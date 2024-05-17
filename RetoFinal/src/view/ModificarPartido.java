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
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
/**
 * This class represents the GUI for modifying a match.
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */
public class ModificarPartido extends JFrame implements ActionListener {
	/**
	 * Unique identifier for serializing the class.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The main content pane of the JFrame.
	 */
	private JPanel contentPane;

	/**
	 * Label for displaying the home team.
	 */
	private JLabel equipoLocalLabel;

	/**
	 * Label for displaying the away team.
	 */
	private JLabel equipoVisitanteLabel;

	/**
	 * Text field for entering the stadium name.
	 */
	private JTextField estadioField;

	/**
	 * Calendar for selecting the date of the match.
	 */
	private JCalendar datePicker;

	/**
	 * Spinner for selecting the time of the match.
	 */
	private JSpinner timeSpinner;

	/**
	 * Controller for managing the application's logic.
	 */
	private Controller controller;

	/**
	 * Button for modifying the match.
	 */
	private JButton btnModifcarPart;

	/**
	 * Text field for entering the first team's score.
	 */
	private JTextField resultado1;

	/**
	 * Text field for entering the second team's score.
	 */
	private JTextField resultado2;

	/**
	 * Combo box for selecting a match.
	 */
	private JComboBox<String> partidosComboBox;

	/**
	 * Label for displaying the first team's score.
	 */
	private JLabel lblResultado1;

	/**
	 * Label for the stadium field.
	 */
	private JLabel lblNewLabel;

	/**
	 * Label for the date picker.
	 */
	private JLabel lblNewLabel_1;

	/**
	 * Label for the time spinner.
	 */
	private JLabel lblNewLabel_2;

	/**
	 * Label for additional information.
	 */
	private JLabel lblNewLabel_3;

	/**
	 * Another label for additional information.
	 */
	private JLabel lblNewLabel_4;

	/**
	 * Additional label for various purposes.
	 */
	private JLabel label;

	/**
	 * List of matches.
	 */
	private ArrayList<Juegan> partidos;

	/**
	 * Panel on the left side of the UI.
	 */
	private JPanel panelLeft;

	/**
	 * Flag indicating whether to show components.
	 */
	private boolean mostrarComponentes;

	/**
	 * Button for logging out of the application.
	 */
	private JButton btnLogOut;

	/**
	 * Button for managing the team.
	 */
	private JButton btnGesEquipo;

	/**
	 * Label for displaying a welcome message.
	 */
	private JLabel lblWelcome;

	/**
	 * Button for managing the coach.
	 */
	private JButton btnGestionarEntrenador;

	/**
	 * Button for creating a new match.
	 */
	private JButton btnCrearPartido;

	/**
	 * Button for modifying an existing match.
	 */
	private JButton btnModificarPartido;

	/**
	 * The date and time for the match.
	 */
	private LocalDateTime date;

	/**
	 * Panel at the top of the UI.
	 */
	private JPanel topPanel;

	/**
	 * Panel for modifying match details.
	 */
	private JPanel panelModificar;
	 /**
     * Constructor for ModificarPartido.
     *
     * @param controlador the controller used to handle actions and data.
     */

