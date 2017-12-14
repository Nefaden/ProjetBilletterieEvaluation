package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.*;
import modele.metier.Representation;
import vue.VueRepresentation;

/**
 * Contrôleur permettant l'affichage et la sélection des représentation dans la
 * vueRepresentation
 *
 * @author ydurand v1.0
 */
public class CtrlRepresentation extends ControleurGenerique implements WindowListener, MouseListener {

    private final RepresentationDao representationdao = new RepresentationDao();
    private List<Representation> lesRepresentations;

    public CtrlRepresentation(CtrlPrincipal ctrlPrincipal) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueRepresentation();
        afficherRepresentation();
        vue.addWindowListener(this);

        afficherRepresentation();
    }

    //méthode pour afficher la liste des représentation via la methode sel
    private void afficherRepresentation() throws SQLException {
        String msg = ""; // message à afficher en cas d'erreur
        ((VueRepresentation) vue).getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        ((VueRepresentation) vue).getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[5];
        lesRepresentations = RepresentationDao.getAll();
        for (Representation uneRepresentation : lesRepresentations) {
            ligneDonnees[0] = uneRepresentation.getGroupe().getNom();
            ligneDonnees[1] = uneRepresentation.getLieu().getNomLieu();
            ligneDonnees[2] = uneRepresentation.getDateRepresentation();
            ligneDonnees[3] = uneRepresentation.getHeureDebRepresentation();
            ligneDonnees[4] = uneRepresentation.getHeureFinRepresentation();
            ((VueRepresentation) vue).getModeleTableRepresentation().addRow(ligneDonnees);
        }
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
