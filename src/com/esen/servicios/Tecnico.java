package com.esen.servicios;

public class Tecnico extends Persona {

    private String especialidad;

    public Tecnico() {}

    public Tecnico(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    // Este es el método que te faltaba y causaba el error
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
