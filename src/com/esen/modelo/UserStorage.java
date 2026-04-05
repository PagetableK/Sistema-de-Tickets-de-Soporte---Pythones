package com.esen.modelo;

import com.esen.servicios.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserStorage extends FileStorage {
    private final String RUTA_ARCHIVO = "usuarios.json";

    public void guardarUsuarios(List<Usuario> listaUsuarios) {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            // Escribe la lista en el archivo con formato bonito
            mapper.writeValue(archivo, listaUsuarios);
            System.out.println("✅ Datos guardados correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Usuario> cargarUsuarios() {
        File archivo = new File(RUTA_ARCHIVOU);

        if (!archivo.exists()) {
            System.out.println("⚠️ No se encontró el archivo previo. Se iniciará con una lista vacía.");
            return new ArrayList<>();
        }
        try {
            List<Usuario> jugadores = mapper.readValue(archivo, new TypeReference<List<Usuario>>() {});
            System.out.println("✅ Datos cargados correctamente.");
            return jugadores;
        } catch (IOException e) {
            System.out.println("❌ Error al leer los datos: " + e.getMessage());
            return new ArrayList<>(); // En caso de error (ej. JSON corrupto), devolvemos lista vacía
        }
    }
}
