package com.esen.presentacion;

public class MenuAdmin extends Menu {

    @Override
    protected void imprimirEncabezadoYOpciones() {
        System.out.println("\n=== MENÚ ADMINISTRADOR ===");
        System.out.println("1. Ver usuarios");
        System.out.println("2. Ver técnicos");
        System.out.println("3. Registrar técnico");
        System.out.println("4. Registrar usuario");
        System.out.println("5. Asignar tickets");
        System.out.println("6. Ver todos los tickets");
        System.out.println("7. Cerrar sesión");
    }

    @Override
    protected void procesarOpcion(String opcion) {
        switch (opcion) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                continuar = false;
                System.out.println();
                break;
            default:
                System.out.println("Seleccione una opción válida (1-7)");
                break;
        }
    }
}