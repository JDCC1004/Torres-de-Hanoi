package com.example.trabajofinalprogramacion.logic;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializacion {

    public Deserializacion() {
        try {

            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("puntaje.txt"));

            while (true){
                Puntaje puntaje = (Puntaje) oi.readObject();
                System.out.println(puntaje.getPuntos());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
