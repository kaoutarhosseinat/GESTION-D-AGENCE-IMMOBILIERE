package javaapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
       
        try (Connection connection = DatabaseManager.getConnection()) {
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID Bien Immobillier: ");
        int id_bienimm = scanner.nextInt();

        System.out.print("Type de Bien Immobillier: ");
        String type = scanner.next();

        System.out.print("La Taille de Bien Immobillier : ");
        int size_bimm = scanner.nextInt();

        System.out.print("Prix: ");
        int prix = scanner.nextInt();

        System.out.print("Localisation: ");
        String local = scanner.next();

        System.out.print("Description: ");
        String desc = scanner.next();

        System.out.print("ID Agent Immobillier: ");
        int id_agent= scanner.nextInt();
        
        BienImmobilier BienImm = new BienImmobilier();
        BienImm.setid_bienimm(id_bienimm);
        BienImm.setType(type);
        BienImm.setTaille(size_bimm);
        BienImm.setPrix(prix);
        BienImm.setLocalisation(local);
        BienImm.setDescription(desc);
        BienImm.setId_agent(id_agent);

        try {
            DatabaseManager.ajouterBienImm(BienImm);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    
        System.out.print("Enter the ID of the property you want to delete: ");
        int id = scanner.nextInt();
        BienImmobilier bienASupprimer = new BienImmobilier();
        bienASupprimer.setid_bienimm(id);
        try {
            DatabaseManager.supprimerBienImm(bienASupprimer.getId_bien_imm());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        DatabaseManager.closeConnection();
    }
}
