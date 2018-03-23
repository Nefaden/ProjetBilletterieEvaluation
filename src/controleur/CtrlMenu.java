package controleur;

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
 * @author ydurand
 * @version 1 
 */

public class CtrlMenu extends ControleurGenerique implements ActionListener, WindowListener {

    public CtrlMenu(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueMenuPrincipal();
        vue.addWindowListener(this);
        getVue().getjMenuItemQuitter().addActionListener(this);
        getVue().getjMenuItemRepresentationAfficher().addActionListener(this);
        getVue().getjMenuItemVente().addActionListener(this);
    }

    /**
     * clic sur la commande Quitter du menu Fichier Le contrôleur délègue
     * l'action au contrôleur frontal
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
     * clic sur la commande Afficher les représentation du menu Representation Le contrôleur délègue
     * l'action au contrôleur frontal
     */
    public void representationAfficher() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION_AFFICHER);
    }

    /**
     * clic sur la commande Ajouter du menu presence Le contrôleur délègue
     * l'action au contrôleur frontal
     */
    public void representationDetails() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_DETAILS);
    }
    
    @Override
    public VueMenuPrincipal getVue() {
        return (VueMenuPrincipal) vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVue().getjMenuItemQuitter())){
            try {
                menuFichierQuitter();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             if (e.getSource().equals(getVue().getjMenuItemRepresentationAfficher()));
            try {
                representationAfficher();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
                 }
             }

    @Override
    public void windowOpened(WindowEvent e) {}
  
    @Override
    public void windowClosing(WindowEvent e) {
        try {
            menuFichierQuitter();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
}
