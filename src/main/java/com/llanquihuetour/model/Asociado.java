package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase abstracta Persona e implementa la interfaz Registrable
 * para definir los métodos y atributos de un objeto Asociado.
 * @author Jaime Seguel.
 * @since Semana 3
 */
public class Asociado extends Persona implements Registrable {

    private String servicio;
    private int tarifa;
    private String observaciones;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Asociado() {

        super();
        this.servicio = "Sin registrar";
        this.tarifa = 0;
        this.observaciones = "Sin registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param servicio Servicio que entrega el asociado.
     * @param tarifa Tarifa del servicio del asociado.
     * @param observaciones Observaciones sobre el servicio del asociado.
     * @param nombre Nombre del asociado.
     * @param rut Rut del asociado.
     * @param fono Teléfono del asociado.
     * @param direccion Dirección del asociado, derivado de la clase Dirección.
     */
    public Asociado(String servicio, int tarifa, String observaciones, String nombre, String rut, String fono, Direccion direccion) {

        super(nombre, rut, fono, direccion);
        this.servicio = servicio;
        this.tarifa = tarifa;
        this.observaciones = observaciones;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Método implementado desde Registrable.
     * @return String con resumen del objeto.
     */
    @Override
    public String mostrarResumen() {

        return "Asociado: " + getNombre() + " (RUT: " + getRut() + ") | Servicio: " + servicio + " | Tarifa: $" + tarifa;
    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del asociado.
     */
    @Override
    public String toString() {

        return "-----Datos del Asociado-----" + "\n"
                + super.toString()
                + "Servicio: " + servicio + "\n"
                + "Tarifa: " + tarifa + "\n"
                + "Observaciones: " + observaciones + "\n";
    }

}
