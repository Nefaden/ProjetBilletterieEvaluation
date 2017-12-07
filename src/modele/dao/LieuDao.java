/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Lieu;

/**
 *
 * @author gdoucet
 */
public class LieuDao {
    
    public static Lieu selectOneById(int idLieu) throws SQLException {
        Lieu unLieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LIEU WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String nom = rs.getString("NOM");
            String adr = rs.getString("ADR");
            int capacite = rs.getInt("CAPACITE");
            unLieu = new Lieu(id, nom, adr, capacite);
        }
        return unLieu;
    }
  
    
    
}