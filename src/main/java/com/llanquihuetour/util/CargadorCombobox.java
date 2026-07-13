package com.llanquihuetour.util;

import javax.swing.JComboBox;

/**
 * Clase para centralizar la carga de datos en los combobox de la interfaz.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class CargadorCombobox {

    /**
     * Carga todas las regiones en el combobox especificado.
     * @param cmbRegion El JComboBox donde se cargarán las regiones.
     */
    public static void cargarRegiones(JComboBox<String> cmbRegion) {

        cmbRegion.addItem("Región de Arica y Parinacota");
        cmbRegion.addItem("Región de Tarapacá");
        cmbRegion.addItem("Región de Antofagasta");
        cmbRegion.addItem("Región de Atacama");
        cmbRegion.addItem("Región de Coquimbo");
        cmbRegion.addItem("Región de Valparaíso");
        cmbRegion.addItem("Región Metropolitana");
        cmbRegion.addItem("Región de O'Higgins");
        cmbRegion.addItem("Región del Maule");
        cmbRegion.addItem("Región del Ñuble");
        cmbRegion.addItem("Región del Biobío");
        cmbRegion.addItem("Región de La Araucanía");
        cmbRegion.addItem("Región de Los Ríos");
        cmbRegion.addItem("Región de Los Lagos");
        cmbRegion.addItem("Región de Aysén");
        cmbRegion.addItem("Magallanes y la Antártica Chilena");
    }

    /**
     * Limpia y carga las ciudades correspondientes a la región seleccionada.
     * @param region El nombre de la región seleccionada.
     * @param cmbCiudad El JComboBox donde se cargarán las ciudades.
     */
    public static void actualizarCiudades(String region, JComboBox<String> cmbCiudad) {

        cmbCiudad.removeAllItems();

        if ("Región de Arica y Parinacota".equals(region)) {

            cmbCiudad.addItem("Arica");
            cmbCiudad.addItem("Putre");
            cmbCiudad.addItem("Camarones");

        } else if ("Región de Tarapacá".equals(region)) {

            cmbCiudad.addItem("Iquique");
            cmbCiudad.addItem("Alto Auspicio");
            cmbCiudad.addItem("Tamarugal");

        } else if ("Región de Antofagasta".equals(region)) {

            cmbCiudad.addItem("Antofagasta");
            cmbCiudad.addItem("Calama");
            cmbCiudad.addItem("Tocopilla");

        } else if ("Región de Atacama".equals(region)) {

            cmbCiudad.addItem("Copiapó");
            cmbCiudad.addItem("Vallenar");
            cmbCiudad.addItem("Caldera");

        } else if ("Región de Coquimbo".equals(region)) {

            cmbCiudad.addItem("La Serena");
            cmbCiudad.addItem("Coquimbo");
            cmbCiudad.addItem("Ovalle");

        } else if ("Región de Valparaíso".equals(region)) {

            cmbCiudad.addItem("Valparaíso");
            cmbCiudad.addItem("Viña del Mar");
            cmbCiudad.addItem("San Antonio");
            cmbCiudad.addItem("Los Andes");

        } else if ("Región Metropolitana".equals(region)) {

            cmbCiudad.addItem("Santiago");
            cmbCiudad.addItem("Puente Alto");
            cmbCiudad.addItem("Maipú");
            cmbCiudad.addItem("La Florida");

        } else if ("Región de O'Higgins".equals(region)) {

            cmbCiudad.addItem("Rancagua");
            cmbCiudad.addItem("San Fernando");
            cmbCiudad.addItem("Pichilemu");

        } else if ("Región del Maule".equals(region)) {

            cmbCiudad.addItem("Talca");
            cmbCiudad.addItem("Curicó");
            cmbCiudad.addItem("Linares");

        } else if ("Región del Ñuble".equals(region)) {

            cmbCiudad.addItem("Chillán");
            cmbCiudad.addItem("San Carlos");
            cmbCiudad.addItem("Bulnes");

        } else if ("Región del Biobío".equals(region)) {

            cmbCiudad.addItem("Concepción");
            cmbCiudad.addItem("Los Ángeles");
            cmbCiudad.addItem("Talcahuano");

        } else if ("Región de La Araucanía".equals(region)) {

            cmbCiudad.addItem("Temuco");
            cmbCiudad.addItem("Villarrica");
            cmbCiudad.addItem("Pucón");
            cmbCiudad.addItem("Angol");

        } else if ("Región de Los Ríos".equals(region)) {

            cmbCiudad.addItem("Valdivia");
            cmbCiudad.addItem("La Unión");
            cmbCiudad.addItem("Panguipulli");

        } else if ("Región de Los Lagos".equals(region)) {

            cmbCiudad.addItem("Puerto Montt");
            cmbCiudad.addItem("Osorno");
            cmbCiudad.addItem("Castro");

        } else if ("Región de Aysén".equals(region)) {

            cmbCiudad.addItem("Coyhaique");
            cmbCiudad.addItem("Puerto Aysén");
            cmbCiudad.addItem("Chile Chico");

        } else if ("Magallanes y la Antártica Chilena".equals(region)) {

            cmbCiudad.addItem("Punta Arenas");
            cmbCiudad.addItem("Puerto Natales");
            cmbCiudad.addItem("Porvenir");
        }
    }

    /**
     * Carga los tipos de personal en el combobox especificado.
     * @param cmb El JComboBox donde se cargarán los tipos.
     */
    public static void cargarTiposPersonal(JComboBox<String> cmb) {

        cmb.removeAllItems();
        cmb.addItem("Empleado");
        cmb.addItem("Asociado");
        cmb.addItem("Guía Turístico");
    }

    /**
     * Carga los filtros de personal en el combobox especificado.
     * @param cmb El JComboBox donde se cargarán los filtros.
     */
    public static void cargarFiltrosPersonal(JComboBox<String> cmb) {

        cmb.removeAllItems();
        cmb.addItem("Todos");
        cmb.addItem("Empleado");
        cmb.addItem("Asociado");
        cmb.addItem("Guía Turístico");
    }

    /**
     * Carga los tipos de recurso físico en el combobox especificado.
     * @param cmb El JComboBox donde se cargarán los tipos.
     */
    public static void cargarTiposRecurso(JComboBox<String> cmb) {

        cmb.removeAllItems();
        cmb.addItem("Vehículo");
        cmb.addItem("Alojamiento");
    }

    /**
     * Carga los filtros de recurso físico en el combobox especificado.
     * @param cmb El JComboBox donde se cargarán los filtros.
     */
    public static void cargarFiltrosRecurso(JComboBox<String> cmb) {

        cmb.removeAllItems();
        cmb.addItem("Todos");
        cmb.addItem("Vehículo");
        cmb.addItem("Alojamiento");
    }

    /**
     * Carga los tipos de servicio en el combobox especificado.
     * @param cmb El JComboBox donde se cargarán los tipos.
     */
    public static void cargarTiposServicio(JComboBox<String> cmb) {

        cmb.removeAllItems();
        cmb.addItem("Paseo Lacustre");
        cmb.addItem("Excursión Cultural");
        cmb.addItem("Ruta Gastronómica");
    }

    /**
     * Carga los filtros de servicio en el combobox especificado.
     * @param cmb El JComboBox donde se cargarán los filtros.
     */
    public static void cargarFiltrosServicio(JComboBox<String> cmb) {

        cmb.removeAllItems();
        cmb.addItem("Todos");
        cmb.addItem("Paseo Lacustre");
        cmb.addItem("Excursión Cultural");
        cmb.addItem("Ruta Gastronómica");
    }

    /**
     * Carga opciones de Sí/No en el combobox especificado.
     * @param cmb El JComboBox donde se cargarán las opciones.
     */
    public static void cargarOpcionesSiNo(JComboBox<String> cmb) {

        cmb.removeAllItems();
        cmb.addItem("Sí");
        cmb.addItem("No");
    }
}
