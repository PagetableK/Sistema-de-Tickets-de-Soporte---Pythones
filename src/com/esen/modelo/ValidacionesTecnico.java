package com.esen.modelo;
import com.esen.servicios.Tecnico;
import java.util.List;

public class ValidacionesTecnico extends Validaciones<Tecnico> {
    public Tecnico tecnicoLogueado;

    @Override
    public boolean validarEmailRegistro(String email, List<Tecnico> tecnicos) {
        boolean correo_repetido = false;

        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getCorreo().equals(email)) {
                correo_repetido = true;
            }
        }

        if (correo_repetido) {
            System.out.println("El correo ya está siendo utilizado");
            return false;
        } else if (!emailRegex(email)) {
            System.out.println("El correo no es válido");
            return false;
        }

        return true;
    }

    @Override
    public boolean validarNombreRegistro(String nombre_tecnico, List<Tecnico> tecnicos) {
        if (nombre_tecnico.isEmpty()) {
            System.out.println("Asegúrese de ingresar el nombre del usuario");
            return false;
        } else if (nombre_tecnico.length() < 4 || nombre_tecnico.length() > 20) {
            System.out.println("El nombre del usuario debe tener entre 4 y 20 caracteres");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validarIngreso(String correo, String nombre_tecnico, List<Tecnico> tecnicos) {
        for (Tecnico t : tecnicos) {

            if (t.getNombre().equalsIgnoreCase(nombre_tecnico) && t.getCorreo().equalsIgnoreCase(correo)) {
                this.tecnicoLogueado = t;
                System.out.println("✅ Acceso concedido. Bienvenido, " + t.getNombre());
                return true;
            }
        }
        System.out.println("❌ Error: Nombre o correo no encontrados.");
        return false;
    }
}
