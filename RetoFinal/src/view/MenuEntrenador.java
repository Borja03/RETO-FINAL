package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import model.equipos.Equipo;
import model.partido.Juegan;
import model.usuarios.Entrenador;
import model.usuarios.Jugador;

/**
 * The MenuEntrenador class represents the main menu interface for an Entrenador
 * (Coach) user type. It provides options to view team information, manage
 * players, view matches, and change password. This class extends JFrame and
 * implements the ActionListener interface.
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class MenuEntrenador extends JFrame implements ActionListener {
	/**
	 * Unique identifier for serializing the class.
	 */
	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The main content pane of the view.
	 */
	private JPanel contentPane;

	/**
	 * Button for logging out.
	 */
	private JButton btnLogOut;

	/**
	 * Button for accessing team information.
	 */
	private JButton btnConsultarEquipo;

	/**
	 * Button for managing players.
	 */
	private JButton btnGestJugadores;

	/**
	 * Button for accessing match information.
	 */
	private JButton btnConsultarPartidos;

	/**
	 * Button for changing password.
	 */
	private JButton btnCambiarContrasena;

	/**
	 * Reference to the controller for handling actions.
	 */
	private Controller controller;

	/**
	 * Label for welcoming the user.
	 */
	private JLabel lblWelcome;

	/**
	 * Label for displaying the user's profile picture.
	 */
	private JLabel lblUserPic;

	/**
	 * Label for indicating adding a profile picture.
	 */
	private JLabel lblBtnAddPic;

	/**
	 * Username of the current user.
	 */
	private String userName;

	/**
	 * Type of user logged in.
	 */
	private String userType;

	/**
	 * Text field for entering the team's name.
	 */
	private JTextField txtEqNombre;

	/**
	 * Text field for entering the team's stadium.
	 */
	private JTextField txtEqEstadio;

	/**
	 * Text field for entering the team's titles.
	 */
	private JTextField txtEqTitulos;

	/**
	 * Text field for entering the team's first coach.
	 */
	private JTextField txtEqPrimerEntre;

	/**
	 * Text field for entering the team's second coach.
	 */
	private JTextField txtEqSegundoEntre;

	/**
	 * Table for displaying team information.
	 */
	private JTable table;

	/**
	 * Scroll pane for the team information table.
	 */
	private JScrollPane scrollPane_1;

	/**
	 * Name of the team being viewed.
	 */
	private String nombreEquipo;

	/**
	 * Blob object representing the team's logo.
	 */
	private Blob teamLogo;

	/**
	 * Label for indicating the list of players.
	 */
	private JLabel lblJugadoresLista;

	/**
	 * Array of buttons for the left panel.
	 */
	private JButton[] leftPanelButtons;

	/**
	 * Icon representing the profile picture.
	 */
	private ImageIcon imageIcon;

	/**
	 * Blob object representing the user's profile picture.
	 */
	private Blob usrBlobIcon;

	/**
	 * Button for uploading a profile picture.
	 */
	private JButton btnUpload;
	 

	/**
	 * Constructor for the MenuEntrenador class. Initializes the main menu for an
	 * Entrenador user type.
	 * 
	 * @param cont          The controller instance for handling business logic.
	 * @param entrConnected The username of the connected Entrenador.
	 * @param userType      The type of user (Entrenador in this case).
	 */
	public MenuEntrenador(Controller cont, String entrConnected, String userType) {
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

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(86, 82, 252));
		panelLeft.setBounds(0, 0, 250, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnConsultarEquipo = new JButton("     Consultar Equipo");
		btnConsultarEquipo.setForeground(new Color(255, 255, 255));
		btnConsultarEquipo.addActionListener(this);

		lblBtnAddPic = new JLabel();
		lblBtnAddPic.setBounds(160, 140, 50, 50);
		lblBtnAddPic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userUploadImgDialog();

			}
		});

		ImageIcon imgIcone = new ImageIcon(getClass().getResource("/images/icons/add.png"));
		Image imageUsere = imgIcone.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblBtnAddPic.setForeground(SystemColor.activeCaption);
		lblBtnAddPic.setIcon(new ImageIcon(imageUsere));

		panelLeft.add(lblBtnAddPic);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(100, 100, 100));
		btnConsultarEquipo.setBounds(0, 395, 250, 49);
		panelLeft.add(btnConsultarEquipo);

		btnGestJugadores = new JButton("     Gestionar  jugadores");
		btnGestJugadores.setForeground(new Color(255, 255, 255));
		btnGestJugadores.addActionListener(this);
		btnGestJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestJugadores.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		btnGestJugadores.setFocusable(false);
		btnGestJugadores.setBorder(null);
		btnGestJugadores.setBackground(new Color(86, 82, 252));
		btnGestJugadores.setBounds(0, 332, 250, 49);
		panelLeft.add(btnGestJugadores);

		lblWelcome = new JLabel("Welcome " + entrConnected);
		lblWelcome.setBackground(new Color(240, 240, 240));
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		lblWelcome.setBounds(23, 205, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Consultar Partidos");
		btnConsultarPartidos.setForeground(new Color(255, 255, 255));
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(86, 82, 252));
		btnConsultarPartidos.setBounds(0, 454, 250, 49);
		panelLeft.add(btnConsultarPartidos);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(0, 586, 250, 49);
		panelLeft.add(btnLogOut);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);

		btnLogOut.setBackground(new Color(86, 82, 252));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));

		btnCambiarContrasena = new JButton("     Cambiar contraseña");
		btnCambiarContrasena.setForeground(new Color(255, 255, 255));
		btnCambiarContrasena.addActionListener(this);

		lblUserPic = new JLabel();
		lblUserPic.setBackground(SystemColor.activeCaption);
		lblUserPic.setForeground(SystemColor.activeCaption);
		lblUserPic.setBounds(50, 33, 150, 150);
		panelLeft.add(lblUserPic);

		btnCambiarContrasena.setBounds(0, 513, 250, 49);
		panelLeft.add(btnCambiarContrasena);
		btnCambiarContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarContrasena.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		btnCambiarContrasena.setFocusable(false);
		btnCambiarContrasena.setBorder(null);
		btnCambiarContrasena.setBackground(new Color(86, 82, 252));

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 128, 64));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(260, 0, 718, 178);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		lblNombre.setBounds(204, 39, 82, 22);
		panel.add(lblNombre);

		JLabel lblNewLabel = new JLabel("Equipo info");
		lblNewLabel.setBounds(286, 10, 104, 22);
		lblNewLabel.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		JLabel lblEqEstadio = new JLabel("Estadio :");
		lblEqEstadio.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		lblEqEstadio.setBounds(204, 67, 82, 22);
		panel.add(lblEqEstadio);

		JLabel lblTitulos = new JLabel("Titulos :");
		lblTitulos.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		lblTitulos.setBounds(204, 93, 82, 22);
		panel.add(lblTitulos);

		JLabel lblPrimerEntrenador = new JLabel("Primer entrenador :");
		lblPrimerEntrenador.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		lblPrimerEntrenador.setBounds(204, 116, 162, 22);
		panel.add(lblPrimerEntrenador);

		JLabel lblSegundoEntrenador = new JLabel("Segundo entrenador :");
		lblSegundoEntrenador.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		lblSegundoEntrenador.setBounds(204, 145, 162, 22);
		panel.add(lblSegundoEntrenador);

		txtEqNombre = new JTextField();
		txtEqNombre.setBounds(368, 40, 254, 25);
		panel.add(txtEqNombre);
		txtEqNombre.setEditable(false);
		txtEqNombre.setColumns(10);

		txtEqEstadio = new JTextField();
		txtEqEstadio.setColumns(10);
		txtEqEstadio.setBounds(368, 68, 254, 25);
		txtEqEstadio.setEditable(false);
		panel.add(txtEqEstadio);

		txtEqTitulos = new JTextField();
		txtEqTitulos.setColumns(10);
		txtEqTitulos.setBounds(368, 94, 254, 25);
		txtEqTitulos.setEditable(false);
		panel.add(txtEqTitulos);

		txtEqPrimerEntre = new JTextField();
		txtEqPrimerEntre.setColumns(10);
		txtEqPrimerEntre.setBounds(368, 120, 254, 25);
		txtEqPrimerEntre.setEditable(false);
		panel.add(txtEqPrimerEntre);

		txtEqSegundoEntre = new JTextField();
		txtEqSegundoEntre.setEditable(false);
		txtEqSegundoEntre.setColumns(10);
		txtEqSegundoEntre.setBounds(368, 149, 254, 25);
		panel.add(txtEqSegundoEntre);

		JLabel lblEqLogo = new JLabel();

		nombreEquipo = controller.getMyTeam(userName, userType);
		ImageIcon defaultLogo = new ImageIcon("src/images/icons/equiposinlogo.png");
		teamLogo = controller.getEquipo(nombreEquipo).getLogo();
		if (teamLogo != null) {
			try {
				byte[] imageData = teamLogo.getBytes(1, (int) teamLogo.length());
				if (imageData != null && imageData.length > 0) {
					ImageIcon icon = new ImageIcon(imageData);
					Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
					ImageIcon scaledIcon = new ImageIcon(image);
					lblEqLogo.setIcon(scaledIcon);
				}
			} catch (SQLException e) {
				System.err.println("Error reading image data from Blob: " + e.getMessage());
				e.printStackTrace();
			}
		}else {
		    lblEqLogo.setIcon(defaultLogo);
		}

		lblEqLogo.setBounds(15, 15, 150, 150);
		panel.add(lblEqLogo);

		ArrayList<Jugador> dataList = controller.getJugadoresPorEquipo(nombreEquipo);

		String[] columnNames = { "Nombre", "Dorsal", "Goles", "Asistencias" };
		Object[][] data = new Object[dataList.size()][4];

		for (int i = 0; i < dataList.size(); i++) {
			Jugador obj = dataList.get(i);
			data[i][0] = obj.getUser();
			data[i][1] = obj.getDorsal();
			data[i][2] = obj.getGoles();
			data[i][3] = obj.getAsistencias();
		}

		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(296, 219, 648, 461);
		contentPane.add(scrollPane_1);

		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane_1.setViewportView(scrollPane);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);

		lblJugadoresLista = new JLabel("Jugadores lista :");
		lblJugadoresLista.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblJugadoresLista.setBounds(547, 188, 191, 22);
		contentPane.add(lblJugadoresLista);

		// Crear un array que contenga los botones del panel izquierdo
		// Crear un array que contenga los botones del panel izquierdo
		leftPanelButtons = new JButton[] { btnConsultarEquipo, btnGestJugadores, btnConsultarPartidos,
				btnCambiarContrasena, btnLogOut };

		// Añadir acciones de mouse a cada botón en el array, excepto para "Consultar
		// Equipo"
		for (JButton button : leftPanelButtons) {
			if (button != btnConsultarEquipo) {
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
					}

					@Override
					public void mouseExited(MouseEvent e) {
						button.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
					}

					@Override
					public void mousePressed(MouseEvent e) {
						button.setBackground(new Color(50, 50, 50)); // Cambia el color al presionar
					}
				});
			}
		}

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/icons/add.png"));
		Image imageUser = imgIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		Entrenador entrenador = controller.getUsuario2(entrConnected);
		if (entrenador.getPicProfile() != null) {
			System.out.println("image is not null");
			try {
				byte[] imageData = entrenador.getPicProfile().getBytes(1, (int) entrenador.getPicProfile().length());
				if (imageData != null && imageData.length > 0) {
					ImageIcon icon2 = new ImageIcon(imageData);
					Image image2 = icon2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
					ImageIcon scaledIcon2 = new ImageIcon(image2);
					lblUserPic.setIcon(scaledIcon2);
				} else {
					// If imageData is null or empty, set a default image
					ImageIcon defaultIcon = new ImageIcon("src/images/icons/default.png");
					lblUserPic.setIcon(defaultIcon);
				}
			} catch (SQLException e) {
				System.err.println("Error reading image data from Blob: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			// If the player's profile picture is null, set a default image
			ImageIcon defaultIcon = new ImageIcon("src/images/icons/default.png");
			lblUserPic.setIcon(defaultIcon);
		}

		fillEquipoInfo();
		fillEntrenadoresInfo();
		this.setVisible(true);
	}

	/**
	 * Fills the UI with information about the team.
	 */
	public void fillEquipoInfo() {
		nombreEquipo = controller.getMyTeam(userName, userType);
		
		ArrayList<Juegan> misPartidos = controller.consultarPartidoEquipo(nombreEquipo);
		for (Juegan partido : misPartidos) {
			
		    LocalDateTime fechaMasPartidoDuracion = partido.getFechaInicio().plusMinutes(120);
		    
		    if (LocalDateTime.now().isAfter(fechaMasPartidoDuracion)) {
		        if (!partido.isAssistUpdated()) {
		            controller.updateAsistencias(
		                partido.getNombreEquipoLocal(),
		                partido.getNombreEquipoVisitante(),
		                partido.getFechaInicio()
		            );
		        }
		    }
		}
		Equipo eq = controller.getEquipo(nombreEquipo);
		txtEqNombre.setText(eq.getNombreEquipo());
		txtEqEstadio.setText(eq.getEstadio());
		txtEqTitulos.setText(eq.getTitulos() + "");
	}

	/**
	 * Fills the UI with information about the trainers.
	 */
	public void fillEntrenadoresInfo() {
		String primEntrenador = controller.getPrimEntrenador(nombreEquipo);
		String segEntrenador = controller.getSegEntrenador(nombreEquipo);

		txtEqPrimerEntre.setText(primEntrenador);
		txtEqSegundoEntre.setText(segEntrenador);
	}

	/**
	 * Loads a custom font from a given file path.
	 * 
	 * @param fontPath The path to the font file.
	 * @param style    The style of the font (e.g., Font.PLAIN).
	 * @param size     The size of the font.
	 * @return The loaded Font object.
	 */
	private Font loadFont(String fontPath, int style, float size) {
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(fontPath))
					.deriveFont(style, size);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
			return customFont;
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Displays a dialog for the user to upload an image.
	 */
	private void userUploadImgDialog() {
	    JFileChooser fileChooser = new JFileChooser();
	    int result = fileChooser.showOpenDialog(null);

	    if (result == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();
	        if (selectedFile != null) {
	            try {
	                Path imagePath = selectedFile.toPath();
	                byte[] imageData = Files.readAllBytes(imagePath);
	                usrBlobIcon = new javax.sql.rowset.serial.SerialBlob(imageData);
	                imageIcon = new ImageIcon(imageData);
	                lblUserPic.setIcon(imageIcon);

	                if (controller.updateUsrIcon(userName, usrBlobIcon, userType)) {
	                    JOptionPane.showMessageDialog(MenuEntrenador.this, "Image uploaded to database!",
	                            "Success", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(MenuEntrenador.this, "Failed to upload image to database!",
	                            "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            } catch (SerialException e1) {
	                e1.printStackTrace();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	    } else {
	        // User canceled the upload, do nothing
	    }	

	}

	/**
	 * Handles actionPerformed events for UI buttons.
	 * 
	 * @param e The ActionEvent object representing the event.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogOut) {

			this.dispose();
			controller.logOut();

		} else if (e.getSource() == btnGestJugadores) {
			GestionarJugadores g1 = new GestionarJugadores(controller, userName, userType, nombreEquipo);
			g1.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
			consultarPartidos.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnCambiarContrasena) {
			CambiarContra cambiarContra = new CambiarContra(controller, userName, userType);
			cambiarContra.setVisible(true);
			this.dispose();
		}

	}
}