package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Cliente;
import Model.Monedero;
import Model.Retiro;
import Model.Transaccion;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public class RetirarController {

    @FXML
    private TextField txtMonto;

    @FXML
    private ComboBox<String> comboMetodo;

    @FXML
    void onRetirar() throws IOException {

        String texto = txtMonto.getText();
        String metodo = comboMetodo.getValue();
        try {
            double monto = Double.parseDouble(texto);
            int puntos = (int)(monto/100)*2;
            Cliente cliente = MonederoAplication.getCliente();

            if (monto > MonederoAplication.getCliente().getSaldo()){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de saldo");
                alert.setHeaderText("Monto insuficiente");
                alert.setContentText("Su saldo es insuficiente, saldo actual: "+MonederoAplication.getCliente().getSaldo());
                alert.show();
                return;
            }

            if (!cliente.getBeneficio()){
                Alert alerta2 = new Alert(Alert.AlertType.CONFIRMATION);
                alerta2.setTitle("Confirmar Retiro");
                alerta2.setHeaderText("¿Desea realizar el retiro?");
                alerta2.setContentText("Desea realizar el retiro por $"+monto+" con un cargo de $200");


                ButtonType btnSi2 = new ButtonType("Sí");
                ButtonType btnNo2 = new ButtonType("No");

                alerta2.getButtonTypes().setAll(btnSi2, btnNo2);

                Optional<ButtonType> resultado2 = alerta2.showAndWait();

                if (resultado2.isPresent() && resultado2.get() == btnSi2) {
                    cliente.setSaldo(cliente.getSaldo()-200);
                }else{
                    return;
                }
            }

            Transaccion retiro = new Retiro(UUID.randomUUID().toString(),monto, LocalDate.now(),metodo,true,MonederoAplication.getCliente());
            MonederoAplication.empresa.agregarTransaccion(retiro);

            cliente.setSaldo(cliente.getSaldo()-monto);
            cliente.setPuntosTotales(cliente.getPuntosTotales()+puntos);
            MonederoAplication.empresa.actualizarCliente(cliente);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Retiro realizado");
            alert.setHeaderText("Retiro realizado con exito!");
            alert.setContentText("Su saldo se ha actualizado");
            alert.show();

            MonederoAplication.openDashboard();

        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de formato");
            alert.setHeaderText("Monto inválido");
            alert.setContentText("Por favor ingrese un valor numérico válido.");
            alert.show();

        }

        Alert alerta3 = new Alert(Alert.AlertType.CONFIRMATION);
        alerta3.setTitle("Notificacion de transaccion");
        alerta3.setHeaderText("¿Desea ser notificado de su transacción?");
        alerta3.setContentText("La notificacion llegara por SMS");


        ButtonType btnSi2 = new ButtonType("Sí");
        ButtonType btnNo2 = new ButtonType("No");

        alerta3.getButtonTypes().setAll(btnSi2, btnNo2);

        Optional<ButtonType> resultado3 = alerta3.showAndWait();

        if (resultado3.isPresent() && resultado3.get() == btnSi2) {
            MonederoAplication.changeScene("notificacion_view.fxml");
        }
    }

    @FXML
    void onVolver() throws IOException {
        MonederoAplication.openDashboard();
    }

    @FXML
    void initialize(){
    }
}
