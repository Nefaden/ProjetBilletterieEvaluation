package test.orm;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Lieu;

/**
 *
 * @author ydurand
 */
public class TestJPA_Lieu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em;
        List<Lieu> desLieux;
        int idLieu;
        Lieu unLieu, unLieu2, unLieu3, unLieuLu, unLieu2Lu, unLieuSupprimer;

        System.out.println("\nDEBUT DES TESTS DE PERSISTANCE POUR LA CLASSE Lieu");
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        EntityTransaction tx = em.getTransaction(); 
        tx.begin();

        idLieu = 1;
        System.out.println("\nTest 1 - sélection du lieu d'identifiant : " + idLieu);
        unLieu = em.find(Lieu.class, idLieu);
        if (unLieu != null) {
            System.out.println("\tLieu d'identifiant : " + idLieu + " : " + unLieu.toString());
        } else {
            System.out.println("\tECHEC : Lieu d'identifiant : " + idLieu + " non trouvée ");
        }
        System.out.println("Test 1 effectué");
        
        
        System.out.println("\nTest 2 - sélection de l'ensemble des lieux");
        Query query= em.createQuery("select l from Lieu l");
        desLieux = query.getResultList();
        for (Lieu objLieu : desLieux) {
            System.out.println("\t->" + objLieu);
        }
        System.out.println("Test 2 effectué");
        
        System.out.println("\nTest 3 - persistance de nouveaux lieux");
        unLieu2 = new Lieu(100, "SALLE DE TEST 1", "Rue de Bonneville", 450);
        unLieu3 = new Lieu(200, "CABINET DE TEST 2", "MAIRIE ANNEXE DE PARAME, Place Georges COUDRAY", 250);
        em.persist(unLieu2);
        em.persist(unLieu3);
        System.out.println("\tpersistance demandée ; vérification par recherche sur l'identifiant du lieu : " + unLieu2.getIdLieu());
        unLieuLu =  em.find(Lieu.class, unLieu2.getIdLieu());
        unLieu2Lu =  em.find(Lieu.class, unLieu3.getIdLieu());
        System.out.println("\tLieu d'identifiant : " + unLieu2.getIdLieu() + " : " + unLieuLu.toString());
        System.out.println("\tLieu d'identifiant : " + unLieu3.getIdLieu() + " : " + unLieu2Lu.toString());
        System.out.println("Test 3 effectué");
        
        System.out.println("\nTest 4 - modification d'un lieu");
        unLieu2.setIdLieu(10);
        System.out.println("\tmodification demandée ; vérification par recherche sur l'identifiant du lieu : " + unLieu2.getIdLieu());
        unLieuLu =  em.find(Lieu.class, unLieu2.getIdLieu());
        System.out.println("\tLieu d'identifiant : " + unLieu2.getIdLieu() + " : " + unLieuLu.toString());
        System.out.println("Test 4 effectué");
        
        unLieuSupprimer = unLieu2;
        System.out.println("\nTest 5-1 - suppression d'un lieu persistant : " + unLieuSupprimer.toString());
        em.remove(unLieuSupprimer);
        System.out.println("\tsuppression effectuée ; vérification par recherche sur l'identifiant du lieu : " + unLieuSupprimer.getIdLieu());
        unLieuLu =  em.find(Lieu.class, unLieu2.getIdLieu());
        if (unLieuLu == null) {
            System.out.println("\tsuppression réussie");
        } else {
            System.out.println("\téchec de la suppression : " + unLieu2.getIdLieu() + " : " + unLieuLu.toString());
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