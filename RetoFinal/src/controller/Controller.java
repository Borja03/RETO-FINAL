package controller;

import java.security.Timestamp;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.equipos.Equipo;
import model.usuarios.CargoEntrenador;
import model.usuarios.Entrenador;
import model.usuarios.Jugador;
import model.usuarios.Tipo;
import model.usuarios.Usuarios;
import view.CambiarDorsal;
import view.Login;

public class Controller implements IController {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/laliga?serverTimezone=Europe/Madrid&allowPublicKeyRetrieval=true&useSSL=false";
	private String user;
	private String password;

	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;

	final String INNSERTentrenador = "INSERT INTO entrenador (user,password,tipoEntrenador,nombreEquipo) VALUES (?,?,?,?)";
	final String DELETEentrenador = "DELETE FROM entrenador WHERE user =?";

	final String INSERTjugador = "INSERT INTO jugador (user,password,dorsal,numeroGoles,numeroAsistencias,nombreEquipo) VALUES (?,?,?,?,?,?)";
	final String GETjugador = "SELECT * FROM jugador WHERE user = ?";
	final String GETentrenador = "SELECT * FROM entrenador WHERE user = ?";
	final String GETjugadorEquipo = "SELECT * FROM jugador WHERE user = ? AND nombreEquipo= ?";
	final String DELETEjugador = "DELETE FROM jugador WHERE user =?";
	final String MODIFICARjugador = "UPDATE jugador SET password=?, dorsal=?,numeroGoles=?, numeroAsistencias=? WHERE user=?";
	final String MODIFICARentrenador = "UPDATE entrenador SET password=?, user=?,tipoEntrenador=? WHERE user=?";

	final String ConnectUser = "SELECT * FROM  laliga WHERE user_name =? AND password=?";
	final String nombreEquipo = "Select nombreEquipo FROM laliga WHERE user=?";
	final String ALLequipos = "SELECT nombreEquipo FROM  equipo";
	final String ENTRENADORequipo = "SELECT nombreEquipo FROM  entrenador where user=?";
	final String JUGADORDORequipo = "SELECT nombreEquipo FROM  jugador where user=?";
	final String NOMBREequipo = "SELECT * FROM  equipo where nombreEquipo=?";
	final String Partidos = "SELECT nombreEquipoLocal, nombreEquipoVisitante, fechaInicio FROM juegan";
	final String ENTRENADORnombre = "SELECT user FROM  entrenador where nombreEquipo=? and tipoEntrenador=?";
	final String JUGADORESequipo = "SELECT * FROM  jugador where nombreEquipo=?";
	final String DORSALlLista = "SELECT dorsal FROM  jugador where nombreEquipo=?";
	final String INSERTequipo = "INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio ,logo) VALUES (?, ?, ?, ?)";
	final String DELETEequipo = "DELETE FROM equipo WHERE nombreEquipo =?";
	final String MODIFICARequipo = "UPDATE equipo SET titulos=?, nombreEstadio=? , logo=? WHERE nombreEquipo=?";
	final String GETJugadorPassword = "SELECT password FROM  jugador where user=?";
	final String GETEntrenadorPassword = "SELECT password FROM  entrenador where user=?";
	final String MODIFICARuserIcon = "UPDATE jugador SET icon=?  WHERE user = ?";

	public boolean checkUserExist(String user) {
		boolean exist = false;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(GETjugador);

			statement.setString(1, user);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				exist = true;
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return exist;
	}

	public boolean checkUserExist2(String user) {
		boolean exist = false;
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(GETentrenador);

			statement.setString(1, user);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				exist = true;
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return exist;
	}

	@Override
	public void logOut() {
		this.closeConnection();
		Login login = new Login(this);
		login.setVisible(true);

	}

