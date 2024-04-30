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
	private JPanel contentPane;
	private JButton btnLogOut;
	private JLabel lblWelcome;

	public CambiarDorsal(Controller cont, String userC) {
		this.controller = cont;
		this.userName = userC;

		getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(128, 128, 0));
		panelLeft.setBounds(0, 0, 300, 680);
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
		btnLogOut.setBounds(37, 595, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblWelcome = new JLabel("Welcome " + userName + "");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		JButton btnConsultarEquipo_1 = new JButton("     Consultar Equipo");
		btnConsultarEquipo_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo_1.setFocusable(false);
		btnConsultarEquipo_1.setBorder(null);
		btnConsultarEquipo_1.setBackground(new Color(128, 128, 0));
		btnConsultarEquipo_1.setBounds(37, 297, 200, 49);
		panelLeft.add(btnConsultarEquipo_1);

		JButton btnConsultarPartidos_1 = new JButton("     Consultar Partidos");
		btnConsultarPartidos_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos_1.setFocusable(false);
		btnConsultarPartidos_1.setBorder(null);
		btnConsultarPartidos_1.setBackground(new Color(128, 128, 0));
		btnConsultarPartidos_1.setBounds(37, 364, 200, 49);
		panelLeft.add(btnConsultarPartidos_1);

		JButton btnCambiarDorsal_1 = new JButton("     Cambiar Dorsal");
		btnCambiarDorsal_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal_1.setFocusable(false);
		btnCambiarDorsal_1.setBorder(null);
		btnCambiarDorsal_1.setBackground(new Color(255, 128, 64));
		btnCambiarDorsal_1.setBounds(37, 432, 200, 49);
		panelLeft.add(btnCambiarDorsal_1);

		JButton btnCambiarContrasea = new JButton("     Cambiar Contraseña");
		btnCambiarContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarContrasea.setFocusable(false);
		btnCambiarContrasea.setBorder(null);
		btnCambiarContrasea.setBackground(new Color(128, 128, 0));
		btnCambiarContrasea.setBounds(37, 502, 200, 49);
		panelLeft.add(btnCambiarContrasea);
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

		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
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
		CambiarDorsal cambiarDorsal = new CambiarDorsal(controller, userName);
		this.dispose();
		cambiarDorsal.setVisible(true);
	}
}
