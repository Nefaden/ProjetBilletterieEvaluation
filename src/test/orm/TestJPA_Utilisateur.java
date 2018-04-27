package test.orm;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Utilisateur;

/**
 * Classe de test du mapping de la classe Utilisateur
 * 
 * @author ydurand
 * @v1.0
 */
public class TestJPA_Utilisateur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em;
        List<Utilisateur> arrObjUtilisateur;
        int idUtilisateur;
        Utilisateur objUtilisateur, objUtilisateur2, objUtilisateur3, objUtilisateurLu, objutilisateurLu2, objUtilisateurSupprimer;

        System.out.println("\nDEBUT DES TESTS DE PERSISTANCE POUR LA CLASSE Utilisateur");
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        EntityTransaction tx = em.getTransaction(); 
        tx.begin();

        idUtilisateur = 1;
        System.out.println("\nTest 1 - sélection de l'utilisateur d'identifiant : " + idUtilisateur);
        objUtilisateur = em.find(Utilisateur.class, idUtilisateur);
        if (objUtilisateur != null) {
            System.out.println("\tUtilisateur d'identifiant : " + idUtilisateur + " : " + objUtilisateur.toString());
        } else {
            System.out.println("\tECHEC : Utilisateur d'identifiant : " + idUtilisateur + " non trouvée ");
        }
        System.out.println("Test 1 effectué");
        
        
        System.out.println("\nTest 2 - sélection de l'ensemble des utilisateurs");
        Query query= em.createQuery("select u from Utilisateur u");
        arrObjUtilisateur = query.getResultList();
        for (Utilisateur dataObjUtilisateur : arrObjUtilisateur) {
            System.out.println("\t->" + dataObjUtilisateur);
        }
        System.out.println("Test 2 effectué");
        
        System.out.println("\nTest 3 - persistance de nouveaux lieux");
        objUtilisateur2 = new Utilisateur(100, "PHILIPPE", "Jean", "jphilippe", "1234");
        objUtilisateur3 = new Utilisateur(100, "POUTOU", "Michèle", "mpoutou", "1234");
        em.persist(objUtilisateur2);
        em.persist(objUtilisateur3);
        System.out.println("\tpersistance demandée ; vérification par recherche sur l'identifiant du lieu : " + objUtilisateur2.getIdUtilisateur());
        objUtilisateurLu =  em.find(Utilisateur.class, objUtilisateur2.getIdUtilisateur());
        objutilisateurLu2 =  em.find(Utilisateur.class, objUtilisateur3.getIdUtilisateur());
        System.out.println("\tLieu d'identifiant : " + objUtilisateur2.getIdUtilisateur() + " : " + objUtilisateurLu.toString());
        System.out.println("\tLieu d'identifiant : " + objUtilisateur3.getIdUtilisateur() + " : " + objutilisateurLu2.toString());
        System.out.println("Test 3 effectué");
        
        System.out.println("\nTest 4 - modification d'un lieu");
        objUtilisateur2.setIdUtilisateur(10);
        System.out.println("\tmodification demandée ; vérification par recherche sur l'identifiant du lieu : " + objUtilisateur2.getIdUtilisateur());
        objUtilisateurLu =  em.find(Utilisateur.class, objUtilisateur2.getIdUtilisateur());
        System.out.println("\tLieu d'identifiant : " + objUtilisateur2.getIdUtilisateur() + " : " + objUtilisateurLu.toString());
        System.out.println("Test 4 effectué");
        
        objUtilisateurSupprimer = objUtilisateur2;
        System.out.println("\nTest 5-1 - suppression d'un lieu persistant : " + objUtilisateurSupprimer.toString());
        em.remove(objUtilisateurSupprimer);
        System.out.println("\tsuppression effectuée ; vérification par recherche sur l'identifiant du lieu : " + objUtilisateurSupprimer.getIdUtilisateur());
        objUtilisateurLu =  em.find(Utilisateur.class, objUtilisateur2.getIdUtilisateur());
        if (objUtilisateurLu == null) {
            System.out.println("\tsuppression réussie");
        } else {
            System.out.println("\téchec de la suppression : " + objUtilisateur2.getIdUtilisateur() + " : " + objUtilisateurLu.toString());
        }
        System.out.println("Test 5-1 effectué");
         
        try {
            // Validation de la transaction
            tx.commit();
            System.out.println("\nTRANSACTION VALIDEE");
        } catch (PersistenceException ex) {
            // Les exceptions relatives à JDBC ne sont détectées qu'au "commit"
            System.out.println("\nException de persistance => TRANSACTION ANNULEE");

        }
        System.out.println("\nFIN DES TESTS");

    }
}