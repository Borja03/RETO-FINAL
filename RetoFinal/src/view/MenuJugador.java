
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import java.time.LocalTime;
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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.equipos.Equipo;
import model.partido.Juegan;
import model.usuarios.Jugador;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

/**
 * MenuJugador class represents the graphical user interface for the menu
 * options available to a player user. It allows the player to view and interact
 * with various functionalities related to their profile and team.
 * 
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class MenuJugador extends JFrame implements ActionListener {
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
	 * Button for changing password.
	 */
	private JButton btnCambiarCont;

	/**
	 * Button for changing player's dorsal number.
	 */
	private JButton btnCambiarDorsal;

	/**
	 * Reference to the controller for handling actions.
	 */
	private Controller controller;

	/**
	 * Label for welcoming the user.
	 */
	private JLabel lblWelcome;

	/**
	 * Username of the current user.
	 */
	private String userName;

	/**
	 * Button for accessing match information.
	 */
	private JButton btnConsultarPartidos;

	/**
	 * Button for accessing team information.
	 */
	private JButton btnConsultarEquipo;

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
	 * Type of user logged in.
	 */
	private String userType;

	/**
	 * Label for indicating the list of players.
	 */
	private JLabel lblJugadoresLista;

	/**
	 * Label for indicating the user's profile picture.
	 */
	private JLabel lblUserPic;

	/**
	 * Label for indicating adding a profile picture.
	 */
	private JLabel lblBtnAddPic;

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
	 * Constructs a new MenuJugador object.
	 * 
	 * @param cont          The controller object for handling interactions between
	 *                      the view and the model.
	 * @param userConnected The username of the currently logged-in user.
	 * @param userType      The type of user, in this case, "jugador" (player).
	 */
	public MenuJugador(Controller cont, String userConnected, String userType) {

		this.controller = cont;
		this.userName = userConnected;
		this.userType = userType;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panelLefts = new JPanel();
		panelLefts.setBounds(0, 0, 250, 680);
		panelLefts.setBackground(new Color(33, 199, 162));
		contentPane.add(panelLefts);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(0, 546, 250, 49);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);

		lblBtnAddPic = new JLabel();
		lblBtnAddPic.setBounds(160, 140, 50, 50);
		lblBtnAddPic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userUploadImgDialog();

			}
		});

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/icons/add.png"));
		Image imageUser = imgIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		panelLefts.setLayout(null);
		lblBtnAddPic.setForeground(SystemColor.activeCaption);
		panelLefts.add(lblBtnAddPic);
		lblBtnAddPic.setIcon(new ImageIcon(imageUser));
		btnLogOut.setBackground(new Color(33, 199, 162));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLefts.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarCont = new JButton("     Cambiar Contraseña");
		btnCambiarCont.setForeground(new Color(255, 255, 255));
		btnCambiarCont.setBounds(0, 476, 250, 49);
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(33, 199, 162));
		panelLefts.add(btnCambiarCont);

		btnCambiarDorsal = new JButton("     Cambiar Dorsal");
		btnCambiarDorsal.setForeground(new Color(255, 255, 255));
		btnCambiarDorsal.setBounds(0, 406, 250, 49);
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal.setFocusable(false);
		btnCambiarDorsal.setBorder(null);
		btnCambiarDorsal.setBackground(new Color(33, 199, 162));
		panelLefts.add(btnCambiarDorsal);

		lblWelcome = new JLabel("     Welcome " + userName);
		lblWelcome.setBounds(10, 228, 217, 34);
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLefts.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Consultar Partidos");
		btnConsultarPartidos.setForeground(new Color(255, 255, 255));
		btnConsultarPartidos.setBounds(0, 338, 250, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(33, 199, 162));
		panelLefts.add(btnConsultarPartidos);

		btnConsultarEquipo = new JButton("     Consultar Equipo");
		btnConsultarEquipo.setForeground(new Color(255, 255, 255));
		btnConsultarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultarEquipo.setBounds(0, 271, 250, 49);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(26, 169, 185));
		panelLefts.add(btnConsultarEquipo);

		lblUserPic = new JLabel();
		lblUserPic.setBounds(50, 33, 150, 150);
		lblUserPic.setBackground(SystemColor.activeCaption);
		lblUserPic.setForeground(new Color(0, 64, 128));
		panelLefts.add(lblUserPic);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(281, 10, 703, 178);
		panel.setForeground(new Color(255, 128, 64));
		panel.setBackground(SystemColor.menu);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(204, 39, 82, 22);
		panel.add(lblNombre);

		JLabel lblNewLabel = new JLabel("Equipo info");
		lblNewLabel.setBounds(286, 10, 104, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);

		JLabel lblEqEstadio = new JLabel("Estadio :");
		lblEqEstadio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEqEstadio.setBounds(204, 67, 82, 22);
		panel.add(lblEqEstadio);

		JLabel lblTitulos = new JLabel("Titulos :");
		lblTitulos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulos.setBounds(204, 93, 82, 22);
		panel.add(lblTitulos);

		JLabel lblPrimerEntrenador = new JLabel("Primer entrenador :");
		lblPrimerEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrimerEntrenador.setBounds(204, 116, 162, 22);
		panel.add(lblPrimerEntrenador);

		JLabel lblSegundoEntrenador = new JLabel("Segundo entrenador :");
		lblSegundoEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
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

		nombreEquipo = controller.getMyTeam(userName, "jugador");
		System.out.println(nombreEquipo);
		teamLogo = controller.getEquipo(nombreEquipo).getLogo();
	
		ImageIcon defaultLogo = new ImageIcon("src/images/icons/equiposinlogo.png");

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
		} else {
		    lblEqLogo.setIcon(defaultLogo);
		}
		
		
		
		
		
		lblEqLogo.setBounds(22, 10, 150, 150);
		panel.add(lblEqLogo);
		
		fillEquipoInfo();
		fillEntrenadoresInfo();

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

		for (Jugador jug : dataList) {
		    if (userName.equals(jug.getUser())) {
		        if (jug.getPicProfile() != null) {
		            try {
		                byte[] imageData = jug.getPicProfile().getBytes(1, (int) jug.getPicProfile().length());
		                if (imageData != null && imageData.length > 0) {
				            ImageIcon icon = new ImageIcon(imageData);
				            Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
				            ImageIcon scaledIcon = new ImageIcon(image);
		                    lblUserPic.setIcon(scaledIcon);
		                } else {
		                    // If image is null or empty in the database, show a default image
		                    ImageIcon defaultIcon = new ImageIcon("src/images/icons/default.png");
		                    lblUserPic.setIcon(defaultIcon);
		                }
		            } catch (SQLException e) {
		                System.err.println("Error reading image data from Blob: " + e.getMessage());
		                e.printStackTrace();
		            }
		        } else {
		            // If image is null in the database, show a default image
		            ImageIcon defaultIcon = new ImageIcon("src/images/icons/default.png");
		            lblUserPic.setIcon(defaultIcon);
		        }
		    }
		}


		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 235, 703, 435);
		contentPane.add(scrollPane_1);

		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane_1.setColumnHeaderView(scrollPane);

		lblJugadoresLista = new JLabel("Jugadores lista :");
		lblJugadoresLista.setBounds(535, 203, 191, 22);
		lblJugadoresLista.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblJugadoresLista);

		this.setVisible(true);


	}

	/**
	 * Fills the information related to the player's team in the GUI.
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
	 * Fills the information related to the coaches of the player's team in the GUI.
	 */
	public void fillEntrenadoresInfo() {
		String primEntrenador = controller.getPrimEntrenador(nombreEquipo);
		String segEntrenador = controller.getSegEntrenador(nombreEquipo);

		txtEqPrimerEntre.setText(primEntrenador);
		txtEqSegundoEntre.setText(segEntrenador);
	}

	/**
	 * Displays a dialog for the user to upload their profile picture.
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
			                    JOptionPane.showMessageDialog(MenuJugador.this, "Image uploaded to database!",
			                            "Success", JOptionPane.INFORMATION_MESSAGE);
			                } else {
			                    JOptionPane.showMessageDialog(MenuJugador.this, "Failed to upload image to database!",
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
	 * Handles the actionPerformed event for various buttons in the GUI.
	 * 
	 * @param e The ActionEvent object representing the event.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnLogOut) {
			controller.logOut();
			this.dispose();
		} else if (o == btnCambiarDorsal) {
			CambiarDorsal ventanaDorsal = new CambiarDorsal(controller, userName, userType);
			ventanaDorsal.setVisible(true);
			this.setVisible(false);
		} else if (o == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
			consultarPartidos.setVisible(true);
			this.dispose();

		} else if (o == btnCambiarCont) {
			CambiarContra ventanaCont = new CambiarContra(controller, userName, userType);
			ventanaCont.setVisible(true);
			this.dispose();
		}

	}

}