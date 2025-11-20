module co.edu.uniquindio.co.poo.proyectofinaljfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires okhttp3;
    requires co.edu.uniquindio.co.poo.proyectofinaljfx;

    opens co.edu.uniquindio.co.poo.proyectofinaljfx to javafx.fxml;
    opens Model to javafx.base;
    exports co.edu.uniquindio.co.poo.proyectofinaljfx;
    exports co.edu.uniquindio.co.poo.proyectofinaljfx.Controller;
    opens co.edu.uniquindio.co.poo.proyectofinaljfx.Controller to javafx.fxml;
}