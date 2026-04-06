package com.esen.presentacion;

import com.esen.modelo.*;
import com.esen.servicios.Tecnico;
import com.esen.servicios.Ticket;
import com.esen.servicios.Usuario;

import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    protected boolean continuar = true;
    protected Scanner s = new Scanner(System.in);
    UserStorage gestor_usuarios = new UserStorage();
    TechnicianStorage gestor_tecnicos = new TechnicianStorage();
    TicketStorage gestor_tickets = new TicketStorage();
    List<Usuario> usuarios = gestor_usuarios.cargarDatos();
    List<Tecnico> tecnicos = gestor_tecnicos.cargarDatos();
    List<Ticket> tickets = gestor_tickets.cargarDatos();
    ValidacionesUsuario validacionesUsuario = new ValidacionesUsuario();
    ValidacionesTecnico validacionesTecnico = new ValidacionesTecnico();

    public void mostrar() {
        do {
            imprimirEncabezadoYOpciones();
            System.out.print("Seleccione una opción: ");
            String opcion = s.nextLine().trim();
            procesarOpcion(opcion);
        } while (continuar);
    }

    protected abstract void imprimirEncabezadoYOpciones();
    protected abstract void procesarOpcion(String opcion);
    public abstract boolean login();
}