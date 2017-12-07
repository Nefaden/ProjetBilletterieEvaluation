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
import vue.vueRepresentation;

/**
 *
 * @author ydurand
 */
public class CtrlRepresentation implements WindowListener {
    
    private vueRepresentation vue;
    
    public CtrlRepresentation(vueRepresentation vue) throws SQLException {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        List<Representation> lesRepresentations = null;
        lesRepresentations = RepresentationDao.selectAll();
               
    }
    
    private void afficherRepresentation(List<Representation> desRepresentation) {
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Groupe", "lieu", "date", "heure Debut", "Heure Fin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[5];
        for (Representation uneRepresentation : desRepresentation) {
            ligneDonnees[0] = uneRepresentation.getIdGroupe();
            ligneDonnees[1] = uneRepresentation.getIdLieu();
            ligneDonnees[2] = uneRepresentation.getDateRepresentation();
            ligneDonnees[3] = uneRepresentation.getHeureDebRepresentation();
            ligneDonnees[4] = uneRepresentation.getHeureFinRepresentation();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);
        }
    }
    
    
    
    
    
    
    
    
    public vueRepresentation getVue() {
        return vue;
    }

    public void setVue(vueRepresentation vue) {
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
