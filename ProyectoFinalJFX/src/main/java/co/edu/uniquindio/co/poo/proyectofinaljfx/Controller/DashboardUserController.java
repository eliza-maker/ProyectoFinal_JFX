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
    void onChangeDepositar(ActionEvent event) {

    }

    @FXML
    void onChangeRetirar(ActionEvent event) throws IOException {
        MonederoAplication.changeScene("retirar-view.fxml");
    }

    @FXML
    void onChangeTransferir(ActionEvent event) {

    }

}
