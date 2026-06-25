package util;

/**
 * Clase que crea una Exception para manejar el error del formato del Rut.
 * @author Jaime Seguel.
 */
public class RutInvalidoException extends Exception {
    
    /**
     * Constructor de la Exception. 
     * @param mensaje Mensaje con informacion del error.
     */
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}