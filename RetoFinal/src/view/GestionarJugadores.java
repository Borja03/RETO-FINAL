
package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

/**
 * JFrame for managing players.
 * 
 * @author 1dami G1
 * @since 2024-05-13
 */
public class GestionarJugadores extends JFrame implements ActionListener {
	
	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Panel that contains the main content of the GUI.
	 */
	private JPanel contentPane;

	/**
	 * Button for creating new entities.
	 */
	private JButton btnCrear;

	/**
	 * Button for deleting a player.
	 */
	private JButton btnDeleteJugador;
<<<<<<< HEAD

	/**
	 * Reference to the controller handling the GUI logic.
	 */
=======
>>>>>>> origin/Alder
	private Controller controller;

	/**
	 * Button for logging out.
	 */
	private JButton btnLogOut;

	/**
	 * Button for changing the user's password.
	 */
	private JButton btnCambiarCont;

	/**
	 * Label displaying a welcome message.
	 */
	private JLabel lblWelcome;

	/**
	 * Button for consulting match details.
	 */
	private JButton btnConsultarPartidos;

	/**
	 * Button for consulting team details.
	 */
	private JButton btnConsultarEquipo;

	/**
	 * Label displaying the username.
	 */
	private JLabel lblUser;

	/**
	 * Label displaying the password.
	 */
	private JLabel lblContrasena;

	/**
	 * Label displaying the player's jersey number.
	 */
	private JLabel lblDorsal;

	/**
	 * Label displaying the number of goals scored by the player.
	 */
	private JLabel lblGoles;
<<<<<<< HEAD

	/**
	 * Label displaying the user's profile picture.
	 */
	private JLabel lblUserPic;

	/**
	 * Label displaying the number of assists made by the player.
	 */
=======
	private JLabel lblUserPic;
>>>>>>> origin/Alder
	private JLabel lblAsistencias;

	/**
	 * Text field for entering the username.
	 */
	private JTextField textFieldUSer;

	/**
	 * Text field for entering the password.
	 */
	private JTextField textFieldContrasena;

	/**
	 * Combo box for selecting the player's jersey number.
	 */
	private JComboBox<Integer> textFieldDorsal;

	/**
	 * Text field for entering the number of goals scored by the player.
	 */
	private JTextField textFieldGoles;
	/**
	 * Text field for entering the number of assists made by the player.
	 */
	private JTextField textFieldAsist;
	/**
	 * Button for confirming an action.
	 */
	private JButton btnOK;
	/**
	 * Text field for entering the name of the team.
	 */
	private JTextField txtEquiponame;
	/**
	 * The team associated with the current user.
	 */
	private String miEquipo;
	/**
	 * The username of the current user.
	 */
	private String userName;

	/**
	 * The type of user currently logged in.
	 */
	private String userType;

	/**
	 * Button for managing players.
	 */
	private JButton btnGestJugadores;

	
	
	/**
	 * Constructs a new GestionarJugadores JFrame.
	 * 
	 * @param controller The Controller instance for handling business logic.
	 * @param user       The username of the current user.
	 * @param userType   The type of user (e.g., admin, coach).
	 * @param team       The team associated with the user.
	 */
	public GestionarJugadores(Controller controller, String user, String userType, String team) {
		this.controller = controller;
		this.userName = user;
		this.userType = userType;
		this.miEquipo = team;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		btnCrear = new JButton("Añadir Jugadores");
		btnCrear.setBounds(463, 40, 176, 35);
		btnCrear.setBackground(new Color(255, 128, 0));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		contentPane.add(btnCrear);

		btnDeleteJugador = new JButton("Eliminar / modificar Jugadores");
		btnDeleteJugador.setBounds(677, 40, 176, 35);
		btnDeleteJugador.addActionListener(this);
		btnDeleteJugador.setFocusable(false);
		btnDeleteJugador.setBorder(null);
		contentPane.add(btnDeleteJugador);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 250, 680);
<<<<<<< HEAD
		panelLeft.setBackground(new Color(86, 82, 252));
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
=======
        panelLeft.setBackground(new Color(86, 82, 252));
        contentPane.add(panelLeft);
        panelLeft.setLayout(null);
>>>>>>> origin/Alder

