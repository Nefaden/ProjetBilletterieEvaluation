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
    private Long l_Id;
    @Column(length=30)
    private String s_DateRepresentation;    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Lieu o_Lieu;    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Groupe o_Groupe;
    @Column(length=30)
    private String s_HeureDebutRepresentation;
    @Column(length=30)
    private String s_HeureFinRepresentation;
    @Column(length=11)
    private int i_NbPlacesRestantes;

    /**
     * 
     * Default constructor for mapping JPA
     */
    public Representation() {        
    }
    
    /**
     * Constructeur avec les 6 attributs
     * @param strDateRepresentation
     * @param objLieu
     * @param objGroupe
     * @param strHeureDebutRepresentation
     * @param strHeureFinRepresentation
     * @param intNbPlacesRestantesRepresentation
     */
    public Representation(String strDateRepresentation, Lieu objLieu, Groupe objGroupe, String strHeureDebutRepresentation, String strHeureFinRepresentation, int intNbPlacesRestantesRepresentation) {
        this.s_DateRepresentation = strDateRepresentation;
        this.o_Lieu = objLieu;
        this.o_Groupe = objGroupe;
        this.s_HeureDebutRepresentation = strHeureDebutRepresentation;
        this.s_HeureFinRepresentation = strHeureFinRepresentation;
        this.i_NbPlacesRestantes = intNbPlacesRestantesRepresentation;
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
     * @return String attributs de la representation
     */
    @Override
    public String toString() {
        return ("Representation{date: " + this.getDateRepresentation() + "\tlieu: " + this.getLieu() + "\tgroupe: " + this.getGroupe() + "\theure de début: " + this.getHeureDebutRepresentation() + "\theure de fin: " + this.getHeureFinRepresentation()) + "\tnombre de places restantes : " + this.getNbPlacesRestantes() + "}";
    }

    /**
     *
     * @return String date de la representation
     */
    public String getDateRepresentation() {
        return s_DateRepresentation;
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
        return s_HeureDebutRepresentation;
    }

    /**
     * 
     * @return String heure de fin de la representation
     */
    public String getHeureFinRepresentation() {
        return s_HeureFinRepresentation;
    }
    
    /**
     * 
     * @return int nombre de places restantes
     */
    public int getNbPlacesRestantes() {
        return i_NbPlacesRestantes;
    }
    
    /**
     * 
     * @param strDateRepresentation : date de la représentation
     */
    public void setDateRepresentation(String strDateRepresentation) {
        this.s_DateRepresentation = strDateRepresentation;
    }
    
    /**
     * 
     * @param objLieu : Le lieu auquel la représentation est liée 
     */
    public void setLieu(Lieu objLieu) {
        this.o_Lieu = objLieu;
    }
    
    /**
     * 
     * @param objGroupe : Le Groupe auquel la représentation est liée 
     */
    public void setGroupe(Groupe objGroupe) {
        this.o_Groupe = objGroupe;
    }

    /**
     * 
     * @param strHeureDebutRepresentation : L'heure du début de la représentation 
     */
    public void setHeureDebRepresentation(String strHeureDebutRepresentation) {
        this.s_HeureDebutRepresentation = strHeureDebutRepresentation;
    }

    /**
     * 
     * @param strHeureFinRepresentation : L'heure de fin estimé pour la représentation 
     */
    public void setHeureFinRepresentation(String strHeureFinRepresentation) {
        this.s_HeureFinRepresentation = strHeureFinRepresentation;
    }
    
    /**
     * 
     * @param intNombrePlacesRestantes : Nombre de places vendable encore pour la représentation
     */
    public void setNbPlacesRestantes(int intNombrePlacesRestantes) {
        this.i_NbPlacesRestantes = intNombrePlacesRestantes;
    }
}
