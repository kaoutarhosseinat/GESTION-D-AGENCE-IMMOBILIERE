package javaapp;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) throws SQLException {
       
        try (Connection connection = DatabaseManager.getConnection()) {
        } catch (SQLException e1) {
        
            e1.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        /*System.out.println("ID Bien Immobillier: ");
        int id_bienimm = scanner.nextInt();

        System.out.println("Type de Bien Immobillier: ");
        String type = scanner.next();

        System.out.println("La Taille de Bien Immobillier : ");
        int sizebi = scanner.nextInt();

        System.out.println("Prix: ");
        int prix = scanner.nextInt();

        System.out.println("Localisation: ");
        String local = scanner.next();

        System.out.println("Description: ");
        String desc = scanner.next();

        System.out.println("ID Agent Immobillier: ");
        int id_agent= scanner.nextInt();
        
        BienImmobilier BienImm = new BienImmobilier();
        BienImm.setid_bienimm(id_bienimm);
        BienImm.setType(type);
        BienImm.setTaille(sizebi);
        BienImm.setPrix(prix);
        BienImm.setLocalisation(local);
        BienImm.setDescription(desc);
        BienImm.setId_agent(id_agent);

        try {
            DatabaseManager.ajouterBienImm(BienImm);
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

    
        System.out.println("Id de bien à supprimer  ");
        int id = scanner.nextInt();
        BienImmobilier bienASupprimer = new BienImmobilier();
        bienASupprimer.setid_bienimm(id);
        try {
            DatabaseManager.supprimerBienImm(bienASupprimer.getId_bien_imm());
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        System.out.println("Entrer Id de bien à modifier");
        int idu = scanner.nextInt();
        boolean exist = DatabaseManager.exist(id);
        if (!exist) {
            System.out.println("le bien n'existe pas");
        }

        System.out.println("Type de Bien Immobilier à rechercher: ");
        String typeb = scanner.next();
        System.out.println("Prix: ");
        int prixb = scanner.nextInt();
        System.out.println("Localisation: ");
        String localisation = scanner.next();
            try {
                DatabaseManager.rechercherBiens(typeb, prixb, localisation);
            } catch (SQLException e) {
                e.printStackTrace();} */
                

        System.out.print("Entrez l'ID du client: ");
            int idClient = scanner.nextInt();
            scanner.nextLine(); 

            
        Client client = DatabaseManager.recupererClient(idClient);
            if (client == null) {
                System.out.println("Client non trouvé dans la base de données.");
                return;
            }

        System.out.print("Entrez l'ID de l'agent immobilier: ");
        int idagent = scanner.nextInt();

        System.out.print("Entrez la date du rendez-vous (AAAA-MM-JJ): ");
        String dateStr = scanner.next();
        Date dateRendezVous = Date.valueOf(dateStr);


         DatabaseManager.planifierRendezVous(client, idagent, dateRendezVous);

        scanner.close();
            }

       
    


















}
        
       
