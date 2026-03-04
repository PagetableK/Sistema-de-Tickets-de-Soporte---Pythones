package com.esen.tickets;

public class Ticket {
    public String descripcion;
    public String prioridad;
    public String estado;

    public Ticket(String descripcion, String prioridad, String estado){
        this.descripcion = descripcion;
        this.prioridad  = prioridad;
        this.estado = estado;
    }
}