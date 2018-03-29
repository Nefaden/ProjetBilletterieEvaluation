package test.modele.dao;

import java.sql.*;
import java.util.List;
import modele.dao.RepresentationDao;
import modele.dao.Jdbc;
import modele.metier.Representation;

/**
 *
 * @author ydurand
 * Classe de test pour la couche DAO de representation
 */
public class RepresentationDaoTest {
    
        public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(1);
            System.out.println("Test1 effectué : sélection unique\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur de fermeture de la connexion JDBC : " + e);
            }
        }

    }
        
    /**
     * Vérifie qu'une connexion peut être ouverte sur le SGBD
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql://", "localhost/", "ydurand_festival", "ydurand_festival_util", "secret");
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche une adresse d'après son identifiant
     * @throws SQLException
     */
    public static void test1_SelectUnique(int idRepresentation) throws SQLException {
        Representation cetteRepresentation = RepresentationDao.getOneById(idRepresentation);
        System.out.println("Representation d'identifiant : "+idRepresentation+" : "+cetteRepresentation.toString());
    }

    /**
     * Affiche toutes les villes
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Representation> desRepresentation = RepresentationDao.getAll();
        System.out.println("Les representations lues : "+desRepresentation.toString());
    }
}
