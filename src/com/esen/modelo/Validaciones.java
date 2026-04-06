package com.esen.modelo;

import com.esen.servicios.Usuario;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validaciones<T> {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean emailRegex(String email) {
        if (email == null) return false;
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public abstract boolean validarEmail(String email, List<T> correos);
    public abstract boolean validarNombre(String nombre, List<Usuario> usuarios);
}
