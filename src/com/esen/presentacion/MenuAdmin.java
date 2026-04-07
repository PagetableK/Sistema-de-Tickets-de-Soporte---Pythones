package com.esen.presentacion;
import com.esen.modelo.Validaciones;
import com.esen.servicios.Ticket;
import com.esen.servicios.Usuario;
import com.esen.servicios.Tecnico;
import com.esen.servicios.TicketStatus;
import com.esen.modelo.ValidacionesUsuario;
import com.esen.modelo.ValidacionesTecnico;


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
        usuarios = gestor_usuarios.cargarDatos();
        tecnicos = gestor_tecnicos.cargarDatos();
        tickets = gestor_tickets.cargarDatos();
        continuar = true;
        switch (opcion) {
            case "1":
                System.out.println("== LISTA DE USUARIOS ==");
                for (Usuario usuario : usuarios)
                {
                    System.out.println("Nombre: " + usuario.getNombre());
                    System.out.println("Email: " + usuario.getCorreo());
                    System.out.println("---");
                }
                System.out.println("Presione Enter para continuar");
                s.nextLine();
                break;
            case "2":
                System.out.println("== LISTA DE TÉCNICOS ==");
                for (Tecnico tecnico : tecnicos) {
                    System.out.println("Nombre: " + tecnico.getNombre());
                    System.out.println("Email: " + tecnico.getCorreo());
                    System.out.println("Especialidad: " + tecnico.getEspecialidad());
                    System.out.println("---");
                }
                System.out.println("Presione Enter para continuar");
                s.nextLine();
                break;
            case "3":
                String nombre_tecnico, correo_tecnico, especialidad;
                while (true) {
                    System.out.print("Ingrese el nombre del técnico: ");
                    nombre_tecnico = s.nextLine();
                    if (validacionesTecnico.validarNombreRegistro(nombre_tecnico, tecnicos)) break;
                }
                while (true) {
                    System.out.print("Ingrese el correo: ");
                    correo_tecnico = s.nextLine();
                    if (validacionesTecnico.validarEmailRegistro(correo_tecnico, tecnicos)) break;
                }
                System.out.print("Ingrese la especialidad: ");
                especialidad = s.nextLine();
                Tecnico nuevoTecnico = new Tecnico(nombre_tecnico, correo_tecnico, especialidad);
                tecnicos.add(nuevoTecnico);
                gestor_tecnicos.guardarDatos(tecnicos);
                System.out.println("¡Técnico registrado con éxito!");
                break;
            case "4":
                String nombre_usuario;
                String correo_usuario;
                String rol_usuario;
                String area_usuario;

                // Validaciones para nombre_usuario
                while (true) {
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombre = s.nextLine();

                    if(validacionesUsuario.validarNombreRegistro(nombre, usuarios)){
                        nombre_usuario = nombre;
                        break;
                    }
                }

                // Validaciones para correo
                while (true){
                    System.out.println("Ingrese el correo:");
                    String correo = s.nextLine();

                    if(validacionesUsuario.validarEmailRegistro(correo, usuarios))
                    {
                        correo_usuario = correo;
                        break;
                    }
                }

                // Validaciones para área
                while (true){
                    System.out.println("Ingrese el área:");
                    String area = s.nextLine();

                    if(!area.isEmpty()){
                        area_usuario = area;
                        break;
                    }
                    else{
                        System.out.println("Asegúrese de ingresar el área del usuario");
                    }
                }

                // Validaciones para rol
                while (true){
                    System.out.println("Ingrese el rol:");
                    String rol = s.nextLine();

                    if(!rol.isEmpty()){
                        rol_usuario = rol;
                        break;
                    }
                }
                Usuario usuario = new Usuario(nombre_usuario, correo_usuario, area_usuario,  rol_usuario);
                usuarios.add(usuario);
                gestor_usuarios.guardarDatos(usuarios);
                break;
            case "5":
                int cntEnEspera = 0;
                for (int i = 0; i < tickets.size(); i++) {
                    if (tickets.get(i).getEstado() == TicketStatus.EN_ESPERA) {
                        System.out.println(i + ". " + tickets.get(i).getDescripcion());
                        cntEnEspera++;
                    }
                }
                if (cntEnEspera == 0){
                    System.out.println("No hay tickets con estado 'En espera'");
                }
                else if (tecnicos.size() == 0){
                    System.out.println("Todavía no se han registrado técnicos");
                }
                else {
                    System.out.println("== SELECCIONE UN TICKET EN ESPERA ==");
                    System.out.print("Ingrese el índice del ticket: ");
                    int ticketIdx = Integer.parseInt(s.nextLine());

                    // 2. Mostrar técnicos disponibles
                    System.out.println("== SELECCIONE UN TÉCNICO ==");
                    for (int j = 0; j < tecnicos.size(); j++) {
                        System.out.println(j + ". " + tecnicos.get(j).getNombre() + " (" + tecnicos.get(j).getEspecialidad() + ")");
                    }
                    System.out.print("Ingrese el índice del técnico: ");
                    int tecnicoIdx = Integer.parseInt(s.nextLine());

                    // 3. Realizar la asignación y cambiar estado
                    Ticket ticketSeleccionado = tickets.get(ticketIdx);
                    ticketSeleccionado.setEstado(TicketStatus.EN_PROCESO);
                    ticketSeleccionado.setTecnicoAsignado(tecnicos.get(tecnicoIdx).getNombre());
                    // Aquí se guardan los cambios en el archivo JSON
                    gestor_tickets.guardarDatos(tickets);

                    System.out.println("¡Ticket asignado exitosamente a " + tecnicos.get(tecnicoIdx).getNombre() + "!");
                }
                break;
            case "6":
                System.out.println("== LISTA DE TICKETS ==");
                for (Ticket ticket : tickets)
                {
                    System.out.println("Descripción: " + ticket.getDescripcion());
                    System.out.println("Prioridad: " + ticket.getPrioridad());
                    System.out.println("Estado: " + ticket.getEstado());
                    if (ticket.getTecnicoAsignado() == null)
                    {
                        System.out.println("Técnico: Sin asignar");
                    }
                    else{
                        System.out.println("Técnico asignado: " + ticket.getTecnicoAsignado());
                    }
                    System.out.println("---");
                }
                System.out.println("Presione Enter para continuar");
                s.nextLine();
                break;
            case "7":
                continuar = false;
                System.out.println();
                break;
            default:
                System.out.println("Seleccione una opción válida (1-7)\nPresione Enter para continuar");
                s.nextLine();
                break;
        }
    }
}