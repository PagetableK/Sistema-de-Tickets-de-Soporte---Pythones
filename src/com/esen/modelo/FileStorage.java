package com.esen.modelo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private final ObjectMapper mapper;
    private final String RUTA_ARCHIVO = "jugadores.json";

    public FileStorage() {
        this.mapper = new ObjectMapper();
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void guardarJugadores(List<Jugador> listaJugadores) {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            // Escribe la lista en el archivo con formato bonito
            mapper.writeValue(archivo, listaJugadores);
            System.out.println("✅ Datos guardados correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Jugador> cargarJugadores() {
        File archivo = new File(RUTA_ARCHIVO);

        // Si es la primera vez que se abre el programa y el archivo no existe,
        // devolvemos una lista nueva vacía para evitar errores (NullPointerException).
        if (!archivo.exists()) {
            System.out.println("⚠️ No se encontró el archivo previo. Se iniciará con una lista vacía.");
            return new ArrayList<>();
        }

        try {
            // Leemos el archivo y lo convertimos a List<Jugador>
            List<Jugador> jugadores = mapper.readValue(archivo, new TypeReference<List<Jugador>>() {});
            System.out.println("✅ Datos cargados correctamente.");
            return jugadores;
        } catch (IOException e) {
            System.out.println("❌ Error al leer los datos: " + e.getMessage());
            return new ArrayList<>(); // En caso de error (ej. JSON corrupto), devolvemos lista vacía
        }
    }
}

