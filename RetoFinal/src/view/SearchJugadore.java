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
 * The SearchJugadore class provides a GUI for searching and managing player information.
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 * */
public class SearchJugadore extends JFrame implements ActionListener {
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
	 * Button for modifying a record.
	 */
	private JButton btnModificar;

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
     * Constructs a new SearchJugadore frame.
     *
     * @param controller the controller to handle logic
     * @param user the username of the logged-in user
     * @param team the team of the logged-in user
     * @param userType the type of the logged-in user
     */
	public SearchJugadore(Controller controller, String user, String team,String userType) {
		this.controller = controller;
		this.userName = user;
		this.miEquipo = team;
		this.userType=userType;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
        // Bottom panel message setup
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
        // Bottom panel setup
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

		JButton btnModificarJugador = new JButton("Modificar jugador");
		btnModificarJugador.setBounds(204, 308, 169, 35);
		btnModificarJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		bottomPanel.add(btnModificarJugador);
		bottomPanel.setVisible(false);
        // Top panel buttons
		btnCrear = new JButton("Añadir Jugadores");
		btnCrear.setBackground(new Color(240, 240, 240));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		btnCrear.setBounds(328, 40, 176, 35);
		contentPane.add(btnCrear);

		btnDelete = new JButton("Eliminar Jugadores");
		btnDelete.setBackground(new Color(255, 128, 0));
		btnDelete.addActionListener(this);
		btnDelete.setFocusable(false);
		btnDelete.setBorder(null);
		btnDelete.setBounds(564, 40, 176, 35);
		contentPane.add(btnDelete);

		btnModificar = new JButton("Modificar Jugadores");
		btnModificar.setBounds(787, 40, 176, 35);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(null);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(this);
        // Left panel setup
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

		btnCambiarDorsal = new JButton("     Cambiar Dorsal");
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal.setFocusable(false);
		btnCambiarDorsal.setBorder(null);
		btnCambiarDorsal.setBackground(new Color(128, 128, 0));
		btnCambiarDorsal.setBounds(37, 445, 200, 49);
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnCambiarDorsal);

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
    Fills the dropdown list with available dorsal numbers for selection.
    Dorsal numbers range from 1 to 25.
    */
	public void fillDorsalBox() {
		for (int i = 1; i <= 25; i++) {
			if (!controller.getUsedDorsal(miEquipo).contains(i)) {
				textFieldDorsal.addItem(i);
			}
		}
	}
	/**
    Fills the user data fields with information retrieved from the controller.
    Retrieves the player information using the provided username,
    and populates the corresponding text fields with the retrieved data.
    @throws NullPointerException if the user retrieved from the controller is null.
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
     * Handles action events for the buttons in the GUI.
     *
     * @param e the ActionEvent
     */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName,userType);
			this.dispose();
			menuEntrenador.setVisible(true);
		} else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName,userType);
			this.dispose();
			consultarPartidos.setVisible(true);
		} else if (e.getSource() == btnCambiarDorsal) {
			CambiarDorsal cambiarDorsal = new CambiarDorsal(controller, userName, userType);
			this.dispose();
			cambiarDorsal.setVisible(true);

		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
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

		if (e.getSource() == btnDelete) {
			// EliminarJugadores e1 = new EliminarJugadores(controller, userName);
			// e1.setVisible(true);
			// this.dispose();
		} else if (e.getSource() == btnModificar) {
		//	ModificarJugadores m1 = new ModificarJugadores(controller);
			//m1.setVisible(true);
			//this.dispose();
		}

		if (e.getSource() == btnElimimarJugador) {
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
//						textFieldUSer.setText("");
//						textFieldContrasena.setText("");
//						textFieldGoles.setText("");
//						textFieldAsist.setText("");
				GestionarJugadores gestionarJugadores = new GestionarJugadores(controller, user,userType, miEquipo);
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