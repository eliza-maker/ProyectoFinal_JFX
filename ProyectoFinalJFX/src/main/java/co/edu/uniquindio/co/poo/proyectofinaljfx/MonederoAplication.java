package co.edu.uniquindio.co.poo.proyectofinaljfx;

import Model.NotificacionSMS;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MonederoAplication extends Application {
    private static Stage primaryStage;
    public static NotificacionSMS notificacion;
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
