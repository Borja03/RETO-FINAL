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
import java.time.LocalDate;

/**
 * The Splash class represents the splash screen of the application.
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class Splash extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static Controller controller;
    public static boolean darkModeState;

    /**
     * Constructs a new Splash screen.
     * 
     * @param cont The Controller instance.
     */
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
		setLocationRelativeTo(null);

        JLabel imgTitle = new JLabel();
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/titleLogo.png"));
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

    /**
     * Loads the user's preference for dark mode from a preferences file.
     * 
     * @return True if dark mode is enabled, false otherwise.
     */
    private boolean loadPreference() {
        boolean darkModeEnabled = false;
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