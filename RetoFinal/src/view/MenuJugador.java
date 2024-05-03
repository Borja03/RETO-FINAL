
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.equipos.Equipo;
import model.usuarios.Jugador;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class MenuJugador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogOut;
	private JButton btnCambiarCont;
	private JButton btnCambiarDorsal;
	private Controller controller;
	private JLabel lblWelcome;
	private String userName;
	private JButton btnConsultarPartidos;
	private JButton btnConsultarEquipo;
	private JTextField txtEqNombre;
	private JTextField txtEqEstadio;
	private JTextField txtEqTitulos;
	private JTextField txtEqPrimerEntre;
	private JTextField txtEqSegundoEntre;
	private JTable table;
	private JScrollPane scrollPane_1;
	private String nombreEquipo;
	private Blob teamLogo;
	private String userType;

	private JLabel lblJugadoresLista;
	private JLabel lblUserPic;
	private JLabel lblBtnAddPic;

	private ImageIcon imageIcon;
	private Blob usrBlobIcon;
	private JButton btnUpload;
	
	
	public MenuJugador(Controller cont, String userConnected,String userType) {

		this.controller = cont;
		this.userName = userConnected;
		this.userType = userType;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1366, 768);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLefts = new JPanel();
		panelLefts.setBounds(0, 0, 250, 680);
		panelLefts.setBackground(new Color(32, 206, 36));
		contentPane.add(panelLefts);

		btnLogOut = new JButton("     Log Out");
		btnLogOut.setBounds(0, 546, 250, 49);
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

		lblBtnAddPic = new JLabel();
		lblBtnAddPic.setBounds(191, 158, 50, 50);
		lblBtnAddPic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userUploadImgDialog();

			}
		});

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/icons/add.png"));
		Image imageUser = imgIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		panelLefts.setLayout(null);
		lblBtnAddPic.setForeground(SystemColor.activeCaption);
		panelLefts.add(lblBtnAddPic);
		lblBtnAddPic.setIcon(new ImageIcon(imageUser));

		lblUserPic = new JLabel();
		lblUserPic.setBounds(54, 33, 150, 150);
		lblUserPic.setBackground(SystemColor.activeCaption);
		lblUserPic.setForeground(SystemColor.activeCaption);
		panelLefts.add(lblUserPic);
		btnLogOut.setBackground(new Color(32, 206, 36));
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		panelLefts.add(btnLogOut);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCambiarCont = new JButton("     Cambiar Contraseña");
		btnCambiarCont.setBounds(0, 476, 250, 49);
		btnCambiarCont.addActionListener(this);
		btnCambiarCont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarCont.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarCont.setFocusable(false);
		btnCambiarCont.setBorder(null);
		btnCambiarCont.setBackground(new Color(32, 206, 36));
		panelLefts.add(btnCambiarCont);

		btnCambiarDorsal = new JButton("     Cambiar Dorsal");
		btnCambiarDorsal.setBounds(0, 406, 250, 49);
		btnCambiarDorsal.addActionListener(this);
		btnCambiarDorsal.setHorizontalAlignment(SwingConstants.LEFT);
		btnCambiarDorsal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCambiarDorsal.setFocusable(false);
		btnCambiarDorsal.setBorder(null);
		btnCambiarDorsal.setBackground(new Color(32, 206, 36));
		panelLefts.add(btnCambiarDorsal);
		

		lblWelcome = new JLabel("     Welcome " + userName);
		lblWelcome.setBounds(10, 228, 217, 34);
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLefts.add(lblWelcome);

		btnConsultarPartidos = new JButton("     Consultar Partidos");
		btnConsultarPartidos.setBounds(0, 338, 250, 49);
		btnConsultarPartidos.addActionListener(this);
		btnConsultarPartidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarPartidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPartidos.setFocusable(false);
		btnConsultarPartidos.setBorder(null);
		btnConsultarPartidos.setBackground(new Color(32, 206, 36));
		panelLefts.add(btnConsultarPartidos);

		btnConsultarEquipo = new JButton("     Consultar Equipo");
		btnConsultarEquipo.setBounds(0, 271, 250, 49);
		btnConsultarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultarEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarEquipo.setFocusable(false);
		btnConsultarEquipo.setBorder(null);
		btnConsultarEquipo.setBackground(new Color(255, 128, 64));
		panelLefts.add(btnConsultarEquipo);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(281, 10, 703, 178);
		panel.setForeground(new Color(255, 128, 64));
		panel.setBackground(SystemColor.menu);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(204, 39, 82, 22);
		panel.add(lblNombre);

		JLabel lblNewLabel = new JLabel("Equipo info");
		lblNewLabel.setBounds(286, 10, 104, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);

		JLabel lblEqEstadio = new JLabel("Estadio :");
		lblEqEstadio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEqEstadio.setBounds(204, 67, 82, 22);
		panel.add(lblEqEstadio);

		JLabel lblTitulos = new JLabel("Titulos :");
		lblTitulos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulos.setBounds(204, 93, 82, 22);
		panel.add(lblTitulos);

		JLabel lblPrimerEntrenador = new JLabel("Primer entrenador :");
		lblPrimerEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrimerEntrenador.setBounds(204, 116, 162, 22);
		panel.add(lblPrimerEntrenador);

		JLabel lblSegundoEntrenador = new JLabel("Segundo entrenador :");
		lblSegundoEntrenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSegundoEntrenador.setBounds(204, 145, 162, 22);
		panel.add(lblSegundoEntrenador);

		txtEqNombre = new JTextField();
		txtEqNombre.setBounds(368, 40, 254, 25);
		panel.add(txtEqNombre);
		txtEqNombre.setEditable(false);
		txtEqNombre.setColumns(10);

		txtEqEstadio = new JTextField();
		txtEqEstadio.setColumns(10);
		txtEqEstadio.setBounds(368, 68, 254, 25);
		txtEqEstadio.setEditable(false);
		panel.add(txtEqEstadio);

		txtEqTitulos = new JTextField();
		txtEqTitulos.setColumns(10);
		txtEqTitulos.setBounds(368, 94, 254, 25);
		txtEqTitulos.setEditable(false);
		panel.add(txtEqTitulos);

		txtEqPrimerEntre = new JTextField();
		txtEqPrimerEntre.setColumns(10);
		txtEqPrimerEntre.setBounds(368, 120, 254, 25);
		txtEqPrimerEntre.setEditable(false);
		panel.add(txtEqPrimerEntre);

		txtEqSegundoEntre = new JTextField();
		txtEqSegundoEntre.setEditable(false);
		txtEqSegundoEntre.setColumns(10);
		txtEqSegundoEntre.setBounds(368, 149, 254, 25);
		panel.add(txtEqSegundoEntre);
		JLabel lblEqLogo = new JLabel();

		nombreEquipo = controller.getMyTeam(userName, "jugador");
		teamLogo = controller.getEquipo(nombreEquipo).getLogo();
		if (teamLogo != null) {
			try {
				byte[] imageData = teamLogo.getBytes(1, (int) teamLogo.length());
				if (imageData != null && imageData.length > 0) {
					ImageIcon icon = new ImageIcon(imageData);
					Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
					ImageIcon scaledIcon = new ImageIcon(image);
					lblEqLogo.setIcon(scaledIcon);
				}
			} catch (SQLException e) {
				System.err.println("Error reading image data from Blob: " + e.getMessage());
				e.printStackTrace();
			}
		}

		lblEqLogo.setBounds(22, 10, 150, 150);
		panel.add(lblEqLogo);


		ArrayList<Jugador> dataList = controller.getJugadoresPorEquipo(nombreEquipo);

		String[] columnNames = { "Nombre", "Dorsal", "Goles", "Asistencias" };
		Object[][] data = new Object[dataList.size()][4];

		for (int i = 0; i < dataList.size(); i++) {
			Jugador obj = dataList.get(i);
			data[i][0] = obj.getUser();
			data[i][1] = obj.getDorsal();
			data[i][2] = obj.getGoles();
			data[i][3] = obj.getAsistencias();
			
		}

		for (Jugador jug : dataList) {
			if (userName.equals(jug.getUser())) {
				if (jug.getPicProfile() != null) {
					try {
						byte[] imageData = jug.getPicProfile().getBytes(1, (int) jug.getPicProfile().length());
						if (imageData != null && imageData.length > 0) {
							ImageIcon icon2 = new ImageIcon(imageData);
							Image image2 = icon2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
							ImageIcon scaledIcon2 = new ImageIcon(image2);
							lblUserPic.setIcon(scaledIcon2);
						}
					} catch (SQLException e) {
						System.err.println("Error reading image data from Blob: " + e.getMessage());
						e.printStackTrace();
					}
				}
			}

		}

		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 235, 703, 435);
		contentPane.add(scrollPane_1);

		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane_1.setColumnHeaderView(scrollPane);

		lblJugadoresLista = new JLabel("Jugadores lista :");
		lblJugadoresLista.setBounds(535, 203, 191, 22);
		lblJugadoresLista.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblJugadoresLista);

		this.setVisible(true);

		fillEquipoInfo();
		fillEntrenadoresInfo();
	}

	public void fillEquipoInfo() {
		nombreEquipo = controller.getMyTeam(userName, userType);
		Equipo eq = controller.getEquipo(nombreEquipo);
		txtEqNombre.setText(eq.getNombreEquipo());
		txtEqEstadio.setText(eq.getEstadio());
		txtEqTitulos.setText(eq.getTitulos() + "");
	}

	public void fillEntrenadoresInfo() {
		String primEntrenador = controller.getPrimEntrenador(nombreEquipo);
		String segEntrenador = controller.getSegEntrenador(nombreEquipo);

		txtEqPrimerEntre.setText(primEntrenador);
		txtEqSegundoEntre.setText(segEntrenador);
	}

	private void userUploadImgDialog() {
		btnUpload = new JButton("Upload Image");
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					if (selectedFile != null) {
						try {
							Path imagePath = selectedFile.toPath();
							byte[] imageData = Files.readAllBytes(imagePath);
							usrBlobIcon = new javax.sql.rowset.serial.SerialBlob(imageData);
							imageIcon = new ImageIcon(imageData);
							lblUserPic.setIcon(imageIcon);

							if (controller.updateUsrIcon(userName, usrBlobIcon, userType)) {
								JOptionPane.showMessageDialog(MenuJugador.this, "Image uploaded to database!",
										"Success", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(MenuJugador.this, "Failed to upload image to database!",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (SerialException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						//
					}
				}
			}
		});

		JOptionPane.showMessageDialog(this, btnUpload, "Upload Image", JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();


			if (o == btnLogOut) {
				controller.logOut();
				this.dispose();
			} else if (o == btnCambiarDorsal) {
				CambiarDorsal ventanaDorsal = new CambiarDorsal(controller, userName,userType);
				ventanaDorsal.setVisible(true);
				this.setVisible(false);
			} else if (o == btnConsultarPartidos) {
				ConsultarPartidos consultarPartidos = new ConsultarPartidos(controller, userName, userType);
				consultarPartidos.setVisible(true);
				this.dispose();

			} else if (o == btnCambiarCont) {
				CambiarContra ventanaCont = new CambiarContra(controller, userName, userType);
				ventanaCont.setVisible(true);
				this.dispose();
			}

		}
	
}
