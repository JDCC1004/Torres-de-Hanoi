package com.example.trabajofinalprogramacion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class JuegoController{


    //private int k = 0;
    private int n;

    private int puntuacion = 500;

    private int puntuacionFinal;

    private int i = n;

    private int j = 3;

    private int contNumMov = 0;

    private int numMinMov = 0;

    @FXML
    private Button btnPuntuacion;
    @FXML
    private ImageView id00;
    @FXML
    private ImageView id20;
    @FXML
    private ImageView id10;
    @FXML
    private ImageView id01;
    @FXML
    private ImageView id11;
    @FXML
    private ImageView id21;
    @FXML
    private ImageView id02;
    @FXML
    private ImageView id12;
    @FXML
    private ImageView id22;

    @FXML
    private Label MovMin;

    @FXML
    private Label Mov;

    @FXML
    private Label Score;

    @FXML
    private ComboBox<Integer> comboBox;

    @FXML
    private GridPane torresGrid;

    public void initialize(){
        comboBox.getItems().addAll(3,4,5,6,7,8,9,10);
        comboBox.setValue(0);
        comboBox.setEditable(false);
    }

    /**public void generarTablas() {

        for (int i = 0, i < comboBox.getValue(); i++){
            lbl[i] = new Label(" Label 1 " +(i+1));
        }
    }**/

    @FXML
    protected void OnActionResolver(){
    }

    @FXML
    protected void OnActionReiniciar(){
        try{
            if(!Mov.getText().equals("")){
                comboBox.setValue(0);
                MovMin.setText("0");
                contNumMov = 0;
                Mov.setText("0");
                puntuacionFinal = puntuacion * 5;
                System.out.println(puntuacionFinal);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDiscos(ActionEvent event){
        int Objetivo = Integer.parseInt(comboBox.getValue().toString());
        n = (int) (Math.pow(2, Objetivo) -1);
        System.out.println("N° Discos " +comboBox.getValue());
        System.out.println(""+n);
        MovMin.setText("" +n);
        Score.setText("" +puntuacion);
    }

    public void Puntaje(){
        switch (puntuacion){
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
                if(contNumMov == n+10){
                    puntuacionFinal = puntuacion * 2;
                    System.out.println(puntuacionFinal);
                }
                break;
            case 4:
                if(contNumMov == n+15){
                    puntuacionFinal = puntuacion;
                    System.out.println(puntuacionFinal);
                }
                break;
        }
    }

    public void iv00() {
        id00.setVisible(false);
        id22.setVisible(true);
    }

    public void iv20(MouseEvent mouseEvent) {

    }

    public void iv10(MouseEvent mouseEvent) {

    }

    public void iv01(MouseEvent mouseEvent) {
        id01.setVisible(false);
        id12.setVisible(true);
        //contNumMov++;
    }

    public void iv11(MouseEvent mouseEvent) {

    }

    public void iv21(MouseEvent mouseEvent) {

    }

    public void iv02(MouseEvent mouseEvent) {
        id02.setVisible(false);
        id22.setVisible(true);
        //contNumMov++;
    }

    public void iv12(MouseEvent mouseEvent) {

    }

    public void iv22(MouseEvent mouseEvent) {
        id22.setVisible(false);
        id11.setVisible(true);
        //contNumMov++;
    }

    public void gridPaneEvent(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            contNumMov++;
        }

        Mov.setText("" +contNumMov);
    }

    /**
     * public void llenarGridPane () {
     * GridPane[][] torresGrid = new GridPane[i][j];
     * for (i = 0; i < torresGrid.length; i++) {
     * for (j = 0; j < torresGrid.length; j++) {
     * GridPane[][] GridPane = new GridPane[0][];
     * torresGrid[i] = GridPane[i][j];
     * }
     * }
     * }
     *
     * @return
     **/

    public static GridPane llenarGridPane(int rows) {
        GridPane torresGrid = new GridPane();

        //rows = Integer.parseInt(comboBox.getValue().toString());

        for (int i = 0; i < rows; i++) {
                TextField textField = new TextField();
                textField.setAlignment(Pos.CENTER);

                torresGrid.add(textField, 0, i);

                GridPane.setMargin(textField, new Insets(5));
                textField.setText("Prueba 1");

            }
            torresGrid.setAlignment(Pos.CENTER);

            return torresGrid;

            /**filas = Integer.parseInt(comboBox.getValue().toString());
             col = 3;

             GridPane = new int[filas][col];

             GridPane.setColumnIndex(String.valueOf(comboBox.getValue()));**/
        }

    @FXML
    protected void OnActionPuntuacion(ActionEvent event) throws IOException {

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

        Stage stage2 = (Stage) this.btnPuntuacion.getScene().getWindow();
        stage2.close();
    }

    @FXML
    public void SalirJuego(KeyEvent event){
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }

}
