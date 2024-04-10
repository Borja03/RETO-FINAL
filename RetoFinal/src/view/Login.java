package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPass;
	private JComboBox<String> cBxRole;
	private JButton btnLogIn;
	private static Controller controller;
	private JLabel lblMsg;


	public static void main(String[] args) {
		controller = new Controller();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();

					frame = new Login();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public Login() {

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

		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUserName.setBounds(514, 235, 407, 53);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblUserName = new JLabel("Usre Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(383, 235, 151, 53);
		contentPane.add(lblUserName);

		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(128, 128, 0));
		panelLogo.setBounds(489, 25, 328, 154);
		contentPane.add(panelLogo);

		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPass.setBounds(383, 324, 151, 53);
		contentPane.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPass.setColumns(10);
		txtPass.setBounds(514, 324, 407, 53);
		contentPane.add(txtPass);

		btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(this);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogIn.setBounds(758, 544, 163, 53);
		contentPane.add(btnLogIn);

		JLabel lblNewLabel = new JLabel("Forgot password ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(624, 625, 163, 21);
		contentPane.add(lblNewLabel);

		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRole.setBounds(383, 417, 151, 53);
		contentPane.add(lblRole);

		// Create a JComboBox for role selection
		cBxRole = new JComboBox<>();
		cBxRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		cBxRole.setBounds(514, 417, 407, 53);
		cBxRole.addItem("Admin");
		cBxRole.addItem("Entrenador");
		cBxRole.addItem("Jugador");
		contentPane.add(cBxRole);

		lblMsg = new JLabel("");
		lblMsg.setForeground(new Color(255, 0, 0));
		lblMsg.setBackground(new Color(255, 0, 0));
		lblMsg.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMsg.setBounds(588, 513, 239, 21);
		contentPane.add(lblMsg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogIn) {

			String username = txtUserName.getText();
			String password = new String(txtPass.getPassword());
			String userType = (String) cBxRole.getSelectedItem();
			System.out.println("userType : " + userType);

			if (txtUserName.getText().isEmpty() || txtPass.getPassword().length == 0) {
				lblMsg.setText("ERROR all fields are required");
			} else if (controller.checkUserExist(username, password, userType)) {
				if ("Admin".equals(userType)) {
					MenuAdmin menuAdmin = new MenuAdmin(controller);
					menuAdmin.setVisible(true);
					this.setVisible(false);
				} else if ("Entrenador".equals(userType)) {
					MenuEntrenador menuEntrenador = new MenuEntrenador(controller, username);
					menuEntrenador.setVisible(true);
					this.setVisible(false);
				} else if ("Jugador".equals(userType)) {
					MenuJugador menuJugador = new MenuJugador(controller);
					menuJugador.setVisible(true);
					this.setVisible(false);
				}
			} else {
				// JOptionPane.showMessageDialog(LoginWindow.this, "Invalid username or
			}


		}

	}
	}




