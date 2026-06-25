package util;

/**
 * Clase para validar el formato del Rut.
 * @author Jaime Seguel.
 */
public class ValidadorRut {

/**
     * Metodo que verifica que el Rut no sea nulo, no este vacio y cumpla con el patron de 7 u 8 numeros, un guion y el digito verificador.
     * @param rut String con el RUT que se desea validar.
     * @return true si el formato es correcto, false si el formato es invalido.
     */
    public static boolean rutValido(String rut) {

        return rut != null && !rut.trim().isEmpty() && rut.matches("[0-9]{7,8}-[0-9kK]");

    }

}
