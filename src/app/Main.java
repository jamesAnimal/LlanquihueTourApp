package app;

import data.GestorDatos;
import model.Tour;

import java.util.ArrayList;

/**
 * Clase principal que contiene la lógica del programa.
 */
public class Main {

    /**
     * Método principal que inicia y ejecuta la lógica.
     */
    public static void main(String[] args) {

        // Se llama a la clase GestorDatos para leer el .txt y guardamos la lectura en una lista dinámica de objetos.
        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> listaTours = gestor.leerArchivo("resources/tours.txt");

        System.out.println("-----LISTA DE TOURS-----" + "\n");

        // Bucle para recorrer la lista e imprimir todos sus objetos.
        for (Tour tour : listaTours) {

            System.out.println(tour);

        }

        System.out.println("-----Tours de tipo Naturaleza-----" + "\n");

        // Bucle para recorrer la lista y separar los tours de tipo "Naturaleza".
        for (Tour tour : listaTours) {

            if (tour.getTipoTour().equals("Naturaleza")) {

                System.out.println(tour);
            }
        }

        System.out.println("-----Tours Economicos-----" + "\n");

        // Bucle para recorrer la lista y separar los tours económicos, es decir, que tengan un valor igual o menor a 20000.
        for (Tour tour : listaTours) {

            if (tour.getValor() <= 20000) {

                System.out.println(tour);
            }

        }

        System.out.println("-----Tours Premium-----" + "\n ");

        // Bucle para recorrer la lista y separar los tours Premium, es decir, que tengan un valor mayor a 20000.
        for (Tour tour : listaTours) {

            if (tour.getValor() > 20000) {

                System.out.println(tour);

            }
        }
    }
}
