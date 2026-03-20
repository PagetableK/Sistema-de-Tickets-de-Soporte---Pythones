package com.esen.tickets;

public class Ticket {
    private String descripcion;
    private String prioridad;
    private TicketStatus estado;

    public Ticket(String descripcion, String prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = TicketStatus.EN_ESPERA;
    }
    public String getDescripcion() {
        return descripcion;
    }
}