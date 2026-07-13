package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase abstracta RecursoFisico e implementa
 * la interfaz Registrable para definir los métodos y atributos de un objeto vehículo.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class Vehiculo extends RecursoFisico implements Registrable {

    private String marca;
    private String modelo;
    private int anio;
    private String patente;
    private int capacidadPasajeros;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Vehiculo() {

        super();
        this.marca = "Sin Registrar";
        this.modelo = "Sin Registrar";
        this.anio = 0;
        this.patente = "Sin Registrar";
        this.capacidadPasajeros = 0;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código identificador del vehículo.
     * @param marca Marca del vehículo.
     * @param modelo Modelo del vehículo.
     * @param anio Año del vehículo.
     * @param patente Patente del vehículo.
     * @param capacidadPasajeros Cantidad de pasajeros que tiene el vehículo.
     */
    public Vehiculo(int codigo, String marca, String modelo, int anio, String patente, int capacidadPasajeros) {

        super(codigo, marca + " " + modelo);
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    /**
     * Método implementado desde Registrable.
     * @return String con resumen del objeto.
     */
    @Override
    public String mostrarResumen() {

        return "Marca: " + marca + " Modelo: " + modelo + " Año: " + anio + " Capacidad Pasajeros: " + capacidadPasajeros;
    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del vehículo.
     */
    @Override
    public String toString() {

        return "-----Vehículo-----" + "\n"
                + super.toString()
                + "Año: " + anio + "\n"
                + "Patente: " + patente + "\n"
                + "Capacidad de Pasajeros: " + capacidadPasajeros + "\n";
    }
}
