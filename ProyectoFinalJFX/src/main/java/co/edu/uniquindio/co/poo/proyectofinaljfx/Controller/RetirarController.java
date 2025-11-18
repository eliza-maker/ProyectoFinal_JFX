package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Cliente;
import Model.Monedero;
import Model.Retiro;
import Model.Transaccion;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
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

            if (monto > MonederoAplication.getCliente().getSaldo()){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de saldo");
                alert.setHeaderText("Monto insuficiente");
                alert.setContentText("Su saldo es insuficiente, saldo actual: "+MonederoAplication.getCliente().getSaldo());
                alert.show();
                return;
            }

            Transaccion retiro = new Retiro(UUID.randomUUID().toString(),monto, LocalDate.now(),metodo,true,MonederoAplication.getCliente());
            MonederoAplication.empresa.agregarTransaccion(retiro);
            Cliente cliente = MonederoAplication.getCliente();
            cliente.setSaldo(cliente.getSaldo()-monto);
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
    }


    @FXML
    void onVolver() throws IOException {
        MonederoAplication.openDashboard();
    }

    @FXML
    void initialize(){
    }
}
