package javaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-19S3UPM:1521:XE", "HOSSEINAT",
                        "kaoutar");
                System.out.println("Connected to the database.");
            } catch (ClassNotFoundException | SQLException e) {
                throw new SQLException("Failed to connect to the database", e);
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

    public static void ajouterBienImm(BienImmobilier Bimm) throws SQLException {
        String query = "INSERT INTO BIEN_IMMOBILIERS (id_bienimm, typebi, taille, PRIX, localisation, descbi, ID_Agent) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, Bimm.getId_bien_imm());
            preparedStatement.setString(2, Bimm.getType());
            preparedStatement.setDouble(3, Bimm.getTaille());
            preparedStatement.setDouble(4, Bimm.getPrix());
            preparedStatement.setString(5, Bimm.getLocalisation());
            preparedStatement.setString(6, Bimm.getDescription());
            preparedStatement.setInt(7, Bimm.getIdagent());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bien immobilier ajouté avec succès.");
            } else {
                System.out.println("Échec de l'ajout du bien immobilier.");
            }
        }
    }

    public static void supprimerBienImm(int id) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM BIEN_IMMOBILIERS WHERE id_bienimm=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Bien avec l'identifiant " + id + " supprimé avec succès.");
                } else {
                    System.out.println("Aucun bien trouvé avec l'identifiant fourni.");
                }
            }
        }
    }
}


