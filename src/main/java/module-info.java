module com.example.trabajofinalprogramacion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabajofinalprogramacion to javafx.fxml;
    exports com.example.trabajofinalprogramacion;
}