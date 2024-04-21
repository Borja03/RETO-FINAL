package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import javax.swing.JCheckBox;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPass;
	private JComboBox<String> cBxRole;
	private JButton btnLogIn;
	private Controller controller;
	private JLabel lblMsg;
	private JCheckBox chckbxShowPassword;

	public Login(Controller cont) {
		this.controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 345, 680);
		panelLeft.setBackground(new Color(128, 128, 0));
		contentPane.add(panelLeft);
		JLabel imgTitle = new JLabel();
		imgTitle.setBounds(0, 0, 345, 680);

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/copa.png"));
		imgTitle.setIcon(imgIcon);
		contentPane.add(imgTitle);

		txtUserName = new JTextField();
		txtUserName.setBounds(514, 235, 407, 53);
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(383, 235, 151, 53);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblUserName);

		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(383, 324, 151, 53);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setBounds(514, 324, 407, 53);
		txtPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPass.setColumns(10);
		contentPane.add(txtPass);

		btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(758, 544, 163, 53);
		btnLogIn.addActionListener(this);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnLogIn);

		JLabel lblNewLabel = new JLabel("Forgot password ?");
		lblNewLabel.setBounds(624, 625, 163, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblNewLabel);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(383, 417, 151, 53);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblRole);

		// Create a JComboBox for role selection
		cBxRole = new JComboBox<>();
		cBxRole.setBounds(514, 417, 407, 53);
		cBxRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		cBxRole.addItem("Admin");
		cBxRole.addItem("Entrenador");
		cBxRole.addItem("Jugador");
		contentPane.add(cBxRole);

		lblMsg = new JLabel("");
		lblMsg.setBounds(588, 513, 239, 21);
		lblMsg.setForeground(new Color(255, 0, 0));
		lblMsg.setBackground(new Color(255, 0, 0));
		lblMsg.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblMsg);

		chckbxShowPassword = new JCheckBox("");
		chckbxShowPassword.setBounds(899, 390, 22, 21);
		contentPane.add(chckbxShowPassword);
		chckbxShowPassword.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Show password");
		lblNewLabel_1.setBounds(809, 394, 112, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDarkModeImg = new JLabel();
		ImageIcon darkMode = new ImageIcon(getClass().getResource("/images/icons/darkmodeIcon.png"));
		lblDarkModeImg.setIcon(darkMode);
		lblDarkModeImg.setBounds(758, 49, 150, 50);
		contentPane.add(lblDarkModeImg);
		
		JLabel lblBrightModeImg = new JLabel();
		ImageIcon imgIconBright = new ImageIcon(getClass().getResource("/images/icons/brightModeIcon.png"));
		lblBrightModeImg.setIcon(imgIconBright);
		lblBrightModeImg.setBounds(780, 49, 150, 50);
		contentPane.add(lblBrightModeImg);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogIn) {
			String userName = txtUserName.getText();
			String password = new String(txtPass.getPassword());
			String userType = (String) cBxRole.getSelectedItem();
			// String myTeam = controller.getMyTeam(username);

			if (txtUserName.getText().isEmpty() || txtPass.getPassword().length == 0) {
				lblMsg.setText("ERROR: All fields are required");
			} else if (controller.logIn(userName, password, userType)) {
				if ("Admin".equals(userType)) {
					MenuAdmin menuAdmin = new MenuAdmin(controller,userName,userType.toLowerCase());
					menuAdmin.setVisible(true);
					this.setVisible(false);
				} else if ("Entrenador".equals(userType)) {
					MenuEntrenador menuEntrenador = new MenuEntrenador(controller,userName,userType.toLowerCase());
					menuEntrenador.setVisible(true);
					this.setVisible(false);
				} else if ("Jugador".equals(userType)) {
					MenuJugador menuJugador = new MenuJugador(controller,userName,userType.toLowerCase());
					menuJugador.setVisible(true);
					this.setVisible(false);
				}
			} else {
				lblMsg.setText("Invalid username or password");
			}
		} else if (e.getSource() == chckbxShowPassword) {
			if (chckbxShowPassword.isSelected()) {
				txtPass.setEchoChar((char) 0);
			} else {
				
				txtPass.setEchoChar('*');
			}
		}
	}
}
