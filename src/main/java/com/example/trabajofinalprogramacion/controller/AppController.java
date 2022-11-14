package com.example.trabajofinalprogramacion.controller;

public enum AppController {

    INSTANCE;
    private final ScoreController juego;

    AppController(){
        juego = new ScoreController("Torres de Hanói", 10);
    }

    public ScoreController getJuego(){
        return ScoreController;
    }
}
