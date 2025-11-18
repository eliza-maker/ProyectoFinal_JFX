package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Label TxtSaldo;

    @FXML
    private Label TxtRango;

    @FXML
    private Label TxtPuntos;

    @FXML
    private Label TxtNombreUsuario;

    @FXML
    private Button BtnIformacionCuenta;

    @FXML
    private Button BtnHistorial;

    @FXML
    void onChangeCuenta(ActionEvent event) throws IOException{
        MonederoAplication.changeScene("informacionCuenta-view.fxml");
    }

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

    @FXML
    void onHistorial()throws IOException{
        MonederoAplication.changeScene("historial-view.fxml");
    }

    @FXML
    void onBeneficios() throws IOException{
        MonederoAplication.changeScene("Beneficios-view.fxml");
    }

    @FXML
    void onCerrarSesion() throws  IOException {
        MonederoAplication.setCliente(null);
        MonederoAplication.openLogin();
    }

    @FXML
    void initialize(){
        cambiarSaldo();
    }

    void cambiarSaldo(){
        TxtSaldo.setText(MonederoAplication.getCliente().getSaldo()+"");
        TxtRango.setText(MonederoAplication.getCliente().getRango()+"");
        TxtPuntos.setText(MonederoAplication.getCliente().getPuntosTotales()+"");
        TxtNombreUsuario.setText(MonederoAplication.getCliente().getNombre());
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
