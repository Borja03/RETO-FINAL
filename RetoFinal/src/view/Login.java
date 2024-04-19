package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;

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
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Load and set the image
        ImagePanel panelLeft = new ImagePanel(getClass().getResource("/images/fotoP.png"));
        panelLeft.setBounds(0, 0, 345, 680);
        contentPane.add(panelLeft);

        txtUserName = new JTextField();
        txtUserName.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
        txtUserName.setBounds(514, 235, 407, 53);
        contentPane.add(txtUserName);
        txtUserName.setColumns(10);

        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
        lblUserName.setBounds(383, 235, 151, 53);
        contentPane.add(lblUserName);

        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
        lblPass.setBounds(383, 324, 151, 53);
        contentPane.add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
        txtPass.setColumns(10);
        txtPass.setBounds(514, 324, 407, 53);
        contentPane.add(txtPass);

        btnLogIn = new JButton("Log in");
        btnLogIn.addActionListener(this);
        btnLogIn.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
        btnLogIn.setBounds(758, 544, 163, 53);
        contentPane.add(btnLogIn);

        JLabel lblNewLabel = new JLabel("Forgot password ?");
        lblNewLabel.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 10));
        lblNewLabel.setBounds(624, 625, 163, 21);
        contentPane.add(lblNewLabel);

        JLabel lblRole = new JLabel("Role");
        lblRole.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 16));
        lblRole.setBounds(383, 417, 151, 53);
        contentPane.add(lblRole);

        // Create a JComboBox for role selection
        cBxRole = new JComboBox<>();
        cBxRole.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 14));
        cBxRole.setBounds(514, 417, 407, 53);
        cBxRole.addItem("Admin");
        cBxRole.addItem("Entrenador");
        cBxRole.addItem("Jugador");
        contentPane.add(cBxRole);

        lblMsg = new JLabel("");
        lblMsg.setForeground(new Color(255, 0, 0));
        lblMsg.setBackground(new Color(255, 0, 0));
        lblMsg.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 12));
        lblMsg.setBounds(588, 513, 239, 21);
        contentPane.add(lblMsg);

        chckbxShowPassword = new JCheckBox("");
        chckbxShowPassword.setBounds(899, 390, 22, 21);
        contentPane.add(chckbxShowPassword);
        chckbxShowPassword.addActionListener(this);

        JLabel lblNewLabel_1 = new JLabel("Show password");
        lblNewLabel_1.setBounds(809, 394, 112, 13);
        contentPane.add(lblNewLabel_1);
    }

    private Font loadFont(String fontPath, int style, float size) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(fontPath)).deriveFont(style, size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogIn) {
            String username = txtUserName.getText();
            String password = new String(txtPass.getPassword());
            String userType = (String) cBxRole.getSelectedItem();
            // String myTeam = controller.getMyTeam(username);

            if (txtUserName.getText().isEmpty() || txtPass.getPassword().length == 0) {
                lblMsg.setText("ERROR: All fields are required");
            } else if (controller.logIn(username, password, userType)) {
                if ("Admin".equals(userType)) {
                    MenuAdmin menuAdmin = new MenuAdmin(controller);
                    menuAdmin.setVisible(true);
                    this.setVisible(false);
                } else if ("Entrenador".equals(userType)) {
                    MenuEntrenador menuEntrenador = new MenuEntrenador(controller, username);
                    menuEntrenador.setVisible(true);
                    this.setVisible(false);
                } else if ("Jugador".equals(userType)) {
                    MenuJugador menuJugador = new MenuJugador(controller, username);
                    menuJugador.setVisible(true);
                    this.setVisible(false);
                }
            } else {
                lblMsg.setText("Invalid username or password");
            }
        } else if (e.getSource() == chckbxShowPassword) {
            if (chckbxShowPassword.isSelected()) {
                // Set password field type to text to show characters
                txtPass.setEchoChar((char) 0);
            } else {
                // Set password field type back to password to hide characters with asterisks
                // (*)
                txtPass.setEchoChar('*');
            }
            repaint();
        }
    }

    // Inner class to display image panel
    class ImagePanel extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image img;

        public ImagePanel(URL url) {
            this(new ImageIcon(url).getImage());
        }

        public ImagePanel(Image img) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
