package com.esen.presentacion;

import com.esen.modelo.TechnicianStorage;
import com.esen.modelo.TicketStorage;
import com.esen.modelo.UserStorage;
import com.esen.servicios.Tecnico;
import com.esen.servicios.Ticket;
import com.esen.servicios.Usuario;

import java.util.List;

public class MenuUsuario extends Menu {
    @Override
    protected void imprimirEncabezadoYOpciones(){
        System.out.println("\n=== MENÚ USUARIO ===");
        System.out.println("1. Crear ticket");
        System.out.println("2. Ver mis tickets");
        System.out.println("3. Cerrar sesión");
    }

    @Override
    protected void procesarOpcion(String opcion){
        continuar = true;
        switch (opcion) {
            case "1":
                tickets.add(new Ticket("X","Yes"));
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