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
        Representation uneRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRepresentation);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id_Groupe = rs.getString("ID_groupe");
            int id_Lieu = rs.getInt("ID_Lieu");
            String date_representation = rs.getString("DATEREPR");
            Groupe unGroupe = GroupeDao.getOneById(id_Groupe);
            Lieu unLieu = LieuDao.getOneById(id_Lieu);
            String heureDebut = rs.getString("HEURE_DEBUT");
            String heureFin = rs.getString("HEURE_FIN");
            int nbPlacesRestantes = rs.getInt("NOMBRE_PLACE_RESTANTE");
            uneRepresentation =  new Representation(idRepresentation, date_representation, unLieu, unGroupe, heureDebut, heureFin, nbPlacesRestantes);
        }
        return uneRepresentation;
    }

    /**
     * Extraction de toutes les representations
     * @return collection de representation
     * @throws SQLException 
     */
    public static List<Representation> getAll() throws SQLException {
        List<Representation> lesRepresentations = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String id_Groupe = rs.getString("ID_groupe");
            int id_Lieu = rs.getInt("ID_Lieu");
            String date_representation = rs.getString("DATEREPR");
            Groupe unGroupe = GroupeDao.getOneById(id_Groupe);
            Lieu unLieu = LieuDao.getOneById(id_Lieu);
            String heureDebut = rs.getString("HEURE_DEBUT");
            String heureFin = rs.getString("HEURE_FIN");
            int nbPlacesRestantes = rs.getInt("NOMBRE_PLACE_RESTANTE");
            uneRepresentation =  new Representation(id, date_representation, unLieu, unGroupe, heureDebut, heureFin, nbPlacesRestantes);
            lesRepresentations.add(uneRepresentation);
        }
        return lesRepresentations;
    }
}