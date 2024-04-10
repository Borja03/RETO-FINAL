package view;

import com.toedter.calendar.JCalendar;
import controller.Controller;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearPartido extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField equipoLocalField;
    private JTextField equipoVisitanteField;
    private JTextField estadioField;
    private JCalendar datePicker;
    private JButton okButton;
    private Controller controller; 

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

        equipoLocalField = new JTextField();
        equipoLocalField.setBounds(139, 28, 266, 20);
        contentPane.add(equipoLocalField);
        equipoLocalField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Equipo Visitante:");
        lblNewLabel_1.setBounds(29, 73, 100, 14);
        contentPane.add(lblNewLabel_1);

        equipoVisitanteField = new JTextField();
        equipoVisitanteField.setBounds(139, 70, 266, 20);
        contentPane.add(equipoVisitanteField);
        equipoVisitanteField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Estadio:");
        lblNewLabel_2.setBounds(29, 115, 100, 14);
        contentPane.add(lblNewLabel_2);

        estadioField = new JTextField();
        estadioField.setBounds(139, 112, 266, 20);
        contentPane.add(estadioField);
        estadioField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Fecha:");
        lblNewLabel_3.setBounds(29, 157, 100, 14);
        contentPane.add(lblNewLabel_3);

       // datePicker = new JCalendar();
       // datePicker.setBounds(139, 154, 200, 150);
       // contentPane.add(datePicker);

        okButton = new JButton("OK");
        okButton.setBounds(166, 209, 89, 23);
        contentPane.add(okButton);
        okButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            String equipoLocal = equipoLocalField.getText();
            String equipoVisitante = equipoVisitanteField.getText();
            String estadio = estadioField.getText();
          //  String fecha = datePicker.getDate().toString();

            // Aquí puedes llamar al método del controlador pasando los valores
            //controller.crearPartido(equipoLocal, equipoVisitante, estadio, fecha);

            // En este punto podrías cerrar la ventana si así lo deseas
            // dispose();
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
