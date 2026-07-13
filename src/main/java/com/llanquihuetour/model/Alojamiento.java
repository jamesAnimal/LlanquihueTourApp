package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase abstracta RecursoFisico e implementa
 * la interfaz Registrable para definir los métodos y atributos de un objeto alojamiento.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class Alojamiento extends RecursoFisico implements Registrable {

    private Direccion direccion;
    private String telefono;
    private String tipoAlojamiento;
    private int capacidadHuespedes;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Alojamiento() {

        super();
        this.direccion = new Direccion();
        this.telefono = "Sin Registrar";
        this.tipoAlojamiento = "Sin Registrar";
        this.capacidadHuespedes = 0;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código identificador del alojamiento.
     * @param nombre Nombre del alojamiento.
     * @param direccion Dirección del alojamiento.
     * @param telefono Teléfono del alojamiento.
     * @param tipoAlojamiento Tipo del alojamiento.
     * @param capacidadHuespedes Capacidad de huéspedes del alojamiento.
     */
    public Alojamiento(int codigo, String nombre, Direccion direccion, String telefono, String tipoAlojamiento, int capacidadHuespedes) {

        super(codigo, nombre);
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAlojamiento = tipoAlojamiento;
        this.capacidadHuespedes = capacidadHuespedes;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getNombre() {
        return super.getNombre();
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public int getCapacidadHuespedes() {
        return capacidadHuespedes;
    }

    public void setCapacidadHuespedes(int capacidadHuespedes) {
        this.capacidadHuespedes = capacidadHuespedes;
    }

    /**
     * Método implementado desde Registrable.
     * @return String con resumen del objeto.
     */
    @Override
    public String mostrarResumen() {

        return "Nombre: " + getNombre() + " Teléfono: " + telefono + " Tipo: " + tipoAlojamiento + " Capacidad: " + capacidadHuespedes;
    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del alojamiento.
     */
    @Override
    public String toString() {

        return "-----Alojamiento-----" + "\n"
                + super.toString()
                + "Dirección: " + direccion + "\n"
                + "Teléfono: " + telefono + "\n"
                + "Tipo de Alojamiento: " + tipoAlojamiento + "\n"
                + "Capacidad de Huéspedes: " + capacidadHuespedes + "\n";
    }
}
