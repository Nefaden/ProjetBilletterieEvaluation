package Connexion.Jdbc;

import java.sql.*;

/**
 * Singleton fournit un objet de connexion JDBC
 *
 * @author ydurand
 * @v1.0
 */
public class Jdbc {

    // Instance du singleton Jdbc
    private static Jdbc singleton = null;
    // Paramètre de la connexion
    private String piloteJdbc = "";
    private String protocoleJdbc = "";
    private String serveurBd = "";
    private String nomBd = "";
    private String loginSgbd = "";
    private String mdpSgbd = "";
    // Connexion
    private Connection connexion = null; // java.sql.Connection

    private Jdbc() {
    }

    /**
     * @param pilote : classe du pilote Jdbc
     * @param protocole : préfixe l'URL du serveur ; dépend du type de SGBD
     * @param serveur : adresse du serveur + port (fini par un /, sauf pour
     * Oracle ; BD pour embarquée : chemin accès répertoire )
     * @param base : nom de la BD ou du DSN pour ODBC
     * @param login : utilisateur autorisé du SGBD (ou schéma Oracle)
     * @param mdp : son mot de passe
     */
    private Jdbc(String pilote, String protocole, String serveur, String base, String login, String mdp) {
        this.piloteJdbc = pilote;
        this.protocoleJdbc = protocole;
        this.serveurBd = serveur;
        this.nomBd = base;
        this.loginSgbd = login;
        this.mdpSgbd = mdp;
    }

    /**
     * 
     * @param pilote
     * @param protocole
     * @param serveur
     * @param base
     * @param login
     * @param mdp
     * @return 
     */
    public static Jdbc creer(String pilote, String protocole, String serveur, String base, String login, String mdp) {
        if (singleton == null) {
            singleton = new Jdbc(pilote, protocole, serveur, base, login, mdp);
        }
        return singleton;
    }

    /**
     * 
     * @return singleton
     */
    public static Jdbc getInstance() {
        return singleton;
    }

    /**
     * Connect to local database
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void connecter() throws ClassNotFoundException, SQLException {
        Class.forName(this.getPiloteJdbc());
        setConnexion(DriverManager.getConnection(this.getProtocoleJdbc() + this.getServeurBd() + this.getNomBd(), this.getLoginSgbd(), this.getMdpSgbd()));
        getConnexion().setAutoCommit(true);
    }

    /**
     * Disconnect from database
     * @throws SQLException 
     */
    public void deconnecter() throws SQLException {
        getConnexion().close();
    }

    /**
     * 
     * @param uneDate
     * @return 
     */
    public static java.sql.Date utilDateToSqlDate(java.util.Date uneDate) {
        return (new java.sql.Date(uneDate.getTime()));
    }

    /**
     * ************************************* *
     * ACCESSEURS * **************************************
     */
    /**
     * 
     * @return String piloteJdbc
     */
    public String getPiloteJdbc() {
        return piloteJdbc;
    }

    /**
     * 
     * @param piloteJdbc 
     */
    public void setPiloteJdbc(String piloteJdbc) {
        this.piloteJdbc = piloteJdbc;
    }

    /**
     * @return String the protocoleJdbc
     */
    public String getProtocoleJdbc() {
        return protocoleJdbc;
    }

    /**
     * @param protocoleJdbc the protocoleJdbc to set
     */
    public void setProtocoleJdbc(String protocoleJdbc) {
        this.protocoleJdbc = protocoleJdbc;
    }

    /**
     * 
     * @return String serveurBd
     */
    public String getServeurBd() {
        return serveurBd;
    }

    /**
     * 
     * @param serveurBd 
     */
    public void setServeurBd(String serveurBd) {
        this.serveurBd = serveurBd;
    }

    /**
     * 
     * @return String nomBd
     */
    public String getNomBd() {
        return nomBd;
    }

    /**
     * 
     * @param nomBd 
     */
    public void setNomBd(String nomBd) {
        this.nomBd = nomBd;
    }

    /**
     * 
     * @return String loginSgbd
     */
    public String getLoginSgbd() {
        return loginSgbd;
    }

    /**
     * 
     * @param loginSgbd 
     */
    public void setLoginSgbd(String loginSgbd) {
        this.loginSgbd = loginSgbd;
    }

    /**
     * 
     * @return String mdpSgbd
     */
    public String getMdpSgbd() {
        return mdpSgbd;
    }

    /**
     * 
     * @param mdpSgbd 
     */
    public void setMdpSgbd(String mdpSgbd) {
        this.mdpSgbd = mdpSgbd;
    }

    /**
     * 
     * @return Connection connexion 
     */
    public Connection getConnexion() {
        return connexion;
    }

    /**
     * 
     * @param connexion 
     */
    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
}