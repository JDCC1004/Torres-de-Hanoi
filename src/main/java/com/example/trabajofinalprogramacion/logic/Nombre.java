package com.example.trabajofinalprogramacion.logic;

public class Nombre {

    private String nombre;

    public Nombre(){
        this.nombre = ".";
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String retornarNombre() {
        return this.nombre;
    }

    public boolean validarNumerosNombre(String nombre) throws MyExceptions {

        boolean bandera = true;

        for(int x = 0; x < nombre.length(); x++){
            if(nombre.charAt(x) >= 32 && nombre.charAt(x) <= 64){

                throw new MyExceptions ("Caracter no permitido");
            }
            else{
                bandera = false;
            }
        }
        return bandera;

    }

}
