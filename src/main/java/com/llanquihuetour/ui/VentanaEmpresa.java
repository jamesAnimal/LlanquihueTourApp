                                                                                                                          package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorEntidades;
import com.llanquihuetour.model.*;
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
 * Clase que representa la interfaz gráfica de la ventana Empresa.
 *
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class VentanaEmpresa extends JFrame {

    private JFrame ventanaPrincipal;
    private GestorEntidades gestorEntidades = new GestorEntidades();

    // Elementos de la ventana.
    private JPanel panelPrincipalEmpresa = new JPanel();
    private JLabel lblInstruccionesEmpresa1 = new JLabel();
    private JLabel lblInstruccionesEmpresa2 = new JLabel();
    private JTabbedPane tabbedPrincipal = new JTabbedPane();
    private JPanel tabRecursosHumanos;
    private JLabel lblTipoPersona = new JLabel();
    private JComboBox<String> cmbTipoPersona = new JComboBox<>();
    private JLabel lblNombrePersona = new JLabel();
    private JTextField txtNombrePersona = new JTextField();
    private JLabel lblRutPersona = new JLabel();
    private JTextField txtRutPersona = new JTextField();
    private JLabel lblTelefonoPersona = new JLabel();
    private JTextField txtTelefonoPersona = new JTextField();
    private JLabel lblEspecificoPersona1 = new JLabel();
    private JTextField txtEspecificoPersona1 = new JTextField();
    private JLabel lblEspecificoPersona3 = new JLabel();
    private JTextField txtEspecificoPersona3 = new JTextField();
    private JLabel lblRegionPersona = new JLabel();
    private JComboBox<String> cmbRegionPersona = new JComboBox<>();
    private JLabel lblCiudadPersona = new JLabel();
    private JComboBox<String> cmbCiudadPersona = new JComboBox<>();
    private JLabel lblCallePersona = new JLabel();
    private JTextField txtCallePersona = new JTextField();
    private JLabel lblNumeroPersona = new JLabel();
    private JTextField txtNumeroPersona = new JTextField();
    private JLabel lblEspecificoPersona2 = new JLabel();
    private JTextField txtEspecificoPersona2 = new JTextField();
    private JButton btnRegistrarPersona = new JButton();
    private JPanel panelFiltroPersonas = new JPanel();
    private JLabel lblFiltroPersonas = new JLabel();
    private JComboBox<String> cmbFiltroPersonas = new JComboBox<>();
    private JTextArea txtAreaPersonas = new JTextArea();
    private JPanel tabRecursosFisicos;
    private JLabel lblTipoRecurso = new JLabel();
    private JComboBox<String> cmbTipoRecurso = new JComboBox<>();
    private JLabel lblCodigoRecurso = new JLabel();
    private JTextField txtCodigoRecurso = new JTextField();
    private JLabel lblEspecificoRecurso1 = new JLabel();
    private JTextField txtEspecificoRecurso1 = new JTextField();
    private JLabel lblEspecificoRecurso2 = new JLabel();
    private JTextField txtEspecificoRecurso2 = new JTextField();
    private JLabel lblEspecificoRecurso3 = new JLabel();
    private JTextField txtEspecificoRecurso3 = new JTextField();
    private JLabel lblEspecificoRecurso4 = new JLabel();
    private JTextField txtEspecificoRecurso4 = new JTextField();
    private JLabel lblCapacidad = new JLabel();
    private JTextField txtCapacidad = new JTextField();
    private JPanel panelDireccionRecurso = new JPanel();
    private JLabel lblRegionRecurso = new JLabel();
    private JComboBox<String> cmbRegionRecurso = new JComboBox<>();
    private JLabel lblCiudadRecurso = new JLabel();
    private JComboBox<String> cmbCiudadRecurso = new JComboBox<>();
    private JLabel lblCalleRecurso = new JLabel();
    private JTextField txtCalleRecurso = new JTextField();
    private JLabel lblNumeroRecurso = new JLabel();
    private JTextField txtNumeroRecurso = new JTextField();
    private JButton btnRegistrarRecurso = new JButton();
    private JPanel panelFiltroRecursos = new JPanel();
    private JLabel lblFiltroRecursos = new JLabel();
    private JComboBox<String> cmbFiltroRecursos = new JComboBox<>();
    private JTextArea txtAreaRecursos = new JTextArea();
    private JButton btnVolver = new JButton();

    /**
     * Constructor de la ventana Empresa.
     */
    public VentanaEmpresa(JFrame ventanaPrincipal) {

        this.ventanaPrincipal = ventanaPrincipal;
        setContentPane(panelPrincipalEmpresa);
        setTitle("Llanquihue Tour - Gestión de Empresa");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Carga los ítems en los comboboxes usando la clase utilitaria.
        CargadorCombobox.cargarTiposPersonal(cmbTipoPersona);
        CargadorCombobox.cargarTiposRecurso(cmbTipoRecurso);
        CargadorCombobox.cargarRegiones(cmbRegionPersona);
        CargadorCombobox.cargarRegiones(cmbRegionRecurso);
        CargadorCombobox.cargarFiltrosPersonal(cmbFiltroPersonas);
        CargadorCombobox.cargarFiltrosRecurso(cmbFiltroRecursos);

        // Carga listados iniciales de prueba (deben ir después de inicializar comboboxes de filtro).
        actualizarListadoPersonas();
        actualizarListadoRecursos();

        // Carga las labels específicas al inicio según el tipo por defecto de cada pestaña.
        actualizarCamposPersonal();
        actualizarCamposRecurso();

        // Hace el cambio visual de los campos (labels) según el tipo de persona seleccionado.
        cmbTipoPersona.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCamposPersonal();
            }
        });

        // Hace el cambio visual de los campos (labels) según el tipo de recurso seleccionado.
        cmbTipoRecurso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                actualizarCamposRecurso();
            }
        });

        // Carga las ciudades en el combobox correspondiente dependiendo de la región elegida (pestaña personas).
        cmbRegionPersona.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                cmbCiudadPersona.removeAllItems();
                String region = (String) cmbRegionPersona.getSelectedItem();
                CargadorCombobox.actualizarCiudades(region, cmbCiudadPersona);
            }
        });

        cmbRegionPersona.setSelectedIndex(0);

        // Carga las ciudades en el combobox correspondiente dependiendo de la región elegida (pestaña recursos).
        cmbRegionRecurso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                cmbCiudadRecurso.removeAllItems();
                String region = (String) cmbRegionRecurso.getSelectedItem();
                CargadorCombobox.actualizarCiudades(region, cmbCiudadRecurso);
            }
        });

        cmbRegionRecurso.setSelectedIndex(0);

        // Actualiza la lista de personas en pantalla según el filtro seleccionado.
        cmbFiltroPersonas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                actualizarListadoPersonas();
            }
        });

        // Actualiza la lista de recursos en pantalla según el filtro seleccionado.
        cmbFiltroRecursos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                actualizarListadoRecursos();
            }
        });

        // Botón para registrar recursos humanos.
        btnRegistrarPersona.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String tipo = (String) cmbTipoPersona.getSelectedItem();
                String nombre = txtNombrePersona.getText().trim();
                String rut = txtRutPersona.getText().trim();
                String fono = txtTelefonoPersona.getText().trim();
                String contenidoEspacio1 = txtEspecificoPersona1.getText().trim();
                String contenidoEspacio2String = txtEspecificoPersona2.getText().trim();
                String contenidoEspacio3 = txtEspecificoPersona3.getText().trim();
                String region = (String) cmbRegionPersona.getSelectedItem();
                String ciudad = (String) cmbCiudadPersona.getSelectedItem();
                String calle = txtCallePersona.getText().trim();
                String numero = txtNumeroPersona.getText().trim();

                // Valida que no haya campos vacíos.
                if (nombre.isEmpty() || rut.isEmpty() || fono.isEmpty() || contenidoEspacio1.isEmpty() || contenidoEspacio2String.isEmpty() || contenidoEspacio3.isEmpty() ||
                        region == null || region.isEmpty() || ciudad == null || ciudad.isEmpty() || calle.isEmpty() || numero.isEmpty()) {

                    JOptionPane.showMessageDialog(VentanaEmpresa.this, "Por favor, complete todos los campos del colaborador.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Direccion dir = new Direccion(calle, numero, ciudad, region);

                // Registra persona tipo Empleado si coincide la etiqueta.
                if ("Empleado".equals(tipo)) {

                    // Valida el sueldo.
                    double sueldo = ValidadorGeneral.validarDecimal(contenidoEspacio2String, "Sueldo");

                    if (sueldo == -1.0) {

                        return;
                    }

                    Empleado emp = new Empleado(contenidoEspacio1, contenidoEspacio3, sueldo, nombre, "11111111-1", fono, dir);

                    // Valida el Rut.
                    try {

                        emp.setRut(rut);

                    } catch (RutInvalidoException ex) {

                        JOptionPane.showMessageDialog(VentanaEmpresa.this, "Error de Validación: " + ex.getMessage(), "RUT Inválido", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Agrega el objeto a la lista gestora y actualiza el área de texto.
                    gestorEntidades.agregarEntidad(emp);
                    actualizarListadoPersonas();
                    JOptionPane.showMessageDialog(VentanaEmpresa.this, "Colaborador registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

                // Registra persona tipo Asociado si coincide la etiqueta.
                } else if ("Asociado".equals(tipo)) {

                    // Valida la tarifa.
                    int tarifa = ValidadorGeneral.validarEntero(contenidoEspacio2String, "Tarifa");

                    if (tarifa == -1) {

                        return;
                    }

                    Asociado asoc = new Asociado(contenidoEspacio1, tarifa, contenidoEspacio3, nombre, "11111111-1", fono, dir);

                    // Valida el Rut.
                    try {

                        asoc.setRut(rut);

                    } catch (RutInvalidoException ex) {

                        JOptionPane.showMessageDialog(VentanaEmpresa.this, "Error de Validación: " + ex.getMessage(), "RUT Inválido", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Agrega el objeto a la lista gestora y actualiza el área de texto.
                    gestorEntidades.agregarEntidad(asoc);
                    actualizarListadoPersonas();
                    JOptionPane.showMessageDialog(VentanaEmpresa.this, "Colaborador registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

                // Registra persona tipo Guía Turístico si coincide la etiqueta.
                } else if ("Guía Turístico".equals(tipo)) {

                    GuiaTuristico guia = new GuiaTuristico(nombre, "11111111-1", fono, dir, contenidoEspacio1, contenidoEspacio2String, contenidoEspacio3);

                    // Valida el Rut.
                    try {

                        guia.setRut(rut);

                    } catch (RutInvalidoException ex) {

                        JOptionPane.showMessageDialog(VentanaEmpresa.this, "Error de Validación: " + ex.getMessage(), "RUT Inválido", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Agrega el objeto a la lista gestora y actualiza el área de texto.
                    gestorEntidades.agregarEntidad(guia);
                    actualizarListadoPersonas();
                    JOptionPane.showMessageDialog(VentanaEmpresa.this, "Colaborador registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }

                // Limpia los campos del formulario.
                txtNombrePersona.setText("");
                txtRutPersona.setText("");
                txtTelefonoPersona.setText("");
                txtEspecificoPersona1.setText("");
                txtEspecificoPersona2.setText("");
                txtEspecificoPersona3.setText("");
                txtCallePersona.setText("");
                txtNumeroPersona.setText("");
                cmbRegionPersona.setSelectedIndex(0);
            }
        });

        // Botón para registrar recursos físicos.
        btnRegistrarRecurso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String tipo = (String) cmbTipoRecurso.getSelectedItem();
                String codigoStr = txtCodigoRecurso.getText().trim();
                String contenidoEspacioRecurso1 = txtEspecificoRecurso1.getText().trim();
                String contenidoEspacioRecurso2 = txtEspecificoRecurso2.getText().trim();
                String contenidoEspacioRecurso3 = txtEspecificoRecurso3.getText().trim();
                String contenidoEspacioRecurso4 = txtEspecificoRecurso4.getText().trim();

                // Valida que no haya campos vacíos.
                if (codigoStr.isEmpty() || contenidoEspacioRecurso1.isEmpty() || contenidoEspacioRecurso2.isEmpty() || contenidoEspacioRecurso3.isEmpty() || contenidoEspacioRecurso4.isEmpty()) {

                    JOptionPane.showMessageDialog(VentanaEmpresa.this, "Por favor, complete todos los campos obligatorios del recurso.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Valida el código.
                int codigo = ValidadorGeneral.validarEntero(codigoStr, "Código");

                if (codigo == -1) {

                    return;
                }

                // Registra recurso tipo Vehículo si coincide la etiqueta.
                if ("Vehículo".equals(tipo)) {

                    String capacidadPasajerosString = txtCapacidad.getText().trim();
                    
                    // Valida que este campo específico de vehículo no esté vacío.
                    if (capacidadPasajerosString.isEmpty()) {
                        JOptionPane.showMessageDialog(VentanaEmpresa.this, "Por favor, especifique la capacidad de pasajeros para el vehículo.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Valida la capacidad de pasajeros.
                    int capacidadPasajeros = ValidadorGeneral.validarEntero(capacidadPasajerosString, "Capacidad Pasajeros");

                    if (capacidadPasajeros == -1) {

                        return;
                    }

                    // Valida el año.
                    int anio = ValidadorGeneral.validarEntero(contenidoEspacioRecurso3, "Año");

                    if (anio == -1) {

                        return;
                    }

                    String marca = contenidoEspacioRecurso1;
                    String modelo = contenidoEspacioRecurso2;
                    String patente = contenidoEspacioRecurso4;

                    // Agrega el objeto a la lista gestora y actualiza el área de texto.
                    Vehiculo vehiculo = new Vehiculo(codigo, marca, modelo, anio, patente, capacidadPasajeros);
                    gestorEntidades.agregarEntidad(vehiculo);
                    actualizarListadoRecursos();
                    JOptionPane.showMessageDialog(VentanaEmpresa.this, "Recurso físico registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

                // Registra recurso tipo Alojamiento si coincide la etiqueta.
                } else if ("Alojamiento".equals(tipo)) {

                    String region = (String) cmbRegionRecurso.getSelectedItem();
                    String ciudad = (String) cmbCiudadRecurso.getSelectedItem();
                    String calle = txtCalleRecurso.getText().trim();
                    String numero = txtNumeroRecurso.getText().trim();

                    // Valida que estos campos específicos de Alojamiento no estén vacíos.
                    if (region == null || region.isEmpty() || ciudad == null || ciudad.isEmpty() || calle.isEmpty() || numero.isEmpty()) {

                        JOptionPane.showMessageDialog(VentanaEmpresa.this, "Por favor, complete la dirección del alojamiento.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Valida la capacidad de huespedes.
                    int capacidadHuespedes = ValidadorGeneral.validarEntero(contenidoEspacioRecurso4, "Capacidad Huéspedes");

                    if (capacidadHuespedes == -1) {

                        return;
                    }

                    String nombre = contenidoEspacioRecurso1;
                    String tipoAlojamiento = contenidoEspacioRecurso2;
                    String telefono = contenidoEspacioRecurso3;

                    // Agrega el objeto a la lista gestora y actualiza el área de texto.
                    Direccion dir = new Direccion(calle, numero, ciudad, region);
                    Alojamiento alojamiento = new Alojamiento(codigo, nombre, dir, telefono, tipoAlojamiento, capacidadHuespedes);
                    gestorEntidades.agregarEntidad(alojamiento);
                    actualizarListadoRecursos();
                    JOptionPane.showMessageDialog(VentanaEmpresa.this, "Recurso físico registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }

                // Limpia los campos del formulario.
                txtCodigoRecurso.setText("");
                txtEspecificoRecurso1.setText("");
                txtEspecificoRecurso2.setText("");
                txtEspecificoRecurso3.setText("");
                txtEspecificoRecurso4.setText("");
                txtCapacidad.setText("");
                txtCalleRecurso.setText("");
                txtNumeroRecurso.setText("");
                cmbRegionRecurso.setSelectedIndex(0);
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

                VentanaEmpresa.this.dispose();

                if (ventanaPrincipal != null) {

                    ventanaPrincipal.setVisible(true);
                }
            }
        });

    }

    /**
     * Filtra y actualiza la lista de colaboradores en pantalla.
     */
    private void actualizarListadoPersonas() {

        String seleccion = (String) cmbFiltroPersonas.getSelectedItem();

        if ("Todos".equals(seleccion)) {

            txtAreaPersonas.setText(gestorEntidades.obtenerResumenEntidades("Personas"));

        } else {

            txtAreaPersonas.setText(gestorEntidades.obtenerResumenEntidades(seleccion));
        }
    }

    /**
     * Filtra y actualiza la lista de recursos físicos en pantalla.
     */
    private void actualizarListadoRecursos() {

        String seleccion = (String) cmbFiltroRecursos.getSelectedItem();

        if ("Todos".equals(seleccion)) {

            txtAreaRecursos.setText(gestorEntidades.obtenerResumenEntidades("Recursos"));

        } else {

            txtAreaRecursos.setText(gestorEntidades.obtenerResumenEntidades(seleccion));
        }
    }

    /**
     * Actualiza el texto de los labels específicos según el tipo de Personal seleccionado.
     */
    private void actualizarCamposPersonal() {

        String seleccion = (String) cmbTipoPersona.getSelectedItem();

        if ("Empleado".equals(seleccion)) {

            lblEspecificoPersona1.setText("Cargo:");
            lblEspecificoPersona2.setText("Sueldo ($):");
            lblEspecificoPersona3.setText("Turno:");

        } else if ("Asociado".equals(seleccion)) {

            lblEspecificoPersona1.setText("Servicio:");
            lblEspecificoPersona2.setText("Tarifa ($):");
            lblEspecificoPersona3.setText("Observaciones:");
            
        } else if ("Guía Turístico".equals(seleccion)) {

            lblEspecificoPersona1.setText("Idiomas:");
            lblEspecificoPersona2.setText("Zonas de Trabajo:");
            lblEspecificoPersona3.setText("Credencial Sernatur:");
        }
    }

    /**
     * Actualiza el texto de los labels y la visibilidad de los paneles según el tipo de recurso físico seleccionado.
     */
    private void actualizarCamposRecurso() {

        String seleccion = (String) cmbTipoRecurso.getSelectedItem();

        if ("Vehículo".equals(seleccion)) {

            lblEspecificoRecurso1.setText("Marca:");
            lblEspecificoRecurso2.setText("Modelo:");
            lblEspecificoRecurso3.setText("Año:");
            lblEspecificoRecurso4.setText("Patente:");

            lblCapacidad.setVisible(true);
            txtCapacidad.setVisible(true);
            panelDireccionRecurso.setVisible(false);

        } else if ("Alojamiento".equals(seleccion)) {

            lblEspecificoRecurso1.setText("Nombre:");
            lblEspecificoRecurso2.setText("Tipo Alojamiento:");
            lblEspecificoRecurso3.setText("Teléfono:");
            lblEspecificoRecurso4.setText("Capacidad Huéspedes:");

            lblCapacidad.setVisible(false);
            txtCapacidad.setVisible(false);
            panelDireccionRecurso.setVisible(true);
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
        panelPrincipalEmpresa = new JPanel();
        panelPrincipalEmpresa.setLayout(new GridBagLayout());
        panelPrincipalEmpresa.setMaximumSize(new Dimension(800, 600));
        panelPrincipalEmpresa.setMinimumSize(new Dimension(800, 600));
        panelPrincipalEmpresa.setPreferredSize(new Dimension(800, 600));
        lblInstruccionesEmpresa1 = new JLabel();
        lblInstruccionesEmpresa1.setText("Gestión de la Empresa (Recursos Humanos y Recursos Físicos)");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 2, 10);
        panelPrincipalEmpresa.add(lblInstruccionesEmpresa1, gbc);
        lblInstruccionesEmpresa2 = new JLabel();
        lblInstruccionesEmpresa2.setText("Complete el formulario superior para registrar y visualice la lista abajo.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(2, 10, 10, 10);
        panelPrincipalEmpresa.add(lblInstruccionesEmpresa2, gbc);
        tabbedPrincipal = new JTabbedPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);
        panelPrincipalEmpresa.add(tabbedPrincipal, gbc);
        tabRecursosHumanos = new JPanel();
        tabRecursosHumanos.setLayout(new GridBagLayout());
        tabbedPrincipal.addTab("Recursos Humanos", tabRecursosHumanos);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        tabRecursosHumanos.add(panel1, gbc);
        lblTipoPersona = new JLabel();
        lblTipoPersona.setText("Tipo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(lblTipoPersona, gbc);
        cmbTipoPersona = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(cmbTipoPersona, gbc);
        lblNombrePersona = new JLabel();
        lblNombrePersona.setText("Nombre Completo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(lblNombrePersona, gbc);
        txtNombrePersona = new JTextField();
        txtNombrePersona.setToolTipText("Ejemplo: Juan Perez Perez");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(txtNombrePersona, gbc);
        lblRutPersona = new JLabel();
        lblRutPersona.setText("RUT:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(lblRutPersona, gbc);
        txtRutPersona = new JTextField();
        txtRutPersona.setToolTipText("Ejemplo: 12345678-9 (sin puntos, con guión)");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(txtRutPersona, gbc);
        lblTelefonoPersona = new JLabel();
        lblTelefonoPersona.setText("Teléfono:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(lblTelefonoPersona, gbc);
        txtTelefonoPersona = new JTextField();
        txtTelefonoPersona.setToolTipText("Ejemplo: +56912345678");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(txtTelefonoPersona, gbc);
        lblEspecificoPersona1 = new JLabel();
        lblEspecificoPersona1.setText("Cargo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(lblEspecificoPersona1, gbc);
        txtEspecificoPersona1 = new JTextField();
        txtEspecificoPersona1.setToolTipText("Ejemplo: Guía Interno");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(txtEspecificoPersona1, gbc);
        lblEspecificoPersona3 = new JLabel();
        lblEspecificoPersona3.setText("Turno:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(lblEspecificoPersona3, gbc);
        txtEspecificoPersona3 = new JTextField();
        txtEspecificoPersona3.setToolTipText("Ejemplo: Diurno");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel1.add(txtEspecificoPersona3, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        tabRecursosHumanos.add(panel2, gbc);
        lblRegionPersona = new JLabel();
        lblRegionPersona.setText("Región:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(lblRegionPersona, gbc);
        cmbRegionPersona = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(cmbRegionPersona, gbc);
        lblCiudadPersona = new JLabel();
        lblCiudadPersona.setText("Ciudad:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(lblCiudadPersona, gbc);
        cmbCiudadPersona = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(cmbCiudadPersona, gbc);
        lblCallePersona = new JLabel();
        lblCallePersona.setText("Calle:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(lblCallePersona, gbc);
        txtCallePersona = new JTextField();
        txtCallePersona.setToolTipText("Ejemplo: Pasaje principal");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(txtCallePersona, gbc);
        lblNumeroPersona = new JLabel();
        lblNumeroPersona.setText("Número:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(lblNumeroPersona, gbc);
        txtNumeroPersona = new JTextField();
        txtNumeroPersona.setToolTipText("Ejemplo: 1234");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(txtNumeroPersona, gbc);
        lblEspecificoPersona2 = new JLabel();
        lblEspecificoPersona2.setText("Sueldo ($):");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(lblEspecificoPersona2, gbc);
        txtEspecificoPersona2 = new JTextField();
        txtEspecificoPersona2.setToolTipText("Ejemplo: 750000");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel2.add(txtEspecificoPersona2, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel2.add(spacer1, gbc);
        btnRegistrarPersona = new JButton();
        btnRegistrarPersona.setText("Registrar Personal");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 5, 10);
        tabRecursosHumanos.add(btnRegistrarPersona, gbc);
        panelFiltroPersonas = new JPanel();
        panelFiltroPersonas.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);
        tabRecursosHumanos.add(panelFiltroPersonas, gbc);
        lblFiltroPersonas = new JLabel();
        lblFiltroPersonas.setText("Filtrar por Tipo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelFiltroPersonas.add(lblFiltroPersonas, gbc);
        cmbFiltroPersonas = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelFiltroPersonas.add(cmbFiltroPersonas, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);
        tabRecursosHumanos.add(scrollPane1, gbc);
        txtAreaPersonas = new JTextArea();
        txtAreaPersonas.setEditable(false);
        scrollPane1.setViewportView(txtAreaPersonas);
        tabRecursosFisicos = new JPanel();
        tabRecursosFisicos.setLayout(new GridBagLayout());
        tabbedPrincipal.addTab("Recursos Fisicos", tabRecursosFisicos);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        tabRecursosFisicos.add(panel3, gbc);
        lblTipoRecurso = new JLabel();
        lblTipoRecurso.setText("Tipo Recurso:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblTipoRecurso, gbc);
        cmbTipoRecurso = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(cmbTipoRecurso, gbc);
        lblCodigoRecurso = new JLabel();
        lblCodigoRecurso.setText("Código:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblCodigoRecurso, gbc);
        txtCodigoRecurso = new JTextField();
        txtCodigoRecurso.setToolTipText("Ejemplo: 501");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtCodigoRecurso, gbc);
        lblEspecificoRecurso1 = new JLabel();
        lblEspecificoRecurso1.setText("Marca:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblEspecificoRecurso1, gbc);
        txtEspecificoRecurso1 = new JTextField();
        txtEspecificoRecurso1.setToolTipText("Ejemplo: Hyundai");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtEspecificoRecurso1, gbc);
        lblEspecificoRecurso2 = new JLabel();
        lblEspecificoRecurso2.setText("Modelo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblEspecificoRecurso2, gbc);
        txtEspecificoRecurso2 = new JTextField();
        txtEspecificoRecurso2.setToolTipText("Ejemplo: H1");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtEspecificoRecurso2, gbc);
        lblEspecificoRecurso3 = new JLabel();
        lblEspecificoRecurso3.setText("Año:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblEspecificoRecurso3, gbc);
        txtEspecificoRecurso3 = new JTextField();
        txtEspecificoRecurso3.setToolTipText("Ejemplo: 2021");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtEspecificoRecurso3, gbc);
        lblEspecificoRecurso4 = new JLabel();
        lblEspecificoRecurso4.setText("Patente:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblEspecificoRecurso4, gbc);
        txtEspecificoRecurso4 = new JTextField();
        txtEspecificoRecurso4.setToolTipText("Ejemplo: PPDD55");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtEspecificoRecurso4, gbc);
        lblCapacidad = new JLabel();
        lblCapacidad.setText("Capacidad Pasajeros:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(lblCapacidad, gbc);
        txtCapacidad = new JTextField();
        txtCapacidad.setToolTipText("Ejemplo: 9");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel3.add(txtCapacidad, gbc);
        panelDireccionRecurso = new JPanel();
        panelDireccionRecurso.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        tabRecursosFisicos.add(panelDireccionRecurso, gbc);
        lblRegionRecurso = new JLabel();
        lblRegionRecurso.setText("Región:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelDireccionRecurso.add(lblRegionRecurso, gbc);
        cmbRegionRecurso = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelDireccionRecurso.add(cmbRegionRecurso, gbc);
        lblCiudadRecurso = new JLabel();
        lblCiudadRecurso.setText("Ciudad:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelDireccionRecurso.add(lblCiudadRecurso, gbc);
        cmbCiudadRecurso = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelDireccionRecurso.add(cmbCiudadRecurso, gbc);
        lblCalleRecurso = new JLabel();
        lblCalleRecurso.setText("Calle:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelDireccionRecurso.add(lblCalleRecurso, gbc);
        txtCalleRecurso = new JTextField();
        txtCalleRecurso.setToolTipText("Ejemplo: Pasaje principal");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelDireccionRecurso.add(txtCalleRecurso, gbc);
        lblNumeroRecurso = new JLabel();
        lblNumeroRecurso.setText("Número:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelDireccionRecurso.add(lblNumeroRecurso, gbc);
        txtNumeroRecurso = new JTextField();
        txtNumeroRecurso.setToolTipText("Ejemplo: 1234");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelDireccionRecurso.add(txtNumeroRecurso, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        panelDireccionRecurso.add(spacer2, gbc);
        btnRegistrarRecurso = new JButton();
        btnRegistrarRecurso.setText("Registrar Recurso");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 5, 10);
        tabRecursosFisicos.add(btnRegistrarRecurso, gbc);
        panelFiltroRecursos = new JPanel();
        panelFiltroRecursos.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);
        tabRecursosFisicos.add(panelFiltroRecursos, gbc);
        lblFiltroRecursos = new JLabel();
        lblFiltroRecursos.setText("Filtrar por Tipo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelFiltroRecursos.add(lblFiltroRecursos, gbc);
        cmbFiltroRecursos = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        panelFiltroRecursos.add(cmbFiltroRecursos, gbc);
        final JScrollPane scrollPane2 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 10);
        tabRecursosFisicos.add(scrollPane2, gbc);
        txtAreaRecursos = new JTextArea();
        txtAreaRecursos.setEditable(false);
        scrollPane2.setViewportView(txtAreaRecursos);
        btnVolver = new JButton();
        btnVolver.setText("<- Volver al Menú Principal");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 15, 10);
        panelPrincipalEmpresa.add(btnVolver, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelPrincipalEmpresa;
    }

}

