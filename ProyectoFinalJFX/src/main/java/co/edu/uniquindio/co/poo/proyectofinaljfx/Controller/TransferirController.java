package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Cliente;
import Model.Deposito;
import Model.Tranferencia;
import Model.Transaccion;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class TransferirController {

    @FXML
    private TextField txtMonto;

    @FXML
    private TextField txtCuentaDestino;

    @FXML
    void onTransferir() throws IOException {
        String texto = txtMonto.getText();


        try {
            double monto = Double.parseDouble(texto);
            String cuentaTransferir = txtCuentaDestino.getText();
            double comision = 500;
            int puntos = (int)(monto/100)*3;

            if(MonederoAplication.empresa.getCuenta(cuentaTransferir) == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en la cuenta");
                alert.setHeaderText("Cuenta no encontrada");
                alert.setContentText("Por favor verifique el numero de la cuenta a transferir.");
                alert.show();
                return;
            }



            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmar transferencia");
            alerta.setHeaderText("¿Deseas continuar?");
            alerta.setContentText("Desea generar la transferencia a la cuenta "+cuentaTransferir+" por $"+monto+" Se cobrara por la transaccion $"+comision);


            ButtonType btnSi = new ButtonType("Sí");
            ButtonType btnNo = new ButtonType("No");

            alerta.getButtonTypes().setAll(btnSi, btnNo);

            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.isPresent() && resultado.get() == btnSi) {
                Cliente cliente= MonederoAplication.getCliente();
                if(monto+comision > cliente.getSaldo()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error de saldo");
                    alert.setHeaderText("Monto insuficiente");
                    alert.setContentText("Su saldo es insuficiente, saldo actual: "+cliente.getSaldo());
                    alert.show();
                    return;
                }

                if(cliente.getPuntosTotales() >= 100){
                    Alert alerta2 = new Alert(Alert.AlertType.CONFIRMATION);
                    alerta2.setTitle("Confirmar Consumo de puntos");
                    alerta2.setHeaderText("¿Desea consumir?");
                    alerta2.setContentText("Desea consumir 100 puntos y generar un 10% de descuento en la comision ");


                    ButtonType btnSi2 = new ButtonType("Sí");
                    ButtonType btnNo2 = new ButtonType("No");

                    alerta2.getButtonTypes().setAll(btnSi2, btnNo2);

                    Optional<ButtonType> resultado2 = alerta2.showAndWait();

                    if (resultado2.isPresent() && resultado2.get() == btnSi2) {
                        comision = comision - comision*0.10;
                        cliente.setPuntosTotales(cliente.getPuntosTotales()-100);
                    }
                }

                Cliente clienteReceptor = MonederoAplication.empresa.getCuenta(cuentaTransferir).getPropietario();
                Transaccion transferencia = new Tranferencia(UUID.randomUUID().toString(),LocalDate.now(),monto,cliente,clienteReceptor);
                MonederoAplication.empresa.agregarTransaccion(transferencia);

                cliente.setSaldo(cliente.getSaldo()-(monto+comision));
                cliente.setPuntosTotales(cliente.getPuntosTotales()+puntos);
                clienteReceptor.setSaldo(clienteReceptor.getSaldo()+monto);

                MonederoAplication.empresa.actualizarCliente(cliente);
                MonederoAplication.empresa.actualizarCliente(clienteReceptor);

                MonederoAplication.openDashboard();
            }

        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de formato");
            alert.setHeaderText("Monto inválido");
            alert.setContentText("Por favor ingrese un valor numérico válido.");
            alert.show();

        }
    }

    @FXML
    void onCancelar() throws IOException {
        MonederoAplication.openDashboard();
    }

    @FXML
    void initialize(){}
}
