package com.example.trabajofinalprogramacion.controller;

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

    private String tfNombre1;

    @FXML
    private Label aviso;
    @FXML
    private TextField tfNombre;
    @FXML
    private Button btnJugar;
    public ScoreController controller;

    @FXML
     void OnActionJugar(ActionEvent event) throws IOException {
        if (tfNombre.getText().isEmpty()) {
            aviso.setVisible(true);
        } else {

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/trabajofinalprogramacion/imgs/Inicio.png")));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/trabajofinalprogramacion/Juego.fxml"));
            Parent root = fxmlLoader.load();
            //ScoreController controller = fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Torres de Hanói");
            stage.getIcons().add(image);
            stage.setResizable(false);
            stage.show();

            tfNombre1 = tfNombre.getText();
            System.out.println("Bienvenido " +tfNombre1);

            controller.llenarCampos(tfNombre1);

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
