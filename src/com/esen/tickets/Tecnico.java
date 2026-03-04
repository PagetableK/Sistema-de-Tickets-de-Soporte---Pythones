package com.esen.tickets;

public class Tecnico extends Persona {

    public String especialidad;

    public Tecnico(String nombre, String correo, String especialidad){
        super(nombre,correo);
        this.especialidad = especialidad;
    }
}
