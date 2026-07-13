package com.llanquihuetour.data;

import com.llanquihuetour.model.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar y listar todos los colaboradores y recursos de la agencia.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class GestorEntidades {

    // Declara la lista que va a guardar a las entidades.
    private List<Registrable> listaEntidades;

    /**
     * Crea e inicializa una lista con los diferentes recursos de la agencia.
     * @return Lista con colaboradores y recursos iniciales.
     */
    private List<Registrable> crearEntidadesPrueba() {

        List<Registrable> entidades = new ArrayList<>();

        Direccion dirEmp = new Direccion("Calle uno", "1234", "Puerto Varas", "Región de Los Lagos");
        Direccion dirAsoc = new Direccion("Calle dos", "2345", "Puerto Montt", "Región de Los Lagos");
        Direccion dirGuia = new Direccion("Calle tres", "3456", "Frutillar", "Región de Los Lagos");
        Direccion dirAloj = new Direccion("Calle cuatro", "4567", "Puerto Varas", "Región de Los Lagos");

        entidades.add(new Empleado("Guía Interno", "Diurno", 750000.0, "Sofía Rojas", "12234567-8", "+56912342345", dirEmp));
        entidades.add(new Asociado("Chofer privado", 45000, "Chofer con licencia A2", "José Castro", "13234234-2", "+56923453456", dirAsoc));
        entidades.add(new GuiaTuristico("Pedro Puente", "14123123-1", "+56954326543", dirGuia, "Español, Ingles, Aleman", "Lago Llanquihue, Frutillar", "SERNATUR-4521"));

        entidades.add(new Vehiculo(501, "Hyundai", "H1", 2021, "PPDD55", 9));
        entidades.add(new Alojamiento(601, "Hotel Cabaña del Lago", dirAloj, "+56987557654", "Hotel", 80));

        return entidades;
    }

    /**
     * Constructor que inicializa la lista de entidades con datos de prueba.
     */
    public GestorEntidades() {

        this.listaEntidades = crearEntidadesPrueba();
    }

    /**
     * Agrega una nueva entidad registrable a la colección.
     * @param entidad Objeto que implementa Registrable.
     */
    public void agregarEntidad(Registrable entidad) {

        this.listaEntidades.add(entidad);
    }

    /**
     * Construye un texto con el resumen de las entidades filtradas según el tipo seleccionado.
     * @param filtro Criterio de filtro ("Personas", "Empleado", "Asociado", "Guía Turístico", "Recursos", "Vehículo", "Alojamiento").
     * @return String con la lista formateada de resúmenes.
     */
    public String obtenerResumenEntidades(String filtro) {

        if (listaEntidades.isEmpty()) {

            return "No hay entidades registradas en el sistema.";
        }

        String resumen = "";

        for (Registrable entidad : listaEntidades) {

            if (entidad instanceof Empleado) {

                if (filtro.equals("Personas") || filtro.equals("Empleado")) {

                    resumen += "[EMPLEADO] " + entidad.mostrarResumen() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (entidad instanceof Asociado) {

                if (filtro.equals("Personas") || filtro.equals("Asociado")) {

                    resumen += "[ASOCIADO] " + entidad.mostrarResumen() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (entidad instanceof GuiaTuristico) {

                if (filtro.equals("Personas") || filtro.equals("Guía Turístico")) {

                    resumen += "[GUÍA TURÍSTICO] " + entidad.mostrarResumen() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (entidad instanceof Vehiculo) {

                if (filtro.equals("Recursos") || filtro.equals("Vehículo")) {

                    resumen += "[VEHÍCULO] " + entidad.mostrarResumen() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (entidad instanceof Alojamiento) {

                if (filtro.equals("Recursos") || filtro.equals("Alojamiento")) {

                    resumen += "[ALOJAMIENTO] " + entidad.mostrarResumen() + "\n";
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
