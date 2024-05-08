package javaapp;

public class BienImmobilier {
  private int id_bien_imm;
  private String typeb;
  private int sizeb;
  private int prix;
  private String localisation;
  private String descbi;
  private int id_agent;


  public int getId_bien_imm(){
    return id_bien_imm;
  }

  public void setid_bienimm(int id_bien_imm){
    this.id_bien_imm = id_bien_imm;
  }
  public String getType(){
    return typeb;
  }
  public void setType(String typeb){
    this.typeb = typeb;
  }
  public int getTaille(){
    return sizeb;
  }
  public void setTaille(int sizeb){
    this.sizeb = sizeb;
  }
  
  public int getPrix() {
      return prix;
  }

  public void setPrix(int prix) {
      this.prix = prix;
  }
  
  public String getLocalisation() {
      return localisation;
  }

  public void setLocalisation(String localisation) {
      this.localisation = localisation;
  }
  
  public String getDescription() {
      return descbi;
  }

  public void setDescription(String descbi) {
      this.descbi = descbi;
  }
  public int getIdagent() {
      return id_agent;
  }
  public void setId_agent(int id_agent) {
      this.id_agent = id_agent;
  }

}
