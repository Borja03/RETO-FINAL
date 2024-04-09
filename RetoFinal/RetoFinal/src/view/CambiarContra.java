package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.event.*;

public class CambiarContra extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Controller l;
    private JButton cerrarSesion;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public CambiarContra(Controller controlador) {
        this.l = controlador;
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
                cambiarContraseña();
            }
        });
        btnOk.setBounds(335, 240, 89, 23);
        contentPane.add(btnOk);

        cerrarSesion = new JButton("Cerrar sesión");
        cerrarSesion.setBounds(236, 240, 89, 23);
        contentPane.add(cerrarSesion);

        cerrarSesion.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == cerrarSesion) {
            Login frame = new Login();
            frame.setVisible(true);
            dispose();
        }
    }

    private void cambiarContraseña() {
        String newPassword = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

      

        JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
