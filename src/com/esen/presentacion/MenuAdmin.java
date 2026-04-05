package com.esen.presentacion;
import com.esen.modelo.Validaciones;
import com.esen.servicios.Usuario;

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
                break;
            case "3":
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

                    if(Validaciones.validarNombreUsuario(nombre, usuarios)){
                        nombre_usuario = nombre;
                        break;
                    }
                }

                // Validaciones para correo
                while (true){
                    System.out.println("Ingrese el correo:");
                    String correo = s.nextLine();

                    if(Validaciones.validarEmailUsuario(correo, usuarios))
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
                break;
            case "6":
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