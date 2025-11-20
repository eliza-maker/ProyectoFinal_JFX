package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NotificacionController {
    @FXML
    private TextField TxtNumero;

    @FXML
    private Button BtnCancelar;

    @FXML
    private Button BtnEnviar;

    @FXML
    private Label lblRequerirNumero;

    @FXML
    void onNotificar() {
        enviarNotificacion();
    }

    public void enviarNotificacion() {
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
    }

