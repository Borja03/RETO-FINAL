package view;

import javax.sql.rowset.serial.SerialException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.awt.SystemColor;

/**
 * The CambiarContra class represents the password change window of the
 * application.
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 * 
 * */
public class CambiarContra extends JFrame implements ActionListener {
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
	 * Represents the type of user currently logged in.
	 */
	private String userType;

	/**
	 * The username of the current user.
	 */
	private String userName;

	/**
	 * Field for entering the old password.
	 */
	private JPasswordField textFieldOldPassword;

	/**
	 * Field for confirming a new password.
	 */
	private JPasswordField confirmPasswordField;

	/**
	 * Field for entering the new password.
	 */
	private JPasswordField passwordFieldFirst;

	/**
	 * Panel for displaying bottom messages.
	 */
	private JPanel bottomPanelMsg;

	/**
	 * Panel for bottom buttons.
	 */
	private JPanel bottomPanel;

	/**
	 * Label for displaying message 1.
	 */
	private JLabel lblMsg1;

	/**
	 * Label for displaying message 2.
	 */
	private JLabel lblMsg2;

	/**
	 * Label for displaying message 3.
	 */
	private JLabel lblMsg3;

	/**
	 * Button for verifying inputs.
	 */
	private JButton btnVerificar;

	/**
	 * Button for saving changes.
	 */
	private JButton btnSave;

	/**
	 * Button for changing passwords.
	 */
	private JButton btnCambiarContrasena;

	/**
	 * Button for managing players.
	 */
	private JButton btnGestJugadores;

	/**
	 * Label for indicating a new password.
	 */
	private JLabel lnlNewPass;

	/**
	 * Panel for left-side content.
	 */
	private JPanel panelLeft;

	/**
	 * Label for adding profile picture.
	 */
	private JLabel lblBtnAddPic;

	/**
	 * Label for displaying user profile picture.
	 */
	private JLabel lblUserPic;

	/**
	 * Button for logging out.
	 */
	private JButton btnLogOut;

	/**
	 * Button for changing passwords.
	 */
	private JButton btnCambiarCont;

	/**
	 * Button for changing player dorsal numbers.
	 */
	private JButton btnCambiarDorsal;

	/**
	 * Label for welcoming the user.
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
	 * Button for uploading files.
	 */
	private JButton btnUpload;

	/**
	 * Blob object representing user profile picture.
	 */
	private Blob usrBlobIcon;

	/**
	 * ImageIcon for user profile picture.
	 */
	private ImageIcon imageIcon;

	/**
	 * Buttons for various actions (consulting, changing dorsal, logging out).
	 */
	private JButton btnConsultarEquipoj, btnConsultarPartidosj, btnCambiarDorsalj, btnCambiarContj, btnLogOutj;


	/**
	 * Constructs a new CambiarContra window.
	 * 
	 * @param controlador The Controller instance.
	 * @param userName    The username of the user.
	 * @param userType    The type of the user (e.g., jugador, entrenador).
	 */

