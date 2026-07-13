package com.llanquihuetour.model;

/**
 * Interfaz que define el contrato común para todas las entidades registrables.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public interface Registrable {

    /**
     * Método que retorna un resumen de los datos de la entidad.
     * @return Texto con el resumen de la entidad.
     */
    public String mostrarResumen();

}
