package com.example.trabajofinalprogramacion.controller;

import com.example.trabajofinalprogramacion.logic.Nombre;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ScoreController {

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnJuego;

    @FXML
    private static Label lblNombre;

    private Nombre nombre = new Nombre();

    @FXML
    private TableView<ScoreController> tablaContenido;

    @FXML
    private TableColumn<ScoreController, String> colNumero;

    @FXML
    private TableColumn<ScoreController, String> colNombre;

    @FXML
    private TableColumn<ScoreController, String> colScore;

    private ScoreController scoreNuevo;
    private String getNombre;

    @FXML
    public void initialize(){
        colNumero.setCellValueFactory(new PropertyValueFactory<>("Número"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colScore.setCellValueFactory(new PropertyValueFactory<>("Score"));
        tablaContenido.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> llenarCampos(newValue.getNombre));
    }

    public void llenarCampos(String Nombre){
        lblNombre.setText(Nombre);
        nombre.setNombre(Nombre);
        //scoreNuevo = scorecontroller;
        //if(scorecontroller != null){
            //tfNombre.setText(scorecontroller.getNombre);
        //}
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
