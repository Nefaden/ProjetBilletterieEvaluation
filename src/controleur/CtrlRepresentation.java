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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contrôleur permettant l'affichage et la sélection des représentation dans la
 * vueRepresentation
 *
 * @author ydurand v1.0
 */
public class CtrlRepresentation extends ControleurGenerique implements ActionListener, WindowListener, MouseListener {

    private final RepresentationDao RepresentationDao = new RepresentationDao();
    private List<Representation> lesRepresentations;

    // Constructeur du controller des représentations
    public CtrlRepresentation(CtrlPrincipal ctrlPrincipal) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueRepresentation();
        afficherRepresentation();
        this.getVue().getjTableRepresentation().addMouseListener(this);
        this.getVue().getjButtonReservation().addActionListener(this);
        this.getVue().getjButtonQuitter().addActionListener(this);
        vue.addWindowListener(this);
    }

    /**
     *
     * Methode pour quitter l'application
     *
     * @throws SQLException
     */
    public void menuFichierQuitter() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
    }

    /**
     *
     * Methode pour quitter la vue des représentation
     *
     * @throws SQLException
     */
    public void representationQuitter() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_QUITTER);
    }

    /**
     *
     * Méthode pour afficher les representation dans le jTable
     *
     * @throws SQLException
     */
    public void afficherRepresentation() throws SQLException {
        String msg = ""; // message à afficher en cas d'erreur/
        ((VueRepresentation) vue).getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"ID", "Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        ((VueRepresentation) vue).getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[6];
            lesRepresentations = RepresentationDao.getAll();
            for (Representation uneRepresentation : lesRepresentations) {
                ligneDonnees[0] = Integer.toString(uneRepresentation.getIdRepresentation());
                ligneDonnees[1] = uneRepresentation.getGroupe().getNomGroupe();
                ligneDonnees[2] = uneRepresentation.getLieu().getNomLieu();
                ligneDonnees[3] = uneRepresentation.getDateRepresentation();
                ligneDonnees[4] = uneRepresentation.getHeureDebutRepresentation();
                ligneDonnees[5] = uneRepresentation.getHeureFinRepresentation();
                ((VueRepresentation) vue).getModeleTableRepresentation().addRow(ligneDonnees);
            }
        } catch (SQLException ex) {
            msg = "CtrlRepresentation - representationAfficher() - " + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "Affichage des représentations", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void afficherUneRepresentation() throws SQLException{
        int ligne = ((VueRepresentation) vue).getjTableRepresentation().getSelectedRow();
        int colonne = ((VueRepresentation) vue).getjTableRepresentation().getSelectedColumn();
        if (ligne != -1 && colonne != -1){
            String groupe = (String) ((VueRepresentation) vue).getModeleTableRepresentation().getValueAt(ligne,colonne);
            this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_DETAILS,groupe);
        }
    }
    
    /**
     *
     * @param e : Evènement lié à la sélection d'une ligne dans le jTable
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(((VueRepresentation) vue).getjButtonQuitter())) {
            try {
                representationQuitter();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlRepresentation.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print("BOUTTON QUITTER");
        } else {
            if (e.getSource().equals(((VueRepresentation) vue).getjButtonReservation())) {
                if (!verifierLignejTable()) {
                    JOptionPane.showMessageDialog(null, "Représentation non sélectionnée.", "Inane error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        afficherUneRepresentation();
                    } catch (SQLException ex) {
                        Logger.getLogger(CtrlRepresentation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public boolean verifierLignejTable() {
        boolean test;
        int ligne = ((VueRepresentation) vue).getjTableRepresentation().getSelectedRow();
        int colonne = ((VueRepresentation) vue).getjTableRepresentation().getSelectedColumn();
        if (ligne != -1 && colonne != -1) {
            test = true;
        } else {
            test = false;
        }
        return test;
    }

    /**
     *
     * @return VueRepresentation vue : Getter de la vue ds représentations
     */
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
