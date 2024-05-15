package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import aplicacion.Splash;
import controller.Controller;
import utlidades.LoginException;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.swing.JToggleButton;

/**
 * The Splash class represents the splash screen of the application.
 * 
 * @author 1dami G1
 * @since 2024-05-13
 */
public class Login extends JFrame implements ActionListener {

	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The main content pane of the login window.
	 */
	private JPanel contentPane;

	/**
	 * Text field for entering the username.
	 */
	private JTextField txtUserName;

	/**
	 * Password field for entering the password.
	 */
	private JPasswordField txtPass;

	/**
	 * Combo box for selecting the user role.
	 */
	private JComboBox<String> cBxRole;

	/**
	 * Button for logging in.
	 */
	private JButton btnLogIn;

	/**
	 * Reference to the controller for handling login actions.
	 */
	private Controller controller;

	/**
	 * Label for displaying messages to the user.
	 */
	private JLabel lblMsg;

	/**
	 * Checkbox for toggling password visibility.
	 */
	private JCheckBox chckbxShowPassword;

	/**
	 * Toggle button for switching between dark and light mode.
	 */
	private JToggleButton tglBtnDark;

	/**
	 * State variable indicating whether dark mode is enabled or not.
	 */
	private boolean darkModeState;

	/**
	 * Constructs a new Login window.
	 * 
	 * @param cont The Controller instance.
	 */
	public Login(Controller cont) {
		this.controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		this.darkModeState = Splash.darkModeState;

		// Load and set the image
		JLabel panelLeft = new JLabel();
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/fotoP.png"));
		panelLeft.setIcon(imgIcon);
		panelLeft.setBounds(0, 0, 345, 680);
		contentPane.add(panelLeft);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		txtUserName = new JTextField();
		txtUserName.setBounds(514, 235, 407, 53);
		txtUserName.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(383, 235, 151, 53);
		lblUserName.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
		contentPane.add(lblUserName);

		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(383, 324, 151, 53);
		lblPass.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
		contentPane.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setBounds(514, 324, 407, 53);
		txtPass.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
		txtPass.setColumns(10);
		contentPane.add(txtPass);

		btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(758, 544, 163, 53);
		btnLogIn.addActionListener(this);
		btnLogIn.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		contentPane.add(btnLogIn);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(383, 417, 151, 53);
		lblRole.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
		contentPane.add(lblRole);

		// Create a JComboBox for role selection
		cBxRole = new JComboBox<>();
		cBxRole.setBounds(514, 417, 407, 53);
		cBxRole.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
		cBxRole.addItem("Admin");
		cBxRole.addItem("Entrenador");
		cBxRole.addItem("Jugador");
		contentPane.add(cBxRole);

		lblMsg = new JLabel("");
		lblMsg.setBounds(588, 513, 239, 21);
		lblMsg.setForeground(new Color(255, 0, 0));
		lblMsg.setBackground(new Color(255, 0, 0));
		lblMsg.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 12));
		contentPane.add(lblMsg);

		chckbxShowPassword = new JCheckBox("");
		chckbxShowPassword.setBounds(899, 390, 22, 21);
		contentPane.add(chckbxShowPassword);
		chckbxShowPassword.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Show password");
		lblNewLabel_1.setBounds(809, 394, 112, 13);
		contentPane.add(lblNewLabel_1);

		tglBtnDark = new JToggleButton("Dark Mode");
		tglBtnDark.setBounds(769, 50, 128, 53);

		tglBtnDark = new JToggleButton("Dark Mode");
		tglBtnDark.setBounds(769, 50, 128, 53);
		tglBtnDark.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					savePreference(true);
					tglBtnDark.setText("Light Mode");
					applyDarkMode(true);
				} else {
					savePreference(false);
					tglBtnDark.setText("Dark Mode");
					applyDarkMode(false);
				}
			}
		});
		tglBtnDark.setSelected(darkModeState);
		contentPane.add(tglBtnDark);

		applyDarkMode(darkModeState);
	}

	/**
	 * Loads a custom font from the specified font path.
	 * 
	 * @param fontPath The path to the font file.
	 * @param style    The style of the font (e.g., Font.PLAIN, Font.BOLD,
	 *                 Font.ITALIC).
	 * @param size     The size of the font.
	 * @return The loaded custom font.
	 */

	private Font loadFont(String fontPath, int style, float size) {
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(fontPath))
					.deriveFont(style, size);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
			return customFont;
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Saves the user's preference for dark mode.
	 * 
	 * @param enabled {@code true} if dark mode is enabled, {@code false} otherwise.
	 */
	private void savePreference(boolean enabled) {
		try (PrintWriter writer = new PrintWriter("preferences.txt")) {
			writer.println(enabled);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Applies dark mode or light mode based on the given boolean value.
	 * 
	 * @param enabled {@code true} to apply dark mode, {@code false} to apply light
	 *                mode.
	 */

	private void applyDarkMode(boolean enabled) {
		if (enabled) {
			try {
				UIManager.setLookAndFeel(new FlatDarkLaf());
			} catch (Exception ex) {
				System.err.println("Failed to initialize LaF");
			}
		} else {
			try {
				UIManager.setLookAndFeel(new FlatLightLaf());
			} catch (Exception ex) {
				System.err.println("Failed to initialize LaF");
			}
		}
		// Update the UI to reflect the new look and feel
		SwingUtilities.updateComponentTreeUI(this);
	}

	/**
	 * Handles action events for the login class.
	 * 
	 * @param e the action event
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogIn) {
			String userName = txtUserName.getText();
			String password = new String(txtPass.getPassword());
			String userType = (String) cBxRole.getSelectedItem();

			try {
				if (txtUserName.getText().isEmpty() || txtPass.getPassword().length == 0) {
					throw new LoginException("ERROR: All fields are required");
				} else if (controller.logIn(userName, password, userType)) {
					if ("Admin".equals(userType)) {
						MenuAdmin menuAdmin = new MenuAdmin(controller);
						menuAdmin.setVisible(true);
						this.setVisible(false);
					} else if ("Entrenador".equals(userType)) {
						MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName,
								userType.toLowerCase());
						menuEntrenador.setVisible(true);
						this.setVisible(false);
					} else if ("Jugador".equals(userType)) {
						MenuJugador menuJugador = new MenuJugador(controller, userName, userType.toLowerCase());
						menuJugador.setVisible(true);
						this.setVisible(false);
					}
				} else {
					throw new LoginException("Invalid username or password");
				}
			} catch (LoginException ex) {
				lblMsg.setText(ex.getMessage());
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