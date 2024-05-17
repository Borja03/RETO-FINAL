package controller;

import java.time.LocalDateTime;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import model.equipos.Equipo;
import model.partido.Juegan;
import model.usuarios.CargoEntrenador;
import model.usuarios.Entrenador;
import model.usuarios.Jugador;
import model.usuarios.Usuarios;
import utlidades.MySqlConnection;
import view.CambiarDorsal;
import view.Login;

/**
 * This class implements the business logic for managing users, including
 * authentication, user creation, logging out, and various database operations
 * related to users such as creating trainers, checking user existence, and
 * logging in.
 * 
 * @implements IController
 */
public class Controller implements IController {

	private String user;
	private String password;

	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private CallableStatement callableStatement = null;

	final String ALLequipos = "SELECT nombreEquipo FROM equipo";
	final String ConnectUser = "SELECT * FROM usuario WHERE user = ? AND password = ?";
	final String DELETEentrenador = "DELETE FROM entrenador WHERE user = ?";
	final String DELETEentrenadorUsuario = "DELETE FROM usuario WHERE user = ?";
	final String DELETEequipo = "DELETE FROM equipo WHERE nombreEquipo = ?";
	final String DELETEjugador = "DELETE FROM jugador WHERE user = ?";
	final String DORSALlLista = "SELECT dorsal FROM jugador where nombreEquipo = ?";
	final String ENTRENADORequipo = "SELECT nombreEquipo FROM entrenador where user = ?";
	final String ENTRENADORnombre = "SELECT usuario.* FROM entrenador INNER JOIN usuario ON entrenador.user = usuario.user WHERE entrenador.nombreEquipo = ? AND entrenador.tipoEntrenador = ?";
	final String GETentrenador = "SELECT entrenador.user, entrenador.nombreEquipo,entrenador.tipoEntrenador, usuario.password, usuario.tipo, usuario.icon FROM entrenador INNER JOIN usuario ON entrenador.user = usuario.user WHERE usuario.user = ?";
	final String GETEntrenadorPassword = "SELECT usuario.password FROM entrenador INNER JOIN usuario ON entrenador.user = usuario.user WHERE entrenador.user = ?";
	final String GETjugador = "SELECT jugador.*, usuario.password, usuario.tipo FROM jugador INNER JOIN usuario ON jugador.user = usuario.user WHERE usuario.user = ?";
	final String GETJugadorPassword = "SELECT usuario.password FROM jugador INNER JOIN usuario ON jugador.user = usuario.user WHERE jugador.user = ?";
	final String GETjugadorEquipo = "SELECT jugador.*, usuario.password, usuario.tipo FROM jugador INNER JOIN usuario ON jugador.user = usuario.user WHERE jugador.user = ? AND jugador.nombreEquipo = ?";
	final String INSERTequipo = "INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio, logo) VALUES (?, ?, ?, ?)";
	final String INSERTjugador = "INSERT INTO jugador (user, dorsal, numeroGoles, numeroAsistencias, nombreEquipo) VALUES (?, ?, ?, ?, ?)";
	final String INNSERTentrenador = "INSERT INTO entrenador (user, tipoEntrenador, nombreEquipo) VALUES (?, ?, ?)";
	final String JUGADORDORequipo = "SELECT nombreEquipo FROM jugador where user = ?";
<<<<<<< HEAD
	final String JUGADORESequipo = "SELECT jugador.*, usuario.password, usuario.tipo FROM jugador INNER JOIN usuario ON jugador.user = usuario.user WHERE jugador.nombreEquipo = ?";
=======
	final String JUGADORESequipo = "SELECT j.user, j.nombreEquipo, j.dorsal, j.numeroGoles, j.numeroAsistencias, u.icon FROM jugador j INNER JOIN usuario u ON j.user = u.user WHERE j.nombreEquipo = ?";

>>>>>>> 0feb09236e8ddaa1aa4d77aa78f121d58e189e72
	final String MODIFICARentrenadorUsuario = "UPDATE usuario SET password = ? WHERE user = ?";
	final String MODIFICARentrenador = "UPDATE entrenador SET tipoEntrenador = ? WHERE user = ?";
	final String MODIFICARjugador = "UPDATE jugador SET dorsal = ?, numeroGoles = ?, numeroAsistencias = ? WHERE user = ?";
	final String MODIFICARpartidoFecha = "UPDATE juegan SET fechaInicio = ? WHERE fechaInicio = ?";
	final String MODIFICARpartidoResultado = "UPDATE juegan SET resultado = ? WHERE fechaInicio = ?";
	final String MODIFICARequipo = "UPDATE equipo SET titulos = ?, nombreEstadio = ?, logo = ? WHERE nombreEquipo = ?";
	final String modificarPartidoFecha = "UPDATE juegan SET fechaInicio = ? WHERE fechaInicio = ?";
	final String modificarPartidoResultado = "UPDATE juegan SET resultado = ? WHERE fechaInicio = ?";
	final String MODIFICARuserIcon = "UPDATE usuario SET icon = ?  WHERE user = ?";
	final String NOMBREequipo = "SELECT * FROM equipo where nombreEquipo = ?";
	final String nombreEquipo = "SELECT nombreEquipo FROM usuario WHERE user = ?";
	final String NOMBREequipoE = "SELECT nombreEquipo FROM entrenador WHERE user = ?";
	final String nombreEstadio = "SELECT nombreEstadio FROM equipo WHERE nombreEquipo = ?";
	final String Partidos = "SELECT nombreEquipoLocal, nombreEquipoVisitante, fechaInicio, resultado FROM juegan";
	final String CONSULTARequipo = "SELECT * FROM juegan WHERE nombreEquipoLocal = ? OR nombreEquipoVisitante = ?";

