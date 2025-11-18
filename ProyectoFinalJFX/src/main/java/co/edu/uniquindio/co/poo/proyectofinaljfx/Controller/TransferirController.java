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
            alerta.setContentText("Desea generar la transferencia a la cuenta "+cuentaTransferir+" por $"+monto);


            ButtonType btnSi = new ButtonType("Sí");
            ButtonType btnNo = new ButtonType("No");

            alerta.getButtonTypes().setAll(btnSi, btnNo);

            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.isPresent() && resultado.get() == btnSi) {
                Cliente cliente= MonederoAplication.getCliente();
                Cliente clienteReceptor = MonederoAplication.empresa.getCuenta(cuentaTransferir).getPropietario();
                Transaccion transferencia = new Tranferencia(UUID.randomUUID().toString(),LocalDate.now(),monto,cliente,clienteReceptor);
                MonederoAplication.empresa.agregarTransaccion(transferencia);

                cliente.setSaldo(cliente.getSaldo()-monto);
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
