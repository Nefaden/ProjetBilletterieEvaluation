package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private ArrayList<Representation> arrObjRepresentation;

    // Constructeur du controller des représentations
    public CtrlRepresentation(CtrlPrincipal ctrlPrincipal) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueRepresentation();
        afficherRepresentation();
        this.getVue().getjTableRepresentation().addMouseListener(this);
        this.getVue().getjButtonReservation().addActionListener(this);
        this.getVue().getjButtonQuitter().addActionListener(this);
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
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"ID", "Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[6];
            // Utilisation JPQL
            arrObjRepresentation = RepresentationDao.getAll();
            for (Representation uneRepresentation : arrObjRepresentation) {
                ligneDonnees[0] = Integer.toString(uneRepresentation.getIdRepresentation());
                ligneDonnees[1] = uneRepresentation.getGroupe().getNomGroupe();
                ligneDonnees[2] = uneRepresentation.getLieu().getNomLieu();
                ligneDonnees[3] = uneRepresentation.getDateRepresentation();
                ligneDonnees[4] = uneRepresentation.getHeureDebutRepresentation();
                ligneDonnees[5] = uneRepresentation.getHeureFinRepresentation();
                getVue().getModeleTableRepresentation().addRow(ligneDonnees);
            }
        } catch (SQLException ex) {
            msg = "CtrlRepresentation - afficherRepresentation() - " + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "Affichage des représentations", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Permet la selection d'une ligne du tableau pour appeler le controller CtrlVentePlace 
     * Pour pouvoir afficher une représentation
     * 
     * @throws SQLException 
     */
    public void afficherUneRepresentation() throws SQLException{
        int ligne = getVue().getjTableRepresentation().getSelectedRow();
        if (ligne != -1) { 
            int idRepresentationSelect = arrObjRepresentation.get(ligne).getIdRepresentation();
            this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_VENTE, idRepresentationSelect);
        }
    }
    
    /**
     *
     * @param e : Evènement lié à la sélection d'une ligne dans le jTable
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVue().getjButtonQuitter())) {
            try {
                representationQuitter();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlRepresentation.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print("BOUTTON QUITTER");
        } else {
            if (e.getSource().equals(getVue().getjButtonReservation())) {
                if (!verifierLignejTable()) {
                    JOptionPane.showMessageDialog(null, "Représentation non sélectionnée.", "Inane error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        afficherUneRepresentation();
                    } catch (SQLException ex) {
                        //Logger.getLogger(CtrlRepresentation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    /**
     * Vérifie la ligne et la colonne selectionner
     * 
     * @return Boolean
     */
    public boolean verifierLignejTable() {
        boolean test;
        int ligne = getVue().getjTableRepresentation().getSelectedRow();
        int colonne = getVue().getjTableRepresentation().getSelectedColumn();
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
    
    /**
     * clic sur la commande Quitter du menu Fichier ou la croix de la fenêtre
     * Le contrôleur délègue l'action au contrôleur frontal
     */
    public void menuFichierQuitter() throws SQLException {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "root", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
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
            Logger.getLogger(CtrlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            representationQuitter();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
