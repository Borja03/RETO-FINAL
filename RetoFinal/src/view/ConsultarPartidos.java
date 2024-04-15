package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import javax.swing.JLabel;

public class ConsultarPartidos extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblEQLocal;
	private JLabel lblEQVisitante;
	private JLabel lblResultado;
	private JLabel lblFechaHora;
	private JLabel lblLugar;
	private Controller controller;

	public ConsultarPartidos(Controller cont) {
		this.controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblEQLocal = new JLabel("New label");
		lblEQLocal.setBounds(39, 49, 188, 30);
		contentPane.add(lblEQLocal);

		lblEQVisitante = new JLabel("New label");
		lblEQVisitante.setBounds(457, 49, 188, 30);
		contentPane.add(lblEQVisitante);

		lblResultado = new JLabel("New label");
		lblResultado.setBounds(237, 49, 188, 30);
		contentPane.add(lblResultado);

		lblFechaHora = new JLabel("New label");
		lblFechaHora.setBounds(213, 111, 188, 30);
		contentPane.add(lblFechaHora);

		lblLugar = new JLabel("New label");
		lblLugar.setBounds(213, 152, 188, 30);
		contentPane.add(lblLugar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
	}

}
