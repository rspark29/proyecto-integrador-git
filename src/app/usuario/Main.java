package app.usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControladorUsuarios controlador = new ControladorUsuarios();
        Scanner scanner = new Scanner(System.in);

        ControladorUsuarios.Decorador.mostrarLineaDecorativa();
        System.out.println("Bienvenido al Sistema de Registro de Usuarios v2.0");
        ControladorUsuarios.Decorador.mostrarLineaDecorativa();

        String continuar;
        do {
            try {
                System.out.print("Ingrese nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese edad: ");
                int edad = Integer.parseInt(scanner.nextLine());

                if (edad < 0 || edad > 130) {
                    throw new IllegalArgumentException("Edad no válida.");
                }

                System.out.print("Ingrese ciudad: ");
                String ciudad = scanner.nextLine();

                Usuario nuevoUsuario = new Usuario(nombre, edad, ciudad);
                controlador.agregarUsuario(nuevoUsuario);

            } catch (NumberFormatException e) {
                System.out.println("⚠ Error: Edad debe ser un número.");
            } catch (IllegalArgumentException e) {
                System.out.println("⚠ " + e.getMessage());
            }

            System.out.print("¿Desea agregar otro usuario? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        ControladorUsuarios.Decorador.mostrarLineaDecorativa();
        System.out.println("Resumen:");
        System.out.println("Total de usuarios: " + controlador.totalUsuarios());
        System.out.println("Promedio de edad: " + controlador.promedioEdad());
        System.out.println("Nombre más largo: " + controlador.nombreMasLargo());
        System.out.println("Usuario destacado: " + controlador.usuarioDestacado());
        ControladorUsuarios.Decorador.mostrarLineaDecorativa();

        scanner.close();
    }
}
