package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class MenuAdmin extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnLogOut;
    private JButton btnAddEq;
    private JLabel lblWelcome;
    private Controller controller;
    private JButton btnGestionarEntrenador;
    private JButton btnCrearPartido;
    private JButton btnModificarPartido;
    private JPanel panelRight;
    private JPanel panelRight2;

    private JButton btnCrearEquipo;
    private JButton btnBorrarEquipo;
    private JButton btnModificarEquipo;

    private JButton btnCrearEntrenador;
    private JButton btnBorrarEntrenador;
    private JButton btnModificarEntrenador;

    public MenuAdmin(Controller cont) {
        this.controller = cont;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1008, 717);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setSize(1366, 768);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelLeft = new JPanel();
        panelLeft.setBounds(0, 0, 329, 680);
        panelLeft.setBackground(new Color(128, 128, 0));
        contentPane.add(panelLeft);
        panelLeft.setLayout(null);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
        btnLogOut.setBackground(new Color(128, 128, 0));
        btnLogOut.setBounds(57, 550, 200, 49);
        btnLogOut.setFocusable(false);
        btnLogOut.setBorder(null);
        panelLeft.add(btnLogOut);
        btnLogOut.addActionListener(this);
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

        btnAddEq = new JButton("Gestionar equipo");
        btnAddEq.addActionListener(this);
        btnAddEq.setHorizontalAlignment(SwingConstants.LEFT);
        btnAddEq.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAddEq.setFocusable(false);
        btnAddEq.setBorder(null);
        btnAddEq.setBackground(new Color(128, 128, 0));
        btnAddEq.setBounds(57, 370, 200, 49);
        panelLeft.add(btnAddEq);

        lblWelcome = new JLabel("Welcome Admin");
        lblWelcome.setForeground(new Color(255, 255, 0));
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblWelcome.setBounds(64, 180, 217, 34);
        panelLeft.add(lblWelcome);

        btnGestionarEntrenador = new JButton("Gestionar entrenador");
        btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
        btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnGestionarEntrenador.setFocusable(false);
        btnGestionarEntrenador.setBorder(null);
        btnGestionarEntrenador.setBackground(new Color(128, 128, 0));
        btnGestionarEntrenador.setBounds(57, 250, 200, 49);
        panelLeft.add(btnGestionarEntrenador);

        btnCrearPartido = new JButton("Crear partido");
        btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
        btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCrearPartido.setFocusable(false);
        btnCrearPartido.setBorder(null);
        btnCrearPartido.setBackground(new Color(128, 128, 0));
        btnCrearPartido.setBounds(57, 310, 200, 49);
        panelLeft.add(btnCrearPartido);

        btnModificarPartido = new JButton("Modificar partido");
        btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
        btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnModificarPartido.setFocusable(false);
        btnModificarPartido.setBorder(null);
        btnModificarPartido.setBackground(new Color(128, 128, 0));
        btnModificarPartido.setBounds(57, 430, 200, 49);
        panelLeft.add(btnModificarPartido);
        btnModificarPartido.addActionListener(this);

        panelRight = new JPanel();
        panelRight.setBounds(329, 0, 659, 680);
        panelRight.setBackground(Color.WHITE);
        contentPane.add(panelRight);
        panelRight.setLayout(new GridLayout(0, 1, 0, 10));

        panelRight2 = new JPanel();
        panelRight2.setBounds(329, 0, 659, 680);
        panelRight2.setBackground(Color.WHITE);
        contentPane.add(panelRight2);
        panelRight2.setLayout(new GridLayout(0, 1, 0, 10));

        btnCrearEquipo = new JButton("Crear equipo");
        btnBorrarEquipo = new JButton("Borrar equipo");
        btnModificarEquipo = new JButton("Modificar equipo");

        btnCrearEntrenador = new JButton("Crear entrenador");
        btnBorrarEntrenador = new JButton("Borrar entrenador");
        btnModificarEntrenador = new JButton("Modificar entrenador");

        ocultarBotonesEquipos();
        ocultarBotonesEntrenadores();

        panelRight.add(btnCrearEntrenador);
        panelRight.add(btnBorrarEntrenador);
        panelRight.add(btnModificarEntrenador);
        panelRight2.add(btnCrearEquipo);
        panelRight2.add(btnBorrarEquipo);
        panelRight2.add(btnModificarEquipo);

        btnCrearEquipo.addActionListener(this);
        btnBorrarEquipo.addActionListener(this);
        btnModificarEquipo.addActionListener(this);
        btnCrearPartido.addActionListener(this);

        btnCrearEntrenador.addActionListener(this);
        btnBorrarEntrenador.addActionListener(this);
        btnModificarEntrenador.addActionListener(this);

        btnGestionarEntrenador.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == btnAddEq) {
            mostrarBotonesEquipos();
            ocultarBotonesEntrenadores();
        } else if (o == btnGestionarEntrenador) {
            mostrarBotonesEntrenadores();
            ocultarBotonesEquipos();
        } else if (o == btnCrearEntrenador) {
            this.dispose();
            AnadirEntrenador av = new AnadirEntrenador(controller);
            av.setVisible(true);
        } else if (o == btnBorrarEntrenador) {
            this.dispose();
            EliminarEntrenador av = new EliminarEntrenador(controller);
            av.setVisible(true);
        } else if (o == btnModificarEntrenador) {
            this.dispose();
            ModificarEntrenador av = new ModificarEntrenador(controller);
            av.setVisible(true);
        } else if (o == btnCrearPartido) {
            CrearPartido2 frame = new CrearPartido2(controller);
            frame.setVisible(true);
            this.dispose();
        } else if (o == btnModificarPartido) {
            ModificarPartido frame = new ModificarPartido(controller);
            frame.setVisible(true);
            this.dispose();
        } else if (o == btnLogOut) {
            Login frame = new Login(controller);
            frame.setVisible(true);
            this.dispose();
        } else if (o == btnCrearEquipo) {
            CrearEquipo frame = new CrearEquipo(controller);
            frame.setVisible(true);
            this.dispose();
        }
    }

    public void mostrarBotonesEquipos() {
        panelRight2.setVisible(true);
        panelRight.setVisible(false);
    }

    public void ocultarBotonesEquipos() {
        panelRight2.setVisible(false);
    }

    public void mostrarBotonesEntrenadores() {
        panelRight.setVisible(true);
        panelRight2.setVisible(false);
    }

    public void ocultarBotonesEntrenadores() {
        panelRight.setVisible(false);
    }
}
