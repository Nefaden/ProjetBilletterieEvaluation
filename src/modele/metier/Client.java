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
    private Long l_Id;
    @Column(length=40)
    private String s_NomClient;
    @Column(length=40)
    private String s_PrenomClient;
    @Column(length=120)
    private String s_AdresseClient;
    @Column(length=11)
    private int i_NumeroTelClient;
    
    /**
     * Constructeur avec les 4 attributs
     * @param strNomClient
     * @param strPrenomClient
     * @param strAdresseClient
     * @param intNumeroTelClient
     */
    public Client(String strNomClient, String strPrenomClient, String strAdresseClient, int intNumeroTelClient) {
        this.s_NomClient = strNomClient;
        this.s_PrenomClient = strPrenomClient;
        this.s_AdresseClient = strAdresseClient;
        this.i_NumeroTelClient = intNumeroTelClient;
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
     * @return String attributs de la reservation
     */
    @Override
    public String toString() {
        return ("Client{nom: " + this.getNomClient() + "\tprenom: " + this.getPrenomClient() + "\tadresse: " + this.getAdresseClient() + "\tnum: " + this.getNumeroTelClient() + "}");
    }
    
    //Getter / Setter de la classe Reservation    
    
    /**
     * 
     * @return String nom du client
     */
    public String getNomClient() {
        return s_NomClient;
    }
    
    /**
     * 
     * @param strNomClient : String nom du client
     */
    public void setNomClient(String strNomClient) {
        this.s_NomClient = strNomClient;
    }
   
    /**
     * 
     * @return String prenom du client
     */    
    public String getPrenomClient() {
        return s_PrenomClient;
    }
    
    /**
     * 
     * @param strPrenomClient : String prenom du client
     */
    public void setPrenomClient(String strPrenomClient) {
        this.s_PrenomClient = strPrenomClient;
    }
    
    /**
     * 
     * @return String adresse du client
     */
    public String getAdresseClient() {
        return s_AdresseClient;
    }
    
    /**
     * 
     * @param strAdresseClient : String adresse du client
     */
    public void setAdresseClient(String strAdresseClient) {
        this.s_AdresseClient = strAdresseClient;
    }
    
    /**
     * 
     * @return int num numéro de téléphone du client
     */
    public int getNumeroTelClient() {
        return i_NumeroTelClient;
    }
    
    /**
     * 
     * @param intNumeroTelClient : int numéro de téléphone du client
     */
    public void setNumeroTelClient(int intNumeroTelClient) {
        this.i_NumeroTelClient = intNumeroTelClient;
    }
    
}
