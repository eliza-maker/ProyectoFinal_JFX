package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Cliente;
import Model.Deposito;
import Model.Retiro;
import Model.Transaccion;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class DepositarController {

    @FXML
    private TextField txtMonto;

    @FXML
    ComboBox<String> comboMetodoDeposito;

    @FXML
    void onDepositar() throws IOException {
        String texto = txtMonto.getText();
        String metodo = comboMetodoDeposito.getValue();

        try {
            double monto = Double.parseDouble(texto);

            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmar deposito");
            alerta.setHeaderText("¿Deseas continuar?");
            alerta.setContentText("Desea generar el deposito a su cuenta por $"+monto);

            ButtonType btnSi = new ButtonType("Sí");
            ButtonType btnNo = new ButtonType("No");

            alerta.getButtonTypes().setAll(btnSi, btnNo);

            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.isPresent() && resultado.get() == btnSi) {

                int puntos = (int) (monto / 100);
                Cliente cliente = MonederoAplication.getCliente();
                Transaccion deposito = new Deposito(UUID.randomUUID().toString(),monto, LocalDate.now(),metodo,0,"123",cliente);

                MonederoAplication.empresa.agregarTransaccion(deposito);
                cliente.setSaldo(cliente.getSaldo()+monto);
                cliente.setPuntosTotales(cliente.getPuntosTotales()+puntos);

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
