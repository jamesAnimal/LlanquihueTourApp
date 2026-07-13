package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase abstracta Persona e implementa la interfaz Registrable
 * para definir los métodos y atributos de un objeto Empleado.
 * @author Jaime Seguel.
 * @since Semana 3
 */
public class Empleado extends Persona implements Registrable {

    private String cargo;
    private String turno;
    private Double sueldo;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Empleado() {

        super();
        this.cargo = "Sin registrar";
        this.turno = "Sin registrar";
        this.sueldo = 0.0;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param cargo Cargo del empleado.
     * @param turno Turno del empleado.
     * @param sueldo Sueldo del empleado.
     * @param nombre Nombre del empleado.
     * @param rut Rut del empleado.
     * @param fono Teléfono del empleado.
     * @param direccion Dirección del empleado, derivado de la clase Dirección.
     */
    public Empleado(String cargo, String turno, Double sueldo, String nombre, String rut, String fono, Direccion direccion) {

        super(nombre, rut, fono, direccion);
        this.cargo = cargo;
        this.turno = turno;
        this.sueldo = sueldo;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Método implementado desde Registrable.
     * @return String con resumen del objeto.
     */
    @Override
    public String mostrarResumen() {

        return "Empleado: " + getNombre() + " (RUT: " + getRut() + ") | Cargo: " + cargo + " | Sueldo: $" + sueldo;
    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del empleado.
     */
    @Override
    public String toString() {

        return "-----Datos del Empleado-----" + "\n"
                + super.toString()
                + "Cargo: " + cargo + "\n"
                + "Turno: " + turno + "\n"
                + "Sueldo: " + sueldo + "\n";
    }

}
