package com.esen.modelo;

import com.esen.servicios.Tecnico;
import com.esen.servicios.Ticket;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketStorage extends FileStorage {
    private final String RUTA_ARCHIVO = "tickets.json";

    @Override
    public void guardarDatos(List<Ticket> listaTickets) {

    }

    @Override
    public List<Ticket> cargarDatos() {
        File archivo = new File(RUTA_ARCHIVO);

        if (!archivo.exists())  return new ArrayList<>();

        try {
            List<Ticket> tickets = mapper.readValue(archivo, new TypeReference<List<Ticket>>() {});
            System.out.println("✅ Datos cargados correctamente.");
            return tickets;
        } catch (IOException e) {
            System.out.println("❌ Error cargando tickets: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
