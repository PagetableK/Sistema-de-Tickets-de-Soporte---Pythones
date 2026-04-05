package com.esen.modelo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.ArrayList;
import java.util.List;

public abstract class FileStorage<T> {
    protected ObjectMapper mapper;


    public FileStorage(){
        this.mapper = new ObjectMapper();
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public abstract  void guardarDatos(List<T> datos);

    public abstract List<T> cargarDatos();
 }

