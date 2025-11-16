package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DepositarController {

    @FXML
    private TextField TxtFieldDeposito;

    @FXML
    private Button BtnDepositar;

    double obtenerMonto(){
        return Double.parseDouble(TxtFieldDeposito.getText());
    }

    void hacerDeposito(){

    }

}
