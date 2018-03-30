package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.Utilisateur;

/**
 * Classe UtilisateurDao - Permet la liaison entre la classe modèle et la BDD
 * 
 * @author ydurand
 * v1.0
 */
public class UtilisateurDao {
    
    /**
     * Méthode permettant de sélectionner un groupe via son identifiant dans la table Groupe
     * @param idUtilisateur
     * @return
     * @throws SQLException 
     */
    public static Utilisateur getOneById(int idUtilisateur ) throws SQLException {
        Utilisateur objUtilisateur  = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT idUtilisateur, nom, prenom, nomUtilisateur, motDePasse FROM Utilisateur WHERE IDUTILISATEUR LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idUtilisateur );
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objUtilisateur = UtilisateurDao.utilisateurFromResultSet(rs);
        }
        return objUtilisateur ;
    }
    
    /**
     * 
     * @param arrObjUtilisateur
     * @return ArrayList<Utilisateur> arrObjUtilisateur : La liste de tous les utilisateurs
     * @throws SQLException 
     */
    public static ArrayList<Utilisateur> getAll() throws SQLException {
        
        ArrayList<Utilisateur> arrObjUtilisateur = new ArrayList<Utilisateur>();
        Utilisateur objUtilisateur;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT idUtilisateur, nom, prenom, nomUtilisateur, motDePasse FROM Utilisateur";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            objUtilisateur = UtilisateurDao.utilisateurFromResultSet(rs);
            arrObjUtilisateur.add(objUtilisateur);
        }
        return arrObjUtilisateur;
    }
    
    /**
     * 
     * @param nomUtilisateur
     * @return Utilisateur objUtilisateur : l'utilisateur sélectionner par son nom
     * @throws SQLException 
     */
    public static Utilisateur getOneByName(String nomUtilisateur) throws SQLException {
        Utilisateur objUtilisateur = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT idUtilisateur, nom, prenom, nomUtilisateur, motDePasse FROM Utilisateur WHERE NOMUTILISATEUR = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, nomUtilisateur);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objUtilisateur = UtilisateurDao.utilisateurFromResultSet(rs);
        }
        return objUtilisateur;
    }
    
    /**
     * 
     * @param rs
     * @return Utilisateur objUtilisateur : un stockage des valeurs de l'utilisateur
     * @throws SQLException 
     */
    private static Utilisateur utilisateurFromResultSet(ResultSet rs) throws SQLException {
        Utilisateur objUtilisateur = null;
        int intIdUtilisateur = rs.getInt("IDUTILISATEUR");
        String strNom = rs.getString("NOM");
        String strPrenom = rs.getString("PRENOM");
        String strNomutilisateur = rs.getString("NOMUTILISATEUR");
        String strMotDePasse = rs.getString("MOTDEPASSE");
        objUtilisateur = new Utilisateur(intIdUtilisateur, strNom, strPrenom, strNomutilisateur, strMotDePasse);
        return objUtilisateur;
    }
}

