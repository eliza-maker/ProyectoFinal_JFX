package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Monedero;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MonederoPagosController {
    @FXML
    private Label lblSaldo;

    @FXML
    void onVolver() throws IOException {
        MonederoAplication.openDashboard();
    }

    @FXML
    void onRetirar()throws IOException{
        MonederoAplication.setMonedero("pago");
        MonederoAplication.changeScene("Retirar-monedero.fxml");
    }

    @FXML
    void initialize() {
        lblSaldo.setText(""+ MonederoAplication.empresa.getCuentaUser(MonederoAplication.getCliente()).getMoneder("2").getSaldo());
    }
}
