package com.example.trabajofinalprogramacion.logic;

import java.io.Serializable;

public class Puntaje implements Serializable {

    public int puntos;

    public Puntaje(int puntos){
        this.puntos = puntos;
    }

    public int getPuntos(){
        return puntos;
    }
}
