package modele.metier;

/**
 * Classe représentant les utilisateurs pour permettre la connexion à l'application
 * 
 * @author ydurand
 * v1.0
 */
public class Utilisateur {
    
    private int i_Id;
    private String s_NomUtilisateur;
    private String s_MotDePasse;
    
    /**
     * Constructeur avec les 4 attributs
     * @param intId:  identifiant DB de la reservation
     * @param strNomUtilsateur : Nom d'utilisateur de la base de données
     * @param strMotDePasse : Mot de passe lié à un utilisateur
     */
    public Utilisateur(int intId, String strNomUtilisateur, String strMotDePasse) {
        this.i_Id = intId;
        this.s_NomUtilisateur = strNomUtilisateur;
        this.s_MotDePasse = strMotDePasse;
    }
    
    /**
     *
     * @return String attributs de la reservation
     */
    @Override
    public String toString() {
        return ("Utilisateur{nom d'utilisateur: " + this.getNomUtilisateur() + "\tmot de passe: " + this.getMotDePasse() + "}");
    }
    
    //Getter / Setter de la classe Reservation
    
    /**
     *
     * @return int id du client dans la DB
     */
    public int getIdClient() {
        return i_Id;
    }
    
    /**
     * 
     * @param intId : identifiant du client dans la DB
     */
    public void setIdClient(int intId) {
        this.i_Id = intId;
    }
    
    /**
     * 
     * @return String nom d'utilisateur
     */
    public String getNomUtilisateur() {
        return s_NomUtilisateur;
    }
    
    /**
     * 
     * @param strNomUtilisateur : Le nom d'authentification à la connexion d'un utilisateur
     */
    public void setNomUtilisateur(String strNomUtilisateur) {
        this.s_NomUtilisateur = strNomUtilisateur;
    }
    
    /**
     * 
     * @return String mot de passe de l'utilisateur
     */
    public String getMotDePasse() {
        return s_MotDePasse;
    }
    
    /**
     * 
     * @param strMotDePasse : Le mot de passe utilisé par l'utilisateur
     */
    public void setMotDePasse(String strMotDePasse) {
        this.s_NomUtilisateur = strMotDePasse;
    }
}
