package view;

import com.toedter.calendar.JCalendar;
import controller.Controller;
import model.equipos.Equipo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class ModificarPartido extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
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

    public ModificarPartido(Controller controlador) {
        this.controller = controlador;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setBounds(42, 199, 80, 20);
        contentPane.add(timeSpinner);

        JLabel lblNewLabel = new JLabel("Equipo Local:");
        lblNewLabel.setBounds(29, 31, 100, 14);
        contentPane.add(lblNewLabel);

        equipoLocalComboBox = new JComboBox<>();
        equipoLocalComboBox.addActionListener(this);
        equipoLocalComboBox.setBounds(139, 28, 266, 20);
        contentPane.add(equipoLocalComboBox);

        JLabel lblNewLabel_1 = new JLabel("Equipo Visitante:");
        lblNewLabel_1.setBounds(29, 73, 100, 14);
        contentPane.add(lblNewLabel_1);

        equipoVisitanteComboBox = new JComboBox<>();
        equipoVisitanteComboBox.setBounds(139, 70, 266, 20);
        contentPane.add(equipoVisitanteComboBox);

        JLabel lblNewLabel_2 = new JLabel("Estadio:");
        lblNewLabel_2.setBounds(29, 115, 100, 14);
        contentPane.add(lblNewLabel_2);

        estadioField = new JTextField();
        estadioField.setEditable(false);
        estadioField.setBounds(139, 112, 266, 20);
        contentPane.add(estadioField);
        estadioField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Fecha:");
        lblNewLabel_3.setBounds(29, 157, 100, 14);
        contentPane.add(lblNewLabel_3);

        datePicker = new JCalendar();
        datePicker.setBounds(139, 154, 200, 150);
        contentPane.add(datePicker);

        okButton = new JButton("OK");
        okButton.setBounds(360, 232, 66, 21);
        contentPane.add(okButton);

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

        resultado1 = new JTextField();
        resultado1.setBounds(139, 230, 30, 20);
        contentPane.add(resultado1);

        JLabel label = new JLabel("-");
        label.setBounds(172, 230, 10, 20);
        contentPane.add(label);

        resultado2 = new JTextField();
        resultado2.setBounds(187, 230, 30, 20);
        contentPane.add(resultado2);
        
        // Etiqueta para el primer resultado
        JLabel lblResultado1 = new JLabel("Resultado:");
        lblResultado1.setBounds(29, 230, 100, 20);
        contentPane.add(lblResultado1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == equipoLocalComboBox) {
            String nombreEquipoLocal = (String) equipoLocalComboBox.getSelectedItem();
            String estadioEquipoLocal = estadiosEquipos.get(nombreEquipoLocal);
            estadioField.setText(estadioEquipoLocal);

            equipoVisitanteComboBox.removeAllItems();
            for (String equipo : equiposDisponibles) {
                if (!equipo.equals(nombreEquipoLocal)) {
                    equipoVisitanteComboBox.addItem(equipo);
                }
            }
        } else if (e.getSource() == okButton) {
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
                    MenuAdmin menuAdmin = new MenuAdmin(controller);
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
        }
    }
}
