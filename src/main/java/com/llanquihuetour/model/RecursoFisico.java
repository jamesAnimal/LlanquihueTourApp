package com.llanquihuetour.model;

/**
 * Clase que define los métodos y atributos más básicos de los recursos físicos en la empresa.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public abstract class RecursoFisico {

    private int codigo;
    private String nombre;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public RecursoFisico() {

        this.codigo = 0;
        this.nombre = "Sin registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código del recurso.
     * @param nombre Nombre del recurso.
     */
    public RecursoFisico(int codigo, String nombre) {

        this.codigo = codigo;
        this.nombre = nombre;
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

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos del recurso.
     */
    @Override
    public String toString() {

        return "Código: " + codigo + "\n"
                + "Nombre: " + nombre + "\n";
    }
}
