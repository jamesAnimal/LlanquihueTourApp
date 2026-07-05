package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase ServicioTuristico para definir los métodos y atributos de un objeto RutaGastronomica.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class RutaGastronomica extends ServicioTuristico {

    private int numeroDeParadas;
    private boolean opcionVegetariana;
    private String condicionAlimentaria;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public RutaGastronomica() {

        super();
        this.numeroDeParadas = 0;
        this.opcionVegetariana = false;
        this.condicionAlimentaria = "Sin Registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código del servicio turístico.
     * @param nombre Nombre del servicio turístico.
     * @param duracionHoras Duración en horas del servicio turístico.
     * @param comuna Comuna en donde se realiza el servicio turístico.
     * @param precio Precio del servicio turístico.
     * @param numeroDeParadas Número de locales que va a recorrer el servicio turístico.
     * @param opcionVegetariana Si el servicio turístico tiene opción vegetariana o no.
     * @param condicionAlimentaria Qué condiciones de salud alimentaria tiene el servicio turístico.
     */
    public RutaGastronomica(int codigo, String nombre, Double duracionHoras, String comuna, Double precio, int numeroDeParadas, boolean opcionVegetariana, String condicionAlimentaria) {
        super(codigo, nombre, duracionHoras, comuna, precio);
        this.numeroDeParadas = numeroDeParadas;
        this.opcionVegetariana = opcionVegetariana;
        this.condicionAlimentaria = condicionAlimentaria;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroParadas) {
        this.numeroDeParadas = numeroParadas;
    }

    public boolean isOpcionVegetariana() {
        return opcionVegetariana;
    }

    public void setOpcionVegetariana(boolean opcionVegetariana) {
        this.opcionVegetariana = opcionVegetariana;
    }

    public String getCondicionAlimentaria() {
        return condicionAlimentaria;
    }

    public void setCondicionAlimentaria(String condicionAlimentaria) {
        this.condicionAlimentaria = condicionAlimentaria;
    }

    /**
     * Método para promocionar un servicio turístico de tipo RutaGastronomica.
     * @return Mensaje de promoción.
     */
    @Override
    public String promocionServicio() {

        return "Disfruta de la gastronomía local en " +
                super.getComuna() + ". Visitando " +
                numeroDeParadas + " paradas culinarias.";
    }

    /**
     * Método para mostrar la información completa de un servicio turístico tipo Ruta Gastronómica.
     */
    @Override
    public void mostrarInformacion() {

        System.out.println("===Ruta Gastronómica===");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duración Horas: " + getDuracionHoras());
        System.out.println("Comuna: " + getComuna());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Número de Paradas: " + getNumeroDeParadas());
        System.out.println("Opción Vegetariana: " + isOpcionVegetariana());
        System.out.println("Condición Alimentaria: " + getCondicionAlimentaria());

    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del servicio.
     */
    @Override
    public String toString() {
        return  "=====Ruta Gastronómica=====" + "\n" +
                super.toString() + "\n" +
                "Número de Paradas: " + numeroDeParadas + "\n" +
                "Opción Vegetariana: " + opcionVegetariana + "\n" +
                "Condición Alimentaria: " + condicionAlimentaria;
    }
}


