package com.esen.modelo;

import com.esen.servicios.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TechnicianStorage extends FileStorage{
    private final String RUTA_ARCHIVO = "tecnicos.json";
}
