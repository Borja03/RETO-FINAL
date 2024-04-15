package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.Controller;

public class CrearEquipo extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Controller controller;
    private JButton cerrarSesion;
    private JTextField nombreEquipoField;
    private JTextField nombreEstadioField;
    private JComboBox<Integer> titulosComboBox;
    private JButton btnOK;

    public CrearEquipo(Controller controlador) {
        this.controller = controlador;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombreEquipo = new JLabel("Nombre del Equipo:");
        lblNombreEquipo.setBounds(30, 30, 150, 20);
        contentPane.add(lblNombreEquipo);

        nombreEquipoField = new JTextField();
        nombreEquipoField.setBounds(200, 30, 200, 20);
        contentPane.add(nombreEquipoField);

        JLabel lblNombreEstadio = new JLabel("Nombre del Estadio:");
        lblNombreEstadio.setBounds(30, 70, 150, 20);
        contentPane.add(lblNombreEstadio);

        nombreEstadioField = new JTextField();
        nombreEstadioField.setBounds(200, 70, 200, 20);
        contentPane.add(nombreEstadioField);

        JLabel lblTitulos = new JLabel("Número de Títulos:");
        lblTitulos.setBounds(30, 110, 150, 20);
        contentPane.add(lblTitulos);

        Integer[] numerosTitulos = new Integer[51];
        for (int i = 0; i <= 50; i++) {
            numerosTitulos[i] = i;
        }
        titulosComboBox = new JComboBox<Integer>(numerosTitulos);
        titulosComboBox.setBounds(200, 110, 100, 20);
        contentPane.add(titulosComboBox);

        cerrarSesion = new JButton("Cerrar sesión");
        cerrarSesion.setBounds(341, 242, 95, 21);
        contentPane.add(cerrarSesion);
        
        btnOK = new JButton("OK");
        btnOK.setBounds(146, 190, 89, 23);
        contentPane.add(btnOK);
        btnOK.addActionListener(this);

        cerrarSesion.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
  
        int titulosSeleccionados = (int) titulosComboBox.getSelectedItem();

       
        if (o == cerrarSesion) {
            Login frame = new Login(controller);
            frame.setVisible(true);
            dispose();
        }else if(o == btnOK) {
        	controller.crearEquipo(nombreEquipoField.getText(), titulosSeleccionados, nombreEstadioField.getText());
        	 int opcion = JOptionPane.showConfirmDialog(this,
						(String) "El equipo ha sido introducido correctamente\n¿Desea añadir otro equipo?", "",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        	 if(opcion == JOptionPane.NO_OPTION) {
        		 this.dispose();
        		 MenuAdmin ma = new MenuAdmin(controller);
        		 ma.setVisible(true);
        	 }
        	 
        }
    }
}
