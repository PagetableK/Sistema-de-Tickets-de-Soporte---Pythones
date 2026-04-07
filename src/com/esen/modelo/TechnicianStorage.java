package com.esen.modelo;

import com.esen.servicios.Tecnico;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TechnicianStorage extends FileStorage<Tecnico>{
    private final String RUTA_ARCHIVO = "tecnicos.json";

    @Override
    public void guardarDatos(List<Tecnico> listaTecnicos) {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            mapper.writeValue(archivo, listaTecnicos);
            System.out.println("✅ Datos guardados correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los datos: " + e.getMessage());
        }
    }

    @Override
    public List<Tecnico> cargarDatos() {
        File archivo = new File(RUTA_ARCHIVO);

        if (!archivo.exists())  return new ArrayList<>();

        try {
            List<Tecnico> tecnicos = mapper.readValue(archivo, new TypeReference<List<Tecnico>>() {});
            System.out.println("✅ Datos de técnicos cargados correctamente.");
            return tecnicos;
        } catch (IOException e) {
            System.out.println("❌ Error cargando técnicos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
