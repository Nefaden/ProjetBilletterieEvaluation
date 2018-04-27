package modele.metier;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe représentant les utilisateurs pour permettre la connexion à l'application
 * 
 * @author ydurand
 * @v1.0
 */
@Entity(name = "Utilisateur")
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {
    
    @Id
    @Column(name = "idUtilisateur", length = 11)
    private int i_Id;
    @Column(name = "nom", length = 40)
    private String s_Nom;
    @Column(name = "prenom", length = 40)
    private String s_Prenom;
    @Column(name = "nomUtilisateur", length = 40)
    private String s_NomUtilisateur;
    @Column(name = "motDePasse", unique=true, length = 40)
    private String s_MotDePasse;
    
    /**
     * 
     * Void Constructor for Mapping JPA
     */
    public Utilisateur() {}
    
    /**
     * Constructeur avec les 4 attributs
     * @param intId:  identifiant DB de la reservation
     * @param strNomUtilsateur : Nom d'utilisateur de la base de données
     * @param strMotDePasse : Mot de passe lié à un utilisateur
     */
    public Utilisateur(int intId, String strNom, String strPrenom, String strNomUtilisateur, String strMotDePasse) {
        this.i_Id = intId;
        this.s_Nom = strNom;
        this.s_Prenom = strPrenom;
        this.s_NomUtilisateur = strNomUtilisateur;
        this.s_MotDePasse = strMotDePasse;
    }
    
    /**
     *
     * @return String attributs de la reservation
     */
    @Override
    public String toString() {
        return ("Utilisateur { nom de l'utilisateur: " + this.getNom() + "\tPrenom de l'utilisateur: " + this.getPrenom() + "\tNom d'utilisateur: " + this.getNomUtilisateur() + "\tmot de passe: " + this.getMotDePasse() + "}");
    }
    
    //Getter / Setter de la classe Reservation
    
    /**
     *
     * @return int id du client dans la DB
     */
    public int getIdUtilisateur() {
        return i_Id;
    }
    
    /**
     * 
     * @param intId : identifiant du client dans la DB
     */
    public void setIdUtilisateur(int intId) {
        this.i_Id = intId;
    }
    
    /**
     * 
     * @return String nom de l'utilisateur
     */
    public String getNom() {
        return s_Nom;
    }
    
    /**
     * 
     * @param strNom : Le nom d'un utilisateur
     */
    public void setNom(String strNom) {
        this.s_Nom = strNom;
    }
    
    /**
     * 
     * @return String prenom de l'utilisateur
     */
    public String getPrenom() {
        return s_Prenom;
    }
    
    /**
     * 
     * @param strPrenom : Le prenom d'un utilisateur
     */
    public void setPrenom(String strPrenom) {
        this.s_Prenom = strPrenom;
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
        this.s_MotDePasse = strMotDePasse;
    }
}
