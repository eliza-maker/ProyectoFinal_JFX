package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.*;
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

public class RetirarMonederoController {
    @FXML
    private TextField txtMonto;

    @FXML
    void onRetirar() throws IOException {

        String texto = txtMonto.getText();

        try {
            double monto = Double.parseDouble(texto);
            Monedero monedero;

            Cliente cliente = MonederoAplication.getCliente();
            Cuenta cuenta =MonederoAplication.empresa.getCuentaUser(cliente);

            if (MonederoAplication.getMonedero().equals("pago")){
                monedero = MonederoAplication.empresa.getCuentaUser(MonederoAplication.getCliente()).getMoneder("2");
            }else{
                monedero =MonederoAplication.empresa.getCuentaUser(MonederoAplication.getCliente()).getMoneder("1");
            }


            if (monto > monedero.getSaldo()){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de saldo");
                alert.setHeaderText("Monto insuficiente");
                alert.setContentText("Su saldo es insuficiente, saldo actual del monedero: "+monedero.getSaldo());
                alert.show();
                return;
            }

            monedero.setSaldo(monto-monedero.getSaldo());
            cuenta.actualizarMonedero(monedero);
            cliente.setSaldo(cliente.getSaldo()+monto);

            MonederoAplication.empresa.actualizarCliente(cliente);
            MonederoAplication.setMonedero(null);

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
