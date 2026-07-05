package com.llanquihuetour.data;

import com.llanquihuetour.model.ServicioTuristico;
import com.llanquihuetour.model.RutaGastronomica;
import com.llanquihuetour.model.PaseoLacustre;
import com.llanquihuetour.model.ExcursionCultural;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase encargada de generar los tours de prueba que se ofrecerán en la agencia Llanquihue Tour.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class GestorServicios {

    /**
     * Crea e inicializa una lista con los distintos servicios turísticos que ofrece la agencia.
     * @return Lista de servicios turísticos.
     */
    public List<ServicioTuristico> crearServiciosTuristicos() {
        List<ServicioTuristico> serviciosTuristicos = new ArrayList<>();

        serviciosTuristicos.add(new RutaGastronomica(101, "Ruta del Kuchen y Café", 3.5, "Puerto Varas",
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
}
