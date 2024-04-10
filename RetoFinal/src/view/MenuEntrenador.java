package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class MenuEntrenador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogOut;
	private JButton btnAddEq;
	private JButton btngJugadores;
	private Controller controller;
	private JLabel lblWelcome;
	private String userName;
	private JButton btnConsultarPartidos;

	public MenuEntrenador(Controller cont, String userC) {
		this.controller = cont;
		userName = userC;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(128, 128, 0));
		panelLeft.setBounds(0, 0, 345, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnAddEq = new JButton("Consultar Equipo");
		btnAddEq.addActionListener(this);
		btnAddEq.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddEq.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEq.setFocusable(false);
		btnAddEq.setBorder(null);
		btnAddEq.setBackground(new Color(128, 128, 0));
		btnAddEq.setBounds(57, 466, 200, 49);
		panelLeft.add(btnAddEq);

		btngJugadores = new JButton("Gestionar  jugadores");
		btngJugadores.addActionListener(this);
		btngJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btngJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btngJugadores.setFocusable(false);
		btngJugadores.setBorder(null);
		btngJugadores.setBackground(new Color(128, 128, 0));
		btngJugadores.setBounds(57, 406, 200, 49);
		panelLeft.add(btngJugadores);

		lblWelcome = new JLabel("Welcome Entrenador");
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
		btnConsultarPartidos.setBounds(57, 526, 200, 49);
		panelLeft.add(btnConsultarPartidos);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(57, 586, 200, 49);
		panelLeft.add(btnLogOut);
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
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();
		if (o == btnLogOut) {
			controller.closeConnection();
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);

		} else if (o == btngJugadores) {
			GestionarJugadores g1 = new GestionarJugadores(controller);
			g1.setVisible(true);
			this.dispose();
		}

	}
}
