package modele.metier;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe Lieu, lieu où sont faites les représentation
 * 
 * @author gdoucet
 * v1.0
 */
@Entity(name="Lieu")
public class Lieu implements Serializable{
    
    @Id
    @GeneratedValue 
    @Column(name="id")
    private Long l_Id;
    @Column(name="nom")
    private String s_NomLieu;
    @Column(name="adr")
    private String s_AdresseLieu;
    @Column(name="capacite")
    private int i_CapaciteLieu;

    /**
     * 
     * Default constructor for mapping JPA
     */
    public Lieu() {        
    }
    
     /**
     * Constructeur avec les 3 attributs
     * @param strNomLieu
     * @param strAdresseLieu    
     * @param intCapaciteLieu
     */
    public Lieu(String strNomLieu, String strAdresseLieu, int intCapaciteLieu) {
        this.s_NomLieu = strNomLieu;
        this.s_AdresseLieu = strAdresseLieu;
        this.i_CapaciteLieu = intCapaciteLieu;

    }
    
    /**
     * 
     * @return Long l_Id : l_Id générée par la persistence
     */
    public Long getL_Id() {
        return l_Id;
    }

    /**
     * 
     * @param l_Id : Long valeur générée par la persistence
     */
    public void setL_Id(Long l_Id) {
        this.l_Id = l_Id;
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
        return s_NomLieu;
    }
    
    /**
     * 
     * @param strNomLieu : String nom du lieu
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
     * @param strAdresseLieu : String adresse du lieu
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
     * @param intCapaciteLieu : int capacité du lieu
     */
    public void setCapaciteLieu(int intCapaciteLieu) {
        this.i_CapaciteLieu = intCapaciteLieu;
    }
    
}
