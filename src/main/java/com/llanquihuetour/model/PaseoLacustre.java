package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase ServicioTuristico para definir los métodos y atributos de un objeto PaseoLacustre.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;
    private int capacidadPasajeros;
    private boolean permitePescar;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public PaseoLacustre() {

        super();
        this.tipoEmbarcacion = "Sin Registrar";
        this.capacidadPasajeros = 0;
        this.permitePescar = false;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código del servicio turístico.
     * @param nombre Nombre del servicio turístico.
     * @param duracionHoras Duración en horas del servicio turístico.
     * @param comuna Comuna en donde se realiza el servicio turístico.
     * @param precio Precio del servicio turístico.
     * @param tipoEmbarcacion Tipo de la embarcación a usar en el servicio turístico.
     * @param permitePescar Si se permite pescar en el servicio turístico o no.
     * @param capacidadPasajeros Capacidad de pasajeros de la embarcación del servicio turístico.
     */
    public PaseoLacustre(int codigo, String nombre, Double duracionHoras, String comuna, Double precio, String tipoEmbarcacion, boolean permitePescar, int capacidadPasajeros) {

        super(codigo, nombre, duracionHoras, comuna, precio);
        this.tipoEmbarcacion = tipoEmbarcacion;
        this.permitePescar = permitePescar;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public boolean isPermitePescar() {
        return permitePescar;
    }

    public void setPermitePescar(boolean permitePescar) {
        this.permitePescar = permitePescar;
    }

    /**
     * Método para promocionar un servicio turístico de tipo Paseo Lacustre.
     * @return Mensaje de promoción.
     */
    @Override
    public String promocionServicio() {

        return "Navega por las hermosas aguas de " +
                super.getComuna() + " en un(a) " + tipoEmbarcacion + ".";
    }

    /**
     * Método para mostrar la información completa de un servicio turístico tipo Paseo Lacustre.
     */
    @Override
    public void mostrarInformacion() {

        System.out.println("===Paseo Lacustre===");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duración Horas: " + getDuracionHoras());
        System.out.println("Comuna: " + getComuna());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Tipo Embarcación: " + getTipoEmbarcacion());
        System.out.println("Capacidad de Pasajeros: " + getCapacidadPasajeros());
        System.out.println("Permite Pescar: " + isPermitePescar());

    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del servicio.
     */
    @Override
    public String toString() {
        return "=====Paseo Lacustre=====" + "\n" +
                super.toString() + "\n" +
                "Tipo de Embarcación: " + tipoEmbarcacion + "\n" +
                "Capacidad de Pasajeros: " + capacidadPasajeros + "\n" +
                "Permite Pescar: " + permitePescar;
    }
}
