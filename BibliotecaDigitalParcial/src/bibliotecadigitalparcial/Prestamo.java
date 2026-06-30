/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecadigitalparcial;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Maxi
 */
public class Prestamo implements Serializable {

    private int idPrestamo;
    private Libro libro;
    private Socio socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;

    public Prestamo(int idPrestamo, Libro libro, Socio socio) {
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
        this.activo = true;

        libro.setDisponible(false);
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void registrarDevolucion() {
        this.activo = false;
        this.fechaDevolucion = LocalDate.now();
        this.libro.setDisponible(true);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPrestamo());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Prestamo otro = (Prestamo) obj;
        return getIdPrestamo() == otro.getIdPrestamo();
    }

    @Override
    public String toString() {
        return "Prestamo N: " + getIdPrestamo()
                + " | Libro: " + getLibro().getTitulo()
                + " | Socio: " + getSocio().getNombre() + " " + getSocio().getApellido()
                + " | Fecha prestamo: " + getFechaPrestamo()
                + " | Estado: " + (isActivo() ? "Activo" : "Devuelto");
    }
}
