package com.llanquihuetour.util;

import com.llanquihuetour.model.Tour;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para buscar tours por etiquetas.
 */
public class BuscadorTours {

    /**
     * Metodo para buscar tours filtrados por etiquetas ingresadas por consola.
     */
    public static void buscarTours(ArrayList<Tour> listaTours, Scanner scan) {

        System.out.println("=== BÚSQUEDA DE TOURS POR ETIQUETAS ===\n");

        // Ciclo que itera el método hasta que el usuario escriba salir.
        String etiqueta = "";

        while (!etiqueta.equals("salir")) {
            System.out.println("Etiquetas disponibles: [todos, naturaleza, cultural, histórico, gastronómico, económicos, premium]");
            System.out.print("Ingrese una etiqueta para buscar (o escriba 'salir' para continuar al registro): ");
            etiqueta = scan.nextLine().trim().toLowerCase();

            // Filtra y muestra los tours según la etiqueta elegida.
            if (!etiqueta.equals("salir")) {
                String resultados = "";

                // Recorre la lista de tours y acumula los tours que coinciden con la etiqueta.
                for (Tour tour : listaTours) {

                    if (etiqueta.equals("todos")) {
                        resultados += tour.toString() + "\n";

                    } else if (tour.getTipoTour().equalsIgnoreCase(etiqueta)) {
                        resultados += tour.toString() + "\n";

                    } else if (etiqueta.equals("economicos") && tour.getValor() <= 20000) {
                        resultados += tour.toString() + "\n";

                    } else if (etiqueta.equals("premium") && tour.getValor() > 20000) {
                        resultados += tour.toString() + "\n";
                    }
                }

                // Muestra la información si el String resultados no está vacía.
                if (!resultados.isEmpty()) {

                    if (etiqueta.equals("todos")) {
                        System.out.println("-----LISTA DE TOURS-----\n\n" + resultados);

                    } else if (etiqueta.equals("economicos")) {
                        System.out.println("-----Tours Económicos-----\n\n" + resultados);

                    } else if (etiqueta.equals("premium")) {
                        System.out.println("-----Tours Premium-----\n\n" + resultados);

                    } else if (etiqueta.equals("naturaleza")) {
                        System.out.println("-----Tours de tipo Naturaleza-----\n\n" + resultados);

                    } else if (etiqueta.equals("cultural")) {
                        System.out.println("-----Tours de tipo Cultural-----\n\n" + resultados);

                    } else if (etiqueta.equals("historico")) {
                        System.out.println("-----Tours de tipo Histórico-----\n\n" + resultados);

                    } else if (etiqueta.equals("gastronomico")) {
                        System.out.println("-----Tours de tipo Gastronómico-----\n\n" + resultados);

                    }
                  // Informa que la etiqueta no es válida si la cadena de texto quedó vacía.
                } else {
                    System.out.println("Etiqueta no válida. Por favor intente con una de la lista.\n");
                }
            }
        }
    }
}
