package com.esen.tickets;

public class Usuario extends Persona {
    public String area;
    public String rol;

    public Usuario(String nombre, String correo, String area, String rol){
        super(nombre, correo);
        this.area = area;
        this.rol = rol;
    }
}
