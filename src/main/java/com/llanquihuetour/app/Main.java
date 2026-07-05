package com.llanquihuetour.app;

import com.llanquihuetour.data.GestorDatos;
import com.llanquihuetour.model.Tour;
import com.llanquihuetour.model.Asociado;
import com.llanquihuetour.model.Cliente;
import com.llanquihuetour.model.Direccion;
import com.llanquihuetour.model.Empleado;
import com.llanquihuetour.util.RutInvalidoException;
import com.llanquihuetour.util.BuscadorTours;
import com.llanquihuetour.data.GestorServicios;
import com.llanquihuetour.model.ServicioTuristico;
import com.llanquihuetour.model.RutaGastronomica;
import com.llanquihuetour.model.PaseoLacustre;
import com.llanquihuetour.model.ExcursionCultural;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que contiene la lógica del programa.
 * @author Jaime Seguel.
 * @since Semana 3, 4, 5 y 6.
 */
public class Main {

    /**
     * Método principal que inicia y ejecuta la lógica de la app.
     * @param args
     */
    public static void main(String[] args) {

/*
        // SEMANA 3: Registro de Personal y Clientes.

        // Llama al Scanner.
        Scanner scan = new Scanner(System.in);

        // Inicializa el objeto empleado1 con el constructor completo.
        Direccion direccionEmpleado = new Direccion("Calle Principal", "#1234", "Santiago", "Reg. Metropolitana");
        Empleado empleado1 = new Empleado("Vendedor", "Vespertino", 600000, "Juan Perez", "12345678-8", "+56912345678", direccionEmpleado);

        // Inicializa el objeto asociado1 con el constructor vacío y entrega los datos directos con el método .set.
        Direccion direccionAsociado = new Direccion();
        Asociado asociado1 = new Asociado();

        direccionAsociado.setCalle("Calle Secundaria");
        direccionAsociado.setNumero("#2345");
        direccionAsociado.setCiudad("Puerto Varas");
        direccionAsociado.setRegion("Reg. de Los Lagos");

        asociado1.setServicio("Transporte");
        asociado1.setTarifa(200000);
        asociado1.setObservaciones("El valor es por traslado ida/vuelta");
        asociado1.setNombre("Carlos Cortez");
        asociado1.setFono("+56998768765");
        asociado1.setDireccion(direccionAsociado);

        // Válida el RUT del asociado utilizando un bloque try-catch.
        try {
            asociado1.setRut("14123456-4");

        } catch (RutInvalidoException e) {
            System.out.println(">> Alerta: " + e.getMessage());
        }

        // Inicializa el objeto cliente1 con el constructor vacío y pidiendo los datos por consola.
        Direccion direccionCliente = new Direccion();
        Cliente cliente1 = new Cliente();

        System.out.println("-----REGISTRO DEL CLIENTE-----" + "\n");

        System.out.println("Ingrese los datos del cliente a continuación:");

        System.out.println("Ingrese el nombre del cliente (Nombre+Apellido): ");
        cliente1.setNombre(scan.nextLine());

        // Ciclo while para repetir el ingreso del RUT hasta cumplir con la validación.
        boolean rutValido = true;

        while (rutValido) {

            try {
                System.out.println("Ingrese el Rut del cliente, sin puntos y con guion: ");
                cliente1.setRut(scan.nextLine());
                rutValido = false;

            } catch (RutInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Ingrese el teléfono del cliente (Ej:+56912345678): ");
        cliente1.setFono(scan.nextLine());

        System.out.println("Ingrese el idioma del cliente: ");
        cliente1.setIdioma(scan.nextLine());

        System.out.println("Ingrese la edad del cliente: ");
        cliente1.setEdad(scan.nextInt());

        scan.nextLine();

        System.out.println("Ingrese el número de contacto de emergencia (Ej:+56912345678): ");
        cliente1.setContactoEmergencia(scan.nextLine());

        System.out.println("Ingrese la calle de residencia: ");
        direccionCliente.setCalle(scan.nextLine());

        System.out.println("Ingrese el número de residencia: ");
        direccionCliente.setNumero(scan.nextLine());

        System.out.println("Ingrese la ciudad de residencia: ");
        direccionCliente.setCiudad(scan.nextLine());

        System.out.println("Ingrese la región de residencia: ");
        direccionCliente.setRegion(scan.nextLine());

        cliente1.setDireccion(direccionCliente);

        // Imprime los datos almacenados.
        System.out.println("\n----- DATOS ALMACENADOS EXITOSAMENTE -----\n");

        System.out.println(empleado1.toString());

        System.out.println(asociado1.toString());

        System.out.println(cliente1.toString());


        // SEMANA 4: Carga de Tours desde Archivo.

        // Llama a la clase GestorDatos para leer el archivo .txt y guarda la lectura en una lista dinámica de objetos.
        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> listaTours = gestor.leerArchivo("src/main/resources/tours.txt");


        // SEMANA 5: Búsqueda Interactiva y Contratación.

        // Ejecuta la búsqueda interactiva de tours usando la clase BuscadorTours.
        BuscadorTours.buscarTours(listaTours, scan);

        // Muestra los tours cargados para que el usuario elija un código y lo asocie al cliente.
        System.out.println("\nTours disponibles para contratar:");

        for (Tour tour : listaTours) {
            System.out.println("Código: " + tour.getCodigo() + " | " + tour.getNombre());
        }

        System.out.println("Ingrese el código del tour que desea contratar para el cliente (0 para ninguno): ");
        int codigoTour = scan.nextInt();

        scan.nextLine();

        // Busca el código seleccionado entre todos los Tours y lo guarda como objeto en cliente1.
        if (codigoTour != 0) {

            for (Tour tour : listaTours) {

                if (tour.getCodigo() == codigoTour) {
                    cliente1.setTourContratado(tour);
                }
            }
        }

        // Imprime los datos de contratación actualizados.
        System.out.println("\n----- DATOS DE CONTRATACIÓN ACTUALIZADOS (SEMANA 5) -----\n");

        System.out.println(cliente1.toString());

        scan.close();


        // SEMANA 6: Servicios Turísticos Especializados.

        // Se crea un objeto de GestorServicios para poder llamar al método crearServiciosTuristicos.
        GestorServicios gestorServicios = new GestorServicios();

        // Se crea una lista para guardar lo que retorna el método crearServiciosTuristicos.
        List<ServicioTuristico> listaDeServicios = gestorServicios.crearServiciosTuristicos();

        // Se recorre la lista y se imprimen los tours uno por uno.
        System.out.println("\n" + "=====Servicios Turisticos=====" + "\n");

        for (ServicioTuristico servicio : listaDeServicios) {
            System.out.println("Promoción: " + servicio.promocionServicio());

            System.out.println(servicio + "\n");

        }
*/

        // SEMANA 7: Aplicando polimorfismo y colecciones genéricas.

        // Se crea un objeto de GestorServicios para poder llamar al método crearServiciosTuristicos.
        GestorServicios gestorServicios = new GestorServicios();

        // Se crea una lista para guardar lo que retorna el método crearServiciosTuristicos.
        List<ServicioTuristico> listaDeServicios = gestorServicios.crearServiciosTuristicos();

        // Ciclo para recorrer la lista y buscar objetos específicos usando instanceOF.
        for (ServicioTuristico servicio : listaDeServicios) {

            if (servicio instanceof RutaGastronomica) {

                RutaGastronomica ruta = (RutaGastronomica) servicio;
                System.out.println("===Ruta Gastronómica===");
                System.out.println("Número de Paradas: " + ruta.getNumeroDeParadas()); //Downcasting.

            } else if (servicio instanceof PaseoLacustre) {

                PaseoLacustre paseo = (PaseoLacustre) servicio;
                System.out.println("===Paseo Lacustre===");
                System.out.println("Tipo de Embarcación: " + paseo.getTipoEmbarcacion()); //Downcasting.

            } else if (servicio instanceof ExcursionCultural) {

                ExcursionCultural excursion = (ExcursionCultural) servicio;
                System.out.println("===Excursión Cultural===");
                System.out.println("Lugar Histórico: " + excursion.getLugarHistorico()); //Downcasting.
            }

            // Se muestra el servicio ya identificado con el instanceOf usando el metodo mostrarInformacion.
            servicio.mostrarInformacion();
            System.out.println("\n");
        }

    }
}