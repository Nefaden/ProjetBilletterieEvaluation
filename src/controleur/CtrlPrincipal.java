package controleur;

import static controleur.EnumAction.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vue.VueRepresentation;
import modele.dao.Jdbc;

/**
 * Controleur principal
 *
 * @author ydurand
 */
public class CtrlPrincipal {

    private CtrlRepresentation ctrlRepresentation = null; // LE CONTROLEUR DES REPRESENTATIONS
    private CtrlVentes ctrlVentes = null;
    private CtrlMenu ctrlMenu = null;

    /**
     * action par défaut action au démarrage de l'application
     */
    public void action() throws SQLException {
        if (ctrlRepresentation == null) {
            ctrlRepresentation = new CtrlRepresentation(this);
            ctrlRepresentation.getVue().setTitle("Vente des billets pour le festival 'Folklore du Monde'");
        }
        ctrlRepresentation.getVue().setEnabled(true);
        ctrlRepresentation.getVue().setVisible(true);
    }

    public void action(EnumAction action) throws SQLException {
        switch (action) {
            case MENU_REPRESENTATION_AFFICHER: // activation de vueRepresentation depuis vueMenu
                menuRepresentationAfficher();
                break;
            case REPRESENTATION_QUITTER:    // retour à vueMenu depuis la vueRepresentation
                representationQuitter();
                break;
            case MENU_QUITTER: // fin de l'application depuis le menu principal
                menuQuitter();
                break;
        }

    }
    
     /**
     * Fin définitive de l'application La demande de confirmation est gérée par
     * le contrôleur spécialisé
     */
    private void menuQuitter() {
        try {
            Jdbc.getInstance().deconnecter();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }
    }
    
     /**
     * Transition vueMenu / vueRepresentation
     */
    private void menuRepresentationAfficher() throws SQLException {
        if (ctrlRepresentation == null) {
            ctrlRepresentation = new CtrlRepresentation(this);
        } else {
            // si le contrôleur et sa vue existent déjà
        }
        // vuPresence est une fenêtre modale :
        // -> vueMenu reste visible, mais n'est pas active
        ctrlMenu.getVue().setEnabled(false);
        ctrlRepresentation.getVue().setEnabled(true);
        ctrlRepresentation.getVue().setVisible(true);
    }
    
     /**
     * Transition vueRepresentation / vueMenu
     */
    private void representationQuitter() {
        if (ctrlMenu == null) {
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlRepresentation.getVue().setVisible(false);
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }
}
