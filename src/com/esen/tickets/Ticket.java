package com.esen.tickets;

public class Ticket {
    public String descripcion;
    public String prioridad;
    public String estado;
    private Tecnico tecnicoAsignado;

    public Ticket(String descripcion, String prioridad, String estado) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = TicketStatus.EN_ESPERA;
        this.tecnicoAsignado = null;
        a
    }
}