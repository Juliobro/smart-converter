package com.juliobro.smartconverter;

import com.juliobro.smartconverter.exceptions.InvalidEntryException;
import com.juliobro.smartconverter.handlers.HttpRequestHandler;
import com.juliobro.smartconverter.handlers.JsonHandler;

import java.util.Scanner;

public class Main {
    private static final String[] CODIGOS_MONEDA = {"USD", "EUR", "COP", "BRL", "CLP", "ARS"};

    public static void main(String[] args) {
        int valorAConvertir;
        String monedaBase;
        String monedaTarget;

        Scanner sc = new Scanner(System.in);
        HttpRequestHandler httpHandler = new HttpRequestHandler();
        JsonHandler jsonHandler = new JsonHandler();
        mensajeBienvenida();

        while (true) {
            menuSeleccion();
            System.out.print("Escribe la moneda que deseas convertir: ");
            monedaBase = obtenerEleccion(sc);
            if (monedaBase.equals("0")) {
                System.out.println("Saliendo del programa, gracias por usar.");
                break;
            }

            System.out.print("Ahora escribe la moneda a la que deseas convertir: ");
            monedaTarget = obtenerEleccion(sc);
            if (monedaTarget.equals("0")) {
                System.out.println("Saliendo del programa, gracias por usar.");
                break;
            }

            do {
                System.out.println("Cuál es el valor en " + monedaBase +
                        " que deseas convertir a " + monedaTarget + "?: ");
                String entrada = sc.nextLine();

                try {
                    valorAConvertir = Integer.parseInt(entrada);
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Por favor ingrese un valor numérico válido.");
                }
            } while (true);

            try {
                String json = httpHandler.extraerJson(monedaBase, monedaTarget);
                jsonHandler.verificarValidez(json);
                double tasaDeConversion = jsonHandler.extraerTasaDeConversion(json);
                String valorConvertido = String.format("%.2f", valorAConvertir * tasaDeConversion);

                System.out.println("El valor de " + valorAConvertir + " " + monedaBase +
                        " equivale a " + valorConvertido + " " + monedaTarget);

            } catch (InvalidEntryException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Presiona 1 para hacer más conversiones o 0 para salir.");
            String continuar = sc.nextLine();

            while (!(continuar.equals("0") || continuar.equals("1"))) {
                System.out.println("Por favor selecciona una opción válida");
                continuar = sc.nextLine();
            }

            if (continuar.equals("0")) {
                System.out.println("Saliendo del programa, gracias por usar.");
                break;
            }
        }
        sc.close();
    }

    public static void mensajeBienvenida() {
        System.out.println("""
                 ******************* ¡Bienvenido a Smart Converter! *******************
                                \s
                 A continuación encontrarás la lista de monedas disponibles para
                 convertir en mi aplicación. Simplemente selecciona el número
                 correspondiente o escribe el código de la moneda que desees
                 integrar a la conversión.
                                \s
                 ¡Espero disfrutes la experiencia!
                \s""");
    }

    public static void menuSeleccion() {
        System.out.println("""
                 1: 'USD' (Dólar)
                 2: 'EUR' (Euro)
                 3: 'COP' (Peso colombiano)
                 4: 'BRL' (Real brasileño)
                 5: 'CLP' (Peso chileno)
                 6: 'ARS' (Peso Argentino)
                                    \s
                 Presiona 0 para salir.
                \s""");
    }

    public static String obtenerEleccion(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine();
            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= 0 && opcion <= 6) {
                    return opcion == 0
                            ? entrada
                            : CODIGOS_MONEDA[opcion - 1];
                }
            } catch (NumberFormatException ignored) {
                if (esCodigoMonedaValido(entrada)) {
                    return entrada.toUpperCase();
                }
            }

            System.out.print("Moneda no reconocida. " +
                    "Por favor ingrese un número entre 0 y 6 o el código de la moneda: ");
        }
    }

    private static boolean esCodigoMonedaValido(String entrada) {
        for (String codigo : CODIGOS_MONEDA) {
            if (codigo.equalsIgnoreCase(entrada)) {
                return true;
            }
        }
        return false;
    }
}
