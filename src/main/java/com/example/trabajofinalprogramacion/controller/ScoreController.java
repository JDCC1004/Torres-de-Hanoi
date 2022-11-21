package com.example.trabajofinalprogramacion.controller;

import com.example.trabajofinalprogramacion.logic.Nombre;
import com.example.trabajofinalprogramacion.logic.Puntaje;
import com.example.trabajofinalprogramacion.logic.añadirContenido;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class ScoreController {

    //String puntaje1;

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnJuego;

    @FXML
    private Label lbl1;

    private Nombre nombre = new Nombre();

    public void llenarCampos(String puntos1){
        lbl1.setText(puntos1);
        nombre.setNombre(puntos1);

    }
    public ScoreController(){
        Puntaje puntaje;
        puntaje = new Puntaje(20);

        try{
            ObjectOutputStream op = new ObjectOutputStream(new FileOutputStream("puntaje.txt"));
            op.writeObject(puntaje);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try{
            ObjectOutputStream op = new añadirContenido(new FileOutputStream("puntaje.txt", true));
            op.writeObject(new Puntaje(30));
            op.writeObject(new Puntaje(40));
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }


    @FXML
    protected void OnActionInicio() throws IOException {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/trabajofinalprogramacion/imgs/Inicio.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/trabajofinalprogramacion/PantallaInicio.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Torres de Hanói");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

        Stage stage2 = (Stage) this.btnInicio.getScene().getWindow();
        stage2.close();
    }

    @FXML
    protected void OnActionJuego() throws IOException {

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

        Stage stage2 = (Stage) this.btnJuego.getScene().getWindow();
        stage2.close();
    }

    @FXML
    public void SalirScore(KeyEvent event){
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }

    @FXML
    protected void OnActionSalir(){
        System.exit(0);
    }
}
