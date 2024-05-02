import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-19S3UPM:1521:XE", "HOSSEINAT", "kaoutar");
                System.out.println("Connected to the database.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
