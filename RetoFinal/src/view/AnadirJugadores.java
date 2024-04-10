package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AnadirJugadores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUser;
	private JLabel lblContrasena;
	private JLabel lblDorsal;
	private JLabel lblGoles;
	private JLabel lblAsistencias;
	private JTextField textFieldUSer;
	private JTextField textFieldContrasena;
	private JTextField textFieldDorsal;
	private JTextField textFieldGoles;
	private JTextField textFieldAsist;
	private JButton btnOK;
	private Controller controller;

	public AnadirJugadores(Controller cont) {
		this.controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUser = new JLabel("Usuario");
		lblUser.setBounds(86, 81, 46, 14);
		contentPane.add(lblUser);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(86, 117, 64, 14);
		contentPane.add(lblContrasena);

		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(86, 154, 46, 14);
		contentPane.add(lblDorsal);

		lblGoles = new JLabel("Goles");
		lblGoles.setBounds(86, 193, 46, 14);
		contentPane.add(lblGoles);

		lblAsistencias = new JLabel("Asistencias");
		lblAsistencias.setBounds(86, 237, 89, 14);
		contentPane.add(lblAsistencias);

		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(185, 78, 225, 20);
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(185, 114, 225, 20);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldDorsal = new JTextField();
		textFieldDorsal.setBounds(185, 151, 225, 20);
		contentPane.add(textFieldDorsal);
		textFieldDorsal.setColumns(10);

		textFieldGoles = new JTextField();
		textFieldGoles.setBounds(185, 190, 225, 20);
		contentPane.add(textFieldGoles);
		textFieldGoles.setColumns(10);

		textFieldAsist = new JTextField();
		textFieldAsist.setBounds(185, 234, 225, 20);
		contentPane.add(textFieldAsist);
		textFieldAsist.setColumns(10);

		btnOK = new JButton("OK");
		btnOK.setBounds(492, 366, 89, 23);
		contentPane.add(btnOK);
		btnOK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnOK) {
			int opcion = JOptionPane.showConfirmDialog(this, (String) "",
					"El jugador ha sido introducido correctamente\n¿Desea añadir otro jugador?",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);

			if (opcion == JOptionPane.NO_OPTION) {
				this.dispose();
				GestionarJugadores g1 = new GestionarJugadores(controller);
				g1.setVisible(true);
			}
		}

	}
}