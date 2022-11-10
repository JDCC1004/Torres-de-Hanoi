module com.example.trabajofinalprogramacion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabajofinalprogramacion to javafx.fxml;
    exports com.example.trabajofinalprogramacion;
    exports com.example.trabajofinalprogramacion.controller;
    opens com.example.trabajofinalprogramacion.controller to javafx.fxml;
}