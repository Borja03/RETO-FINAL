
package view;

import java.awt.BorderLayout;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import aplicacion.Splash;
import controller.Controller;

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

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JCheckBox;
import javax.swing.JToggleButton;


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
    private JToggleButton tglBtnDark;
    private boolean darkModeState;

   
    public Login(Controller cont) {
        this.controller = cont;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1008, 717);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

		this.darkModeState= Splash.darkModeState;

        // Load and set the image
        ImagePanel panelLeft = new ImagePanel(getClass().getResource("/images/fotoP.png"));
        panelLeft.setBounds(0, 0, 345, 680);
        contentPane.add(panelLeft);
        contentPane.setLayout(null);

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

        JLabel lblNewLabel = new JLabel("Forgot password ?");
        lblNewLabel.setBounds(624, 625, 163, 21);
        lblNewLabel.setFont(loadFont("../fonts/tilt.ttf", Font.PLAIN, 10));
        contentPane.add(lblNewLabel);

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

    
	
	 private void savePreference(boolean enabled) {
	        try (PrintWriter writer = new PrintWriter("preferences.txt")) {
	            writer.println(enabled);
	        } catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	        }
	    }
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
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnLogIn) {
			String userName = txtUserName.getText();
			String password = new String(txtPass.getPassword());
			String userType = (String) cBxRole.getSelectedItem();

			if (txtUserName.getText().isEmpty() || txtPass.getPassword().length == 0) {
				lblMsg.setText("ERROR: All fields are required");
			} else if (controller.logIn(userName, password, userType)) {
				if ("Admin".equals(userType)) {
					MenuAdmin menuAdmin = new MenuAdmin(controller);
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

            repaint();
        
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
