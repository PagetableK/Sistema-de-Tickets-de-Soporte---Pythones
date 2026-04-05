package com.esen.modelo;

import com.esen.servicios.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserStorage extends FileStorage<Usuario> {
    private final String RUTA_ARCHIVO = "usuarios.json";


    @Override
    public void guardarDatos(List<Usuario> listaUsuarios) {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            mapper.writeValue(archivo, listaUsuarios);
            System.out.println("✅ Datos guardados correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los datos: " + e.getMessage());
        }
    }


    @Override
    public List<Usuario> cargarDatos() {
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists())  return new ArrayList<>();

        try {
            List<Usuario> usuarios = mapper.readValue(archivo, new TypeReference<List<Usuario>>() {});
            System.out.println("✅ Datos cargados correctamente.");
            return usuarios;
        } catch (IOException e) {
            System.out.println("❌ Error cargando usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
