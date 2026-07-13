package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase abstracta Persona para definir los métodos y atributos de un objeto cliente.
 * @author Jaime Seguel.
 * @since Semana 3
 */
public class Cliente extends Persona {

    private String idioma;
    private int edad;
    private String contactoEmergencia;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Cliente() {

        super();
        this.idioma = "Sin registrar";
        this.edad = 0;
        this.contactoEmergencia = "Sin registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param idioma Idioma del cliente.
     * @param edad Edad del cliente.
     * @param contactoEmergencia Contacto de emergencia del cliente en caso de accidente.
     * @param nombre Nombre del cliente.
     * @param rut Rut del cliente.
     * @param fono Teléfono del cliente.
     * @param direccion Dirección del cliente, derivado de la clase Dirección.
     */
    public Cliente(String idioma, int edad, String contactoEmergencia, String nombre, String rut, String fono, Direccion direccion) {

        super(nombre, rut, fono, direccion);
        this.idioma = idioma;
        this.edad = edad;
        this.contactoEmergencia = contactoEmergencia;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
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

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del cliente.
     */
    @Override
    public String toString() {
        
        return "-----Datos del Cliente-----" + "\n"
                + super.toString()
                + "Edad: " + edad + "\n"
                + "Idioma: " + idioma + "\n"
                + "Contacto de Emergencia: " + contactoEmergencia + "\n";

    }

}
