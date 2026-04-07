package com.esen.modelo;

import com.esen.servicios.Ticket;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketStorage extends FileStorage<Ticket> {
    private final String RUTA_ARCHIVO = "tickets.json";

    @Override
    public void guardarDatos(List<Ticket> listaTickets) {
        try {
            File archivo = new File(RUTA_ARCHIVO);

            mapper.writeValue(archivo, listaTickets);
//            System.out.println("✅ Datos guardados correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los datos: " + e.getMessage());
        }
    }

    @Override
    public List<Ticket> cargarDatos() {
        File archivo = new File(RUTA_ARCHIVO);

        if (!archivo.exists())  return new ArrayList<>();

        try {
            List<Ticket> tickets = mapper.readValue(archivo, new TypeReference<List<Ticket>>() {});
//            System.out.println("✅ Datos cargados correctamente.");
            return tickets;
        } catch (IOException e) {
            System.out.println("❌ Error cargando tickets: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
