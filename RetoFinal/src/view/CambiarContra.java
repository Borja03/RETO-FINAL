package view;

import javax.swing.*; 
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Blob;

public class CambiarContra extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Controller controller;
    private String userType;
    private String userName;
	private JButton btnLogOut;
	private JButton btnCambiarCont;
	private JButton btnCambiarDorsal;
	private JLabel lblWelcome;
	private JButton btnConsultarPartidos;
	private JButton btnConsultarEquipo;
	private JPasswordField textFieldOldPassword;
	private JPasswordField confirmPasswordField;
	private JPasswordField passwordFieldFirst;
	private JPanel bottomPanelMsg;
	private JPanel bottomPanel;
	private JLabel lblMsg1;
	private JLabel lblMsg2;
	private JLabel lblMsg3;
	private JButton btnVerificar;
	private  JButton btnSave;
	private JLabel lnlNewPass;
    public CambiarContra(Controller controlador,String userName,String userType) {
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

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 300, 680);
		panelLeft.setBackground(new Color(128, 128, 0));
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
		btnLogOut.setBounds(40, 546, 200, 49);
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
		btnCambiarCont.setBackground(new Color(255, 128, 64));
		btnCambiarCont.setBounds(40, 476, 200, 49);
		panelLeft.add(btnCambiarCont);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarContrasenia();
            }
        });
        btnOk.setBounds(335, 240, 89, 23);
        contentPane.add(btnOk);
        
        JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(128, 128, 0));
		panelLeft.setBounds(0, 0, 345, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("Log Out");
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
		btnLogOut.setBounds(57, 536, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarCont = new JButton("Cambiar Contraseña");
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(128, 128, 0));
		btnCambiarCont.setBounds(57, 466, 200, 49);
		panelLeft.add(btnCambiarCont);

		btnCambiarDorsal = new JButton("Cambiar Dorsal");
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal.setFocusable(false);
		btnCambiarDorsal.setBorder(null);
		btnCambiarDorsal.setBackground(new Color(128, 128, 0));


	

		btnCambiarDorsal.setBounds(57, 396, 200, 49);
		panelLeft.add(btnCambiarDorsal);
      
	  lblWelcome = new JLabel("Welcome " +userName);
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("Consultar Partidos");
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(128, 128, 0));

		btnConsultarPartidos.setBounds(57, 328, 200, 49);
		panelLeft.add(btnConsultarPartidos);

		btnConsultarEquipo = new JButton("Consultar Equipo");

		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(128, 128, 0));
		btnConsultarEquipo.setBounds(57, 261, 200, 49);
		panelLeft.add(btnConsultarEquipo);
		JLabel lblEqLogo = new JLabel();

       
        
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
        bottomPanelMsg.setBounds(341, 266, 628, 380);
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
        bottomPanelMsg.setVisible(false);
        bottomPanel.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();


		if (e.getSource() == btnLogOut) {
	
			this.dispose();
			controller.logOut();

		} else if (e.getSource() == btnGestJugadores) {
			GestionarJugadores g1 = new GestionarJugadores(controller, username, nombreEquipo);
			g1.setVisible(true);
			this.dispose();
		}
		else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller,username);
			consultarPartidos.setVisible(true);
			this.dispose();
		}else if(e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller,username);
			menuEntrenador.setVisible(true);
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
            JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
          if ("jugador".equals(userType)) {
                MenuJugador menuJugador = new MenuJugador(controller, userName);
                menuJugador.setVisible(true);
            } else if ("entrenador".equals(userType)) {
                MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName);
                menuEntrenador.setVisible(true);
            }
            this.dispose(); 
            controller.logOut();
        } else {
            JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}