
package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.usuarios.CargoEntrenador;
import model.usuarios.Entrenador;
import model.usuarios.Jugador;
import view.toDelete.ModificarJugadores;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class SearchEntrenador extends JFrame implements ActionListener {

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
	private JButton btnElimimarEntrenador;
	private JTextField txtEquiponame;
	private String miEquipo;
	private String userName;
	private JButton btnBuscarJugador;
	private JPanel bottomPanel;

	public SearchEntrenador(Controller controller, String user, String team) {
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
		btnCrear.setBackground(new Color(240, 240, 240));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		btnCrear.setBounds(328, 40, 176, 35);
		contentPane.add(btnCrear);

		btnDeleteMod = new JButton("Eliminar/Modificar Jugadores");
		btnDeleteMod.setBackground(new Color(255, 128, 0));
		btnDeleteMod.addActionListener(this);
		btnDeleteMod.setFocusable(false);
		btnDeleteMod.setBorder(null);
		btnDeleteMod.setBounds(564, 40, 176, 35);
		contentPane.add(btnDeleteMod);

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

		btnModPartidos = new JButton("     Modificar partidos");
		btnModPartidos.addActionListener(this);
		btnModPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnModPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModPartidos.setFocusable(false);
		btnModPartidos.setBorder(null);
		btnModPartidos.setBackground(new Color(128, 128, 0));
		btnModPartidos.setBounds(37, 445, 200, 49);
		btnModPartidos.addActionListener(this);
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
		panelLeft.add(btnModPartidos);

		lblWelcome = new JLabel("Welcome " + userName + "");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnGestionarEquipo = new JButton("     Gestionar Equipo");
		btnGestionarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEquipo.setFocusable(false);
		btnGestionarEquipo.setBorder(null);
		btnGestionarEquipo.setBackground(new Color(128, 128, 0));
		btnGestionarEquipo.setBounds(37, 386, 200, 49);
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
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(128, 128, 0));
		btnCrearPartido.setBounds(37, 327, 200, 49);
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
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(255, 128, 64));
		btnGestionarEntrenador.setBounds(37, 275, 200, 49);
		panelLeft.add(btnGestionarEntrenador);
	
		
		// formulario
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(310, 85, 676, 154);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEquipo.setBounds(63, 42, 49, 17);
		topPanel.add(lblEquipo);
		
		txtEquiponame = new JTextField();
		txtEquiponame.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEquiponame.setBounds(181, 39, 146, 23);
		txtEquiponame.setColumns(10);
		txtEquiponame.setText(miEquipo);
		txtEquiponame.setEditable(false);
		topPanel.add(txtEquiponame);
		
		lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(63, 85, 55, 17);
		topPanel.add(lblUser);
		
		textFieldUSer = new JTextField();
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldUSer.setBounds(181, 82, 146, 23);
		topPanel.add(textFieldUSer);
		textFieldUSer.setColumns(10);
		
		btnBuscarJugador = new JButton("Buscar Entrenador");
		btnBuscarJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarJugador.setBounds(467, 81, 200, 35);
		topPanel.add(btnBuscarJugador);
		btnBuscarJugador.addActionListener(this);

		
		JLabel lblMsgError = new JLabel("");
		lblMsgError.setBounds(448, 235, 360, 41);
		contentPane.add(lblMsgError);
		
		bottomPanel = new JPanel();
		bottomPanel.setBounds(310, 253, 674, 417);
		contentPane.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasena.setBounds(80, 46, 90, 35);
		bottomPanel.add(lblContrasena);

		lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(80, 105, 90, 34);
		bottomPanel.add(lblCargo);

		

		textFieldContrasena = new JTextField();
		textFieldContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldContrasena.setBounds(245, 53, 250, 34);
		bottomPanel.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

	
		
		textFieldCargo = new JComboBox<String>();
		textFieldCargo.setBounds(245, 105, 250, 34);
		textFieldCargo.addItem( "");
		textFieldCargo.addItem( "Primer_entrenador");
		textFieldCargo.addItem( "Segundo_entrenador");

		bottomPanel.add(textFieldCargo);

		btnElimimarEntrenador = new JButton("Eliminar entrenador");
		btnElimimarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnElimimarEntrenador.setBounds(442, 308, 200, 35);
		bottomPanel.add(btnElimimarEntrenador);

	
		
		JButton btnModificarEntrenador = new JButton("Modificar Entrenador");
		btnModificarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarEntrenador.setBounds(204, 308, 200, 35);
		bottomPanel.add(btnModificarEntrenador);
		bottomPanel.setVisible(false);
		
	
	}
	
	public void fillUserData() {
		Entrenador usr = (Entrenador) controller.getUsuario2(userName);
		if (usr != null) {
			textFieldUSer.setText(usr.getUser());
			textFieldContrasena.setText(usr.getContrasenia());
		} else {
			System.out.println("El usuario no existe");
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

	 if (e.getSource() == btnCrearPartido) {
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
		
		else if(e.getSource() == btnBuscarJugador) {
			if(controller.checkUserExist(textFieldUSer.getText())) {
				fillUserData();
				bottomPanel.setVisible(true);
				
			}

		}

	 
		if (e.getSource() == btnDeleteMod) {
			//EliminarJugadores e1 = new EliminarJugadores(controller, userName);
		//	e1.setVisible(true);
		//	this.dispose();
		}
		
		
		if (e.getSource() == btnElimimarEntrenador) {
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
						"El entrenador ha sido introducido correctamente\n¿Desea añadir otro entrenador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//						textFieldUSer.setText("");
//						textFieldContrasena.setText("");
//						textFieldGoles.setText("");
//						textFieldAsist.setText("");
				MenuAdmin gestionarJugadores = new MenuAdmin(controller);
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
