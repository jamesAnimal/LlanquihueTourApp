package app;

import model.Asociado;
import model.Cliente;
import model.Direccion;
import model.Empleado;
import model.Persona;
import util.RutInvalidoException;
import util.ValidadorRut;
import java.util.Scanner;

/**
 * Clase principal que inicia el programa.
 * @author Jaime Seguel.
 */
public class Main {

    /**
     * Metodo principal que ejecuta la logica de registro de datos y luego los imprime por consola.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Inicializacion del Objeto empleado1 con el constructor completo.
        Direccion direccionEmpleado = new Direccion("Calle Principal", "#1234", "Santiago", "Reg. Metropolitana");
        Empleado empleado1 = new Empleado("Vendedor", "Vespertino", 600000, "Juan Perez", "12345678-8", "+56912345678", direccionEmpleado);

        // Inicializacion del Objeto asociado1 con el constructor vacio y entregando los dato directos con el metodo .set.
        Direccion direccionAsociado = new Direccion();
        Asociado asociado1 = new Asociado();

        direccionAsociado.setCalle("Calle Secundaria");
        direccionAsociado.setNumero("#2345");
        direccionAsociado.setCiudad("Arica");
        direccionAsociado.setRegion("Reg. Arica y Parinacota");

        asociado1.setServicio("Transporte");
        asociado1.setTarifa(200000);
        asociado1.setObservaciones("El valor es por traslado ida/vuelta");
        asociado1.setNombre("Carlos Cortez");
        asociado1.setFono("+56998768765");
        asociado1.setDireccion(direccionAsociado);

        // Try-catch para validar el Rut.
        try {

            asociado1.setRut("14123456-4");

        } catch (RutInvalidoException e) {

            System.out.println(">> Alerta: " + e.getMessage());
        }

        // Inicializacion del Objeto cliente1 con el constructor vacio, pidiendo los datos por consola y agregandolos con el metodo .set.
        Direccion direccionCliente = new Direccion();
        Cliente cliente1 = new Cliente();
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese los datos del cliente a continuacion.");

        System.out.println("Ingrese el nombre del cliente (Nombre+Apellido): ");
        cliente1.setNombre(scan.nextLine());

        // Ciclo While para repetir el ingreso del Rut hasta que cumpla con la validacion.
        while (true) {

            try {
                System.out.println("Ingrese el Rut del cliente, sin puntos y con guion: ");
                cliente1.setRut(scan.nextLine());
                break;

            } catch (RutInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Ingrese el telefono del cliente (Ej:+56912345678): ");
        cliente1.setFono(scan.nextLine());

        System.out.println("Ingrese el idioma del cliente: ");
        cliente1.setIdioma(scan.nextLine());

        System.out.println("Ingrese la edad del cliente: ");
        cliente1.setEdad(scan.nextInt());
        scan.nextLine();

        System.out.println("Ingrese el numero de contacto de emergencia del cliente (Ej:+56912345678): ");
        cliente1.setContactoEmergencia(scan.nextLine());

        System.out.println("Ingrese la calle de residencia: ");
        direccionCliente.setCalle(scan.nextLine());

        System.out.println("Ingrese el numero de residencia: ");
        direccionCliente.setNumero(scan.nextLine());

        System.out.println("Ingrese la ciudad de residencia: ");
        direccionCliente.setCiudad(scan.nextLine());

        System.out.println("Ingrese la region de residencia: ");
        direccionCliente.setRegion(scan.nextLine());

        cliente1.setDireccion(direccionCliente);

        // Teniendo todos los datos ya listos, aca se imprimen por consola.
        System.out.println("\n----- DATOS ALMACENADOS EXITOSAMENTE -----\n");

        System.out.println(empleado1.toString());
        System.out.println(asociado1.toString());
        System.out.println(cliente1.toString());

        scan.close();

    }

}
