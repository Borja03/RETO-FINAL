package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import model.partido.Juegan;

public class ModificarPartido extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel equipoLocalLabel;
	private JLabel equipoVisitanteLabel;
	private JTextField estadioField;
	private JCalendar datePicker;
	private JSpinner timeSpinner;
	private Controller controller;
	private JButton okButton;
	private JTextField resultado1;
	private JTextField resultado2;
	private JComboBox<String> partidosComboBox;
	private JButton editarPartidoButton;
	private JLabel lblResultado1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel label;
	private ArrayList<Juegan> partidos;
	private JPanel panelLeft;
	private boolean mostrarComponentes;
	private JButton btnLogOut;
	private JButton btnGesEquipo;
	private JLabel lblWelcome;
	private JButton btnGestionarEntrenador;
	private JButton btnCrearPartido;
	private JButton btnModificarPartido;
	private LocalDateTime date;

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
		lblResultado1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado1.setBounds(380, 156, 100, 20);
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(326, 31, 100, 14);
		contentPane.add(lblNewLabel);

		equipoLocalLabel = new JLabel();
		equipoLocalLabel.setBounds(458, 31, 266, 20);
		contentPane.add(equipoLocalLabel);

		lblNewLabel_1 = new JLabel("Equipo Visitante:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(326, 67, 122, 14);
		contentPane.add(lblNewLabel_1);

		equipoVisitanteLabel = new JLabel();
		equipoVisitanteLabel.setBounds(458, 61, 266, 20);
		contentPane.add(equipoVisitanteLabel);

		lblNewLabel_2 = new JLabel("Estadio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(326, 114, 100, 14);
		contentPane.add(lblNewLabel_2);

		estadioField = new JTextField();
		estadioField.setBounds(458, 113, 266, 20);
		estadioField.setEditable(false);
		contentPane.add(estadioField);
		estadioField.setColumns(10);

		lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(380, 197, 100, 14);
		contentPane.add(lblNewLabel_3);

		datePicker = new JCalendar();
		datePicker.setBounds(500, 196, 200, 150);
		contentPane.add(datePicker);

		lblNewLabel_4 = new JLabel("Hora:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(380, 356, 46, 14);
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
		okButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		okButton.setBounds(758, 499, 66, 21);
		contentPane.add(okButton);
		okButton.setVisible(false);

		editarPartidoButton = new JButton("Editar este partido");
		editarPartidoButton.setBounds(524, 287, 200, 30);
		editarPartidoButton.addActionListener(this);
		contentPane.add(editarPartidoButton);

		panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 312, 680);
		panelLeft.setBackground(new Color(242, 45, 45));
		getContentPane().add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("   Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setBackground(new Color(242, 45, 45));
		btnLogOut.setBounds(0, 595, 310, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
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
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnGesEquipo = new JButton("     Gestionar equipo");
		btnGesEquipo.setForeground(new Color(255, 255, 255));
		btnGesEquipo.addActionListener(this);
		btnGesEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnGesEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGesEquipo.setFocusable(false);
		btnGesEquipo.setBorder(null);
		btnGesEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGesEquipo.setBackground(new Color(220, 3, 9));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGesEquipo.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGesEquipo.setBackground(new Color(242, 45, 45));
			}
		});
		btnGesEquipo.setBackground(new Color(242, 45, 45));
		btnGesEquipo.setBounds(0, 386, 310, 49);
		panelLeft.add(btnGesEquipo);

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(37, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnGestionarEntrenador = new JButton("     Gestionar entrenador");
		btnGestionarEntrenador.setForeground(new Color(255, 255, 255));
		btnGestionarEntrenador.addActionListener(this);
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
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
		btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
		btnGestionarEntrenador.setBounds(0, 275, 310, 49);
		panelLeft.add(btnGestionarEntrenador);

		btnCrearPartido = new JButton("     Crear partido");
		btnCrearPartido.setForeground(new Color(255, 255, 255));
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
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
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(242, 45, 45));
		btnCrearPartido.setBounds(0, 327, 310, 49);
		panelLeft.add(btnCrearPartido);

		btnModificarPartido = new JButton("     Modificar partido");
		btnModificarPartido.setForeground(new Color(255, 255, 255));
		btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPartido.setFocusable(false);
		btnModificarPartido.setBorder(null);
		btnModificarPartido.setBackground(new Color(220, 3, 9));
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
		btnModificarPartido.setBounds(0, 445, 310, 49);
		panelLeft.add(btnModificarPartido);
		btnModificarPartido.addActionListener(this);

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

		JLabel[] labels = { lblResultado1, label, lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3,
				lblNewLabel_4 };
		for (JLabel label : labels) {
			label.setVisible(visible);
		}
	}

	private void llenarComboBoxPartidos() {
		partidos = controller.listaPartidos();
		for (Juegan juegan : partidos) {
			String local = juegan.getNombreEquipoLocal();
			String visitante = juegan.getNombreEquipoVisitante();
			date = juegan.getFechaInicio();
			String resultado = juegan.getResultado();
			String partido = local + " vs " + visitante + " fecha: " + date + " Resultado: " + resultado;
			partidosComboBox.addItem(partido);
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == editarPartidoButton) {
			Juegan juegan = obtenerPartidoSeleccionado();

			if (juegan != null) {
				mostrarComponentes = !mostrarComponentes;
				setComponentesVisibles(mostrarComponentes);
				editarPartidoButton.setVisible(false);
				okButton.setVisible(true);
				partidosComboBox.setVisible(false);
				if (date.isBefore(LocalDateTime.now())) {
					datePicker.setEnabled(false);
					timeSpinner.setEnabled(false);
					resultado1.setEnabled(true);
					resultado2.setEnabled(true);
				} else {
					datePicker.setEnabled(true);
					timeSpinner.setEnabled(true);
					resultado1.setEnabled(false);
					resultado2.setEnabled(false);
				}
				equipoLocalLabel.setText(juegan.getNombreEquipoLocal());
				equipoVisitanteLabel.setText(juegan.getNombreEquipoVisitante());
				estadioField.setText(controller.getNombreEstadio(juegan));
				char res1 = juegan.getResultado().charAt(0);
				resultado1.setText(String.valueOf(res1));
				char res2 = juegan.getResultado().charAt(2);
				resultado2.setText(String.valueOf(res2));
				LocalDateTime fecha = juegan.getFechaInicio();
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, fecha.getYear());
				calendar.set(Calendar.MONTH, fecha.getMonthValue() - 1);
				calendar.set(Calendar.DAY_OF_MONTH, fecha.getDayOfMonth());
				datePicker.setDate(calendar.getTime());
				calendar.set(Calendar.HOUR_OF_DAY, fecha.getHour());
				calendar.set(Calendar.MINUTE, fecha.getMinute());
				calendar.set(Calendar.SECOND, fecha.getSecond());
				Date horaActual = calendar.getTime();
				timeSpinner.setValue(horaActual);

			} else {
				JOptionPane.showMessageDialog(this, "Seleccione un partido válido.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (o == okButton) {
			String local = equipoLocalLabel.getText();
			String visitante = equipoVisitanteLabel.getText();
			Date selectedDate = datePicker.getDate();
			Instant instant = selectedDate.toInstant();
			ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
			LocalDateTime fecha = zdt.toLocalDateTime();
			Date selectedTime = (Date) timeSpinner.getValue();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(selectedTime);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			fecha = fecha.withHour(hour).withMinute(minute).withSecond(second);
			String resultado = resultado1.getText() + label.getText() + resultado2.getText();
			Juegan juegan = new Juegan(local, visitante, fecha, resultado);
			controller.modificarPartido(juegan, date);
			MenuAdmin menuAdmin = new MenuAdmin(controller);
			menuAdmin.setVisible(true);
			this.dispose();
		} else if (o == btnCrearPartido) {
			CrearPartido crearPartido = new CrearPartido(controller);
			crearPartido.setVisible(true);
			this.dispose();
		} else if (o == btnGesEquipo) {
			MenuAdmin menusAdmin = new MenuAdmin(controller);
			menusAdmin.setVisible(true);
			this.dispose();
		} else if (o == btnGestionarEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			gestionarEntre.setVisible(true);
			this.dispose();
		} else if (o == btnLogOut) {
			Login frame = new Login(controller);
			frame.setVisible(true);
			this.dispose();
		}
	}

	private Juegan obtenerPartidoSeleccionado() {
		if (partidosComboBox.getSelectedIndex() != -1) {
			return partidos.get(partidosComboBox.getSelectedIndex());
		}
		return null;
	}

}
