package com.llanquihuetour.model;

import com.llanquihuetour.util.RutInvalidoException;
import com.llanquihuetour.util.ValidadorRut;

/**
 * Clase que define los métodos y atributos más básicos de los objetos en la empresa.
 * @author Jaime Seguel.
 */
public class Persona {

    private String nombre;
    private String rut;
    private String fono;
    private Direccion direccion;
    
    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Persona() {

        this.nombre = "Sin registrar";
        this.rut = "Sin registrar";
        this.fono = "Sin registrar";
        this.direccion = new Direccion();
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param nombre Nombre de la persona.
     * @param rut Rut de la persona.
     * @param fono Teléfono de la persona.
     * @param direccion Dirección de la persona, derivado de la clase Dirección.
     */
    public Persona(String nombre, String rut, String fono, Direccion direccion) {

        this.nombre = nombre;
        this.rut = rut;
        this.fono = fono;
        this.direccion = direccion;
    }

    // Define los métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    // Asigna el RUT validando su formato con la clase ValidadorRut y lanza RutInvalidoException si es incorrecto.
    public void setRut(String rut) throws RutInvalidoException {

        if (!ValidadorRut.rutValido(rut)) {
            throw new RutInvalidoException("El RUT ingresado no es válido, inténtelo nuevamente.");
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

    // Formatea y retorna los atributos de la clase para mostrarlos por consola.
    @Override 
    public String toString() {

        return "Nombre: " + nombre + "\n"
                + "Rut: " + rut + "\n"
                + "Fono: " + fono + "\n"
                + direccion;
    }

}
