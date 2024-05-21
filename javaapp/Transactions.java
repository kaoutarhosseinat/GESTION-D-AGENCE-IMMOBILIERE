package javaapp;

import java.sql.Date;
public class Transactions {
    private int numtransaction;
    private String typeT;
    private double montant;
    private Date date;
    private Contrat contrat;
    private int id_client;
    private int id_bienimm;


        public int getNumTransaction(){
            return numtransaction;
        }
        public void setNumTransaction(int numtransaction) {
            this.numtransaction = numtransaction;
        }
        public int getId_bien_imm(){
            return id_bienimm;
        }
        public void setid_bienimm(int id_bienimm){
            this.id_bienimm = id_bienimm;
        }
        
        public int getId_client() {
            return id_client;
        }

        public void setId_client(int id_client) {
            this.id_client = id_client;
        }

        public double getMontant() {
            return montant;
        }

        public void setMontant(double montant) {
            this.montant = montant;
        }

        public String getType() {
            return typeT;
        }

        public void setType(String typeT) {
            this.typeT = typeT;
        }

        public Contrat getContrat() {
            return contrat;
        }

        public void setContrat(Contrat contrat) {
            this.contrat = contrat;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    

