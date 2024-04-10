package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class GestionarEntre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller l;
	private JButton cerrarSesion;

	public GestionarEntre(Controller controlador) {
		this.l = controlador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		cerrarSesion = new JButton("Cerrar sesión");
		cerrarSesion.setBounds(341, 242, 95, 21);
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
}

