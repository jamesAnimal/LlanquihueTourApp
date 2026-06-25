package model;

/**
 * Clase creada para manejar los datos de la direccion de una persona.
 * @author Jaime Seguel.
 */
public class Direccion {

    private String calle;
    private String numero;
    private String ciudad;
    private String region;

    /**
     * Constructor vacio para inicializar el objeto con los datos por default para luego ser rellenados.
     */
    public Direccion() {

        this.calle = "Sin registrar";
        this.numero = "Sin registrar";
        this.ciudad = "Sin registrar";
        this.region = "Sin registrar";
    }

    /**
     * Constructor para inicializar el objeto con los datos agregados directamente.
     * @param calle Calle de residencia de la persona.
     * @param numero Numero de residencia de la persona.
     * @param ciudad Ciudad de residencia de la persona.
     * @param region Region de residencia de la persona.
     */
    public Direccion(String calle, String numero, String ciudad, String region) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.region = region;
    }

    // Metodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    // Metodo .toString para mostrar los atributos de la clase formateados por consola.
    @Override
    public String toString() {
        return "Calle: " + calle + "\n"
                + "Numero: " + numero + "\n"
                + "Ciudad: " + ciudad + "\n"
                + "Region: " + region + "\n";

    }

}
