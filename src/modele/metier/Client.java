package modele.metier;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe représentant les clients pour les quels des réservations sont effectués
 * 
 * @author ydurand
 * v1.0
 */
@Entity
public class Client {
    
    @Id
    @GeneratedValue
    private Long id;
    @Column(length=40)
    private String nom;
    @Column(length=40)
    private String prenom;
    @Column(length=120)
    private String adresse;
    @Column(length=11)
    private int num;
    
    /**
     * Constructeur avec les 4 attributs
     * @param nom
     * @param prenom
     * @param adresse
     * @param num
     */
    public Client(String nom, String prenom, String adresse, int num) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num = num;
    }
    
    /**
     * 
     * @return Long id : id générée par la persistence
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id : Long valeur générée par la persistence
     */
    public void setId(Long id) {
        this.id = id;
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
