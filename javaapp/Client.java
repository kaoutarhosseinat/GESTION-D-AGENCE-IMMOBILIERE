package javaapp;

public class Client {
    public int id_client;
    private String nomc;
    private String prenomc;
    private String typec;
    private String demandec;
    public int numTransaction;

    public int getId_client(){
        return id_client;
    }

    public void  setId_client(int id_client){
        this.id_client=id_client;
    }
    
    public int getNumTransaction() {
        return numTransaction;
    }

    public void setNumTransaction(int numTransaction) {
        this.numTransaction = numTransaction;
    }
    
    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }
    
    public String getPreNomc() {
        return prenomc;
    }

    public void setPreNomc(String prenomc) {
        this.prenomc = prenomc;
    }
    
    public String getTypec() {
        return typec;
    }

    public void setTypec(String typec) {
        this.typec = typec;
    }
    
    public String getdemandec() {
        return demandec;
    }

    public void setdemandec(String demandec) {
        this.demandec = demandec;
    }


}
