package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.sql.rowset.serial.SerialException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.Blob;
import java.sql.SQLException;
import controller.Controller;
import model.equipos.Equipo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class ModificarEquipos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JButton btnLogOut;
	private JButton btnCambiarCont;
	private JButton btnCambiarDorsal;
	private JLabel lblWelcome;
	private JButton btnConsultarPartidos;
	private JButton btnConsultarEquipo;
	private String userName;
	private JPanel rightPanelAddEd;
	private JTextField nombreEquipoField;
	private JTextField nombreEstadioField;
	private JTextField txttitulosField;
	private JButton bntModificarEq;
	private JButton btnAddEquipo;
	private JButton btnModificar;
	private JButton btnUpload;
	private JLabel lblEqLogo;
	private ImageIcon imageIcon;
	private Blob imageBlob;
	private JLabel lblNombreDelEstadio;
	private JPanel topMenuPanelAddEq;
	private JButton btnBorrarEquipo;
	private JPanel panelSearch;
	private JLabel lblNombreEquipo_1;
	private JComboBox<String> cBoxEquipos;

	public ModificarEquipos(Controller controller) {
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		rightPanelAddEd = new JPanel();
		rightPanelAddEd.setBounds(310, 154, 674, 526);
		contentPane.add(rightPanelAddEd);
		rightPanelAddEd.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(128, 128, 0));
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
				btnLogOut.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnLogOut.setBackground(new Color(50, 70, 90));
			}
		});
		btnLogOut.setBackground(new Color(128, 128, 0));
		btnLogOut.setBounds(37, 595, 200, 49);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLeft.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarCont = new JButton("     Cambiar Contraseña");
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(128, 128, 0));
		btnCambiarCont.setBounds(37, 504, 200, 49);
		panelLeft.add(btnCambiarCont);
		btnCambiarCont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarCont.setBackground(new Color(50, 70, 90));
			}
		});

		btnCambiarDorsal = new JButton("     Modificar partido");
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal.setFocusable(false);
		btnCambiarDorsal.setBorder(null);
		btnCambiarDorsal.setBackground(new Color(128, 128, 0));
		btnCambiarDorsal.setBounds(37, 445, 200, 49);
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnCambiarDorsal.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnCambiarDorsal);

		lblWelcome = new JLabel("Welcome " + userName + "");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(64, 180, 217, 34);
		panelLeft.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Gestionar equipo");
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(255, 128, 64));
		btnConsultarPartidos.setBounds(37, 386, 200, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarPartidos.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnConsultarPartidos);

		btnConsultarEquipo = new JButton("     Crear partido");
		btnConsultarEquipo.addActionListener(this);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(128, 128, 0));
		btnConsultarEquipo.setBounds(37, 327, 200, 49);
		btnConsultarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(90, 70, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(128, 128, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnConsultarEquipo.setBackground(new Color(50, 70, 90));
			}
		});
		panelLeft.add(btnConsultarEquipo);

		JButton btnGestionarJugadores = new JButton("     Gestionar entrenador");
		btnGestionarJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarJugadores.setFocusable(false);
		btnGestionarJugadores.setBorder(null);
		btnGestionarJugadores.setBackground(new Color(128, 128, 0));
		btnGestionarJugadores.setBounds(37, 275, 200, 49);
		panelLeft.add(btnGestionarJugadores);

		// top menu buttons
		topMenuPanelAddEq = new JPanel();
		topMenuPanelAddEq.setBounds(310, 10, 674, 58);
		contentPane.add(topMenuPanelAddEq);
		topMenuPanelAddEq.setLayout(null);

		btnAddEquipo = new JButton("Añadir equipo");
		btnAddEquipo.addActionListener(this);
		btnAddEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEquipo.setBackground(SystemColor.menu);
		btnAddEquipo.setFocusable(false);
		btnAddEquipo.setBorder(null);
		btnAddEquipo.setBounds(74, 10, 150, 34);
		topMenuPanelAddEq.add(btnAddEquipo);

		btnModificar = new JButton("Modificar  Equipo");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificar.setBackground(new Color(255, 128, 64));
		btnModificar.addActionListener(this);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(null);
		btnModificar.setBounds(248, 10, 150, 34);
		topMenuPanelAddEq.add(btnModificar);

		// right panel
		JLabel lblNombreEquipo = new JLabel("Nombre del Equipo:");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEquipo.setBounds(53, 32, 160, 34);
		rightPanelAddEd.add(lblNombreEquipo);

		nombreEquipoField = new JTextField();
		nombreEquipoField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEquipoField.setBounds(223, 32, 250, 34);
		nombreEquipoField.setEditable(false);
		rightPanelAddEd.add(nombreEquipoField);

		nombreEstadioField = new JTextField();
		nombreEstadioField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreEstadioField.setBounds(223, 107, 250, 34);
		rightPanelAddEd.add(nombreEstadioField);

		JLabel lblTitulos = new JLabel("Número de Títulos:");
		lblTitulos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulos.setBounds(53, 182, 145, 34);
		rightPanelAddEd.add(lblTitulos);

		txttitulosField = new JTextField();
		txttitulosField.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttitulosField.setBounds(223, 182, 250, 34);
		rightPanelAddEd.add(txttitulosField);

		bntModificarEq = new JButton("Modificar Equipo");
		bntModificarEq.addActionListener(this);
		bntModificarEq.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntModificarEq.setBounds(280, 440, 160, 34);
		rightPanelAddEd.add(bntModificarEq);

		JLabel lblLogo = new JLabel("Logo equipo : ");
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogo.setBounds(53, 258, 132, 34);
		rightPanelAddEd.add(lblLogo);

		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpload.setBounds(223, 257, 250, 34);
		btnUpload.addActionListener(this);
		rightPanelAddEd.add(btnUpload);

		lblEqLogo = new JLabel("");
		lblEqLogo.setBounds(50, 302, 200, 200);
		rightPanelAddEd.add(lblEqLogo);

		lblNombreDelEstadio = new JLabel("Nombre del Estadio:");
		lblNombreDelEstadio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelEstadio.setBounds(53, 110, 160, 34);
		rightPanelAddEd.add(lblNombreDelEstadio);

		btnBorrarEquipo = new JButton("Borrar Equipo");
		btnBorrarEquipo.addActionListener(this);
		btnBorrarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBorrarEquipo.setBounds(481, 440, 160, 34);
		rightPanelAddEd.add(btnBorrarEquipo);

		panelSearch = new JPanel();
		panelSearch.setBounds(310, 78, 674, 58);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);

		lblNombreEquipo_1 = new JLabel("Nombre del Equipo:");
		lblNombreEquipo_1.setBounds(48, 20, 142, 17);
		lblNombreEquipo_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSearch.add(lblNombreEquipo_1);

		cBoxEquipos = new JComboBox<String>();

		cBoxEquipos.addActionListener(this);
		cBoxEquipos.setBounds(219, 13, 250, 34);
		panelSearch.add(cBoxEquipos);

		fillBoxEqName();
		rightPanelAddEd.setVisible(false);

	}

	public void fillBoxEqName() {
		for (String eqName : controller.getEquipos()) {
			cBoxEquipos.addItem(eqName);
		}
	}
	public void fillDataEquipo(String selectedEquipo) {
	    Equipo eq = controller.getEquipo(selectedEquipo);
	    nombreEquipoField.setText(eq.getNombreEquipo());
	    nombreEstadioField.setText(eq.getEstadio());
	    txttitulosField.setText(eq.getTitulos() + "");

	    Blob imgB = eq.getLogo();
	    if (imgB != null) {
	        try {
	            byte[] imageData = imgB.getBytes(1, (int) imgB.length());
	            if (imageData != null && imageData.length > 0) {
	                ImageIcon icon = new ImageIcon(imageData);
	                Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	                ImageIcon scaledIcon = new ImageIcon(image);
	                lblEqLogo.setIcon(scaledIcon);
	            } 
	        } catch (SQLException e) {
	            System.err.println("Error reading image data from Blob: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }   
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// left menu buttons
		if (e.getSource() == btnConsultarEquipo) {
			MenuEntrenador menuEntrenador = new MenuEntrenador(controller, userName);
			this.dispose();
			// menuEntrenador.setVisible(true);
		} else if (e.getSource() == btnConsultarPartidos) {
			ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName);
			this.dispose();
			// consultarPartidos.setVisible(true);
		} else if (e.getSource() == btnCambiarDorsal) {
			CambiarDorsal cambiarDorsal = new CambiarDorsal(controller, userName);
			this.dispose();
			cambiarDorsal.setVisible(true);

		} else if (e.getSource() == btnLogOut) {
			this.dispose();
			controller.logOut();
		}
		// right panel buttons
		if (o == cBoxEquipos) {

			fillDataEquipo((String) cBoxEquipos.getSelectedItem());
			rightPanelAddEd.setVisible(true);
		}
		if(o==btnBorrarEquipo) {
			if(controller.borrarEquipo(nombreEquipoField.getText())) {
				this.dispose();
				ModificarEquipos modificarEquipos = new ModificarEquipos(controller);
				modificarEquipos.setVisible(true);
			}
		}

		// top paenel buttons
		if (o == btnAddEquipo) {
			CrearEquipo crearEquipo = new CrearEquipo(controller);
			this.dispose();

			crearEquipo.setVisible(true);
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
						lblEqLogo.setIcon(imageIcon);

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
					// Handle case where user cancels selection (e.g., show a message)
				}
			}

		} else if (o == bntModificarEq) {
			if (controller.modificarEquipo(nombreEquipoField.getText(), Integer.valueOf(txttitulosField.getText()),
					nombreEstadioField.getText(), imageBlob)) {
				int opcion = JOptionPane.showConfirmDialog(this,
						(String) "El equipo ha sido introducido correctamente\n¿Desea añadir otro equipo?", "",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				if (opcion == JOptionPane.NO_OPTION) {
					this.dispose();
					MenuAdmin ma = new MenuAdmin(controller);
					ma.setVisible(true);
				}

			}
		}
	}

}
