package model;

/**
 * Clase hija de Persona que define los metodos y atributos de un objeto asociado.
 * @author Jaime Seguel.
 */
public class Asociado extends Persona {

    private String servicio;
    private int tarifa;
    private String observaciones;

    /**
     * Constructor vacio para inicializar el objeto con los datos por default para luego ser rellenados.
     */
    public Asociado() {

        super();
        this.servicio = "Sin registrar";
        this.tarifa = 0;
        this.observaciones = "Sin registrar";

    }

    /**
     * Constructor para inicializar el objeto con los datos agregados directamente.
     * @param servicio Servicio que entrega el asociado.
     * @param tarifa Tarifa del servicio del asociado
     * @param observaciones Observaciones sobre el servicio del asociado.
     * @param nombre Nombre del asociado.
     * @param rut Rut del asociado.
     * @param fono Telefono del asociado.
     * @param direccion Direccion del asociado.
     */
    public Asociado(String servicio, int tarifa, String observaciones, String nombre, String rut, String fono, Direccion direccion) {
        super(nombre, rut, fono, direccion);
        this.servicio = servicio;
        this.tarifa = tarifa;
        this.observaciones = observaciones;
    }

    // Metodos setters y getters para crear el flujo de datos con los atributos privados.
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

    // Metodo .toString para mostrar los atributos de la clase formateados por consola.
    @Override
    public String toString() {
        return "-----Datos del Asociado-----" + "\n"
                + super.toString()
                + "Servicio: " + servicio + "\n"
                + "Tarifa: " + tarifa + "\n"
                + "Observaciones: " + observaciones + "\n";
    }

}
