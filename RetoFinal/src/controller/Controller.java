
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

	final String INNSERTjugador = "INSERT INTO jugador (user,password,dorsal,nombreEquipo) VALUES (?,?,?,?)";
	final String INNSERTentrenador = "INSERT INTO entrenador (user,password,tipoEntrenador,nombreEquipo) VALUES (?,?,?,?)";

	final String ConnectUser = "SELECT * FROM  laliga WHERE user_name =? AND password=?";
	
	final String ALLequipos = "SELECT nombreEquipo FROM  equipo";
	final String ENTRENADORequipo = "SELECT nombreEquipo FROM  entrenador where user=?";


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






	@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
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
	public boolean crearJugador(String user, String password, int dorsal, String nombreEquipo) {
		boolean added = false;
		this.openConnection("entrenador", "entrenador");
		try {
			statement = connection.prepareStatement(INNSERTjugador);

			statement.setString(1, user);
			statement.setString(2, password);
			statement.setInt(3, dorsal);
			statement.setString(4, nombreEquipo);
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
	public void borrarJugador() {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void modificarEntrenador() {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void modificarJugador() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
	
}

