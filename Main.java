import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Obtenir la connexion à la base de données
        Connection connection = DatabaseManager.getConnection();

        // Utiliser la connexion pour exécuter des requêtes, etc.

        // Assurez-vous de fermer la connexion lorsque vous avez terminé
        DatabaseManager.closeConnection();
    }
}
