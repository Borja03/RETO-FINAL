
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class ConsultarPartidos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JButton btnLogOut;
	private JButton btnConsultarEquipo;
	private JButton btnGestJugadores;
	private JLabel lblWelcome;
	private JButton btnConsultarPartidos;
	private String userName;
	private JScrollPane scrollPane;
	// private JPanel rightPanel;
	private JLabel lblVs;
	private JLabel lblEqVistante;
	private JLabel lblEqLogo1;
	private JLabel lblFechaYHora;
	private JLabel lblEstadio;
	private JPanel cardsPanel;
	private String userType;
	private JButton btnCambiarContrasena;

	public ConsultarPartidos(Controller cont, String entrConnected,String userType) {
		this.controller = cont;
		this.userName = entrConnected;
		this.userType = userType;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel(); // Use BorderLayout for the content pane
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//left panel 
		JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(128, 128, 0));
        panelLeft.setBounds(0, 0, 250, 680);
        contentPane.add(panelLeft);
        panelLeft.setLayout(null);

        btnConsultarEquipo = new JButton("     Consultar Equipo");
        btnConsultarEquipo.addActionListener(this);
        btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
        btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnConsultarEquipo.setFocusable(false);
        btnConsultarEquipo.setBorder(null);
        btnConsultarEquipo.setBackground(new Color(128, 128, 0));
        btnConsultarEquipo.setBounds(20, 395, 200, 49);
        panelLeft.add(btnConsultarEquipo);

        btnGestJugadores = new JButton("     Gestionar  jugadores");
        btnGestJugadores.addActionListener(this);
        btnGestJugadores.setHorizontalAlignment(SwingConstants.LEFT);
        btnGestJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnGestJugadores.setFocusable(false);
        btnGestJugadores.setBorder(null);
        btnGestJugadores.setBackground(new Color(128, 128, 0));
        btnGestJugadores.setBounds(20, 332, 200, 49);
        panelLeft.add(btnGestJugadores);

        lblWelcome = new JLabel("Welcome " + entrConnected + "");
        lblWelcome.setForeground(new Color(255, 255, 0));
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblWelcome.setBounds(20, 182, 217, 34);
        panelLeft.add(lblWelcome);

        btnConsultarPartidos = new JButton("     Consultar Partidos");
        btnConsultarPartidos.addActionListener(this);
        btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
        btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnConsultarPartidos.setFocusable(false);
        btnConsultarPartidos.setBorder(null);
        btnConsultarPartidos.setBackground(new Color(255, 128, 64));
        btnConsultarPartidos.setBounds(20, 454, 200, 49);
        panelLeft.add(btnConsultarPartidos);

        btnLogOut = new JButton("     Log Out");
        btnLogOut.setBounds(20, 586, 200, 49);
        panelLeft.add(btnLogOut);
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
        btnLogOut.setBackground(new Color(128, 128, 0));
        btnLogOut.setFocusable(false);
        btnLogOut.setBorder(null);
        btnLogOut.addActionListener(this);
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

        btnCambiarContrasena = new JButton("     Cambiar contraseña");
        btnCambiarContrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCambiarContrasena.setBounds(20, 513, 200, 49);
        panelLeft.add(btnCambiarContrasena);
        btnCambiarContrasena.setHorizontalAlignment(SwingConstants.LEFT);
        btnCambiarContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCambiarContrasena.setFocusable(false);
        btnCambiarContrasena.setBorder(null);
        btnCambiarContrasena.setBackground(new Color(128, 128, 0));
        btnCambiarContrasena.addActionListener(this);
		
        


    
		//right  panel

		
		JPanel rightPanel = new JPanel();
        rightPanel.setBounds(256, 10, 728, 660);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // Use BoxLayout

		contentPane.add(rightPanel);


		String logo1 = "/images/equiposLogo/athletic-bilbao.png";
		String logo2 = "/images/equiposLogo/real-madrid.png";
		cardsPanel = new JPanel();
		cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane(cardsPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		rightPanel.add(scrollPane, BorderLayout.CENTER);
        rightPanel.add(scrollPane); // Add scroll pane to right panel

		for (int i = 0; i < 20; i++) {
			miCard("Team 1" + i, logo1, "Team 2" + (i + 1),logo2, "17-04-2024 16:15", "Estadio Name", (20 + (180 * i)));
		}

		setVisible(true);
	}

	public void miCard(String eqLocal, String linkLogo1, String EqVisitante, String linkLogo2, String dateTime,
			String estadio, int high) {

		JPanel partidoPanel = new JPanel(new BorderLayout());
		partidoPanel.setBackground(new Color(192, 192, 192));
		partidoPanel.setBounds(10, high, 718, 150);
		partidoPanel.setBorder(new LineBorder(Color.RED, 3));
        partidoPanel.setPreferredSize(new Dimension(710, 170)); 
        partidoPanel.setMaximumSize(new Dimension(710, 170));
        partidoPanel.setAlignmentX(Component.LEFT_ALIGNMENT); 
		partidoPanel.setLayout(null);

		JLabel lblEqLocal = new JLabel(eqLocal);
		lblEqLocal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEqLocal.setBounds(175, 58, 150, 22);
		partidoPanel.add(lblEqLocal);

		JLabel lblEqLogo = new JLabel();
		ImageIcon imgIcon = new ImageIcon(getClass().getResource(linkLogo1));
		lblEqLogo.setIcon(imgIcon);
		lblEqLogo.setBounds(15, 15, 150, 150);
		partidoPanel.add(lblEqLogo);

		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVs.setBounds(335, 58, 40, 22);
		partidoPanel.add(lblVs);

		JLabel lblEqVistante = new JLabel(EqVisitante);
		lblEqVistante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEqVistante.setBounds(385, 58, 173, 22);
		partidoPanel.add(lblEqVistante);

		JLabel lblEqLogo1 = new JLabel();
		ImageIcon imgIcon2 = new ImageIcon(getClass().getResource(linkLogo2));
		lblEqLogo1.setIcon(imgIcon2);
		lblEqLogo1.setBounds(547, 15, 150, 150);
		partidoPanel.add(lblEqLogo1);

		JLabel lblFechaYHora = new JLabel(dateTime);
		lblFechaYHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaYHora.setBounds(300, 111, 132, 22);
		partidoPanel.add(lblFechaYHora);

		JLabel lblEstadio = new JLabel("Estadio :" + estadio);
		lblEstadio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstadio.setBounds(290, 143, 108, 22);
		partidoPanel.add(lblEstadio);

		cardsPanel.add(partidoPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogOut) {

			this.dispose();
			controller.logOut();

		} else if (e.getSource() == btnGestJugadores) {
			String myTeam = "";
			GestionarJugadores g1 = new GestionarJugadores(controller, userName,userType, myTeam);
			g1.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName,userType);
			menuEntrenador.setVisible(true);
			this.dispose();
		}else if(e.getSource() == btnCambiarContrasena) {
			CambiarContra cambiarContra = new CambiarContra(controller,userName,userType);
			cambiarContra.setVisible(true);
			this.dispose();
		}

	}
}
