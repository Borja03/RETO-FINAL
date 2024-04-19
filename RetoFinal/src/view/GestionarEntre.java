package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.usuarios.CargoEntrenador;
import view.toDelete.ModificarJugadores;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GestionarEntre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCrear;
	private JButton btnDeleteMod;
	private Controller controller;
	private JButton btnLogOut;
	private JButton btnModPartidos;
	private JLabel lblWelcome;
	private JButton btnGestionarEquipo;
	private JButton btnCrearPartido;
	private JLabel lblUser;
	private JLabel lblContrasena;
	private JLabel lblCargo;
	private JTextField textFieldUSer;
	private JTextField textFieldContrasena;
	private JComboBox textFieldCargo;
	private JButton btnAnadir;
	private JTextField txtEquiponame;
	private String miEquipo;
	private String userName;

	public GestionarEntre(Controller controller, String user, String team) {
		this.controller = controller;
		this.userName = user;
		this.miEquipo = team;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCrear = new JButton("Añadir Entrenadores");
		btnCrear.setBounds(328, 40, 176, 35);
		btnCrear.setBackground(new Color(255, 128, 0));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		contentPane.add(btnCrear);

		btnDeleteMod = new JButton("Eliminar/Modificar entrenadores");
		btnDeleteMod.setBounds(564, 40, 176, 35);
		btnDeleteMod.addActionListener(this);
		btnDeleteMod.setFocusable(false);
		btnDeleteMod.setBorder(null);
		contentPane.add(btnDeleteMod);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 300, 680);
		panelLeft.setBackground(new Color(128, 128, 0));
		contentPane.add(panelLeft);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setBounds(37, 595, 200, 49);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.setLayout(null);
		btnLogOut.setBackground(new Color(128, 128, 0));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnModPartidos = new JButton("     Modificar partidos");
		btnModPartidos.setBounds(37, 446, 200, 49);
		btnModPartidos.addActionListener(this);
		btnModPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnModPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModPartidos.setFocusable(false);
		btnModPartidos.setBorder(null);
		btnModPartidos.setBackground(new Color(128, 128, 0));
		panelLeft.add(btnModPartidos);
		btnModPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModPartidos.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModPartidos.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnModPartidos.setBackground(new Color(50, 70, 90));
			}
		});

		lblWelcome = new JLabel("Welcome " + userName + "");
		lblWelcome.setBounds(64, 180, 217, 34);
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLeft.add(lblWelcome);

		btnGestionarEquipo = new JButton("     Gestionar Equipo");
		btnGestionarEquipo.setBounds(37, 386, 200, 49);
		btnGestionarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEquipo.setFocusable(false);
		btnGestionarEquipo.setBorder(null);
		btnGestionarEquipo.setBackground(new Color(128, 128, 0));
		btnGestionarEquipo.addActionListener(this);
		btnGestionarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnGestionarEquipo);

		btnCrearPartido = new JButton("     Crear partido");
		btnCrearPartido.setBounds(37, 327, 200, 49);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(128, 128, 0));
		btnCrearPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnCrearPartido);

		JButton btnGestionarEntrenador = new JButton("     Gestionar entrenadores");
		btnGestionarEntrenador.setBounds(37, 275, 200, 49);
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(255, 128, 64));
		panelLeft.add(btnGestionarEntrenador);
		// formulario
		lblUser = new JLabel("Usuario");
		lblUser.setBounds(350, 207, 90, 35);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblUser);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(350, 267, 90, 35);
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblContrasena);

		lblCargo = new JLabel("Cargo entrenador");
		lblCargo.setBounds(350, 332, 90, 35);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblCargo);

		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(515, 208, 250, 34);
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(515, 274, 250, 34);
		textFieldContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldCargo = new JComboBox<String>();
		textFieldCargo.setBounds(250, 187, 225, 22);
		textFieldCargo.addItem( "");
		textFieldCargo.addItem( "Primer_entrenador");
		textFieldCargo.addItem( "Segundo_entrenador");

		contentPane.add(textFieldCargo);
		
		btnAnadir = new JButton("Añadir enrtenador");
		btnAnadir.setBounds(751, 562, 200, 35);
		btnAnadir.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnAnadir);

		txtEquiponame = new JTextField();
		txtEquiponame.setBounds(515, 148, 250, 34);
		txtEquiponame.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEquiponame.setColumns(10);
		txtEquiponame.setText(miEquipo);
		txtEquiponame.setEditable(false);
		contentPane.add(txtEquiponame);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(350, 150, 90, 35);
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblEquipo);
		btnAnadir.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnDeleteMod) {
			SearchJugadore eliminarJugadores = new SearchJugadore(controller, userName, miEquipo);
			this.dispose();
			eliminarJugadores.setVisible(true);
		} else if (e.getSource() == btnCrearPartido) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName);
			this.dispose();
			menuEntrenador.setVisible(true);
		} else if (e.getSource() == btnGestionarEquipo) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName);
			this.dispose();
			consultarPartidos.setVisible(true);
		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		}

		if (e.getSource() == btnAnadir) {
			String user = textFieldUSer.getText();
			String password = textFieldContrasena.getText();
			String myTeam = txtEquiponame.getText();
			String tipoString = (String) textFieldCargo.getSelectedItem();
			CargoEntrenador tipo = null;
			if (tipoString.equals("Primer_entrenador")) {
				tipo = CargoEntrenador.PRIMER_ENTRENADOR;
			} else if (tipoString.equals("Segundo_entrenador")) {
				tipo = CargoEntrenador.SEGUNDO_ENTRENADOR;
			}

			// Object o = e.getSource();
			if (controller.crearEntrenador(user, password, myTeam, tipo)) {
				int opcion = JOptionPane.showConfirmDialog(this, (String) "",
						"El jugador ha sido introducido correctamente\n¿Desea añadir otro jugador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//				textFieldUSer.setText("");
//				textFieldContrasena.setText("");
//				textFieldGoles.setText("");
//				textFieldAsist.setText("");
				GestionarJugadores gestionarJugadores = new GestionarJugadores(controller, user, miEquipo);
				this.dispose();
				gestionarJugadores.setVisible(true);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin g1 = new MenuAdmin(controller);
					g1.setVisible(true);
				}
			}
		}

	}
}
