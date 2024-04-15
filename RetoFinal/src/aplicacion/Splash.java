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
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;

public class Splash extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Controller controller;

	public Splash(Controller cont) {
		this.controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel imgTitle = new JLabel();
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/titlelogo.png"));
		imgTitle.setIcon(imgIcon);
		imgTitle.setBounds(277, 74, 463, 149);
		contentPane.add(imgTitle);

		JLabel imageLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/logo.gif"));
		imageLabel.setIcon(imageIcon);
		imageLabel.setBounds(305, 143, 403, 403);
		contentPane.add(imageLabel);

		Label label = new Label("Made in Tartanga 2023/2024");
		label.setFont(new Font("VASCA", Font.BOLD, 14));
		label.setBounds(413, 596, 250, 41);
		contentPane.add(label);

		Timer timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(controller);
				dispose();
				login.setVisible(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
}