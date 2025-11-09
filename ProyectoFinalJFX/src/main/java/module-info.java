module co.edu.uniquindio.co.poo.proyectofinaljfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.co.poo.proyectofinaljfx to javafx.fxml;
    exports co.edu.uniquindio.co.poo.proyectofinaljfx;
}