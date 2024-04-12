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
	private JTextField txtEquiponame;
	private String user;
	private String myTeam;

	public AnadirJugadores(Controller cont,String user,String team) {
		this.controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUser = new JLabel("Usuario");
		lblUser.setBounds(151, 118, 46, 14);
		contentPane.add(lblUser);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(151, 154, 64, 14);
		contentPane.add(lblContrasena);

		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(151, 191, 46, 14);
		contentPane.add(lblDorsal);

		lblGoles = new JLabel("Goles");
		lblGoles.setBounds(151, 230, 46, 14);
		contentPane.add(lblGoles);

		lblAsistencias = new JLabel("Asistencias");
		lblAsistencias.setBounds(151, 274, 89, 14);
		contentPane.add(lblAsistencias);

		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(250, 115, 225, 20);
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(250, 151, 225, 20);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldDorsal = new JTextField();
		textFieldDorsal.setBounds(250, 188, 225, 20);
		contentPane.add(textFieldDorsal);
		textFieldDorsal.setColumns(10);

		textFieldGoles = new JTextField();
		textFieldGoles.setBounds(250, 227, 225, 20);
		contentPane.add(textFieldGoles);
		textFieldGoles.setColumns(10);

		textFieldAsist = new JTextField();
		textFieldAsist.setBounds(250, 271, 225, 20);
		contentPane.add(textFieldAsist);
		textFieldAsist.setColumns(10);

		btnOK = new JButton("OK");
		btnOK.setBounds(492, 366, 89, 23);
		contentPane.add(btnOK);
		
		txtEquiponame = new JTextField();
		txtEquiponame.setBounds(250, 71, 225, 20);
		txtEquiponame.setColumns(10);
		txtEquiponame.setText(team);
		txtEquiponame.setEditable(false);
		contentPane.add(txtEquiponame);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(151, 74, 46, 14);
		contentPane.add(lblEquipo);
		btnOK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user=textFieldUSer.getText();
		String password=textFieldContrasena.getText();
		String myTeam= txtEquiponame.getText();
		int dorsal=Integer.valueOf(textFieldDorsal.getText());
		int numGoles=Integer.valueOf(textFieldGoles.getText());
		int numAsist=Integer.valueOf(textFieldAsist.getText());
		
		Object o = e.getSource();
		if(controller.crearJugador(user, password, dorsal, numGoles, numAsist, myTeam)) {
			if (o == btnOK) {
				int opcion = JOptionPane.showConfirmDialog(this, (String) "",
						"El jugador ha sido introducido correctamente\n¿Desea añadir otro jugador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				textFieldUSer.setText("");
				textFieldContrasena.setText("");
				textFieldDorsal.setText("");
				textFieldGoles.setText("");
				textFieldAsist.setText("");

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					GestionarJugadores g1 = new GestionarJugadores(controller,user,myTeam);
					g1.setVisible(true);
				}
			}
		}

		

	}
}
