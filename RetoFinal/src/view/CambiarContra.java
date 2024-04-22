package view;

import javax.swing.*; 
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class CambiarContra extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Controller controller;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private String userType;
    private JButton btnLogOut;
	private JButton btnCambiarCont;
	private JButton btnCambiarDorsal;
	private JLabel lblWelcome;
	private String username;
	private JButton btnConsultarPartidos;
	private JButton btnGestJugadores;
	private JButton btnConsultarEquipo;
	private String nombreEquipo;

    public CambiarContra(Controller controlador, String userType, String username) {
        this.controller = controlador;
        this.userType = userType;
        this.username = username;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nueva Contraseña:");
        lblNewLabel.setBounds(10, 40, 122, 14);
        contentPane.add(lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(142, 37, 250, 20);
        contentPane.add(passwordField);

        JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña:");
        lblConfirmarContrasea.setBounds(10, 80, 136, 14);
        contentPane.add(lblConfirmarContrasea);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(142, 77, 250, 20);
        contentPane.add(confirmPasswordField);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarContrasenia();
            }
        });
        btnOk.setBounds(335, 240, 89, 23);
        contentPane.add(btnOk);
        
        JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(128, 128, 0));
		panelLeft.setBounds(0, 0, 345, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(50, 70, 90));
			}
		});
		btnLogOut.setBackground(new Color(128, 128, 0));
		btnLogOut.setBounds(57, 536, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarCont = new JButton("Cambiar Contraseña");
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(128, 128, 0));
		btnCambiarCont.setBounds(57, 466, 200, 49);
		panelLeft.add(btnCambiarCont);

		btnCambiarDorsal = new JButton("Cambiar Dorsal");
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal.setFocusable(false);
		btnCambiarDorsal.setBorder(null);
		btnCambiarDorsal.setBackground(new Color(128, 128, 0));
		btnCambiarDorsal.setBounds(57, 396, 200, 49);
		panelLeft.add(btnCambiarDorsal);

		lblWelcome = new JLabel("Welcome Jugador");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("Consultar Partidos");
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(128, 128, 0));
		btnConsultarPartidos.setBounds(57, 328, 200, 49);
		panelLeft.add(btnConsultarPartidos);

		btnConsultarEquipo = new JButton("Consultar Equipo");
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(128, 128, 0));
		btnConsultarEquipo.setBounds(57, 261, 200, 49);
		panelLeft.add(btnConsultarEquipo);
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

		if (e.getSource() == btnLogOut) {
	
			this.dispose();
			controller.logOut();

		} else if (e.getSource() == btnGestJugadores) {
			GestionarJugadores g1 = new GestionarJugadores(controller, username, nombreEquipo);
			g1.setVisible(true);
			this.dispose();
		}
		else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller,username);
			consultarPartidos.setVisible(true);
			this.dispose();
		}else if(e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller,username);
			menuEntrenador.setVisible(true);
			this.dispose();
		}
    }

    private void cambiarContrasenia() {
        String newPassword = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean changed = controller.cambiarPassword(username, newPassword, userType);

        if (changed) {
            JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if ("Jugador".equals(userType)) {
                MenuJugador menuJugador = new MenuJugador(controller, username);
                menuJugador.setVisible(true);
            } else if ("Entrenador".equals(userType)) {
                MenuEntrenador menuEntrenador = new MenuEntrenador(controller, username);
                menuEntrenador.setVisible(true);
            }
            dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}