		btnConsultarEquipo = new JButton("     Consultar Equipo");
		btnConsultarEquipo.setForeground(new Color(255, 255, 255));
		btnConsultarEquipo.addActionListener(this);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(86, 82, 252));
		btnConsultarEquipo.setBounds(0, 395, 250, 49);
		panelLeft.add(btnConsultarEquipo);
		// Action listener solo para el botón "Consultar Equipo"
		btnConsultarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(50, 50, 50)); // Cambia el color al presionar
			}
		});
		btnGestJugadores = new JButton("     Gestionar jugadores");
		btnGestJugadores.setForeground(new Color(255, 255, 255));
		btnGestJugadores.addActionListener(this);
		btnGestJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestJugadores.setFocusable(false);
		btnGestJugadores.setBorder(null);
		btnGestJugadores.setBackground(new Color(100, 100, 100)); // Color inicial gris
		btnGestJugadores.setBounds(0, 332, 250, 49);
		panelLeft.add(btnGestJugadores);
		// Action listener para el botón "Gestionar Jugadores"
		btnGestJugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestJugadores.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestJugadores.setBackground(new Color(100, 100, 100)); // Restaura el color al salir
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestJugadores.setBackground(new Color(100, 100, 100)); // Cambia el color al presionar
			}
		});
		lblWelcome = new JLabel("Welcome " + user + "");
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(20, 182, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Consultar Partidos");
		btnConsultarPartidos.setForeground(new Color(255, 255, 255));
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(86, 82, 252));
		btnConsultarPartidos.setBounds(0, 454, 250, 49);
		panelLeft.add(btnConsultarPartidos);
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(50, 50, 50)); // Cambia el color al presionar
			}
		});

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(0, 586, 250, 49);
		panelLeft.add(btnLogOut);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(100, 100, 100));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(86, 82, 252));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(50, 70, 90));
			}
		});
		btnLogOut.setBackground(new Color(86, 82, 252));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarCont = new JButton("     Cambiar contraseña");
		btnCambiarCont.setForeground(new Color(255, 255, 255));
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setBounds(0, 513, 250, 49);
		panelLeft.add(btnCambiarCont);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(86, 82, 252));
		// Action listener para el botón "Cambiar contraseña"
		btnCambiarCont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(50, 50, 50)); // Cambia el color al presionar
			}
		});
		panelLeft.add(btnConsultarEquipo);

		// formulario
		lblUser = new JLabel("Usuario");
		lblUser.setBounds(350, 207, 90, 35);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblUser);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(350, 267, 90, 35);
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblContrasena);

		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(350, 332, 90, 35);
		lblDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDorsal);

		lblGoles = new JLabel("Goles");
		lblGoles.setBounds(350, 399, 90, 35);
		lblGoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblGoles);

		lblAsistencias = new JLabel("Asistencias");
		lblAsistencias.setBounds(350, 460, 90, 35);
		lblAsistencias.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblAsistencias);

		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(515, 208, 250, 34);
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(515, 274, 250, 35);
		textFieldContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldDorsal = new JComboBox<>();
		textFieldDorsal.setBounds(515, 333, 250, 35);
		textFieldDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
<<<<<<< HEAD
		fillDorsalBox();
=======
		fillDorsalBox ();
>>>>>>> origin/Alder
		contentPane.add(textFieldDorsal);

		textFieldGoles = new JTextField();
		textFieldGoles.setBounds(515, 399, 250, 35);
		textFieldGoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(textFieldGoles);
		textFieldGoles.setColumns(10);

		textFieldAsist = new JTextField();
		textFieldAsist.setBounds(515, 460, 250, 35);
		textFieldAsist.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(textFieldAsist);
		textFieldAsist.setColumns(10);

		btnOK = new JButton("Añadir jugador");
		btnOK.setBounds(751, 562, 150, 35);
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnOK);

		txtEquiponame = new JTextField();
		txtEquiponame.setBounds(515, 148, 250, 35);
		txtEquiponame.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEquiponame.setColumns(10);
		txtEquiponame.setText(miEquipo);
		txtEquiponame.setEditable(false);
		contentPane.add(txtEquiponame);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(350, 150, 90, 35);
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblEquipo);
		btnOK.addActionListener(this);
		
		lblUserPic = new JLabel();
		lblUserPic.setBackground(SystemColor.activeCaption);
		lblUserPic.setForeground(SystemColor.activeCaption);
		lblUserPic.setBounds(50, 33, 150, 150);
		panelLeft.add(lblUserPic);
		


		lblUserPic = new JLabel();
		lblUserPic.setBackground(SystemColor.activeCaption);
		lblUserPic.setForeground(SystemColor.activeCaption);
		lblUserPic.setBounds(50, 33, 150, 150);
		panelLeft.add(lblUserPic);

	}

	/**
	 * Fills the JComboBox for selecting player dorsal numbers.
	 */
	public void fillDorsalBox() {

		for (int i = 1; i <= 25; i++) {
			if (!controller.getUsedDorsal(miEquipo).contains(i)) {
				textFieldDorsal.addItem(i);
			}
		}
	}

	/**
	 * ActionListener implementation method. Handles button clicks and actions.
	 * 
	 * @param e The ActionEvent that occurred.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnDeleteJugador) {
<<<<<<< HEAD
			ModificarJugadores eliminarJugadores = new ModificarJugadores(controller, userName, miEquipo, userType);
=======
			ModificarJugadores eliminarJugadores = new ModificarJugadores (controller,userName,miEquipo,userType);
>>>>>>> origin/Alder
			this.dispose();
			eliminarJugadores.setVisible(true);
		} else if (e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName, userType);
			this.dispose();
			menuEntrenador.setVisible(true);
		} else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
			this.dispose();
			consultarPartidos.setVisible(true);
		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		} else if (e.getSource() == btnCambiarCont) {
			CambiarContra cambiarContra = new CambiarContra(controller, userName, userType);
			cambiarContra.setVisible(true);
			this.dispose();
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
				GestionarJugadores gestionarJugadores = new GestionarJugadores(controller, user, userType, miEquipo);
				this.dispose();
				gestionarJugadores.setVisible(true);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					GestionarJugadores g1 = new GestionarJugadores(controller, user, userType, myTeam);
					g1.setVisible(true);
				}
			}
		}

	}
}