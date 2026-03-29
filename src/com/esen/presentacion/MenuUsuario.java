package com.esen.presentacion;

public class MenuUsuario extends Menu {
    @Override
    protected void imprimirEncabezadoYOpciones(){
        System.out.println("\n=== MENÚ USUARIO ===");
        System.out.println("1. Crear ticket");
        System.out.println("2. Ver mis tickets");
        System.out.println("3. Cerrar sesión");
        System.out.print("Seleccione una opción: ");
    }

    @Override
    protected void procesarOpcion(String opcion){
        switch (opcion) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                continuar = false;
                System.out.println();
                break;
            default:
                System.out.println("Seleccione una opción válida (1, 2, o 3)");
                break;
        }
    }
}