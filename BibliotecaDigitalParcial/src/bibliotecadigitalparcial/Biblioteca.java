/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecadigitalparcial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Maxi
 */
public class Biblioteca {

    private Repositorio<Libro> libros;
    private Repositorio<Socio> socios;
    private Repositorio<Prestamo> prestamos;

    private HashMap<String, Libro> librosPorCodigo;
    private HashMap<String, Socio> sociosPorDni;

    private int proximoIdPrestamo;
    public int contadorLibrosDisponibles;
    public int contadorSocios;
    public int contadorLibros;

    public Biblioteca() {

        libros = new Repositorio<>();
        socios = new Repositorio<>();
        prestamos = new Repositorio<>();

        librosPorCodigo = new HashMap<>();
        sociosPorDni = new HashMap<>();

        proximoIdPrestamo = 1;
        contadorLibrosDisponibles = 0;
        contadorSocios = 0;
        contadorLibros = 0;
    }

    public boolean registrarLibro(Libro libro) {

        if (librosPorCodigo.containsKey(libro.getCodigo())) {
            return false;
        }

        libros.agregar(libro);
        librosPorCodigo.put(libro.getCodigo(), libro);

        return true;
    }

    public boolean registrarSocio(Socio socio) {

        if (sociosPorDni.containsKey(socio.getDni())) {
            return false;
        }

        socios.agregar(socio);
        sociosPorDni.put(socio.getDni(), socio);

        return true;
    }

    public Libro buscarLibro(String codigo) {
        return librosPorCodigo.get(codigo);
    }

    public Socio buscarSocio(String dni) {
        return sociosPorDni.get(dni);
    }

    public ArrayList<Libro> listarLibros() {
        return libros.listar();
    }

    public ArrayList<Socio> listarSocios() {
        return socios.listar();
    }

    public ArrayList<Prestamo> listarPrestamos() {
        return prestamos.listar();
    }

    public boolean realizarPrestamo(String codigoLibro, String dniSocio) {

        Libro libro = buscarLibro(codigoLibro);

        if (libro == null || !libro.isDisponible()) {
            return false;
        }

        Socio socio = buscarSocio(dniSocio);

        if (socio == null) {
            return false;
        }

        Prestamo prestamo = new Prestamo(proximoIdPrestamo, libro, socio);

        prestamos.agregar(prestamo);

        libro.setDisponible(false);

        proximoIdPrestamo++;

        return true;
    }

    public boolean registrarDevolucion(int idPrestamo) {

        for (Prestamo prestamo : prestamos.listar()) {

            if (prestamo.getIdPrestamo() == idPrestamo && prestamo.isActivo()) {

                prestamo.registrarDevolucion();

                prestamo.getLibro().setDisponible(true);

                return true;
            }
        }

        return false;
    }

    public ArrayList<Prestamo> listarPrestamosActivos() {

        ArrayList<Prestamo> activos = new ArrayList<>();

        for (Prestamo prestamo : prestamos.listar()) {

            if (prestamo.isActivo()) {
                activos.add(prestamo);
            }
        }

        return activos;
    }

    // Reconstruccion para la recarga de datos
    private void reconstruirMapas() {

        librosPorCodigo.clear();
        sociosPorDni.clear();

        for (Libro libro : libros.listar()) {
            librosPorCodigo.put(libro.getCodigo(), libro);
        }

        for (Socio socio : socios.listar()) {
            sociosPorDni.put(socio.getDni(), socio);
        }
    }

    private void actualizarProximoIdPrestamo() {

        int maximo = 0;

        for (Prestamo prestamo : prestamos.listar()) {

            if (prestamo.getIdPrestamo() > maximo) {
                maximo = prestamo.getIdPrestamo();
            }
        }

        proximoIdPrestamo = maximo + 1;
    }

    public void cargarDatos() {

        try {

            libros = ArchivoUtil.cargar("libros.dat");
            socios = ArchivoUtil.cargar("socios.dat");
            prestamos = ArchivoUtil.cargar("prestamos.dat");

            reconstruirMapas();
            actualizarProximoIdPrestamo();

            System.out.println("Datos cargados correctamente.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No fue posible cargar los datos.");
        }
    }

    public void guardarDatos() {

        try {

            ArchivoUtil.guardar("libros.dat", libros);
            ArchivoUtil.guardar("socios.dat", socios);
            ArchivoUtil.guardar("prestamos.dat", prestamos);

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar los datos.");
        }
    }

    public void contarLibrosDisponibles() {

        for (Libro libro : libros.listar()) {
            if (libro.isDisponible()) {
                contadorLibrosDisponibles++;
            }
        }

    }

    public void contarSocios() {

        for (Socio socio : socios.listar()) {
            contadorSocios++;
        }

    }

    public void contarLibros() {

        for (Libro libro : libros.listar()) {
            contadorLibros++;
        }
    }

}
