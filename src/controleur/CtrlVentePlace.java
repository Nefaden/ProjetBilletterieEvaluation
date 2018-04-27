package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modele.metier.Representation;
import vue.VueVentePlace;

/**
 * Controller permettant la gestion de la vente des places
 * 
 * @author ydurand
 * @v1.0
 */
public class CtrlVentePlace extends ControleurGenerique implements ActionListener, WindowListener, MouseListener {
    
    //private final RepresentationDao RepresentationDao = new RepresentationDao();
    private Representation objRepresentation;
    private EntityManager em;

    public CtrlVentePlace(CtrlPrincipal ctrlPrincipal, int idRepresentationSelect) throws SQLException {
        super(ctrlPrincipal);
        this.em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
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
            // Utilisation JPQL
            Query query = em.createQuery("select r from Representation r WHERE r.i_Id = " + idRepresentationSelect);
            objRepresentation = (Representation) query.getSingleResult();
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
    
    /**
     * Méthode qui modifie le nombre de place restante pour une representation après une vente
     * @throws SQLException 
     */
    public void venteSoustraire() throws SQLException{
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Representation objFindRepresentation = em.find(Representation.class, objRepresentation.getIdRepresentation());
        int nbPlaceAVendre = objFindRepresentation.getNbPlaceRestante();
        int nbPlaceVendu = Integer.parseInt((getVue().getjTextFieldPlacesReserver()).getText());
        int nbPlaceRestante = nbPlaceAVendre - nbPlaceVendu;
        objFindRepresentation.setNbPlaceRestante(nbPlaceRestante);
        em.flush();
        tx.commit();
        em.close();
    }
    
    /**
     * Méthode pour quitter la vue des ventes
     * @throws SQLException 
     */
    public void venteQuitter() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.VENTES_QUITTER);
    }
    
    /**
     * Getter pour récupérer le paramètre vue de la vue
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

    /**
     * 
     * @param e : event lié à la vue
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Si le bouton annuler est sélectionner
        if(e.getSource().equals(getVue().getjButtonAnnuler())) {
            try {
                venteQuitter();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlVentePlace.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Si le bouton reserver est sélectionner
        }else {
            if(e.getSource().equals(getVue().getjButtonReserver())) {
                
                Date currentTime = new Date();
                String dateDebut = objRepresentation.getDateRepresentation();
                String heureDebut = objRepresentation.getHeureDebutRepresentation();
                
                int annee = Integer.parseInt(dateDebut.substring(6,10));
                int mois = Integer.parseInt(dateDebut.substring(3,5));
                int jour = Integer.parseInt(dateDebut.substring(0,2));
                int heure = Integer.parseInt(heureDebut.substring(0,2));
                int minutes = Integer.parseInt(heureDebut.substring(3,5));
            
                Date dateRepresentation = new Date(annee-1900, mois, jour,heure,minutes);
                
                //Si la date locale est supérieur à la date de fin de la représentation
                // renvoie une erreur
                if (dateRepresentation.before(currentTime)) {
                    String msg = "Le concert est passé";
                    JOptionPane.showMessageDialog(null,msg,"Concert Terminé",JOptionPane.ERROR_MESSAGE);
                } else {
                    // Si le nombre de place après la vente est < 0 renvoie une erreur
                    if (objRepresentation.getNbPlaceRestante() - Integer.parseInt(getVue().getjTextFieldPlacesReserver().getText()) < 0) {
                        JOptionPane.showMessageDialog(null,"Pas assez de place disponible, veuillez saisir un nombre de place inférieur à "+ objRepresentation.getNbPlaceRestante(),"Inane error",JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Demande la confirmation de l'utilisateur avant d'update la table
                        if (JOptionPane.showConfirmDialog(null, "Vous êtes sûr ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            try {
                                this.venteSoustraire();
                                System.out.println("Transaction de l'objet");
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


