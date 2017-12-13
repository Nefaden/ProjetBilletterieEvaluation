/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.swing.JOptionPane;
import vue.VueRepresentation;

/**
 *
 * @author ydurand
 */
public class CtrlPrincipal {
    
    private CtrlRepresentation ctrlRepresentation = null; // LE CONTROLEUR DES REPRESENTATIONS
    
    public CtrlPrincipal(CtrlRepresentation ctrlRepresentation) {
        ctrlRepresentation.getVueRepresentation().setVisible(true);
    }
    
    private void transitionRepresentationVersReserver() {
        ctrlRepresentation.getVueRepresentation().setVisible(false);
        ctrlReservation.getVueReservation().setVisible(true);
    }

    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVueRepresentation(), "Quitter l'application\nEtes-vous sûr(e) ?", "root", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
}
