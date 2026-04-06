package com.esen.modelo;
import com.esen.servicios.Tecnico;
import java.util.List;

public class ValidacionesTecnico extends Validaciones<Tecnico>{
    @Override
    public boolean validarEmail(String email, List<Tecnico> tecnicos){
        boolean correo_repetido = false;

        for (Tecnico tecnico : tecnicos){
            if(tecnico.getNombre().equals(email)){
                correo_repetido = true;
            }
        }

        if (correo_repetido){
            System.out.println("El correo ya está siendo utilizado");
            return false;
        }
        else if(!emailRegex(email)){
            System.out.println("El correo no es válido");
            return false;
        }

        return true;
    }

    @Override
    public boolean validarNombre(String nombre_tecnico, List<Tecnico> tecnicos){
        boolean nombre_repetido = false;

        for (Tecnico tecnico : tecnicos){
            if(tecnico.getNombre().equals(nombre_tecnico)){
                nombre_repetido = true;
            }
        }

        if (nombre_repetido == true){
            System.out.println("El nombre de técnico ya está siendo utilizado");
            return false;
        }
        else if (nombre_tecnico.isEmpty()){
            System.out.println("Asegúrese de ingresar el nombre del usuario");
            return false;
        }
        else if (nombre_tecnico.length() < 4 || nombre_tecnico.length() > 20) {
            System.out.println("El nombre del usuario debe tener entre 4 y 20 caracteres");
            return false;
        }
        else{
            return true;
        }
    }
}
