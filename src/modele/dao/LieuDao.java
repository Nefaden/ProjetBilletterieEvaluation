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
 * Classe LieuDao
 * @author gdoucet
 * v1.0
 */
public class LieuDao {
    
    /**
     * Méthode permettant de sélectionner un Lieu par son identifiant dans la table Lieu
     * @param idLieu
     * @return
     * @throws SQLException 
     */
    public static Lieu getOneById(int idLieu) throws SQLException {
        Lieu objLieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Lieu WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String nom = rs.getString("NOM");
            String adr = rs.getString("ADR");
            int capacite = rs.getInt("CAPACITE");
            objLieu = new Lieu(id, nom, adr, capacite);
        }
        return objLieu;
    }
}