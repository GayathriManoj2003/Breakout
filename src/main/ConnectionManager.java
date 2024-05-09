package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url = "jdbc:mysql://localhost:3306/Breakout";
    private static String username = "root";
    private static String password = "root";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to MySQL Database Successful.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("MySQL JDBC Driver not found.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to get connection to database.");
            }
            return connection;
        }
    }
    public static void main(String[] args)
    {
    	ConnectionManager.getConnection();
    }
}

