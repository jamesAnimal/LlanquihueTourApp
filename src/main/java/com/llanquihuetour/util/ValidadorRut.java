package com.llanquihuetour.util;

/**
 * Clase para validar el formato del Rut.
 * @author Jaime Seguel.
 */
public class ValidadorRut {

    /**
     * Método que verifica que el Rut no sea nulo, no esté vacío y cumpla con el patrón de 7 u 8 números, un guion y el dígito verificador.
     * @param rut String con el RUT que se desea validar.
     * @return true si el formato es correcto, false si el formato es inválido.
     */
    public static boolean rutValido(String rut) {

        return rut != null && !rut.trim().isEmpty() && rut.matches("[0-9]{7,8}-[0-9kK]");
    }
}
