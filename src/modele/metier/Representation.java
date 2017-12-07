/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.sql.Time;
import modele.metier.Lieu;
import modele.metier.Groupe;

/**
 *
 * @author gdoucet
 */
public class Representation {
    
    private int id;
    private String date;
    private Lieu unLieu;
    private Groupe unGroupe;
    private String heureDeb;
    private String heureFin;
    
    public Representation(int id, String date_representation, Lieu unLieu, Groupe unGroupe, String heureDebut_representation, String heureFin_representation) {
        this.id = id;
        this.date = date_representation;
        this.unLieu = unLieu;
        this.unGroupe = unGroupe;
        this.heureDeb = heureDebut_representation;
        this.heureFin = heureFin_representation;
    }
    
    public int getIdRepresentation() {
        return id;
    }
    public String getDateRepresentation() {
        return date;
    }
    public Lieu getLieu() {
        return unLieu;
    }
    public Groupe getGroupe() {
        return unGroupe;
    }
    public String getHeureDebRepresentation() {
        return heureDeb;
    }
    public String getHeureFinRepresentation() {
        return heureFin;
    }
        
}
