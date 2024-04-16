
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.equipos.Equipo;

import model.usuarios.Jugador;
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

	final String INNSERTjugador = "INSERT INTO jugador (user,password,dorsal,numeroGoles,numeroAsistencias,nombreEquipo) VALUES (?,?,?,?,?,?)";
	final String GETjugador = "SELECT * FROM jugador WHERE user = ?";
	final String DELETEjugador = "DELETE FROM jugador WHERE user =?";
	final String MODIFICARjugador = "UPDATE jugador SET password=?, dorsal=?,numeroGoles=?, numeroAsistencias=? WHERE user=?";

	final String ConnectUser = "SELECT * FROM  laliga WHERE user_name =? AND password=?";

	final String ALLequipos = "SELECT nombreEquipo FROM  equipo";
	final String ENTRENADORequipo = "SELECT nombreEquipo FROM  entrenador where user=?";

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
	public void crearEquipo() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean crearEntrenador(String nombreEquipo, String user, String password, String tipoEntrenador) {
		boolean added = false;
		this.openConnection("admin", "admin");
		try {
			statement = connection.prepareStatement(INNSERTentrenador);

			statement.setString(1, user);
			statement.setString(2, password);
			statement.setString(3, tipoEntrenador);
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
	public void crearPartido() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean crearJugador(String user, String password, int dorsal, int numeroGoles, int numeroAsistencias,
			String nombreEquipo) {
		boolean added = false;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(INNSERTjugador);
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
			if (added) {

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
	public void borrarEntrenador() {
		// TODO Auto-generated method stub

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
	public void modificarEntrenador() {
		// TODO Auto-generated method stub

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

	@Override
	public void modificarPartido() {
		// TODO Auto-generated method stub

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
		this.openConnection("jugador", "jugador");
		try {

			Usuarios usuario = this.getUsuario(user);
			if (usuario != null && usuario instanceof Jugador) {
				Jugador jugador = (Jugador) usuario;

				statement = connection.prepareStatement(MODIFICARjugador);
				statement.setString(1, ((Usuarios) jugador).getContraseña());
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

			} else {
				System.out.println("El usuario no es un jugador o no existe");
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return modified;
	}

	public boolean existeDorsal(int dorsal) {
		boolean exists = false;
		this.openConnection("jugador", "jugador");
		try {
			statement = connection.prepareStatement(GETjugador);
			statement.setInt(1, dorsal);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				exists = true;
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return exists;
	}

	@Override
	public void cambiarPassword() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarPartido() {
		// TODO Auto-generated method stub

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

	public String getMyTeam(String entName) {
		String myTeam = null;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(ENTRENADORequipo);
			statement.setString(1, entName);

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
				usuario = new Jugador(userN, password, nombreEquipo, dorsal, numGoles, numAsistencias);

			}

			// usuario = new Jugador(userN, password, nombreEquipo, dorsal, numGoles,
			// numAsistencias);

			// TODO Auto-generated method stub

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return usuario;

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

}
