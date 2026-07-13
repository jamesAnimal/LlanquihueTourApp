package com.llanquihuetour.data;

import com.llanquihuetour.model.ServicioTuristico;
import com.llanquihuetour.model.RutaGastronomica;
import com.llanquihuetour.model.PaseoLacustre;
import com.llanquihuetour.model.ExcursionCultural;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase encargada de almacenar y gestionar los servicios turísticos que se ofrecen en la agencia.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class GestorServicios {

    // Declara la lista que va a guardar a las entidades.
    private List<ServicioTuristico> listaServicios;

    /**
     * Crea e inicializa una lista con los distintos servicios turísticos de la agencia.
     * @return Lista de servicios turísticos.
     */
    public List<ServicioTuristico> crearServiciosTuristicos() {

        List<ServicioTuristico> serviciosTuristicos = new ArrayList<>();

        serviciosTuristicos.add(new RutaGastronomica(101, "Ruta del Kuchen", 3.5, "Puerto Varas",
                25000.0, 4, true, "Apto para Celíacos"));

        serviciosTuristicos.add(new RutaGastronomica(102, "Sabores de Llanquihue", 4.0, "Llanquihue",
                35000.0, 5, false, "Sin restricciones"));

        serviciosTuristicos.add(new PaseoLacustre(201, "Navegación al Volcán Osorno", 2.0, "Puerto Varas",
                15000.0, "Catamarán", false, 50));

        serviciosTuristicos.add(new PaseoLacustre(202, "Tour de Pesca en el Lago", 5.0, "Frutillar",
                45000.0, "Lancha a Motor", true, 6));

        serviciosTuristicos.add(new ExcursionCultural(301, "Patrimonio Alemán en Frutillar", 3.0, "Frutillar",
                12000.0, "Teatro del Lago y Museo", "Español e Inglés", true));

        serviciosTuristicos.add(new ExcursionCultural(302, "Mitos y Leyendas de Llanquihue", 2.5, "Llanquihue",
                10000.0, "Casas Patrimoniales", "Español", false));

        return serviciosTuristicos;
    }

    /**
     * Constructor que inicializa la lista de Servicios con datos de prueba.
     */
    public GestorServicios() {

        this.listaServicios = crearServiciosTuristicos();
    }

    /**
     * Agrega un nuevo servicio turístico a la colección.
     * @param servicio Objeto servicio turístico.
     */
    public void agregarServicio(ServicioTuristico servicio) {

        this.listaServicios.add(servicio);
    }

    /**
     * Construye un texto con el resumen de los servicios filtrados según el tipo seleccionado.
     * @param filtro Criterio de filtro ("Todos", "Paseo Lacustre", "Excursión Cultural", "Ruta Gastronómica").
     * @return String con la lista formateada de resúmenes.
     */
    public String obtenerResumenServicios(String filtro) {

        if (this.listaServicios.isEmpty()) {

            return "No hay servicios registrados en el sistema.";
        }

        String resumen = "";

        for (ServicioTuristico servicio : listaServicios) {

            if (servicio instanceof PaseoLacustre) {

                if (filtro.equals("Todos") || filtro.equals("Paseo Lacustre")) {

                    resumen += servicio.toString() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (servicio instanceof ExcursionCultural) {

                if (filtro.equals("Todos") || filtro.equals("Excursión Cultural")) {

                    resumen += servicio.toString() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (servicio instanceof RutaGastronomica) {

                if (filtro.equals("Todos") || filtro.equals("Ruta Gastronómica")) {

                    resumen += servicio.toString() + "\n";
                    resumen += "--------------------------------------------------\n";
                }
            }
        }

        if (resumen.isEmpty()) {

            return "No hay registros para la categoría seleccionada: " + filtro;
        }

        return resumen;
    }
}
