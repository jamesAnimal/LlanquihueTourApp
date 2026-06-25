package model;

/**
 * Clase hija de Persona que define los metodos y atributos de un objeto cliente.
 * @author Jaime Seguel.
 */
public class Cliente extends Persona {

    private String idioma;
    private int edad;
    private String contactoEmergencia;

    /**
     * Constructor vacio para inicializar el objeto con los datos por default para luego ser rellenados.
     */
    public Cliente() {

        super();
        this.idioma = "Sin registrar";
        this.edad = 0;
        this.contactoEmergencia = "Sin registrar";
    }

    /**
     * Constructor para inicializar el objeto con los datos agregados directamente.
     * @param idioma Idioma del cliente.
     * @param edad Edad del cliente.
     * @param contactoEmergencia Contacto de emergencia del cliente en caso de accidente.
     * @param nombre Nombre del cliente.
     * @param rut Rut del cliente.
     * @param fono Telefono del cliente.
     * @param direccion Direccion del cliente.
     */
    public Cliente(String idioma, int edad, String contactoEmergencia, String nombre, String rut, String fono, Direccion direccion) {
        super(nombre, rut, fono, direccion);
        this.idioma = idioma;
        this.edad = edad;
        this.contactoEmergencia = contactoEmergencia;
    }

    // Metodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    // Metodo .toString para mostrar los atributos de la clase formateados por consola.
    @Override
    public String toString() {
        return "-----Datos del Cliente-----" + "\n"
                + super.toString()
                + "Edad: " + edad + "\n"
                + "Idioma: " + idioma + "\n"
                + "Contacto de Emergencia: " + contactoEmergencia + "\n";

    }

}
