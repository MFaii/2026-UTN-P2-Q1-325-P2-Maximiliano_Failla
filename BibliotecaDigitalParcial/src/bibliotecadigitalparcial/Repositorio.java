/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecadigitalparcial;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Maxi
 */
public class Repositorio<T> implements Serializable {

    private ArrayList<T> elementos;

    public Repositorio() {
        elementos = new ArrayList<>();
    }

    public boolean agregar(T objeto) {
        if (!elementos.contains(objeto)) {
            elementos.add(objeto);
            return true;
        }
        return false;
    }

    public boolean eliminar(T objeto) {
        return elementos.remove(objeto);
    }

    public ArrayList<T> listar() {
        return elementos;
    }
}
