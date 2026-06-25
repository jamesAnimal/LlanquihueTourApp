package com.llanquihuetour.data;

import com.llanquihuetour.model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que gestiona los datos de un archivo .txt.
 */
public class GestorDatos {

    /**
     * Metodo que abre el archivo, procesa cada línea y retorna una lista dinámica con los objetos creados.
     * @param rutaArchivo Ruta del archivo .txt.
     * @return Lista dinámica de objetos.
     */
    public ArrayList<Tour> leerArchivo(String rutaArchivo) {

        ArrayList<Tour> listaDeTours = new ArrayList<>();

        // Abre y lee el archivo, manejando errores de lectura de forma segura.
        try (BufferedReader bufRed = new BufferedReader(new FileReader(rutaArchivo))) {

            // Lee el archivo línea por línea, separa los datos y los convierte a sus tipos correspondientes.
            String linea;
            while ((linea = bufRed.readLine()) != null) {

                String[] partes = linea.split(";");

                if (partes.length == 5) {

                    int codigo = Integer.parseInt(partes[0].trim());
                    String nombre = partes[1].trim();
                    String tipoTour = partes[2].trim();
                    String lugar = partes[3].trim();
                    double valor = Double.parseDouble(partes[4].trim());

                    // Crea el objeto Tour y lo agrega a la lista dinámica.
                    Tour tour = new Tour(codigo, nombre, tipoTour, lugar, valor);
                    listaDeTours.add(tour);

                }

            }

        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());

        }

        return listaDeTours;

    }

}