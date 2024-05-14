package utlidades;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/laliga?serverTimezone=Europe/Madrid&allowPublicKeyRetrieval=true&useSSL=false";

    private static MySqlConnection instance;
    private Connection connection;
    private String userType;

    private MySqlConnection(String userType) throws SQLException {
        this.userType = userType;
        this.connection = DriverManager.getConnection(DB_URL, userType, userType);
    }

    public static MySqlConnection getInstance(String userType) throws SQLException {
        if (instance == null || instance.isClosed() || !instance.getUserType().equals(userType)) {
            synchronized (MySqlConnection.class) {
                if (instance == null || instance.isClosed() || !instance.getUserType().equals(userType)) {
                    instance = new MySqlConnection(userType);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getUserType() {
        return userType;
    }

    // Check if the connection is closed
    private boolean isClosed() throws SQLException {
        return connection == null || connection.isClosed();
    }

    // Close the connection
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
            instance = null; // Allow recreating the instance if needed
        }
    }
}



