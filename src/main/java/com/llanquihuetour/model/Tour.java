package com.llanquihuetour.model;


/**
 * Clase que define la estructura y atributos de los objetos de tipo Tour.
 * @author Jaime Seguel.
 * @since Semana 4
 */
public class Tour {

    private int codigo;
    private String nombre;
    private String tipoTour;
    private String lugar;
    private double valor;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Tour() {
        this.codigo = 0;
        this.nombre = "Sin registrar.";
        this.tipoTour = "Sin registrar.";
        this.lugar = "Sin registrar.";
        this.valor = 0.0;

    }

    /**
     * Constructor que inicializa un objeto ingresando los parámetros directamente.
     * @param codigo Código del tour.
     * @param nombre Nombre del tour.
     * @param tipoTour Tipo del tour.
     * @param lugar Lugar donde se realiza el tour.
     * @param valor Valor del tour.
     */
    public Tour(int codigo, String nombre, String tipoTour, String lugar, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoTour = tipoTour;
        this.lugar = lugar;
        this.valor = valor;
    }

    // Define los métodos Getter y Setter para obtener y modificar los parámetros encapsulados.
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoTour() {
        return tipoTour;
    }

    public void setTipoTour(String tipoTour) {
        this.tipoTour = tipoTour;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del tour.
     */
    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Tipo de tour: " + tipoTour + "\n" +
                "Lugar: " + lugar + "\n" +
                "Valor: " + valor + "\n";
    }
}
