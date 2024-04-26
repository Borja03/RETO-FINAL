<<<<<<< HEAD

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class MenuAdmin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JButton btnLogOut;
	private JButton btnModificarPartido;
	private JLabel lblWelcome;
	private JButton btnConsultarPartidos;
	private JButton btnCrearPartido;
	private String userName;
	private JPanel rightPanelAddEd;
	private JTextField nombreEquipoField;
	private JTextField nombreEstadioField;
	private JTextField txttitulosField;
	private JButton bntAnadirEq;
	private JButton btnAddEquipo;
	private JButton btnModificar;
	private JButton btnUpload;
	private JLabel lblEquipoLogo;
	private ImageIcon imageIcon;
	private Blob imageBlob;
	private JLabel lblNombreDelEstadio;
	private JPanel topMenuPanelAddEq;
	private JButton btnGestionarEntrenador;
	private JLabel labelError;

	public MenuAdmin(Controller controller) {
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		rightPanelAddEd = new JPanel();
		rightPanelAddEd.setBounds(310, 73, 674, 597);
		contentPane.add(rightPanelAddEd);
		rightPanelAddEd.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(242, 45, 45));
		panelLeft.setBounds(0, 0, 300, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(50, 70, 90));
			}
		});
		btnLogOut.setBackground(new Color(242, 45, 45));
		btnLogOut.setBounds(37, 595, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogOut.setForeground(Color.WHITE);

		btnModificarPartido = new JButton("     Modificar partido");
		btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPartido.setFocusable(false);
		btnModificarPartido.setBorder(null);
		btnModificarPartido.setBackground(new Color(242, 45, 45));
		btnModificarPartido.setBounds(37, 440, 200, 49);
		btnModificarPartido.addActionListener(this);
		btnModificarPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnModificarPartido);
		btnModificarPartido.setForeground(Color.WHITE);

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setBackground(new Color(0, 0, 0));
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(37, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Gestionar equipo");
		btnConsultarPartidos.setEnabled(false);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(255, 128, 64));
		btnConsultarPartidos.setBounds(37, 385, 200, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnConsultarPartidos);
		btnConsultarPartidos.setForeground(Color.BLACK);

		btnCrearPartido = new JButton("     Crear partido");
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(242, 45, 45));
		btnCrearPartido.setBounds(37, 330, 200, 49);
		btnCrearPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnCrearPartido);
		btnCrearPartido.setForeground(Color.WHITE);

		btnGestionarEntrenador = new JButton("     Gestionar entrenador");
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
		btnGestionarEntrenador.setBounds(37, 275, 200, 49);
		btnGestionarEntrenador.addActionListener(this);
		btnGestionarEntrenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnGestionarEntrenador);
		btnGestionarEntrenador.setForeground(Color.WHITE);

		topMenuPanelAddEq = new JPanel();
		topMenuPanelAddEq.setBounds(310, 10, 674, 58);
		contentPane.add(topMenuPanelAddEq);
		topMenuPanelAddEq.setLayout(null);

		btnAddEquipo = new JButton("Añadir equipo");
		btnAddEquipo.setBackground(new Color(255, 128, 64));
		btnAddEquipo.setFocusable(false);
		btnAddEquipo.setBorder(null);
		btnAddEquipo.setBounds(74, 10, 150, 34);
		topMenuPanelAddEq.add(btnAddEquipo);

		btnModificar = new JButton("Modificar  equipo");
		btnModificar.setBackground(SystemColor.menu);
		btnModificar.addActionListener(this);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(null);
		btnModificar.setBounds(248, 10, 150, 34);
		topMenuPanelAddEq.add(btnModificar);

		// right panel
		JLabel lblNombreEquipo = new JLabel("Nombre del Equipo:");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEquipo.setBounds(53, 75, 160, 34);
		rightPanelAddEd.add(lblNombreEquipo);

		nombreEquipoField = new JTextField();
		nombreEquipoField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEquipoField.setBounds(223, 75, 250, 34);
		rightPanelAddEd.add(nombreEquipoField);

		nombreEstadioField = new JTextField();
		nombreEstadioField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEstadioField.setBounds(223, 150, 250, 34);
		rightPanelAddEd.add(nombreEstadioField);

		JLabel lblTitulos = new JLabel("Número de Títulos:");
		lblTitulos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulos.setBounds(53, 225, 145, 34);
		rightPanelAddEd.add(lblTitulos);

		txttitulosField = new JTextField();
		txttitulosField.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttitulosField.setBounds(223, 225, 250, 34);
		rightPanelAddEd.add(txttitulosField);

		bntAnadirEq = new JButton("Añadir Equipo");
		bntAnadirEq.addActionListener(this);
		bntAnadirEq.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntAnadirEq.setBounds(474, 450, 150, 34);
		rightPanelAddEd.add(bntAnadirEq);

		JLabel lblLogo = new JLabel("Logo equipo : ");
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogo.setBounds(53, 301, 132, 34);
		rightPanelAddEd.add(lblLogo);

		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpload.setBounds(223, 300, 250, 34);
		btnUpload.addActionListener(this);
		rightPanelAddEd.add(btnUpload);

		lblEquipoLogo = new JLabel("");
		lblEquipoLogo.setBounds(53, 361, 200, 200);
		rightPanelAddEd.add(lblEquipoLogo);

		lblNombreDelEstadio = new JLabel("Nombre del Estadio:");
		lblNombreDelEstadio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelEstadio.setBounds(53, 153, 160, 34);
		rightPanelAddEd.add(lblNombreDelEstadio);

		labelError=new JLabel("");
		labelError.setVisible(false);
		rightPanelAddEd.add(labelError);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// left menu buttons
		if (e.getSource() == btnCrearPartido) {
			CrearPartido crearPartido = new CrearPartido(controller);
			this.dispose();
			crearPartido.setVisible(true);
		} else if (e.getSource() == btnModificarPartido) {
			ModificarPartido modificarPartido = new ModificarPartido(controller);
			this.dispose();
			modificarPartido.setVisible(true);

		} else if (e.getSource() == btnGestionarEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			this.dispose();
			gestionarEntre.setVisible(true);
		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		} else if (e.getSource() == btnModificar) {
			this.dispose();
			ModificarEquipos modificarEquipos = new ModificarEquipos(controller);
			modificarEquipos.setVisible(true);
		}

		if (o == btnUpload) {

			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				if (selectedFile != null) {
					try {
						Path imagePath = selectedFile.toPath();
						byte[] imageData = Files.readAllBytes(imagePath);
						imageBlob = new javax.sql.rowset.serial.SerialBlob(imageData);
						imageIcon = new ImageIcon(imageData);
						lblEquipoLogo.setIcon(imageIcon);
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {

				}
			}

		} else if (o == bntAnadirEq) {
			try {

				if (controller.crearEquipo(nombreEquipoField.getText(), Integer.valueOf(txttitulosField.getText()),
						nombreEstadioField.getText(), imageBlob)) {
					int opcion = JOptionPane.showConfirmDialog(this,
							"El equipo ha sido introducido correctamente\n¿Desea añadir otro equipo?", "",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
					if (opcion == JOptionPane.NO_OPTION) {
						this.dispose();
						MenuAdmin ma = new MenuAdmin(controller);
						ma.setVisible(true);
					}
				} else {
					labelError.setVisible(true);
					labelError.setText("Error! El equipo introducido ya existe");
					labelError.setFont(new Font("Tahoma", Font.BOLD, 14));
					labelError.setBounds(200, 400, 550, 30);
					labelError.setForeground(Color.RED);
					rightPanelAddEd.revalidate();
					rightPanelAddEd.repaint();
				}
			} catch (NumberFormatException e1) {
				labelError.setVisible(true);
				labelError.setText("Error! Tienes que llenar todos los parámetros");
				labelError.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelError.setBounds(200, 400, 550, 30);
				labelError.setForeground(Color.RED);

				rightPanelAddEd.revalidate();
				rightPanelAddEd.repaint();
			}

		}
	}
=======

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class MenuAdmin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JButton btnLogOut;
	private JButton btnModificarPartido;
	private JLabel lblWelcome;
	private JButton btnConsultarPartidos;
	private JButton btnCrearPartido;
	private String userName;
	private JPanel rightPanelAddEd;
	private JTextField nombreEquipoField;
	private JTextField nombreEstadioField;
	private JTextField txttitulosField;
	private JButton bntAnadirEq;
	private JButton btnAddEquipo;
	private JButton btnModificar;
	private JButton btnUpload;
	private JLabel lblEquipoLogo;
	private ImageIcon imageIcon;
	private Blob imageBlob;
	private JLabel lblNombreDelEstadio;
	private JPanel topMenuPanelAddEq;
	private JButton btnGestionarEntrenador;
	private JLabel labelError;

	public MenuAdmin(Controller controller) {
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		rightPanelAddEd = new JPanel();
		rightPanelAddEd.setBounds(310, 73, 674, 597);
		contentPane.add(rightPanelAddEd);
		rightPanelAddEd.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(242, 45, 45));
		panelLeft.setBounds(0, 0, 300, 680);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(50, 70, 90));
			}
		});
		btnLogOut.setBackground(new Color(242, 45, 45));
		btnLogOut.setBounds(37, 595, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogOut.setForeground(Color.WHITE);

		btnModificarPartido = new JButton("     Modificar partido");
		btnModificarPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPartido.setFocusable(false);
		btnModificarPartido.setBorder(null);
		btnModificarPartido.setBackground(new Color(242, 45, 45));
		btnModificarPartido.setBounds(37, 440, 200, 49);
		btnModificarPartido.addActionListener(this);
		btnModificarPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnModificarPartido.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnModificarPartido);
		btnModificarPartido.setForeground(Color.WHITE);

		lblWelcome = new JLabel("   Welcome Admin");
		lblWelcome.setBackground(new Color(0, 0, 0));
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(37, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Gestionar equipo");
		btnConsultarPartidos.setEnabled(false);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(255, 128, 64));
		btnConsultarPartidos.setBounds(37, 385, 200, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnConsultarPartidos);
		btnConsultarPartidos.setForeground(Color.BLACK);

		btnCrearPartido = new JButton("     Crear partido");
		btnCrearPartido.addActionListener(this);
		btnCrearPartido.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearPartido.setFocusable(false);
		btnCrearPartido.setBorder(null);
		btnCrearPartido.setBackground(new Color(242, 45, 45));
		btnCrearPartido.setBounds(37, 330, 200, 49);
		btnCrearPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCrearPartido.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnCrearPartido);
		btnCrearPartido.setForeground(Color.WHITE);

		btnGestionarEntrenador = new JButton("     Gestionar entrenador");
		btnGestionarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarEntrenador.setFocusable(false);
		btnGestionarEntrenador.setBorder(null);
		btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
		btnGestionarEntrenador.setBounds(37, 275, 200, 49);
		btnGestionarEntrenador.addActionListener(this);
		btnGestionarEntrenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(242, 45, 45));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnGestionarEntrenador.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnGestionarEntrenador);
		btnGestionarEntrenador.setForeground(Color.WHITE);

		topMenuPanelAddEq = new JPanel();
		topMenuPanelAddEq.setBounds(310, 10, 674, 58);
		contentPane.add(topMenuPanelAddEq);
		topMenuPanelAddEq.setLayout(null);

		btnAddEquipo = new JButton("Añadir equipo");
		btnAddEquipo.setBackground(new Color(255, 128, 64));
		btnAddEquipo.setFocusable(false);
		btnAddEquipo.setBorder(null);
		btnAddEquipo.setBounds(74, 10, 150, 34);
		topMenuPanelAddEq.add(btnAddEquipo);

		btnModificar = new JButton("Modificar  equipo");
		btnModificar.setBackground(SystemColor.menu);
		btnModificar.addActionListener(this);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(null);
		btnModificar.setBounds(248, 10, 150, 34);
		topMenuPanelAddEq.add(btnModificar);

		// right panel
		JLabel lblNombreEquipo = new JLabel("Nombre del Equipo:");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEquipo.setBounds(53, 75, 160, 34);
		rightPanelAddEd.add(lblNombreEquipo);

		nombreEquipoField = new JTextField();
		nombreEquipoField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEquipoField.setBounds(223, 75, 250, 34);
		rightPanelAddEd.add(nombreEquipoField);

		nombreEstadioField = new JTextField();
		nombreEstadioField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEstadioField.setBounds(223, 150, 250, 34);
		rightPanelAddEd.add(nombreEstadioField);

		JLabel lblTitulos = new JLabel("Número de Títulos:");
		lblTitulos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulos.setBounds(53, 225, 145, 34);
		rightPanelAddEd.add(lblTitulos);

		txttitulosField = new JTextField();
		txttitulosField.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttitulosField.setBounds(223, 225, 250, 34);
		rightPanelAddEd.add(txttitulosField);

		bntAnadirEq = new JButton("Añadir Equipo");
		bntAnadirEq.addActionListener(this);
		bntAnadirEq.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntAnadirEq.setBounds(474, 450, 150, 34);
		rightPanelAddEd.add(bntAnadirEq);

		JLabel lblLogo = new JLabel("Logo equipo : ");
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogo.setBounds(53, 301, 132, 34);
		rightPanelAddEd.add(lblLogo);

		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpload.setBounds(223, 300, 250, 34);
		btnUpload.addActionListener(this);
		rightPanelAddEd.add(btnUpload);

		lblEquipoLogo = new JLabel("");
		lblEquipoLogo.setBounds(53, 361, 200, 200);
		rightPanelAddEd.add(lblEquipoLogo);

		lblNombreDelEstadio = new JLabel("Nombre del Estadio:");
		lblNombreDelEstadio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelEstadio.setBounds(53, 153, 160, 34);
		rightPanelAddEd.add(lblNombreDelEstadio);

		labelError=new JLabel("");
		labelError.setVisible(false);
		rightPanelAddEd.add(labelError);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// left menu buttons
		if (e.getSource() == btnCrearPartido) {
			CrearPartido crearPartido = new CrearPartido(controller);
			this.dispose();
			crearPartido.setVisible(true);
		} else if (e.getSource() == btnModificarPartido) {
			ModificarPartido modificarPartido = new ModificarPartido(controller);
			this.dispose();
			modificarPartido.setVisible(true);

		} else if (e.getSource() == btnGestionarEntrenador) {
			GestionarEntre gestionarEntre = new GestionarEntre(controller);
			this.dispose();
			gestionarEntre.setVisible(true);
		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		} else if (e.getSource() == btnModificar) {
			this.dispose();
			ModificarEquipos modificarEquipos = new ModificarEquipos(controller);
			modificarEquipos.setVisible(true);
		}

		if (o == btnUpload) {

			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				if (selectedFile != null) {
					try {
						Path imagePath = selectedFile.toPath();
						byte[] imageData = Files.readAllBytes(imagePath);
						imageBlob = new javax.sql.rowset.serial.SerialBlob(imageData);
						imageIcon = new ImageIcon(imageData);
						lblEquipoLogo.setIcon(imageIcon);
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {

				}
			}

		} else if (o == bntAnadirEq) {
			try {

				if (controller.crearEquipo(nombreEquipoField.getText(), Integer.valueOf(txttitulosField.getText()),
						nombreEstadioField.getText(), imageBlob)) {
					int opcion = JOptionPane.showConfirmDialog(this,
							"El equipo ha sido introducido correctamente\n¿Desea añadir otro equipo?", "",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
					if (opcion == JOptionPane.NO_OPTION) {
						this.dispose();
						MenuAdmin ma = new MenuAdmin(controller);
						ma.setVisible(true);
					}
				} else {
					labelError.setVisible(true);
					labelError.setText("Error! El equipo introducido ya existe");
					labelError.setFont(new Font("Tahoma", Font.BOLD, 14));
					labelError.setBounds(200, 400, 550, 30);
					labelError.setForeground(Color.RED);
					rightPanelAddEd.revalidate();
					rightPanelAddEd.repaint();
				}
			} catch (NumberFormatException e1) {
				labelError.setVisible(true);
				labelError.setText("Error! Tienes que llenar todos los parámetros");
				labelError.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelError.setBounds(200, 400, 550, 30);
				labelError.setForeground(Color.RED);

				rightPanelAddEd.revalidate();
				rightPanelAddEd.repaint();
			}

		}
	}
>>>>>>> c027c9284a54636c2c83b8c9c4e557de6dbb2f7d
}