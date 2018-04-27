package controleur;

import static controleur.EnumAction.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Connexion.Jdbc.Jdbc;
import Connexion.Jdbc.JdbcDist;

/**
 * Controleur principal
 *
 * @author ydurand
 * @v1.0
 */
public class CtrlPrincipal {

    private CtrlAuthentificationLocale ctrlAuthentificationLocale = null; // Controller des connexions
    private CtrlRepresentation ctrlRepresentation = null; // LE CONTROLEUR DES REPRESENTATIONS
    private CtrlVentePlace ctrlVentePlace = null; // LE CONTROLEUR D'UNE REPRESENTATION
    private CtrlMenuPrincipal ctrlMenuPrincipal = null; // Le controller du menu principal
    private CtrlConnexionDistante ctrlConnexionDistante = null; // le controller des connexions via la BDD
    
    /**
     * action par défaut action au démarrage de l'application
     */
    public void action() throws SQLException {
        if (ctrlAuthentificationLocale == null) {
            ctrlAuthentificationLocale = new CtrlAuthentificationLocale(this);
        }
        ctrlAuthentificationLocale.getVue().setEnabled(true);
        ctrlAuthentificationLocale.getVue().setVisible(true);
    }

    /**
     * Enum all available action and link between controller
     * @param action
     * @throws SQLException 
     */
    public void action(EnumAction action) throws SQLException {
        switch (action) {
            case AUTHENTIFICATION_AFFICHER_MENU_PRINCIPAL: // Activation du menu principal après connexion
                menuPrincipalAfficher();
                break;
            case CONNEXION_AFFICHER_MENU_PRINCIPAL: // Activation du menu principal après connexion
                menuPrincipalRetour();
                break;
            case MENU_CONNEXION_DISTANTE: // Active la vue pour se connecter à la base distante
                connexionDistanteAfficher();
                break;
            case MENU_REPRESENTATION_AFFICHER: // activation de vueRepresentation depuis vueMenu
                representationAfficher();
                break;
            case REPRESENTATION_QUITTER:    // retour à vueMenu depuis la vueRepresentation
                representationQuitter();
                break;
            case VENTES_QUITTER:
                venteQuitter();
                break;
            case CONNEXION_DISTANTE_QUITTER: // Active la vue pour se connecter à la base distante
                connexionDistanteQuitter();
                break;
            case MENU_QUITTER: // fin de l'application depuis le menu principal
                menuFichierQuitter();
                break;
        }
    }
    
    /**
     * 
     * Appel d'un constructeur avec un échange de variable de type String
     * @throws SQLException 
     */
    public void action(EnumAction action, int idRepresentationSelect) throws SQLException {
        switch (action) {
            case REPRESENTATION_VENTE: // activation de vueUneRepresentation depuis vueRepresentation
                venteAfficher(idRepresentationSelect);
                break;
        }            
    }
    
    /**
     * 
     * Fin définitive de l'application La demande de confirmation est gérée par
     * le contrôleur spécialisé
     * @throws SQLException
     */
    private void menuFichierQuitter() throws SQLException {
        try {
            Jdbc.getInstance().deconnecter();
            if (CtrlConnexionDistante.estConnecter != false)
                JdbcDist.getInstance().deconnecter();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }
    }
    
    /**
     * 
     * Transition VueAuthentificationLocale / VueMenuPrincipal
     * @throws SQLException
     */
    private void menuPrincipalAfficher() throws SQLException {
        if (ctrlMenuPrincipal == null) {
            ctrlMenuPrincipal = new CtrlMenuPrincipal(this);
        }
        ctrlAuthentificationLocale.getVue().setEnabled(false);
        ctrlAuthentificationLocale.getVue().setVisible(false);
        ctrlMenuPrincipal.getVue().setEnabled(true);
        ctrlMenuPrincipal.getVue().setVisible(true);
    }
    
