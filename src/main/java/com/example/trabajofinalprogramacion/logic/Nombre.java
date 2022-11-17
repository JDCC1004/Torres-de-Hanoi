package com.example.trabajofinalprogramacion.logic;

public class Nombre {

    private String nombre;

    public Nombre(){
        this.nombre = ".";
    }

    public String setNombre(String nombre){
        this.nombre = nombre;
        return nombre;
    }
    public String getNombre() {
        return nombre;
    }

}
