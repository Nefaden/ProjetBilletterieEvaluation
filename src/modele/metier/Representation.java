package modele.metier;

import modele.metier.Lieu;
import modele.metier.Groupe;

/**
 * Classe représentant les representations des groupes participant au festival dans les lieux réservés
 * 
 * @author ydurand
 * v1.0
 */
public class Representation {

    private int i_Id;
    private String s_Date;
    private Lieu o_Lieu;
    private Groupe o_Groupe;
    private String s_HeureDebut;
    private String s_HeureFin;
    private int i_NbPlaceRestante;

    /**
     * Constructeur avec les 6 attributs
     * @param intId : identifiant DB de la representation
     * @param strDateRepresentation
     * @param objLieu
     * @param objGroupe
     * @param strHeureDebutRepresentation
     * @param strHeureFinRepresentation
     * @param intNbPlaceRestante
     */
    public Representation(int intId, String strDateRepresentation, Lieu objLieu, Groupe objGroupe, String strHeureDebutRepresentation, String strHeureFinRepresentation, int intNbPlaceRestante) {
        this.i_Id = intId;
        this.s_Date = strDateRepresentation;
        this.o_Lieu = objLieu;
        this.o_Groupe = objGroupe;
        this.s_HeureDebut = strHeureDebutRepresentation;
        this.s_HeureFin = strHeureFinRepresentation;
        this.i_NbPlaceRestante = intNbPlaceRestante;
    }
    
    /**
     *
     * @return String attributs de la representation
     */
    @Override
    public String toString() {
        return ("Representation{date: " + this.getDateRepresentation() + "\tlieu: " + this.getLieu() + "\tgroupe: " + this.getGroupe() + "\theure de début: " + this.getHeureDebutRepresentation() + "\theure de fin: " + this.getHeureFinRepresentation()) + "\tnombre de places restantes : " + this.getNbPlaceRestante() + "}";
    }

    /**
     *
     * @return int id de la representation dans la DB
     */
    public int getIdRepresentation() {
        return i_Id;
    }

    /**
     *
     * @return String date de la representation
     */
    public String getDateRepresentation() {
        return s_Date;
    }

    /**
     *
     * @return objet Lieu de la classe Lieu, le lieu de la representation
     */
    public Lieu getLieu() {
        return o_Lieu;
    }

    /**
     * 
     * @return objet Groupe de la classe Groupe, le groupe participant à la representation
     */
    public Groupe getGroupe() {
        return o_Groupe;
    }

    /**
     * 
     * @return String heure de début de la representation
     */
    public String getHeureDebutRepresentation() {
        return s_HeureDebut;
    }

    /**
     * 
     * @return String heure de fin de la representation
     */
    public String getHeureFinRepresentation() {
        return s_HeureFin;
    }
    
    /**
     * 
     * @return int nombre de places restantes
     */
    public int getNbPlaceRestante() {
        return i_NbPlaceRestante;
    }
    
    /**
     * 
     * @param intId : identifiant de la representation dans la DB
     */
    public void setIdRepresentation(int intId) {
        this.i_Id = intId;
    }
    
    /**
     * 
     * @param strDateRepresentation 
     */
    public void setDateRepresentation(String strDateRepresentation) {
        this.s_Date = strDateRepresentation;
    }
    
    /**
     * 
     * @param objLieu 
     */
    public void setLieu(Lieu objLieu) {
        this.o_Lieu = objLieu;
    }
    
    /**
     * 
     * @param objGroupe 
     */
    public void setGroupe(Groupe objGroupe) {
        this.o_Groupe = objGroupe;
    }

    /**
     * 
     * @param strHeureDebut 
     */
    public void setHeureDebutRepresentation(String strHeureDebut) {
        this.s_HeureDebut = strHeureDebut;
    }

    /**
     * 
     * @param strHeureFin 
     */
    public void setHeureFinRepresentation(String strHeureFin) {
        this.s_HeureFin = strHeureFin;
    }
    
    /**
     * 
     * @param intNbPlaceRestante
     */
    public void setNbPlaceRestante(int intNbPlaceRestante) {
        this.i_NbPlaceRestante = intNbPlaceRestante;
    }
}
