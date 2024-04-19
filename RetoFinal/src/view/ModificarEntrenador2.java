package view;

import java.awt.EventQueue; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.usuarios.CargoEntrenador;
import model.usuarios.Entrenador;
import model.usuarios.Jugador;
import javax.swing.JComboBox;

public class ModificarEntrenador2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUser;
	private JLabel lblContrasena;
	private JLabel lblTipo;
	private JTextField textFieldUSer;
	private JTextField textFieldContrasena;
	private JButton btnOK;
	private Controller controller;
	private String user;
	private JComboBox comboBoxTipo;

	public ModificarEntrenador2(Controller cont, String userC) {
		this.controller = cont;
		this.user = userC;
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

		lblTipo = new JLabel("Tipo de entrenador");
		lblTipo.setBounds(86, 154, 99, 14);
		contentPane.add(lblTipo);

		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(195, 78, 225, 20);
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(195, 114, 225, 20);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		btnOK = new JButton("OK");
		btnOK.setBounds(492, 366, 89, 23);
		contentPane.add(btnOK);

		String tipo = "";
		String[] tipoEntrenador = { "Primer_entrenador", "Segundo_entrenador" };
		for (int i = 0; i < tipoEntrenador.length; i++) {
			tipo = tipoEntrenador[i];
		}

		comboBoxTipo = new JComboBox<String>(tipoEntrenador);
		comboBoxTipo.setBounds(195, 150, 225, 22);
		contentPane.add(comboBoxTipo);
		btnOK.addActionListener(this);

		entrenadorOldInfo();
	}

	public void entrenadorOldInfo() {

		Entrenador usr = (Entrenador) controller.getUsuario2(user);
		if (usr != null) {
			textFieldUSer.setText(usr.getUser());
			textFieldContrasena.setText(usr.getContrasenia());
		} else {
			System.out.println("El usuario no existe");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		int opcion = 0;

		// String user=textFieldUSer.getText();
		String password = textFieldContrasena.getText();
		// String myTeam= txtEquiponame.getText();
		String tipoString = (String) comboBoxTipo.getSelectedItem();
		CargoEntrenador tipo = null;
		if (tipoString.equalsIgnoreCase("Primer_entrenador")) {
			tipo = CargoEntrenador.PRIMER_ENTRENADOR;
		} else if (tipoString.equalsIgnoreCase("Segundo_entrenador")) {
			tipo = CargoEntrenador.SEGUNDO_ENTRENADOR;
		}
		String team = controller.getMyTeam(user);

		if (o == btnOK) {

			if (controller.modificarEntrenador(user, password, tipo)) {
				opcion = JOptionPane.showConfirmDialog(this,
						(String) "El entrenador ha sido modificado correctamente\n¿Desea modificar otro entrenador?",
						"", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			}

			if (opcion == JOptionPane.NO_OPTION) {
				this.dispose();
				MenuAdmin g1 = new MenuAdmin(controller);
				g1.setVisible(true);

			} else {
				ModificarEntrenador m1 = new ModificarEntrenador(controller);
				m1.setVisible(true);
				this.dispose();
			}
		}

	}
}