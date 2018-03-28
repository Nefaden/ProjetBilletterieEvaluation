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
    
    public CtrlVentePlace(CtrlPrincipal ctrlPrincipal, String groupe) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueVentePlace();
        this.getVue().getjButtonValider().addActionListener(this);
        this.getVue().getjButtonQuitter().addActionListener(this);
        this.vue.addWindowListener(this);
        afficherUneRepresentation(groupe);
    }
    
    //méthode pour afficher la représentation sélectionner
    private void afficherUneRepresentation(String groupe) throws SQLException {
        String msg = ""; //message d'erreur
        try {
            getVue().getModeleTableInformation().setRowCount(0);
            String[] titresColonnes = {"Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin", "Adresse"};
            getVue().getModeleTableInformation().setColumnIdentifiers(titresColonnes);
            Groupe nomGroupe = GroupeDao.getOneByName(groupe);
            objRepresentation = RepresentationDao.getOneByIdGroupe(nomGroupe.getIdGroupe());
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
            String[] titresCol = {"Nombre de places total", "Places restantes"};
            getVue().getModeleTablePlaces().setColumnIdentifiers(titresCol);
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
        afficherUneRepresentation(objRepresentation.getGroupe().getNomGroupe());
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
    
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
    try {
            venteQuitter();
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
