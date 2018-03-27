package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Groupe;

/**
 * Classe GroupeDao
 * @author mroux
 * v1.0
 */
public class GroupeDao {
    
    /**
     * Méthode permettant de sélectionner un groupe via son identifiant dans la table Groupe
     * @param idGroupe
     * @return
     * @throws SQLException 
     */
    public static Groupe getOneById(String idGroupe ) throws SQLException {
        Groupe objGroupe  = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe WHERE ID LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, idGroupe );
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objGroupe = GroupeDao.groupeFromResultSet(rs);
        }
        return objGroupe ;
    }
    
    public static Groupe getOneByName(String nomGroupe) throws SQLException {
        Groupe objGroupe = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM groupe WHERE NOM= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, nomGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objGroupe = GroupeDao.groupeFromResultSet(rs);
        }
        return objGroupe;
    }
    
    private static Groupe groupeFromResultSet(ResultSet rs) throws SQLException {
        Groupe objGroupe = null;
        String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String adressePostale = rs.getString("ADRESSEPOSTALE");
            String identiteResponsable = rs.getString("IDENTITERESPONSABLE");
            int nbPersonne = rs.getInt("NOMBREPERSONNES");
            String nomPays = rs.getString("NOMPAYS");
            String hebergement = rs.getString("HEBERGEMENT");
        objGroupe = new Groupe(id, nom, adressePostale, identiteResponsable, nbPersonne, nomPays, hebergement);
        return objGroupe;
    }
}
