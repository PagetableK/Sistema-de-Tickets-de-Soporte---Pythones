package com.esen;

import com.esen.presentacion.MenuUsuario;
import com.esen.presentacion.MenuTecnico;
import com.esen.presentacion.MenuAdmin;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;

        Scanner s = new Scanner(System.in);
        MenuUsuario usuario = new MenuUsuario();
        MenuTecnico tecnico = new MenuTecnico();
        MenuAdmin administrador = new MenuAdmin();

        do {
            System.out.println("\n••••Bienvenido al sistema de tickets de soporte••••");
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ingresar al menú de usuario");
            System.out.println("2. Ingresar al menú de técnico");
            System.out.println("3. Ingresar al menú de administrador");
            System.out.println("4. Cerrar terminal");
            System.out.println("Digite el número correspondiente:");
            String opcion = s.nextLine().trim();

            switch (opcion) {
                case "1":
                    usuario.mostrar();
                    break;
                case "2":
                    tecnico.mostrar();
                    break;
                case "3":
                    administrador.mostrar();
                    break;
                case "4":
                    continuar = false;
                    break;
                default:
                    System.out.println("Digite una opción válida (1, 2, 3 o 4)");
                    break;
            }
        } while (continuar);
    }
}