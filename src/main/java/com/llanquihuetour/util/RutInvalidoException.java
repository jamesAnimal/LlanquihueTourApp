package com.llanquihuetour.util;

/**
 * Clase que crea una Exception para manejar el error del formato del Rut.
 * @author Jaime Seguel.
 * @since Semana 3
 */
public class RutInvalidoException extends Exception {
    
    /**
     * Constructor de la Exception. 
     * @param mensaje Mensaje con información del error.
     */
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}