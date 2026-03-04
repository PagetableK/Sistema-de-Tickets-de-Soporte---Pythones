package com.esen.tickets;

public class Tecnico extends Persona {

    public String especialidad;

    public Tecnico(String nombre, String correo, String especialidad, String area){
        super(nombre,correo,area);
        this.especialidad = especialidad;
    }
}
