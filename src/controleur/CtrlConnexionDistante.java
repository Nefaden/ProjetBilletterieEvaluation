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
import Connexion.Jdbc.JdbcDist;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import vue.VueConnexionDistante;
import modele.metier.Utilisateur;

/**
 * Controller gérant les connexions et la vue VueAuthentificationLocale
 *
 * @author ydurand
 * @v1.0
 */
public class CtrlConnexionDistante extends ControleurGenerique implements ActionListener, WindowListener {
    
    public static boolean estConnecter;

    // Constructeur du controller Principal
    public CtrlConnexionDistante(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        this.vue = new VueConnexionDistante();
        this.vue.addWindowListener(this);
        this.getVue().getjButtonConnexion().addActionListener(this);
        this.getVue().getjButtonQuitter().addActionListener(this);
        this.estConnecter = estConnecter;
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

            final Properties prop = new Properties();
            InputStream input = null;

            try {

                input = new FileInputStream("config/accessDB.properties");

                // load a properties file
                prop.load(input);

                // get the property value and print it out
                //JdbcDist.getInstance().deconnecter();
                Jdbc.getInstance().setServeurBd(prop.getProperty("dbdist.pass"));
                Jdbc.getInstance().connecter();

            } catch (final IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (final IOException ex2) {
                        ex2.printStackTrace();
                    }
                }
            }

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
                    EntityManager em;
                    em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
                    String nomUtilisateur = getVue().getjTextFieldNomUtilisateur().getText();
                    Query query = em.createQuery("select u from Utilisateur u WHERE u.s_NomUtilisateur = :NomUtilisateur").setParameter("NomUtilisateur", nomUtilisateur);
                    Utilisateur objUtilisateur = (Utilisateur) query.getSingleResult();
                    if (getVue().getjPasswordFieldMotDePasse().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Renseignez le Mot de Passe", "Inane error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (objUtilisateur.getNomUtilisateur().equals(getVue().getjTextFieldNomUtilisateur().getText())
                                && objUtilisateur.getMotDePasse().equals(sb.toString())) {
                            try {
                                Jdbc.getInstance().connecter();
                                this.estConnecter = true;
                            } catch (ClassNotFoundException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Main - connexion à la BDD - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Main - connexion à la BDD", JOptionPane.ERROR_MESSAGE);
                            }
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
