package modele.metier;

/**
 * Classe Groupe, le groupe jouant durant la representation
 * 
 * @author mroux
 * v1,0
 */
public class Groupe {
    
    private String s_Id;
    private String s_NomGroupe;
    private String s_AdressePostale;
    private String s_IdentiteResponsable;
    private int i_NbPersonne;
    private String s_NomPays;
    private String s_Hebergement;
    
    
     /**
     * Constructeur avec les 7 attributs
     * @param strId : identifiant DB du lieu
     * @param strNomGroupe
     * @param strAdressePostale     
     * @param intIdentiteResponsable
     * @param intNbPersonne
     * @param strNomPays
     * @param strHebergement
     */
    public Groupe(String strId, String strNomGroupe, String strAdressePostale, String intIdentiteResponsable, int intNbPersonne, String strNomPays, String strHebergement) {
    
        this.s_Id=strId;
        this.s_NomGroupe=strNomGroupe;
        this.s_AdressePostale=strAdressePostale;
        this.s_IdentiteResponsable=intIdentiteResponsable;
        this.i_NbPersonne=intNbPersonne;
        this.s_NomPays=strNomPays;
        this.s_Hebergement = strHebergement;
}
    
    /**
     *
     * @return String attributs du Groupe
     */
    @Override
    public String toString() {
        return ("Groupe{nom: " + this.getNomGroupe() + "\tadresse postale: " + this.getAdressePostale() + "\tindentite du responsable: " + this.getIdentiteResponsable() + "\tNombre de personnes: " + this.getNbPersonne() + "\tNom du Pays : " + this.getNomPays() + "\tHebergement: " + this.getHebergement()) +"}";
    }
    
    /**
     * 
     * @return int identifiant du groupe dans la DB
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
     * @return String le s_NomGroupe du groupe
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
     * @return String si le groupe est héberger ou non
     */
    public String getHebergement() {
        return s_Hebergement;
    }
    
    /**
     * 
     * @param strHebergement : char (booléen) vérifie si oui ou non le groupe est héberger
     */
    public void setHebergement(String strHebergement) {
        this.s_Hebergement = strHebergement;
    }
    
}
