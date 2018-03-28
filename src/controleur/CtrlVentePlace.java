package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.GroupeDao;
import modele.dao.RepresentationDao;
import modele.metier.Groupe;
import modele.metier.Representation;
import vue.VueVentePlace;

/**
 *
 * @author gdoucet
 */
public class CtrlVentePlace extends ControleurGenerique implements ActionListener, WindowListener, MouseListener {

    private final RepresentationDao RepresentationDao = new RepresentationDao();
    private Representation objRepresentation;
    
    public CtrlVentePlace(CtrlPrincipal ctrlPrincipal, int idRepresentationSelect) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueVentePlace();
        this.getVue().getjButtonValider().addActionListener(this);
        this.getVue().getjButtonQuitter().addActionListener(this);
        this.vue.addWindowListener(this);
        afficherUneRepresentation(idRepresentationSelect);
    }
    
    /**
     * 
     * méthode pour afficher la représentation sélectionner
     * @param idRepresentationSelect : la représentation sélectionner
     * @throws SQLException 
     */
    private void afficherUneRepresentation(int idRepresentationSelect) throws SQLException {
        String msg = ""; //message d'erreur
        try {
            getVue().getModeleTableInformation().setRowCount(0);
            String[] titresColonnes = {"Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin", "Adresse"};
            getVue().getModeleTableInformation().setColumnIdentifiers(titresColonnes);
            objRepresentation = RepresentationDao.getOneById(idRepresentationSelect);
            String[] ligneDonnees = new String[6];
            ligneDonnees[0] = objRepresentation.getGroupe().getNomGroupe();
            ligneDonnees[1] = objRepresentation.getLieu().getNomLieu();
            ligneDonnees[2] = objRepresentation.getDateRepresentation();
            ligneDonnees[3] = objRepresentation.getHeureDebutRepresentation();
            ligneDonnees[4] = objRepresentation.getHeureFinRepresentation();
            ligneDonnees[5] = objRepresentation.getLieu().getAdresseLieu();
            getVue().getModeleTableInformation().addRow(ligneDonnees);
        } catch (Exception ex) {
            msg = "Erreur dans la methode afficherUneRepresentation" + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "afficherUneRepresentation", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void afficherNombrePlaces(Representation uneRepresentation) {
        String msg = ""; //message d'erreur
        try {
            getVue().getModeleTablePlaces().setRowCount(0);
            String[] titresColonnes = {"Nombre de places total", "Places restantes"};
            getVue().getModeleTablePlaces().setColumnIdentifiers(titresColonnes);
            String[] donnees = new String[2];
            donnees[0] = Integer.toString(uneRepresentation.getLieu().getCapaciteLieu());
            donnees[1] = Integer.toString(uneRepresentation.getNbPlaceRestante());
            getVue().getModeleTablePlaces().addRow(donnees);
        } catch (Exception ex) {
            msg = "Erreur dans la methode afficherNombrePlaces" + ex.getMessage();
            JOptionPane.showMessageDialog(vue, "", msg, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void venteSoustraire() throws SQLException{
        int vente = Integer.parseInt((getVue().getjTextFieldCommande()).getText());

        RepresentationDao.updateNbPlaceRestante(objRepresentation.getIdRepresentation(), vente);
        afficherUneRepresentation(objRepresentation.getIdRepresentation());
    }
    
    public void venteQuitter() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.VENTES_QUITTER);        
    }
    
    /**
     *
     * @return VueRepresentation vue : Getter de la vue ds représentations
     */
    @Override
    public VueVentePlace getVue() {
        return (VueVentePlace) vue;
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
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
    try {
            menuFichierQuitter();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(getVue().getjButtonQuitter())) {
            try {
                venteQuitter();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlVentePlace.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(e.getSource().equals((getVue().getjButtonValider()))) {
                if(objRepresentation.getLieu().getCapaciteLieu() - objRepresentation.getNbPlaceRestante() < Integer.parseInt((getVue().getjTextFieldCommande().getText()))) {
                    JOptionPane.showMessageDialog(null,"Pas assez de place disponible, veuillez saisir un nombre de place inférieur à "+ (objRepresentation.getLieu().getCapaciteLieu() - objRepresentation.getNbPlaceRestante()),"Inane error",JOptionPane.ERROR_MESSAGE);
                }else{
                    if (JOptionPane.showConfirmDialog(null, "Vous êtes sûr ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        try {
                            venteSoustraire();
                        } catch (SQLException ex) {
                            Logger.getLogger(CtrlVentePlace.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        // no option
                    }
                }
            }
            
        }
    }    
}
