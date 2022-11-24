package com.example.trabajofinalprogramacion.controller;

import com.example.trabajofinalprogramacion.logic.Nombre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class JuegoController{

    private static int n;

    private int puntuacion = 500;

    private int puntuacionFinal;

    private static int contNumMov = 0;

    private int numMinMov = 0;

    private int Objetivo = 0;

    private int puntos;

    int[] Arreglo = {1,2,3,4,5,6,7};

    private Nombre nombre = new Nombre();

    @FXML
    private Button btnTerminar;

    @FXML
    private Button btnReiniciar;

    @FXML
    private VBox v1, v2, v3;

    @FXML
    private Label MovMin, Mov, Score, nom;

    @FXML
    private ComboBox<Integer> comboBox;

    public void initialize(){
        comboBox.getItems().addAll(3,4,5,6,7,8,9,10);
        comboBox.setValue(0);
        comboBox.setEditable(false);
    }

    public void llenarNombre(String nom1){
        nom.setText(nom1);
        nombre.setNombre(nom1);
    }

    boolean discoTomado = false;
    @FXML
    void onPressedVbox(MouseEvent event) {
        VBox v = (VBox) event.getSource();
        String idV = v.getId();
        System.out.println(idV);
        if (!discoTomado){
            cogerDisco(idV);
        }else {
            ponerDisco(idV);
        }
    }
    String auxLabel = "";
    void cogerDisco (String identificador) {
        if (identificador == v1.getId() && v1.getChildren().size() != 0){
            Label aux = (Label) v1.getChildren().get(0);
            auxLabel = aux.getText();
            v1.getChildren().remove(0);
            discoTomado = true;
        } else if (identificador == v2.getId() && v2.getChildren().size() != 0) {
            Label aux = (Label) v2.getChildren().get(0);
            auxLabel = aux.getText();
            v2.getChildren().remove(0);
            discoTomado = true;
        } else if (identificador == v3.getId() && v3.getChildren().size() != 0) {
            Label aux = (Label) v3.getChildren().get(0);
            auxLabel = aux.getText();
            v3.getChildren().remove(0);
            discoTomado = true;
        }
    }
    void ponerDisco(String identificador){
        if (discoTomado){
            Label label = new Label();
            label.setText(auxLabel);
            switch (identificador){
                case "v1":
                    validarDisco(v1, label);
                    contNumMov ++;
                    puntuacion = puntuacion + 50;
                    break;
                case "v2":
                    validarDisco(v2, label);
                    contNumMov ++;
                    puntuacion = puntuacion + 50;

                    break;
                case "v3":
                    validarDisco(v3, label);
                    contNumMov ++;
                    puntuacion = puntuacion + 50;

                    break;
                default:
                    System.out.println(".");
                    break;
            }
        }
    }

    void validarDisco (VBox vh, Label l) {
        if (vh.getChildren().size() == 0){
            vh.getChildren().add(l);
            discoTomado = false;
        }
        else {
            Label label = (Label) vh.getChildren().get(0);
            String s = label.getText();
            if (auxLabel.length() < s.length()){
                vh.getChildren().add(0, l);
                discoTomado = false;
            }
        }
    }

    public void generarTablas(int [] Label, int i) {

        /**for (int k = 0; k < comboBox.getValue(); k++) {
            Label label = new Label();
            String x = "";
            for (int l = 0; l < k+1; l++) {
                x = x + "*";
            }
            label.setText(x);
            label.setStyle("-fx-font-size: 15");
            v1.getChildren().add(label);**/

        if(i != comboBox.getValue()){
            generarTablas(Label, i + 1);
            Label label = new Label();
            String x = "";
            for (int l = 0; l < i+1; l++){
                x = x + "*";
            }
            label.setText(x);
            label.setStyle("-fx-font-size: 15");
            v1.getChildren().add(label);
        }
    }

    public void determinarGano(int [] Arreglo, int i){
        if(i != Arreglo.length){
            System.out.println(Arreglo[i]);
            determinarGano(Arreglo, i+1);
        }
    }
    @FXML
    protected void OnActionResolver(){
        for (int k = 0; k < comboBox.getValue(); k++) {
            Label label = new Label();
            String x = "";
            for (int l = 0; l < k+1; l++) {
                x = x + "*";
            }
            label.setText(x);
            label.setStyle("-fx-font-size: 15");
            v1.getChildren().clear();
            v3.getChildren().add(label);
        }
    }

    @FXML
    protected void OnActionReiniciar(){
        try{
            if(!Mov.getText().equals("")){
                comboBox.setValue(0);
                MovMin.setText("0");
                contNumMov = 0;
                Mov.setText("0");
                Score.setText("" +puntuacionFinal);
                v1.getChildren().clear();
                v2.getChildren().clear();
                v3.getChildren().clear();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDiscos(ActionEvent event){
        Objetivo = Integer.parseInt(comboBox.getValue().toString());
        n = (int) (Math.pow(2, Objetivo) -1);
        System.out.println("N° Discos " +comboBox.getValue());
        System.out.println(""+n);
        MovMin.setText("" +n);
        Score.setText("" +puntuacion);
        int[] Label = new int[comboBox.getValue()];
        int i = 1;
        generarTablas(Label, 1-i);
        //recorrerArreglo(Arreglo, 1);
    }

    public void v1Event(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            contNumMov++;
            puntuacion = puntuacion + 50;
            if(contNumMov == numMinMov){
                puntuacion = puntuacion * 2;
            }
        }
        Mov.setText("" +contNumMov);
        Score.setText("" +puntuacion);
    }

    public void v2Event(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            contNumMov++;
            puntuacion = puntuacion + 50;
            if(contNumMov == numMinMov){
                puntuacion = puntuacion * 2;
            }
        }
        Mov.setText("" +contNumMov);
        Score.setText("" +puntuacion);

    }

    public void v3Event(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            contNumMov++;
            puntuacion = puntuacion + 50;
            if(contNumMov == numMinMov){
                puntuacion = puntuacion * 2;
                System.out.println(puntuacion);
            }
        }
        Mov.setText("" +contNumMov);
        Score.setText("" +puntuacion);
    }

    public void Puntaje(){
        if(contNumMov == n){
            puntuacionFinal = puntuacion * 5;
        } else if (contNumMov == n+5) {
            puntuacionFinal = puntuacion * 4;
        } else if (contNumMov == n+10) {
            puntuacionFinal = puntuacion * 3;
        } else if (contNumMov == n+15) {
            puntuacionFinal = puntuacion * 2;
        } else if (contNumMov == n+20) {
            puntuacionFinal = puntuacion * 1;
        }
        /**switch (puntuacion){
            case 0:
                if(contNumMov == n){
                    puntuacionFinal = puntuacion * 5;
                    System.out.println(puntuacionFinal);
                }
                break;
            case 1:
                if(contNumMov == n+5){
                    puntuacionFinal = puntuacion * 4;
                    System.out.println(puntuacionFinal);
                }
                break;
            case 2:
                if(contNumMov == n+10){
                    puntuacionFinal = puntuacion * 3;
                    System.out.println(puntuacionFinal);
                }
                break;
            case 3:
                if(contNumMov == n+15){
                    puntuacionFinal = puntuacion * 2;
                    System.out.println(puntuacionFinal);
                }
                break;
            case 4:
                if(contNumMov == n+20){
                    puntuacionFinal = puntuacion;
                    System.out.println(puntuacionFinal);
                }
                break;
            default:
                System.out.println(".");
                break;
        }**/
    }

    public void OnActionTerminar(ActionEvent event) throws IOException {
        if(v3.getChildren().size() == comboBox.getValue()){

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/trabajofinalprogramacion/imgs/Inicio.png")));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/trabajofinalprogramacion/Score.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            ScoreController scoreControl = fxmlLoader.getController();
            stage.setTitle("Torres de Hanói");
            stage.getIcons().add(image);
            stage.setResizable(false);
            stage.show();

            puntos = Integer.parseInt(Score.getText());
            System.out.println(puntos);

            scoreControl.llenarCampos(String.valueOf(puntos));

            Stage stage2 = (Stage) this.btnTerminar.getScene().getWindow();
            stage2.close();
        }
    }


    @FXML
    public void SalirJuego(KeyEvent event){
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }
}
