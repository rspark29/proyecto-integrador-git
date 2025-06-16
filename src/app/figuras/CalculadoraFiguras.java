package app.figuras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraFiguras {
    private static final List<Figura> historial = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            imprimirMenu();

            System.out.print("Seleccione una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    crearCirculo(sc);
                    break;
                case "2":
                    crearRectangulo(sc);
                    break;
                case "3":
                    crearTriangulo(sc);
                    break;
                case "4":
                    mostrarHistorial();
                    break;
                case "5":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            Decorador.imprimirLinea();
        }

        mostrarEstadisticas();
        sc.close();
    }

    public static void imprimirMenu() {
        Decorador.imprimirCabecera("MENÚ PRINCIPAL");
        System.out.println("1. Calcular área de un Círculo");
        System.out.println("2. Calcular área de un Rectángulo");
        System.out.println("3. Calcular área de un Triángulo");
        System.out.println("4. Mostrar historial");
        System.out.println("5. Salir");
    }

    public static void crearCirculo(Scanner sc) {
        try {
            System.out.print("Ingrese el radio: ");
            double radio = Double.parseDouble(sc.nextLine());
            if (radio <= 0) throw new IllegalArgumentException("El radio debe ser mayor que cero.");

            Figura c = new Circulo(radio);
            System.out.printf("Área del círculo: %.2f%n", c.calcularArea());
            historial.add(c);
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void crearRectangulo(Scanner sc) {
        try {
            System.out.print("Ingrese la base: ");
            double base = Double.parseDouble(sc.nextLine());
            System.out.print("Ingrese la altura: ");
            double altura = Double.parseDouble(sc.nextLine());
            if (base <= 0 || altura <= 0) throw new IllegalArgumentException("Los valores deben ser positivos.");

            Figura r = new Rectangulo(base, altura);
            System.out.printf("Área del rectángulo: %.2f%n", r.calcularArea());
            historial.add(r);
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese valores numéricos válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void crearTriangulo(Scanner sc) {
        try {
            System.out.print("Ingrese la base: ");
            double base = Double.parseDouble(sc.nextLine());
            System.out.print("Ingrese la altura: ");
            double altura = Double.parseDouble(sc.nextLine());
            if (base <= 0 || altura <= 0) throw new IllegalArgumentException("Los valores deben ser positivos.");

            Figura t = new Triangulo(base, altura);
            System.out.printf("Área del triángulo: %.2f%n", t.calcularArea());
            historial.add(t);
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese valores numéricos válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No se han registrado figuras aún.");
            return;
        }

        Decorador.imprimirCabecera("Historial de Figuras");
        int i = 1;
        for (Figura figura : historial) {
            System.out.printf("%d. %s - Área: %.2f%n", i++, figura.getNombre(), figura.calcularArea());
        }
    }

    public static void mostrarEstadisticas() {
        int total = historial.size();
        double sumaAreas = historial.stream().mapToDouble(Figura::calcularArea).sum();
        double promedio = total > 0 ? sumaAreas / total : 0;

        Decorador.imprimirCabecera("Estadísticas Finales");
        System.out.println("Total de figuras: " + total);
        System.out.printf("Promedio de áreas: %.2f%n", promedio);
    }

    // Clase anidada estática
    static class Decorador {
        public static void imprimirCabecera(String titulo) {
            System.out.println("==============================");
            System.out.println(titulo.toUpperCase());
            System.out.println("==============================");
        }

        public static void imprimirLinea() {
            System.out.println("------------------------------");
        }
    }
}


