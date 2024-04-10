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

public class ModificarJugadores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEJugador;
	private JLabel lblEJugador;
	private JButton btnOK;

	public ModificarJugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblEJugador = new JLabel("Introduce el nombre de usuario del jugador que deseas modificar:");
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

		if (o == btnOK) {
			ModificarJugadores2 m1 = new ModificarJugadores2();
			m1.setVisible(true);
			this.dispose();
		}
	}

}
