package modele.metier;

/**
 * Classe Groupe, le groupe jouant durant la representation
 * @author mroux
 * v1,0
 */
public class Groupe {
    
    private String id;
    private String nom;
    private String adressePostale;
    private String identiteResponsable;
    private int nbPersonne;
    private String nomPays;
    private String hebergement;
    
    
     /**
     * Constructeur avec les 7 attributs
     * @param id : identifiant DB du lieu
     * @param nom
     * @param adressePostale     
     * @param identiteResponsable
     * @param nbPersonne
     * @param nomPays
     * @param hebergement
     */
    public Groupe(String id, String nom, String adressePostale, String identiteResponsable, int nbPersonne, String nomPays, String hebergement) {
    
        this.id=id;
        this.nom=nom;
        this.adressePostale=adressePostale;
        this.identiteResponsable=identiteResponsable;
        this.nbPersonne=nbPersonne;
        this.nomPays=nomPays;
        this.hebergement=hebergement;
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
     * @return int identifiant du groupe dans la DB
     */
    public String getId() {
        return id;
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
     * @return String l'adresse postale du groupe
     */
    public String getAdressePostale() {
        return adressePostale;
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
     * @return int nombre de personne dans le groupe
     */
    public int getNbPersonne() {
        return nbPersonne;
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
     * @return String si le groupe est héberger ou non
     */
    public String getHebergement() {
        return hebergement;
    }
    
}
