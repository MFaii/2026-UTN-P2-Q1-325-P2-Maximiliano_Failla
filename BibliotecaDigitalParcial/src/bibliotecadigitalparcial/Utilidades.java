/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecadigitalparcial;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Maxi
 */
public class Utilidades {

    // Pedir entero
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.println(mensaje);

        while (!scanner.hasNextInt()) {
            System.out.println("Error.Debe ingresar un numero entero.");
            scanner.nextLine();
            System.out.println(mensaje);
        }

        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

    // Pedir boolean
    public static boolean pedirBoolean(Scanner scanner, String mensaje) {
        System.out.println(mensaje);

        while (!scanner.hasNextBoolean()) {
            System.out.println("Error. Debe ingresar true/false");
            scanner.nextLine();
            System.out.println(mensaje);
        }

        boolean datoBooleano = scanner.nextBoolean();
        scanner.nextLine();
        return datoBooleano;
    }

    // Pedir entero positivo
    public static int pedirEnteroPositivo(Scanner scanner, String mensaje) {
        int numero;

        do {
            numero = pedirEntero(scanner, mensaje);
            if (numero <= 0) {
                System.out.println("Error. Debe ser mayor a cero(0).");
            }
        } while (numero <= 0);
        return numero;
    }

    // Pedir entero no negativo, permite 0
    public static int pedirEnteroNoNegativo(Scanner scanner, String mensaje) {
        int numero;

        do {
            numero = pedirEntero(scanner, mensaje);
            if (numero < 0) {
                System.out.println("Error. No se permiten negativos.");
            }
        } while (numero < 0);
        return numero;
    }

    // Pedir entero en un rango
    public static int pedirEnteroEnRango(Scanner scanner, String mensaje, int min, int max) {
        int numero;

        do {
            numero = pedirEntero(scanner, mensaje);
            if (numero < min || numero > max) {
                System.out.println("Error.Valor fuera de rango.");
            }
        } while (numero < min || numero > max);
        return numero;
    }

    // Pedir double
    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.println(mensaje);

        while (!scanner.hasNextDouble()) {
            System.out.println("Error. Ingrese un numero decimal.");

            scanner.nextLine();
            System.out.println(mensaje);
        }

        double numero = scanner.nextDouble();
        scanner.nextLine();
        return numero;
    }

    // Pedir double positivo
    public static double pedirDoublePositivo(Scanner scanner, String mensaje) {
        double numero;

        do {
            numero = pedirDouble(scanner, mensaje);

            if (numero <= 0) {
                System.out.println("Error. Debe ser mayor a cero(0)");
            }
        } while (numero <= 0);
        return numero;
    }

    // Pedir double en rango
    public static double pedirDoubleEnRango(Scanner scanner, String mensaje, double min, double max) {
        double numero;

        do {
            numero = pedirDouble(scanner, mensaje);

            if (numero < min || numero > max) {
                System.out.println("Error. Valor fuera de rango.");
            }
        } while (numero < min || numero > max);
        return numero;
    }

    // Pedir texto
    public static String pedirTexto(Scanner scanner, String mensaje) {
        String texto;

        do {
            System.out.println(mensaje);

            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Error. No puede estar vacio.");
            }

        } while (texto.isEmpty());
        return texto;
    }

    // Valirdar S/N menu
    public static boolean validarSN(Scanner scanner, String mensaje) {
        String respuesta;

        do {
            System.out.println(mensaje);

            respuesta = scanner.nextLine();

            if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
                System.out.println("Error. Ingrese S/N.");
            }
        } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
        return respuesta.equalsIgnoreCase("S");
    }

    // Validar opcion del menu
    public static int pedirOpcionMenu(Scanner scanner, int min, int max) {
        int opcion;

        do {
            opcion = pedirEntero(scanner, "Seleccione una opcion: ");

            if (opcion < min || opcion > max) {
                System.out.println("Error. Opcion invalida");
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

    // Validar strings 3 argumentos
    public static boolean validarOpcionTexto3(String texto, String opcion1, String opcion2, String opcion3) {
        return texto.equalsIgnoreCase(opcion1) || texto.equalsIgnoreCase(opcion2) || texto.equalsIgnoreCase(opcion3);
    }

    // Validar strings 2 argumentos
    public static boolean validarOpcionTexto2(String texto, String opcion1, String opcion2) {
        return texto.equalsIgnoreCase(opcion1) || texto.equalsIgnoreCase(opcion2);
    }

    // Pedir char
    public static char pedirChar(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine().charAt(0);
    }

    // Validar genero
    public static char pedirGenero(Scanner scanner, String mensaje) {
        char genero;

        do {
            genero = Character.toUpperCase(pedirChar(scanner, mensaje));

            if (genero != 'M' && genero != 'F' && genero != 'X') {
                System.out.println("Error. Genero invalido.");
            }
        } while (genero != 'M' && genero != 'F' && genero != 'X');
        return genero;
    }

    // Pausa
    public static void pausa(Scanner scanner) {
        System.out.println();
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    // Mostrar titulo
    public static void mostrarTitulo(String titulo) {
        System.out.println();
        System.out.println("------------------------");
        System.out.println(titulo);
        System.out.println("------------------------");

    }

    // Mostrar opcion
    public static void mostrarOpcion(String opcion) {
        System.out.println();
        System.out.println(opcion);
    }

    // Apagado de programa
    public static void apagarPrograma(String opcion) {
        System.out.println();
        System.out.println(opcion);
    }

    // Mostrar listas
    public static <T> void mostrarLista(List<T> lista) {

        if (lista.isEmpty()) {
            System.out.println("No hay elementos para mostrar.");
            return;
        }

        for (T elemento : lista) {
            System.out.println(elemento);
        }
    }

}
