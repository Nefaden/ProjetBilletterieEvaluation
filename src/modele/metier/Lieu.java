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
public class Lieu {
    
    private int id;
    private String nom;
    private String adr;
    private int capacite;

    
    public Lieu(int id, String nom, String adresse, int capacite) {
        this.id = id;
        this.nom = nom;
        this.adr = adresse;
        this.capacite = capacite;

    }
    
    public int getIdLieu() {
        return id;
    }
    public String getNomLieu() {
        return nom;
    }
    public String getAdresseLieu() {
        return adr;
    }
    public int getCapaciteLieu() {
        return capacite;
    }

    
}
