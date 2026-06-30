/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecadigitalparcial;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 *
 * @author Maxi
 */
public class Informe implements IExportable {

    private Biblioteca biblioteca;

    public Informe(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void exportar(String rutaArchivo) {

        try {
            PrintWriter writer = new PrintWriter(rutaArchivo);

            // Por cada vez que se genera el informe vuelve a contar
            biblioteca.contarLibrosDisponibles();
            biblioteca.contarSocios();
            biblioteca.contarLibros();
            writer.println("=== INFORME ===");
            writer.println("Fecha y hora de generacion: " + LocalDate.now());
            writer.println("Socios registrados: " + biblioteca.contadorSocios);
            writer.println("Libros registrados: " + biblioteca.contadorLibros);
            writer.println("Libros disponibles: " + biblioteca.contadorLibrosDisponibles);
            writer.println("Libro mas solicitado: --No resuelto--");
            writer.println();
            writer.println("===Prestamos activos ===");
            writer.println();

            for (Prestamo prestamo : biblioteca.listarPrestamosActivos()) {

                writer.println("ID: " + prestamo.getIdPrestamo());

                writer.println("Socio: " + prestamo.getSocio().getNombre()
                        + " " + prestamo.getSocio().getApellido()
                        + " " + prestamo.getSocio().getDni());

                writer.println("Libro: " + prestamo.getLibro().getTitulo());

                writer.println("Fecha prestamo: " + prestamo.getFechaPrestamo());

                writer.println("Estado: Activo");

                writer.println("---------------------------------------------");

            }

            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al generar el reporte.");
        }

    }
}
