package SistemaBibliotecaConsole.vista;

import SistemaBibliotecaConsole.controlador.LibroControlador;
import SistemaBibliotecaConsole.controlador.LectorControlador;
import SistemaBibliotecaConsole.modelo.Libro;
import SistemaBibliotecaConsole.modelo.Lector;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuConsola {
    private final Scanner scanner = new Scanner(System.in);
    private final LibroControlador libroCtrl = new LibroControlador();
    private final LectorControlador lectorCtrl = new LectorControlador();

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Sistema de Gestión de Biblioteca ===");
            System.out.println("1. Gestionar Libros");
            System.out.println("2. Gestionar Lectores");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = leerEntero();

            switch (opcion) {
                case 1 -> menuLibros();
                case 2 -> menuLectores();
                case 3 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void menuLibros() {
        while (true) {
            System.out.println("\n--- Gestión de Libros ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Editar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = leerEntero();

            try {
                switch (opcion) {
                    case 1 -> agregarLibro();
                    case 2 -> listarLibros();
                    case 3 -> editarLibro();
                    case 4 -> eliminarLibro();
                    case 5 -> { return; }
                    default -> System.out.println("Opción inválida.");
                }
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
            }
        }
    }

    private void agregarLibro() throws SQLException {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = leerEntero();
        libroCtrl.agregarLibro(new Libro(0, titulo, autor, anio));
        System.out.println("Libro agregado correctamente.");
    }

    private void listarLibros() throws SQLException {
        List<Libro> libros = libroCtrl.obtenerLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro l : libros) {
                System.out.printf("[%d] %s - %s (%d)%n", l.getId(), l.getTitulo(), l.getAutor(), l.getAnioPublicacion());
            }
        }
    }

    private void editarLibro() throws SQLException {
        System.out.print("ID del libro a editar: ");
        int id = leerEntero();
        System.out.print("Nuevo título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nuevo autor: ");
        String autor = scanner.nextLine();
        System.out.print("Nuevo año: ");
        int anio = leerEntero();
        libroCtrl.editarLibro(new Libro(id, titulo, autor, anio));
        System.out.println("Libro actualizado.");
    }

    private void eliminarLibro() throws SQLException {
        System.out.print("ID del libro a eliminar: ");
        int id = leerEntero();
        libroCtrl.eliminarLibro(id);
        System.out.println("Libro eliminado.");
    }

    private void menuLectores() {
        while (true) {
            System.out.println("\n--- Gestión de Lectores ---");
            System.out.println("1. Agregar Lector");
            System.out.println("2. Listar Lectores");
            System.out.println("3. Editar Lector");
            System.out.println("4. Eliminar Lector");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = leerEntero();

            try {
                switch (opcion) {
                    case 1 -> agregarLector();
                    case 2 -> listarLectores();
                    case 3 -> editarLector();
                    case 4 -> eliminarLector();
                    case 5 -> { return; }
                    default -> System.out.println("Opción inválida.");
                }
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
            }
        }
    }

    private void agregarLector() throws SQLException {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        lectorCtrl.agregarLector(new Lector(0, nombre, email));
        System.out.println("Lector agregado correctamente.");
    }

    private void listarLectores() throws SQLException {
        List<Lector> lectores = lectorCtrl.obtenerLectores();
        if (lectores.isEmpty()) {
            System.out.println("No hay lectores registrados.");
        } else {
            for (Lector l : lectores) {
                System.out.printf("[%d] %s - %s%n", l.getId(), l.getNombre(), l.getEmail());
            }
        }
    }

    private void editarLector() throws SQLException {
        System.out.print("ID del lector a editar: ");
        int id = leerEntero();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo email: ");
        String email = scanner.nextLine();
        lectorCtrl.editarLector(new Lector(id, nombre, email));
        System.out.println("Lector actualizado.");
    }

    private void eliminarLector() throws SQLException {
        System.out.print("ID del lector a eliminar: ");
        int id = leerEntero();
        lectorCtrl.eliminarLector(id);
        System.out.println("Lector eliminado.");
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Intente de nuevo: ");
            }
        }
    }
}
