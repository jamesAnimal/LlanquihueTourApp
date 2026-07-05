package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase ServicioTuristico para definir los métodos y atributos de un objeto ExcursionCultural.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;
    private String idiomaGuia;
    private boolean incluyeEntradas;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public ExcursionCultural() {

        super();
        this.lugarHistorico = "Sin Registrar";
        this.idiomaGuia = "Sin Registrar";
        this.incluyeEntradas = false;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código del servicio turístico.
     * @param nombre Nombre del servicio turístico.
     * @param duracionHoras Duración en horas del servicio turístico.
     * @param comuna Comuna en donde se realiza el servicio turístico.
     * @param precio Precio del servicio turístico.
     * @param lugarHistorico Lugar histórico a visitar en el servicio turístico.
     * @param idiomaGuia Idiomas que maneja el guía del servicio turístico.
     * @param incluyeEntradas Si el servicio turístico incluye las entradas a los lugares históricos o no.
     */
    public ExcursionCultural(int codigo, String nombre, Double duracionHoras, String comuna, Double precio, String lugarHistorico, String idiomaGuia, boolean incluyeEntradas) {

        super(codigo, nombre, duracionHoras, comuna, precio);
        this.lugarHistorico = lugarHistorico;
        this.idiomaGuia = idiomaGuia;
        this.incluyeEntradas = incluyeEntradas;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    public String getIdiomaGuia() {
        return idiomaGuia;
    }

    public void setIdiomaGuia(String idiomaGuia) {
        this.idiomaGuia = idiomaGuia;
    }

    public boolean isIncluyeEntradas() {
        return incluyeEntradas;
    }

    public void setIncluyeEntradas(boolean incluyeEntradas) {
        this.incluyeEntradas = incluyeEntradas;
    }

    /**
     * Método para promocionar un servicio turístico de tipo Excursion Cultural.
     * @return Mensaje de promoción.
     */
    @Override
    public String promocionServicio() {

        return "Explora la historia y el patrimonio local en " +
                lugarHistorico + " (" + super.getComuna() + ").";
    }

    /**
     * Método para mostrar la información completa de un servicio turístico tipo Excursión Cultural.
     */
    @Override
    public void mostrarInformacion() {

        System.out.println("===Excursión Cultural===");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duración Horas: " + getDuracionHoras());
        System.out.println("Comuna: " + getComuna());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Lugar Histórico: " + getLugarHistorico());
        System.out.println("Idioma Guía: " + getIdiomaGuia());
        System.out.println("Incluye Entradas: " + isIncluyeEntradas());

    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del servicio.
     */
    @Override
    public String toString() {
        return "=====Excursión Cultural=====" + "\n" +
                super.toString() + "\n" +
                "Lugar Histórico: " + lugarHistorico + "\n" +
                "Idiomas del Guía: " + idiomaGuia + "\n" +
                "Incluye Entradas: " + incluyeEntradas;
    }
}
