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
    private Representation uneRepresentation;
    
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
        getVue().getModeleTableInformation().setRowCount(0);
        String[] titresColonnes = {"Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin", "Adresse"};
        getVue().getModeleTableInformation().setColumnIdentifiers(titresColonnes);
        Groupe nomGroupe = GroupeDao.getOneByName(groupe);
        uneRepresentation = RepresentationDao.getOneByIdGroupe(nomGroupe.getIdGroupe());
        String[] ligneDonnees = new String[6];
        ligneDonnees[0] = uneRepresentation.getGroupe().getNomGroupe();
        ligneDonnees[1] = uneRepresentation.getLieu().getNomLieu();
        ligneDonnees[2] = uneRepresentation.getDateRepresentation();
        ligneDonnees[3] = uneRepresentation.getHeureDebutRepresentation();
        ligneDonnees[4] = uneRepresentation.getHeureFinRepresentation();
        ligneDonnees[5] = uneRepresentation.getLieu().getAdresseLieu();
        getVue().getModeleTableInformation().addRow(ligneDonnees);
    }
    
    public void afficherNombrePlaces(Representation uneRepresentation) {
        getVue().getModeleTablePlaces().setRowCount(0);
        String[] titresCol = {"Nombre de places total", "Places restantes"};
        getVue().getModeleTablePlaces().setColumnIdentifiers(titresCol);
        String[] donnees = new String[2];
        donnees[0] = Integer.toString(uneRepresentation.getLieu().getCapaciteLieu());
        donnees[1] = Integer.toString(uneRepresentation.getNbPlaceRestante());
        getVue().getModeleTablePlaces().addRow(donnees);
    }
    
    public void venteSoustraire() throws SQLException{
        int vente = Integer.parseInt((getVue().getjTextFieldCommande()).getText());

        RepresentationDao.updateNbPlaceRestante(uneRepresentation.getIdRepresentation(), vente);
        afficherUneRepresentation(uneRepresentation.getGroupe().getNomGroupe());
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
                if(uneRepresentation.getLieu().getCapaciteLieu() - uneRepresentation.getNbPlaceRestante() < Integer.parseInt((getVue().getjTextFieldCommande().getText()))) {
                    JOptionPane.showMessageDialog(null,"Pas assez de place disponible, veuillez saisir un nombre de place inférieur à "+ (uneRepresentation.getLieu().getCapaciteLieu() - uneRepresentation.getNbPlaceRestante()),"Inane error",JOptionPane.ERROR_MESSAGE);
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
