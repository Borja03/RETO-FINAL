package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuAdmin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogOut;
	private JButton btnAddEq;
	private JButton btnAddJugado;
	private Controller controller;
	private JLabel lblWelcome;
	private String userName;

	public MenuAdmin(Controller cont) {
		this.controller = cont;
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

		btnAddEq = new JButton("Añadir equipo");
		btnAddEq.addActionListener(this);
		btnAddEq.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddEq.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEq.setFocusable(false);
		btnAddEq.setBorder(null);
		btnAddEq.setBackground(new Color(128, 128, 0));
		btnAddEq.setBounds(57, 466, 200, 49);
		panelLeft.add(btnAddEq);

		btnAddJugado = new JButton("Añadir jugador");
		btnAddJugado.addActionListener(this);
		btnAddJugado.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddJugado.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddJugado.setFocusable(false);
		btnAddJugado.setBorder(null);
		btnAddJugado.setBackground(new Color(128, 128, 0));
		btnAddJugado.setBounds(57, 396, 200, 49);
		panelLeft.add(btnAddJugado);

		lblWelcome = new JLabel("Welcome Admin");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogOut) {
			controller.closeConnection();
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
		}
	}
}
