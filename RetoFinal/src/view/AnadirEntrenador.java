package view;

import java.awt.EventQueue; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.usuarios.CargoEntrenador;

import javax.swing.JComboBox;

public class AnadirEntrenador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblUser;
	private JLabel lblContrasena;
	private JLabel lblTipo;
	private JTextField textFieldUSer;
	private JTextField textFieldContrasena;
	private JButton btnOK;
	private Controller controller;
	private JTextField txtEquiponame;
	private JComboBox comboBoxTipo;

	public AnadirEntrenador(Controller cont) {
		this.controller = cont;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUser = new JLabel("Usuario");
		lblUser.setBounds(131, 118, 46, 14);
		contentPane.add(lblUser);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(131, 154, 64, 14);
		contentPane.add(lblContrasena);

		lblTipo = new JLabel("Tipo de Entrenador");
		lblTipo.setBounds(131, 191, 101, 14);
		contentPane.add(lblTipo);

		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(250, 115, 225, 20);
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(250, 151, 225, 20);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		btnOK = new JButton("OK");
		btnOK.setBounds(492, 366, 89, 23);
		contentPane.add(btnOK);

		txtEquiponame = new JTextField();
		txtEquiponame.setBounds(250, 71, 225, 20);
		txtEquiponame.setColumns(10);
		contentPane.add(txtEquiponame);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(131, 74, 46, 14);
		contentPane.add(lblEquipo);

		String tipo = "";
		String[] tipoEntrenador = { "Primer_entrenador", "Segundo_entrenador" };
		for (int i = 0; i < tipoEntrenador.length; i++) {
			tipo = tipoEntrenador[i];
		}

		comboBoxTipo = new JComboBox<String>(tipoEntrenador);
		comboBoxTipo.setBounds(250, 187, 225, 22);
		contentPane.add(comboBoxTipo);
		btnOK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = textFieldUSer.getText();
		String password = textFieldContrasena.getText();
		String myTeam = txtEquiponame.getText();
		String tipoString = (String) comboBoxTipo.getSelectedItem();
		CargoEntrenador tipo = null;
		if (tipoString.equals("Primer_entrenador")) {
			tipo = CargoEntrenador.PRIMER_ENTRENADOR;
		} else if (tipoString.equals("Segundo_entrenador")) {
			tipo = CargoEntrenador.SEGUNDO_ENTRENADOR;
		}
		
		Object o = e.getSource();
		if (controller.crearEntrenador(myTeam, user, password, tipo)) {
			if (o == btnOK) {
				int opcion = JOptionPane.showConfirmDialog(this, (String) "",
						"El entrenador ha sido introducido correctamente\n¿Desea añadir otro entrenador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				textFieldUSer.setText("");
				textFieldContrasena.setText("");

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin g1 = new MenuAdmin(controller);
					g1.setVisible(true);
				}
			}
		}

	}
}