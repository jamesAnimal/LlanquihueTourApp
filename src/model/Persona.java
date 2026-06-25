package model;

import util.RutInvalidoException;
import util.ValidadorRut;

/**
 * Clase padre o Super que define los metodos y atributos mas basicos de los objetos en la empresa.
 * @author Jaime Seguel.
 */
public class Persona {

    private String nombre;
    private String rut;
    private String fono;
    private Direccion direccion;
    
    /**
     * Constructor vacio para inicializar el objeto con los datos por default para luego ser rellenados.
     */
    public Persona() {

        this.nombre = "Sin registrar";
        this.rut = "Sin registrar";
        this.fono = "Sin registrar";
        this.direccion = new Direccion();
    }

    
    /**
     * Constructor para inicializar el objeto con los datos agregados directamente.
     * @param nombre Nombre de la persona.
     * @param rut Rut de la persona.
     * @param fono Telefono de la persona.
     * @param direccion Direccion de la persona, derivado de la clase Direccion.
     */
    public Persona(String nombre, String rut, String fono, Direccion direccion) {

        this.nombre = nombre;
        this.rut = rut;
        this.fono = fono;
        this.direccion = direccion;
    }

    // Metodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    // Metodo .set para el Rut con el manejo del error RutInvalidoException.
    public void setRut(String rut) throws RutInvalidoException {

        if (!ValidadorRut.rutValido(rut)) {
            throw new RutInvalidoException("El RUT ingresado no es valido, intentelo nuevamente.");

        }
        this.rut = rut;

    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // Metodo .toString para mostrar los atributos de la clase formateados por consola.
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"
                + "Rut: " + rut + "\n"
                + "Fono: " + fono + "\n"
                + direccion;

    }

}
