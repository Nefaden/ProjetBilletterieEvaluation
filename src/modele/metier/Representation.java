package modele.metier;

import java.sql.Time;
import modele.metier.Lieu;
import modele.metier.Groupe;

/**
 *Classe représentant les representations des groupes participant au festival dans les lieux réservés
 * 
 * @author ydurand
 * v1.0
 */
public class Representation {

    private int id;
    private String date;
    private Lieu unLieu;
    private Groupe unGroupe;
    private String heureDeb;
    private String heureFin;
    private int nbPlacesRestantes;

    /**
     * Constructeur avec les 6 attributs
     * @param id : identifiant DB de la representation
     * @param date_representation
     * @param unLieu
     * @param unGroupe
     * @param heureDebut_representation
     * @param heureFin_representation
     * @param nbPlacesRestantes_representation
     */
    public Representation(int id, String date_representation, Lieu unLieu, Groupe unGroupe, String heureDebut_representation, String heureFin_representation, int nombrePlacesRestantes) {
        this.id = id;
        this.date = date_representation;
        this.unLieu = unLieu;
        this.unGroupe = unGroupe;
        this.heureDeb = heureDebut_representation;
        this.heureFin = heureFin_representation;
        this.nbPlacesRestantes = nombrePlacesRestantes;
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
     * @return int id de la representation dans la DB
     */
    public int getIdRepresentation() {
        return id;
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
     * @param id : identifiant de la representation dans la DB
     */
    public void setIdRepresentation(int id) {
        this.id = id;
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
