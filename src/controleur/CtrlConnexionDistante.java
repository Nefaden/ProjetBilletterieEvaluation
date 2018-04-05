package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vue.VueConnexionDistante;
import modele.metier.Utilisateur;
import modele.dao.UtilisateurDao;

/**
 * Controller gérant les connexions et la vue VueAuthentificationLocale
 *
 * @author ydurand v1.0
 */
public class CtrlConnexionDistante extends ControleurGenerique implements ActionListener, WindowListener {

    // Constructeur du controller Principal
    public CtrlConnexionDistante(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        this.vue = new VueConnexionDistante();
        this.vue.addWindowListener(this);
        this.getVue().getjButtonConnexion().addActionListener(this);
        this.getVue().getjButtonQuitter().addActionListener(this);
    }

    /**
     *
     * @return vue : Getter pour récupérer la vue "connexion"
     */
    @Override
    public VueConnexionDistante getVue() {
        return (VueConnexionDistante) vue;
    }

    /**
     * clic sur le bouton connexion pour une tentative de connexion Si la
     * connexion est validé le controller appelle la méthode du controller
     * principal Affiche la vue adéquat à la méthode
     */
    public void menuPrincipalRetour() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.CONNEXION_AFFICHER_MENU_PRINCIPAL);
    }

    /**
     *
     * @param e : Evénements e auquel est associé toutes actions dans la vue Sur
     * n'importe quel élément graphique avec lesquels les intéractions sont
     * possible
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.getVue().getjButtonConnexion())) {

            try {
                String motDePasse = this.getVue().getjPasswordFieldMotDePasse().getText();

                MessageDigest mdPassword;

                mdPassword = MessageDigest.getInstance("MD5");

                mdPassword.update(motDePasse.getBytes());
                byte[] digest = mdPassword.digest();
                StringBuffer sb = new StringBuffer();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }

                if (getVue().getjTextFieldNomUtilisateur().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Renseignez le nom d'utilisateur", "Inane error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Utilisateur objUtilisateur = UtilisateurDao.getOneByNameUser(getVue().getjTextFieldNomUtilisateur().getText());
                    if (getVue().getjPasswordFieldMotDePasse().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Renseignez le Mot de Passe", "Inane error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (objUtilisateur.getNomUtilisateur().equals(getVue().getjTextFieldNomUtilisateur().getText())
                                && objUtilisateur.getMotDePasse().equals(sb.toString())) {
                            JOptionPane.showMessageDialog(null, "Connexion effectuée");
                            this.getCtrlPrincipal().action(EnumAction.CONNEXION_AFFICHER_MENU_PRINCIPAL);
                        }
                    }
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (e.getSource().equals(this.getVue().getjButtonQuitter())) {
                try {
                    this.getCtrlPrincipal().action(EnumAction.CONNEXION_AFFICHER_MENU_PRINCIPAL);
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * clic sur le bouton Quitter de la vue ou sur la croix de la fenêtre
     * l'action au contrôleur frontal
     *
     * @throws java.sql.SQLException
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

    /**
     *
     * @param e Evénement pour quitter l'application depuis la croix de la
     * fenêtre
     */
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
}
