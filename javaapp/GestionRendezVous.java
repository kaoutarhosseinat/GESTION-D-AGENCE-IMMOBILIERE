package javaapp;

import oracle.sql.DATE;

public class GestionRendezVous {
    private int id_rdv;
    private DATE date_rdv;
    public int id_client;
    
    
    
    public int getId_rdv() {
        return id_rdv;
    }

    public void setId_rdv(int id_rdv){
        this.id_rdv=id_rdv;
    }
    
    public DATE getDate_rdv() {
        return date_rdv;
    }

    public void setDate_rdv(DATE date_rdv) {
        this.date_rdv = date_rdv;
    }
    
    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

}

 
