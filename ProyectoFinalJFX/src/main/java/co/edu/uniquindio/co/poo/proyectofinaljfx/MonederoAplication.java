package co.edu.uniquindio.co.poo.proyectofinaljfx;

import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MonederoAplication extends Application {
    private static Stage primaryStage;
    public static Empresa empresa;
    public static NotificacionSMS notificacion;
    public static Cliente cliente;
    public static String monedero;

    @Override
    public void start(Stage stage) throws IOException {
        cargarDatos();
        primaryStage = stage;


        notificacion = new NotificacionSMS(
                "https://e5vdjr.api.infobip.com",
                "1588d65acee321bcfd1068194c53a220-319cb1f1-2af5-49be-ad35-69f3d23cb98f"
        );

        openLogin();
    }

    public static void openLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MonederoAplication.class.getResource("Inicio-sesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Iniciar sesion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void openDashboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MonederoAplication.class.getResource("DashboardUser_View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void changeScene(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(MonederoAplication.class.getResource(fxml));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void cargarDatos(){
        this.empresa = new Empresa("Bancolombia");
        Cliente c = new Cliente("1", "Isa","isa@gmail.com", RangoCliente.BRONCE, 50000,"123");
        Cliente c2 = new Cliente("2", "Eliza","Eliza@gmail.com", RangoCliente.BRONCE, 20000,"123");
        Cuenta cuenta1 = new Cuenta("1010",c);
        Cuenta cuenta2 = new Cuenta("2020",c2);
        Monedero monedero1 = new MonederoAhorro("1",2000);
        Monedero monedero2 = new MonederoAhorro("2",5000);
        Monedero monedero3 = new MonederoAhorro("1",200);
        Monedero monedero4 = new MonederoAhorro("2",5000);
        cuenta1.agregarMonedero(monedero1);
        cuenta1.agregarMonedero(monedero2);
        cuenta2.agregarMonedero(monedero3);
        cuenta2.agregarMonedero(monedero4);
        empresa.agregarCliente(c);
        empresa.agregarCliente(c2);
        empresa.agregarCuenta(cuenta1);
        empresa.agregarCuenta(cuenta2);
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        MonederoAplication.cliente = cliente;
    }

    public static String getMonedero() {
        return monedero;
    }

    public static void setMonedero(String monedero) {
        MonederoAplication.monedero = monedero;
    }
}
