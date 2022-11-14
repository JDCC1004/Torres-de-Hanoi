package com.example.trabajofinalprogramacion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UsuarioController {

    @FXML
    private TextField tfNombre;

    @FXML
    protected void teclaPresionada(KeyEvent event) throws IOException {

        if (event.getCode() == KeyCode.ENTER) {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/trabajofinalprogramacion/imgs/Inicio.png")));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/trabajofinalprogramacion/Juego.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Torres de Hanói");
            stage.getIcons().add(image);
            stage.setResizable(false);
            stage.setMaxHeight(300);
            stage.setMaxWidth(300);
            stage.show();

            //ScoreController.llenarTabla(tfNombre);

            Stage stage2 = (Stage) this.tfNombre.getScene().getWindow();
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
