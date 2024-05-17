package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.sql.rowset.serial.SerialException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.Blob;
import java.sql.SQLException;
import controller.Controller;
import model.equipos.Equipo;
import utlidades.Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;

/**
 * The ModificarEquipos class provides a graphical user interface for modifying
 * sports teams. Users can view details of existing teams, edit team
 * information, and upload team logos. It extends JFrame and implements
 * ActionListener to handle user interactions.
 * 
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class ModificarEquipos extends JFrame implements ActionListener {
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
	 * Reference to the controller for handling actions.
	 */
	private Controller controller;

	/**
	 * Username of the current user.
	 */
	private String userName;

	/**
	 * Panel for adding or editing records.
	 */
	private JPanel rightPanelAddEd;

	/**
	 * Text field for entering the team's name.
	 */
	private JTextField nombreEquipoField;

	/**
	 * Text field for entering the team's stadium name.
	 */
	private JTextField nombreEstadioField;

	/**
	 * Text field for entering the number of titles.
	 */
	private JTextField txttitulosField;

	/**
	 * Button for modifying team information.
	 */
	private JButton bntModificarEq;

	/**
	 * Button for adding a new team.
	 */
	private JButton btnAddEquipo;

	/**
	 * Button for modifying records.
	 */
	private JButton btnModificar;

	/**
	 * Button for uploading an image.
	 */
	private JButton btnUpload;

	/**
	 * Label for displaying the team's logo.
	 */
	private JLabel lblEqLogo;

	/**
	 * Icon representing the image.
	 */
	private ImageIcon imageIcon;

	/**
	 * Blob object representing the image.
	 */
	private Blob imageBlob;

	/**
	 * Label for indicating the stadium name.
	 */
	private JLabel lblNombreDelEstadio;

	/**
	 * Panel for the top menu in adding/editing views.
	 */
	private JPanel topMenuPanelAddEq;

	/**
	 * Button for deleting a team.
	 */
	private JButton btnBorrarEquipo;

	/**
	 * Panel for searching records.
	 */
	private JPanel panelSearch;

	/**
	 * Label indicating the team name.
	 */
	private JLabel lblNombreEquipo_1;

	/**
	 * Combo box for selecting teams.
	 */
	private JComboBox<String> cBoxEquipos;

	/**
	 * Button for logging out.
	 */
	private JButton btnLogOut;

	/**
	 * Button for modifying matches.
	 */
	private JButton btnModificarPartido;

	/**
	 * Label for welcoming the user.
	 */
	private JLabel lblWelcome;

	/**
	 * Button for accessing match information.
	 */
	private JButton btnConsultarPartidos;

	/**
	 * Button for creating a new match.
	 */
	private JButton btnCrearPartido;

	/**
	 * Button for adding a new team.
	 */
	private JButton bntAnadirEq;

	/**
	 * Button for modifying team information.
	 */
	private JButton btnModificarEquipo;

	/**
	 * Label for displaying the team's logo.
	 */
	private JLabel lblEquipoLogo;

	/**
	 * Type of user logged in.
	 */
	private String userType;

	/**
	 * Button for managing coaches.
	 */
	private JButton btnGestionarEntrenador;
	 
	/**
	 * Constructs a new ModificarEquipos instance with the specified controller.
	 * 
	 * @param controller The controller for managing team-related actions.
	 */
	public ModificarEquipos(Controller controller) {
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		rightPanelAddEd = new JPanel();
		rightPanelAddEd.setBounds(310, 154, 674, 526);
		contentPane.add(rightPanelAddEd);
		rightPanelAddEd.setLayout(null);
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(242, 35, 35));
		panelLeft.setBounds(0, 0, 312, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("      Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(242, 35, 35));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(242, 35, 35));
			}
		});
		btnLogOut.setBackground(new Color(242, 35, 35));
		btnLogOut.setBounds(0, 595, 310, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnModificarPartido = new JButton("     Modificar partido");
		btnModificarPartido.setForeground(new Color(255, 255, 255));
		btnModificarPartido.addActionListener(this);
		btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPartido.setFocusable(false);
		btnModificarPartido.setBorder(null);
		btnModificarPartido.setBackground(new Color(242, 35, 35));
		btnModificarPartido.setBounds(0, 445, 310, 49);
		btnModificarPartido.addActionListener(this);
		btnModificarPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(242, 35, 35));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(242, 35, 35));
			}
		});
		panelLeft.add(btnModificarPartido);

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(37, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Gestionar equipo");
		btnConsultarPartidos.setForeground(new Color(255, 255, 255));
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(220, 3, 9));
		btnConsultarPartidos.setBounds(0, 386, 310, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(242, 35, 35));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(242, 35, 35));
			}
		});
		panelLeft.add(btnConsultarPartidos);

		btnCrearPartido = new JButton("     Crear partido");
		btnCrearPartido.setForeground(new Color(255, 255, 255));
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(242, 35, 35));
		btnCrearPartido.setBounds(0, 327, 310, 49);
		btnCrearPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(242, 35, 35));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(242, 35, 35));
			}
		});
		panelLeft.add(btnCrearPartido);

		btnGestionarEntrenador = new JButton("     Gestionar entrenador");
		btnGestionarEntrenador.setForeground(new Color(255, 255, 255));
		btnGestionarEntrenador.addActionListener(this);
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(242, 35, 35));
		btnGestionarEntrenador.setBounds(0, 275, 310, 49);
		btnGestionarEntrenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(242, 35, 35));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(242, 35, 35));
			}
		});
		panelLeft.add(btnGestionarEntrenador);

		// top menu buttons
		topMenuPanelAddEq = new JPanel();
		topMenuPanelAddEq.setBounds(310, 10, 674, 58);
		contentPane.add(topMenuPanelAddEq);
		topMenuPanelAddEq.setLayout(null);

		btnAddEquipo = new JButton("Añadir equipo");
		btnAddEquipo.addActionListener(this);
		btnAddEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEquipo.setBackground(SystemColor.menu);
		btnAddEquipo.setFocusable(false);
		btnAddEquipo.setBorder(null);
		btnAddEquipo.setBounds(74, 10, 150, 34);
		topMenuPanelAddEq.add(btnAddEquipo);

		btnModificar = new JButton("Modificar  Equipo");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificar.setBackground(new Color(220, 3, 9));
		btnModificar.addActionListener(this);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(null);
		btnModificar.setBounds(248, 10, 150, 34);
		topMenuPanelAddEq.add(btnModificar);

		// right panel
		JLabel lblNombreEquipo = new JLabel("Nombre del Equipo:");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEquipo.setBounds(53, 32, 160, 34);
		rightPanelAddEd.add(lblNombreEquipo);

		nombreEquipoField = new JTextField();
		nombreEquipoField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEquipoField.setBounds(223, 32, 250, 34);
		nombreEquipoField.setEditable(false);
		rightPanelAddEd.add(nombreEquipoField);

		nombreEstadioField = new JTextField();
		nombreEstadioField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEstadioField.setBounds(223, 107, 250, 34);
		rightPanelAddEd.add(nombreEstadioField);

		JLabel lblTitulos = new JLabel("Número de Títulos:");
		lblTitulos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulos.setBounds(53, 182, 145, 34);
		rightPanelAddEd.add(lblTitulos);

		txttitulosField = new JTextField();
		txttitulosField.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttitulosField.setBounds(223, 182, 250, 34);
		rightPanelAddEd.add(txttitulosField);

		bntModificarEq = new JButton("Modificar Equipo");
		bntModificarEq.addActionListener(this);
		bntModificarEq.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntModificarEq.setBounds(280, 440, 160, 34);
		rightPanelAddEd.add(bntModificarEq);

		JLabel lblLogo = new JLabel("Logo equipo : ");
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogo.setBounds(53, 258, 132, 34);
		rightPanelAddEd.add(lblLogo);

		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpload.setBounds(223, 257, 250, 34);
		btnUpload.addActionListener(this);
		rightPanelAddEd.add(btnUpload);

		lblEqLogo = new JLabel("");
		lblEqLogo.setBounds(50, 302, 200, 200);
		rightPanelAddEd.add(lblEqLogo);

		lblNombreDelEstadio = new JLabel("Nombre del Estadio:");
		lblNombreDelEstadio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelEstadio.setBounds(53, 110, 160, 34);
		rightPanelAddEd.add(lblNombreDelEstadio);

		btnBorrarEquipo = new JButton("Borrar Equipo");
		btnBorrarEquipo.addActionListener(this);
		btnBorrarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBorrarEquipo.setBounds(481, 440, 160, 34);
		rightPanelAddEd.add(btnBorrarEquipo);

		panelSearch = new JPanel();
		panelSearch.setBounds(310, 78, 674, 58);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);

		lblNombreEquipo_1 = new JLabel("Nombre del Equipo:");
		lblNombreEquipo_1.setBounds(48, 20, 142, 17);
		lblNombreEquipo_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSearch.add(lblNombreEquipo_1);

		cBoxEquipos = new JComboBox<String>();

		cBoxEquipos.addActionListener(this);
		cBoxEquipos.setBounds(219, 13, 250, 34);
		panelSearch.add(cBoxEquipos);

		fillBoxEqName();
		rightPanelAddEd.setVisible(false);

	}

	/**
	 * Fills the combo box with the names of existing teams.
	 */
	public void fillBoxEqName() {
		for (String eqName : controller.getEquipos()) {
			cBoxEquipos.addItem(eqName);
		}
	}

	/**
	 * Populates the team details fields with the information of the selected team.
	 * 
	 * @param selectedEquipo The name of the selected team.
	 */
	public void fillDataEquipo(String selectedEquipo) {
		Equipo eq = controller.getEquipo(selectedEquipo);
		nombreEquipoField.setText(eq.getNombreEquipo());
		nombreEstadioField.setText(eq.getEstadio());
		txttitulosField.setText(eq.getTitulos() + "");

		ImageIcon defaultLogo = new ImageIcon("src/images/icons/equiposinlogo.png");

		Blob imgB = eq.getLogo();
		if (imgB != null) {
			lblEqLogo.setIcon(Util.blobToImgIcon(imgB));
		}else {
			lblEqLogo.setIcon(defaultLogo);
		}
	}

	/**
	 * Handles various user actions performed in the GUI.
	 * 
	 * @param e The ActionEvent representing the user action.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// left menu
		if (o == btnModificarPartido) {
			ModificarPartido modificarPartido = new ModificarPartido(controller);
			this.dispose();
			modificarPartido.setVisible(true);
		} else if (e.getSource() == btnCrearPartido) {
			CrearPartido crearPartido = new CrearPartido(controller);
			this.dispose();
			crearPartido.setVisible(true);
		} else if (e.getSource() == btnGestionarEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			this.dispose();
			gestionarEntre.setVisible(true);
		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		}

		// right panel buttons
		if (o == cBoxEquipos) {

			fillDataEquipo((String) cBoxEquipos.getSelectedItem());
			rightPanelAddEd.setVisible(true);
		}
		if (o == btnBorrarEquipo) {
			if (controller.borrarEquipo(nombreEquipoField.getText())) {
				this.dispose();
				ModificarEquipos modificarEquipos = new ModificarEquipos(controller);
				modificarEquipos.setVisible(true);
			}
		}

		// top paenel buttons
		if (o == btnAddEquipo) {

			MenuAdmin menuAdmin = new MenuAdmin(controller);
			this.dispose();

			menuAdmin.setVisible(true);
		}
		if (o == btnUpload) {

			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				if (selectedFile != null) {
					try {
						Path imagePath = selectedFile.toPath();
						byte[] imageData = Files.readAllBytes(imagePath);

						imageBlob = new javax.sql.rowset.serial.SerialBlob(imageData);
						imageIcon = new ImageIcon(imageData);
						lblEqLogo.setIcon(imageIcon);

					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					// Handle case where user cancels selection (e.g., show a message)
				}
			}

		} else if (o == bntModificarEq) {
			if (controller.modificarEquipo(nombreEquipoField.getText(), Integer.valueOf(txttitulosField.getText()),
					nombreEstadioField.getText(), imageBlob)) {
				int opcion = JOptionPane.showConfirmDialog(this,
						(String) "El equipo ha sido introducido correctamente\n¿Desea añadir otro equipo?", "",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin ma = new MenuAdmin(controller);
					ma.setVisible(true);
				}

			}
		}
	}
}