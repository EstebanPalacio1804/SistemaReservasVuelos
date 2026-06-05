package reservasvuelo;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private Vuelo vuelo;
    private JTable tablaAsientos;
    private DefaultTableModel modeloTabla;
    private JTextField txtNumeroAsiento, txtNombre;
    private JTextArea areaEstado;
    private JLabel lblPrecioEconomico, lblPrecioEjecutivo;

    public Main() {
        vuelo = new Vuelo(10, 5);
        inicializarComponentes();
        actualizarTabla();
    }

    private void inicializarComponentes() {
        setTitle("Sistema de Reservas de Vuelo - Aerolinea Colombia");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(0, 68, 136));
        panelSuperior.setPreferredSize(new Dimension(1000, 100));
        panelSuperior.setLayout(new BorderLayout());
        
        JLabel titulo = new JLabel(" SISTEMA DE RESERVAS DE VUELOS ", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        panelSuperior.add(titulo, BorderLayout.CENTER);
        
        JLabel subtitulo = new JLabel("Aerolinea Colombia", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitulo.setForeground(new Color(255, 255, 200));
        panelSuperior.add(subtitulo, BorderLayout.SOUTH);
        
        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCentral.setBackground(new Color(240, 248, 255));

        JPanel panelPrecios = new JPanel();
        panelPrecios.setLayout(new BoxLayout(panelPrecios, BoxLayout.Y_AXIS));
        panelPrecios.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 102, 204), 2),
            "Informacion de Precios",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14),
            new Color(0, 102, 204)
        ));
        panelPrecios.setBackground(new Color(255, 255, 255));
        panelPrecios.setPreferredSize(new Dimension(250, 200));

        JLabel tituloPrecios = new JLabel("TARIFAS 2026", SwingConstants.CENTER);
        tituloPrecios.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tituloPrecios.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrecios.add(tituloPrecios);
        panelPrecios.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel panelEco = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEco.setBackground(Color.WHITE);
        JLabel iconoEco = new JLabel(" ");
        iconoEco.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        panelEco.add(iconoEco);
        panelEco.add(new JLabel("Asiento Economico:"));
        lblPrecioEconomico = new JLabel("$150.000 COP");
        lblPrecioEconomico.setForeground(new Color(0, 150, 0));
        lblPrecioEconomico.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panelEco.add(lblPrecioEconomico);
        panelPrecios.add(panelEco);

        JPanel panelEjec = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEjec.setBackground(Color.WHITE);
        JLabel iconoEjec = new JLabel(" ");
        iconoEjec.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        panelEjec.add(iconoEjec);
        panelEjec.add(new JLabel("Asiento Ejecutivo:"));
        lblPrecioEjecutivo = new JLabel("$580.000 COP");
        lblPrecioEjecutivo.setForeground(new Color(204, 102, 0));
        lblPrecioEjecutivo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panelEjec.add(lblPrecioEjecutivo);
        panelPrecios.add(panelEjec);

        panelPrecios.add(Box.createRigidArea(new Dimension(0, 20)));
        JLabel nota = new JLabel(" Precios incluyen impuestos");
        nota.setFont(new Font("Segoe UI", Font.ITALIC, 10));
        nota.setForeground(Color.GRAY);
        nota.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrecios.add(nota);

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 15));
        panelFormulario.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 102, 204), 2),
            "Datos de la Reserva",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14),
            new Color(0, 102, 204)
        ));
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setPreferredSize(new Dimension(300, 200));

        panelFormulario.add(new JLabel("Numero de Asiento:"));
        txtNumeroAsiento = new JTextField();
        panelFormulario.add(txtNumeroAsiento);

        panelFormulario.add(new JLabel("Nombre del Pasajero:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        JButton btnReservar = new JButton("RESERVAR");
        btnReservar.setBackground(new Color(0, 150, 0));
        btnReservar.setForeground(Color.WHITE);
        btnReservar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBackground(new Color(204, 0, 0));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 12));

        panelFormulario.add(btnReservar);
        panelFormulario.add(btnCancelar);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.add(panelPrecios, BorderLayout.NORTH);
        panelDerecho.add(panelFormulario, BorderLayout.CENTER);
        
        panelCentral.add(panelDerecho);

        modeloTabla = new DefaultTableModel(new String[]{"Numero", "Tipo", "Precio COP", "Estado", "Reservante"}, 0);
        tablaAsientos = new JTable(modeloTabla);
        tablaAsientos.setRowHeight(25);
        tablaAsientos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tablaAsientos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaAsientos.getTableHeader().setBackground(new Color(0, 102, 204));
        tablaAsientos.getTableHeader().setForeground(Color.WHITE);
        
        tablaAsientos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    String tipo = table.getValueAt(row, 1).toString();
                    if (tipo.equals("Economico")) {
                        c.setBackground(new Color(220, 255, 220));
                    } else {
                        c.setBackground(new Color(255, 235, 200));
                    }
                }
                return c;
            }
        });
        
        JScrollPane scrollTabla = new JScrollPane(tablaAsientos);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Mapa de Asientos del Avion"));
        scrollTabla.setPreferredSize(new Dimension(450, 400));

        JPanel panelInferior = new JPanel(new BorderLayout());
        areaEstado = new JTextArea(8, 45);
        areaEstado.setEditable(false);
        areaEstado.setBackground(new Color(250, 250, 250));
        areaEstado.setFont(new Font("Monospaced", Font.PLAIN, 11));
        JScrollPane scrollEstado = new JScrollPane(areaEstado);
        scrollEstado.setBorder(BorderFactory.createTitledBorder("Registro de Actividad"));
        panelInferior.add(scrollEstado, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(240, 248, 255));
        
        JButton btnMostrarLibres = new JButton("📋 Mostrar Libres");
        btnMostrarLibres.setBackground(new Color(0, 102, 204));
        btnMostrarLibres.setForeground(Color.WHITE);
        
        JButton btnMostrarReservados = new JButton("📌 Mostrar Reservados");
        btnMostrarReservados.setBackground(new Color(255, 140, 0));
        btnMostrarReservados.setForeground(Color.WHITE);
        
        JButton btnReiniciar = new JButton("🔄 Reiniciar Sistema");
        btnReiniciar.setBackground(new Color(128, 0, 128));
        btnReiniciar.setForeground(Color.WHITE);

        panelBotones.add(btnMostrarLibres);
        panelBotones.add(btnMostrarReservados);
        panelBotones.add(btnReiniciar);
        panelInferior.add(panelBotones, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);
        add(scrollTabla, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);

        btnReservar.addActionListener(e -> reservarAsiento());
        btnCancelar.addActionListener(e -> cancelarReserva());
        btnMostrarLibres.addActionListener(e -> mostrarLibres());
        btnMostrarReservados.addActionListener(e -> mostrarReservados());
        btnReiniciar.addActionListener(e -> reiniciarSistema());
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Asiento a : vuelo.getTodosLosAsientos()) {
            String estado = a.isReservado() ? "Reservado" : "Libre";
            String reservante = a.isReservado() ? a.getNombreReservante() : "---";
            String precio = String.format("$%,.0f COP", a.getPrecio());
            modeloTabla.addRow(new Object[]{a.getNumero(), a.getTipoAsiento(), precio, estado, reservante});
        }
    }

    private void actualizarEstado(String mensaje) {
        areaEstado.append("[" + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()) + "] " + mensaje + "\n");
        actualizarTabla();
    }

    private void reservarAsiento() {
        try {
            int numero = Integer.parseInt(txtNumeroAsiento.getText().trim());
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacio");
                return;
            }
            boolean exito = vuelo.reservarAsiento(numero, nombre);
            if (exito) {
                actualizarEstado("RESERVA EXITOSA: Asiento " + numero + " para " + nombre);
            } else {
                actualizarEstado("ERROR: El asiento " + numero + " ya esta reservado o no existe");
            }
            txtNumeroAsiento.setText("");
            txtNombre.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Numero de asiento invalido");
        }
    }

    private void cancelarReserva() {
        try {
            int numero = Integer.parseInt(txtNumeroAsiento.getText().trim());
            boolean exito = vuelo.cancelarReserva(numero);
            if (exito) {
                actualizarEstado("CANCELACION EXITOSA: Asiento " + numero + " ahora esta libre");
            } else {
                actualizarEstado("ERROR: El asiento " + numero + " no estaba reservado o no existe");
            }
            txtNumeroAsiento.setText("");
            txtNombre.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Numero de asiento invalido");
        }
    }

    private void mostrarLibres() {
        areaEstado.append("\n--- ASIENTOS LIBRES ---\n");
        for (Asiento a : vuelo.getAsientosLibres()) {
            areaEstado.append(a.toString() + "\n");
        }
    }

    private void mostrarReservados() {
        areaEstado.append("\n--- ASIENTOS RESERVADOS ---\n");
        for (Asiento a : vuelo.getAsientosReservados()) {
            areaEstado.append(a.toString() + "\n");
        }
    }

    private void reiniciarSistema() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas cancelar TODAS las reservas?",
                "Reiniciar Sistema",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            vuelo.reiniciarSistema();
            actualizarEstado("SISTEMA REINICIADO: Todas las reservas han sido canceladas");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}