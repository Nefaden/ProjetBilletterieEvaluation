package modele.metier;

import javax.persistence.*;
import modele.metier.Lieu;
import modele.metier.Groupe;
import java.io.Serializable;

/**
 * Classe représentant les representations des groupes participant au festival dans les lieux réservés
 * 
 * @author ydurand
 * v1.0
 */
@Entity
public class Representation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length=30)
    private String date;    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ID_LIEU")
    private Lieu unLieu;    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ID_GROUPE")
    private Groupe unGroupe;
    @Column(length=30)
    private String heureDeb;
    @Column(length=30)
    private String heureFin;
    @Column(length=11)
    private int nbPlacesRestantes;

    /**
     * Constructeur avec les 6 attributs
     * @param date_representation
     * @param unLieu
     * @param unGroupe
     * @param heureDebut_representation
     * @param heureFin_representation
     * @param nbPlacesRestantes_representation
     */
    public Representation(String date_representation, Lieu unLieu, Groupe unGroupe, String heureDebut_representation, String heureFin_representation, int nombrePlacesRestantes) {
        this.date = date_representation;
        this.unLieu = unLieu;
        this.unGroupe = unGroupe;
        this.heureDeb = heureDebut_representation;
        this.heureFin = heureFin_representation;
        this.nbPlacesRestantes = nombrePlacesRestantes;
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
     * @return String attributs de la representation
     */
    @Override
    public String toString() {
        return ("Representation{date: " + this.getDateRepresentation() + "\tlieu: " + this.getLieu() + "\tgroupe: " + this.getGroupe() + "\theure de début: " + this.getHeureDebRepresentation() + "\theure de fin: " + this.getHeureFinRepresentation()) + "\tnombre de places restantes : " + this.getNbPlacesRestantes() + "}";
    }

    /**
     *
     * @return String date de la representation
     */
    public String getDateRepresentation() {
        return date;
    }

    /**
     *
     * @return objet Lieu de la classe Lieu, le lieu de la representation
     */
    public Lieu getLieu() {
        return unLieu;
    }

    /**
     * 
     * @return objet Groupe de la classe Groupe, le groupe participant à la representation
     */
    public Groupe getGroupe() {
        return unGroupe;
    }

    /**
     * 
     * @return String heure de début de la representation
     */
    public String getHeureDebRepresentation() {
        return heureDeb;
    }

    /**
     * 
     * @return String heure de fin de la representation
     */
    public String getHeureFinRepresentation() {
        return heureFin;
    }
    
    /**
     * 
     * @return int nombre de places restantes
     */
    public int getNbPlacesRestantes() {
        return nbPlacesRestantes;
    }
    
    /**
     * 
     * @param date 
     */
    public void setDateRepresentation(String date) {
        this.date = date;
    }
    
    /**
     * 
     * @param unLieu 
     */
    public void setLieu(Lieu unLieu) {
        this.unLieu = unLieu;
    }
    
    /**
     * 
     * @param unGroupe 
     */
    public void setGroupe(Groupe unGroupe) {
        this.unGroupe = unGroupe;
    }

    /**
     * 
     * @param heureDeb 
     */
    public void setHeureDebRepresentation(String heureDeb) {
        this.heureDeb = heureDeb;
    }

    /**
     * 
     * @param heureFin 
     */
    public void setHeureFinRepresentation(String heureFin) {
        this.heureFin = heureFin;
    }
    
    /**
     * 
     * @param nombrePlacesRestantes
     */
    public void setNbPlacesRestantes(int nombrePlacesRestantes) {
        this.nbPlacesRestantes = nombrePlacesRestantes;
    }
}
