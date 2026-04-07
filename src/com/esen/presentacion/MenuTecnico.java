package com.esen.presentacion;

import com.esen.servicios.Tecnico;
import com.esen.servicios.Ticket;
import com.esen.servicios.TicketStatus;

import java.util.List;

public class MenuTecnico extends Menu {

    private Tecnico tecnicoLogueado;

    @Override
    protected void imprimirEncabezadoYOpciones() {
        System.out.println("\n=== MENÚ TÉCNICO ===");
        System.out.println("1. Ver tickets asignados");
        System.out.println("2. Cerrar ticket");
        System.out.println("3. Cerrar sesión");
    }

    public boolean login(){
        tecnicos = gestor_tecnicos.cargarDatos();
        int intentos = 0;
        boolean V = false;
        while(intentos < 3 && !V) {
            System.out.println("\n--- ACCESO DE TÉCNICO ---");
            System.out.println("Ingrese su correo (o escriba Salir para volver):");
            String correo = s.nextLine().trim();
            if (correo.toLowerCase().trim().equals("salir")) {
                break;
            }
            System.out.println("Ingrese su nombre:");
            String nombre = s.nextLine().trim();
            if (nombre.toLowerCase().trim().equals("salir")) {
                break;
            }
            V = validacionesTecnico.validarIngreso(correo, nombre, tecnicos);
            intentos += 1;
        }
        if(intentos == 3) {
            System.out.println("Demasiados intentos fallidos.");
        }

        tecnicoLogueado = validacionesTecnico.tecnicoLogueado;

        return V;
    }


    @Override
    protected void procesarOpcion(String opcion) {
        continuar = true;
        switch (opcion) {
            case "1":
                tickets = gestor_tickets.cargarDatos();
                System.out.println("== TUS TICKETS ASIGNADOS ==");
                boolean tieneTickets = false;
                for (Ticket t : tickets) {
                    if (t.getTecnicoAsignado() != null &&
                            t.getTecnicoAsignado().equalsIgnoreCase(tecnicoLogueado.getNombre())) {
                        System.out.println("[" + t.getEstado() + "] " + t.getDescripcion() + " | Prioridad: " + t.getPrioridad());
                        tieneTickets = true;
                    }
                }
                if (!tieneTickets) System.out.println("No tienes tickets asignados.");
                System.out.println("\nPresione Enter para continuar");
                s.nextLine();
                break;
            case "2":
                tickets = gestor_tickets.cargarDatos(); // recargar por si hay cambios

                // Filtrar tickets asignados a este técnico
                System.out.println("== TUS TICKETS EN PROCESO ==");
                boolean hayTickets = false;
                for (int i = 0; i < tickets.size(); i++) {
                    Ticket t = tickets.get(i);
                    if (t.getEstado() == TicketStatus.EN_PROCESO &&
                            t.getTecnicoAsignado() != null &&
                            t.getTecnicoAsignado().equalsIgnoreCase(tecnicoLogueado.getNombre())) {
                        System.out.println(i + ". " + t.getDescripcion() + " | Prioridad: " + t.getPrioridad());
                        hayTickets = true;
                    }
                }

                if (!hayTickets) {
                    System.out.println("No tienes tickets en proceso.");
                    s.nextLine();
                    break;
                }

                System.out.print("Ingrese el índice del ticket a cerrar: ");
                int idx = Integer.parseInt(s.nextLine().trim());
                tickets.get(idx).setEstado(TicketStatus.CERRADO);
                gestor_tickets.guardarDatos(tickets);
                System.out.println("✅ Ticket cerrado exitosamente.");
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