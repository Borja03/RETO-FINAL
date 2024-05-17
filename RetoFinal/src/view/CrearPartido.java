package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import controller.Controller;
import model.equipos.Equipo;

/**
 * The CrearPartido class represents a JFrame for creating football (soccer)
 * matches. It allows administrators to schedule matches by selecting the local
 * and visiting teams, specifying the stadium, date, and time for the match.
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
class CrearPartido extends JFrame implements ActionListener {
	/**
	 * Unique identifier for serializing the class.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogOut;
	private JButton btnGestEquipo;
	private JLabel lblWelcome;
	private Controller controller;
	private JButton btnGestionarEntrenador;
	private JButton btnCrearPartido;
	private JComboBox<String> equipoLocalComboBox;
	private JComboBox<String> equipoVisitanteComboBox;
	private JTextField estadioField;
	private JCalendar datePicker;
	private JSpinner timeSpinner;
	private HashMap<String, String> estadiosEquipos = new HashMap<>();
	private ArrayList<String> equiposDisponibles = new ArrayList<>();
	private JButton okButton;
	private JButton btnModificarPartido; // Botón Modificar partido
	private String user;
	private String userType;

	/**
	 * Constructs a new CrearPartido JFrame.
	 * 
	 * @param cont The Controller instance for handling business logic.
	 */
	public CrearPartido(Controller cont) {
		this.controller = cont;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 250, 680);
		panelLeft.setBackground(new Color(242, 45, 45));
		getContentPane().add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("   Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setBackground(new Color(242, 45, 45));
		btnLogOut.setBounds(0, 595, 250, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
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

		btnGestEquipo = new JButton("     Gestionar equipo");
		btnGestEquipo.setForeground(new Color(255, 255, 255));
		btnGestEquipo.addActionListener(this);
		btnGestEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestEquipo.setFocusable(false);
		btnGestEquipo.setBorder(null);
		btnGestEquipo.setBackground(new Color(242, 45, 45));
		btnGestEquipo.setBounds(0, 386, 250, 49);
		panelLeft.add(btnGestEquipo);
		btnGestEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestEquipo.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestEquipo.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestEquipo.setBackground(new Color(242, 45, 45));
			}
		});

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(10, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnGestionarEntrenador = new JButton("     Gestionar entrenador");
		btnGestionarEntrenador.setForeground(new Color(255, 255, 255));
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
		btnGestionarEntrenador.setBounds(0, 275, 250, 49);
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

		btnCrearPartido = new JButton("     Crear partido");
		btnCrearPartido.setForeground(new Color(255, 255, 255));
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(220, 3, 9));
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

		// Botón Modificar partido
		btnModificarPartido = new JButton("     Modificar partido");
		btnModificarPartido.setForeground(new Color(255, 255, 255));
		btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPartido.setFocusable(false);
		btnModificarPartido.setBorder(null);
		btnModificarPartido.setBackground(new Color(242, 45, 45));
		btnModificarPartido.setBounds(0, 445, 250, 49);
		btnModificarPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(242, 45, 45));
			}
		});
		panelLeft.add(btnModificarPartido);
		btnModificarPartido.addActionListener(this); // Agregar ActionListener

		btnCrearPartido.addActionListener(this);

		// Agregar acción al botón de gestionar entrenador
		btnGestionarEntrenador.addActionListener(this);

		// Configuración del timeSpinner
		timeSpinner = new JSpinner(new SpinnerDateModel());
		timeSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setBounds(532, 514, 100, 34);
		getContentPane().add(timeSpinner);

		// Etiqueta para "Equipo Local"
		JLabel lblNewLabel = new JLabel("Equipo Local:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(380, 94, 100, 34);
		getContentPane().add(lblNewLabel);

		// ComboBox para seleccionar el equipo local
		equipoLocalComboBox = new JComboBox<>();
		equipoLocalComboBox.addActionListener(this);
		equipoLocalComboBox.setBounds(532, 96, 250, 34);
		getContentPane().add(equipoLocalComboBox);

		// Etiqueta para "Equipo Visitante"
		JLabel lblNewLabel_1 = new JLabel("Equipo Visitante:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(380, 154, 135, 34);
		getContentPane().add(lblNewLabel_1);

		// ComboBox para seleccionar el equipo visitante
		equipoVisitanteComboBox = new JComboBox<>();
		equipoVisitanteComboBox.setBounds(532, 156, 250, 34);
		getContentPane().add(equipoVisitanteComboBox);

		// Etiqueta para "Estadio"
		JLabel lblNewLabel_2 = new JLabel("Estadio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(380, 198, 100, 34);
		getContentPane().add(lblNewLabel_2);

		// Campo de texto para mostrar el estadio seleccionado
		estadioField = new JTextField();
		estadioField.setEditable(false);
		estadioField.setBounds(532, 198, 250, 34);
		getContentPane().add(estadioField);

		// Etiqueta para "Fecha"
		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(380, 241, 100, 34);
		getContentPane().add(lblNewLabel_3);

		// Calendario para seleccionar la fecha del partido
		datePicker = new JCalendar();
		datePicker.getYearChooser().getSpinner().setFont(new Font("Tahoma", Font.BOLD, 14));
		datePicker.getMonthChooser().getComboBox().setFont(new Font("Tahoma", Font.BOLD, 14));
		datePicker.setBounds(532, 273, 400, 200);
		getContentPane().add(datePicker);

		// Botón para confirmar la creación del partido
		okButton = new JButton("Añadir Partido");
		okButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		okButton.setBounds(815, 603, 150, 34);
		getContentPane().add(okButton);

		JLabel lblNewLabel_3_1 = new JLabel("Fecha:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(380, 511, 100, 34);
		contentPane.add(lblNewLabel_3_1);

		llenarComboBoxEquipos();

		okButton.addActionListener(this);
	}

	/**
	 * Fills the team combo boxes with available teams.
	 */
	private void llenarComboBoxEquipos() {
		ArrayList<Equipo> equipos = controller.listarEquiposCP();
		equipoVisitanteComboBox.addItem("");

		for (Equipo equipo : equipos) {
			equipoLocalComboBox.addItem(equipo.getNombreEquipo());
			equipoVisitanteComboBox.addItem(equipo.getNombreEquipo());
			estadiosEquipos.put(equipo.getNombreEquipo(), equipo.getEstadio());
			equiposDisponibles.add(equipo.getNombreEquipo());
		}

		if (equipoVisitanteComboBox.getItemCount() > 1) {
			equipoVisitanteComboBox.removeItemAt(0);
		}
	}

	@SuppressWarnings("deprecation")
	/**
	 * ActionListener implementation method. Handles various button clicks and
	 * actions.
	 * 
	 * @param e The ActionEvent that occurred.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		MenuAdmin menuAdmin = new MenuAdmin(controller);

		if (o == btnCrearPartido) {
			CrearPartido frame = new CrearPartido(controller);
			frame.setVisible(true);
			// dispose();
		} else if (o == okButton) {
			String equipoLocal = (String) equipoLocalComboBox.getSelectedItem();
			String equipoVisitante = (String) equipoVisitanteComboBox.getSelectedItem();

			Timestamp fechaInicio = new Timestamp(datePicker.getDate().getTime());
			java.util.Date horaSeleccionada = (java.util.Date) timeSpinner.getValue();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(horaSeleccionada);
			Timestamp horaInicio = new Timestamp(horaSeleccionada.getTime());

			if (equipoLocal != null && equipoVisitante != null && fechaInicio != null && horaInicio != null) {
				fechaInicio.setHours(calendar.get(Calendar.HOUR_OF_DAY));
				fechaInicio.setMinutes(calendar.get(Calendar.MINUTE));

				boolean partidoCreado = controller.crearPartido(equipoLocal, equipoVisitante, fechaInicio);
				if (partidoCreado) {
					JOptionPane.showMessageDialog(this, "Partido creado exitosamente.");
					// Volver al menú admin
					menuAdmin.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Error al crear el partido.");
				}
			} else {
				if (estadioField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Por favor, complete el campo del estadio.");
				} else {
					JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
				}
			}
		} else if (o == equipoLocalComboBox) {
			String nombreEquipoLocal = (String) equipoLocalComboBox.getSelectedItem();
			String estadioEquipoLocal = estadiosEquipos.get(nombreEquipoLocal);
			estadioField.setText(estadioEquipoLocal);
			equipoVisitanteComboBox.removeAllItems();
			for (String equipo : equiposDisponibles) {
				if (!equipo.equals(nombreEquipoLocal)) {
					equipoVisitanteComboBox.addItem(equipo);
				}
			}
		} else if (o == btnModificarPartido) { // Acción para el botón Modificar partido
			ModificarPartido frame = new ModificarPartido(controller);
			frame.setVisible(true);
			this.dispose();
		} else if (o == btnGestionarEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			gestionarEntre.setVisible(true);
			this.dispose();
		} else if (o == btnGestEquipo) {
			MenuAdmin menAdmin = new MenuAdmin(controller);
			menuAdmin.setVisible(true);
			this.dispose();
		} else if (o == btnModificarPartido) {
			ModificarPartido modificarPartido = new ModificarPartido(controller);
			menuAdmin.setVisible(true);
			this.dispose();
		} else if (o == btnLogOut) {
			Login frame = new Login(controller);
			frame.setVisible(true);
			this.dispose();
		}
	}
}