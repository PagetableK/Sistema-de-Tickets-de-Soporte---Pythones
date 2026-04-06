package com.esen.presentacion;

import com.esen.servicios.Tecnico;

import java.util.List;

public class MenuTecnico extends Menu {
    @Override
    protected void imprimirEncabezadoYOpciones() {
        System.out.println("\n=== MENÚ TÉCNICO ===");
        System.out.println("1. Ver tickets asignados");
        System.out.println("2. Cerrar ticket");
        System.out.println("3. Cerrar sesión");
    }

    public void validacion(){
        System.out.println("Ingrese sus credenciales de técnico:");
        System.out.println("Ingrese su correo:");
        String email = s.nextLine().trim();
        //validacionesTecnico.validarEmail(email, tecnicos);
        System.out.println("Ingrese su nombre:");
        String nombre = s.nextLine().trim();
        //validacionesTecnico.validarNombre(nombre, tecnicos);
    }


    @Override
    protected void procesarOpcion(String opcion) {
        continuar = true;
        switch (opcion) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                continuar = false;
                System.out.println();
                gestor_tickets.guardarDatos(tickets);
                break;
            default:
                System.out.println("Seleccione una opción válida (1, 2, o 3)\nPresione Enter para continuar");
                s.nextLine();
                break;
        }
    }
}