	public ModificarPartido(Controller controlador) {
		this.controller = controlador;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		topPanel = new JPanel();
		topPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		topPanel.setBounds(260, 20, 706, 107);
		contentPane.add(topPanel);
		
		
		panelModificar = new JPanel();
		panelModificar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelModificar.setBounds(260, 142, 724, 528);
		contentPane.add(panelModificar);

		panelModificar.setLayout(null);
		
		lblResultado1 = new JLabel("Resultado:");
		lblResultado1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado1.setBounds(45, 159, 78, 34);
		panelModificar.add(lblResultado1);

		resultado1 = new JTextField();
		resultado1.setFont(new Font("Tahoma", Font.BOLD, 14));
		resultado1.setBounds(280, 160, 34, 34);
		panelModificar.add(resultado1);

		label = new JLabel("-");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(333, 159, 7, 34);
		panelModificar.add(label);

		resultado2 = new JTextField();
		resultado2.setFont(new Font("Tahoma", Font.BOLD, 14));
		resultado2.setBounds(371, 160, 34, 34);
		panelModificar.add(resultado2);

		lblNewLabel = new JLabel("Equipo Local:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(45, 10, 100, 34);
		panelModificar.add(lblNewLabel);

		equipoLocalLabel = new JLabel();
		equipoLocalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		equipoLocalLabel.setBounds(280, 10, 300, 34);
		panelModificar.add(equipoLocalLabel);

		lblNewLabel_1 = new JLabel("Equipo Visitante:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(45, 54, 122, 34);
		panelModificar.add(lblNewLabel_1);

		equipoVisitanteLabel = new JLabel();
		equipoVisitanteLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		equipoVisitanteLabel.setBounds(280, 54, 300, 34);
		panelModificar.add(equipoVisitanteLabel);

		lblNewLabel_2 = new JLabel("Estadio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(45, 98, 58, 34);
		panelModificar.add(lblNewLabel_2);

		estadioField = new JTextField();
		estadioField.setFont(new Font("Tahoma", Font.BOLD, 14));
		estadioField.setBounds(280, 101, 300, 34);
		estadioField.setEditable(false);
		panelModificar.add(estadioField);
		estadioField.setColumns(10);

		lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(45, 229, 49, 34);
		panelModificar.add(lblNewLabel_3);

		datePicker = new JCalendar();
		datePicker.setBounds(278, 229, 356, 186);
		panelModificar.add(datePicker);

		lblNewLabel_4 = new JLabel("Hora:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(45, 433, 41, 34);
		panelModificar.add(lblNewLabel_4);

		timeSpinner = new JSpinner(new SpinnerDateModel());
		timeSpinner.setBounds(274, 436, 66, 34);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		panelModificar.add(timeSpinner);
		topPanel.setLayout(null);

		partidosComboBox = new JComboBox<>();
		partidosComboBox.addActionListener(this);
		partidosComboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		partidosComboBox.setBounds(272, 38, 300, 34);
		topPanel.add(partidosComboBox);

		btnModifcarPart = new JButton("Modificar partido");
		btnModifcarPart.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModifcarPart.setBounds(516, 470, 161, 34);
		panelModificar.add(btnModifcarPart);

		panelLeft = new JPanel();
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
		btnGesEquipo.setBounds(0, 386, 250, 49);
		panelLeft.add(btnGesEquipo);

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(10, 179, 217, 34);
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
		btnGestionarEntrenador.setBounds(0, 275, 250, 49);
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
		btnCrearPartido.setBounds(0, 327, 250, 49);
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
		btnModificarPartido.setBounds(0, 445, 250, 49);
		panelLeft.add(btnModificarPartido);
		
		JLabel lblPartidos = new JLabel("Partidos programados :");
		lblPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPartidos.setBounds(40, 38, 200, 34);
		topPanel.add(lblPartidos);
		


		btnModificarPartido.addActionListener(this);

		//setComponentesVisibles(false);

		llenarComboBoxPartidos();

		btnModifcarPart.addActionListener(this);
		panelModificar.setVisible(false);

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

	
	 /**
     * Handles action events triggered by user interactions with the UI.
     *
     * @param e the action event triggered by the user.
     */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == partidosComboBox) {
			panelModificar.setVisible(true);

			Juegan juegan = obtenerPartidoSeleccionado();

			if (juegan != null) {

				//mostrarComponentes = !mostrarComponentes;
				//setComponentesVisibles(mostrarComponentes);
//				editarPartidoButton.setVisible(false);
//				btnModifcarPart.setVisible(true);
//				partidosComboBox.setVisible(false);
//				if (date.isBefore(LocalDateTime.now())) {
//					datePicker.setEnabled(false);
//					timeSpinner.setEnabled(false);
//					resultado1.setEnabled(true);
//					resultado2.setEnabled(true);
//				} else {
//					datePicker.setEnabled(true);
//					timeSpinner.setEnabled(true);
//					resultado1.setEnabled(false);
//					resultado2.setEnabled(false);
//				}
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
		} else if (o == btnModifcarPart) {
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