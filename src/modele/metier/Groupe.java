/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author ydurand
 */
public class Groupe {
    
    private int id;
    private String nom;
    private String adressePostale;
    private String identiteResponsable;
    private String nbPersonne;
    private String nomPays;
    private String hebergement;
    
    public Groupe(int id, String nom, String adressePostale, String identiteResponsable, String nbPersonne, String nomPays, String hebergement) {
    
        this.id=id;
        this.nom=nom;
        this.adressePostale=adressePostale;
        this.identiteResponsable=identiteResponsable;
        this.nbPersonne=nbPersonne;
        this.nomPays=nomPays;
        this.hebergement=hebergement;
}

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public String getIdentiteResponsable() {
        return identiteResponsable;
    }

    public String getNbPersonne() {
        return nbPersonne;
    }

    public String getNomPays() {
        return nomPays;
    }

    public String getHebergement() {
        return hebergement;
    }
    
}
