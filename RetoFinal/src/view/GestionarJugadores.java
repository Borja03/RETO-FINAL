package view;

import java.awt.Color; 
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import view.toDelete.ModificarJugadores;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GestionarJugadores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCrear;
	private JButton btnDeleteJugador;
	private JButton btnModificar;
	private Controller controller;
	private JButton btnLogOut;
	private JButton btnCambiarCont;
	private JLabel lblWelcome;
	private JButton btnConsultarPartidos;
	private JButton btnConsultarEquipo;
	private JLabel lblUser;
	private JLabel lblContrasena;
	private JLabel lblDorsal;
	private JLabel lblGoles;
	private JLabel lblAsistencias;
	private JTextField textFieldUSer;
	private JTextField textFieldContrasena;
	private JComboBox<Integer> textFieldDorsal;
	private JTextField textFieldGoles;
	private JTextField textFieldAsist;
	private JButton btnOK;
	private JTextField txtEquiponame;
	private String miEquipo;
	private String userName;
	private String userType;

	public GestionarJugadores(Controller controller, String user,String userType, String team) {
		this.controller = controller;
		this.userName = user;
		this.userType=userType;
		this.miEquipo = team;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCrear = new JButton("Añadir Jugadores");
		btnCrear.setBackground(new Color(255, 128, 0));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		btnCrear.setBounds(328, 40, 176, 35);
		contentPane.add(btnCrear);

		btnDeleteJugador = new JButton("Eliminar Jugadores");
		btnDeleteJugador.addActionListener(this);
		btnDeleteJugador.setFocusable(false);
		btnDeleteJugador.setBorder(null);
		btnDeleteJugador.setBounds(564, 40, 176, 35);
		contentPane.add(btnDeleteJugador);

		btnModificar = new JButton("Modificar Jugadores");
		btnModificar.setBounds(787, 40, 176, 35);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(null);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(this);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(128, 128, 0));
		panelLeft.setBounds(0, 0, 300, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("     Log Out");
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
		btnLogOut.setBounds(37, 595, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarCont = new JButton("     Cambiar Contraseña");
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(128, 128, 0));
		btnCambiarCont.setBounds(37, 504, 200, 49);
		panelLeft.add(btnCambiarCont);
		btnCambiarCont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(50, 70, 90));
			}
		});

		lblWelcome = new JLabel("Welcome " + userName + "");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Consultar Partidos");
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(128, 128, 0));
		btnConsultarPartidos.setBounds(37, 386, 200, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnConsultarPartidos);

		btnConsultarEquipo = new JButton("    Consultar Equipo");
		btnConsultarEquipo.addActionListener(this);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(128, 128, 0));
		btnConsultarEquipo.setBounds(37, 327, 200, 49);
		btnConsultarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnConsultarEquipo);

		JButton btnGestionarJugadores = new JButton("     Gestionar jugadores");
		btnGestionarJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarJugadores.setFocusable(false);
		btnGestionarJugadores.setBorder(null);
		btnGestionarJugadores.setBackground(new Color(255, 128, 64));
		btnGestionarJugadores.setBounds(37, 275, 200, 49);
		panelLeft.add(btnGestionarJugadores);
		// formulario
		lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(350, 207, 90, 35);
		contentPane.add(lblUser);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasena.setBounds(350, 267, 90, 35);
		contentPane.add(lblContrasena);

		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDorsal.setBounds(350, 332, 90, 35);
		contentPane.add(lblDorsal);

		lblGoles = new JLabel("Goles");
		lblGoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGoles.setBounds(350, 399, 90, 35);
		contentPane.add(lblGoles);

		lblAsistencias = new JLabel("Asistencias");
		lblAsistencias.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsistencias.setBounds(350, 460, 90, 35);
		contentPane.add(lblAsistencias);

		textFieldUSer = new JTextField();
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldUSer.setBounds(515, 208, 250, 34);
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldContrasena.setBounds(515, 274, 250, 35);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldDorsal = new JComboBox<>();
		textFieldDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDorsal.setBounds(515, 333, 250, 35);
		fillDorsalBox ();
		contentPane.add(textFieldDorsal);

		textFieldGoles = new JTextField();
		textFieldGoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldGoles.setBounds(515, 399, 250, 35);
		contentPane.add(textFieldGoles);
		textFieldGoles.setColumns(10);

		textFieldAsist = new JTextField();
		textFieldAsist.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldAsist.setBounds(515, 460, 250, 35);
		contentPane.add(textFieldAsist);
		textFieldAsist.setColumns(10);

		btnOK = new JButton("Añadir jugador");
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOK.setBounds(751, 562, 150, 35);
		contentPane.add(btnOK);

		txtEquiponame = new JTextField();
		txtEquiponame.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEquiponame.setBounds(515, 148, 250, 35);
		txtEquiponame.setColumns(10);
		txtEquiponame.setText(miEquipo);
		txtEquiponame.setEditable(false);
		contentPane.add(txtEquiponame);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEquipo.setBounds(350, 150, 90, 35);
		contentPane.add(lblEquipo);
		btnOK.addActionListener(this);

	}

	public void fillDorsalBox () {

		for (int i = 1; i <= 25; i++) {
			if (!controller.getUsedDorsal(miEquipo).contains(i)) {
				textFieldDorsal.addItem(i);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnDeleteJugador) {
			SearchJugadore eliminarJugadores = new SearchJugadore (controller,userName,userType,miEquipo);
			this.dispose();
			eliminarJugadores.setVisible(true);
		} else if (e.getSource() == btnModificar) {
			ModificarJugadores m1 = new ModificarJugadores(controller);
			m1.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName,userType);
			this.dispose();
			menuEntrenador.setVisible(true);
		} else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName,userType);
			this.dispose();
			consultarPartidos.setVisible(true);
		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		}

		if (e.getSource() == btnOK) {
			String user = textFieldUSer.getText();
			String password = textFieldContrasena.getText();
			String myTeam = txtEquiponame.getText();
			int dorsal = (int) textFieldDorsal.getSelectedItem();
			int numGoles = Integer.valueOf(textFieldGoles.getText());
			int numAsist = Integer.valueOf(textFieldAsist.getText());

			// Object o = e.getSource();
			if (controller.crearJugador(user, password, dorsal, numGoles, numAsist, myTeam)) {
				int opcion = JOptionPane.showConfirmDialog(this, (String) " opopop",
						"El jugador ha sido introducido correctamente\n¿Desea añadir otro jugador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//				textFieldUSer.setText("");
//				textFieldContrasena.setText("");
//				textFieldGoles.setText("");
//				textFieldAsist.setText("");
				GestionarJugadores gestionarJugadores= new GestionarJugadores(controller,user,userType,miEquipo);
				this.dispose();
				gestionarJugadores.setVisible(true);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					GestionarJugadores g1 = new GestionarJugadores(controller, user,userType, myTeam);
					g1.setVisible(true);
				}
			}
		}

	}
}
