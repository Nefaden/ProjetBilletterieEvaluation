package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.RepresentationDao;
import modele.metier.Representation;
import vue.VueRepresentation;
import controleur.CtrlUneRepresentation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import vue.VueUneRepresentation;

/**
 * Contrôleur permettant l'affichage et la sélection des représentation dans la
 * vueRepresentation
 *
 * @author ydurand v1.0
 */
public class CtrlRepresentation extends ControleurGenerique implements ActionListener, WindowListener, MouseListener {

    private final RepresentationDao RepresentationDao = new RepresentationDao();
    private List<Representation> lesRepresentations;

    public CtrlRepresentation(CtrlPrincipal ctrlPrincipal) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueRepresentation();
        afficherRepresentation();
        this.getVue().getjTableRepresentation().addMouseListener(this);
        this.getVue().getjButtonReservation().addActionListener(this);
        vue.addWindowListener(this);
    }
    
    
    /*
    * Methode pour quitter l'application
    */
    public void menuFichierQuitter() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
    }    
    
    /*
    * Methode pour quitter la vue des représentation    
    */
    public void representationQuitter() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_QUITTER);
    }

    //méthode pour afficher la liste des représentation via la methode sel
    public void afficherRepresentation() throws SQLException {
        String msg = ""; // message à afficher en cas d'erreur/
        ((VueRepresentation) vue).getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin", "Place restante"};
        ((VueRepresentation) vue).getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[6];
            lesRepresentations = RepresentationDao.getAll();
            for (Representation uneRepresentation : lesRepresentations) {
                ligneDonnees[0] = uneRepresentation.getGroupe().getNom();
                ligneDonnees[1] = uneRepresentation.getLieu().getNomLieu();
                ligneDonnees[2] = uneRepresentation.getDateRepresentation();
                ligneDonnees[3] = uneRepresentation.getHeureDebRepresentation();
                ligneDonnees[4] = uneRepresentation.getHeureFinRepresentation();
                ligneDonnees[5] = Integer.toString(uneRepresentation.getNbPlacesRestantes());
                ((VueRepresentation) vue).getModeleTableRepresentation().addRow(ligneDonnees);
            } 
        } catch (SQLException ex) {
            msg = "CtrlRepresentation - representationAfficher() - " + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "Affichage des représentations", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void afficherUneRepresentation() throws SQLException {
        VueUneRepresentation uneVue = new VueUneRepresentation();
        CtrlUneRepresentation ctrlUneRepresentation = new CtrlUneRepresentation(uneVue);
        this.getVue().setEnabled(false);
        ctrlUneRepresentation.getVue().setVisible(true);
    }
    
    
    //int ligneSelectionne = lesRepresentations.getSelectedRow();
    //on récupére la valeur de la première colonne de la ligne sélectionné
    //taJTable.getValueAt(ligneSelectionne, 0);
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JTable lesRepresentations = this.getVue().getjTableRepresentation();
        if (e.getSource().equals(getVue().getjButtonReservation())) {
            try {
                afficherUneRepresentation();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (e.getSource().equals(lesRepresentations)) {
                int ligneSelectionne = lesRepresentations.getSelectedRow();
                lesRepresentations.getValueAt(ligneSelectionne, 0);
            }
        }
    }
    
    @Override
    public VueRepresentation getVue() {
        return (VueRepresentation) vue;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            menuFichierQuitter();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
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
