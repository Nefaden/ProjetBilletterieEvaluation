/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modele.dao.Jdbc;
import modele.dao.LieuDao;
import modele.metier.Lieu;
/**
 *
 * @author gdoucet
 */
public class LieuDaoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(1);
            System.out.println("Test1 effectué : sélection unique\n");
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
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql://", "localhost/", "festival", "root", "joliverie");
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche une adresse d'après son identifiant
     * @throws SQLException
     */
    public static void test1_SelectUnique(int idLieu) throws SQLException {
        Lieu ceLieu = LieuDao.selectOneById(idLieu);
        System.out.println("Lieu "+idLieu+" : "+ ceLieu.getNomLieu());
    }

}