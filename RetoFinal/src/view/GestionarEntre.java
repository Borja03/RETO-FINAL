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
import model.equipos.Equipo;
import model.usuarios.CargoEntrenador;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * JFrame for managing coaches.
 * 
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class GestionarEntre extends JFrame implements ActionListener {
	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel that contains the main content of the GUI.
	 */
	private JPanel contentPane;
	/**
	 * Button for creating entities.
	 */
	private JButton btnCrear;
	/**
	 * Button for deleting or modifying entities.
	 */
	private JButton btnDeleteMod;
	/**
	 * Reference to the controller handling the GUI logic.
	 */
	private Controller controller;
	/**
	 * Button for logging out.
	 */
	private JButton btnLogOut;
	/**
	 * Button for modifying match details.
	 */
	private JButton btnModPartidos;
	/**
	 * Label displaying a welcome message.
	 */
	private JLabel lblWelcome;

	/**
	 * Button for managing teams.
	 */
	private JButton btnGestionarEquipo;

	/**
	 * Button for creating a new match.
	 */
	private JButton btnCrearPartido;
	/**
	 * Label displaying the username.
	 */
	private JLabel lblUser;
	/**
	 * Label displaying the password.
	 */
	private JLabel lblContrasena;
	/**
	 * Label displaying the user's role or position.
	 */
	private JLabel lblCargo;

	/**
	 * Text field for entering the username.
	 */
	private JTextField textFieldUSer;

	/**
	 * Text field for entering the password.
	 */
	private JTextField textFieldContrasena;
	/**
	 * Combo box for selecting the user's role or position.
	 */
	private JComboBox textFieldCargo;
	/**
	 * Button for adding new elements.
	 */
	private JButton btnAnadir;
	/**
	 * The username of the current user.
	 */
	private String user;

	/**
	 * The team associated with the current user.
	 */
	private String myTeam;
	/**
	 * Combo box for selecting the team.
	 */
	private JComboBox<String> textFieldEquipo;
	/**
	 * Represents the type of user currently logged in.
	 */
	private String userType;
	/**
	 * Button for managing coaches.
	 */
	private JButton btnGestionarEntrenador;


	/**
	 * Constructs a new GestionarEntre JFrame.
	 * 
	 * @param controller The Controller instance for handling business logic.
	 */
	public GestionarEntre(Controller controller) {
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		btnCrear = new JButton("Añadir Entrenadores");
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrear.setBounds(328, 40, 185, 35);
		btnCrear.setBackground(new Color(220, 3, 9));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		contentPane.add(btnCrear);

		btnDeleteMod = new JButton("Eliminar/Modificar entrenadores");
		btnDeleteMod.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteMod.setBounds(564, 40, 250, 35);
		btnDeleteMod.addActionListener(this);
		btnDeleteMod.setFocusable(false);
		btnDeleteMod.setBorder(null);
		contentPane.add(btnDeleteMod);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 250, 680);
		panelLeft.setBackground(new Color(242, 45, 45));
		contentPane.add(panelLeft);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(0, 595, 310, 49);
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
		panelLeft.setLayout(null);
		btnLogOut.setBackground(new Color(242, 45, 45));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnModPartidos = new JButton("     Modificar partidos");
		btnModPartidos.setForeground(new Color(255, 255, 255));
		btnModPartidos.setBounds(0, 446, 250, 49);
		btnModPartidos.addActionListener(this);
		btnModPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnModPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModPartidos.setFocusable(false);
		btnModPartidos.setBorder(null);
		btnModPartidos.setBackground(new Color(242, 45, 45));
		panelLeft.add(btnModPartidos);
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

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setBounds(10, 180, 217, 34);
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelLeft.add(lblWelcome);

		btnGestionarEquipo = new JButton("     Gestionar Equipo");
		btnGestionarEquipo.setForeground(new Color(255, 255, 255));
		btnGestionarEquipo.setBounds(0, 386, 250, 49);
		btnGestionarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEquipo.setFocusable(false);
		btnGestionarEquipo.setBorder(null);
		btnGestionarEquipo.setBackground(new Color(242, 45, 45));
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
		btnCrearPartido.setBounds(0, 327, 250, 49);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(242, 45, 45));
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
		btnGestionarEntrenador.setBounds(0, 275, 250, 49);
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(220, 3, 9));
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
		// formulario
		lblUser = new JLabel("Usuario");
		lblUser.setBounds(350, 207, 90, 35);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblUser);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(350, 267, 90, 35);
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblContrasena);

		lblCargo = new JLabel("Cargo entrenador");
		lblCargo.setBounds(350, 338, 185, 35);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblCargo);

		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(515, 208, 250, 34);
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(515, 274, 250, 34);
		textFieldContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldCargo = new JComboBox<String>();
		textFieldCargo.setBounds(515, 340, 250, 34);
		textFieldCargo.addItem("");
		textFieldCargo.addItem("Primer_entrenador");
		textFieldCargo.addItem("Segundo_entrenador");

		contentPane.add(textFieldCargo);

		btnAnadir = new JButton("Añadir enrtenador");
		btnAnadir.setBounds(751, 562, 200, 35);
		btnAnadir.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnAnadir);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(350, 150, 90, 35);
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblEquipo);

		textFieldEquipo = new JComboBox<String>();
		textFieldEquipo.setBounds(515, 152, 250, 34);
		contentPane.add(textFieldEquipo);
		btnAnadir.addActionListener(this);

		ArrayList<Equipo> equipos = controller.listarEquiposCP();
		for (Equipo eq : equipos) {
			textFieldEquipo.addItem(eq.getNombreEquipo());
		}
	}

	/**
	 * ActionListener implementation method. Handles button clicks and actions.
	 * 
	 * @param e The ActionEvent that occurred.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();
		int opcion = 0;
		String usr = textFieldUSer.getText();
		String password = textFieldContrasena.getText();
		String myTeam = (String) textFieldEquipo.getSelectedItem();
		String tipoString = (String) textFieldCargo.getSelectedItem();
		CargoEntrenador tipo = null;
		if (tipoString.equals("Primer_entrenador")) {
			tipo = CargoEntrenador.PRIMER_ENTRENADOR;
		} else if (tipoString.equals("Segundo_entrenador")) {
			tipo = CargoEntrenador.SEGUNDO_ENTRENADOR;
		}

		if (o == btnDeleteMod) {

			SearchEntrenador eliminarJugadores = new SearchEntrenador(controller);
			this.dispose();
			eliminarJugadores.setVisible(true);
		} else if (o == btnCrearPartido) {
			CrearPartido cPartidos = new CrearPartido(controller);
			this.dispose();
			cPartidos.setVisible(true);
		} else if (o == btnGestionarEquipo) {
			MenuAdmin cPartidos = new MenuAdmin(controller);
			this.dispose();
			cPartidos.setVisible(true);

		} else if (e.getSource() == btnModPartidos) {
			ModificarPartido modificarPartido = new ModificarPartido(controller);
			this.dispose();
			modificarPartido.setVisible(true);
		} else if (o == btnDeleteMod) {
			SearchEntrenador searchEntrenador = new SearchEntrenador(controller);
			this.dispose();
			searchEntrenador.setVisible(true);
		} else if (o == btnCrearPartido) {
			CrearPartido crearPartido = new CrearPartido(controller);
			this.dispose();
			crearPartido.setVisible(true);
		} else if (o == btnGestionarEquipo) {

		} else if (o == btnLogOut) {
			this.dispose();
			controller.logOut();

		} else if (e.getSource() == btnAnadir) {

			if (controller.crearEntrenador(myTeam, usr, password, tipo)) {
				opcion = JOptionPane.showConfirmDialog(this, (String) "",
						"El entrenador ha sido introducido correctamente\n¿Desea añadir otro jugador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin g1 = new MenuAdmin(controller);
					g1.setVisible(true);
				} else {
					GestionarEntre gestionarEntre = new GestionarEntre(controller);
					gestionarEntre.setVisible(true);
					this.dispose();
				}
			}else  {
	            JOptionPane.showMessageDialog(this, "Error al añadir el entrenador(Ya existe). Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
	        }

		}
	}
}