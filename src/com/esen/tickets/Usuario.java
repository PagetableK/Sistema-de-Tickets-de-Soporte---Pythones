package com.esen.tickets;

public class Usuario extends Persona {
    public String area;

    public Usuario(String nombre, String correo, String area){
        super(nombre, correo);
        this.area = area;
    }
}
