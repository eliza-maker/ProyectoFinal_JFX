package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Cliente;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class BeneficiosController {

    @FXML
    private ComboBox<String> comboBeneficios;

    @FXML
    private Label lblCostoPuntos;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    void onCanjear() throws IOException {
        String beneficio = comboBeneficios.getValue();
        Cliente cliente = MonederoAplication.getCliente();
        if(beneficio.equals("Mes sin recargos")){
            if (cliente.getPuntosTotales() >= 500){
                cliente.setPuntosTotales(cliente.getPuntosTotales()-500);
                cliente.setBeneficio(true);
                MonederoAplication.empresa.actualizarCliente(cliente);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de puntos");
                alert.setHeaderText("Monto de puntosinsuficiente");
                alert.setContentText("Sus puntos totales son insuficientes, puntos actuales: "+cliente.getPuntosTotales());
                alert.show();
                return;
            }
        }
        if(beneficio.equals("Bono de saldo $50")){
            if (cliente.getPuntosTotales() >= 1000){
                cliente.setPuntosTotales(cliente.getPuntosTotales()-1000);
                cliente.setSaldo(cliente.getSaldo()+50);
                MonederoAplication.empresa.actualizarCliente(cliente);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de puntos");
                alert.setHeaderText("Monto de puntosinsuficiente");
                alert.setContentText("Sus puntos totales son insuficientes, puntos actuales: "+cliente.getPuntosTotales());
                alert.show();
                return;
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tramite exitoso!");
        alert.setHeaderText("Beneficio recargado");
        alert.setContentText("Se ha canjeado el beneficio con exito.");
        alert.show();
        MonederoAplication.openDashboard();
    }

    @FXML
    void onVolver() throws IOException {
        MonederoAplication.openDashboard();
    }

    @FXML
    void initialize() {
        comboBeneficios.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue) {
                    case "Mes sin recargos":
                        lblCostoPuntos.setText("500 puntos");
                        txtDescripcion.setText("Se generara un mes a partir de hoy un mes sin recargos por los retiros que se realice");
                        break;

                    case "Bono de saldo $50":
                        lblCostoPuntos.setText("1000 puntos");
                        txtDescripcion.setText("Se generara un bono de que se su,ara en su saldo por $50");
                        break;
                }
            }
        });
    }

}
