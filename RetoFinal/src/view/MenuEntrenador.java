
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import model.equipos.Equipo;
import model.usuarios.Jugador;

public class MenuEntrenador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogOut;
	private JButton btnConsultarEquipo;
	private JButton btnGestJugadores;
	private JButton btnConsultarPartidos;
	private JButton btnCambiarContrasena;
	private Controller controller;
	private JLabel lblWelcome;
	private String userName;
	private String userType;
	private JTextField txtEqNombre;
	private JTextField txtEqEstadio;
	private JTextField txtEqTitulos;
	private JTextField txtEqPrimerEntre;
	private JTextField txtEqSegundoEntre;
	private JTable table;
	private JScrollPane scrollPane_1;
	private String nombreEquipo;
	private Blob teamLogo;
	private JLabel lblJugadoresLista;
	private JButton[] leftPanelButtons;

	public MenuEntrenador(Controller cont, String entrConnected, String userType) {
		this.controller = cont;
		this.userName = entrConnected;
		this.userType = userType;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(86, 82, 252));
		panelLeft.setBounds(0, 0, 250, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnConsultarEquipo = new JButton("     Consultar Equipo");
		btnConsultarEquipo.setForeground(new Color(255, 255, 255));
		btnConsultarEquipo.addActionListener(this);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(100, 100, 100));
		btnConsultarEquipo.setBounds(0, 395, 250, 49);
		panelLeft.add(btnConsultarEquipo);

		btnGestJugadores = new JButton("     Gestionar  jugadores");
		btnGestJugadores.setForeground(new Color(255, 255, 255));
		btnGestJugadores.addActionListener(this);
		btnGestJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestJugadores.setFocusable(false);
		btnGestJugadores.setBorder(null);
		btnGestJugadores.setBackground(new Color(86, 82, 252));
		btnGestJugadores.setBounds(0, 332, 250, 49);
		panelLeft.add(btnGestJugadores);

		lblWelcome = new JLabel("Welcome " + entrConnected);
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(20, 182, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Consultar Partidos");
		btnConsultarPartidos.setForeground(new Color(255, 255, 255));
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(86, 82, 252));
		btnConsultarPartidos.setBounds(0, 454, 250, 49);
		panelLeft.add(btnConsultarPartidos);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(0, 586, 250, 49);
		panelLeft.add(btnLogOut);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
	
		btnLogOut.setBackground(new Color(86, 82, 252));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarContrasena = new JButton("     Cambiar contraseña");
		btnCambiarContrasena.setForeground(new Color(255, 255, 255));
		btnCambiarContrasena.addActionListener(this);
		btnCambiarContrasena.setBounds(0, 513, 250, 49);
		panelLeft.add(btnCambiarContrasena);
		btnCambiarContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarContrasena.setFocusable(false);
		btnCambiarContrasena.setBorder(null);
		btnCambiarContrasena.setBackground(new Color(86, 82, 252));

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 128, 64));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(260, 0, 718, 178);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(204, 39, 82, 22);
		panel.add(lblNombre);

		JLabel lblNewLabel = new JLabel("Equipo info");
		lblNewLabel.setBounds(286, 10, 104, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);

		JLabel lblEqEstadio = new JLabel("Estadio :");
		lblEqEstadio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEqEstadio.setBounds(204, 67, 82, 22);
		panel.add(lblEqEstadio);

		JLabel lblTitulos = new JLabel("Titulos :");
		lblTitulos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulos.setBounds(204, 93, 82, 22);
		panel.add(lblTitulos);

		JLabel lblPrimerEntrenador = new JLabel("Primer entrenador :");
		lblPrimerEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrimerEntrenador.setBounds(204, 116, 162, 22);
		panel.add(lblPrimerEntrenador);

		JLabel lblSegundoEntrenador = new JLabel("Segundo entrenador :");
		lblSegundoEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSegundoEntrenador.setBounds(204, 145, 162, 22);
		panel.add(lblSegundoEntrenador);

		txtEqNombre = new JTextField();
		txtEqNombre.setBounds(368, 40, 254, 25);
		panel.add(txtEqNombre);
		txtEqNombre.setEditable(false);
		txtEqNombre.setColumns(10);

		txtEqEstadio = new JTextField();
		txtEqEstadio.setColumns(10);
		txtEqEstadio.setBounds(368, 68, 254, 25);
		txtEqEstadio.setEditable(false);
		panel.add(txtEqEstadio);

		txtEqTitulos = new JTextField();
		txtEqTitulos.setColumns(10);
		txtEqTitulos.setBounds(368, 94, 254, 25);
		txtEqTitulos.setEditable(false);
		panel.add(txtEqTitulos);

		txtEqPrimerEntre = new JTextField();
		txtEqPrimerEntre.setColumns(10);
		txtEqPrimerEntre.setBounds(368, 120, 254, 25);
		txtEqPrimerEntre.setEditable(false);
		panel.add(txtEqPrimerEntre);

		txtEqSegundoEntre = new JTextField();
		txtEqSegundoEntre.setEditable(false);
		txtEqSegundoEntre.setColumns(10);
		txtEqSegundoEntre.setBounds(368, 149, 254, 25);
		panel.add(txtEqSegundoEntre);

		JLabel lblEqLogo = new JLabel();

		nombreEquipo = controller.getMyTeam(userName, userType);
		teamLogo = controller.getEquipo(nombreEquipo).getLogo();
		if (teamLogo != null) {
			try {
				byte[] imageData = teamLogo.getBytes(1, (int) teamLogo.length());
				if (imageData != null && imageData.length > 0) {
					ImageIcon icon = new ImageIcon(imageData);
					Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
					ImageIcon scaledIcon = new ImageIcon(image);
					lblEqLogo.setIcon(scaledIcon);
				}
			} catch (SQLException e) {
				System.err.println("Error reading image data from Blob: " + e.getMessage());
				e.printStackTrace();
			}
		}

		lblEqLogo.setBounds(15, 15, 150, 150);
		panel.add(lblEqLogo);

		ArrayList<Jugador> dataList = controller.getJugadoresPorEquipo(nombreEquipo);

		String[] columnNames = { "Nombre", "Dorsal", "Goles" };
		Object[][] data = new Object[dataList.size()][3];

		for (int i = 0; i < dataList.size(); i++) {
			Jugador obj = dataList.get(i);
			data[i][0] = obj.getUser();
			data[i][1] = obj.getDorsal();
			data[i][2] = obj.getAsistencias();
		}

		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(296, 219, 648, 461);
		contentPane.add(scrollPane_1);

		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane_1.setViewportView(scrollPane);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);

		lblJugadoresLista = new JLabel("Jugadores lista :");
		lblJugadoresLista.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblJugadoresLista.setBounds(547, 188, 191, 22);
		contentPane.add(lblJugadoresLista);

		// Crear un array que contenga los botones del panel izquierdo
		// Crear un array que contenga los botones del panel izquierdo
		leftPanelButtons = new JButton[] { btnConsultarEquipo, btnGestJugadores, btnConsultarPartidos,
				btnCambiarContrasena, btnLogOut };

		// Añadir acciones de mouse a cada botón en el array, excepto para "Consultar
		// Equipo"
		for (JButton button : leftPanelButtons) {
			if (button != btnConsultarEquipo) {
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button.setBackground(new Color(100, 100, 100)); // Cambia el color al entrar
					}

					@Override
					public void mouseExited(MouseEvent e) {
						button.setBackground(new Color(86, 82, 252)); // Restaura el color al salir
					}

					@Override
					public void mousePressed(MouseEvent e) {
						button.setBackground(new Color(50, 50, 50)); // Cambia el color al presionar
					}
				});
			}
		}

		fillEquipoInfo();
		fillEntrenadoresInfo();
		this.setVisible(true);
	}

	public void fillEquipoInfo() {
		nombreEquipo = controller.getMyTeam(userName, userType);
		Equipo eq = controller.getEquipo(nombreEquipo);
		txtEqNombre.setText(eq.getNombreEquipo());
		txtEqEstadio.setText(eq.getEstadio());
		txtEqTitulos.setText(eq.getTitulos() + "");
	}

	public void fillEntrenadoresInfo() {
		String primEntrenador = controller.getPrimEntrenador(nombreEquipo);
		String segEntrenador = controller.getSegEntrenador(nombreEquipo);

		txtEqPrimerEntre.setText(primEntrenador);
		txtEqSegundoEntre.setText(segEntrenador);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogOut) {

			this.dispose();
			controller.logOut();

		} else if (e.getSource() == btnGestJugadores) {
			GestionarJugadores g1 = new GestionarJugadores(controller, userName, userType, nombreEquipo);
			g1.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
			consultarPartidos.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnCambiarContrasena) {
			CambiarContra cambiarContra = new CambiarContra(controller, userName, userType);
			cambiarContra.setVisible(true);
			this.dispose();
		}

	}

}
