package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import view.toDelete.AnadirEntrenador;

public class GestionarEntre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCrear;
	private JButton btnDelete;
	private JButton btnModificar;
	private Controller controller;
	private JButton cerrarSesion;

	public GestionarEntre(Controller controlador) {
		this.controller = controlador;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCrear = new JButton("Añadir Entrenador");
		btnCrear.addActionListener(this);

		btnCrear.setBounds(137, 62, 176, 23);
		contentPane.add(btnCrear);

		btnDelete = new JButton("Eliminar Entrenador");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(137, 122, 176, 23);
		contentPane.add(btnDelete);

		btnModificar = new JButton("Modificar Entrenador");
		btnModificar.setBounds(137, 178, 176, 23);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == cerrarSesion) {
			Login frame = new Login(controller);
			frame.setVisible(true);
			dispose();
		}else if(o == btnCrear) {
			this.dispose();
			AnadirEntrenador av = new AnadirEntrenador(controller);
			av.setVisible(true);
		}else if(o == btnDelete) {
			this.dispose();
			EliminarEntrenador av = new EliminarEntrenador(controller);
			av.setVisible(true);
		}else {
			this.dispose();
			ModificarEntrenador av = new ModificarEntrenador(controller);
			av.setVisible(true);
		}

	}
}



