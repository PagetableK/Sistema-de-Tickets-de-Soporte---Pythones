package com.esen.presentacion;

import com.esen.servicios.Ticket;
import com.esen.servicios.Usuario;

import java.util.Arrays;
import java.util.List;

public class MenuUsuario extends Menu {

    private Usuario usuarioLogueado;

    public boolean login() {
        usuarios = gestor_usuarios.cargarDatos();
        int intentos = 0;
        boolean V = false;
        while(intentos < 3 && !V) {
            System.out.println("\n--- ACCESO DE USUARIO ---");
            System.out.print("Ingrese su correo (o escriba Salir para volver): ");
            String correo = s.nextLine().trim();
            if (correo.toLowerCase().trim().equals("salir")) {
                break;
            }
            System.out.print("Ingrese su nombre: ");
            String nombre = s.nextLine().trim();
            V = validacionesUsuario.validarIngreso(correo, nombre, usuarios);
            intentos += 1;
        }
        if(intentos == 3) {
            System.out.println("Demasiados intentos fallidos.");
        }

        usuarioLogueado = validacionesUsuario.usuarioLogueado;

        return V;
    }

    @Override
    protected void imprimirEncabezadoYOpciones() {
        System.out.println("\n=== MENÚ USUARIO (" + usuarioLogueado.getNombre() + ") ===");
        System.out.println("1. Crear ticket");
        System.out.println("2. Ver mis tickets");
        System.out.println("3. Cerrar sesión");
    }

    @Override
    protected void procesarOpcion(String opcion) {
        usuarios = gestor_usuarios.cargarDatos();
        tecnicos = gestor_tecnicos.cargarDatos();
        tickets = gestor_tickets.cargarDatos();
        continuar = true;
        switch (opcion) {
            case "1":
                crearNuevoTicket();
                break;
            case "2":
                verMisTickets();
                break;
            case "3":
                System.out.println("Guardando cambios y cerrando sesión...");
                gestor_tickets.guardarDatos(tickets);
                continuar = false;
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                break;
        }
    }


    private void crearNuevoTicket() {
        List<String> prioridades = Arrays.asList("ALTA", "MEDIA", "BAJA");

        System.out.println("\n--- NUEVO TICKET ---");
        System.out.print("Descripción del problema: ");
        String desc = s.nextLine();

        while (true) {
            System.out.print("Prioridad (Alta/Media/Baja): ");
            String prioridad = s.nextLine();
            prioridad = prioridad.toUpperCase().trim();
            if (prioridades.contains(prioridad)) {
                Ticket nuevo = new Ticket(desc, prioridad);
                tickets.add(nuevo);
                System.out.println("DEBUG: guardando " + tickets.size() + " tickets");
                gestor_tickets.guardarDatos(tickets);
                System.out.println("✅ Ticket registrado exitosamente (Estado: " + nuevo.getEstado() + ")");
                break;
            }
            else{
                System.out.println("La prioridad ingresada no es válida. \nIngrese una prioridad válida para continuar.");
            }
        }
    }


    private void verMisTickets() {
        System.out.println("\n--- MIS TICKETS REGISTRADOS ---");
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets en el sistema.");
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            Ticket t = tickets.get(i);
            System.out.println((i + 1) + ". [" + t.getEstado() + "] " + t.getDescripcion() + " | Prioridad: " + t.getPrioridad());
        }
        System.out.println("\nPresione Enter para volver al menú...");
        s.nextLine();
    }
}