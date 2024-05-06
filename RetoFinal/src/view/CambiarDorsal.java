
package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;

public class CambiarDorsal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Controller controller;
	private String userName;
	private String userType;
	private JPanel contentPane;
	private JButton btnLogOut;
	private JButton  btnConsultarPartidos;
	private JButton  btnCambiarCont;
	private JButton  btnConsultarEquipo;

	public CambiarDorsal(Controller cont, String userC,String userType) {
		this.controller = cont;
		this.userName = userC;
		this.userType = userType;

		getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel buttonsPanel = new JPanel(new GridLayout(5, 5, 10, 10));
		buttonsPanel.setBounds(320, 10, 650, 650); // Ajusta la posición del panel y su tamaño
		buttonsPanel.setBackground(Color.WHITE);

		for (int i = 1; i <= 25; i++) {
			ImageIcon icon = new ImageIcon("src/images/camisetaBoton.png");
			Image scaledImage = icon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
			icon = new ImageIcon(scaledImage);
			JButton button = new JButton(icon);
			button.setText(Integer.toString(i));
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setVerticalTextPosition(JButton.CENTER);
			button.setFont(new Font("Tahoma", Font.BOLD, 24));
			button.setBorder(null);
			button.setEnabled(true);
			button.addActionListener(this);
			if (cont.existeDorsal(i, userC)) {
				button.setEnabled(false);
				button.setBackground(Color.GRAY);
			} else {
				button.setEnabled(true);
				button.setBackground(Color.WHITE);
			}
			buttonsPanel.add(button);
		}
		getContentPane().add(buttonsPanel, BorderLayout.CENTER);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(null);
		panelLeft.setBackground(new Color(32, 206, 36));
		panelLeft.setBounds(0, 0, 250, 680);
		contentPane.add(panelLeft);
		
		JLabel lblBtnAddPic = new JLabel();
		lblBtnAddPic.setForeground(SystemColor.activeCaption);
		lblBtnAddPic.setBounds(191, 158, 50, 50);
		panelLeft.add(lblBtnAddPic);
		
		JLabel lblUserPic = new JLabel();
		lblUserPic.setForeground(SystemColor.activeCaption);
		lblUserPic.setBackground(SystemColor.activeCaption);
		lblUserPic.setBounds(54, 33, 150, 150);
		panelLeft.add(lblUserPic);
		
		btnLogOut = new JButton("     Log Out");
		btnLogOut.addActionListener(this);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(32, 206, 36));
		btnLogOut.setBounds(0, 546, 250, 49);
		panelLeft.add(btnLogOut);
		
		btnCambiarCont = new JButton("     Cambiar Contraseña");
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(32, 206, 36));
		btnCambiarCont.setBounds(0, 476, 250, 49);
		panelLeft.add(btnCambiarCont);
		
		JButton btnCambiarDorsal = new JButton("     Cambiar Dorsal");
	
		btnCambiarDorsal.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal.setFocusable(false);
		btnCambiarDorsal.setBorder(null);
		btnCambiarDorsal.setBackground(new Color(255, 128, 64));
		btnCambiarDorsal.setBounds(0, 406, 250, 49);
		panelLeft.add(btnCambiarDorsal);
		
		JLabel lblWelcome = new JLabel("     Welcome " +userName);
		lblWelcome.setForeground(Color.YELLOW);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(40, 227, 217, 34);
		panelLeft.add(lblWelcome);
		
		btnConsultarPartidos = new JButton("     Consultar Partidos");
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(32, 206, 36));
		btnConsultarPartidos.setBounds(0, 338, 250, 49);
		panelLeft.add(btnConsultarPartidos);
		
		btnConsultarEquipo = new JButton("     Consultar Equipo");
		btnConsultarEquipo.addActionListener(this);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(32, 206, 36));
		btnConsultarEquipo.setBounds(0, 271, 250, 49);
		panelLeft.add(btnConsultarEquipo);
		setLocationRelativeTo(null);

		
	}

	public void actionPerformed(ActionEvent e) {
		// left menu button action listenners 
		if (e.getSource() == btnLogOut) {
			controller.logOut();
			this.dispose();
		} else if (e.getSource() == btnConsultarEquipo) {
			MenuJugador menuJugador = new MenuJugador(controller, userName,userType);
			menuJugador.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
			consultarPartidos.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnCambiarCont) {
			CambiarContra ventanaCont = new CambiarContra(controller, userName, userType);
			ventanaCont.setVisible(true);
			this.dispose();
		}else {
		Object o = e.getSource();
		JButton clickedButton = (JButton) o;
		String buttonText = clickedButton.getText();
		int dorsal = Integer.parseInt(buttonText);

		int dialogResult = JOptionPane.showConfirmDialog(null, " Est s seguro que deseas cambiar el dorsal?",
				"Confirmar", JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION) {
			dorsal = Integer.parseInt(buttonText);
			boolean success = controller.modificarJugadorConDorsal(userName, dorsal);
			if (success) {
				JOptionPane.showMessageDialog(null, "El dorsal se ha cambiado con  xito a " + buttonText);
			} else {
				JOptionPane.showMessageDialog(null, "Error al cambiar el dorsal");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No has confirmado cambiar el dorsal");
		}

		// Deshabilitar el bot n seleccionado
		clickedButton.setEnabled(false);

		// Volver a la ventana anterior
		CambiarDorsal cambiarDorsal = new CambiarDorsal(controller, userName,userType);
		this.dispose();
		cambiarDorsal.setVisible(true);
		
		


		}
		}
	
	
}
