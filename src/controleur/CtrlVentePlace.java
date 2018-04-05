/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.RepresentationDao;
import modele.metier.Representation;
import vue.VueVentePlace;

/**
 *
 * @author btssio
 */
public class CtrlVentePlace extends ControleurGenerique implements ActionListener, WindowListener, MouseListener {
    
    private final RepresentationDao RepresentationDao = new RepresentationDao();
    private Representation objRepresentation;

    public CtrlVentePlace(CtrlPrincipal ctrlPrincipal, int idRepresentationSelect) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueVentePlace();
        this.getVue().getjButtonReserver().addActionListener(this);
        this.getVue().getjButtonAnnuler().addActionListener(this);
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
            objRepresentation = RepresentationDao.getOneById(idRepresentationSelect);
            getVue().getjLabelGroupe().setText(objRepresentation.getGroupe().getNomGroupe());
            getVue().getjLabelLieu().setText(objRepresentation.getLieu().getNomLieu());
            getVue().getjLabelDate().setText(objRepresentation.getDateRepresentation());
            getVue().getjLabelHeureDebut().setText(objRepresentation.getHeureDebutRepresentation());
            getVue().getjLabelHeureFin().setText(objRepresentation.getHeureFinRepresentation());
            getVue().getjLabelPlacesTotal().setText(Integer.toString(objRepresentation.getLieu().getCapaciteLieu()));
            getVue().getjLabelPlacesRestantes().setText(Integer.toString(objRepresentation.getNbPlaceRestante()));
        } catch (Exception ex) {
            msg = "Erreur dans la methode afficherUneRepresentation" + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "afficherUneRepresentation", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void venteSoustraire() throws SQLException{
        int vente = Integer.parseInt((getVue().getjTextFieldPlacesReserver()).getText());
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
            Logger.getLogger(CtrlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
        if(e.getSource().equals(getVue().getjButtonAnnuler())) {
            try {
                venteQuitter();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlVentePlace.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            if(e.getSource().equals(getVue().getjButtonReserver())) {
                
                Date currentTime = new Date();
                String dateDebut = objRepresentation.getDateRepresentation();
                String heureDebut = objRepresentation.getHeureDebutRepresentation();
                
                //String msg2 = "Date auj : " + dateCourante;
                //JOptionPane.showMessageDialog(null,msg2,"Inane error",JOptionPane.ERROR_MESSAGE);
                
                int annee = Integer.parseInt(dateDebut.substring(6,10));
                int mois = Integer.parseInt(dateDebut.substring(3,5));
                int jour = Integer.parseInt(dateDebut.substring(0,2));
                int heure = Integer.parseInt(heureDebut.substring(0,2));
                int minutes = Integer.parseInt(heureDebut.substring(3,5));
            
                Date dateRepresentation = new Date(annee-1900, mois, jour,heure,minutes);
                
                
                if (dateRepresentation.before(currentTime)) {
                    String msg = "Le concert est passé";
                    JOptionPane.showMessageDialog(null,msg,"Concert Terminé",JOptionPane.ERROR_MESSAGE);
                } else {
                    if (objRepresentation.getNbPlaceRestante() - Integer.parseInt(getVue().getjTextFieldPlacesReserver().getText()) < 0) {
                        JOptionPane.showMessageDialog(null,"Pas assez de place disponible, veuillez saisir un nombre de place inférieur à "+ objRepresentation.getNbPlaceRestante(),"Inane error",JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (JOptionPane.showConfirmDialog(null, "Vous êtes sûr ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            try {
                                this.venteSoustraire();
                            } catch (SQLException ex) {
                                Logger.getLogger(CtrlVentePlace.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                        }
                    }
                }
            }
        }
    }
}


