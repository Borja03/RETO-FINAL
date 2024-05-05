package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class SearchEntrenador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAddEntrenador;
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
	private JComboBox<String> textFieldUSer;
	private JTextField textFieldContrasena;
	private JComboBox<String> textFieldCargo;
	private JButton btnEliminarEntrenador;
	private JComboBox<String> txtEquiponame;
	private JPanel bottomPanel;
	private String user;
	private JButton btnModificarEntrenador;
	private String userType;
	private JButton btnGestionarEntrenador;

	public SearchEntrenador(Controller controller) {
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAddEntrenador = new JButton("Añadir Entrenadores");
		btnAddEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEntrenador.addActionListener(this);
		btnAddEntrenador.setBackground(new Color(240, 240, 240));
		btnAddEntrenador.setFocusable(false);
		btnAddEntrenador.setBorder(null);
		btnAddEntrenador.setBounds(328, 40, 185, 35);
		contentPane.add(btnAddEntrenador);

		btnDeleteMod = new JButton("Eliminar/Modificar Entrenadores");
		btnDeleteMod.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnDeleteMod.setBackground(new Color(220, 3, 9));
		btnDeleteMod.addActionListener(this);
		btnDeleteMod.setFocusable(false);
		btnDeleteMod.setBorder(null);
		btnDeleteMod.setBounds(564, 40, 250, 35);
		contentPane.add(btnDeleteMod);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(242, 45, 45));
		panelLeft.setBounds(0, 0, 250, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(242, 45, 45));
			}
		});
		btnLogOut.setBackground(new Color(242, 45, 45));
		btnLogOut.setBounds(0, 595, 250, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnModPartidos = new JButton("     Modificar partidos");
		btnModPartidos.setForeground(new Color(255, 255, 255));
		btnModPartidos.addActionListener(this);
		btnModPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnModPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModPartidos.setFocusable(false);
		btnModPartidos.setBorder(null);
		btnModPartidos.setBackground(new Color(242, 45, 45));
		btnModPartidos.setBounds(0, 445, 250, 49);
		btnModPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModPartidos.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModPartidos.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnModPartidos.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnModPartidos);

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setBackground(new Color(0, 0, 0));
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(10, 181, 217, 34);
		panelLeft.add(lblWelcome);

		btnGestionarEquipo = new JButton("     Gestionar Equipo");
		btnGestionarEquipo.setForeground(new Color(255, 255, 255));
		btnGestionarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEquipo.setFocusable(false);
		btnGestionarEquipo.setBorder(null);
		btnGestionarEquipo.setBackground(new Color(242, 45, 45));
		btnGestionarEquipo.setBounds(0, 386, 250, 49);
		btnGestionarEquipo.addActionListener(this);
		btnGestionarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestionarEquipo.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnGestionarEquipo);

		btnCrearPartido = new JButton("     Crear partido");
		btnCrearPartido.setForeground(new Color(255, 255, 255));
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(242, 45, 45));
		btnCrearPartido.setBounds(0, 327, 250, 49);


		btnCrearPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnCrearPartido);

		btnGestionarEntrenador = new JButton("     Gestionar entrenadores");
		btnGestionarEntrenador.setForeground(new Color(255, 255, 255));
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(220, 3, 9));
		btnGestionarEntrenador.setBounds(0, 275, 250, 49);
		btnGestionarEntrenador.addActionListener(this);
		btnGestionarEntrenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnGestionarEntrenador);

		JPanel topPanel = new JPanel();
		topPanel.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(128, 0, 64)));
		topPanel.setBounds(310, 85, 676, 154);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEquipo.setBounds(63, 27, 84, 34);
		topPanel.add(lblEquipo);

		txtEquiponame = new JComboBox<String>();
		txtEquiponame.addActionListener(this);
		txtEquiponame.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEquiponame.setBounds(245, 27, 250, 34);
		topPanel.add(txtEquiponame);

		lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(63, 81, 68, 34);
		topPanel.add(lblUser);

		textFieldUSer = new JComboBox<String>();
		textFieldUSer.addActionListener(this);
		textFieldUSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldUSer.setBounds(245, 81, 250, 34);
		topPanel.add(textFieldUSer);

		JLabel lblMsgError = new JLabel("");
		lblMsgError.setBounds(448, 235, 360, 41);
		contentPane.add(lblMsgError);

		bottomPanel = new JPanel();
		bottomPanel.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
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
		textFieldContrasena.setBounds(245, 47, 250, 34);
		bottomPanel.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldCargo = new JComboBox<String>();
		textFieldCargo.setBounds(245, 105, 250, 34);
		textFieldCargo.addItem("Primer_entrenador");
		textFieldCargo.addItem("Segundo_entrenador");
		bottomPanel.add(textFieldCargo);

		btnEliminarEntrenador = new JButton("Eliminar entrenador");
		btnEliminarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarEntrenador.setBounds(442, 308, 200, 35);
		bottomPanel.add(btnEliminarEntrenador);
		btnEliminarEntrenador.addActionListener(this);

		btnModificarEntrenador = new JButton("Modificar Entrenador");
		btnModificarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarEntrenador.setBounds(204, 308, 200, 35);
		btnModificarEntrenador.addActionListener(this);
		bottomPanel.add(btnModificarEntrenador);

		bottomPanel.setVisible(false);

		fillEquiposNames();

	}

	public void fillEquiposNames() {
		ArrayList<String> equiListaBox = new ArrayList<>();
		txtEquiponame.removeAllItems();
		equiListaBox = controller.getEquipos();

		for (String equipo : equiListaBox) {
			txtEquiponame.addItem(equipo);
		}

	}

	public void fillEntrenadoresEquipo(String nombreEquipo) {
		ArrayList<String> entListaBox = new ArrayList<>();
		textFieldUSer.removeAllItems();
		entListaBox.clear();
		String primEntrenador = controller.getPrimEntrenador(nombreEquipo);
		String segEntrenador = controller.getSegEntrenador(nombreEquipo);

		entListaBox = new ArrayList<>(Arrays.asList("", primEntrenador, segEntrenador));

		for (String str : entListaBox) {
			textFieldUSer.addItem(str);
		}
	}

	public void fillUserData(String miUser) {
		Entrenador usr = (Entrenador) controller.getUsuario2(miUser);
		if (usr != null) {
			textFieldUSer.addItem(usr.getUser());
			textFieldContrasena.setText(usr.getContrasenia());
			txtEquiponame.addItem(usr.getNombreEquipo());

			CargoEntrenador cargo = usr.getCargo();

			if (cargo == CargoEntrenador.PRIMER_ENTRENADOR) {
				textFieldCargo.setSelectedItem("Primer_entrenador");
			} else if (cargo == CargoEntrenador.SEGUNDO_ENTRENADOR) {
				textFieldCargo.setSelectedItem("Segundo_entrenador");
			}
		} else {
			System.out.println("El usuario no existe");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnCrearPartido) {
			CrearPartido cPartido = new CrearPartido(controller);
			this.dispose();
			cPartido.setVisible(true);
		} else if (o == btnAddEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			this.dispose();
			gestionarEntre.setVisible(true);

		} else if (o == btnGestionarEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			this.dispose();
			gestionarEntre.setVisible(true);

		} else if (o == btnGestionarEquipo) {
			MenuAdmin cEquipo = new MenuAdmin(controller);
			this.dispose();
			cEquipo.setVisible(true);
		} else if (o == btnLogOut) {
			this.dispose();
			controller.logOut();
		} else if (o == btnModPartidos) {
			ModificarPartido modPartido = new ModificarPartido(controller);
			this.dispose();
			modPartido.setVisible(true);
		} else  if (o == txtEquiponame && e.getActionCommand().equals("comboBoxChanged")) {
	        // User selected a team name
	        if (txtEquiponame.getSelectedItem() != null) {
	            String selectedTeam = (String) txtEquiponame.getSelectedItem();
	            fillEntrenadoresEquipo(selectedTeam); // Update userTextField with team's players
	        }
	    } else if (o == textFieldUSer && e.getActionCommand().equals("comboBoxChanged")) {
	        // User selected a player
	        if (textFieldUSer.getSelectedItem() != null) {
	            String selectedUser = (String) textFieldUSer.getSelectedItem();
	            fillUserData(selectedUser); // Display selected user's information
				bottomPanel.setVisible(true);

	        }
		

		} else if (o == btnEliminarEntrenador) {
			if (controller.borrarEntrenador(textFieldUSer.getSelectedItem().toString())) {
				int opcion = JOptionPane.showConfirmDialog(this,
						"El entrenador ha sido eliminado correctamente\n¿Desea eliminar otro entrenador?", "",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin g1 = new MenuAdmin(controller);
					g1.setVisible(true);
				}
			}
		} else if (o == btnModificarEntrenador) {
			String usr = textFieldUSer.getSelectedItem().toString();
			String password = textFieldContrasena.getText();
			String tipoString = (String) textFieldCargo.getSelectedItem();
			CargoEntrenador tipo = null;
			if (tipoString.equals("Primer_entrenador")) {
				tipo = CargoEntrenador.PRIMER_ENTRENADOR;
			} else if (tipoString.equals("Segundo_entrenador")) {
				tipo = CargoEntrenador.SEGUNDO_ENTRENADOR;
			}

			if (controller.modificarEntrenador(usr, password, tipo)) {
				int opcion = JOptionPane.showConfirmDialog(this, "",
						"El entrenador ha sido modificado correctamente\n¿Desea modificar otro entrenador?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin g1 = new MenuAdmin(controller);
					g1.setVisible(true);
				}
			}
		}
	}

}
