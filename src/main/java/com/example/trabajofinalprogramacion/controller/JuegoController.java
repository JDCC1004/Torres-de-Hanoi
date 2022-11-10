package com.example.trabajofinalprogramacion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class JuegoController{


    //private int k = 0;
    private int n;

    private int i = n;

    private int j = 3;

    private int contNumMov = 0;

    private int numMinMov = 0;

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
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void SalirJuego(KeyEvent event){
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }

    public void saveDiscos(ActionEvent event){
        int Objetivo = Integer.parseInt(comboBox.getValue().toString());
        n = (int) (Math.pow(2, Objetivo) -1);
        System.out.println("N° Discos " +comboBox.getValue());
        System.out.println(""+n);
        MovMin.setText("" +n);
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

}
