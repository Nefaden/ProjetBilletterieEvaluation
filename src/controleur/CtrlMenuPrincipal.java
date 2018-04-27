package controleur;

import Connexion.Jdbc.Jdbc;
import Connexion.Jdbc.JdbcDist;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vue.VueMenuPrincipal;

/**
 * Contrôleur de la fenêtre VueMenu
 *
 * @author ydurand
 * @v1.0
 */
public class CtrlMenuPrincipal extends ControleurGenerique implements ActionListener, WindowListener {

    // Constructeur du controller du menu principal
    public CtrlMenuPrincipal(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        this.vue = new VueMenuPrincipal();
        this.vue.addWindowListener(this);
        this.getVue().getjMenuItemConnexion().addActionListener(this);
        this.getVue().getjMenuItemQuitter().addActionListener(this);
        this.getVue().getjMenuItemRepresentationAfficher().addActionListener(this);
        this.getVue().getjMenuItemVente().addActionListener(this);
    }

    /**
     * clic sur la commande Quitter du menu Fichier ou la croix de la fenêtre Le
     * contrôleur délègue l'action au contrôleur frontal
     */
    public void menuFichierQuitter() throws SQLException {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "root", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
        }
    }

    /**
     * clic sur la commande Afficher les représentation du menu Representation
     * Le contrôleur délègue l'action au contrôleur frontal
     */
    public void representationAfficher() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION_AFFICHER);
    }

    /**
     * clic sur la commande Ajouter du menu vente Le contrôleur délègue l'action
     * au contrôleur frontal
     */
    public void representationVente() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_VENTE);
    }

    /**
     *
     * Clic sur la commande du menu fichier pour afficher l'écran de connexion
     *
     * @throws SQLException
     */
    public void afficherConnexion() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.MENU_CONNEXION_DISTANTE);
    }

    /**
     *
     * @return (VueMenuPrincipal) vue : Getter de la vue du menu principal
     */
    @Override
    public VueMenuPrincipal getVue() {
        return (VueMenuPrincipal) vue;
    }

    /**
     *
     * @param e : évenement lié aux objets contenu dans les menus déroulants
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVue().getjMenuItemQuitter())) {
            try {
                menuFichierQuitter();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource().equals(getVue().getjMenuItemRepresentationAfficher()));
        {
            try {
                representationAfficher();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource().equals(getVue().getjMenuItemConnexion())) {
            try {
                afficherConnexion();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //action sur le menu item se deconnecter
        if (e.getSource().equals(this.getVue().getjMenuItemDeconnexion())) {
            if (CtrlConnexionDistante.estConnecter != false) {
                this.getVue().getjMenuItemConnexion().setVisible(true);
                this.getVue().getjMenuItemConnexion().setEnabled(true);
                try {
                    Jdbc.getInstance().deconnecter();
                    CtrlConnexionDistante.estConnecter = false;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD distante", JOptionPane.ERROR_MESSAGE);
                } 
                JOptionPane.showMessageDialog(null, "Deconnecté");
            }

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            menuFichierQuitter();

        } catch (SQLException ex) {
            Logger.getLogger(CtrlMenuPrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
