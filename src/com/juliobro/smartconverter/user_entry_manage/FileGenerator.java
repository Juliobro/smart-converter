package com.juliobro.smartconverter.user_entry_manage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileGenerator {
    private final List<String> REGISTROS = new ArrayList<>();

    public void agregarRegistro(double valorAConvertir, String valorConvertido, String monedaBase, String monedaTarget) {
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("El valor de " + valorAConvertir + " " + monedaBase +
                " equivale a " + valorConvertido + " " + monedaTarget);

        REGISTROS.add(hora.format(formatter) + ": Haz convertido " + valorAConvertir + " " + monedaBase +
                " a " + valorConvertido + " " +  monedaTarget);
    }

    public void generarArchivo() throws IOException {
        try (FileWriter fl = new FileWriter("conversiones.txt")) {
            for (String registro : REGISTROS) {
                fl.write(registro + System.lineSeparator());
            }
        }
    }
}
