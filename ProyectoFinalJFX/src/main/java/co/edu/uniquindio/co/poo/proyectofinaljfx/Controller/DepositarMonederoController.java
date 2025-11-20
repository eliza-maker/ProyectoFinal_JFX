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

public class DepositarMonederoController {
    @FXML
    private TextField txtMonto;

    @FXML
    ComboBox<String> comboMetodoDeposito;

    @FXML
    void onDepositar() throws IOException {
        String texto = txtMonto.getText();
        String tipoMonedero = comboMetodoDeposito.getValue();

        try {
            double monto = Double.parseDouble(texto);

            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmar deposito");
            alerta.setHeaderText("¿Deseas continuar?");
            alerta.setContentText("Desea generar el deposito a su "+tipoMonedero);

            ButtonType btnSi = new ButtonType("Sí");
            ButtonType btnNo = new ButtonType("No");

            alerta.getButtonTypes().setAll(btnSi, btnNo);

            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.isPresent() && resultado.get() == btnSi) {
                Cliente cliente = MonederoAplication.getCliente();

                if (cliente.getSaldo() < monto) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error de saldo");
                    alert.setHeaderText("Monto insuficiente");
                    alert.setContentText("Su saldo es insuficiente, saldo actual: "+cliente.getSaldo());
                    alert.show();
                    return;
                }

                Cuenta cuenta=MonederoAplication.empresa.getCuentaUser(MonederoAplication.getCliente());
                Monedero monedero;
                if (tipoMonedero.equals("Monedero Ahorro")) {
                    monedero = cuenta.getMoneder("1");
                }else {
                    monedero = cuenta.getMoneder("2");
                }

                monedero.setSaldo(monedero.getSaldo()+monto);
                cuenta.actualizarMonedero(monedero);
                MonederoAplication.empresa.agregarCuenta(cuenta);

                cliente.setSaldo(cliente.getSaldo()-monto);
                MonederoAplication.empresa.actualizarCliente(cliente);

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
    void onVolver() throws IOException {
        MonederoAplication.openDashboard();
    }

    @FXML
    void initialize(){}

}
