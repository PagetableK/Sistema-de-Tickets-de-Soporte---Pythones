package com.esen.modelo;

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

    public abstract boolean validarEmailRegistro(String email, List<T> correos);
    public abstract boolean validarNombreRegistro(String nombre, List<T> nombres);
    public abstract  boolean validarIngreso(String email, String nombre, List<T> correos);
}
