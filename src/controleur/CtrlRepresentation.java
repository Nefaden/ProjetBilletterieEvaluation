/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import modele.dao.RepresentationDao;
import modele.metier.Representation;
import vue.VueRepresentation;

/**
 *
 * @author ydurand
 */
public class CtrlRepresentation implements WindowListener {
    
    private VueRepresentation vue;
    
    public CtrlRepresentation(VueRepresentation vue) throws SQLException {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        List<Representation> lesRepresentations = null;
        lesRepresentations = RepresentationDao.getAll();
        afficherRepresentation(lesRepresentations);
    }
    
    private void afficherRepresentation(List<Representation> desRepresentation) {
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[5];
        for (Representation uneRepresentation : desRepresentation) {
            ligneDonnees[0] = uneRepresentation.getGroupe().getNom();
            ligneDonnees[1] = uneRepresentation.getLieu().getNomLieu();
            ligneDonnees[2] = uneRepresentation.getDateRepresentation();
            ligneDonnees[3] = uneRepresentation.getHeureDebRepresentation();
            ligneDonnees[4] = uneRepresentation.getHeureFinRepresentation();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);
        }
    }
    
    
    
    
    
    
    
    
    public VueRepresentation getVue() {
        return vue;
    }

    public void setVue(VueRepresentation vue) {
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
    
}
