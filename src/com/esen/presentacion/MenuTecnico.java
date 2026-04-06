package com.esen.presentacion;

import com.esen.servicios.Tecnico;
import com.esen.servicios.Ticket;
import com.esen.servicios.TicketStatus;

import java.util.List;

public class MenuTecnico extends Menu {

    private Tecnico tecnicoLogueado;

    @Override
    protected void imprimirEncabezadoYOpciones() {
        System.out.println("\n=== MENÚ TÉCNICO (" + tecnicoLogueado.getNombre() + ") ===");
        System.out.println("1. Ver tickets asignados");
        System.out.println("2. Cerrar ticket");
        System.out.println("3. Cerrar sesión");
    }

    public boolean login(){
        gestor_tickets.cargarDatos();
        gestor_tecnicos.cargarDatos();
        int intentos = 0;
        boolean V = false;
        while(intentos < 3 && !V) {
            System.out.println("\n--- ACCESO DE TÉCNICO ---");
            System.out.println("Ingrese su correo:");
            String correo = s.nextLine().trim();
            System.out.println("Ingrese su nombre:");
            String nombre = s.nextLine().trim();
            V = validacionesTecnico.validarIngreso(correo, nombre, tecnicos);
            intentos += 1;
            if (intentos == 3) {
                System.out.println("Demasiados intentos fallidos.");
                break;
            }
        }
        return V;
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

    protected void VerTicketsAsignados(){
        System.out.println("== LISTA DE TICKETS ASIGNADOS==");
        for (Ticket ticket : tickets) {
            if (tecnicoLogueado.equals(ticket.getTecnicoAsignado())) {
                System.out.println("Descripción: " + ticket.getDescripcion());
                System.out.println("Prioridad: " + ticket.getPrioridad());
                System.out.println("Estado: " + ticket.getEstado());
                System.out.println("---");
            }
        }
        System.out.println("Presione Enter para continuar");
        s.nextLine();
    }

    protected void CerrarTicket(){

    }

}