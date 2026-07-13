package com.llanquihuetour.data;

import com.llanquihuetour.model.Cliente;
import com.llanquihuetour.model.Direccion;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de almacenar y gestionar la lista de clientes registrados de la agencia.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class GestorClientes {

    // Declara la lista que va a guardar a los clientes.
    private List<Cliente> listaClientes;

    /**
     * Crea e inicializa una lista con los diferentes clientes de la agencia.
     * @return Lista con clientes de prueba.
     */
    private List<Cliente> crearClientesPrueba() {

        List<Cliente> clientes = new ArrayList<>();

        Direccion dir1 = new Direccion("Calle principal", "1234", "Puerto Varas", "Región de Los Lagos");
        Direccion dir2 = new Direccion("Avenida sur", "4321", "Santiago", "Región Metropolitana");

        clientes.add(new Cliente("Español", 34, "+56912341234", "Juan Perez", "12345678-9", "+56943214321", dir1));
        clientes.add(new Cliente("Inglés", 28, "+56943214321", "Jhon Smith", "15000123-K", "+56912341234", dir2));

        return clientes;
    }

    /**
     * Constructor que inicializa la lista de clientes con datos de prueba.
     */
    public GestorClientes() {

        this.listaClientes = crearClientesPrueba();
    }

    /**
     * Agrega un nuevo cliente a la colección.
     * @param cliente Objeto cliente ya validado y creado.
     */
    public void agregarCliente(Cliente cliente) {

        this.listaClientes.add(cliente);
    }

    /**
     * Retorna un texto formateado con el listado de todos los clientes para mostrar en la GUI.
     * @return String con la información de todos los clientes.
     */
    public String obtenerResumenClientes() {

        if (this.listaClientes.isEmpty()) {

            return "No hay clientes registrados en el sistema.";
        }

        String resumen = "";

        for (Cliente cliente : listaClientes) {

            resumen += cliente.toString() + "\n";
            resumen += "--------------------------------------------------\n";
        }

        return resumen;
    }
}
