package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Cliente;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtContrasena;

    @FXML
    void initialize(){

    }

    @FXML
    void onLogin() throws IOException {
        String documento = txtDocumento.getText();
        String contrasena = txtContrasena.getText();

        Cliente resp =MonederoAplication.empresa.login(documento, contrasena);

        if (resp != null){
            MonederoAplication.setCliente(resp);
            MonederoAplication.openDashboard();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Datos invalidos");
        alert.setContentText("El usuario o contraseña son incorectos.");
        alert.showAndWait();
    }
}
