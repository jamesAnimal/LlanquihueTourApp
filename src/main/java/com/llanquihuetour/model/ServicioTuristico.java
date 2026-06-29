package com.llanquihuetour.model;

/**
 * Clase que define los métodos y atributos más básicos de los servicios turísticos en la empresa.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class ServicioTuristico {

    private int codigo;
    private String nombre;
    private Double duracionHoras;
    private String comuna;
    private Double precio;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public ServicioTuristico() {

        this.codigo = 0;
        this.nombre = "Sin Registrar";
        this.duracionHoras = 0.0;
        this.comuna = "Sin Registrar";
        this.precio = 0.0;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código del servicio turístico.
     * @param nombre Nombre del servicio turístico.
     * @param duracionHoras Duración del servicio turístico.
     * @param comuna Comuna en donde se desarrolla el servicio turístico.
     * @param precio Precio del servicio turístico.
     */
    public ServicioTuristico(int codigo, String nombre, Double duracionHoras, String comuna, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.comuna = comuna;
        this.precio = precio;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
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

    public Double getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Método para promocionar un servicio turístico.
     * @return Mensaje de promoción.
     */
    public String promocionServicio() {

        return "Promoción del servicio turístico " + nombre + ".";
    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del servicio.
     */
    @Override
    public String toString() {
        return  "Código de Tour: " + codigo + "\n" +
                "Nombre del Tour: " + nombre + "\n" +
                "Duración en Horas: " + duracionHoras + "\n" +
                "Comuna en donde se desarrolla: " + comuna + "\n" +
                "Precio de Tour: " + precio;
    }
}
