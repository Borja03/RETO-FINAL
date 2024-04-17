package view;

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
    private JLabel lblNewLabel_5;
    private JLabel label;

    public ModificarPartido(Controller controlador) {
        this.controller = controlador;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 690, 486);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblResultado1 = new JLabel("Resultado:");
        lblResultado1.setBounds(29, 157, 100, 20);
        contentPane.add(lblResultado1);

        resultado1 = new JTextField();
        resultado1.setBounds(139, 154, 30, 20);
        contentPane.add(resultado1);

        label = new JLabel("-");
        label.setBounds(172, 154, 10, 20);
        contentPane.add(label);

        resultado2 = new JTextField();
        resultado2.setBounds(187, 154, 30, 20);
        contentPane.add(resultado2);

        lblNewLabel = new JLabel("Equipo Local:");
        lblNewLabel.setBounds(29, 31, 100, 14);
        contentPane.add(lblNewLabel);

        equipoLocalLabel = new JLabel();
        equipoLocalLabel.setBounds(139, 28, 266, 20);
        contentPane.add(equipoLocalLabel);

        lblNewLabel_1 = new JLabel("Equipo Visitante:");
        lblNewLabel_1.setBounds(29, 73, 100, 14);
        contentPane.add(lblNewLabel_1);

        equipoVisitanteLabel = new JLabel();
        equipoVisitanteLabel.setBounds(139, 70, 266, 20);
        contentPane.add(equipoVisitanteLabel);

        lblNewLabel_2 = new JLabel("Estadio:");
        lblNewLabel_2.setBounds(29, 115, 100, 14);
        contentPane.add(lblNewLabel_2);

        estadioField = new JTextField();
        estadioField.setBounds(139, 112, 266, 20);
        estadioField.setEditable(false);
        contentPane.add(estadioField);
        estadioField.setColumns(10);

        lblNewLabel_3 = new JLabel("Fecha:");
        lblNewLabel_3.setBounds(29, 199, 100, 14);
        contentPane.add(lblNewLabel_3);

        datePicker = new JCalendar();
        datePicker.setBounds(139, 196, 200, 150);
        contentPane.add(datePicker);

        lblNewLabel_4 = new JLabel("Hora:");
        lblNewLabel_4.setBounds(29, 358, 46, 14);
        contentPane.add(lblNewLabel_4);

        timeSpinner = new JSpinner(new SpinnerDateModel());
        timeSpinner.setBounds(139, 355, 80, 20);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        contentPane.add(timeSpinner);

        lblNewLabel_5 = new JLabel("Partido:");
        lblNewLabel_5.setBounds(29, 242, 100, 14);
        contentPane.add(lblNewLabel_5);

        partidosComboBox = new JComboBox<>();
        partidosComboBox.addActionListener(this);
        partidosComboBox.setBounds(230, 239, 200, 20);
        contentPane.add(partidosComboBox);

        okButton = new JButton("OK");
        okButton.setBounds(391, 355, 66, 21);
        contentPane.add(okButton);
        okButton.setVisible(false);

        editarPartidoButton = new JButton("Editar este partido");
        editarPartidoButton.setBounds(230, 297, 200, 30);
        editarPartidoButton.addActionListener(this);
        contentPane.add(editarPartidoButton);

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
                lblNewLabel_4, lblNewLabel_5 };
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
        if (e.getSource() == editarPartidoButton) {
            mostrarComponentes = !mostrarComponentes;
            setComponentesVisibles(mostrarComponentes);
            editarPartidoButton.setText("Editar este partido");
            editarPartidoButton.setVisible(false);
            okButton.setVisible(true);
            partidosComboBox.setVisible(false);
            lblNewLabel_5.setVisible(false);
        } else if (e.getSource() == partidosComboBox) {
            String nombrePartidoSeleccionado = (String) partidosComboBox.getSelectedItem();
            if (!nombrePartidoSeleccionado.isEmpty()) {
                // Aquí obtienes los nombres de los equipos local y visitante desde el nombre del partido seleccionado
                String[] nombresEquipos = nombrePartidoSeleccionado.split(" VS ");
                String nombreEquipoLocal = nombresEquipos[0];
                String nombreEquipoVisitante = nombresEquipos[1];

                // Estableces los nombres de los equipos en los labels correspondientes
                equipoLocalLabel.setText(nombreEquipoLocal);
                equipoVisitanteLabel.setText(nombreEquipoVisitante);
            }
        } else if (e.getSource() == okButton) {
            // Resto del código aquí
        } 
    }
}
