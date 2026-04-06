package com.esen.servicios;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketStatus {
    EN_ESPERA("En espera"),
    EN_PROCESO("En proceso"),
    CERRADO("Cerrado");

    private final String etiqueta;

    TicketStatus(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @JsonValue // ✅ usa la etiqueta al GUARDAR en JSON
    @Override
    public String toString() {
        return etiqueta;
    }

    @JsonCreator // ✅ usa la etiqueta al LEER desde JSON
    public static TicketStatus fromString(String valor) {
        for (TicketStatus status : TicketStatus.values()) {
            if (status.etiqueta.equalsIgnoreCase(valor)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Estado desconocido: " + valor);
    }
}