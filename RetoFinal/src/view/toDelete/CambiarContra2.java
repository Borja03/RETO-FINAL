package view.toDelete;

import javax.swing.*; 
import javax.swing.border.EmptyBorder;

import controller.Controller;
import view.Login;
import view.MenuEntrenador;
import view.MenuJugador;

import java.awt.event.*;

public class CambiarContra2 extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Controller controller;
    private JButton cerrarSesion;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private String userType;
    private String username;
    private JButton btnVolverMenu;

    public CambiarContra2(Controller controlador, String userType, String username) {
        this.controller = controlador;
        this.userType = userType;
        this.username = username;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nueva Contraseña:");
        lblNewLabel.setBounds(10, 40, 122, 14);
        contentPane.add(lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(142, 37, 250, 20);
        contentPane.add(passwordField);

        JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña:");
        lblConfirmarContrasea.setBounds(10, 80, 136, 14);
        contentPane.add(lblConfirmarContrasea);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(142, 77, 250, 20);
        contentPane.add(confirmPasswordField);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarContrasenia();
            }
        });
        btnOk.setBounds(335, 240, 89, 23);
        contentPane.add(btnOk);

        cerrarSesion = new JButton("Cerrar sesión");
        cerrarSesion.setBounds(236, 240, 89, 23);
        contentPane.add(cerrarSesion);

        cerrarSesion.addActionListener(this);

        // Crear y configurar el botón de volver al menú correspondiente
        if ("Jugador".equals(userType)) {
            btnVolverMenu = new JButton("Volver al Menú de Jugador");
        } else if ("Entrenador".equals(userType)) {
            btnVolverMenu = new JButton("Volver al Menú de Entrenador");
        }
        btnVolverMenu.setBounds(10, 240, 200, 23);
        contentPane.add(btnVolverMenu);
        btnVolverMenu.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == cerrarSesion) {
            Login frame = new Login(controller);
            frame.setVisible(true);
            dispose();
        } else if (o == btnVolverMenu) {
            if ("Jugador".equals(userType)) {
                MenuJugador menuJugador = new MenuJugador(controller, username);
                menuJugador.setVisible(true);
            } else if ("Entrenador".equals(userType)) {
                MenuEntrenador menuEntrenador = new MenuEntrenador(controller, username);
                menuEntrenador.setVisible(true);
            }
            dispose(); // Cerrar la ventana actual
        }
    }

    private void cambiarContrasenia() {
        String newPassword = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean changed = controller.cambiarPassword(username, newPassword, userType);

        if (changed) {
            JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if ("Jugador".equals(userType)) {
                MenuJugador menuJugador = new MenuJugador(controller, username);
                menuJugador.setVisible(true);
            } else if ("Entrenador".equals(userType)) {
                MenuEntrenador menuEntrenador = new MenuEntrenador(controller, username);
                menuEntrenador.setVisible(true);
            }
            dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}