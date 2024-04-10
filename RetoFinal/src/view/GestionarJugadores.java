package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionarJugadores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCrear;
	private JButton btnDelete;
	private JButton btnModificar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionarJugadores frame = new GestionarJugadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionarJugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCrear = new JButton("Añadir Jugadores");
		btnCrear.addActionListener(this);

		btnCrear.setBounds(137, 62, 176, 23);
		contentPane.add(btnCrear);

		btnDelete = new JButton("Eliminar Jugadores");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(137, 122, 176, 23);
		contentPane.add(btnDelete);

		btnModificar = new JButton("Modificar Jugadores");
		btnModificar.setBounds(137, 178, 176, 23);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnCrear) {
			AnadirJugadores a1 = new AnadirJugadores();
			a1.setVisible(true);
			this.dispose();
		} else if (o == btnDelete) {
			EliminarJugadores e1 = new EliminarJugadores();
			e1.setVisible(true);
			this.dispose();
		} else if (o == btnModificar) {
			ModificarJugadores m1 = new ModificarJugadores();
			m1.setVisible(true);
			this.dispose();
		}

	}
}
