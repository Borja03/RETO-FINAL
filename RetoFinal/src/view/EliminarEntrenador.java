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

public class EliminarEntrenador extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEJugador;
	private JLabel lblEJugador;
	private JButton btnOK;
	private Controller controller;


	public EliminarEntrenador(Controller cont) {
		this.controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblEJugador = new JLabel("Introduce el nombre de usuario del entrenador que deseas eliminar:");
		lblEJugador.setBounds(48, 74, 340, 14);
		contentPane.add(lblEJugador);

		textFieldEJugador = new JTextField();
		textFieldEJugador.setBounds(48, 112, 259, 20);
		contentPane.add(textFieldEJugador);
		textFieldEJugador.setColumns(10);

		btnOK = new JButton("OK");
		btnOK.setBounds(299, 210, 89, 23);
		contentPane.add(btnOK);
		btnOK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		int opcion ;
		String entrenador=textFieldEJugador.getText();

		if (o == btnOK) {
			if(controller.borrarEntrenador(entrenador)) {
				 opcion = JOptionPane.showConfirmDialog(this,
						(String) "El entrenador ha sido eliminado correctamente\n¿Desea eliminar otro entrenador?", "",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				 textFieldEJugador.setText("");
				 if (opcion == JOptionPane.NO_OPTION) {
						this.dispose();
						GestionarEntre g1 = new GestionarEntre(controller);
						g1.setVisible(true);
					}
			}
			

			
		}

	}

}
