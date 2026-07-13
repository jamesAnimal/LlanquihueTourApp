package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorClientes;
import com.llanquihuetour.model.Cliente;
import com.llanquihuetour.model.Direccion;
import com.llanquihuetour.util.CargadorCombobox;
import com.llanquihuetour.util.RutInvalidoException;
import com.llanquihuetour.util.ValidadorGeneral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase que representa la interfaz gráfica de la ventana Clientes.
 *
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class VentanaCliente extends JFrame {

    private JFrame ventanaPrincipal;
    private GestorClientes gestorClientes = new GestorClientes();

    // Elementos de la ventana.
    private JPanel panelPrincipalCliente = new JPanel();
    private JLabel lblInstruccionesCliente1 = new JLabel();
    private JLabel lblInstruccionesCliente2 = new JLabel();
    private JLabel lblNombre = new JLabel();
    private JTextField txtNombre = new JTextField();
    private JLabel lblRut = new JLabel();
    private JTextField txtRut = new JTextField();
    private JLabel lblTelefono = new JLabel();
    private JTextField txtTelefono = new JTextField();
    private JLabel lblEdad = new JLabel();
    private JTextField txtEdad = new JTextField();
    private JLabel lblIdiona = new JLabel();
    private JTextField txtIdioma = new JTextField();
    private JLabel lblContacto = new JLabel();
    private JTextField txtContacto = new JTextField();
    private JLabel lblRegion = new JLabel();
    private JComboBox<String> cmbRegion = new JComboBox<>();
    private JLabel lblCiudad = new JLabel();
    private JComboBox<String> cmbCiudad = new JComboBox<>();
    private JLabel lblCalle = new JLabel();
    private JTextField txtCalle = new JTextField();
    private JLabel lblNumero = new JLabel();
    private JTextField txtNumero = new JTextField();
    private JButton btnRegistrar = new JButton();
    private JTextArea txtAreaClientes = new JTextArea();
    private JButton btnVolver = new JButton();

    /**
     * Constructor de la ventana Cliente.
     */
    public VentanaCliente(JFrame ventanaPrincipal) {

        this.ventanaPrincipal = ventanaPrincipal;
        setContentPane(panelPrincipalCliente);
        setTitle("Llanquihue Tour - Registro de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Carga regiones en el combobox Región usando la clase utilitaria.
        CargadorCombobox.cargarRegiones(cmbRegion);

        // Carga las ciudades iniciales correspondientes al primer elemento del combobox.
        cmbRegion.setSelectedIndex(0);

        // Carga las ciudades en el combobox Ciudad dependiendo de la region elegida.
        cmbRegion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String region = (String) cmbRegion.getSelectedItem();
                CargadorCombobox.actualizarCiudades(region, cmbCiudad);
            }
        });

        // Carga el listado inicial de clientes de prueba.
        txtAreaClientes.setText(gestorClientes.obtenerResumenClientes());

        // Botón para registrar un nuevo cliente.
        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = txtNombre.getText().trim();
                String rut = txtRut.getText().trim();
                String fono = txtTelefono.getText().trim();
                String edadStr = txtEdad.getText().trim();
                String idioma = txtIdioma.getText().trim();
                String contacto = txtContacto.getText().trim();
                String calle = txtCalle.getText().trim();
                String numero = txtNumero.getText().trim();
                String region = (String) cmbRegion.getSelectedItem();
                String ciudad = (String) cmbCiudad.getSelectedItem();

                // Valida que no haya campos obligatorios vacíos.
                if (nombre.isEmpty() || rut.isEmpty() || fono.isEmpty() || edadStr.isEmpty() || calle.isEmpty() ||
                        numero.isEmpty() || region == null || region.isEmpty() || ciudad == null || ciudad.isEmpty()) {

                    JOptionPane.showMessageDialog(VentanaCliente.this, "Por favor, complete todos los campos del formulario.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Valida la edad.
                int edad = ValidadorGeneral.validarEntero(edadStr, "Edad");
                if (edad == -1) return;

                // Crea la dirección.
                Direccion direccion = new Direccion(calle, numero, ciudad, region);

                // Crea el cliente y valida el RUT.
                Cliente cliente = new Cliente(idioma, edad, contacto, nombre, "11111111-1", fono, direccion);

                try {

                    cliente.setRut(rut);

                } catch (RutInvalidoException ex) {

                    JOptionPane.showMessageDialog(VentanaCliente.this, "Error de Validación: " + ex.getMessage(), "RUT Inválido", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Agrega el cliente a la lista del gestor y actualiza el listado en pantalla.
                gestorClientes.agregarCliente(cliente);
                txtAreaClientes.setText(gestorClientes.obtenerResumenClientes());

                // Muestra mensaje de registro exitoso.
                JOptionPane.showMessageDialog(VentanaCliente.this, "Cliente registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

                // Limpia los campos del formulario.
                txtNombre.setText("");
                txtRut.setText("");
                txtTelefono.setText("");
                txtEdad.setText("");
                txtIdioma.setText("");
                txtContacto.setText("");
                txtCalle.setText("");
                txtNumero.setText("");
                cmbRegion.setSelectedIndex(0);
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

                VentanaCliente.this.dispose();

                if (ventanaPrincipal != null) {

                    ventanaPrincipal.setVisible(true);
                }
            }
        });

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
        panelPrincipalCliente = new JPanel();
        panelPrincipalCliente.setLayout(new GridBagLayout());
        panelPrincipalCliente.setMaximumSize(new Dimension(800, 600));
        panelPrincipalCliente.setMinimumSize(new Dimension(800, 600));
        panelPrincipalCliente.setPreferredSize(new Dimension(800, 600));
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipalCliente.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipalCliente.add(spacer2, gbc);
        lblInstruccionesCliente1 = new JLabel();
        lblInstruccionesCliente1.setText("Complete todos los campos del formulario superior con los datos del turista y su dirección.");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(15, 10, 2, 10);
        panelPrincipalCliente.add(lblInstruccionesCliente1, gbc);
        lblInstruccionesCliente2 = new JLabel();
        lblInstruccionesCliente2.setText("Una vez listo, presione 'Registrar Cliente' para guardar la información.");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(2, 10, 10, 10);
        panelPrincipalCliente.add(lblInstruccionesCliente2, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelPrincipalCliente.add(panel1, gbc);
        lblNombre = new JLabel();
        lblNombre.setText("Nombre Completo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(lblNombre, gbc);
        txtNombre = new JTextField();
        txtNombre.setToolTipText("Ejemplo: Juan Perez Perez");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(txtNombre, gbc);
        lblRut = new JLabel();
        lblRut.setText("RUT:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(lblRut, gbc);
        txtRut = new JTextField();
        txtRut.setToolTipText("Ejemplo: 12345678-9 (sin puntos, con guión)");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(txtRut, gbc);
        lblTelefono = new JLabel();
        lblTelefono.setText("Teléfono:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(lblTelefono, gbc);
        txtTelefono = new JTextField();
        txtTelefono.setToolTipText("Ejemplo: +56912345678");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(txtTelefono, gbc);
        lblEdad = new JLabel();
        lblEdad.setText("Edad:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(lblEdad, gbc);
        txtEdad = new JTextField();
        txtEdad.setToolTipText("Ejemplo: 25");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(txtEdad, gbc);
        lblIdiona = new JLabel();
        lblIdiona.setText("Idioma:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(lblIdiona, gbc);
        txtIdioma = new JTextField();
        txtIdioma.setToolTipText("Ejemplo: Español");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel1.add(txtIdioma, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelPrincipalCliente.add(panel2, gbc);
        lblContacto = new JLabel();
        lblContacto.setText("Contacto Urgencia:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(lblContacto, gbc);
        txtContacto = new JTextField();
        txtContacto.setToolTipText("Ejemplo: +56912345678");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(txtContacto, gbc);
        lblRegion = new JLabel();
        lblRegion.setText("Región:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(lblRegion, gbc);
        cmbRegion = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(cmbRegion, gbc);
        lblCiudad = new JLabel();
        lblCiudad.setText("Ciudad:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(lblCiudad, gbc);
        cmbCiudad = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(cmbCiudad, gbc);
        lblCalle = new JLabel();
        lblCalle.setText("Calle:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(lblCalle, gbc);
        txtCalle = new JTextField();
        txtCalle.setToolTipText("Ejemplo: Pasaje principal");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(txtCalle, gbc);
        lblNumero = new JLabel();
        lblNumero.setText("Número:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(lblNumero, gbc);
        txtNumero = new JTextField();
        txtNumero.setToolTipText("Ejemplo: 1234");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(txtNumero, gbc);
        btnRegistrar = new JButton();
        btnRegistrar.setText("Registrar Cliente");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 10, 15, 10);
        panelPrincipalCliente.add(btnRegistrar, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelPrincipalCliente.add(scrollPane1, gbc);
        txtAreaClientes = new JTextArea();
        txtAreaClientes.setEditable(false);
        txtAreaClientes.setText("");
        txtAreaClientes.setToolTipText("Sin puntos y con guión.");
        scrollPane1.setViewportView(txtAreaClientes);
        btnVolver = new JButton();
        btnVolver.setText("<- Volver al Menú Principal");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 15, 10);
        panelPrincipalCliente.add(btnVolver, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelPrincipalCliente;
    }

}