	public CambiarContra(Controller controlador, String userName, String userType) {
		this.controller = controlador;
		this.userName = userName;
		this.userType = userType;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel topPanel = new JPanel();
		topPanel.setBounds(341, 31, 621, 210);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		textFieldOldPassword = new JPasswordField();
		textFieldOldPassword.setBounds(200, 76, 250, 34);
		textFieldOldPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		topPanel.add(textFieldOldPassword);

		JLabel lblOldPassword = new JLabel("Contraseña antigua : ");
		lblOldPassword.setBounds(10, 75, 180, 34);
		lblOldPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		topPanel.add(lblOldPassword);

		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(this);
		btnVerificar.setBounds(440, 140, 150, 34);
		btnVerificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		topPanel.add(btnVerificar);

		JLabel lblOldPasswordVerifcation = new JLabel("Verificación de contraseña  ");
		lblOldPasswordVerifcation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldPasswordVerifcation.setBounds(200, 10, 250, 34);
		topPanel.add(lblOldPasswordVerifcation);

		bottomPanel = new JPanel();
		bottomPanel.setBounds(341, 251, 628, 395);
		contentPane.add(bottomPanel);
		bottomPanel.setLayout(null);

		confirmPasswordField = new JPasswordField();

		confirmPasswordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		confirmPasswordField.setBounds(200, 201, 250, 34);
		bottomPanel.add(confirmPasswordField);

		passwordFieldFirst = new JPasswordField();
		passwordFieldFirst.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordFieldFirst.setBounds(200, 112, 250, 34);
		bottomPanel.add(passwordFieldFirst);

		JLabel lblNewLabel = new JLabel("Nueva Contraseña:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 112, 150, 34);
		bottomPanel.add(lblNewLabel);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña:");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmarContrasea.setBounds(10, 198, 166, 34);
		bottomPanel.add(lblConfirmarContrasea);

		btnSave = new JButton("Guardar");
		btnSave.addActionListener(this);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(440, 270, 150, 34);
		bottomPanel.add(btnSave);

		lnlNewPass = new JLabel("Changing Password");
		lnlNewPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lnlNewPass.setBounds(200, 31, 250, 34);
		bottomPanel.add(lnlNewPass);

		bottomPanelMsg = new JPanel();
		bottomPanelMsg.setBounds(341, 251, 628, 395);
		lblMsg1 = new JLabel("Contraseña incorrecta");
		lblMsg1.setForeground(new Color(192, 192, 192));
		lblMsg1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMsg1.setBounds(200, 43, 230, 54);
		bottomPanelMsg.add(lblMsg1);

		contentPane.add(bottomPanelMsg);

		if (userType.equalsIgnoreCase("jugador")) {
			showMenuJugador(userName);
		} else if (userType.equalsIgnoreCase("entrenador")) {
			showMenuEntre(userName);
		}

	}

	/**
	 * The left menu of entrenador: if userType is entrenador will show this menu.
	 * @param userName    The username of the user.
	 */
	public void showMenuEntre(String userName) {
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
		// Cambio de color al pasar el ratón sobre el botón
		btnConsultarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
			}
		});

		btnGestJugadores = new JButton("     Gestionar jugadores");
		btnGestJugadores.setForeground(new Color(255, 255, 255));
		btnGestJugadores.addActionListener(this);
		btnGestJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestJugadores.setFocusable(false);
		btnGestJugadores.setBorder(null);
		btnGestJugadores.setBackground(new Color(86, 82, 252));
		btnGestJugadores.setBounds(0, 332, 250, 49);
		panelLeft.add(btnGestJugadores);
		// Cambio de color al pasar el ratón sobre el botón
		btnGestJugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestJugadores.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestJugadores.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
			}
		});

		lblWelcome = new JLabel("Welcome " + userName);
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(20, 200, 217, 34);
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
		// Cambio de color al pasar el ratón sobre el botón
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
			}
		});

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(0, 586, 250, 49);
		panelLeft.add(btnLogOut);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);

		btnLogOut.setBackground(new Color(86, 82, 252));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(86, 82, 252)); // Se mantiene gris al salir
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(50, 70, 90)); // Cambia el color al presionar
			}
		});

		btnCambiarContrasena = new JButton("     Cambiar contraseña");
		btnCambiarContrasena.setForeground(new Color(255, 255, 255));
		btnCambiarContrasena.addActionListener(this);
		btnCambiarContrasena.setBounds(0, 513, 250, 49);
		panelLeft.add(btnCambiarContrasena);
		btnCambiarContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarContrasena.setFocusable(false);
		btnCambiarContrasena.setBorder(null);
		btnCambiarContrasena.setBackground(new Color(100, 100, 100)); // Cambiado a gris
		btnCambiarContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarContrasena.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarContrasena.setBackground(new Color(100, 100, 100)); // Se mantiene gris al salir
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarContrasena.setBackground(new Color(50, 70, 90)); // Cambia el color al presionar
			}
		});
		bottomPanelMsg.setVisible(false);
		bottomPanel.setVisible(false);

	}

	/**
	 * The left menu of jugador: if userType is jugador will show this menu.
	 * @param userName    The username of the user.
	 */

	public void showMenuJugador(String userName) {
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

		panelLefts.setLayout(null);
	
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
		btnCambiarCont.setBackground(new Color(26, 169, 185));
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

		btnConsultarEquipoj = new JButton("     Consultar Equipo");
		btnConsultarEquipoj.setForeground(new Color(255, 255, 255));
		btnConsultarEquipoj.addActionListener(this);
		btnConsultarEquipoj.setBounds(0, 271, 250, 49);
		btnConsultarEquipoj.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipoj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipoj.setFocusable(false);
		btnConsultarEquipoj.setBorder(null);
		btnConsultarEquipoj.setBackground(new Color(33, 199, 162));
		panelLefts.add(btnConsultarEquipoj);

		lblUserPic = new JLabel();
		lblUserPic.setBounds(50, 33, 150, 150);
		lblUserPic.setBackground(SystemColor.activeCaption);
		lblUserPic.setForeground(new Color(0, 64, 128));
		panelLefts.add(lblUserPic);

		bottomPanelMsg.setVisible(false);
		bottomPanel.setVisible(false);

	}

	/**
	 * Opens a dialog for the user to upload an image. The selected image is
	 * converted to a Blob and displayed in a JLabel. If the upload is successful,
	 * the image is updated in the database.
	 */
	private void userUploadImgDialog() {
		btnUpload = new JButton("Upload Image");
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
								JOptionPane.showMessageDialog(CambiarContra.this, "Image uploaded to database!",
										"Success", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(CambiarContra.this, "Failed to upload image to database!",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (SerialException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						//
					}
				}
			}
		});

		JOptionPane.showMessageDialog(this, btnUpload, "Upload Image", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Handles action events for the login class.
	 * 
	 * @param e the action event
	 */

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		System.out.println("Action performed: " + e.getActionCommand());

		if (e.getSource() == btnVerificar) {
			String oldPassword = new String(textFieldOldPassword.getPassword());
			if (!oldPassword.equals(controller.getUsuarioPassword(userName, userType))) {
				bottomPanelMsg.setVisible(true);
			} else {
				bottomPanel.setVisible(true);

			}
		} else if (o == btnCambiarDorsal) {
			CambiarDorsal ventanaDorsal = new CambiarDorsal(controller, userName, userType);
			ventanaDorsal.setVisible(true);
			this.setVisible(false);
		} else if (o == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
			consultarPartidos.setVisible(true);
			this.dispose();

		} else if (o == btnConsultarEquipo) {
			MenuEntrenador menuEntr = new MenuEntrenador(controller, userName, userType);
			menuEntr.setVisible(true);
			this.setVisible(false);
		} else if (o == btnConsultarPartidos) {
			ConsultarPartidos constPar = new ConsultarPartidos(controller, userName, userType);
			constPar.setVisible(true);
			this.setVisible(false);
		} else if (o == btnGestJugadores) {
			String myTeam = "";
			GestionarJugadores gestJ = new GestionarJugadores(controller, userName, userType, myTeam);
			gestJ.setVisible(true);
			this.setVisible(false);
		} else if (o == btnLogOut) {
			controller.logOut();
			this.dispose();
		}

		if (e.getSource() == btnSave) {
			System.out.println("btn saved clicked ");

			cambiarContrasenia();
		} /*
			 * else if (o == btnVolverMenu) { if ("Jugador".equals(userType)) { MenuJugador
			 * menuJugador = new MenuJugador(controller, userName);
			 * menuJugador.setVisible(true); } else if ("Entrenador".equals(userType)) {
			 * MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName);
			 * menuEntrenador.setVisible(true); }
			 */
		// for jugador menu

		if (o == btnLogOutj) {
			controller.logOut();
			this.dispose();
		} else if (o == btnCambiarDorsalj) {
			CambiarDorsal ventanaDorsal = new CambiarDorsal(controller, userName, userType);
			ventanaDorsal.setVisible(true);
			this.dispose();
		} else if (o == btnConsultarPartidosj) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
			consultarPartidos.setVisible(true);
			this.dispose();

		} else if (o == btnConsultarEquipoj) {
			MenuJugador menuJugador = new MenuJugador(controller, userName, userType);
			menuJugador.setVisible(true);
			this.dispose();
		}

	}

	private void cambiarContrasenia() {
		System.out.println("i'm here");
		String newPassword = new String(passwordFieldFirst.getPassword());
		String confirmPassword = new String(confirmPasswordField.getPassword());

		if (!newPassword.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		boolean changed = controller.cambiarPassword(userName, newPassword, userType);

		if (changed) {
			JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente.", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);
			/*
			 * if ("jugador".equals(userType)) { MenuJugador menuJugador = new
			 * MenuJugador(controller, userName); menuJugador.setVisible(true); } else if
			 * ("entrenador".equals(userType)) { MenuEntrenador menuEntrenador = new
			 * MenuEntrenador(controller, userName); menuEntrenador.setVisible(true); }
			 */
			this.dispose();
			controller.logOut();
		} else {
			JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}