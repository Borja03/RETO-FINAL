package aplicacion;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import view.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;

public class Splash extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Controller controller;
	public static boolean darkModeState;
	public Splash(Controller cont) {
		this.controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);

		JLabel imgTitle = new JLabel();
		imgTitle.setBounds(277, 74, 463, 149);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/titlelogo.png"));
		contentPane.setLayout(null);
		imgTitle.setIcon(imgIcon);
		contentPane.add(imgTitle);

		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(305, 143, 403, 403);
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/logo.gif"));
		imageLabel.setIcon(imageIcon);
		contentPane.add(imageLabel);

		Label label = new Label("Made in Tartanga 2023/2024");
		label.setBounds(413, 596, 250, 41);
		label.setFont(new Font("VASCA", Font.BOLD, 14));
		contentPane.add(label);

		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(controller);
				dispose();
				login.setVisible(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
        darkModeState = loadPreference();

	}
	
	  private boolean loadPreference() {
		  boolean darkModeEnabled=false;
	        try (BufferedReader reader = new BufferedReader(new FileReader("preferences.txt"))) {
	            String line = reader.readLine();
	            if (line != null) {
	                 darkModeEnabled = Boolean.parseBoolean(line);
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return darkModeEnabled;
	    }
}
