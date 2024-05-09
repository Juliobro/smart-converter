package com.juliobro.smartconverter.modules;

import java.util.Scanner;

public class UserInput {
    public double valorAConvertir;
    public String monedaBase;
    public String monedaTarget;
    private static final String[] CODIGOS_MONEDA = {"USD", "EUR", "COP", "BRL", "CLP", "ARS"};

    public String obtenerEleccion(Scanner sc) {
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
