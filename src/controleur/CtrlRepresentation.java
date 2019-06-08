package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.metier.Representation;
import vue.VueRepresentation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Contrôleur permettant l'affichage et la sélection des représentation dans la
 * vueRepresentation
 *
 * @author ydurand 
 * @v1.0
 */
public class CtrlRepresentation extends ControleurGenerique implements ActionListener, WindowListener, MouseListener {

    //private final RepresentationDao RepresentationDao = new RepresentationDao();
    private Vector<Representation> arrObjRepresentation;

    // Constructeur du controller des représentations
    public CtrlRepresentation(CtrlPrincipal ctrlPrincipal) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueRepresentation();
        afficherRepresentation();
        this.getVue().getjTableRepresentation().addMouseListener(this);
        this.getVue().getjButtonReservation().addActionListener(this);
        this.getVue().getjButtonQuitter().addActionListener(this);
        this.getVue().getjButtonOrderByDate().addActionListener(this);
        this.getVue().getjButtonOrderLieu().addActionListener(this);
        this.getVue().getjButtonOrderByGroup().addActionListener(this);
        this.getVue().getjButtonOrderByDate().setEnabled(false);
        this.getVue().getjButtonOrderLieu().setEnabled(true);
        this.getVue().getjButtonOrderByGroup().setEnabled(true);
        
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
        EntityManager em;
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"ID", "Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[6];
        // Utilisation JPQL
        Query query = em.createQuery("select r from Representation r order by r.s_Date DESC, r.o_Lieu.s_NomLieu, r.o_Groupe.s_NomGroupe");
        arrObjRepresentation = (Vector<Representation>) query.getResultList();
        for (Representation objRepresentation : arrObjRepresentation) {
            ligneDonnees[0] = Integer.toString(objRepresentation.getIdRepresentation());
            ligneDonnees[1] = objRepresentation.getGroupe().getNomGroupe();
            ligneDonnees[2] = objRepresentation.getLieu().getNomLieu();
            ligneDonnees[3] = objRepresentation.getDateRepresentation();
            ligneDonnees[4] = objRepresentation.getHeureDebutRepresentation();
            ligneDonnees[5] = objRepresentation.getHeureFinRepresentation();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);
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
                if (!verifierLigneJTable()) {
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
    
    // Ordonner le tableau par date
    public void afficherRepresentationOrderByDate() {
        EntityManager em;
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"ID", "Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[6];
        // requête JPQL
        Query query = em.createQuery("select r from Representation r order by r.s_Date DESC, r.o_Lieu.s_NomLieu, r.o_Groupe.s_NomGroupe");
        arrObjRepresentation = (Vector<Representation>) query.getResultList();
        for (Representation objRepresentation : arrObjRepresentation) {
            ligneDonnees[0] = Integer.toString(objRepresentation.getIdRepresentation());
            ligneDonnees[1] = objRepresentation.getGroupe().getNomGroupe();
            ligneDonnees[2] = objRepresentation.getLieu().getNomLieu();
            ligneDonnees[3] = objRepresentation.getDateRepresentation();
            ligneDonnees[4] = objRepresentation.getHeureDebutRepresentation();
            ligneDonnees[5] = objRepresentation.getHeureFinRepresentation();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);
        }        
    }
    
    // Ordonner le tableau par lieu
    public void afficherRepresentationOrderByLieu() {
        EntityManager em;
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"ID", "Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[6];
        // requête JPQL
        Query query = em.createQuery("select r from Representation r order by r.o_Lieu.s_NomLieu, r.s_Date DESC, r.o_Groupe.s_NomGroupe");
        arrObjRepresentation = (Vector<Representation>) query.getResultList();
        for (Representation objRepresentation : arrObjRepresentation) {
            ligneDonnees[0] = Integer.toString(objRepresentation.getIdRepresentation());
            ligneDonnees[1] = objRepresentation.getGroupe().getNomGroupe();
            ligneDonnees[2] = objRepresentation.getLieu().getNomLieu();
            ligneDonnees[3] = objRepresentation.getDateRepresentation();
            ligneDonnees[4] = objRepresentation.getHeureDebutRepresentation();
            ligneDonnees[5] = objRepresentation.getHeureFinRepresentation();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);
        }
    }
    
    // Ordonner le tableau par groupe
    public void afficherRepresentationOrderByGroup() {
        EntityManager em;
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"ID", "Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[6];
        // requête JPQL
        Query query = em.createQuery("select r from Representation r order by r.o_Groupe.s_NomGroupe, r.s_Date DESC, r.o_Lieu.s_NomLieu");
        arrObjRepresentation = (Vector<Representation>) query.getResultList();
        for (Representation objRepresentation : arrObjRepresentation) {
            ligneDonnees[0] = Integer.toString(objRepresentation.getIdRepresentation());
            ligneDonnees[1] = objRepresentation.getGroupe().getNomGroupe();
            ligneDonnees[2] = objRepresentation.getLieu().getNomLieu();
            ligneDonnees[3] = objRepresentation.getDateRepresentation();
            ligneDonnees[4] = objRepresentation.getHeureDebutRepresentation();
            ligneDonnees[5] = objRepresentation.getHeureFinRepresentation();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);
        }
        
    }

    /**
     * Vérifie la ligne et la colonne selectionner
     * 
     * @return Boolean
     */
    public boolean verifierLigneJTable() {
        boolean idLigneJTable;
        int ligne = getVue().getjTableRepresentation().getSelectedRow();
        int colonne = getVue().getjTableRepresentation().getSelectedColumn();
        if (ligne != -1 && colonne != -1) {
            idLigneJTable = true;
        } else {
            idLigneJTable = false;
        }
        return idLigneJTable;
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
