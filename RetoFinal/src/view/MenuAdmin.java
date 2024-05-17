
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.sql.Blob;
import java.sql.SQLException;
import controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

/**
 * The MenuAdmin class represents the administration menu for the application.
 * It provides various functionalities for managing teams, matches, and coaches.
 * The Splash class represents the splash screen of the application.
 * 
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class MenuAdmin extends JFrame implements ActionListener {

	/**
	 * Unique identifier for serialization.
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
	 * Button for modifying a match.
	 */
	private JButton btnModificarPartido;

	/**
	 * Label displaying a welcome message.
	 */
	private JLabel lblWelcome;

	/**
	 * Button for consulting match details.
	 */
	private JButton btnConsultarPartidos;

	/**
	 * Button for creating a new match.
	 */
	private JButton btnCrearPartido;

	/**
	 * The username of the current user.
	 */
	private String userName;

	/**
	 * Panel on the right side for adding/editing entities.
	 */
	private JPanel rightPanelAddEd;

	/**
	 * Text field for entering the name of a team.
	 */
	private JTextField nombreEquipoField;

	/**
	 * Text field for entering the name of a stadium.
	 */
	private JTextField nombreEstadioField;

	/**
	 * Text field for entering the number of titles.
	 */
	private JTextField txttitulosField;

	/**
	 * Button for adding an entity.
	 */
	private JButton bntAnadirEq;

	/**
	 * Button for adding a team.
	 */
	private JButton btnAddEquipo;

	/**
	 * Button for modifying an entity.
	 */
	private JButton btnModificar;

	/**
	 * Button for uploading an image.
	 */
	private JButton btnUpload;

	/**
	 * Label displaying the logo of a team.
	 */
	private JLabel lblEquipoLogo;

	/**
	 * ImageIcon representing the logo image.
	 */
	private ImageIcon imageIcon;

	/**
	 * Blob object representing the image.
	 */
	private Blob imageBlob;

	/**
	 * Label displaying the name of the stadium.
	 */
	private JLabel lblNombreDelEstadio;

	/**
	 * Panel at the top for menu options related to adding a team.
	 */
	private JPanel topMenuPanelAddEq;

	/**
	 * The type of user currently logged in.
	 */
	private String userType;

	/**
	 * Button for managing coaches.
	 */
	private JButton btnGestionarEntrenador;

	/**
	 * Constructs the MenuAdmin frame.
	 *
	 * @param controller the controller used to handle business logic
	 */
	public MenuAdmin(Controller controller) {
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
		rightPanelAddEd.setBounds(310, 73, 674, 597);
		contentPane.add(rightPanelAddEd);
		rightPanelAddEd.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 250, 680);
		panelLeft.setBackground(new Color(242, 45, 45));
		getContentPane().add(panelLeft);
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

		btnModificarPartido = new JButton("     Modificar partido");
		btnModificarPartido.setForeground(new Color(255, 255, 255));
		btnModificarPartido.addActionListener(this);
		btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPartido.setFocusable(false);
		btnModificarPartido.setBorder(null);
		btnModificarPartido.setBackground(new Color(242, 45, 45));
		btnModificarPartido.setBounds(0, 445, 250, 49);
		btnModificarPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnModificarPartido);

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setBackground(new Color(0, 0, 0));
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(10, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Gestionar equipo");
		btnConsultarPartidos.setForeground(new Color(255, 255, 255));
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(220, 3, 9));
		btnConsultarPartidos.setBounds(0, 386, 250, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(242, 45, 45));
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

		btnGestionarEntrenador = new JButton("     Gestionar entrenador");
		btnGestionarEntrenador.setForeground(new Color(255, 255, 255));
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
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

		// top menu buttons
		topMenuPanelAddEq = new JPanel();
		topMenuPanelAddEq.setBounds(310, 11, 674, 57);
		contentPane.add(topMenuPanelAddEq);
		topMenuPanelAddEq.setLayout(null);

		btnAddEquipo = new JButton("Añadir equipo");
		btnAddEquipo.setForeground(new Color(0, 0, 0));
		btnAddEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEquipo.setBackground(new Color(220, 3, 9));
		btnAddEquipo.setFocusable(false);
		btnAddEquipo.setBorder(null);
		btnAddEquipo.setBounds(74, 10, 176, 34);
		topMenuPanelAddEq.add(btnAddEquipo);

		btnModificar = new JButton("Modificar  equipo");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificar.setBackground(SystemColor.menu);
		btnModificar.addActionListener(this);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(null);
		btnModificar.setBounds(275, 10, 176, 34);
		topMenuPanelAddEq.add(btnModificar);

		// right panel
		JLabel lblNombreEquipo = new JLabel("Nombre del Equipo:");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEquipo.setBounds(53, 75, 160, 34);
		rightPanelAddEd.add(lblNombreEquipo);

		nombreEquipoField = new JTextField();
		nombreEquipoField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEquipoField.setBounds(223, 75, 250, 34);
		rightPanelAddEd.add(nombreEquipoField);

		nombreEstadioField = new JTextField();
		nombreEstadioField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEstadioField.setBounds(223, 150, 250, 34);
		rightPanelAddEd.add(nombreEstadioField);

		JLabel lblTitulos = new JLabel("Número de Títulos:");
		lblTitulos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulos.setBounds(53, 225, 145, 34);
		rightPanelAddEd.add(lblTitulos);

		txttitulosField = new JTextField();
		txttitulosField.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttitulosField.setBounds(223, 225, 250, 34);
		rightPanelAddEd.add(txttitulosField);

		bntAnadirEq = new JButton("Añadir Equipo");
		bntAnadirEq.addActionListener(this);
		bntAnadirEq.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntAnadirEq.setBounds(474, 450, 150, 34);
		rightPanelAddEd.add(bntAnadirEq);

		JLabel lblLogo = new JLabel("Logo equipo : ");
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogo.setBounds(53, 301, 132, 34);
		rightPanelAddEd.add(lblLogo);

		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpload.setBounds(223, 300, 250, 34);
		btnUpload.addActionListener(this);
		rightPanelAddEd.add(btnUpload);

		lblEquipoLogo = new JLabel("");
		lblEquipoLogo.setBounds(53, 361, 200, 200);
		rightPanelAddEd.add(lblEquipoLogo);

		lblNombreDelEstadio = new JLabel("Nombre del Estadio:");
		lblNombreDelEstadio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelEstadio.setBounds(53, 153, 160, 34);
		rightPanelAddEd.add(lblNombreDelEstadio);

	}

	/**
	 * Allows the user to upload a logo for the team.
	 */
	public void uploadLogo() {
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
					lblEquipoLogo.setIcon(imageIcon);
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

			}
		}
	}

	/**
	 * Handles action events for the MenuAdmin class.
	 * 
	 * @param e the action event
	 */
	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btnLogOut) {
			this.dispose();
			controller.logOut();
        } else if (e.getSource() == btnModificar) {
			this.dispose();
			ModificarEquipos modificarEquipos = new ModificarEquipos(controller);
			modificarEquipos.setVisible(true);
        } else if (e.getSource() == btnCrearPartido) {
    		CrearPartido crearPartido = new CrearPartido(controller);
			this.dispose();
			crearPartido.setVisible(true);
        } else if (e.getSource()== btnGestionarEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			this.dispose();
			gestionarEntre.setVisible(true);
        } else if (e.getSource() == btnAddEquipo) {
        	
            rightPanelAddEd.setVisible(true);
        } else if (e.getSource() == btnModificarPartido) {
			ModificarPartido modificarPartido = new ModificarPartido(controller);
			this.dispose();
			modificarPartido.setVisible(true);
        } else if (e.getSource() == bntAnadirEq) {
            addTeam();
        } else if (e.getSource() == btnUpload) {
            uploadImage();
        }
    }

    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                imageBlob = new javax.sql.rowset.serial.SerialBlob(Files.readAllBytes(selectedFile.toPath()));
                imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                lblEquipoLogo.setIcon(imageIcon);
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addTeam() {
        String nombreEquipo = nombreEquipoField.getText().trim();
        String nombreEstadio = nombreEstadioField.getText().trim();
        String titulosText = txttitulosField.getText().trim();
        if (nombreEquipo.isEmpty() || nombreEstadio.isEmpty() || titulosText.isEmpty() || imageBlob == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos y cargue una imagen.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int titulos;
        try {
            titulos = Integer.parseInt(titulosText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido de títulos.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

          if(  controller.crearEquipo(nombreEquipo, titulos, nombreEstadio, imageBlob)) {
            JOptionPane.showMessageDialog(this, "Equipo añadido correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
          } else  {
            JOptionPane.showMessageDialog(this, "Error al añadir el equipo(Ya existe). Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nombreEquipoField.setText("");
        nombreEstadioField.setText("");
        txttitulosField.setText("");
        lblEquipoLogo.setIcon(null);
        imageBlob = null;
    }
}