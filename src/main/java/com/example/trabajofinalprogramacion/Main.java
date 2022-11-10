package com.example.trabajofinalprogramacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        /** Pantalla de Inicio **/

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/trabajofinalprogramacion/imgs/Inicio.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PantallaInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Torres de Hannoi");
        stage.setScene(scene);
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}