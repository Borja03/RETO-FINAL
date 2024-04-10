
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller implements IController {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/laliga?serverTimezone=Europe/Madrid&allowPublicKeyRetrieval=true&useSSL=false";
	private String user;
	private String password;

	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isConnected = false;

	final String INNSERTjugador = "INSERT INTO jugador (user,password,dorsal,nombreEquipo) VALUES (?,?,?,?)";

	final String ConnectUser = "SELECT * FROM  laliga WHERE user_name =? AND password=?";
	final String MODIFICARusuario = "UPDATE USUARIO SET edad=?, dni=? WHERE user_name=?";
	final String ALLequipos = "SELECT nombreEquipo FROM  equipo";
	final String ENTRENADORequipo = "SELECT nombreEquipo FROM  entrenador where user=?";

	// final String granJugadorRole = "GRANT jugador_role TO ?";

	public boolean checkUserExist(String username, String pass, String userType) {
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
			// JOptionPane.showMessageDialog(LoginWindow.this, "Authentication failed.",
			// "Error",
			// JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	@Override
	public boolean logOut() {
		return false;
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
}
