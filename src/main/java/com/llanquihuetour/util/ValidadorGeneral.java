package com.llanquihuetour.util;

import javax.swing.JOptionPane;

/**
 * Clase centralizada para la validación de campos numéricos y el formato del Rut.
 * @author Jaime Seguel
 * @since Semana 8
 */
public class ValidadorGeneral {

    /**
     * Valida que un número guardado en texto represente un número entero positivo mayor a cero.
     * @param texto El número en formato texto ingresado por el usuario.
     * @param nombreCampo El nombre del campo (ej: "Edad", "Sueldo") para el mensaje de error.
     * @return El número validado, o -1 si hubo un error de validación.
     */
    public static int validarEntero(String texto, String nombreCampo) {

        try {

            int numero = Integer.parseInt(texto.trim());

            if (numero <= 0) {

                JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " debe ser mayor a 0.", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                return -1;
            }

            return numero;

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " debe ser un número entero positivo.", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    /**
     * Valida que un número guardado en texto represente un número decimal positivo mayor a cero.
     * @param texto El texto ingresado por el usuario.
     * @param nombreCampo El nombre del campo (ej: "Precio", "Duración") para los mensajes de error.
     * @return El número validado, o -1.0 si hubo un error de validación.
     */
    public static double validarDecimal(String texto, String nombreCampo) {

        try {

            double numero = Double.parseDouble(texto.trim());

            if (numero <= 0.0) {

                JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " debe ser un número decimal positivo", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                return -1.0;
            }

            return numero;

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " debe ser un número decimal válido.", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
            return -1.0;
        }
    }

    /**
     * Método que verifica que el Rut no sea nulo, no esté vacío y cumpla con el patrón de 7 u 8 números, un guion y el dígito verificador.
     * @param rut String con el RUT que se desea validar.
     * @return true si el formato es correcto, false si el formato es inválido.
     */
    public static boolean rutValido(String rut) {

        return rut != null && !rut.trim().isEmpty() && rut.matches("[0-9]{7,8}-[0-9kK]");
    }
}
