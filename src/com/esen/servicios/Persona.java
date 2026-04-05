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

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getCorreo() { return correo;}

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String obtenerDetalles(){
        return "Nombre: " + nombre + " | Correo: " + correo;
    }
}
