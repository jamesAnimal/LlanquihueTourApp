package data;

// Importaciones.
import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de leer el archivo .txt y agregarlos a una lista dinámica de objetos.
 */
public class GestorDatos {

    /**
     * Método principal que se encarga de abrir un archivo, procesarlo y retornar una
     * lista dinámica de objetos con los datos obtenidos del archivo
     * @param rutaArchivo Ruta del archivo .txt.
     * @return Lista dinámica de objetos.
     */
    public ArrayList<Tour> leerArchivo(String rutaArchivo) {

        ArrayList<Tour> listaDeTours = new ArrayList<>();

        // Try with resources que lee el archivo, si falla la lectura cierra el proceso de manera segura y lanza el error.
        try (BufferedReader bufRed = new BufferedReader(new FileReader(rutaArchivo))) {

            // Ciclo que lee línea por línea el archivo, separa los datos con .split los agrega a diferentes variables
            // cambiando el tipo de variable si es necesario con .parse.
            String linea;
            while ((linea = bufRed.readLine()) != null) {

                String[] partes = linea.split(";");

                if (partes.length == 5) {

                    int codigo = Integer.parseInt(partes[0].trim());
                    String nombre = partes[1].trim();
                    String tipoTour = partes[2].trim();
                    String lugar = partes[3].trim();
                    double valor = Double.parseDouble(partes[4].trim());

                    // Aquí se agregan los datos a un objeto y luego el objeto se agrega a la lista dinámica de objetos.
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