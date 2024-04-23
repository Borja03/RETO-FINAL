package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JComboBox<String> textFieldCargo;
	private JButton btnEliminarEntrenador;
	private JTextField txtEquiponame;
	private JButton btnBuscarEntrenador;
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

		btnCrear = new JButton("Añadir Entrenadores");
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrear.setBackground(new Color(240, 240, 240));
		btnCrear.setFocusable(false);
		btnCrear.setBorder(null);
		btnCrear.setBounds(328, 40, 176, 35);
		contentPane.add(btnCrear);


		btnDeleteMod = new JButton("Eliminar/Modificar Entrenadores");
		btnDeleteMod.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnDeleteMod.setBackground(new Color(220, 3, 9));
		btnDeleteMod.addActionListener(this);
		btnDeleteMod.setFocusable(false);
		btnDeleteMod.setBorder(null);
		btnDeleteMod.setBounds(564, 40, 261, 35);
		contentPane.add(btnDeleteMod);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(242, 45, 45));
		panelLeft.setBounds(0, 0, 312, 680);
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
		btnLogOut.setBounds(0, 595, 310, 49);
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
		btnModPartidos.setBounds(0, 445, 310, 49);
		btnModPartidos.addActionListener(this);
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

		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(37, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnGestionarEquipo = new JButton("     Gestionar Equipo");
		btnGestionarEquipo.setForeground(new Color(255, 255, 255));
		btnGestionarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEquipo.setFocusable(false);
		btnGestionarEquipo.setBorder(null);
		btnGestionarEquipo.setBackground(new Color(242, 45, 45));
		btnGestionarEquipo.setBounds(0, 386, 310, 49);
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
		btnCrearPartido.setBounds(0, 327, 310, 49);

		btnCrearPartido.addActionListener(this);

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
		btnGestionarEntrenador.setBounds(0, 275, 310, 49);
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
		txtEquiponame.setText("");
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

		btnBuscarEntrenador = new JButton("Buscar Entrenador");
		btnBuscarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarEntrenador.setBounds(467, 81, 200, 35);
		topPanel.add(btnBuscarEntrenador);
		btnBuscarEntrenador.addActionListener(this);

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
		bottomPanel.add(btnModificarEntrenador);
		bottomPanel.setVisible(false);
	}

	public void fillUserData() {
		Entrenador usr = (Entrenador) controller.getUsuario2(textFieldUSer.getText());
		if (usr != null) {
			textFieldUSer.setText(usr.getUser());
			textFieldContrasena.setText(usr.getContrasenia());
			txtEquiponame.setText(usr.getNombreEquipo());

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
		if (e.getSource() == btnCrearPartido) {
			CrearPartido cPartido = new CrearPartido(controller);
			this.dispose();
			cPartido.setVisible(true);
		} else if (e.getSource() == btnGestionarEquipo) {
			//CrearEquipo cEquipo = new CrearEquipo(controller, user, userType);
			//this.dispose();
			//cEquipo.setVisible(true);
		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		} else if (e.getSource() == btnBuscarEntrenador) {
			if (controller.checkUserExist2(textFieldUSer.getText())) {
				fillUserData();
				bottomPanel.setVisible(true);
			}
		} else if (e.getSource() == btnEliminarEntrenador) {
			if (controller.borrarEntrenador(textFieldUSer.getText())) {
				int opcion = JOptionPane.showConfirmDialog(this,
						"El entrenador ha sido eliminado correctamente\n¿Desea eliminar otro entrenador?", "",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);

				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin g1 = new MenuAdmin(controller);
					g1.setVisible(true);
				}
			}
		} else if (e.getSource() == btnModificarEntrenador) {
			String usr = textFieldUSer.getText();
			String password = textFieldContrasena.getText();
			String myTeam = controller.getMyTeam(textFieldUSer.getText(), userType);
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
