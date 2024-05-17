package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.Controller;
import model.partido.Juegan;
import utlidades.Util;

/**
 * The ConsultarPartidos class represents a JFrame for viewing football (soccer)
 * matches. It provides functionality for both players and coaches to view
 * upcoming matches for their team. Users can interact with the interface to
 * perform actions such as logging out, changing settings, and navigating to
 * other functionalities. The Splash class represents the splash screen of the
 * application.
 * 
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class ConsultarPartidos extends JFrame implements ActionListener {
	/**
	 * Unique identifier for serializing the class.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel that contains the main content of the GUI.
	 */
	private JPanel contentPane;
	/**
	 * Reference to the controller handling the GUI logic.
	 */
	private Controller controller;

	/**
	 * Button for logging out.
	 */
	private JButton btnLogOut;
	/**
	 * Button for consulting team details.
	 */
	private JButton btnConsultarEquipo;

	/**
	 * Button for managing players.
	 */
	private JButton btnGestJugadores;

	/**
	 * Label displaying a welcome message.
	 */
	private JLabel lblWelcome;

	/**
	 * Label displaying the user's profile picture.
	 */
	private JLabel lblUserPic;
	/**
	 * Button for consulting match details.
	 */
	private JButton btnConsultarPartidos;
	/**
	 * The username of the current user.
	 */
	private String userName;
	/**
	 * Scroll pane used in the GUI.
	 */
	private JScrollPane scrollPane;
	/**
	 * Panel containing cards for various GUI views.
	 */
	private JPanel cardsPanel;
	/**
	 * Represents the type of user currently logged in.
	 */
	private String userType;
	/**
	 * Button for changing passwords.
	 */
	private JButton btnCambiarContrasena;
	/**
	 * Additional buttons for consulting team details, match details, changing
	 * dorsal, changing password, and logging out.
	 */
	private JButton btnConsultarEquipoj, btnConsultarPartidosj, btnCambiarDorsalj, btnCambiarContj, btnLogOutj;

	/**
	 * Constructs a new ConsultarPartidos JFrame.
	 * 
	 * @param cont          The Controller instance for handling business logic.
	 * @param entrConnected The username of the currently logged-in user.
	 * @param userType      The type of user (e.g., "jugador" or "entrenador").
	 */
	public ConsultarPartidos(Controller cont, String entrConnected, String userType) {
		this.controller = cont;
		this.userName = entrConnected;
		this.userType = userType;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		// Left panel
		// Right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(256, 10, 728, 660);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		contentPane.add(rightPanel);

		cardsPanel = new JPanel();
		cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane(cardsPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		rightPanel.add(scrollPane, BorderLayout.CENTER);
		rightPanel.add(scrollPane);

		String miEquipo = controller.getMyTeam(userName, userType);
		System.out.println(miEquipo);
		ArrayList<Juegan> misPartidos = controller.consultarPartidoEquipo(miEquipo);
		ImageIcon logo1;
		ImageIcon logo2;
		String estadio;
		ImageIcon defaultLogo = new ImageIcon("src/images/icons/equiposinlogo.png");
		
		for (int i = 0; i < misPartidos.size(); i++) {
			Blob logo1Blob = controller.getEquipo(misPartidos.get(i).getNombreEquipoLocal()).getLogo();
			Blob logo2Blob = controller.getEquipo(misPartidos.get(i).getNombreEquipoVisitante()).getLogo();
			estadio = controller.getNombreEstadio(misPartidos.get(i));
			logo1 = Util.blobToImgIcon(logo1Blob);
			logo2 = Util.blobToImgIcon(logo2Blob);

			if (logo1 == null) {
				logo1 = defaultLogo;
			}
			if (logo2 == null) {
				logo2 = defaultLogo;
			}

			if (misPartidos.get(i).getFechaInicio().isAfter(LocalDateTime.now())) {
				miCard(misPartidos.get(i).getNombreEquipoLocal(), logo1, misPartidos.get(i).getNombreEquipoVisitante(),
						logo2, misPartidos.get(i).getFechaInicio().toString(), estadio, (20 + (180 * i)));
			}

		}

		setVisible(true);
		// chosing mleft menu based on user type
		if (userType.equalsIgnoreCase("jugador")) {
			showMenuJugador();
		} else if (userType.equalsIgnoreCase("entrenador")) {
			showMenuEntrenador();
		}
	}

	/**
	 * Sets up the left menu panel with options specific to a jugador (player) user.
	 */
	public void showMenuJugador() {
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(null);
		panelLeft.setBackground(new Color(33, 199, 162));
		panelLeft.setBounds(0, 0, 250, 680);
		contentPane.add(panelLeft);

		lblUserPic = new JLabel();
		lblUserPic.setForeground(SystemColor.activeCaption);
		lblUserPic.setBackground(SystemColor.activeCaption);
		lblUserPic.setBounds(54, 33, 150, 150);
		panelLeft.add(lblUserPic);

		btnLogOutj = new JButton("     Log Out");
		btnLogOutj.addActionListener(this);
		btnLogOutj.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOutj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogOutj.setFocusable(false);
		btnLogOutj.setBorder(null);
		btnLogOutj.setBackground(new Color(33, 199, 162));
		btnLogOutj.setBounds(0, 546, 250, 49);
		panelLeft.add(btnLogOutj);

		btnCambiarContj = new JButton("     Cambiar Contraseña");
		btnCambiarContj.setForeground(new Color(255, 255, 255));
		btnCambiarContj.setBounds(0, 476, 250, 49);
		btnCambiarContj.addActionListener(this);
		btnCambiarContj.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarContj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarContj.setFocusable(false);
		btnCambiarContj.setBorder(null);
		btnCambiarContj.setBackground(new Color(33, 199, 162));
		panelLeft.add(btnCambiarContj);

		btnCambiarDorsalj = new JButton("     Cambiar Dorsal");
		btnCambiarDorsalj.setForeground(new Color(255, 255, 255));
		btnCambiarDorsalj.setBounds(0, 406, 250, 49);
		btnCambiarDorsalj.addActionListener(this);
		btnCambiarDorsalj.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsalj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsalj.setFocusable(false);
		btnCambiarDorsalj.setBorder(null);
		btnCambiarDorsalj.setBackground(new Color(33, 199, 162));
		panelLeft.add(btnCambiarDorsalj);

		lblWelcome = new JLabel("     Welcome " + userName);
		lblWelcome.setBounds(10, 228, 217, 34);
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLeft.add(lblWelcome);

		btnConsultarPartidosj = new JButton("     Consultar Partidos");
		btnConsultarPartidosj.setForeground(new Color(255, 255, 255));
		btnConsultarPartidosj.setBounds(0, 338, 250, 49);
		btnConsultarPartidosj.addActionListener(this);
		btnConsultarPartidosj.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidosj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidosj.setFocusable(false);
		btnConsultarPartidosj.setBorder(null);
		btnConsultarPartidosj.setBackground(new Color(26, 169, 185));
		panelLeft.add(btnConsultarPartidosj);

		btnConsultarEquipoj = new JButton("     Consultar Equipo");
		btnConsultarEquipoj.setForeground(new Color(255, 255, 255));
		btnConsultarEquipoj.addActionListener(this);
		btnConsultarEquipoj.setBounds(0, 271, 250, 49);
		btnConsultarEquipoj.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipoj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipoj.setFocusable(false);
		btnConsultarEquipoj.setBorder(null);
		btnConsultarEquipoj.setBackground(new Color(33, 199, 162));
		panelLeft.add(btnConsultarEquipoj);
	}

	/**
	 * Sets up the left menu panel with options specific to a entrenador (coach)
	 * user.
	 */
	public void showMenuEntrenador() {
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

		btnGestJugadores = new JButton("     Gestionar  jugadores");
		btnGestJugadores.setForeground(new Color(255, 255, 255));
		btnGestJugadores.addActionListener(this);
		btnGestJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestJugadores.setFocusable(false);
		btnGestJugadores.setBorder(null);
		btnGestJugadores.setBackground(new Color(86, 82, 252));
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
				btnGestJugadores.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestJugadores.setBackground(new Color(50, 50, 50)); // Cambia el color al presionar
			}
		});

		lblWelcome = new JLabel("Welcome " + userName);
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
		btnConsultarPartidos.setBackground(new Color(100, 100, 100));
		btnConsultarPartidos.setBounds(0, 454, 250, 49);
		panelLeft.add(btnConsultarPartidos);

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

		btnCambiarContrasena = new JButton("     Cambiar contraseña");
		btnCambiarContrasena.setForeground(new Color(255, 255, 255));
		btnCambiarContrasena.addActionListener(this);
		btnCambiarContrasena.setBounds(0, 513, 250, 49);
		panelLeft.add(btnCambiarContrasena);
		btnCambiarContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarContrasena.setFocusable(false);
		btnCambiarContrasena.setBorder(null);
		btnCambiarContrasena.setBackground(new Color(86, 82, 252));
		// Action listener para el botón "Cambiar contraseña"
		btnCambiarContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarContrasena.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarContrasena.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarContrasena.setBackground(new Color(50, 50, 50)); // Cambia el color al presionar
			}
		});

	}

	/**
	 * Constructs a visual representation of a match and adds it to the cardsPanel.
	 * 
	 * @param eqLocal     The name of the local team.
	 * @param logo1       The ImageIcon representing the logo of the local team.
	 * @param EqVisitante The name of the visiting team.
	 * @param logo2       The ImageIcon representing the logo of the visiting team.
	 * @param dateTime    The date and time of the match.
	 * @param estadio     The name of the stadium where the match will be held.
	 * @param high        The vertical position of the match panel within the
	 *                    cardsPanel.
	 */

	public void miCard(String eqLocal, ImageIcon logo1, String EqVisitante, ImageIcon logo2, String dateTime,
			String estadio, int high) {

		JPanel partidoPanel = new JPanel(new BorderLayout());
		partidoPanel.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		partidoPanel.setBounds(10, high, 718, 150);
		partidoPanel.setBorder(new LineBorder(Color.blue, 3));
		partidoPanel.setPreferredSize(new Dimension(710, 170));
		partidoPanel.setMaximumSize(new Dimension(710, 170));
		partidoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		partidoPanel.setLayout(null);

		JLabel lblEqLocal = new JLabel(eqLocal);
		lblEqLocal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEqLocal.setBounds(170, 58, 150, 22); // Adjusted x-coordinate to create space
		partidoPanel.add(lblEqLocal);

		JLabel lblEqLogo = new JLabel();
		ImageIcon imgIcon = logo1;
		lblEqLogo.setIcon(imgIcon);
		lblEqLogo.setBounds(15, 15, 150, 150);
		partidoPanel.add(lblEqLogo);

		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVs.setBounds(350, 58, 40, 22);
		partidoPanel.add(lblVs);

		JLabel lblEqVistante = new JLabel(EqVisitante);
		lblEqVistante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEqVistante.setBounds(400, 58, 150, 22); // Adjusted x-coordinate to create space
		partidoPanel.add(lblEqVistante);

		JLabel lblEqLogo1 = new JLabel();
		ImageIcon imgIcon2 = logo2;
		lblEqLogo1.setIcon(imgIcon2);
		lblEqLogo1.setBounds(550, 15, 150, 150); // Adjusted x-coordinate to minimize space
		partidoPanel.add(lblEqLogo1);

		JLabel lblFechaYHora = new JLabel(dateTime);
		lblFechaYHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaYHora.setBounds(300, 111, 150, 22);
		partidoPanel.add(lblFechaYHora);

		JLabel lblEstadio = new JLabel("Estadio : " + estadio);
		lblEstadio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstadio.setBounds(300, 143, 300, 22);
		partidoPanel.add(lblEstadio);

		cardsPanel.add(partidoPanel);
	}

	/**
	 * Handles action events triggered by user interactions with buttons.
	 * 
	 * @param e The ActionEvent to be processed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		} else if (e.getSource() == btnGestJugadores) {
			String myTeam = "";
			GestionarJugadores g1 = new GestionarJugadores(controller, userName, userType, myTeam);
			g1.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName, userType);
			menuEntrenador.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnCambiarContrasena) {
			CambiarContra cambiarContra = new CambiarContra(controller, userName, userType);
			cambiarContra.setVisible(true);
			this.dispose();
		}

		// for jugador menu

		if (e.getSource() == btnLogOutj) {
			controller.logOut();
			this.dispose();
		} else if (e.getSource() == btnCambiarDorsalj) {
			CambiarDorsal ventanaDorsal = new CambiarDorsal(controller, userName, userType);
			ventanaDorsal.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnConsultarPartidosj) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
			consultarPartidos.setVisible(true);
			this.dispose();

		} else if (e.getSource() == btnConsultarEquipoj) {
			MenuJugador menuJugador = new MenuJugador(controller, userName, userType);
			menuJugador.setVisible(true);
			this.dispose();
		}if (e.getSource() == btnCambiarContj) {
			CambiarContra cambiarContra = new CambiarContra(controller, userName, userType);
			cambiarContra.setVisible(true);
			this.dispose();
		}
	}

}