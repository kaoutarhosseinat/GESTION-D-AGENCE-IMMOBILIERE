package javaapp;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String query = "INSERT INTO BIEN_IMMOBILIERS (id_bienimm, typebi, sizebi, PRIX, localisation, descbi, ID_Agent) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, Bimm.getId_bien_imm());
            preparedStatement.setString(2, Bimm.getType());
            preparedStatement.setInt(3, Bimm.getTaille());
            preparedStatement.setInt(4, Bimm.getPrix());
            preparedStatement.setString(5, Bimm.getLocalisation());
            preparedStatement.setString(6, Bimm.getDescription());
            preparedStatement.setInt(7, Bimm.getIdagent());

            int r= preparedStatement.executeUpdate();
            if (r > 0) {
                System.out.println("Bien immobilier ajouté avec succès.");
            } else {
                System.out.println("Échec de l'ajout du bien immobilier.");
            }
        }
    }

    public static void supprimerBienImm(int id) throws SQLException {
        try (Connection connection = getConnection()) {
            String query1 = "DELETE FROM BIEN_IMMOBILIERS WHERE id_bienimm=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query1)) {
                preparedStatement.setInt(1, id);
                int r = preparedStatement.executeUpdate();
                if (r > 0) {
                    System.out.println("Bien avec l'identifiant " + id + " supprimé avec succès.");
                } else {
                    System.out.println("Aucun bien trouvé avec l'identifiant fourni.");
                }
            }
        }
    }
    
    public static void modifierBienImm(BienImmobilier Bimm) throws SQLException{
        String query2 = "UPDATE BIEN_IMMOBILIERS set typebi=?, sizebi=?, PRIX=?, localisation=?, descbi=? WHERE id_bienimm=?";
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query2)) {
            preparedStatement.setString(1, Bimm.getType());
            preparedStatement.setDouble(2, Bimm.getTaille());
            preparedStatement.setDouble(3, Bimm.getPrix());
            preparedStatement.setString(4, Bimm.getLocalisation());
            preparedStatement.setString(5, Bimm.getDescription());
            preparedStatement.setInt(6, Bimm.getIdagent());

            int r= preparedStatement.executeUpdate();
            if (r > 0) {
                System.out.println("Bien immobilier ajouté avec succès.");
            } else {
                System.out.println("Échec de l'ajout du bien immobilier.");
            }
        }

    }

 public static boolean exist(int id) {
    String query3 = "SELECT COUNT(*) FROM BIEN_IMMOBILIERS WHERE id_bienimm = ?";
    try {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query3);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        } else {
            
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
        return false; 
}
}


public static void rechercherBiens(String typeb, int prixb, String localisation) throws SQLException {
        String query4 = "SELECT * FROM BIEN_IMMOBILIERS WHERE typebi = ? AND PRIX = ? AND localisation = ?";
        boolean trouve = false; 
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query4)) {
            preparedStatement.setString(1, typeb);
            preparedStatement.setInt(2, prixb);
            preparedStatement.setString(3, localisation);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                trouve = true;
                int id = resultSet.getInt("id_bienimm");
                String typebi = resultSet.getString("typebi");
                int size = resultSet.getInt("sizebi");
                int price = resultSet.getInt("PRIX");
                String location = resultSet.getString("localisation");
                String description = resultSet.getString("descbi");
                int agentId = resultSet.getInt("ID_Agent");
                
                System.out.println("Property ID: " + id);
                System.out.println("Type: " + typebi);
                System.out.println("Size: " + size);
                System.out.println("Price: " + price);
                System.out.println("Location: " + location);
                System.out.println("Description: " + description);
                System.out.println("Agent ID: " + agentId);
        
            }
            if (!trouve) {
                System.out.println("Le bien que vous avez recherché n'existe pas.");
            }
        }
    }
    public void enregistrerPaiement(Transactions tran) {
    try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO PAIEMENTS (numTransaction, paiement, dateT, typeT, id_client, id_bienimm) VALUES (?, ?, ?)")) {
        preparedStatement.setInt(1,tran.getNumTransaction());
        preparedStatement.setDouble(2,tran.getMontant());
        preparedStatement.setDate(3,tran.getDate());
        preparedStatement.setString(3, tran.getType());
        preparedStatement.setInt(3, tran.getId_client());
        preparedStatement.setInt(3, tran.getId_bien_imm());
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Paiement enregistré avec succès.");
        } else {
            System.out.println("Échec de l'enregistrement du paiement.");
        }
    } catch (SQLException e) {
    }
}

public static Client recupererClient(int idClient) {
    String query = "SELECT id_client, nom FROM clients WHERE id_client = ?";
    try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, idClient);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                return new Client();
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public static void planifierRendezVous(Client client, int id_agent, Date dateRendezVous) {
    int idClient = client.getId_client();
    enregistrerRendezVous(dateRendezVous, idClient);
    System.out.println("Rendez-vous planifié avec succès.");
}

private static void enregistrerRendezVous(Date dateRdv, int idClient) {
        String query = "INSERT INTO rendez_vous (date_rdv, id_client) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, dateRdv); 
            preparedStatement.setInt(2, idClient);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rendez-vous enregistré avec succès dans la base de données.");
            } else {
                System.out.println("Échec de l'enregistrement du rendez-vous dans la base de données.");
            }
        } catch (SQLException e) {
            
        }

    }
}









