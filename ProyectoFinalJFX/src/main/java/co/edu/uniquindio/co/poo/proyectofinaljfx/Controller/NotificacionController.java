package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Notificable;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NotificacionController implements Notificable {

    @FXML
    private TextField TxtNumero;

    @FXML
    private Button BtnCancelar;

    @FXML
    private Button BtnEnviar;

    @FXML
    private Label lblRequerirNumero;


    public void onEnviarNotificacion() {
        try {
            String numero = TxtNumero.getText();

            if (numero == null || numero.isBlank()) {
                throw new IllegalArgumentException("Numero Invalido");
            }

            String respuesta = MonederoAplication.notificacion.enviarSms(numero, "Tu transacción se realizó correctamente");
            }
        catch (Exception e) {
            e.printStackTrace();
        }
        }

    @FXML
    void onCancelar() throws IOException {
        MonederoAplication.changeScene("DashBoardUser_View.fxml");
    }
    }

