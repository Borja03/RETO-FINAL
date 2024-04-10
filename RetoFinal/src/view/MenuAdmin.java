package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class MenuAdmin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogOut;
	private JButton btnAddEq;
	private JButton btnAddJugado;
	private Controller controller;
	private JLabel lblWelcome;
	private String userName;
	private Controller l;
	private JButton crearEquipo;
	private JButton crearPartido;
	private JButton cambiarContra;
	private JButton gestionarEntre;
	private JButton cerrarSesion;
	private Container panelLeft = null;
  
	public MenuAdmin(Controller controlador) {
		this.l = controlador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		gestionarEntre = new JButton("Gestionar entrenador");
		gestionarEntre.setBounds(220, 94, 163, 45);
		contentPane.add(gestionarEntre);

		crearPartido = new JButton("Crear partido");
		crearPartido.setBounds(34, 163, 163, 45);
		contentPane.add(crearPartido);

		JTextPane titulo = new JTextPane();
		titulo.setText("DISPLAY ADMIN");
		titulo.setEditable(false);
		titulo.setBounds(154, 34, 114, 19);
		contentPane.add(titulo);

		cerrarSesion = new JButton("Cerrar sesión");
		cerrarSesion.setBounds(296, 242, 140, 21);
		contentPane.add(cerrarSesion);

		crearEquipo.addActionListener(this);
		gestionarEntre.addActionListener(this);
		cambiarContra.addActionListener(this);
		crearPartido.addActionListener(this);

		cerrarSesion.addActionListener(this);
		btnLogOut.setBackground(new Color(128, 128, 0));
		btnLogOut.setBounds(57, 536, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);

		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnAddEq = new JButton("Gestionar equipo");
		btnAddEq.addActionListener(this);
		btnAddEq.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddEq.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEq.setFocusable(false);
		btnAddEq.setBorder(null);
		btnAddEq.setBackground(new Color(128, 128, 0));
		btnAddEq.setBounds(57, 466, 200, 49);
		panelLeft.add(btnAddEq);

		lblWelcome = new JLabel("Welcome Admin");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == crearEquipo) {
			CrearEquipo frame = new CrearEquipo(l);
			frame.setVisible(true);
			dispose();
		} else if (o == gestionarEntre) {
			GestionarEntre frame = new GestionarEntre(l);
			frame.setVisible(true);
			dispose();
		} else if (o == cambiarContra) {
			CambiarContra frame = new CambiarContra(l);
			frame.setVisible(true);
			dispose();
		} else if (o == crearPartido) {
			CrearPartido frame = new CrearPartido(l);
			frame.setVisible(true);
			dispose();
		}

		else if (o == cerrarSesion) {
			Login frame = new Login();
			frame.setVisible(true);
			dispose();
		}
		if (e.getSource() == btnLogOut) {
			controller.closeConnection();
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
		}
	}

}
