/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import modele.metier.Representation;
import vue.VueUneRepresentation;

/**
 *
 * @author gdoucet
 */
public class CtrlUneRepresentation implements WindowListener, MouseListener {

    private VueUneRepresentation vue;
    
    public CtrlUneRepresentation(VueUneRepresentation vue) throws SQLException {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
    }
    
    //méthode pour afficher la liste des représentation via la methode sel
    private void afficherUneRepresentation(Representation objRepresentation) {
        getVue().getModeleTableInformation().setRowCount(0);
        String[] titresColonnes = {"Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin", "Adresse"};
        getVue().getModeleTableInformation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[6];
        ligneDonnees[0] = objRepresentation.getGroupe().getNomGroupe();
        ligneDonnees[1] = objRepresentation.getLieu().getNomLieu();
        ligneDonnees[2] = objRepresentation.getDateRepresentation();
        ligneDonnees[3] = objRepresentation.getHeureDebutRepresentation();
        ligneDonnees[4] = objRepresentation.getHeureFinRepresentation();
        ligneDonnees[5] = objRepresentation.getLieu().getAdresseLieu();
        getVue().getModeleTableInformation().addRow(ligneDonnees);
    }
    
    private void afficherNombrePlaces(Representation objRepresentation) {
        getVue().getModeleTablePlaces().setRowCount(0);
        String[] titresCol = {"Nombre de places total", "Places restantes"};
        getVue().getModeleTablePlaces().setColumnIdentifiers(titresCol);
        String[] donnees = new String[2];
        donnees[0] = Integer.toString(objRepresentation.getLieu().getCapaciteLieu());
        donnees[1] = Integer.toString(objRepresentation.getNbPlacesRestantes());
        getVue().getModeleTablePlaces().addRow(donnees);
    }
      
    public VueUneRepresentation getVue() {
        return vue;
    }

    public void setVue(VueUneRepresentation vue) {
        this.vue = vue;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
