package com.llanquihuetour.app;

import com.llanquihuetour.ui.VentanaBienvenida;

import javax.swing.*;

/**
 * Clase principal que inicializa la interfaz gráfica.
 * @author Jaime Seguel.
 * @since Semana 8.
 */
public class Main {

    /**
     * Método que inicia y ejecuta la ventana de bienvenida.
     */
    public static void main(String[] args) {

        new VentanaBienvenida().setVisible(true);

    }
}