	public void openConnection(String user, String password) {
		try {
			connection = DriverManager.getConnection(DB_URL, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
			System.out.println("Close Connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean logIn(String username, String pass, String userType) {
		String query = "";
		String userDb;
		String passDb;

		if ("Admin".equals(userType)) {
			System.out.println("checking Admin...");
			user = "admin";
			password = "admin";
			openConnection(user, password);
			if (username.equals("admin") && password.equals("admin")) {
				return true;
			}

		} else if ("Entrenador".equals(userType)) {
			System.out.println("checking Entrenador...");
			user = "entrenador";
			password = "entrenador";
			openConnection(user, password);
			query = "SELECT * FROM entrenador WHERE user = ? AND password = ?";
		} else if ("Jugador".equals(userType)) {
			System.out.println("checking Jugador...");
			user = "jugador";
			password = "jugador";
			openConnection(user, password);
			query = "SELECT * FROM jugador WHERE user = ? AND password = ?";
		}

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, pass);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				userDb = resultSet.getString("user");
				passDb = resultSet.getString("password");
				if (userDb.equals(username) && passDb.equals(pass)) {
					return true;
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean crearEntrenador(String nombreEquipo, String user, String password, CargoEntrenador tipoEntrenador) {
		boolean added = false;
		this.openConnection("admin", "admin");

		try {
			statement = connection.prepareStatement(INNSERTentrenador);
			statement.setString(1, user);
			statement.setString(2, password);
			statement.setString(3, tipoEntrenador.getNombre());
			statement.setString(4, nombreEquipo);
			if (statement.executeUpdate() > 0) {
				added = true;
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return added;
	}

	@Override
	public boolean crearPartido(String equipoLocal, String equipoVisitante, java.sql.Timestamp fechaInicio) {
		boolean added = false;
		try {
			openConnection("admin", "admin");

			String insertJueganQuery = "INSERT INTO juegan (nombreEquipoLocal, nombreEquipoVisitante, fechaInicio, resultado) VALUES (?, ?, ?, ?)";
			PreparedStatement insertJueganStatement = connection.prepareStatement(insertJueganQuery);
			insertJueganStatement.setString(1, equipoLocal);
			insertJueganStatement.setString(2, equipoVisitante);
			insertJueganStatement.setTimestamp(3, fechaInicio);
			insertJueganStatement.setString(4, "0-0");

			if (insertJueganStatement.executeUpdate() > 0) {
				added = true;
				System.out.println("Partido creado!");
			} else {
				System.out.println("Fallo al crear el partido en la tabla juegan.");
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return added;
	}

	@Override
	public boolean crearJugador(String user, String password, int dorsal, int numeroGoles, int numeroAsistencias,
			String nombreEquipo) {
		boolean added = false;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(INSERTjugador);
			statement.setString(1, user);
			statement.setString(2, password);
			statement.setInt(3, dorsal);
			statement.setInt(4, numeroGoles);
			statement.setInt(5, numeroAsistencias);
			statement.setString(6, nombreEquipo);
			if (statement.executeUpdate() > 0) {
				added = true;
				System.out.println("Data inserted!");
			} else {
				System.out.println("Failed!");
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return added;
	}

	@Override
	public boolean borrarEntrenador(String user) {
		boolean deleted = false;
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(DELETEentrenador);

			statement.setString(1, user);
			if (statement.executeUpdate() > 0) {
				deleted = true;
				System.out.println("Data inserted!");
			} else {
				System.out.println("Failed!");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return deleted;

	}

	@Override
	public boolean borrarJugador(String user) {
		boolean deleted = false;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(DELETEjugador);

			statement.setString(1, user);
			if (statement.executeUpdate() > 0) {
				deleted = true;
				System.out.println("Data inserted!");
			} else {
				System.out.println("Failed!");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return deleted;
	}

	@Override
	public boolean modificarEntrenador(String user, String password, CargoEntrenador tipoEntrenador) {
		boolean modified = false;
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(MODIFICARentrenador);
			// statement.setString(1, user);
			statement.setString(1, password);
			statement.setString(2, user);
			statement.setString(3, tipoEntrenador.getNombre());
			statement.setString(4, user);

			if (statement.executeUpdate() > 0) {
				modified = true;
				System.out.println("Data inserted!");
			} else {
				System.out.println("Failed!");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return modified;
	}

	@Override
	public boolean modificarJugador(String user, String password, int dorsal, int numGoles, int numAsist) {
		boolean modified = false;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(MODIFICARjugador);
			// statement.setString(1, user);
			statement.setString(1, password);
			statement.setInt(2, dorsal);
			statement.setInt(3, numGoles);
			statement.setInt(4, numAsist);
			statement.setString(5, user);
			if (statement.executeUpdate() > 0) {
				modified = true;
				System.out.println("Data inserted!");
			} else {
				System.out.println("Failed!");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return modified;
	}

	public ArrayList<String> listaPartidos() {
		this.openConnection("admin", "admin");
		ArrayList<String> partidosProgramados = new ArrayList<>();
		try {
			statement = connection.prepareStatement(Partidos);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String local = resultSet.getString("nombreEquipoLocal");
				String visitante = resultSet.getString("nombreEquipoVisitante");
				Date fecha = resultSet.getTimestamp("fechaInicio");
				String partido = local + " VS " + visitante + " fecha: " + fecha.toString();
				partidosProgramados.add(partido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return partidosProgramados;
	}
	 @Override
	    public boolean modificarPartido(String nombrePartido, String nuevoResultado) {
	        boolean updated = false;
	        try {
	            openConnection("admin", "admin");

	            String updatePartidoQuery = "UPDATE juegan SET resultado = ? WHERE nombreEquipoLocal = ? OR nombreEquipoVisitante = ?";
	            PreparedStatement updatePartidoStatement = connection.prepareStatement(updatePartidoQuery);
	            updatePartidoStatement.setString(1, nuevoResultado);
	            updatePartidoStatement.setString(2, nombrePartido);
	            updatePartidoStatement.setString(3, nombrePartido);

	            if (updatePartidoStatement.executeUpdate() > 0) {
	                updated = true;
	                System.out.println("Partido actualizado!");
	            } else {
	                System.out.println("Fallo al actualizar el partido en la tabla juegan.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error de SQL");
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return updated;
	    }

	@Override
	public void consultarEquipo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarDorsal() {
		CambiarDorsal ventanaDorsal = new CambiarDorsal(this, "usuario");
		ventanaDorsal.setVisible(true);
	}

	public boolean modificarJugadorConDorsal(String user, int dorsal) {

		boolean modified = false;
		try {

			Usuarios usuario = this.getUsuario(user);

			Jugador jugador = (Jugador) usuario;
			this.openConnection("jugador", "jugador");
			statement = connection.prepareStatement(MODIFICARjugador);
			statement.setString(1, ((Usuarios) jugador).getContrasenia());
			statement.setInt(2, dorsal);
			statement.setInt(3, jugador.getGoles());
			statement.setInt(4, jugador.getAsistencias());
			statement.setString(5, user);
			if (statement.executeUpdate() > 0) {
				modified = true;

				System.out.println("Dorsal modificado con éxito!");

			} else {
				System.out.println("Error al modificar el dorsal");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return modified;
	}

	public boolean existeDorsal(int dorsal, String user) {
		this.openConnection("jugador", "jugador");
		boolean exists = false;
		try {
			statement = connection.prepareStatement(GETjugador);
			statement.setString(1, user);
			resultSet = statement.executeQuery();
			String nombreEquipo = "";
			if (resultSet.next()) {
				nombreEquipo = resultSet.getString("nombreEquipo");
			}

			statement = connection.prepareStatement("SELECT * FROM jugador WHERE dorsal = ? AND nombreEquipo = ?");
			statement.setInt(1, dorsal);
			statement.setString(2, nombreEquipo);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				exists = true;
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		}
		this.closeConnection();
		return exists;
	}

	@Override
	public boolean cambiarPassword(String user, String newPassword, String userType) {
		boolean changed = false;
		String query = "";
		if ("entrenador".equals(userType)) {
			query = "UPDATE entrenador SET password = ? WHERE user = ?";
		} else if ("jugador".equals(userType)) {
			query = "UPDATE jugador SET password = ? WHERE user = ?";
		}
		openConnection(userType, userType);

		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, newPassword);
			statement.setString(2, user);

			if (statement.executeUpdate() > 0) {
				changed = true;
				System.out.println("Contraseña cambiada exitosamente.");
			} else {
				System.out.println("Error al cambiar la contraseña.");
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return changed;
	}

	public ArrayList<String> getEquipos() {
		ArrayList<String> misEquipos = new ArrayList<>();
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(ALLequipos);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String equipo = resultSet.getString("nombreEquipo");
				misEquipos.add(equipo);
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return misEquipos;
	}

	public String getMyTeam(String userName, String userType) {
		String myTeam = null;
		String query = "";

		if ("entrenador".equals(userType)) {
			query = ENTRENADORequipo;
		} else if ("jugador".equals(userType)) {
			query = JUGADORDORequipo;
		}
		this.openConnection(userType, userType);
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userName);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				myTeam = resultSet.getString("nombreEquipo");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return myTeam;
	}

	public Usuarios getUsuario(String user) {
		Usuarios usuario = null;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(GETjugador);
			statement.setString(1, user);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String userN = resultSet.getString("user");
				String password = resultSet.getString("password");
				String nombreEquipo = resultSet.getString("nombreEquipo");
				int dorsal = resultSet.getInt("dorsal");
				int numGoles = resultSet.getInt("numeroGoles");
				int numAsistencias = resultSet.getInt("numeroAsistencias");
				Blob icon = resultSet.getBlob("icon");
				usuario = new Jugador(userN, password, nombreEquipo, dorsal, numGoles, numAsistencias, icon);

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return usuario;

	}

	public Entrenador getUsuario2(String user) {
		Entrenador entrenador = null;
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(GETentrenador);
			statement.setString(1, user);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String userN = resultSet.getString("user");
				String password = resultSet.getString("password");
				String nombreEquipo = resultSet.getString("nombreEquipo");
				String cargoStr = resultSet.getString("tipoEntrenador");
				String cargoStr1 = resultSet.getString("tipoEntrenador");
				CargoEntrenador cargo = null;
				try {
					cargo = CargoEntrenador.valueOf(cargoStr1.toUpperCase());
				} catch (IllegalArgumentException e) {
					// Manejar el caso en el que el valor de la base de datos no coincide con ningún
					// valor del enum
					System.out.println("Valor de tipoEntrenador no válido: " + cargoStr1);
				}

				entrenador = new Entrenador(userN, userN, password, nombreEquipo, cargo);
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return entrenador;
	}

	@Override
	public ArrayList<Equipo> listarEquiposCP() {
		ArrayList<Equipo> equipos = new ArrayList<>();

		try {
			openConnection("admin", "admin");
			String query = "SELECT * FROM equipo";
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String nombreEquipo = resultSet.getString("nombreEquipo");
				String nombreEstadio = resultSet.getString("nombreEstadio");
				int titulos = resultSet.getInt("titulos");
				Equipo eq = new Equipo(nombreEquipo, nombreEstadio, titulos);
				equipos.add(eq);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection();
		}

		return equipos;
	}

	public Date obtenerFechaPartido(String nombrePartido) {
		Date fechaPartido = null;
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(
					"SELECT fechaInicio FROM juegan WHERE nombreEquipoLocal = ? OR nombreEquipoVisitante = ?");
			statement.setString(1, nombrePartido);
			statement.setString(2, nombrePartido);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				fechaPartido = resultSet.getTimestamp("fechaInicio");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return fechaPartido;
	}

	@Override
	public Equipo getEquipo(String nombreEquipo) {
		Equipo myTeam = null;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(NOMBREequipo);
			statement.setString(1, nombreEquipo);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String nombreEq = resultSet.getString("nombreEquipo");
				String estadio = resultSet.getString("nombreEstadio");
				int titulos = resultSet.getInt("titulos");
				Blob logo = resultSet.getBlob("logo");

				myTeam = new Equipo(nombreEq, estadio, titulos, logo);
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return myTeam;
	}

	public String getPrimEntrenador(String eqName) {
		String entName = null;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(ENTRENADORnombre);
			statement.setString(1, eqName);
			statement.setString(2, "PRIMER_ENTRENADOR");

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				entName = resultSet.getString("user");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return entName;
	}

	@Override
	public String getSegEntrenador(String eqName) {
		String entName = null;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(ENTRENADORnombre);
			statement.setString(1, eqName);
			statement.setString(2, "SEGUNDO_ENTRENADOR");

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				entName = resultSet.getString("user");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return entName;
	}

	@Override
	public ArrayList<Jugador> getJugadoresPorEquipo(String nombreEquipo) {
		ArrayList<Jugador> jugadoresEq = new ArrayList<>();

		try {
			openConnection("entrenador", "entrenador");
			statement = connection.prepareStatement(JUGADORESequipo);
			statement.setString(1, nombreEquipo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String user = resultSet.getString("user");
				String password = resultSet.getString("password");
				String nbEquipo = resultSet.getString("nombreEquipo");
				int dorsal = resultSet.getInt("dorsal");
				int goles = resultSet.getInt("numeroGoles");
				int asistencias = resultSet.getInt("numeroAsistencias");
				Blob picProfile = resultSet.getBlob("icon");

				Jugador jug = new Jugador(user, password, nbEquipo, dorsal, goles, asistencias, picProfile);
				jugadoresEq.add(jug);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection();
		}

		return jugadoresEq;
	}

	@Override
	public ArrayList<Integer> getUsedDorsal(String eqName) {
		ArrayList<Integer> dorsalLista = new ArrayList<>();
		int dorsal;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(DORSALlLista);
			statement.setString(1, eqName);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				dorsal = resultSet.getInt("dorsal");
				dorsalLista.add(dorsal);
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return dorsalLista;
	}

	@Override
	public boolean crearEquipo(String nombreEquipo, int titulos, String nombreEstadio, Blob logo) {
		boolean inserted = false;

		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(INSERTequipo);
			statement.setString(1, nombreEquipo);
			statement.setInt(2, titulos);
			statement.setString(3, nombreEstadio);
			statement.setBlob(4, logo);
			if (statement.executeUpdate() > 0) {
				inserted = true;
				System.out.println("Data inserted!");
			} else {
				System.out.println("Failed!");
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}

		return inserted;

	}

	@Override
	public boolean borrarEquipo(String nombreEquipo) {
		boolean deleted = false;
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(DELETEequipo);

			statement.setString(1, nombreEquipo);
			if (statement.executeUpdate() > 0) {
				deleted = true;
			} else {
				System.out.println("Failed!");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return deleted;

	}

	@Override
	public boolean modificarEquipo(String nombreEquipo, int titulos, String nombreEstadio, Blob logo) {
		boolean modified = false;
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(MODIFICARequipo);
			statement.setInt(1, titulos);
			statement.setString(2, nombreEstadio);
			statement.setBlob(3, logo);
			statement.setString(4, nombreEquipo);

			if (statement.executeUpdate() > 0) {
				modified = true;
				System.out.println("Data inserted!");
			} else {
				System.out.println("Failed!");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return modified;
	}

	@Override
	public void consultarPartido() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getUsuarioPassword(String userName, String userType) {

		String pass = "";
		String query = "";
		if ("entrenador".equals(userType)) {
			query = GETEntrenadorPassword;
		} else if ("jugador".equals(userType)) {
			query = GETJugadorPassword;
		}

		openConnection(userType, userType);

		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userName);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				pass = resultSet.getString("password");
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return pass;
	}

	@Override
	public boolean updateUsrIcon(String user, Blob userIcon, String userType) {

		boolean modified = false;
		this.openConnection(userType, userType);
		try {
			statement = connection.prepareStatement(MODIFICARuserIcon);
			statement.setBlob(1, userIcon);
			statement.setString(2, user);

			if (statement.executeUpdate() > 0) {
				modified = true;
				System.out.println("Data inserted!");
			} else {
				System.out.println("Failed!");
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return modified;
	}
}
