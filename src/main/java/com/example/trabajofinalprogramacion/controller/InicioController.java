package com.example.trabajofinalprogramacion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InicioController {

    public String discos;

    @FXML
    private Button btnStart;
    @FXML
    private Button btnScore;

    @FXML
    protected void OnActionIniciar(ActionEvent event) throws IOException {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/trabajofinalprogramacion/imgs/Inicio.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/trabajofinalprogramacion/Juego.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Torres de Hanói");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

        Stage stage2 = (Stage) this.btnStart.getScene().getWindow();
        stage2.close();
    }

    @FXML
    protected void OnActionScore(ActionEvent event) throws IOException {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/trabajofinalprogramacion/imgs/Inicio.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/trabajofinalprogramacion/Score.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Torres de Hanói");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

        Stage stage2 = (Stage) this.btnScore.getScene().getWindow();
        stage2.close();
    }

    @FXML
    protected void OnActionSalir(){
        System.exit(0);
    }

    @FXML
    protected void teclaSalir(KeyEvent event){
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }

}