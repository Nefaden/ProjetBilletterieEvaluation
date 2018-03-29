package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Representation;
import modele.metier.Groupe;
import modele.metier.Lieu;

/**
 * Classe RepresentationDao 
 * @author ydurand
 * v1.0
 */
public class RepresentationDao {
    //Instancier lieu et groupe comme des objets qui vont chercher leurs nom depuis les tables qui leurs sont attitrés
    
    /**
     * Extraction d'une representation, sur son identifiant
     * @param idRepresentation identifiant
     * @return objet Representation
     * @throws SQLException 
     */
    public static Representation getOneById(int idRepresentation) throws SQLException {
        Representation objRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRepresentation);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objRepresentation = RepresentationDao.RepresentationFromResultSet(rs);
        }
        return objRepresentation;
    }
    
    public static Representation getOneByIdGroupe(String idGroupe) throws SQLException {
        Representation objRepresentation = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM representation WHERE ID_GROUPE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, idGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objRepresentation = RepresentationDao.RepresentationFromResultSet(rs);
        }
        return objRepresentation;
    }

    /**
     * Extraction de toutes les representations
     * @return collection de representation
     * @throws SQLException 
     */
    public static ArrayList<Representation> getAll() throws SQLException {
        ArrayList<Representation> arrObjRepresentation = new ArrayList<Representation>();
        Representation objRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT id, daterepr, id_lieu, id_groupe, heure_debut, heure_fin, nombre_place_restante FROM Representation";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            objRepresentation = RepresentationDao.RepresentationFromResultSet(rs);
            arrObjRepresentation.add(objRepresentation);
        }
        return arrObjRepresentation;
    }
    
    private static Representation RepresentationFromResultSet(ResultSet rs) throws SQLException {
        Representation objRepresentation = null;
        int id = rs.getInt("ID");
        String id_Groupe = rs.getString("ID_GROUPE");
        int id_Lieu = rs.getInt("ID_LIEU");
        String date_representation = rs.getString("DATEREPR");
        String heureDebut = rs.getString("HEURE_DEBUT");
        String heureFin = rs.getString("HEURE_FIN");
        int nbPlacesRestantes = rs.getInt("NOMBRE_PLACE_RESTANTE");
        
        Groupe objGroupe = GroupeDao.getOneById(id_Groupe);
        Lieu objLieu = LieuDao.getOneById(id_Lieu);
        objRepresentation =  new Representation(id, date_representation, objLieu, objGroupe, heureDebut, heureFin, nbPlacesRestantes);
        return objRepresentation;
    }
    
    public static void updateNbPlaceRestante(int idRep, int nbPlaces) throws SQLException
    {
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "UPDATE Representation SET nombre_Place_Restante = nombre_Place_Restante - ? WHERE ID = ?;"; 
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, nbPlaces);
        pstmt.setInt(2, idRep);
        pstmt.executeUpdate();
    }
}
