package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Connexion.Jdbc.Jdbc;
import vue.VueAuthentificationLocale;

/**
 * Controller gérant les connexions et la vue VueAuthentificationLocale
 *
 * @author ydurand 
 * @v1.0
 */
public class CtrlAuthentificationLocale extends ControleurGenerique implements ActionListener, WindowListener {

    // Constructeur du controller Principal
    public CtrlAuthentificationLocale(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        this.vue = new VueAuthentificationLocale();
        this.vue.addWindowListener(this);
        this.getVue().getjButtonConnexion().addActionListener(this);
        this.getVue().getjButtonQuitter().addActionListener(this);
    }

    /**
     *
     * @return vue : Getter pour récupérer la vue "connexion"
     */
    @Override
    public VueAuthentificationLocale getVue() {
        return (VueAuthentificationLocale) vue;
    }

    /**
     * clic sur le bouton connexion pour une tentative de connexion Si la
     * connexion est validé le controller appelle la méthode du controller
     * principal Affiche la vue adéquat à la méthode
     */
    public void menuPrincipalAfficher() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.AUTHENTIFICATION_AFFICHER_MENU_PRINCIPAL);
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

            Properties connexionProperties = new Properties();
            InputStream input = null;

            try {
                input = new FileInputStream("config/accessDB.properties");

                // load properties file
                connexionProperties.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            try {
                String identifiant = this.getVue().getjTextFieldNomUtilisateur().getText();
                String motDePasse = this.getVue().getjPasswordFieldMotDePasse().getText();

                MessageDigest mdUser = MessageDigest.getInstance("MD5");
                mdUser.update(identifiant.getBytes());
                byte[] digest = mdUser.digest();
                StringBuffer sb = new StringBuffer();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }

                MessageDigest mdPassword = MessageDigest.getInstance("MD5");
                mdPassword.update(motDePasse.getBytes());
                byte[] digest2 = mdPassword.digest();
                StringBuffer sb2 = new StringBuffer();
                for (byte b : digest2) {
                    sb2.append(String.format("%02x", b & 0xff));
                }

                /* Compare les éléments du fichier properties à ce qui est récupérer des jTextField
                Si les éléments des jTextFields corresepondent, renvoie vers la méthode CONNEXION_MENU_PRINCPAL du controller principal */
                if (connexionProperties.getProperty("login").equals(sb.toString()) && connexionProperties.getProperty("password").equals(sb2.toString())) {
                    try {
                        Jdbc.getInstance().connecter();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Main - connexion à la BDD distante - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Main - connexion à la BDD distante", JOptionPane.ERROR_MESSAGE);
                    }
                    this.getCtrlPrincipal().action(EnumAction.AUTHENTIFICATION_AFFICHER_MENU_PRINCIPAL);
                } else {
                    JOptionPane.showMessageDialog(null, "Vérifier vos identifiants !");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlAuthentificationLocale.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlAuthentificationLocale.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(this.getVue().getjButtonQuitter())) {
            try {
                this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlAuthentificationLocale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * clic sur le bouton Quitter de la vue ou sur la croix de la fenêtre
     * l'action au contrôleur frontal
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
