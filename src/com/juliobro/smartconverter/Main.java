package com.juliobro.smartconverter;

import com.juliobro.smartconverter.exceptions.InvalidInputException;
import com.juliobro.smartconverter.extras.ConsoleProgressBar;
import com.juliobro.smartconverter.handlers.HttpRequestHandler;
import com.juliobro.smartconverter.handlers.JsonHandler;
import com.juliobro.smartconverter.user_entry_manage.FileGenerator;
import com.juliobro.smartconverter.user_entry_manage.UserInput;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HttpRequestHandler httpHandler = new HttpRequestHandler();
        JsonHandler jsonHandler = new JsonHandler();
        FileGenerator archivo = new FileGenerator();
        UserInput userInput = new UserInput();

        mensajeBienvenida();

        while (true) {
            menuSeleccion();
            System.out.print("Escribe la moneda que deseas convertir: ");
            userInput.monedaBase = userInput.obtenerEleccion(sc);
            String monedaBase = userInput.monedaBase;
            if (monedaBase.equals("0")) {
                System.out.println("Saliendo del programa, gracias por usar.");
                break;
            }

            System.out.print("Ahora escribe la moneda a la que deseas convertir: ");
            userInput.monedaTarget = userInput.obtenerEleccion(sc);
            String monedaTarget = userInput.monedaTarget;
            if (monedaTarget.equals("0")) {
                System.out.println("Saliendo del programa, gracias por usar.");
                break;
            }

            do {
                System.out.println("Cuál es el valor en " + monedaBase +
                        " que deseas convertir a " + monedaTarget + "?: ");
                String entrada = sc.nextLine();

                try {
                    userInput.valorAConvertir = Double.parseDouble(entrada);
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Por favor ingrese un valor numérico válido.");
                }
            } while (true);

            try {
                String json = httpHandler.extraerJson(monedaBase, monedaTarget);
                jsonHandler.verificarValidez(json);
                double tasaDeConversion = jsonHandler.extraerTasaDeConversion(json);

                double valorAConvertir = userInput.valorAConvertir;
                String valorConvertido = String.format("%.2f", valorAConvertir * tasaDeConversion);
                ConsoleProgressBar.ProgressBar();
                archivo.agregarRegistro(valorAConvertir, valorConvertido, monedaBase, monedaTarget);
                System.out.println();

            } catch (InvalidInputException e) {
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
        archivo.generarArchivo();
        System.out.println("Se ha guardado el registro de tus conversiones en 'conversiones.txt'");
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
}
