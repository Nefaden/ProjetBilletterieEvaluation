package modele.metier;

/**
 * Classe Lieu, lieu où sont faites les représentation
 * @author gdoucet
 * v1.0
 */
public class Lieu {
    
    private int id;
    private String nom;
    private String adr;
    private int capacite;

     /**
     * Constructeur avec les 4 attributs
     * @param id : identifiant DB du lieu
     * @param nom
     * @param adresse    
     * @param capacite
     */
    public Lieu(int id, String nom, String adresse, int capacite) {
        this.id = id;
        this.nom = nom;
        this.adr = adresse;
        this.capacite = capacite;

    }
    
     /**
     *
     * @return int id du lieu dans la DB
     */
    public int getIdLieu() {
        return id;
    }
    
    /**
     * 
     * @return String le nom du lieu
     */
    public String getNomLieu() {
        return nom;
    }
    
    /**
     * 
     * @return String l'adresse du lieu
     */
    public String getAdresseLieu() {
        return adr;
    }
    
    /**
     * 
     * @return int la capacité du lieu
     */
    public int getCapaciteLieu() {
        return capacite;
    }

    
}
