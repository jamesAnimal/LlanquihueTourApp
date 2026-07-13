package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorServicios;
import com.llanquihuetour.model.*;
import com.llanquihuetour.util.ValidadorGeneral;
import com.llanquihuetour.util.CargadorCombobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase que representa la interfaz gráfica de la ventana Servicios.
 *
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class VentanaServicios extends JFrame {

    private JFrame ventanaPrincipal;
    private GestorServicios gestorServicios = new GestorServicios();

    // Elementos de la ventana.
    private JPanel panelPrincipalServicios = new JPanel();
    private JLabel lblInstruccionesServicios1 = new JLabel();
    private JLabel lblInstruccionesServicios2 = new JLabel();
    private JLabel lblTipo = new JLabel();
    private JComboBox<String> cmbTipo = new JComboBox<>();
    private JLabel lblCodigo = new JLabel();
    private JTextField txtCodigo = new JTextField();
    private JLabel lblNombre = new JLabel();
    private JTextField txtNombre = new JTextField();
    private JLabel lblDuracion = new JLabel();
    private JTextField txtDuracion = new JTextField();
    private JLabel lblComuna = new JLabel();
    private JTextField txtComuna = new JTextField();
    private JLabel lblPrecio = new JLabel();
    private JTextField txtPrecio = new JTextField();
    private JLabel lblEspecifico1 = new JLabel();
    private JTextField txtEspecifico1 = new JTextField();
    private JLabel lblEspecifico2 = new JLabel();
    private JTextField txtEspecifico2 = new JTextField();
    private JLabel lblEspecifico3 = new JLabel();
    private JComboBox<String> cmbEspecifico3 = new JComboBox<>();
    private JButton btnRegistrar = new JButton();
    private JPanel panelFiltro = new JPanel();
    private JLabel lblFiltro = new JLabel();
    private JComboBox<String> cmbFiltro = new JComboBox<>();
    private JTextArea txtAreaServicios = new JTextArea();
    private JButton btnVolver = new JButton();


    /**
     * Constructor de la ventana Servicios.
     */
    public VentanaServicios(JFrame ventanaPrincipal) {

        this.ventanaPrincipal = ventanaPrincipal;
        setContentPane(panelPrincipalServicios);
        setTitle("Llanquihue Tour - Gestión de Servicios");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Carga opciones en los comboboxes usando la clase utilitaria.
        CargadorCombobox.cargarTiposServicio(cmbTipo);
        CargadorCombobox.cargarFiltrosServicio(cmbFiltro);
        CargadorCombobox.cargarOpcionesSiNo(cmbEspecifico3);

        // Carga labels específicas al inicio según el tipo por defecto.
        actualizarLabels();

        // Hace el cambio visual de los campos (labels) según el servicio seleccionado.
        cmbTipo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                actualizarLabels();
            }
        });

        // Carga los servicios iniciales en pantalla.
        txtAreaServicios.setText(gestorServicios.obtenerResumenServicios("Todos"));

        // Actualiza la lista de servicios en pantalla según el filtro seleccionado.
        cmbFiltro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                txtAreaServicios.setText(gestorServicios.obtenerResumenServicios((String) cmbFiltro.getSelectedItem()));
            }
        });

        // Botón para registrar un nuevo servicio turístico.
        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String tipo = (String) cmbTipo.getSelectedItem();
                String codigoStr = txtCodigo.getText().trim();
                String nombre = txtNombre.getText().trim();
                String duracionStr = txtDuracion.getText().trim();
                String comuna = txtComuna.getText().trim();
                String precioStr = txtPrecio.getText().trim();
                String contenidoEspacio1 = txtEspecifico1.getText().trim();
                String contenidoEspacio2String = txtEspecifico2.getText().trim();
                String contenidoEspacio3combx = (String) cmbEspecifico3.getSelectedItem();

                // Valida que no haya campos vacíos.
                if (codigoStr.isEmpty() || nombre.isEmpty() || duracionStr.isEmpty() || comuna.isEmpty() ||
                        precioStr.isEmpty() || contenidoEspacio1.isEmpty() || contenidoEspacio2String.isEmpty() || contenidoEspacio3combx == null) {

                    JOptionPane.showMessageDialog(VentanaServicios.this, "Por favor, complete todos los campos del formulario.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Valida código.
                int codigo = ValidadorGeneral.validarEntero(codigoStr, "Código");
                if (codigo == -1) return;

                // Valida duración.
                double duracion = ValidadorGeneral.validarDecimal(duracionStr, "Duración en Horas");
                if (duracion == -1.0) return;

                // Valida precio.
                double precio = ValidadorGeneral.validarDecimal(precioStr, "Precio");
                if (precio == -1.0) return;

                // Convierte la opción de texto en un Boolean.
                boolean espacio3Boolean = "Sí".equals(contenidoEspacio3combx);

                // Crea y registra el servicio específico según la selección del usuario.
                if ("Paseo Lacustre".equals(tipo)) {

                    int capacidadPasajeros = ValidadorGeneral.validarEntero(contenidoEspacio2String, "Capacidad Pasajeros");
                    if (capacidadPasajeros == -1) return;
                    PaseoLacustre paseo = new PaseoLacustre(codigo, nombre, duracion, comuna, precio, contenidoEspacio1, espacio3Boolean, capacidadPasajeros);
                    gestorServicios.agregarServicio(paseo);
                    txtAreaServicios.setText(gestorServicios.obtenerResumenServicios((String) cmbFiltro.getSelectedItem()));
                    JOptionPane.showMessageDialog(VentanaServicios.this, "Servicio turístico registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

                } else if ("Excursión Cultural".equals(tipo)) {

                    ExcursionCultural excursion = new ExcursionCultural(codigo, nombre, duracion, comuna, precio, contenidoEspacio1, contenidoEspacio2String, espacio3Boolean);
                    gestorServicios.agregarServicio(excursion);
                    txtAreaServicios.setText(gestorServicios.obtenerResumenServicios((String) cmbFiltro.getSelectedItem()));
                    JOptionPane.showMessageDialog(VentanaServicios.this, "Servicio turístico registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

                } else if ("Ruta Gastronómica".equals(tipo)) {

                    int paradas = ValidadorGeneral.validarEntero(contenidoEspacio1, "Número de Paradas");
                    if (paradas == -1) return;
                    RutaGastronomica ruta = new RutaGastronomica(codigo, nombre, duracion, comuna, precio, paradas, espacio3Boolean, contenidoEspacio2String);
                    gestorServicios.agregarServicio(ruta);
                    txtAreaServicios.setText(gestorServicios.obtenerResumenServicios((String) cmbFiltro.getSelectedItem()));
                    JOptionPane.showMessageDialog(VentanaServicios.this, "Servicio turístico registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }

                // Limpia los campos del formulario.
                txtCodigo.setText("");
                txtNombre.setText("");
                txtDuracion.setText("");
                txtComuna.setText("");
                txtPrecio.setText("");
                txtEspecifico1.setText("");
                txtEspecifico2.setText("");
                cmbEspecifico3.setSelectedIndex(0);
                cmbTipo.setSelectedIndex(0);
            }

        });

        // Retorna a la ventana principal al cerrar la ventana actual.
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                if (ventanaPrincipal != null) {
                    ventanaPrincipal.setVisible(true);
                }
            }
        });

        // Botón para volver al menú principal.
        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaServicios.this.dispose();

                if (ventanaPrincipal != null) {

                    ventanaPrincipal.setVisible(true);
                }
            }
        });
    }

    /**
     * Actualiza el texto de las 3 labels específicas según el tipo de servicio turístico seleccionado.
     */
    private void actualizarLabels() {

        String seleccion = (String) cmbTipo.getSelectedItem();

        if ("Paseo Lacustre".equals(seleccion)) {

            lblEspecifico1.setText("Tipo Embarcación:");
            lblEspecifico2.setText("Capacidad Pasajeros:");
            lblEspecifico3.setText("¿Permite Pescar?:");

        } else if ("Excursión Cultural".equals(seleccion)) {

            lblEspecifico1.setText("Lugar Histórico:");
            lblEspecifico2.setText("Idioma Guía:");
            lblEspecifico3.setText("¿Incluye Entradas?:");

        } else if ("Ruta Gastronómica".equals(seleccion)) {

            lblEspecifico1.setText("Número de Paradas:");
            lblEspecifico2.setText("Condición Alimentaria:");
            lblEspecifico3.setText("¿Opción Vegetariana?:");
        }

        // Refresca la interfaz gráfica para aplicar los cambios visuales.
        revalidate();
        repaint();
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelPrincipalServicios = new JPanel();
        panelPrincipalServicios.setLayout(new GridBagLayout());
        panelPrincipalServicios.setMaximumSize(new Dimension(800, 600));
        panelPrincipalServicios.setMinimumSize(new Dimension(800, 600));
        panelPrincipalServicios.setPreferredSize(new Dimension(800, 600));
        lblInstruccionesServicios1 = new JLabel();
        lblInstruccionesServicios1.setText("Gestión de Servicios Turísticos");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 2, 10);
        panelPrincipalServicios.add(lblInstruccionesServicios1, gbc);
        lblInstruccionesServicios2 = new JLabel();
        lblInstruccionesServicios2.setText("Complete el formulario superior para registrar y visualice la lista abajo.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(2, 10, 10, 10);
        panelPrincipalServicios.add(lblInstruccionesServicios2, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);
        panelPrincipalServicios.add(panel1, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 10, 5);
        panel1.add(panel2, gbc);
        lblTipo = new JLabel();
        lblTipo.setText("Tipo Servicio:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(lblTipo, gbc);
        cmbTipo = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 150);
        panel2.add(cmbTipo, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(panel3, gbc);
        lblCodigo = new JLabel();
        lblCodigo.setText("Código:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblCodigo, gbc);
        txtCodigo = new JTextField();
        txtCodigo.setToolTipText("Ejemplo: 101");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtCodigo, gbc);
        lblNombre = new JLabel();
        lblNombre.setText("Nombre:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblNombre, gbc);
        txtNombre = new JTextField();
        txtNombre.setToolTipText("Ejemplo: Ruta del Kuchen");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtNombre, gbc);
        lblDuracion = new JLabel();
        lblDuracion.setText("Duración (Horas):");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblDuracion, gbc);
        txtDuracion = new JTextField();
        txtDuracion.setToolTipText("Ejemplo: 3.5");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtDuracion, gbc);
        lblComuna = new JLabel();
        lblComuna.setText("Comuna:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblComuna, gbc);
        txtComuna = new JTextField();
        txtComuna.setToolTipText("Ejemplo: Puerto Varas");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtComuna, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(panel4, gbc);
        lblPrecio = new JLabel();
        lblPrecio.setText("Precio ($):");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel4.add(lblPrecio, gbc);
        txtPrecio = new JTextField();
        txtPrecio.setToolTipText("Ejemplo: 25000");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel4.add(txtPrecio, gbc);
        lblEspecifico1 = new JLabel();
        lblEspecifico1.setText("Especifico 1:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel4.add(lblEspecifico1, gbc);
        txtEspecifico1 = new JTextField();
        txtEspecifico1.setToolTipText("Ejemplo: Catamarán");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel4.add(txtEspecifico1, gbc);
        lblEspecifico2 = new JLabel();
        lblEspecifico2.setText("Especifico 2:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel4.add(lblEspecifico2, gbc);
        txtEspecifico2 = new JTextField();
        txtEspecifico2.setToolTipText("Ejemplo: 50");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel4.add(txtEspecifico2, gbc);
        lblEspecifico3 = new JLabel();
        lblEspecifico3.setText("Especifico 3:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel4.add(lblEspecifico3, gbc);
        cmbEspecifico3 = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel4.add(cmbEspecifico3, gbc);
        btnRegistrar = new JButton();
        btnRegistrar.setText("Registrar Servicio");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 10, 5, 10);
        panelPrincipalServicios.add(btnRegistrar, gbc);
        panelFiltro = new JPanel();
        panelFiltro.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);
        panelPrincipalServicios.add(panelFiltro, gbc);
        lblFiltro = new JLabel();
        lblFiltro.setText("Filtrar por Tipo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelFiltro.add(lblFiltro, gbc);
        cmbFiltro = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelFiltro.add(cmbFiltro, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);
        panelPrincipalServicios.add(scrollPane1, gbc);
        txtAreaServicios = new JTextArea();
        txtAreaServicios.setEditable(false);
        scrollPane1.setViewportView(txtAreaServicios);
        btnVolver = new JButton();
        btnVolver.setText("<- Volver al Menú Principal");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 10, 15, 10);
        panelPrincipalServicios.add(btnVolver, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelPrincipalServicios;
    }

}
