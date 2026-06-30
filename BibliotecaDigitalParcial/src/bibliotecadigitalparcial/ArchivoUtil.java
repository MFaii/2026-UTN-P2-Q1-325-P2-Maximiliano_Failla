/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecadigitalparcial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Maxi
 */
public class ArchivoUtil {

    public static <T> void guardar(String archivo, T objeto) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo));

        salida.writeObject(objeto);
        salida.close();
    }

    public static <T> T cargar(String archivo) throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));

        T objeto = (T) entrada.readObject();
        entrada.close();

        return objeto;
    }
}
