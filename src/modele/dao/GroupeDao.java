/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Groupe;

/**
 *
 * @author btssio
 */
public class GroupeDao {
    
    public static Groupe selectOne(int idGroupe ) throws SQLException {
        Groupe unGroupe  = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM GROUPE WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idGroupe );
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String nom = rs.getString("NOM");
            String adressePostale = rs.getString("ADRESSEPOSTALE");
            String identiteResponsable = rs.getString("IDENTITERESPONSABLE");
            String nbPersonne = rs.getString("NBPERSONNE");
            String nomPays = rs.getString("NOMPAYS");
            String hebergement = rs.getString("HEBERGEMENT");
            unGroupe  = new Groupe (id, nom, adressePostale, identiteResponsable, nbPersonne, nomPays, hebergement);
        }
        return unGroupe ;
    }
}
