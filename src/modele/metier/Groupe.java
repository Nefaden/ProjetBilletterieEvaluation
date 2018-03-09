package modele.metier;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Classe Groupe, le groupe jouant durant la representation
 * 
 * @author mroux
 * v1.0
 */
@Entity
public class Groupe implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    @Column(length=40)
    private String nom;
    @Column(length=120)
    private String adressePostale;
    @Column(length=40)
    private String identiteResponsable;
    @Column(length=11)
    private int nbPersonne;
    @Column(length=40)
    private String nomPays;
    @Column(length=1)
    private String hebergement;
    
    
     /**
     * Constructeur avec les 6 attributs
     * @param nom
     * @param adressePostale     
     * @param identiteResponsable
     * @param nbPersonne
     * @param nomPays
     * @param hebergement
     */
    public Groupe(String nom, String adressePostale, String identiteResponsable, int nbPersonne, String nomPays, String hebergement) {
    
        this.nom=nom;
        this.adressePostale=adressePostale;
        this.identiteResponsable=identiteResponsable;
        this.nbPersonne=nbPersonne;
        this.nomPays=nomPays;
        this.hebergement=hebergement;
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
     * @return String attributs du Groupe
     */
    @Override
    public String toString() {
        return ("Groupe{nom: " + this.getNom() + "\tadresse postale: " + this.getAdressePostale() + "\tindentite du responsable: " + this.getIdentiteResponsable() + "\tNombre de personnes: " + this.getNbPersonne() + "\tNom du Pays : " + this.getNomPays() + "\tHebergement: " + this.getHebergement()) +"}";
    }

    /**
     * 
     * @return String le nom du groupe
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * 
     * @param nom : String nom du groupe
     */
    public void setNom() {
        this.nom = nom;
    }

    /**
     * 
     * @return String l'adresse postale du groupe
     */
    public String getAdressePostale() {
        return adressePostale;
    }
    
    /**
     * 
     * @param adressePostale : String l'adresse postale du groupe
     */
    public void setAdressePostale() {
        this.adressePostale = adressePostale;
    }

    /**
     * 
     * @return String l'identité du responsable du groupe
     */
    public String getIdentiteResponsable() {
        return identiteResponsable;
    }

    /**
     * 
     * @param identiteResponsable : String le nom du responsable du groupe
     */
    public void setIdentiteResponsable() {
        this.identiteResponsable = identiteResponsable;
    }
    
    /**
     * 
     * @return int nombre de personne dans le groupe
     */
    public int getNbPersonne() {
        return nbPersonne;
    }
    
    /**
     * 
     * @param nbPersonne : int Le nombre de personnes dans le groupe
     */
    public void setNbPersonne() {
        this.nbPersonne = nbPersonne;
    }

    /**
     * 
     * @return String le nom du pays d'origine du groupe
     */
    public String getNomPays() {
        return nomPays;
    }
    
    /**
     * 
     * @param nomPays : String le nom du pays
     */
    public void setNomPays() {
        this.nomPays = nomPays;
    }

    /**
     * 
     * @return String si le groupe est héberger ou non
     */
    public String getHebergement() {
        return hebergement;
    }
    
    /**
     * 
     * @param hebergement : String (booléen) vérifie si oui ou non le groupe est héberger
     */
    public void setHebergement() {
        this.hebergement = hebergement;
    }
    
}
