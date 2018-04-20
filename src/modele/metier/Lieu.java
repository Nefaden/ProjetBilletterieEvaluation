package modele.metier;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Classe Lieu, lieu où sont faites les représentation
 * 
 * @author gdoucet
 * v1.0
 */
@Entity(name = "Lieu")
@Table(name = "Lieu")
public class Lieu implements Serializable {
    
    @Id
    @Column(name = "id", length = 11)
    private int i_Id;
    @Column(name = "nom", length = 255)
    private String s_NomLieu;
    @Column(name = "adr", length = 255)
    private String s_AdresseLieu;
    @Column(name = "capacite", length = 11)
    private int i_CapaciteLieu;
    
    /**
     * 
     * Void constructor for Mapping JPA
     */
    public Lieu() {}

     /**
     * Constructeur avec les 4 attributs
     * @param intId : identifiant DB du lieu
     * @param strNomLieu
     * @param strAdresseLieu    
     * @param intCapaciteLieu
     */
    public Lieu(int intId, String strNomLieu, String strAdresseLieu, int intCapaciteLieu) {
        this.i_Id = intId;
        this.s_NomLieu = strNomLieu;
        this.s_AdresseLieu = strAdresseLieu;
        this.i_CapaciteLieu = intCapaciteLieu;

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
     * @return int id du lieu dans la DB
     */
    public int getIdLieu() {
        return i_Id;
    }
    
    /**
     *
     * @param intId : id du lieu dans la base de données
     */
    public void setIdLieu(int intId) {
        this.i_Id = intId;
    }
    
    /**
     * 
     * @return String le nom du lieu
     */
    public String getNomLieu() {
        return s_NomLieu;
    }
    
    /**
     *
     * @param strNomLieu : Nom du lieu dans la base de données
     */
    public void setNomLieu(String strNomLieu) {
        this.s_NomLieu = strNomLieu;
    }
    
    /**
     * 
     * @return String l'adresse du lieu
     */
    public String getAdresseLieu() {
        return s_AdresseLieu;
    }
    
    /**
     *
     * @param strAdresseLieu : adresse du lieu dans la base de données
     */
    public void setAdresseLieu(String strAdresseLieu) {
        this.s_AdresseLieu = strAdresseLieu;
    }
    
    /**
     * 
     * @return int la capacité du lieu
     */
    public int getCapaciteLieu() {
        return i_CapaciteLieu;
    }
    
    /**
     * 
     * @param intCapaciteLieu : int la capacité du lieu
     */
    public void getCapaciteLieu(int intCapaciteLieu) {
        this.i_CapaciteLieu = intCapaciteLieu;
    }    
}
