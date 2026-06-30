/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecadigitalparcial;

import java.util.Scanner;

/**
 *
 * @author Maxi
 */
public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Precarga para testear
        // LIBROS
        biblioteca.registrarLibro(new Libro("L001", "Cien anios de soledad", "Gabriel Garcia Marquez", 1967));
        biblioteca.registrarLibro(new Libro("L002", "Ficciones", "Jorge Luis Borges", 1944));
        biblioteca.registrarLibro(new Libro("L003", "El tunel", "Ernesto Sabato", 1948));
        biblioteca.registrarLibro(new Libro("L004", "Rayuela", "Julio Cortazar", 1963));
        biblioteca.registrarLibro(new Libro("L005", "Don Quijote de la Mancha", "Miguel de Cervantes", 1605));
        biblioteca.registrarLibro(new Libro("L006", "La sombra del viento", "Carlos Ruiz Zafon", 2001));
        biblioteca.registrarLibro(new Libro("L007", "El alquimista", "Paulo Coelho", 1988));
        biblioteca.registrarLibro(new Libro("L008", "Cronica de una muerte anunciada", "Gabriel Garcia Marquez", 1981));
        biblioteca.registrarLibro(new Libro("L009", "1984", "George Orwell", 1949));
        biblioteca.registrarLibro(new Libro("L010", "Harry Potter y la piedra filosofal", "J.K. Rowling", 1997));

        // SOCIOS
        biblioteca.registrarSocio(new Socio("30111222", "Juan", "Perez", "juan.perez@mail.com"));
        biblioteca.registrarSocio(new Socio("28999888", "Maria", "Gonzalez", "maria.gonzalez@mail.com"));
        biblioteca.registrarSocio(new Socio("31222333", "Lucas", "Fernandez", "lucas.fernandez@mail.com"));
        biblioteca.registrarSocio(new Socio("27555666", "Sofia", "Martinez", "sofia.martinez@mail.com"));
        biblioteca.registrarSocio(new Socio("33444111", "Tomas", "Rodriguez", "tomas.rodriguez@mail.com"));
        biblioteca.registrarSocio(new Socio("29888777", "Valentina", "Lopez", "valentina.lopez@mail.com"));
        biblioteca.registrarSocio(new Socio("31000999", "Diego", "Sanchez", "diego.sanchez@mail.com"));
        biblioteca.registrarSocio(new Socio("32222111", "Camila", "Romero", "camila.romero@mail.com"));
        biblioteca.registrarSocio(new Socio("28777111", "Nicolas", "Diaz", "nicolas.diaz@mail.com"));
        biblioteca.registrarSocio(new Socio("30555444", "Florencia", "Acosta", "florencia.acosta@mail.com"));

        int opcion;

        do {

            Utilidades.mostrarTitulo("SISTEMA DE BIBLIOTECA");

            Utilidades.mostrarOpcion("1. Registrar libro");
            Utilidades.mostrarOpcion("2. Listar libros");
            Utilidades.mostrarOpcion("3. Buscar libro por codigo");
            Utilidades.mostrarOpcion("4. Registrar socio");
            Utilidades.mostrarOpcion("5. Listar socios");
            Utilidades.mostrarOpcion("6. Realizar prestamo");
            Utilidades.mostrarOpcion("7. Registrar devolucion");
            Utilidades.mostrarOpcion("8. Listar prestamos activos");
            Utilidades.mostrarOpcion("9. Exportar reporte");
            Utilidades.mostrarOpcion("10. Guardar datos");
            Utilidades.mostrarOpcion("11. Cargar Datos");
            Utilidades.mostrarOpcion("0. Salir");

            opcion = Utilidades.pedirOpcionMenu(scanner, 0, 11);

            switch (opcion) {

                case 1:
                    registrarLibro(scanner, biblioteca);
                    break;

                case 2:
                    Utilidades.mostrarLista(biblioteca.listarLibros());
                    Utilidades.pausa(scanner);
                    break;

                case 3:
                    buscarLibro(scanner, biblioteca);
                    break;

                case 4:
                    registrarSocio(scanner, biblioteca);
                    break;

                case 5:
                    Utilidades.mostrarLista(biblioteca.listarSocios());
                    Utilidades.pausa(scanner);
                    break;

                case 6:
                    realizarPrestamo(scanner, biblioteca);
                    break;

                case 7:
                    registrarDevolucion(scanner, biblioteca);
                    break;

                case 8:
                    Utilidades.mostrarLista(biblioteca.listarPrestamosActivos());
                    Utilidades.pausa(scanner);
                    break;

                case 9:
                    Informe informe = new Informe(biblioteca);
                    informe.exportar("informe.txt");
                    System.out.println("Reporte generado");
                    Utilidades.pausa(scanner);
                    break;

                case 10:
                    biblioteca.guardarDatos();
                    Utilidades.pausa(scanner);
                    break;

                case 11:
                    biblioteca.cargarDatos();
                    Utilidades.pausa(scanner);
                    break;

                case 0:
                    Utilidades.apagarPrograma("Saliendo del sistema...");
                    break;
            }

        } while (opcion != 0);

    }

    private static void registrarLibro(Scanner scanner, Biblioteca biblioteca) {

        String codigo = Utilidades.pedirTexto(scanner, "Codigo: ");
        String titulo = Utilidades.pedirTexto(scanner, "Titulo: ");
        String autor = Utilidades.pedirTexto(scanner, "Autor: ");
        int anio = Utilidades.pedirEntero(scanner, "Anio publicacion: ");

        Libro libro = new Libro(codigo, titulo, autor, anio);

        if (biblioteca.registrarLibro(libro)) {
            System.out.println("Libro registrado correctamente");
        } else {
            System.out.println("Ya existe un libro con ese codigo");
        }

        Utilidades.pausa(scanner);

    }

    private static void buscarLibro(Scanner scanner, Biblioteca biblioteca) {

        String codigo = Utilidades.pedirTexto(scanner, "Codigo del libro: ");

        Libro libro = biblioteca.buscarLibro(codigo);

        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado");
        }

        Utilidades.pausa(scanner);

    }

    private static void registrarSocio(Scanner scanner, Biblioteca biblioteca) {

        String dni = Utilidades.pedirTexto(scanner, "DNI: ");
        String nombre = Utilidades.pedirTexto(scanner, "Nombre: ");
        String apellido = Utilidades.pedirTexto(scanner, "Apellido: ");
        String email = Utilidades.pedirTexto(scanner, "Email: ");

        Socio socio = new Socio(dni, nombre, apellido, email);

        if (biblioteca.registrarSocio(socio)) {
            System.out.println("Socio registrado correctamente");
        } else {
            System.out.println("Ya existe un socio con ese DNI");
        }

        Utilidades.pausa(scanner);

    }

    private static void realizarPrestamo(Scanner scanner, Biblioteca biblioteca) {

        String codigo = Utilidades.pedirTexto(scanner, "Codigo del libro: ");
        String dni = Utilidades.pedirTexto(scanner, "DNI socio: ");

        boolean ok = biblioteca.realizarPrestamo(codigo, dni);

        if (ok) {
            System.out.println("Prestamo realizado correctamente");
        } else {
            System.out.println("No se pudo realizar el prestamo");
        }

        Utilidades.pausa(scanner);
    }

    private static void registrarDevolucion(Scanner scanner, Biblioteca biblioteca) {

        int id = Utilidades.pedirEntero(scanner, "ID del prestamo: ");

        boolean ok = biblioteca.registrarDevolucion(id);

        if (ok) {
            System.out.println("Devolucion registrada correctamente");
        } else {
            System.out.println("No se encontró el prestamo o ya fue devuelto");
        }

        Utilidades.pausa(scanner);
    }
}
