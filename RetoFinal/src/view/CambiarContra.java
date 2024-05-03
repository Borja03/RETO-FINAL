package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Blob;
import java.awt.SystemColor;

public class CambiarContra extends JFrame implements ActionListener {



    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Controller controller;
    private String userType;

    private String userName;
	private JPasswordField textFieldOldPassword;
	private JPasswordField confirmPasswordField;
	private JPasswordField passwordFieldFirst;
	private JPanel bottomPanelMsg;
	private JPanel bottomPanel;
	private JLabel lblMsg1;
	private JLabel lblMsg2;
	private JLabel lblMsg3;
	private JButton btnVerificar;
	private JButton btnSave;
	private JButton btnCambiarContrasena;
	private JButton btnGestJugadores;

	private JLabel lnlNewPass;
	private JPanel panelLeft;
	private JLabel lblBtnAddPic;
	private JLabel lblUserPic;
	private JButton btnLogOut;
	private JButton btnCambiarCont;
	private JButton btnCambiarDorsal;
	private JLabel lblWelcome;
	private JButton btnConsultarPartidos;
	private JButton btnConsultarEquipo;
	private JButton btnConsultarEquipoj,btnConsultarPartidosj,btnCambiarDorsalj,btnCambiarContj,btnLogOutj;

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

		JPanel topPanel = new JPanel();
		topPanel.setBounds(341, 31, 621, 210);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		textFieldOldPassword = new JPasswordField();
		textFieldOldPassword.setBounds(200, 76, 250, 34);
		textFieldOldPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		topPanel.add(textFieldOldPassword);

		JLabel lblOldPassword = new JLabel("Old password : ");
		lblOldPassword.setBounds(10, 75, 150, 34);
		lblOldPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		topPanel.add(lblOldPassword);

		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(this);
		btnVerificar.setBounds(440, 140, 150, 34);
		btnVerificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		topPanel.add(btnVerificar);

		JLabel lblOldPasswordVerifcation = new JLabel("Old Password verifcation ");
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
		lblMsg1 = new JLabel("Contraseña");
		lblMsg1.setForeground(new Color(192, 192, 192));
		lblMsg1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMsg1.setBounds(200, 43, 230, 54);
		bottomPanelMsg.add(lblMsg1);

		lblMsg2 = new JLabel("No ");
		lblMsg2.setForeground(Color.LIGHT_GRAY);
		lblMsg2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMsg2.setBounds(200, 110, 230, 54);
		bottomPanelMsg.add(lblMsg2);

		lblMsg3 = new JLabel("Bla bla ");
		lblMsg3.setForeground(Color.LIGHT_GRAY);
		lblMsg3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMsg3.setBounds(200, 199, 230, 54);
		bottomPanelMsg.add(lblMsg3);

		contentPane.add(bottomPanelMsg);
		



		if (userType.equalsIgnoreCase("jugador")) {
			showMenuJugador(userName);
		} else if (userType.equalsIgnoreCase("entrenador")) {
			showMenuEntre(userName);
		}

	}

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

	        lblWelcome = new JLabel("Welcome "+userName);
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

	public void showMenuJugador(String userName) {
		panelLeft = new JPanel();
		panelLeft.setLayout(null);
		panelLeft.setBackground(new Color(32, 206, 36));
		panelLeft.setBounds(0, 0, 250, 680);
		contentPane.add(panelLeft);
		
		lblBtnAddPic = new JLabel();
		lblBtnAddPic.setForeground(SystemColor.activeCaption);
		lblBtnAddPic.setBounds(191, 158, 50, 50);
		panelLeft.add(lblBtnAddPic);
		
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
		btnLogOutj.setBackground(new Color(32, 206, 36));
		btnLogOutj.setBounds(0, 546, 250, 49);
		panelLeft.add(btnLogOutj);
		
		btnCambiarContj = new JButton("     Cambiar Contraseña");
		btnCambiarContj.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarContj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarContj.setFocusable(false);
		btnCambiarContj.setBorder(null);
		btnCambiarContj.setBackground(new Color(255, 128, 64));
		btnCambiarContj.setBounds(0, 476, 250, 49);
		panelLeft.add(btnCambiarContj);
		
		btnCambiarDorsalj = new JButton("     Cambiar Dorsal");
		btnCambiarDorsalj.addActionListener(this);
		btnCambiarDorsalj.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsalj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsalj.setFocusable(false);
		btnCambiarDorsalj.setBorder(null);
		btnCambiarDorsalj.setBackground(new Color(32, 206, 36));
		btnCambiarDorsalj.setBounds(0, 406, 250, 49);
		panelLeft.add(btnCambiarDorsalj);
		
		lblWelcome = new JLabel("     Welcome "+userName);
		lblWelcome.setForeground(Color.YELLOW);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(20, 200, 217, 34);
		panelLeft.add(lblWelcome);
		
		btnConsultarPartidosj = new JButton("     Consultar Partidos");
		btnConsultarPartidosj.addActionListener(this);
		btnConsultarPartidosj.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidosj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidosj.setFocusable(false);
		btnConsultarPartidosj.setBorder(null);
		btnConsultarPartidosj.setBackground(new Color(32, 206, 36));
		btnConsultarPartidosj.setBounds(0, 338, 250, 49);
		panelLeft.add(btnConsultarPartidosj);
		btnConsultarEquipoj = new JButton("     Consultar Equipo");
		btnConsultarEquipoj.addActionListener(this);
		btnConsultarEquipoj.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipoj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipoj.setFocusable(false);
		btnConsultarEquipoj.setBorder(null);
		btnConsultarEquipoj.setBackground(new Color(32, 206, 36));
		btnConsultarEquipoj.setBounds(0, 271, 250, 49);
		panelLeft.add(btnConsultarEquipoj);
		bottomPanelMsg.setVisible(false);
		bottomPanel.setVisible(false);

		
		

	}

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
			CambiarDorsal ventanaDorsal = new CambiarDorsal(controller, userName,userType);
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
		}else if (o == btnLogOut) {
			controller.logOut();
			this.dispose();
		}

       
       
		if (e.getSource() == btnSave) {
			System.out.println("btn saved clicked ");

			cambiarContrasenia();
		}/*
			 * else if (o == btnVolverMenu) { if ("Jugador".equals(userType)) { MenuJugador
			 * menuJugador = new MenuJugador(controller, userName);
			 * menuJugador.setVisible(true); } else if ("Entrenador".equals(userType)) {
			 * MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName);
			 * menuEntrenador.setVisible(true); }
			 */
		//for jugador menu 

		if (o == btnLogOutj) {
			controller.logOut();
			this.dispose();
		} else if (o == btnCambiarDorsalj) {
			CambiarDorsal ventanaDorsal = new CambiarDorsal(controller, userName,userType);
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