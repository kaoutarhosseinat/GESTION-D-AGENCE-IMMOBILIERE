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

        System.out.println("ID Bien Immobillier: ");
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
                e.printStackTrace();} 
                

        System.out.println("Ajouter un nouveau client :");
        System.out.println("ID Client : ");
        int idClient = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Nom du client : ");
        String nomClient = scanner.nextLine();
        System.out.println("Prénom du client : ");
        String prenomClient = scanner.nextLine();
        System.out.println("Type du client : ");
        String typeClient = scanner.nextLine();
        System.out.println("Demande du client : ");
        String demandeClient = scanner.nextLine();
        System.out.println("Numéro de transaction : ");
        int numTransaction = scanner.nextInt();

        Client nouveauClient = new Client();
        nouveauClient.setId_client(idClient);
        nouveauClient.setNomc(nomClient);
        nouveauClient.setPreNomc(prenomClient);
        nouveauClient.setTypec(typeClient);
        nouveauClient.setdemandec(demandeClient);
        nouveauClient.setNumTransaction(numTransaction);

    
        try {
            DatabaseManager.ajouterClient(nouveauClient);
            System.out.println("Client ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }

       


        System.out.println("Modifier les informations d'un client :");
        System.out.println("ID du client à modifier : ");
        int idClientAModifier = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Nouveau nom du client : ");
        String nouveauNomClient = scanner.nextLine();
        System.out.println("Nouveau prénom du client : ");
        String nouveauPrenomClient = scanner.nextLine();
        System.out.println("Nouveau type du client : ");
        String nouveauTypeClient = scanner.nextLine();
        System.out.println("Nouvelle demande du client : ");
        String nouvelleDemandeClient = scanner.nextLine();
        System.out.println("Nouveau numéro de transaction : ");
        int nouveauNumTransaction = scanner.nextInt();

        Client modifierClient = new Client();
        modifierClient.setId_client(idClientAModifier);
        modifierClient.setNomc(nouveauNomClient);
        modifierClient.setPreNomc(nouveauPrenomClient);
        modifierClient.setTypec(nouveauTypeClient);
        modifierClient.setdemandec(nouvelleDemandeClient);
        modifierClient.setNumTransaction(nouveauNumTransaction);

        
        try {
            DatabaseManager.modifierClient(modifierClient);
            System.out.println("Informations du client modifiées avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification des informations du client : " + e.getMessage());
        }

        scanner.close();

        
     System.out.println("Supprimer un client :");
        System.out.println("ID du client à supprimer : ");
        int idClientASupprimer = scanner.nextInt();
        try {
           DatabaseManager.supprimerClient(idClientASupprimer);
            System.out.println("Client supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du client : " + e.getMessage());
        }
            
        Client client = DatabaseManager.recupererClient(idClient);
            if (client == null) {
                System.out.println("Client non trouvé dans la base de données.");
                return;
            }
        
        System.out.println("Enregistrer un nouveau paiement :");
        System.out.println("Numéro de transaction : ");
        int numTrans = Integer.parseInt(scanner.nextLine());
        System.out.println("Montant : ");
        double payMontant = Double.parseDouble(scanner.nextLine());
        System.out.println("Date (AAAA-MM-JJ) : ");
        String payDateStr = scanner.nextLine();
        Date payDate = Date.valueOf(payDateStr);
        System.out.println("Type : ");
        String payType = scanner.nextLine();
        System.out.println("ID Client : ");
        int payIdClient = Integer.parseInt(scanner.nextLine());
        System.out.println("ID Bien Imm : ");
        int payIdBienImm = Integer.parseInt(scanner.nextLine());
        
        Transactions payment = new Transactions();
        payment.setNumTransaction(numTrans);
        payment.setMontant(payMontant);
        payment.setDate(payDate);
        payment.setType(payType);
        payment.setId_client(payIdClient);
        payment.setid_bienimm(payIdBienImm);
       
        DatabaseManager.enregistrerPaiement(payment);
           

        System.out.println("Générer un nouveau contrat :");
        System.out.println("Nom de l'agent immobilier : ");
        String agentNom = scanner.nextLine();
        System.out.println("Type de bien immobilier : ");
        String bienType = scanner.nextLine();
        System.out.println("Localisation du bien immobilier : ");
        String bienLocalisation = scanner.nextLine();
        System.out.println("Type de transaction : ");
        String transType = scanner.nextLine();
        System.out.println("Montant de la transaction : ");
        double transMontant = Double.parseDouble(scanner.nextLine());
        DatabaseManager.enregistrerContrat(agentNom, bienType, transType,bienLocalisation,transMontant);

        scanner.close();





        System.out.print("Entrez l'ID de l'agent immobilier: ");
        int idagent = scanner.nextInt();

        System.out.print("Entrez la date du rendez-vous (AAAA-MM-JJ): ");
        String dateStr = scanner.next();
        Date dateRendezVous = Date.valueOf(dateStr);


         DatabaseManager.planifierRendezVous(client, idagent, dateRendezVous);

        scanner.close();
            }

       
    
}
        
       
