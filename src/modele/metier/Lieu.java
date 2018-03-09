package modele.metier;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe Lieu, lieu où sont faites les représentation
 * 
 * @author gdoucet
 * v1.0
 */
@Entity
public class Lieu implements Serializable{
    
    @Id
    @GeneratedValue    
    private Long id;
    @Column(length=255)
    private String nom;
    @Column(length=255)
    private String adr;
    @Column(length=11)
    private int capacite;

     /**
     * Constructeur avec les 3 attributs
     * @param nom
     * @param adresse    
     * @param capacite
     */
    public Lieu(String nom, String adresse, int capacite) {
        this.nom = nom;
        this.adr = adresse;
        this.capacite = capacite;

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
     * @return String attributs du Lieu
     */
    @Override
    public String toString() {
        return ("Lieu{nom: " + this.getNomLieu() + "\tadresse: " + this.getAdresseLieu() + "\tcapacite: " + this.getCapaciteLieu())+"}";
    }
    
    /**
     * 
     * @return String le nom du lieu
     */
    public String getNomLieu() {
        return nom;
    }
    
    /**
     * 
     * @param nom : String nom du lieu
     */
    public void setNomLieu(Long id) {
        this.id = id;
    }
    
    /**
     * 
     * @return String l'adresse du lieu
     */
    public String getAdresseLieu() {
        return adr;
    }
    
    /**
     * 
     * @param adr : String adresse du lieu
     */
    public void setAdresseLieu() {
        this.adr = adr;
    }
    
    /**
     * 
     * @return int la capacité du lieu
     */
    public int getCapaciteLieu() {
        return capacite;
    }
    
    /**
     * 
     * @param capacite : int capacité du lieu
     */
    public void setCapaciteLieu() {
        this.capacite = capacite;
    }
    
}
