/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.sql.Time;

/**
 *
 * @author gdoucet
 */
public class Representation {
    
    private int id;
    private String date;
    private int id_lieu;
    private String id_groupe;
    private String heureDeb;
    private String heureFin;
    
    public Representation(int id, String date_representation, int id_lieu, String id_groupe, String heureDebut_representation, String heureFin_representation) {
        this.id = id;
        this.date = date_representation;
        this.id_lieu = id_lieu;
        this.id_groupe = id_groupe;
        this.heureDeb = heureDebut_representation;
        this.heureFin = heureFin_representation;
    }
    
    public int getIdRepresentation() {
        return id;
    }
    public String getDateRepresentation() {
        return date;
    }
    public int getIdLieu() {
        return id_lieu;
    }
    public String getIdGroupe() {
        return id_groupe;
    }
    public String getHeureDebRepresentation() {
        return heureDeb;
    }
    public String getHeureFinRepresentation() {
        return heureFin;
    }
        
}
