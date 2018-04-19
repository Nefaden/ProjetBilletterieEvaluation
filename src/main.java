
import controleur.CtrlPrincipal;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import modele.dao.Jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Classe Main - S'exécute au lancement de l'appli - Contient les connexions à
 * la DB -
 *
 * @author ydurand v1.0
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        final Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src/config/accessDB.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            // Changer le dbdist en sgbd pour utiliser le main en local DB
            String driver = prop.getProperty("sgbd.driver");
            String jdbc = prop.getProperty("sgbd.jdbc");
            String pass = prop.getProperty("sgbd.pass");
            String databasename = prop.getProperty("sgbd.databasename");
            String login = prop.getProperty("sgbd.login");
            String password = prop.getProperty("sgbd.password");

            Jdbc.creer(driver, jdbc, pass, databasename, login, password);

        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }

        CtrlPrincipal ctrlPrincipal;

        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Main - connexion à la BDD - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Main - connexion à la BDD", JOptionPane.ERROR_MESSAGE);
        }

        // Pour lancer l'application, instancier le contrôleur principal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();

    }
}
