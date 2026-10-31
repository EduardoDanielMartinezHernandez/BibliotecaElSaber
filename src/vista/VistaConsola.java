package vista;

import java.util.Scanner;

public class VistaConsola {

    private Scanner teclado = new Scanner(System.in);

    public void menuPrincipal() {
        System.out.println("\n--- BIBLIOTECA EL SABER ---");
        System.out.println("1. Libros nuevos");
        System.out.println("2. Libros en préstamo");
        System.out.println("3. Libros de referencia");
        System.out.println("0. Salir");
    }

    public void menuLibrosNuevos() {
        System.out.println("\n--- LIBROS NUEVOS ---");
        System.out.println("1. Agregar libro");
        System.out.println("2. Mostrar libros");
        System.out.println("3. Buscar por código");
        System.out.println("4. Eliminar el último");
        System.out.println("0. Volver");
    }

    public void menuPrestamos() {
        System.out.println("\n--- LIBROS EN PRÉSTAMO ---");
        System.out.println("1. Registrar préstamo");
        System.out.println("2. Buscar por título");
        System.out.println("3. Mostrar préstamos");
        System.out.println("4. Devolver libro");
        System.out.println("0. Volver");
    }

    public void menuReferencia() {
        System.out.println("\n--- LIBROS DE REFERENCIA ---");
        System.out.println("1. Agregar libro");
        System.out.println("2. Mostrar siguiente libro");
        System.out.println("3. Buscar por autor");
        System.out.println("4. Verificar si está vacía");
        System.out.println("0. Volver");
    }

    public int leerOpcion() {
        System.out.print("Opción: ");
        try {
            return Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }
}
