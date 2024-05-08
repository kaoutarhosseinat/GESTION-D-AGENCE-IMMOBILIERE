package javaapp;
import java.sql.Connection;
import java.sql.DriverManager;


public class Main {
    public static void main(String[] args) {
       
        Connection connection = DatabaseManager.getConnection();
        BienImmobilier BienImm = new BienImmobilier();
        BienImm.setid_bienimm(1);
        BienImm.setType("villa");
        BienImm.setTaille(900);
        BienImm.setPrix(1234567);
        BienImm.setLocalisation("hydra");
        BienImm.setDescription("villa ta kaoutar");
        BienImm.setId_agent(1);

        DatabaseManager.ajouterBienImm(BienImm);
        
        DatabaseManager.closeConnection();
    }
}
