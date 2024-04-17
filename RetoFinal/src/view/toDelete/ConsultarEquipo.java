package view.toDelete;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.Controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ConsultarEquipo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JLabel lblNEquipo;
	private JLabel lblEstadio;
	private JLabel lblTitulos;
	private JLabel lblEntrenadores;
	private JLabel lblJugadores;
	private JButton btnOK;
	private JLabel lblNEquipoShow;
	private JLabel lblEstadioShow;
	private JLabel lblTitulosShow;
	private JLabel lblEntrenadoresShow;
	private JLabel lblJugadoresShow;

	public ConsultarEquipo(Controller cont) {
		this.controller = cont;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(128, 128, 0));
		panelLeft.setBounds(0, 0, 345, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		lblNEquipo = new JLabel("Nombre Equipo:");
		lblNEquipo.setBounds(43, 63, 173, 26);
		panelLeft.add(lblNEquipo);
		
		lblEstadio = new JLabel("Estadio:");
		lblEstadio.setBounds(43, 110, 173, 26);
		panelLeft.add(lblEstadio);
		
		lblTitulos = new JLabel("Titulos:");
		lblTitulos.setBounds(43, 155, 173, 26);
		panelLeft.add(lblTitulos);
		
		lblEntrenadores = new JLabel("Entrenadores:");
		lblEntrenadores.setBounds(43, 211, 173, 26);
		panelLeft.add(lblEntrenadores);
		
		lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setBounds(43, 269, 173, 26);
		panelLeft.add(lblJugadores);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(863, 644, 89, 23);
		contentPane.add(btnOK);
		
		lblNEquipoShow = new JLabel("");
		lblNEquipoShow.setBounds(357, 62, 173, 26);
		contentPane.add(lblNEquipoShow);
		
		lblEstadioShow = new JLabel("");
		lblEstadioShow.setBounds(357, 108, 173, 26);
		contentPane.add(lblEstadioShow);
		
		lblTitulosShow = new JLabel("");
		lblTitulosShow.setBounds(355, 153, 173, 26);
		contentPane.add(lblTitulosShow);
		
		lblEntrenadoresShow = new JLabel("");
		lblEntrenadoresShow.setBounds(357, 207, 173, 26);
		contentPane.add(lblEntrenadoresShow);
		
		lblJugadoresShow = new JLabel("");
		lblJugadoresShow.setBounds(355, 261, 173, 26);
		contentPane.add(lblJugadoresShow);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		

	}

}
