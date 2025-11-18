package co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;

import Model.Transaccion;
import co.edu.uniquindio.co.poo.proyectofinaljfx.MonederoAplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class HistorialController {

    @FXML
    private TableView<Transaccion> tablaHistorial;

    @FXML
    private TableColumn<Transaccion,String> colTipo;

    @FXML
    private TableColumn<Transaccion,String> colMonto;

    @FXML
    private TableColumn<Transaccion,String> colFecha;

    @FXML
    private TableColumn<Transaccion,String> colDetalle;

    @FXML
    void onCerrarSesion() throws IOException {
        MonederoAplication.openDashboard();
    }

    @FXML
    void initialize()throws IOException {

        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        colTipo.setCellValueFactory(cellData -> {
            Transaccion t = cellData.getValue();

            if (t instanceof Model.Retiro) {
                return new javafx.beans.property.SimpleStringProperty("Retiro");
            } else if (t instanceof Model.Deposito) {
                return new javafx.beans.property.SimpleStringProperty("Depósito");
            } else if (t instanceof Model.Tranferencia) {
                return new javafx.beans.property.SimpleStringProperty("Transferencia");
            } else {
                return new javafx.beans.property.SimpleStringProperty("Desconocido");
            }
        });

        tablaHistorial.setItems(FXCollections.observableList(MonederoAplication.empresa.getListaTransacciones()));

    }

}
