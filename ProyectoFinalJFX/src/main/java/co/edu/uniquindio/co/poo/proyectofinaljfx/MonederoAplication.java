package co.edu.uniquindio.co.poo.proyectofinaljfx;

import Model.Cliente;
import Model.NotificacionSMS;
import Model.RangoCliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MonederoAplication extends Application {
    private static Stage primaryStage;
    public static List<Cliente> listaClientes = new LinkedList<>();
    public static NotificacionSMS notificacion;

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void setListaClientes(List<Cliente> listaClientes) {
        MonederoAplication.listaClientes = listaClientes;
    }

    public MonederoAplication() {
        this.listaClientes = getListaClientes();
    }

    Cliente c = new Cliente("1", "Isa","isa@gmail.com", RangoCliente.BRONCE, 20000);

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        notificacion = new NotificacionSMS(
                "https://e5vdjr.api.infobip.com",
                "1588d65acee321bcfd1068194c53a220-319cb1f1-2af5-49be-ad35-69f3d23cb98f"
        );

        FXMLLoader fxmlLoader = new FXMLLoader(MonederoAplication.class.getResource("DashboardUser_View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void changeScene(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(MonederoAplication.class.getResource(fxml));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
