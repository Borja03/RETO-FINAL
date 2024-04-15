package view;

import com.toedter.calendar.JCalendar;
import controller.Controller;
import model.equipos.Equipo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CrearPartido extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> equipoLocalComboBox;
    private JComboBox<String> equipoVisitanteComboBox;
    private JTextField estadioField;
    private JCalendar datePicker;
    private Controller controller;
    private HashMap<String, String> estadiosEquipos = new HashMap<>();

    public CrearPartido(Controller controlador) {
        this.controller = controlador;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        JButton okButton = new JButton("OK");
        okButton.setBounds(360, 232, 66, 21);
        contentPane.add(okButton);

       
        llenarComboBoxEquipos();
    }


  

    private void llenarComboBoxEquipos() {
        ArrayList<Equipo> equipos = controller.listarEquiposCP();
        for (Equipo equipo : equipos) {
       
            equipoLocalComboBox.addItem(equipo.getNombreEquipo());
            equipoVisitanteComboBox.addItem(equipo.getNombreEquipo());
            
            estadiosEquipos.put(equipo.getNombreEquipo(), equipo.getEstadio());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == equipoLocalComboBox) {
            String nombreEquipoLocal = (String) equipoLocalComboBox.getSelectedItem();
            String estadioEquipoLocal = estadiosEquipos.get(nombreEquipoLocal);
   
            estadioField.setText(estadioEquipoLocal);
        }
    }


    public static void main(String[] args) {
        // Crear una instancia del controlador
        Controller controlador = new Controller();

        // Crear una instancia de la ventana CrearPartido y pasarle el controlador
        CrearPartido ventanaCrearPartido = new CrearPartido(controlador);

        // Hacer visible la ventana
        ventanaCrearPartido.setVisible(true);
    }
}
