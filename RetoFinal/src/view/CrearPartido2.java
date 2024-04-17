package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

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

class CrearPartido2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogOut;
	private JButton btnAddEq;
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

	public CrearPartido2(Controller cont) {
		this.controller = cont;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 329, 680);
		panelLeft.setBackground(new Color(128, 128, 0));
		getContentPane().add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setBackground(new Color(128, 128, 0));
		btnLogOut.setBounds(57, 550, 200, 49);
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
		btnAddEq.setBounds(57, 370, 200, 49);
		panelLeft.add(btnAddEq);

		lblWelcome = new JLabel("Welcome Admin");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnGestionarEntrenador = new JButton("Gestionar entrenador");
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(128, 128, 0));
		btnGestionarEntrenador.setBounds(57, 250, 200, 49);
		panelLeft.add(btnGestionarEntrenador);

		btnCrearPartido = new JButton("Crear partido");
		btnCrearPartido.setEnabled(false);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(79, 79, 0));
		btnCrearPartido.setBounds(57, 310, 200, 49);
		panelLeft.add(btnCrearPartido);

		// Botón Modificar partido
		btnModificarPartido = new JButton("Modificar partido");
		btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPartido.setFocusable(false);
		btnModificarPartido.setBorder(null);
		btnModificarPartido.setBackground(new Color(128, 128, 0));
		btnModificarPartido.setBounds(57, 430, 200, 49);
		panelLeft.add(btnModificarPartido);
		btnModificarPartido.addActionListener(this); // Agregar ActionListener

		btnCrearPartido.addActionListener(this);
		btnCrearPartido.addActionListener(this);

		// Agregar acción al botón de gestionar entrenador
		btnGestionarEntrenador.addActionListener(this);

		// Configuración del timeSpinner
		timeSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setBounds(529, 199, 80, 20);
		getContentPane().add(timeSpinner);

		// Etiqueta para "Equipo Local"
		JLabel lblNewLabel = new JLabel("Equipo Local:");
		lblNewLabel.setBounds(516, 31, 100, 14);
		getContentPane().add(lblNewLabel);

		// ComboBox para seleccionar el equipo local
		equipoLocalComboBox = new JComboBox<>();
		equipoLocalComboBox.addActionListener(this);
		equipoLocalComboBox.setBounds(626, 28, 266, 20);
		getContentPane().add(equipoLocalComboBox);

		// Etiqueta para "Equipo Visitante"
		JLabel lblNewLabel_1 = new JLabel("Equipo Visitante:");
		lblNewLabel_1.setBounds(516, 73, 100, 14);
		getContentPane().add(lblNewLabel_1);

		// ComboBox para seleccionar el equipo visitante
		equipoVisitanteComboBox = new JComboBox<>();
		equipoVisitanteComboBox.setBounds(626, 70, 266, 20);
		getContentPane().add(equipoVisitanteComboBox);

		// Etiqueta para "Estadio"
		JLabel lblNewLabel_2 = new JLabel("Estadio:");
		lblNewLabel_2.setBounds(516, 115, 100, 14);
		getContentPane().add(lblNewLabel_2);

		// Campo de texto para mostrar el estadio seleccionado
		estadioField = new JTextField();
		estadioField.setEditable(false);
		estadioField.setBounds(626, 112, 266, 20);
		getContentPane().add(estadioField);

		// Etiqueta para "Fecha"
		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setBounds(516, 157, 100, 14);
		getContentPane().add(lblNewLabel_3);

		// Calendario para seleccionar la fecha del partido
		datePicker = new JCalendar();
		datePicker.setBounds(626, 154, 200, 150);
		getContentPane().add(datePicker);

		// Botón para confirmar la creación del partido
		okButton = new JButton("OK");
		okButton.setBounds(847, 232, 66, 21);
		getContentPane().add(okButton);

		llenarComboBoxEquipos();

		okButton.addActionListener(this);
	}

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
			Timestamp horaInicio = new Timestamp(horaSeleccionada.getTime());

			if (equipoLocal != null && equipoVisitante != null && fechaInicio != null && horaInicio != null) {
				fechaInicio.setHours(horaInicio.getHours());
				fechaInicio.setMinutes(horaInicio.getMinutes());
				fechaInicio.setSeconds(horaInicio.getSeconds());

				boolean partidoCreado = controller.crearPartido(equipoLocal, equipoVisitante, fechaInicio);
				if (partidoCreado) {
					JOptionPane.showMessageDialog(this, "Partido creado exitosamente.");
					// Volver al menú admin
					menuAdmin.setVisible(true);
					// dispose();
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
		} else if (o == btnAddEq) {
			menuAdmin.mostrarBotonesEquipos();
			menuAdmin.ocultarBotonesEntrenadores();
			menuAdmin.setVisible(true);
			this.dispose();
		} else if (o == btnGestionarEntrenador) {
			menuAdmin.mostrarBotonesEntrenadores();
			menuAdmin.ocultarBotonesEquipos();
			menuAdmin.setVisible(true);
			this.dispose();
		} else if (o == btnModificarPartido) { // Acción para el botón Modificar partido
			ModificarPartido frame = new ModificarPartido(controller);
			frame.setVisible(true);
			this.dispose();
		} else if (o == btnLogOut) {
			Login frame = new Login(controller);
			frame.setVisible(true);
			this.dispose();
		}
	}
}