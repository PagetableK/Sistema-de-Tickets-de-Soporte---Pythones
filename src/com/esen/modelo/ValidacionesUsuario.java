package com.esen.modelo;
import com.esen.servicios.Usuario;
import java.util.List;


public class ValidacionesUsuario extends Validaciones<Usuario>{
    @Override
    public boolean validarEmailRegistro(String email, List<Usuario> usuarios){
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

    @Override
    public boolean validarEmailIngreso(String email, List<Usuario> usuarios){
        return true;
    }

    @Override
    public boolean validarNombreRegistro(String nombre_usuario, List<Usuario> usuarios){
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

    @Override
    public boolean validarNombreIngreso(String nombre_usuario, List<Usuario> usuarios){
        return true;
    }
}