    /**
     * 
     * Transition VueConnexionDistante / VueMenuPrincipal
     * @throws SQLException
     */
    private void menuPrincipalRetour() throws SQLException {
        if (ctrlMenuPrincipal == null) {
            ctrlMenuPrincipal = new CtrlMenuPrincipal(this);
        }
        ctrlConnexionDistante.getVue().setEnabled(false);
        ctrlConnexionDistante.getVue().setVisible(false);
        ctrlConnexionDistante = null;
        ctrlMenuPrincipal.getVue().setEnabled(true);
    }
    
    /**
     * 
     * Transition vueMenuPrincipal / VueConnexionDistante
     * @throws SQLException 
     */
    private void connexionDistanteAfficher() throws SQLException {
        if (ctrlConnexionDistante == null) {
            ctrlConnexionDistante = new CtrlConnexionDistante(this);
        }
        ctrlConnexionDistante.getVue().setEnabled(true);
        ctrlConnexionDistante.getVue().setVisible(true);
        ctrlMenuPrincipal.getVue().setEnabled(false);
        ctrlMenuPrincipal.getVue().setVisible(false);
        ctrlMenuPrincipal.getVue().dispose();
    }
    
    /**
     * 
     * Transition vueMenu / vueRepresentation
     * @throws SQLException
     */
    private void representationAfficher() throws SQLException {
        if (ctrlRepresentation == null) {
            ctrlRepresentation = new CtrlRepresentation(this);
        }
        ctrlMenuPrincipal.getVue().setEnabled(false);
        ctrlMenuPrincipal.getVue().setVisible(false);
        ctrlMenuPrincipal.getVue().dispose();
        ctrlRepresentation.getVue().setVisible(true);
        ctrlRepresentation.getVue().setEnabled(true);
    }
    
    /**
     * 
     * Transition vueRepresentation / vueMenu
     * @throws SQLException
     */
    private void representationQuitter() {
        if (ctrlMenuPrincipal == null) 
            ctrlMenuPrincipal = new CtrlMenuPrincipal(this);       
        ctrlRepresentation.getVue().setVisible(false);
        ctrlRepresentation.getVue().setEnabled(false);
        ctrlMenuPrincipal.getVue().setEnabled(true);
        ctrlMenuPrincipal.getVue().setVisible(true);
        ctrlRepresentation.getVue().dispose();
    }
    
    /**
     * 
     * @throws SQLException 
     * Methode pour afficher la vue de la représentation selectionnée
     */
    private void venteAfficher(int idRepresentationSelect) throws SQLException {
        if (ctrlVentePlace == null) {
            ctrlVentePlace = new CtrlVentePlace(this, idRepresentationSelect);
        }
        ctrlRepresentation.getVue().setEnabled(false);
        ctrlRepresentation.getVue().setVisible(false);
        ctrlRepresentation.getVue().dispose();
        ctrlVentePlace.getVue().setVisible(true);
        ctrlVentePlace.getVue().setEnabled(true);
    }
    
    /**
     * 
     * Transition vueLesVentes / vueRepresentation
     * @throws SQLException
     */
    private void venteQuitter() throws SQLException {
        if (ctrlRepresentation == null) 
            ctrlRepresentation = new CtrlRepresentation(this);       
        ctrlRepresentation.getVue().setVisible(true);
        ctrlRepresentation.getVue().setEnabled(true);
        ctrlVentePlace.getVue().setEnabled(false);
        ctrlVentePlace.getVue().setVisible(false);
        ctrlVentePlace.getVue().dispose();
        ctrlVentePlace = null;
    }
    
    /**
     * 
     * @throws SQLException 
     */
    private void connexionDistanteQuitter() throws SQLException {
        if (ctrlMenuPrincipal == null) 
            ctrlMenuPrincipal = new CtrlMenuPrincipal(this);       
        ctrlMenuPrincipal.getVue().setVisible(true);
        ctrlMenuPrincipal.getVue().setEnabled(true);
        ctrlConnexionDistante.getVue().setEnabled(false);
        ctrlConnexionDistante.getVue().setVisible(false);
        ctrlConnexionDistante.getVue().dispose();
    }
}
