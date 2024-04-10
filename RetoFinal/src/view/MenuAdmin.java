package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JButton;
import javax.swing.JTextPane;

public class MenuAdmin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller l;
	private JButton crearEquipo;
	private JButton crearPartido;
	private JButton cambiarContra;
	private JButton gestionarEntre;

	public MenuAdmin(Controller controlador) {
		this.l = controlador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		crearEquipo = new JButton("Crear equipo");
		crearEquipo.setBounds(34, 94, 163, 45);
		contentPane.add(crearEquipo);
		
		gestionarEntre = new JButton("Gestionar entrenador");
		gestionarEntre.setBounds(220, 94, 163, 45);
		contentPane.add(gestionarEntre);
		
		cambiarContra = new JButton("Cambiar contraseña");
		cambiarContra.setBounds(220, 163, 163, 45);
		contentPane.add(cambiarContra);
		
		crearPartido = new JButton("Crear partido");
		crearPartido.setBounds(34, 163, 163, 45);
		contentPane.add(crearPartido);
		
		JTextPane titulo = new JTextPane();
		titulo.setText("DISPLAY ADMIN");
		titulo.setEditable(false);
		titulo.setBounds(154, 34, 114, 19);
		contentPane.add(titulo);
		
		crearEquipo.addActionListener(this);
		gestionarEntre.addActionListener(this);
		cambiarContra.addActionListener(this);
		crearPartido.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == crearEquipo) {
			CrearEquipo frame = new CrearEquipo (l);
    		frame.setVisible(true);
    		dispose();
        }else if (o == gestionarEntre) {
        	GestionarEntre frame = new GestionarEntre (l);
    		frame.setVisible(true);
    		dispose();
        }else if (o == cambiarContra) {
        	CambiarContra frame = new CambiarContra (l);
    		frame.setVisible(true);
    		dispose();
        }else if (o == crearPartido) {
        	CrearPartido frame = new CrearPartido (l);
    		frame.setVisible(true);
    		dispose();
        }
	}
}