	final String INSERTjugadorUser = "INSERT INTO usuario (user, password) VALUES (?, ?)";
	final String INNSERTentrenadorUser = "INSERT INTO usuario (user, password) VALUES (?, ?)";

	/**
	 * Checks whether a user with the specified username exists in the database.
	 *
	 * @param user The username to check for existence.
	 * @return true if the user exists, otherwise false.
	 * 
	 */
	@Override
	public boolean checkUserExist(String user) {
		boolean exist = false;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return exist;
	}

	/**
	 * Logs out the current user by closing the connection and showing the login
	 * screen.
	 */

	@Override
	public void logOut() {
		this.closeConnection();

		Login login = new Login(this);
		login.setVisible(true);

	}

	/**
	 * Logs in a user with the provided username, password, and user type.
	 *
	 * @param usuario     The username to log in with.
	 * @param contrasena  The password to log in with.
	 * @param tipoUsuario The type of user to log in as.
	 * @return true if the login is successful, otherwise false.
	 * 
	 */
	@Override
	public boolean logIn(String usuario, String contrasena, String tipoUsuario) {
		String userDb;
		String passDb;

		try {
			if ("Admin".equalsIgnoreCase(tipoUsuario)) {
				System.out.println("Comprobando Administrador...");
				user = "admin";
				password = "admin";
				connection = MySqlConnection.getInstance(tipoUsuario.toLowerCase()).getConnection();

				if (usuario.equals("admin") && contrasena.equals("admin")) {
					return true;
				}
			} else if ("Entrenador".equalsIgnoreCase(tipoUsuario) || "Jugador".equalsIgnoreCase(tipoUsuario)) {
				System.out.println("Comprobando " + tipoUsuario + "...");
				user = tipoUsuario.toLowerCase();
				password = tipoUsuario.toLowerCase();
				connection = MySqlConnection.getInstance(tipoUsuario.toLowerCase()).getConnection();
				String query = "SELECT * FROM usuario WHERE user = ? AND password = ?";
				try (PreparedStatement statement = connection.prepareStatement(query)) {
					statement.setString(1, usuario);
					statement.setString(2, contrasena);
					ResultSet resultSet = statement.executeQuery();

					if (resultSet.next()) {
						userDb = resultSet.getString("user");
						passDb = resultSet.getString("password");
						if (userDb.equals(usuario) && passDb.equals(contrasena)) {
							return true;
						}
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				MySqlConnection.getInstance(tipoUsuario.toLowerCase()).getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Creates a new trainer with the specified details and adds them to the
	 * database.
	 *
	 * @param nombreEquipo   The name of the team the trainer belongs to.
	 * @param user           The username of the trainer.
	 * @param password       The password of the trainer.
	 * @param tipoEntrenador The type of trainer (e.g., head coach, assistant
	 *                       coach).
	 * @return true if the trainer is successfully created and added to the
	 *         database, otherwise false.
 *                      fails.
	 * 
	 */
	@Override
	public boolean crearEntrenador(String nombreEquipo, String user, String password, CargoEntrenador tipoEntrenador) {
		boolean added = false;

		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

			statement = connection.prepareStatement(INNSERTentrenadorUser);
			statement.setString(1, user);
			statement.setString(2, password);
			statement.executeUpdate();
			statement = connection.prepareStatement(INNSERTentrenador);
			statement.setString(1, user);
			statement.setString(2, tipoEntrenador.getNombre());
			statement.setString(3, nombreEquipo);
			if (statement.executeUpdate() > 0) {
				added = true;
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return added;
	}

	/**
	 * Creates a new match between the specified local and visiting teams at the
	 * given start time.
	 *
	 * @param equipoLocal     The name of the local team participating in the match.
	 * @param equipoVisitante The name of the visiting team participating in the
	 *                        match.
	 * @param fechaInicio     The start time of the match.
	 * @return true if the match is successfully created and added to the database,
	 *         otherwise false.
	 * 
	 */
	@Override
	public boolean crearPartido(String equipoLocal, String equipoVisitante, java.sql.Timestamp fechaInicio) {
		boolean added = false;
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return added;
	}

	/**
	 * Creates a new player with the specified details and adds them to the
	 * database.
	 *
	 * @param user              The username of the new player.
	 * @param password          The password associated with the player's account.
	 * @param dorsal            The dorsal number of the player.
	 * @param numeroGoles       The number of goals scored by the player.
	 * @param numeroAsistencias The number of assists made by the player.
	 * @param nombreEquipo      The name of the team the player belongs to.
	 * @return true if the player is successfully created and added to the database,
	 *         otherwise false.
	 * 
	 */
	@Override
	public boolean crearJugador(String user, String password, int dorsal, int numeroGoles, int numeroAsistencias,
			String nombreEquipo) {
		boolean added = false;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

			statement = connection.prepareStatement(INSERTjugadorUser);
			statement.setString(1, user);
			statement.setString(2, password);
			statement.executeUpdate();
			statement = connection.prepareStatement(INSERTjugador);
			statement.setString(1, user);
			statement.setInt(2, dorsal);
			statement.setInt(3, numeroGoles);
			statement.setInt(4, numeroAsistencias);
			statement.setString(5, nombreEquipo);
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
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return added;
	}

	/**
	 * Deletes an existing coach from the database based on the provided username.
	 *
	 * @param user The username of the coach to be deleted.
	 * @return true if the coach is successfully deleted from the database,
	 *         otherwise false.
	 */
	@Override
	public boolean borrarEntrenador(String user) {
		boolean deleted = false;
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

			statement = connection.prepareStatement(DELETEentrenadorUsuario);
			statement.setString(1, user);
			statement.executeUpdate();

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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deleted;
	}
	  /**
     * Deletes an existing player from the database based on the provided username.
     *
     * @param user The username of the player to be deleted.
     * @return true if the player is successfully deleted from the database, otherwise false.
     */

	@Override
	public boolean borrarJugador(String user) {
		boolean deleted = false;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return deleted;
	}
	   /**
     * Modifies the details of an existing coach in the database.
     *
     * @param user           The username of the coach to be modified.
     * @param password       The new password for the coach.
     * @param tipoEntrenador The new type of coach (e.g., head coach, assistant coach).
     * @return true if the coach details are successfully modified, otherwise false.
     */
	@Override
	public boolean modificarEntrenador(String user, String password, CargoEntrenador tipoEntrenador) {
		boolean modified = false;
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

			statement = connection.prepareStatement(MODIFICARentrenador);
			statement.setString(1, password);
			statement.setString(2, user);
			statement.executeUpdate();

			statement = connection.prepareStatement(MODIFICARentrenador);
			statement.setString(1, tipoEntrenador.getNombre());
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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return modified;
	}
	   /**
     * Modifies the details of an existing player in the database.
     *
     * @param user     The username of the player to be modified.
     * @param password The new password for the player.
     * @param dorsal   The new dorsal number for the player.
     * @param numGoles The new number of goals scored by the player.
     * @param numAsist The new number of assists made by the player.
     * @return true if the player details are successfully modified, otherwise false.
     */
	@Override
	public boolean modificarJugador(String user, String password, int dorsal, int numGoles, int numAsist) {
		boolean modified = false;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return modified;
	}
    /**
     * Retrieves a list of scheduled matches from the database.
     *
     * @return An ArrayList of Juegan objects representing the scheduled matches.
     */
	@Override
	public ArrayList<Juegan> listaPartidos() {
		ArrayList<Juegan> partidosProgramados = new ArrayList<>();
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

			statement = connection.prepareStatement(Partidos);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String local = resultSet.getString("nombreEquipoLocal");
				String visitante = resultSet.getString("nombreEquipoVisitante");
				java.sql.Timestamp timestamp = resultSet.getTimestamp("fechaInicio");
				LocalDateTime fecha = timestamp.toLocalDateTime();
				String resultado = resultSet.getString("resultado");
				Juegan partido = new Juegan(local, visitante, fecha, resultado);
				partidosProgramados.add(partido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return partidosProgramados;
	}
    /**
     * Modifies a scheduled match in the database.
     *
     * @param partidoModificado The modified match object containing the updated information.
     * @param fechaAntigua      The original start date and time of the match.
     */
	@Override
	public void modificarPartido(Juegan partidoModificado, LocalDateTime fechaAntigua) {
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

			PreparedStatement stmtResultado = connection.prepareStatement(modificarPartidoResultado);
			stmtResultado.setString(1, partidoModificado.getResultado());
			stmtResultado.setObject(2, fechaAntigua);
			stmtResultado.executeUpdate();
			stmtResultado.close();

			PreparedStatement stmtFecha = connection.prepareStatement(modificarPartidoFecha);
			stmtFecha.setObject(1, partidoModificado.getFechaInicio());
			stmtFecha.setObject(2, fechaAntigua);
			stmtFecha.executeUpdate();
			stmtFecha.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
	}
	  /**
     * Opens a dialog window for changing the player's dorsal number.
     * This method displays a window where the user can input a new dorsal number for a player.
     */
	@Override
	public void modificarDorsal() {
		CambiarDorsal ventanaDorsal = new CambiarDorsal(this, "usuario", "jugador");
		ventanaDorsal.setVisible(true);
	}
	   /**
     * Modifies the player's information including the dorsal number.
     *
     * @param user   The username of the player to be modified.
     * @param dorsal The new dorsal number to assign to the player.
     * @return True if the player's information, including the dorsal number, was successfully modified; otherwise, false.

     */
	@Override
	public boolean modificarJugadorConDorsal(String user, int dorsal) {

		boolean modified = false;
		try {

			Usuarios usuario = this.getUsuario(user);

			Jugador jugador = (Jugador) usuario;
			connection = MySqlConnection.getInstance("jugador").getConnection();

			statement = connection.prepareStatement(MODIFICARjugador);
			statement.setInt(1, dorsal);
			statement.setInt(2, jugador.getGoles());
			statement.setInt(3, jugador.getAsistencias());
			statement.setString(4, user);
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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return modified;
	}

	public boolean existeDorsal(int dorsal, String user) {
		boolean exists = false;
		try {
			connection = MySqlConnection.getInstance("jugador").getConnection();

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
		try {
			MySqlConnection.getInstance("jugador").getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		return exists;
	}
	  /**
     * Checks if a given dorsal number exists for a specific player within their team.
     *
     * @param dorsal The dorsal number to check for existence.
     * @param user   The username of the player.
     * @return True if the dorsal number exists for the specified player within their team; otherwise, false.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
	@Override
	public boolean cambiarPassword(String user, String newPassword, String userType) {
		boolean changed = false;
		String query = "";
		query = "UPDATE usuario SET password = ? WHERE user = ?";

		try {
			connection = MySqlConnection.getInstance(userType).getConnection();

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
			try {
				MySqlConnection.getInstance(userType).getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return changed;
	}
	   /**
     * Retrieves a list of all teams from the database.
     *
     * @return An ArrayList containing the names of all teams.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
	@Override
	public ArrayList<String> getEquipos() {
		ArrayList<String> misEquipos = new ArrayList<>();

		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return misEquipos;
	}
	   /**
     * Retrieves the team associated with the given user.
     *
     * @param userName The username of the user.
     * @param userType The type of user ('entrenador' or 'jugador').
     * @return The name of the team associated with the user, or null if no team is found.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
	@Override
	public String getMyTeam(String userName, String userType) {
		String myTeam = null;
		String query = "";

		if ("entrenador".equalsIgnoreCase(userType)) {
			query = ENTRENADORequipo;
		} else if ("jugador".equalsIgnoreCase(userType)) {
			query = JUGADORDORequipo;
		}
		try {
			connection = MySqlConnection.getInstance(userType).getConnection();

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
			try {
				MySqlConnection.getInstance(userType).getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return myTeam;
	}
	   /**
     * Retrieves the user information from the database based on the given username.
     *
     * @param user The username of the user.
     * @return An instance of Usuarios containing the user information, or null if no user is found.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
	@Override
	public Usuarios getUsuario(String user) {
		Usuarios usuario = null;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

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
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return usuario;

	}
	
	   /**
     * Retrieves the user information from the database based on the given username.
     *
     * @param user The username of the user.
     * @return An instance of Entrenador containing the user information, or null if no user is found.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
	public Entrenador getUsuario2(String user) {
		Entrenador entrenador = null;
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

			statement = connection.prepareStatement(GETentrenador);
			statement.setString(1, user);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String userN = resultSet.getString("user");
				String password = resultSet.getString("password");
				String nombreEquipo = resultSet.getString("nombreEquipo");
				String cargoStr = resultSet.getString("tipoEntrenador");
				String cargoStr1 = resultSet.getString("tipoEntrenador");
				Blob profilPic = resultSet.getBlob("icon");

				CargoEntrenador cargo = null;
				try {
					cargo = CargoEntrenador.valueOf(cargoStr1.toUpperCase());
				} catch (IllegalArgumentException e) {
					// Manejar el caso en el que el valor de la base de datos no coincide con ningún
					// valor del enum
					//System.out.println("Valor de tipoEntrenador no válido: " + cargoStr1);
				}

				entrenador = new Entrenador(userN, userN, password, nombreEquipo, cargo,profilPic);
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return entrenador;
	}
    /**
     * Retrieves a list of all teams from the database.
     *
     * @return An ArrayList of Equipo objects containing information about each team.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
	@Override
	public ArrayList<Equipo> listarEquiposCP() {
		ArrayList<Equipo> equipos = new ArrayList<>();

		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}

		return equipos;
	}
    /**
     * Retrieves the date of a specified match from the database.
     *
     * @param nombrePartido The name of the match.
     * @return The date of the specified match, or null if the match is not found.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
	public Date obtenerFechaPartido(String nombrePartido) {
		Date fechaPartido = null;
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

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
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return fechaPartido;
	}
    /**
     * Retrieves information about a specific team from the database.
     *
     * @param nombreEquipo The name of the team to retrieve information for.
     * @return An Equipo object containing information about the specified team, or null if the team is not found.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public Equipo getEquipo(String nombreEquipo) {
		Equipo myTeam = null;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
			try {
				MySqlConnection.getInstance("jugador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return myTeam;
	}
    /**
     * Retrieves the name of the primary coach for a specified team.
     *
     * @param eqName The name of the team.
     * @return The username of the primary coach for the specified team, or null if no primary coach is found.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	public String getPrimEntrenador(String eqName) {
		String entName = null;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

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
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return entName;
	}
    /**
     * Retrieves the name of the secondary coach for a specified team.
     *
     * @param eqName The name of the team.
     * @return The username of the secondary coach for the specified team, or null if no secondary coach is found.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public String getSegEntrenador(String eqName) {
		String entName = null;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

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
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return entName;
	}
    /**
     * Retrieves a list of players belonging to a specified team.
     *
     * @param nombreEquipo The name of the team to retrieve players for.
     * @return An ArrayList of Jugador objects representing the players of the specified team.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public ArrayList<Jugador> getJugadoresPorEquipo(String nombreEquipo) {
		ArrayList<Jugador> jugadoresEq = new ArrayList<>();

		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

			statement = connection.prepareStatement(JUGADORESequipo);
			statement.setString(1, nombreEquipo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String user = resultSet.getString("user");
				//String password = resultSet.getString("password");
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
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return jugadoresEq;
	}
    /**
     * Retrieves a list of used dorsal numbers for a specified team.
     *
     * @param eqName The name of the team to retrieve dorsal numbers for.
     * @return An ArrayList of Integer objects representing the used dorsal numbers for the specified team.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public ArrayList<Integer> getUsedDorsal(String eqName) {
		ArrayList<Integer> dorsalLista = new ArrayList<>();
		int dorsal;
		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

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
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return dorsalLista;
	}
    /**
     * Creates a new team with the provided information.
     *
     * @param nombreEquipo  The name of the new team.
     * @param titulos       The number of titles won by the new team.
     * @param nombreEstadio The name of the stadium of the new team.
     * @param logo          The logo of the new team.
     * @return true if the team was successfully created, false otherwise.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public boolean crearEquipo(String nombreEquipo, int titulos, String nombreEstadio, Blob logo) {
		boolean inserted = false;

		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

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
			return false;
		} finally {
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}

		return inserted;

	}
    /**
     * Deletes the team with the specified name.
     *
     * @param nombreEquipo The name of the team to delete.
     * @return true if the team was successfully deleted, false otherwise.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public boolean borrarEquipo(String nombreEquipo) {
		boolean deleted = false;
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

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
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return deleted;

	}
    /**
     * Modifies the information of an existing team.
     *
     * @param nombreEquipo  The name of the team to modify.
     * @param titulos       The updated number of titles won by the team.
     * @param nombreEstadio The updated name of the stadium of the team.
     * @param logo          The updated logo of the team.
     * @return true if the team information was successfully modified, false otherwise.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public boolean modificarEquipo(String nombreEquipo, int titulos, String nombreEstadio, Blob logo) {
		boolean modified = false;
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

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
			return false;
		} finally {
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return modified;
	}
    /**
     * Retrieves the password of a specified user from the database.
     *
     * @param userName The username of the user whose password to retrieve.
     * @param userType The type of the user (e.g., "entrenador", "jugador").
     * @return The password of the specified user.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public String getUsuarioPassword(String userName, String userType) {

		String pass = "";
		String query = "";
		if ("entrenador".equals(userType)) {
			query = GETEntrenadorPassword;
		} else if ("jugador".equals(userType)) {
			query = GETJugadorPassword;
		}

		try {

			connection = MySqlConnection.getInstance(userType).getConnection();

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
			try {
				MySqlConnection.getInstance(userType).getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return pass;
	}
    /**
     * Updates the icon of a specified user in the database.
     *
     * @param user     The username of the user whose icon to update.
     * @param userIcon The new icon of the user.
     * @param userType The type of the user (e.g., "entrenador", "jugador").
     * @return true if the user icon was successfully updated, false otherwise.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public boolean updateUsrIcon(String user, Blob userIcon, String userType) {

		boolean modified = false;
		try {
			connection = MySqlConnection.getInstance(userType).getConnection();

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
			try {
				MySqlConnection.getInstance(userType).getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return modified;
	}
    /**
     * Checks if a match exists on a specified date.
     *
     * @param fecha The date of the match.
     * @return true if a match exists on the specified date, false otherwise.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	public boolean existePartidoEnFecha(java.sql.Timestamp fecha) {
		String query = "SELECT COUNT(*) AS count FROM juegan WHERE fechaInicio = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setTimestamp(1, fecha);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int count = resultSet.getInt("count");
					return count > 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
    /**
     * Checks if a specified date is unique (i.e., not already used for a match).
     *
     * @param fecha The date to check.
     * @return true if the date is unique, false otherwise.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	public boolean verificarFechaUnica(LocalDateTime fecha) {
		boolean fechaUnica = false;
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();

			PreparedStatement statement = connection
					.prepareStatement("SELECT COUNT(*) FROM juegan WHERE fechaInicio = ?");
			statement.setObject(1, fecha);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				fechaUnica = (count == 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return fechaUnica;
	}
    /**
     * Retrieves the name of the stadium for a specified match.
     *
     * @param juegan The match information.
     * @return The name of the stadium where the match is played.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
	public String getNombreEstadio(Juegan juegan) {
		String estadio = "";
		try {
			connection = MySqlConnection.getInstance("admin").getConnection();
			statement = connection.prepareStatement(nombreEstadio);
			statement.setString(1, juegan.getNombreEquipoLocal());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				estadio = resultSet.getString("nombreEstadio");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			MySqlConnection.getInstance("admin").getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		return estadio;

	}
    /**
     * Retrieves a list of matches involving a specified team.
     *
     * @param equipoName The name of the team to retrieve matches for.
     * @return An ArrayList of Juegan objects representing the matches involving the specified team.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */

	@Override
	public ArrayList<Juegan> consultarPartidoEquipo(String equipoName) {
		ArrayList<Juegan> partidosLista = new ArrayList<>();

		try {
			connection = MySqlConnection.getInstance("entrenador").getConnection();

			statement = connection.prepareStatement(CONSULTARequipo);
			statement.setString(1, equipoName);
			statement.setString(2, equipoName);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String local = resultSet.getString("nombreEquipoLocal");
				String visitante = resultSet.getString("nombreEquipoVisitante");
				java.sql.Timestamp timestamp = resultSet.getTimestamp("fechaInicio");
				LocalDateTime fecha = timestamp.toLocalDateTime();
				String resultado = resultSet.getString("resultado");
				Juegan partido = new Juegan(local, visitante, fecha, resultado);
				partidosLista.add(partido);
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.getInstance("entrenador").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return partidosLista;
	}
    /**
     * Closes the database connection.
     */

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
<<<<<<< HEAD
=======
    /**
     * Updates the number of assists for players of the teams involved in a match.
     *
     * @param localTeam  The name of the local team.
     * @param visitTeam  The name of the visiting team.
     * @param matchTime  The time of the match.
     * @throws SQLException If an SQL exception occurs while querying the database.
     */
>>>>>>> 0feb09236e8ddaa1aa4d77aa78f121d58e189e72

	@Override
	public void updateAsistencias(String localTeam, String visitTeam, LocalDateTime matchTime) {

		try {
			connection = MySqlConnection.getInstance("jugador").getConnection();

			callableStatement = connection.prepareCall("{CALL UpdateAsistenciasAfterMatch(?, ?, ?)}");
			callableStatement.setString(1, localTeam);
			callableStatement.setString(2, visitTeam);
			Timestamp timestamp = Timestamp.valueOf(matchTime);
			callableStatement.setTimestamp(3, timestamp);

			callableStatement.execute();
<<<<<<< HEAD

			System.out.println("Asistencias updated successfully for the match.");
=======
>>>>>>> 0feb09236e8ddaa1aa4d77aa78f121d58e189e72

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.getInstance("admin").getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void consultarEquipo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarPartido() {
		// TODO Auto-generated method stub

	}

}