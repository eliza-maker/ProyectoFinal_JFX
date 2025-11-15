package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class DashboardUserController {

    @FXML
    private Button BtnDepositar;

    @FXML
    private Button BtnRetirar;

    @FXML
    private Button BtnTransferir;

    @FXML
    private Button BtnSMS;

    @FXML
    void onChangeDepositar(ActionEvent event) throws IOException {
        MonederoAplication.changeScene("depositar-view.fxml");
    }

    @FXML
    void onChangeRetirar(ActionEvent event) throws IOException {
        MonederoAplication.changeScene("retirar-view.fxml");
    }

    @FXML
    void onChangeTransferir(ActionEvent event) throws IOException {
        MonederoAplication.changeScene("Transferir-view.fxml");
    }

    @FXML
    void onNotificar(){
        enviarNotificacion();
    }

    public void enviarNotificacion() {
        try {
            String respuesta = MonederoAplication.notificacion.enviarSms(
                    "573011281692",
                    "Tu transacción se realizó correctamente"
            );

            System.out.println("Respuesta Infobip: " + respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
