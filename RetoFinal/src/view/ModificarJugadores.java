
package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.usuarios.Jugador;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
/**
 * The ModificarJugadores class provides a graphical user interface for modifying players.
 * Users can add, delete, or modify player information such as username, password, dorsal number, goals, and assists.
 * It extends JFrame and implements ActionListener to handle user interactions.
 * 
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 3
 */
public class ModificarJugadores extends JFrame implements ActionListener {
	/**
	 * Unique identifier for serializing the class.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The main content pane of the view.
	 */
	private JPanel contentPane;

	/**
	 * Button for creating a new record.
	 */
	private JButton btnCrear;

	/**
	 * Button for deleting a record.
	 */
	private JButton btnDelete;

	/**
	 * Reference to the controller for handling actions.
	 */
	private Controller controller;

	/**
	 * Button for logging out.
	 */
	private JButton btnLogOut;

	/**
	 * Button for changing password.
	 */
	private JButton btnCambiarCont;

	/**
	 * Button for changing dorsal (jersey number).
	 */
	private JButton btnCambiarDorsal;

	/**
	 * Label for welcoming the user.
	 */
	private JLabel lblWelcome;

	/**
	 * Button for accessing match information.
	 */
	private JButton btnConsultarPartidos;

	/**
	 * Button for accessing team information.
	 */
	private JButton btnConsultarEquipo;

	/**
	 * Label for indicating username.
	 */
	private JLabel lblUser;

	/**
	 * Label for indicating password.
	 */
	private JLabel lblContrasena;

	/**
	 * Label for indicating dorsal (jersey number).
	 */
	private JLabel lblDorsal;

	/**
	 * Label for indicating goals.
	 */
	private JLabel lblGoles;

	/**
	 * Label for indicating assists.
	 */
	private JLabel lblAsistencias;

	/**
	 * Text field for entering username.
	 */
	private JTextField textFieldUSer;

	/**
	 * Text field for entering password.
	 */
	private JTextField textFieldContrasena;

	/**
	 * Combo box for selecting dorsal (jersey number).
	 */
	private JComboBox<Integer> textFieldDorsal;

	/**
	 * Text field for entering goals.
	 */
	private JTextField textFieldGoles;

	/**
	 * Text field for entering assists.
	 */
	private JTextField textFieldAsist;

	/**
	 * Button for deleting a player.
	 */
	private JButton btnElimimarJugador;

	/**
	 * Text field for entering team name.
	 */
	private JTextField txtEquiponame;

	/**
	 * The user's team.
	 */
	private String miEquipo;

	/**
	 * The username of the logged-in user.
	 */
	private String userName;

	/**
	 * Button for searching for a player.
	 */
	private JButton btnBuscarJugador;

	/**
	 * Panel for the bottom section.
	 */
	private JPanel bottomPanel;

	/**
	 * Panel for displaying messages in the bottom section.
	 */
	private JPanel bottomPanelMsg;

	/**
	 * Label indicating player.
	 */
	private JLabel lblJugador;

	/**
	 * Label indicating non-existence.
	 */
	private JLabel lblNoExiste;

	/**
	 * The type of user logged in.
	 */
	private String userType;

	/**
	 * Button for confirming an action.
	 */
	private JButton btnOK;

	/**
	 * Button for modifying a player.
	 */
	private JButton btnModificarJugador;

	/**
	 * Button for managing players.
	 */
	private JButton btnGestJugadores;
	 


