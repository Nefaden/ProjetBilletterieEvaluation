package controleur;

import static controleur.EnumAction.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modele.dao.Jdbc;

/**
 * Controleur principal
 *
 * @author ydurand
 */
public class CtrlPrincipal {

    private CtrlConnexion ctrlConnexion = null; // Controller des connexions
    private CtrlRepresentation ctrlRepresentation = null; // LE CONTROLEUR DES REPRESENTATIONS
    private CtrlReservation ctrlReservation = null; // LE CONTROLEUR D'UNE REPRESENTATION
    private CtrlMenu ctrlMenu = null;//test de push

    /**
     * action par défaut action au démarrage de l'application
     */
    public void action() throws SQLException {
        if (ctrlConnexion == null) {
            ctrlConnexion = new CtrlConnexion(this);
        }
        ctrlConnexion.getVue().setEnabled(true);
        ctrlConnexion.getVue().setVisible(true);
    }

    public void action(EnumAction action) throws SQLException {
        switch (action) {
            case CONNEXION_AFFICHER_MENU_PRINCIPAL: // Activation du menu principal après connexion
                menuPrincipalAfficher();
                break;
            case MENU_REPRESENTATION_AFFICHER: // activation de vueRepresentation depuis vueMenu
                menuRepresentationAfficher();
                break;
            case REPRESENTATION_QUITTER:    // retour à vueMenu depuis la vueRepresentation
                representationQuitter();
                break;
            case VENTES_QUITTER:
                venteQuitter();
            case MENU_QUITTER: // fin de l'application depuis le menu principal
                menuFichierQuitter();
                break;
        }
    }
    
    /**
     * Appel d'un constructeur avec un échange de variable de type String
     */
    public void action(EnumAction action, int idRepresentationSelect) throws SQLException {
        switch (action) {
            case REPRESENTATION_DETAILS: // activation de vueUneRepresentation depuis vueRepresentation
                menuRepresentationDetail(idRepresentationSelect);
                break;
        }            
    }
    
    /**
     * Fin définitive de l'application La demande de confirmation est gérée par
     * le contrôleur spécialisé
     */
    private void menuFichierQuitter() {
        try {
            Jdbc.getInstance().deconnecter();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }
    }
    
    /**
     * Transition VueConnexion / VueMenuPrincipal
     */
    private void menuPrincipalAfficher() throws SQLException {
        if (ctrlMenu == null) {
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlConnexion.getVue().setEnabled(false);
        ctrlConnexion.getVue().setVisible(false);
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }
    
    /**
     * Transition vueMenu / vueRepresentation
     */
    private void menuRepresentationAfficher() throws SQLException {
        if (ctrlRepresentation == null) {
            ctrlRepresentation = new CtrlRepresentation(this);
        }
        ctrlMenu.getVue().setEnabled(false);
        ctrlMenu.getVue().setVisible(false);
        ctrlRepresentation.getVue().setVisible(true);
        ctrlRepresentation.getVue().setEnabled(true);
    }
    
    /**
     * 
     * @throws SQLException 
     * Methode pour afficher la vue de la représentation selectionnée
     */
    private void menuRepresentationDetail(int idRepresentationSelect) throws SQLException {
        if (ctrlReservation == null) {
            ctrlReservation = new CtrlReservation(this, idRepresentationSelect);
        }
        ctrlRepresentation.getVue().setEnabled(false);
        ctrlRepresentation.getVue().setVisible(false);
        ctrlReservation.getVue().setVisible(true);
        ctrlReservation.getVue().setEnabled(true);
    }
    
    /**
     * Transition vueRepresentation / vueMenu
     */
    private void representationQuitter() {
        if (ctrlMenu == null) 
            ctrlMenu = new CtrlMenu(this);       
        ctrlRepresentation.getVue().setVisible(false);
        ctrlRepresentation.getVue().setEnabled(false);
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }
    
    /**
     * Transition vueLesVentes / vueRepresentation
     */
    private void venteQuitter() throws SQLException {
        if (ctrlRepresentation == null) 
            ctrlRepresentation = new CtrlRepresentation(this);       
        ctrlRepresentation.getVue().setVisible(true);
        ctrlRepresentation.getVue().setEnabled(true);
        ctrlReservation.getVue().setEnabled(false);
        ctrlReservation.getVue().setVisible(false);
    }
}
