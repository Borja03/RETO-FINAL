package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class MenuAdmin extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
		private JPanel contentPane;
	    private JButton btnLogOut;
	    private JButton btnAddEq;
	    private JButton btnAddJugado;
	    private JButton crearEquipo;
	    private JButton gestionarEntre;
	    private JButton cambiarContra;
	    private JButton crearPartido;
	    private JButton cerrarSesion;
	    private JLabel lblWelcome;
	    private Controller controller;
	    private String userName;

	public MenuAdmin(Controller cont) {
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
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(50, 70, 90));
			}
		});
    		
	
		
		crearEquipo = new JButton("Crear equipo");
		crearEquipo.setBounds(391, 124, 163, 45);
		contentPane.add(crearEquipo);
		
		gestionarEntre = new JButton("Gestionar entrenador");
		gestionarEntre.setBounds(564, 124, 163, 45);
		contentPane.add(gestionarEntre);

		cambiarContra = new JButton("Cambiar contraseña");
		cambiarContra.setBounds(391, 179, 163, 45);
		contentPane.add(cambiarContra);
	
		crearPartido = new JButton("Crear partido");
		crearPartido.setBounds(564, 179, 163, 45);
		contentPane.add(crearPartido);

		JTextPane titulo = new JTextPane();
		titulo.setBounds(509, 80, 114, 19);
		titulo.setText("DISPLAY ADMIN");
		titulo.setEditable(false);
		contentPane.add(titulo);

		cerrarSesion = new JButton("Cerrar sesión");
		cerrarSesion.setBounds(661, 257, 140, 21);
		contentPane.add(cerrarSesion);

		crearEquipo.addActionListener(this);
		gestionarEntre.addActionListener(this);
		cambiarContra.addActionListener(this);
		crearPartido.addActionListener(this);
		cerrarSesion.addActionListener(this);
		btnLogOut.setBackground(new Color(128, 128, 0));
		btnLogOut.setBounds(57, 536, 200, 49);
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
		btnAddEq.setBounds(57, 466, 200, 49);
		panelLeft.add(btnAddEq);

		lblWelcome = new JLabel("Welcome Admin");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
    
    		Object o = e.getSource();
		if (o == crearEquipo) {
			CrearEquipo frame = new CrearEquipo (controller);
    		frame.setVisible(true);
    		dispose();
        }else if (o == gestionarEntre) {
        	GestionarEntre frame = new GestionarEntre (controller);
    		frame.setVisible(true);
    		dispose();
        }else if (o == cambiarContra) {
        	CambiarContra frame = new CambiarContra (controller);
    		frame.setVisible(true);
    		dispose();
        }else if (o == crearPartido) {
        	CrearPartido frame = new CrearPartido (controller);
    		frame.setVisible(true);
    		dispose();
        }
        else if (o == cerrarSesion) {
        	Login frame = new Login ();
    		frame.setVisible(true);
    		dispose();
        }
		
		if(o==btnLogOut) {
			controller.closeConnection();
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
		}
	}
}
