package com.esen;

import com.esen.modelo.FileStorage;
import com.esen.modelo.TechnicianStorage;
import com.esen.modelo.TicketStorage;
import com.esen.modelo.UserStorage;
import com.esen.presentacion.MenuUsuario;
import com.esen.presentacion.MenuTecnico;
import com.esen.presentacion.MenuAdmin;
import com.esen.servicios.Tecnico;
import com.esen.servicios.Usuario;
import com.esen.servicios.Ticket;

import java.io.File;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;

        Scanner s = new Scanner(System.in);
        MenuUsuario usuario = new MenuUsuario();
        MenuTecnico tecnico = new MenuTecnico();
        MenuAdmin administrador = new MenuAdmin();
        UserStorage gestor_usuarios = new UserStorage(); //examinar
        TechnicianStorage gestor_tecnicos = new TechnicianStorage();
        TicketStorage gestor_tickets = new TicketStorage();
        System.out.println("••••INICIANDO SISTEMA••••");
        List<Usuario> usuarios = gestor_usuarios.cargarDatos();
        List<Tecnico> tecnicos = gestor_tecnicos.cargarDatos();
        List<Ticket> tickets = gestor_tickets.cargarDatos();


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
        System.out.println("\n••••CERRANDO SISTEMA••••");
    }
}