import controleur.CtrlPrincipal;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modele.dao.Jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ydurand
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        CtrlPrincipal ctrlPrincipal; 
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        } 
        
        // Pour lancer l'application, instancier le contrôleur principal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();
    }
}
