package com.esen.servicios;

public class Ticket {
    private String descripcion;
    private String prioridad;
    private TicketStatus estado;

    /*public Ticket(String descripcion, String prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = TicketStatus.EN_ESPERA;
    }*/
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public TicketStatus getEstado() {
        return estado;
    }
    public void setEstado(TicketStatus estado) {
        this.estado = estado;
    }
}