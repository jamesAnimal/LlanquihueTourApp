package model;

/**
 * Clase modelo para crear objetos de tipo Tour.
 */
public class Tour {

    // Atributos del objeto tour.
    private int codigo;
    private String nombre;
    private String tipoTour;
    private String lugar;
    private double valor;

    /**
     * Constructor sin parámetros para instanciar un objeto "en blanco".
     */
    public Tour() {
        this.codigo = 0;
        this.nombre = "Sin registrar.";
        this.tipoTour = "Sin registrar.";
        this.lugar = "Sin registrar.";
        this.valor = 0.0;

    }

    /**
     * Constructor con parámetros para instanciar un objeto ingresando los parámetros directo en el constructor.
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

    // Métodos Getter y Setter para poder obtener y modificar parámetros encapsulados.
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

    // Método que ordena y da formato a la información del objeto para ser mostrada por consola.
    @Override
    public String toString() {
        return "Codigo: " + codigo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Tipo de tour: " + tipoTour + "\n" +
                "Lugar: " + lugar + "\n" +
                "Valor: " + valor + "\n";
    }
}
