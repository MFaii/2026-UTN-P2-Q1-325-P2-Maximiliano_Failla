/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecadigitalparcial;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Maxi
 */
public class Libro implements Serializable {

    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
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
        Libro otro = (Libro) obj;
        return getCodigo().equals(otro.getCodigo());
    }

    @Override
    public String toString() {
        return "Codigo: " + getCodigo()
                + " | Titulo: " + getTitulo()
                + " | Autor: " + getAutor()
                + " | Anio: " + getAnioPublicacion()
                + " | Disponible: " + (isDisponible() ? "Si" : "No");
    }
}
