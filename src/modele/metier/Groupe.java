package modele.metier;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Classe Groupe, le groupe jouant durant la representation
 * 
 * @author mroux
 * v1.0
 */
@Entity(name="Groupe")
@Table(name = "Groupe")
public class Groupe implements Serializable {
    
    @Id   
    @Column(name = "id", length = 4)
    private String s_Id;
    @Column(name = "nom", length = 40)
    private String s_NomGroupe;
    @Column(name = "identiteResponsable", length = 40)
    private String s_IdentiteResponsable;
    @Column(name = "adressePostale", length = 120)
    private String s_AdressePostale;
    @Column(name = "nombrePersonnes", length = 11)
    private int i_NbPersonne;
    @Column(name = "nomPays", length = 40)
    private String s_NomPays;
    @Column(name = "hebergement")
    private char c_Hebergement;
    
    
    /**
     * 
     * Default constructor for mapping JPA
     */
    public Groupe() {}
    
     /**
     * Constructeur avec les 7 attributs
     * @param strId
     * @param strNomGroupe
     * @param strAdressePostale     
     * @param strIdentiteResponsable
     * @param intNbPersonne
     * @param strNomPays
     * @param charHebergement
     */
    public Groupe(String strId, String strNomGroupe, String strAdressePostale, String strIdentiteResponsable, int intNbPersonne, String strNomPays, char charHebergement) {
    
        this.s_Id = strId;
        this.s_NomGroupe = strNomGroupe;
        this.s_AdressePostale = strAdressePostale;
        this.s_IdentiteResponsable = strIdentiteResponsable;
        this.i_NbPersonne = intNbPersonne;
        this.s_NomPays = strNomPays;
        this.c_Hebergement = charHebergement;
}
    
    /**
     *
     * @return String attributs du Groupe
     */
    @Override
    public String toString() {
        return ("Groupe{id: " + this.getIdGroupe() + "\tnom: " + this.getNomGroupe() + "\tadresse postale: " + this.getAdressePostale() + "\tindentite du responsable: " + this.getIdentiteResponsable() + "\tNombre de personnes: " + this.getNbPersonne() + "\tNom du Pays : " + this.getNomPays() + "\tHebergement: " + this.getHebergement()) +"}";
    }

    /**
     * 
     * @return String l'id conceptuel du groupe
     */
    public String getIdGroupe() {
        return s_Id;
    }
    
    /**
     * 
     * @param strId : String id du groupe
     */
    public void setIdGroupe(String strId) {
        this.s_Id = strId;
    }
    
    /**
     * 
     * @return String le nom du groupe
     */
    public String getNomGroupe() {
        return s_NomGroupe;
    }
    
    /**
     * 
     * @param strNomGroupe : String nom du groupe
     */
    public void setNom(String strNomGroupe) {
        this.s_NomGroupe = strNomGroupe;
    }

    /**
     * 
     * @return String l'adresse postale du groupe
     */
    public String getAdressePostale() {
        return s_AdressePostale;
    }
    
    /**
     * 
     * @param strAdressePostale : String l'adresse postale du groupe
     */
    public void setAdressePostale(String strAdressePostale) {
        this.s_AdressePostale = strAdressePostale;
    }

    /**
     * 
     * @return String l'identité du responsable du groupe
     */
    public String getIdentiteResponsable() {
        return s_IdentiteResponsable;
    }

    /**
     * 
     * @param strIdentiteResponsable : String le s_NomGroupe du responsable du groupe
     */
    public void setIdentiteResponsable(String strIdentiteResponsable) {
        this.s_IdentiteResponsable = strIdentiteResponsable;
    }
    
    /**
     * 
     * @return int nombre de personne dans le groupe
     */
    public int getNbPersonne() {
        return i_NbPersonne;
    }
    
    /**
     * 
     * @param intNbPersonne : int Le nombre de personnes dans le groupe
     */
    public void setNbPersonne(int intNbPersonne) {
        this.i_NbPersonne = intNbPersonne;
    }

    /**
     * 
     * @return String le s_NomGroupe du pays d'origine du groupe
     */
    public String getNomPays() {
        return s_NomPays;
    }
    
    /**
     * 
     * @param strNomPays : String le s_NomGroupe du pays
     */
    public void setNomPays(String strNomPays) {
        this.s_NomPays = strNomPays;
    }

    /**
     * 
     * @return char si le groupe est héberger ou non
     */
    public char getHebergement() {
        return c_Hebergement;
    }
    
    /**
     * 
     * @param charHebergement : char (booléen) vérifie si oui ou non le groupe est héberger
     */
    public void setHebergement(char charHebergement) {
        this.c_Hebergement = charHebergement;
    }    
}