	/**
	 * Constructs a new ModificarJugadores instance with the specified controller,
	 * user, team, and user type.
	 * 
	 * @param controller The controller for managing player-related actions.
	 * @param user       The username of the current user.
	 * @param team       The name of the team associated with the current user.
	 * @param userType   The type of user (e.g., coach, administrator).
	 */
	public ModificarJugadores(Controller controller, String user, String team, String userType) {
		this.controller = controller;
		this.userName = user;
		this.miEquipo = team;
		this.userType = userType;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		bottomPanelMsg = new JPanel();
		bottomPanelMsg.setBackground(SystemColor.menu);
		bottomPanelMsg.setBounds(310, 249, 676, 421);
		contentPane.add(bottomPanelMsg);
		bottomPanelMsg.setLayout(null);

		JLabel lblMsg = new JLabel("Este");
		lblMsg.setBackground(SystemColor.textHighlightText);
		lblMsg.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMsg.setBounds(183, 49, 295, 72);
		bottomPanelMsg.add(lblMsg);

		lblJugador = new JLabel("jugador");
		lblJugador.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblJugador.setBackground(SystemColor.textHighlightText);
		lblJugador.setBounds(183, 131, 295, 72);
		bottomPanelMsg.add(lblJugador);

		lblNoExiste = new JLabel("NO existe !");
		lblNoExiste.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNoExiste.setBackground(SystemColor.textHighlightText);
		lblNoExiste.setBounds(183, 226, 295, 72);
		bottomPanelMsg.add(lblNoExiste);
		bottomPanelMsg.setVisible(false);

		bottomPanel = new JPanel();
		bottomPanel.setBounds(310, 253, 674, 417);
		contentPane.add(bottomPanel);
		bottomPanel.setLayout(null);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(80, 46, 90, 35);
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(lblContrasena);

		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(80, 97, 90, 35);
		lblDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(lblDorsal);

		lblGoles = new JLabel("Goles");
		lblGoles.setBounds(80, 159, 90, 35);
		lblGoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(lblGoles);

		lblAsistencias = new JLabel("Asistencias");
		lblAsistencias.setBounds(80, 218, 90, 35);
		lblAsistencias.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(lblAsistencias);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(245, 53, 250, 34);
		textFieldContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldDorsal = new JComboBox<>();
		textFieldDorsal.setBounds(245, 98, 250, 34);
		textFieldDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(textFieldDorsal);

		textFieldGoles = new JTextField();
		textFieldGoles.setBounds(245, 159, 250, 35);
		textFieldGoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(textFieldGoles);
		textFieldGoles.setColumns(10);

		textFieldAsist = new JTextField();
		textFieldAsist.setBounds(245, 218, 250, 35);
		textFieldAsist.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(textFieldAsist);
		textFieldAsist.setColumns(10);

		btnElimimarJugador = new JButton("Eliminar jugador");
		btnElimimarJugador.setBounds(442, 308, 176, 35);
		btnElimimarJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(btnElimimarJugador);
		btnElimimarJugador.addActionListener(this);

		btnModificarJugador = new JButton("Modificar jugador");
		btnModificarJugador.setBounds(204, 308, 169, 35);
		btnModificarJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(btnModificarJugador);
		btnModificarJugador.addActionListener(this);
		bottomPanel.setVisible(false);

		btnCrear = new JButton("Añadir Jugadores");
		btnCrear.setBackground(new Color(240, 240, 240));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		btnCrear.setBounds(480, 40, 176, 35);
		contentPane.add(btnCrear);
		btnCrear.addActionListener(this);

		btnDelete = new JButton("Eliminar / modificar Jugadores");
		btnDelete.setBackground(new Color(255, 128, 0));
		btnDelete.addActionListener(this);
		btnDelete.setFocusable(false);
		btnDelete.setBorder(null);
		btnDelete.setBounds(689, 40, 176, 35);
		contentPane.add(btnDelete);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(86, 82, 252));
		panelLeft.setBounds(0, 0, 250, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

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

		JPanel topPanel = new JPanel();
		topPanel.setBounds(310, 85, 676, 154);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEquipo.setBounds(63, 42, 49, 17);
		topPanel.add(lblEquipo);

		txtEquiponame = new JTextField();
		txtEquiponame.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEquiponame.setBounds(181, 39, 146, 23);
		txtEquiponame.setColumns(10);
		txtEquiponame.setText(miEquipo);
		txtEquiponame.setEditable(false);
		topPanel.add(txtEquiponame);

		lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(63, 85, 55, 17);
		topPanel.add(lblUser);

		textFieldUSer = new JTextField();
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldUSer.setBounds(181, 82, 146, 23);
		topPanel.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		btnBuscarJugador = new JButton("Buscar jugador");
		btnBuscarJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarJugador.setBounds(467, 81, 143, 35);
		topPanel.add(btnBuscarJugador);
		btnBuscarJugador.addActionListener(this);
		fillDorsalBox();

	}

	/**
	 * Fills the combo box with dorsal numbers that are not already in use by
	 * players in the team.
	 */
	public void fillDorsalBox() {
		for (int i = 1; i <= 25; i++) {
			if (!controller.getUsedDorsal(miEquipo).contains(i)) {
				textFieldDorsal.addItem(i);
			}
		}
	}

	/**
	 * Fills the user interface fields with the information of the selected user.
	 */
	public void fillUserData() {
		Jugador usr = (Jugador) controller.getUsuario(textFieldUSer.getText());
		textFieldUSer.setText(usr.getUser());
		textFieldContrasena.setText(usr.getContrasenia());
		textFieldDorsal.addItem(usr.getDorsal());
		textFieldGoles.setText(usr.getGoles() + "");
		textFieldAsist.setText(usr.getAsistencias() + "");
	}

	/**
	 * Handles various user actions performed in the GUI.
	 * 
	 * @param e The ActionEvent representing the user action.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName, userType);
			this.dispose();
			menuEntrenador.setVisible(true);
			/*
			 * } else if (e.getSource() == btnCambiarDorsal) { CambiarDorsal cambiarDorsal =
			 * new CambiarDorsal(controller, userName, userType); this.dispose();
			 * cambiarDorsal.setVisible(true); controller.logOut();
			 */
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
		} else if (e.getSource() == btnCrear) {
			GestionarJugadores g1 = new GestionarJugadores(controller, userName, userType, miEquipo);
			g1.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnElimimarJugador) {
			controller.borrarJugador(userName);
			JOptionPane.showMessageDialog(null, "¡Jugador eliminado con éxito!");
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName, userType);
			this.dispose();
			menuEntrenador.setVisible(true);
		}

		else if (e.getSource() == btnBuscarJugador) {
			if (controller.checkUserExist(textFieldUSer.getText())) {
				fillUserData();
				bottomPanelMsg.setVisible(false);
				bottomPanel.setVisible(true);
			} else {
				bottomPanel.setVisible(false);
				bottomPanelMsg.setVisible(true);
			}

		}
		if (e.getSource() == btnModificarJugador) {
			String user = textFieldUSer.getText();
			String password = textFieldContrasena.getText();
			String myTeam = txtEquiponame.getText();
			int dorsal = (int) textFieldDorsal.getSelectedItem();
			int numGoles = Integer.valueOf(textFieldGoles.getText());
			int numAsist = Integer.valueOf(textFieldAsist.getText());

			// Object o = e.getSource();
			if (controller.modificarJugador(user, password, dorsal, numGoles, numAsist)) {
				int opcion = JOptionPane.showConfirmDialog(this, (String) " Introduciendo jugador",
						"El jugador ha sido introducido correctamente\n¿Desea añadir otro jugador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//						textFieldUSer.setText("");
//						textFieldContrasena.setText("");
//						textFieldGoles.setText("");
//						textFieldAsist.setText("");
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