package modele.metier;

import modele.metier.Representation;
import modele.metier.Reservation;

/**
 * Classe représentant les clients pour les quels des réservations sont effectués
 * 
 * @author ydurand
 * v1.0
 */
public class Client {
    
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private int num;
    
    /**
     * Constructeur avec les 4 attributs
     * @param id : identifiant DB de la reservation
     * @param nom
     * @param prenom
     * @param adresse
     * @param num
     */
    public Client(int id, String nom, String prenom, String adresse, int num) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num = num;
    }
    
    /**
     *
     * @return String attributs de la reservation
     */
    @Override
    public String toString() {
        return ("Client{nom: " + this.getNomClient() + "\tprenom: " + this.getPrenomClient() + "\tadresse: " + this.getAdresseClient() + "\tnum: " + this.getNumClient() + "}");
    }
    
    //Getter / Setter de la classe Reservation
    
    /**
     *
     * @return int id du client dans la DB
     */
    public int getIdClient() {
        return id;
    }
    
    /**
     * 
     * @param id : identifiant du client dans la DB
     */
    public void setIdClient(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @return String nom du client
     */
    public String getNomClient() {
        return nom;
    }
    
    /**
     * 
     * @param nom : String nom du client
     */
    public void setNomClient(String nom) {
        this.nom = nom;
    }
   
    /**
     * 
     * @return String prenom du client
     */    
    public String getPrenomClient() {
        return prenom;
    }
    
    /**
     * 
     * @param prenom : String prenom du client
     */
    public void setPrenomClient(String prenom) {
        this.prenom = prenom;
    }
    
    /**
     * 
     * @return String adresse du client
     */
    public String getAdresseClient() {
        return adresse;
    }
    
    /**
     * 
     * @param adresse : String adresse du client
     */
    public void setAdresseClient(String adresse) {
        this.adresse = adresse;
    }
    
    /**
     * 
     * @return int num numéro de téléphone du client
     */
    public int getNumClient() {
        return num;
    }
    
    /**
     * 
     * @param num : int numéro de téléphone du client
     */
    public void setNumClient(int num) {
        this.num = num;
    }
    
}
