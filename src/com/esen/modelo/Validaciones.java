package com.esen.modelo;
import com.esen.servicios.Usuario;

import java.sql.SQLOutput;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean emailRegex(String email) {
        if (email == null) return false;
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validarEmailUsuario(String email, List<Usuario> usuarios){
        boolean correo_repetido = false;

        for (Usuario usuario : usuarios){
            if(usuario.getNombre().equals(email)){
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

    public static boolean validarNombreUsuario(String nombre_usuario, List<Usuario> usuarios){
        boolean nombre_repetido = false;

        for (Usuario usuario : usuarios){
            if(usuario.getNombre().equals(nombre_usuario)){
                nombre_repetido = true;
            }
        }

        if (nombre_repetido == true){
            System.out.println("El nombre de usuario ya está siendo utilizado");
            return false;
        }
        else if (nombre_usuario.isEmpty()){
            System.out.println("Asegúrese de ingresar el nombre del usuario");
            return false;
        }
        else if (nombre_usuario.length() < 4 || nombre_usuario.length() > 20) {
            System.out.println("El nombre del usuario debe tener entre 4 y 20 caracteres");
            return false;
        }
        else{
            return true;
        }
    }
}
