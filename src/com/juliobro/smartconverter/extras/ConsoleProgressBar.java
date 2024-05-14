package com.juliobro.smartconverter.extras;

public class ConsoleProgressBar {
    //This method will simulate the operation of a progress bar solely for the purpose of enhancing
    //the user experience. It doesn't assess any actual connection or calculation progress.

    public static void ProgressBar() {
        int duracionBucle = 2000; //Set loop duration in milliseconds
        int numIteraciones = 50; //Set progress bar length (quantity of "|")
        long tiempoEspera = duracionBucle / numIteraciones;

        for (int i = 0; i <= numIteraciones; i++) {
            int progreso = i * 100 / numIteraciones;

            System.out.print("\rProcesando: [");
            for (int j = 0; j < i; j++) {
                System.out.print("|");
            }

            for (int j = i; j < numIteraciones; j++) {
                System.out.print(" ");
            }
            System.out.print("] " + progreso + "%");

            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
