package model;

/**
 * Clase hija de Persona que define los metodos y atributos de un objeto empleado.
 * @author Jaime Seguel.
 */
public class Empleado extends Persona {

    private String cargo;
    private String turno;
    private int sueldo;

    /**
     * Constructor vacio para inicializar el objeto con los datos por default para luego ser rellenados.
     */
    public Empleado() {

        super();
        this.cargo = "Sin registrar";
        this.turno = "Sin registrar";
        this.sueldo = 0;

    }

    /**
     * Constructor para inicializar el objeto con los datos agregados directamente.
     * @param cargo Cargo del empleado.
     * @param turno Turno del empleado.
     * @param sueldo Sueldo del empleado.
     * @param nombre Nombre del empleado.
     * @param rut Rut del empleado.
     * @param fono Telefono del empleado.
     * @param direccion Direccion del empleado.
     */
    public Empleado(String cargo, String turno, int sueldo, String nombre, String rut, String fono, Direccion direccion) {
        super(nombre, rut, fono, direccion);
        this.cargo = cargo;
        this.turno = turno;
        this.sueldo = sueldo;
    }

    // Metodos setters y getters para crear el flujo de datos con los atributos privados.
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

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    // Metodo .toString para mostrar los atributos de la clase formateados por consola.
    @Override
    public String toString() {
        return "-----Datos del Empleado-----" + "\n"
                + super.toString()
                + "Cargo: " + cargo + "\n"
                + "Turno: " + turno + "\n"
                + "Sueldo: " + sueldo + "\n";

    }

}
