package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vue.VueMenu;

/**
 * Contrôleur de la fenêtre VueMenu
 * @author ydurand
 * @version 1 
 */

public class CtrlMenu extends ControleurGenerique implements ActionListener, WindowListener {

    public CtrlMenu(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueMenu();
        vue.addWindowListener(this);
        getVue().getjMenuItemQuitter().addActionListener(this);
        getVue().getjMenuItemListeEquipiers().addActionListener(this);
        getVue().getjMenuItemPresenceAJouter().addActionListener(this);
    }

    /**
     * clic sur la commande Quitter du menu Fichier Le contrôleur délègue
     * l'action au contrôleur frontal
     */
    public void menuQuitter() throws SQLException {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "root", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
        }
    }

    /**
     * clic sur la commande Ajouter du menu presence Le contrôleur délègue
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
    public VueMenu getVue() {
        return (VueMenu) vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVue().getjMenuItemQuitter())){
            menuQuitter();
        }else{
             if (e.getSource().equals(getVue().getjMenuItemListeEquipiers())){
                 representationDetails();
             }else{
                 if (e.getSource().equals(getVue().getjMenuItemPresenceAJouter())){
                     representationAfficher();
                 }
             }
        }
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}
  
    @Override
    public void windowClosing(WindowEvent e) {
        menuQuitter();
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
