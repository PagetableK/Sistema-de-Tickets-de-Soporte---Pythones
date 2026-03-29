package com.esen.servicios;

public class Persona {
    private String nombre;
    private String correo;

    public Persona(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String obtenerDetalles(){
        return "Nombre: " + nombre + " | Correo: " + correo;
    }
}
