package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.usuarios.CargoEntrenador;
import model.usuarios.Entrenador;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

/**
 * The SearchEntrenador class represents a GUI for searching and managing
 * 'Entrenador' (coach) entities. This class extends JFrame and implements
 * ActionListener. It provides functionality to add, delete, and modify
 * entrenador records.
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class SearchEntrenador extends JFrame implements ActionListener {
	/**
	 * Unique identifier for serializing the class.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * Represents the main content pane of the application window.
	 */
	private JPanel contentPane;

	/**
	 * 
	 * Button for adding a new coach.
	 */
	private JButton btnAddEntrenador;

	/**
	 * 
	 * Button for deleting or modifying a coach.
	 */
	private JButton btnDeleteMod;

	/**
	 * 
	 * Instance of the application controller.
	 */
	private Controller controller;

	/**
	 * 
	 * Button for logging out from the application.
	 */
	private JButton btnLogOut;

	/**
	 * 
	 * Button for modifying matches.
	 */
	private JButton btnModPartidos;

	/**
	 * 
	 * Label for displaying a welcome message.
	 */
	private JLabel lblWelcome;

	/**
	 * 
	 * Button for managing teams.
	 */
	private JButton btnGestionarEquipo;

	/**
	 * 
	 * Button for creating a new match.
	 */
	private JButton btnCrearPartido;

	/**
	 * 
	 * Label for displaying the username.
	 */
	private JLabel lblUser;

	/**
	 * 
	 * Label for displaying the password.
	 */
	private JLabel lblContrasena;

	/**
	 * 
	 * Label for displaying the user's role.
	 */
	private JLabel lblCargo;

	/**
	 * 
	 * Dropdown list for selecting a user.
	 */
	private JComboBox<String> textFieldUSer;

	/**
	 * 
	 * Text field for entering the password.
	 */
	private JTextField textFieldContrasena;

	/**
	 * 
	 * Dropdown list for selecting a user's role.
	 */
	private JComboBox<String> textFieldCargo;

	/**
	 * 
	 * Button for deleting a coach.
	 */
	private JButton btnEliminarEntrenador;

	/**
	 * 
	 * Dropdown list for selecting a team.
	 */
	private JComboBox<String> txtEquiponame;

	/**
	 * 
	 * Panel for displaying bottom elements.
	 */
	private JPanel bottomPanel;

	/**
	 * 
	 * The user's name.
	 */
	private String user;

	/**
	 * 
	 * Button for modifying a coach.
	 */
	private JButton btnModificarEntrenador;

	/**
	 * 
	 * The type of user.
	 */
	private String userType;

	/**
	 * 
	 * Button for managing coaches.
	 */
	private JButton btnGestionarEntrenador;

	/**
	 * Constructs a new SearchEntrenador frame.
	 *
	 * @param controller the Controller instance to handle application logic
	 */
	public SearchEntrenador(Controller controller) {
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		btnAddEntrenador = new JButton("Añadir Entrenadores");
		btnAddEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEntrenador.addActionListener(this);
		btnAddEntrenador.setBackground(new Color(240, 240, 240));
		btnAddEntrenador.setFocusable(false);
		btnAddEntrenador.setBorder(null);
		btnAddEntrenador.setBounds(328, 40, 185, 35);
		contentPane.add(btnAddEntrenador);

		btnDeleteMod = new JButton("Eliminar/Modificar Entrenadores");
		btnDeleteMod.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnDeleteMod.setBackground(new Color(220, 3, 9));
		btnDeleteMod.addActionListener(this);
		btnDeleteMod.setFocusable(false);
		btnDeleteMod.setBorder(null);
		btnDeleteMod.setBounds(564, 40, 250, 35);
		contentPane.add(btnDeleteMod);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(242, 45, 45));
		panelLeft.setBounds(0, 0, 250, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(242, 45, 45));
			}
		});
		btnLogOut.setBackground(new Color(242, 45, 45));
		btnLogOut.setBounds(0, 595, 250, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnModPartidos = new JButton("     Modificar partidos");
		btnModPartidos.setForeground(new Color(255, 255, 255));
		btnModPartidos.addActionListener(this);
		btnModPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnModPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModPartidos.setFocusable(false);
		btnModPartidos.setBorder(null);
		btnModPartidos.setBackground(new Color(242, 45, 45));
		btnModPartidos.setBounds(0, 445, 250, 49);
		btnModPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModPartidos.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModPartidos.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnModPartidos.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnModPartidos);

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setBackground(new Color(0, 0, 0));
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(10, 181, 217, 34);
		panelLeft.add(lblWelcome);

		btnGestionarEquipo = new JButton("     Gestionar Equipo");
		btnGestionarEquipo.setForeground(new Color(255, 255, 255));
		btnGestionarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEquipo.setFocusable(false);
		btnGestionarEquipo.setBorder(null);
		btnGestionarEquipo.setBackground(new Color(242, 45, 45));
		btnGestionarEquipo.setBounds(0, 386, 250, 49);
		btnGestionarEquipo.addActionListener(this);
		btnGestionarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnGestionarEquipo);

		btnCrearPartido = new JButton("     Crear partido");
		btnCrearPartido.setForeground(new Color(255, 255, 255));
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(242, 45, 45));
		btnCrearPartido.setBounds(0, 327, 250, 49);

		btnCrearPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnCrearPartido);

		btnGestionarEntrenador = new JButton("     Gestionar entrenadores");
		btnGestionarEntrenador.setForeground(new Color(255, 255, 255));
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(220, 3, 9));
		btnGestionarEntrenador.setBounds(0, 275, 250, 49);
		btnGestionarEntrenador.addActionListener(this);
		btnGestionarEntrenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnGestionarEntrenador);

		JPanel topPanel = new JPanel();
		topPanel.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(128, 0, 64)));
		topPanel.setBounds(310, 85, 676, 154);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEquipo.setBounds(63, 27, 84, 34);
		topPanel.add(lblEquipo);

		txtEquiponame = new JComboBox<String>();
		txtEquiponame.addActionListener(this);
		txtEquiponame.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEquiponame.setBounds(245, 27, 250, 34);
		topPanel.add(txtEquiponame);

		lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(63, 81, 68, 34);
		topPanel.add(lblUser);

		textFieldUSer = new JComboBox<String>();
		textFieldUSer.addActionListener(this);
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldUSer.setBounds(245, 81, 250, 34);
		topPanel.add(textFieldUSer);

		JLabel lblMsgError = new JLabel("");
		lblMsgError.setBounds(448, 235, 360, 41);
		contentPane.add(lblMsgError);

		bottomPanel = new JPanel();
		bottomPanel.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		bottomPanel.setBounds(310, 253, 674, 417);
		contentPane.add(bottomPanel);
		bottomPanel.setLayout(null);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasena.setBounds(80, 46, 90, 35);
		bottomPanel.add(lblContrasena);

		lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(80, 105, 90, 34);
		bottomPanel.add(lblCargo);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldContrasena.setBounds(245, 47, 250, 34);
		bottomPanel.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldCargo = new JComboBox<String>();
		textFieldCargo.setBounds(245, 105, 250, 34);
		textFieldCargo.addItem("Primer_entrenador");
		textFieldCargo.addItem("Segundo_entrenador");
		bottomPanel.add(textFieldCargo);

		btnEliminarEntrenador = new JButton("Eliminar entrenador");
		btnEliminarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarEntrenador.setBounds(442, 308, 200, 35);
		bottomPanel.add(btnEliminarEntrenador);
		btnEliminarEntrenador.addActionListener(this);

		btnModificarEntrenador = new JButton("Modificar Entrenador");
		btnModificarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarEntrenador.setBounds(204, 308, 200, 35);
		btnModificarEntrenador.addActionListener(this);
		bottomPanel.add(btnModificarEntrenador);

		bottomPanel.setVisible(false);

		fillEquiposNames();

	}

	/**
	 * Fills the JComboBox with the names of all available teams.
	 */
	public void fillEquiposNames() {
		txtEquiponame.removeAllItems();
		for (String equipo : controller.getEquipos()) {
			txtEquiponame.addItem(equipo);
		}
	}

	/**
	 * Fills the JComboBox with the names of coaches associated with the specified
	 * team.
	 *
	 * @param nombreEquipo The name of the team for which coaches are to be
	 *                     retrieved.
	 */
	public void fillEntrenadoresEquipo(String nombreEquipo) {
		textFieldUSer.removeAllItems(); // Clear items from JComboBox
		String primEntrenador = controller.getPrimEntrenador(nombreEquipo);
		String segEntrenador = controller.getSegEntrenador(nombreEquipo);

		if (primEntrenador != null) {
			textFieldUSer.addItem(primEntrenador);
		}
		if (segEntrenador != null) {
			textFieldUSer.addItem(segEntrenador);
		}
	}

	/**
	 * Fills the user data fields based on the provided username.
	 *
	 * @param miUser The username for which user data is to be filled.
	 */
	public void fillUserData(String miUser) {
		Entrenador usr = (Entrenador) controller.getUsuario2(miUser);
		if (usr != null) {
			textFieldContrasena.setText(usr.getContrasenia());
			CargoEntrenador cargo = usr.getCargo();

			if (cargo == CargoEntrenador.PRIMER_ENTRENADOR) {
				textFieldCargo.setSelectedItem("Primer_entrenador");
			} else if (cargo == CargoEntrenador.SEGUNDO_ENTRENADOR) {
				textFieldCargo.setSelectedItem("Segundo_entrenador");
			}
		}
	}

	/**
	 * Handles action events generated by the various buttons in the GUI.
	 *
	 * @param e the action event
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnCrearPartido) {
			CrearPartido cPartido = new CrearPartido(controller);
			this.dispose();
			cPartido.setVisible(true);
		} else if (o == btnAddEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			this.dispose();
			gestionarEntre.setVisible(true);

		} else if (o == btnGestionarEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			this.dispose();
			gestionarEntre.setVisible(true);

		} else if (o == btnGestionarEquipo) {
			MenuAdmin cEquipo = new MenuAdmin(controller);
			this.dispose();
			cEquipo.setVisible(true);
		} else if (o == btnLogOut) {
			this.dispose();
			controller.logOut();
		} else if (o == btnModPartidos) {
			ModificarPartido modPartido = new ModificarPartido(controller);
			this.dispose();
			modPartido.setVisible(true);
		} else if (o == txtEquiponame && e.getActionCommand().equals("comboBoxChanged")) {
			// User selected a team name
			if (txtEquiponame.getSelectedItem() != null) {
				String selectedTeam = (String) txtEquiponame.getSelectedItem();
				fillEntrenadoresEquipo(selectedTeam); // Update userTextField with team's players
			}
		} else if (o == textFieldUSer && e.getActionCommand().equals("comboBoxChanged")) {
			// User selected a player
			if (textFieldUSer.getSelectedItem() != null) {
				String selectedUser = (String) textFieldUSer.getSelectedItem();
				fillUserData(selectedUser); // Display selected user's information
				bottomPanel.setVisible(true);

			}

		} else if (o == btnEliminarEntrenador) {
			if (controller.borrarEntrenador(textFieldUSer.getSelectedItem().toString())) {
				int opcion = JOptionPane.showConfirmDialog(this,
						"El entrenador ha sido eliminado correctamente\n¿Desea eliminar otro entrenador?", "",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin g1 = new MenuAdmin(controller);
					g1.setVisible(true);
				}
			}
		} else if (o == btnModificarEntrenador) {
			String usr = textFieldUSer.getSelectedItem().toString();
			String password = textFieldContrasena.getText();
			String tipoString = (String) textFieldCargo.getSelectedItem();
			CargoEntrenador tipo = null;
			if (tipoString.equals("Primer_entrenador")) {
				tipo = CargoEntrenador.PRIMER_ENTRENADOR;
			} else if (tipoString.equals("Segundo_entrenador")) {
				tipo = CargoEntrenador.SEGUNDO_ENTRENADOR;
			}

			if (controller.modificarEntrenador(usr, password, tipo)) {
				int opcion = JOptionPane.showConfirmDialog(this, "",
						"El entrenador ha sido modificado correctamente\n¿Desea modificar otro entrenador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin g1 = new MenuAdmin(controller);
					g1.setVisible(true);
				}
			}
		}
	}

}