package com.example.trabajofinalprogramacion.controller;

import com.example.trabajofinalprogramacion.logic.MyExceptions;
import com.example.trabajofinalprogramacion.logic.Nombre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UsuarioController {

    Nombre nombre = new Nombre();

    @FXML
    private Label aviso;
    @FXML
    private TextField tfNombre;
    @FXML
    private Button btnJugar;

    @FXML
    void saveNombre(ActionEvent event) {

            try {
                nombre.setNombre((tfNombre.getText()));
                nombre.validarNumerosNombre(tfNombre.getText());
            } catch (MyExceptions ex) {
                aviso.setText(ex.getMessage());
            }
            btnJugar.requestFocus();
            tfNombre.clear();
    }

    @FXML
     void OnActionJugar(ActionEvent event) throws IOException{

        if(tfNombre.getText().isBlank()){
            aviso.setText("¡¡ Debe ingresar un nombre !!");
            tfNombre.requestFocus();
        }else {

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/trabajofinalprogramacion/imgs/Inicio.png")));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/trabajofinalprogramacion/Juego.fxml"));
            Parent root;
            root = fxmlLoader.load();
            JuegoController juegoControl = fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Torres de Hanói");
            stage.getIcons().add(image);
            stage.setResizable(false);
            stage.show();

            //nombre = tfNombre.getText();
            //System.out.println("Bienvenido " +nombre);

            juegoControl.llenarNombre(tfNombre.getText());

            Stage stage2 = (Stage) this.btnJugar.getScene().getWindow();
            stage2.close();
        }
    }

    @FXML
    public void SalirUsuario(KeyEvent event){
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }
}
