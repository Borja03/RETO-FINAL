package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import controller.Controller;
import model.equipos.Equipo;

public class ModificarPartido extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel equipoLocalLabel;
	private JLabel equipoVisitanteLabel;
	private JComboBox<String> equipoLocalComboBox;
	private JComboBox<String> equipoVisitanteComboBox;
	private JTextField estadioField;
	private JCalendar datePicker;
	private JSpinner timeSpinner;
	private Controller controller;
	private HashMap<String, String> estadiosEquipos = new HashMap<>();
	private ArrayList<String> equiposDisponibles = new ArrayList<>();
	private JButton okButton;
	private JTextField resultado1;
	private JTextField resultado2;
	private JComboBox<String> partidosComboBox;
	private JButton editarPartidoButton;
	private boolean mostrarComponentes = false;
	private JLabel lblResultado1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel label;

	private JLabel lblWelcome;
	private JButton btnLogOut;
	private JButton btnGesEquipo;
	private JButton btnGestionarEntrenador;
	private JButton btnCrearPartido;
	private JButton btnModificarPartido;
	private JPanel panelLeft;
	private JPanel panelRight;
	private String user;
	private String userType;

	
	public ModificarPartido(Controller controlador) {
		this.controller = controlador;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblResultado1 = new JLabel("Resultado:");
		lblResultado1.setBounds(348, 157, 100, 20);
		contentPane.add(lblResultado1);

		resultado1 = new JTextField();
		resultado1.setBounds(538, 158, 30, 20);
		contentPane.add(resultado1);

		label = new JLabel("-");
		label.setBounds(588, 157, 10, 20);
		contentPane.add(label);

		resultado2 = new JTextField();
		resultado2.setBounds(608, 158, 30, 20);
		contentPane.add(resultado2);

		lblNewLabel = new JLabel("Equipo Local:");
		lblNewLabel.setBounds(348, 31, 100, 14);
		contentPane.add(lblNewLabel);

		equipoLocalLabel = new JLabel();
		equipoLocalLabel.setBounds(458, 31, 266, 20);
		contentPane.add(equipoLocalLabel);

		lblNewLabel_1 = new JLabel("Equipo Visitante:");
		lblNewLabel_1.setBounds(348, 63, 100, 14);
		contentPane.add(lblNewLabel_1);

		equipoVisitanteLabel = new JLabel();
		equipoVisitanteLabel.setBounds(458, 61, 266, 20);
		contentPane.add(equipoVisitanteLabel);

		lblNewLabel_2 = new JLabel("Estadio:");
		lblNewLabel_2.setBounds(348, 115, 100, 14);
		contentPane.add(lblNewLabel_2);

		estadioField = new JTextField();
		estadioField.setBounds(458, 113, 266, 20);
		estadioField.setEditable(false);
		contentPane.add(estadioField);
		estadioField.setColumns(10);

		lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setBounds(348, 199, 100, 14);
		contentPane.add(lblNewLabel_3);

		datePicker = new JCalendar();
		datePicker.setBounds(500, 196, 200, 150);
		contentPane.add(datePicker);

		lblNewLabel_4 = new JLabel("Hora:");
		lblNewLabel_4.setBounds(348, 358, 46, 14);
		contentPane.add(lblNewLabel_4);

		timeSpinner = new JSpinner(new SpinnerDateModel());
		timeSpinner.setBounds(500, 355, 80, 20);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		contentPane.add(timeSpinner);

		partidosComboBox = new JComboBox<>();
		partidosComboBox.setBounds(524, 239, 200, 20);
		contentPane.add(partidosComboBox);

		okButton = new JButton("OK");
		okButton.setBounds(758, 499, 66, 21);
		contentPane.add(okButton);
		okButton.setVisible(false);

		editarPartidoButton = new JButton("Editar este partido");
		editarPartidoButton.setBounds(524, 287, 200, 30);
		editarPartidoButton.addActionListener(this);
		contentPane.add(editarPartidoButton);

		panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 329, 680);
		panelLeft.setBackground(new Color(128, 128, 0));
		getContentPane().add(panelLeft);
		panelLeft.setLayout(null);

		panelRight = new JPanel();
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

		btnGesEquipo = new JButton("Gestionar equipo");
		btnGesEquipo.addActionListener(this);
		btnGesEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGesEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGesEquipo.setFocusable(false);
		btnGesEquipo.setBorder(null);
		btnGesEquipo.setBackground(new Color(128, 128, 0));
		btnGesEquipo.setBounds(57, 370, 200, 49);
		panelLeft.add(btnGesEquipo);

		lblWelcome = new JLabel("Welcome Admin");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnGestionarEntrenador = new JButton("Gestionar entrenador");
		btnGestionarEntrenador.addActionListener(this);
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(128, 128, 0));
		btnGestionarEntrenador.setBounds(57, 250, 200, 49);
		panelLeft.add(btnGestionarEntrenador);

		btnCrearPartido = new JButton("Crear partido");
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(128, 128, 0));
		btnCrearPartido.setBounds(57, 310, 200, 49);
		panelLeft.add(btnCrearPartido);

		// Botón Modificar partido
		btnModificarPartido = new JButton("Modificar partido");
		btnModificarPartido.setForeground(new Color(128, 128, 0));
		btnModificarPartido.setEnabled(false);
		btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPartido.setFocusable(false);
		btnModificarPartido.setBorder(null);
		btnModificarPartido.setBackground(new Color(255, 128, 64));
		btnModificarPartido.setBounds(57, 430, 200, 49);
		panelLeft.add(btnModificarPartido);
		btnModificarPartido.addActionListener(this); // Agregar ActionListener

		setComponentesVisibles(false);

		llenarComboBoxPartidos();

		okButton.addActionListener(this);
	}

	private void setComponentesVisibles(boolean visible) {
		equipoLocalLabel.setVisible(visible);
		equipoVisitanteLabel.setVisible(visible);
		estadioField.setVisible(visible);
		datePicker.setVisible(visible);
		timeSpinner.setVisible(visible);
		okButton.setVisible(visible);
		resultado1.setVisible(visible);
		resultado2.setVisible(visible);
		// Ocultar textos a la derecha
		JLabel[] labels = { lblResultado1, label, lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3,
				lblNewLabel_4
				};
		for (JLabel label : labels) {
			label.setVisible(visible);
		}
	}

	private void llenarComboBoxPartidos() {
		ArrayList<String> partidos = controller.listaPartidos();

		partidosComboBox.addItem("");

		for (int i = 0; i < partidos.size(); i++) {
			partidosComboBox.addItem(partidos.get(i));
		}
	}

	public void actionPerformed(ActionEvent e) {
		MenuAdmin menuAdmin = new MenuAdmin(controller);
		Object o = e.getSource();
		if (o == editarPartidoButton) {
			mostrarComponentes = !mostrarComponentes;
			setComponentesVisibles(mostrarComponentes);
			editarPartidoButton.setText("Editar este partido");
			editarPartidoButton.setVisible(false);
			okButton.setVisible(true);
			partidosComboBox.setVisible(false);
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
					menuAdmin.setVisible(true);
					dispose();
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
		} else if (o == btnCrearPartido) {
			CrearPartido crearPartido = new CrearPartido(controller);
			crearPartido.setVisible(true);
			this.dispose();
		}  else if (o == btnGesEquipo) {
			MenuAdmin menusAdmin= new MenuAdmin(controller);
			menusAdmin.setVisible(true);
			this.dispose();
		
		}else if (o == btnGestionarEntrenador) {
			GestionarEntre gestionarEntre= new GestionarEntre(controller);
			gestionarEntre.setVisible(true);
			this.dispose();
			
		}  else if (o == btnLogOut) {
			Login frame = new Login(controller);
			frame.setVisible(true);
			this.dispose();
		}
	}
}

