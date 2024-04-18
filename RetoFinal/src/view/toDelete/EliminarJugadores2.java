
package view.toDelete;

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
import model.usuarios.Jugador;
import view.CambiarDorsal;
import view.ConsultarPartidos;
import view.GestionarJugadores;
import view.MenuEntrenador;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class EliminarJugadores2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCrear;
	private JButton btnDelete;
	private JButton btnModificar;
	private Controller controller;
	private JButton btnLogOut;
	private JButton btnCambiarCont;
	private JButton btnCambiarDorsal;
	private JLabel lblWelcome;
	private JButton btnConsultarPartidos;
	private JButton btnConsultarEquipo;
	private JLabel lblUser;
	private JLabel lblContrasena;
	private JLabel lblDorsal;
	private JLabel lblGoles;
	private JLabel lblAsistencias;
	private JTextField textFieldUSer;
	private JTextField textFieldContrasena;
	private JComboBox<Integer> textFieldDorsal;
	private JTextField textFieldGoles;
	private JTextField textFieldAsist;
	private JButton btnOK;
	private JTextField txtEquiponame;
	private String miEquipo;
	private String userName;

	public EliminarJugadores2(Controller controller, String user, String team) {
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

		btnCrear = new JButton("Añadir Jugadores");
		btnCrear.setBackground(new Color(240, 240, 240));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		btnCrear.setBounds(328, 40, 176, 35);
		contentPane.add(btnCrear);

		btnDelete = new JButton("Eliminar Jugadores");
		btnDelete.setBackground(new Color(255, 128, 0));
		btnDelete.addActionListener(this);
		btnDelete.setFocusable(false);
		btnDelete.setBorder(null);
		btnDelete.setBounds(564, 40, 176, 35);
		contentPane.add(btnDelete);

		btnModificar = new JButton("Modificar Jugadores");
		btnModificar.setBounds(787, 40, 176, 35);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(null);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(this);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(128, 128, 0));
		panelLeft.setBounds(0, 0, 300, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("     Log Out");
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
		btnLogOut.setBackground(new Color(128, 128, 0));
		btnLogOut.setBounds(37, 595, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarCont = new JButton("     Cambiar Contraseña");
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(128, 128, 0));
		btnCambiarCont.setBounds(37, 504, 200, 49);
		panelLeft.add(btnCambiarCont);
		btnCambiarCont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(50, 70, 90));
			}
		});

		btnCambiarDorsal = new JButton("     Cambiar Dorsal");
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal.setFocusable(false);
		btnCambiarDorsal.setBorder(null);
		btnCambiarDorsal.setBackground(new Color(128, 128, 0));
		btnCambiarDorsal.setBounds(37, 445, 200, 49);
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnCambiarDorsal);

		lblWelcome = new JLabel("Welcome " + userName + "");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Consultar Partidos");
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(128, 128, 0));
		btnConsultarPartidos.setBounds(37, 386, 200, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnConsultarPartidos);

		btnConsultarEquipo = new JButton("    Consultar Equipo");
		btnConsultarEquipo.addActionListener(this);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(128, 128, 0));
		btnConsultarEquipo.setBounds(37, 327, 200, 49);
		btnConsultarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnConsultarEquipo);

		JButton btnGestionarJugadores = new JButton("     Gestionar jugadores");
		btnGestionarJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarJugadores.setFocusable(false);
		btnGestionarJugadores.setBorder(null);
		btnGestionarJugadores.setBackground(new Color(255, 128, 64));
		btnGestionarJugadores.setBounds(37, 275, 200, 49);
		panelLeft.add(btnGestionarJugadores);
		// formulario
		lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(350, 207, 90, 35);
		contentPane.add(lblUser);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasena.setBounds(350, 267, 90, 35);
		contentPane.add(lblContrasena);

		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDorsal.setBounds(350, 332, 90, 35);
		contentPane.add(lblDorsal);

		lblGoles = new JLabel("Goles");
		lblGoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGoles.setBounds(350, 399, 90, 35);
		contentPane.add(lblGoles);

		lblAsistencias = new JLabel("Asistencias");
		lblAsistencias.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsistencias.setBounds(350, 460, 90, 35);
		contentPane.add(lblAsistencias);

		textFieldUSer = new JTextField();
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldUSer.setBounds(515, 208, 250, 34);
		contentPane.add(textFieldUSer);
		textFieldUSer.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldContrasena.setBounds(515, 274, 250, 34);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldDorsal = new JComboBox<>();
		textFieldDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDorsal.setBounds(515, 333, 250, 34);
		fillDorsalBox();
		contentPane.add(textFieldDorsal);

		textFieldGoles = new JTextField();
		textFieldGoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldGoles.setBounds(515, 399, 250, 35);
		contentPane.add(textFieldGoles);
		textFieldGoles.setColumns(10);

		textFieldAsist = new JTextField();
		textFieldAsist.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldAsist.setBounds(515, 460, 250, 35);
		contentPane.add(textFieldAsist);
		textFieldAsist.setColumns(10);

		btnOK = new JButton("Eliminar jugador");
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOK.setBounds(751, 562, 176, 35);
		contentPane.add(btnOK);

		txtEquiponame = new JTextField();
		txtEquiponame.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEquiponame.setBounds(515, 148, 250, 34);
		txtEquiponame.setColumns(10);
		txtEquiponame.setText(miEquipo);
		txtEquiponame.setEditable(false);
		contentPane.add(txtEquiponame);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEquipo.setBounds(350, 150, 90, 35);
		contentPane.add(lblEquipo);
		
		JButton btnModificarJugador = new JButton("Modificar jugador");
		btnModificarJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarJugador.setBounds(564, 562, 169, 35);
		contentPane.add(btnModificarJugador);
		btnOK.addActionListener(this);

		jugadorOldInfo();
	}
	
	public void jugadorOldInfo() {
		Jugador usr =(Jugador) controller.getUsuario(userName);
		textFieldUSer.setText(usr.getUser());
		textFieldContrasena.setText(usr.getContrasenia());
		fillDorsalBox();
	//	textFieldDorsal.setText(usr.getDorsal()+"");
		textFieldGoles.setText(usr.getGoles()+"");
		textFieldAsist.setText(usr.getAsistencias()+"");
	}

	public void fillDorsalBox() {

		for (int i = 1; i <= 25; i++) {
			if (!controller.getUsedDorsal(miEquipo).contains(i)) {
				textFieldDorsal.addItem(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnDelete) {
			//EliminarJugadores e1 = new EliminarJugadores(controller, userName);
		//	e1.setVisible(true);
		//	this.dispose();
		} else if (e.getSource() == btnModificar) {
			ModificarJugadores m1 = new ModificarJugadores(controller);
			m1.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName);
			this.dispose();
			menuEntrenador.setVisible(true);
		} else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName);
			this.dispose();
			consultarPartidos.setVisible(true);
		} else if (e.getSource() == btnCambiarDorsal) {
			CambiarDorsal cambiarDorsal = new CambiarDorsal(controller, userName);
			this.dispose();
			cambiarDorsal.setVisible(true);

		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		}

		if (e.getSource() == btnOK) {
			String user = textFieldUSer.getText();
			String password = textFieldContrasena.getText();
			String myTeam = txtEquiponame.getText();
			int dorsal = (int) textFieldDorsal.getSelectedItem();
			int numGoles = Integer.valueOf(textFieldGoles.getText());
			int numAsist = Integer.valueOf(textFieldAsist.getText());

			// Object o = e.getSource();
			if (controller.crearJugador(user, password, dorsal, numGoles, numAsist, myTeam)) {
				int opcion = JOptionPane.showConfirmDialog(this, (String) " opopop",
						"El jugador ha sido introducido correctamente\n¿Desea añadir otro jugador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//						textFieldUSer.setText("");
//						textFieldContrasena.setText("");
//						textFieldGoles.setText("");
//						textFieldAsist.setText("");
				GestionarJugadores gestionarJugadores = new GestionarJugadores(controller, user, miEquipo);
				this.dispose();
				gestionarJugadores.setVisible(true);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					GestionarJugadores g1 = new GestionarJugadores(controller, user, myTeam);
					g1.setVisible(true);
				}
			}
		}

	}
}