package modele.orm;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Groupe;

/**
 *
 * @author nbourgeois
 */
public class testJPA_Groupe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em;
        List<Groupe> desGroupes;
        String idGroupe;
        Groupe unGroupe, unGroupe2, unGroupe3, unGroupe2Lu, unGroupe3Lu, unGroupeSuppr;

        System.out.println("\nDEBUT DES TESTS DE PERSISTANCE POUR LA CLASSE Groupe");
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        EntityTransaction tx = em.getTransaction(); 
        tx.begin();

        idGroupe = "g004";
        System.out.println("\nTest 1 - sélection du groupe d'identifiant : " + idGroupe);
        unGroupe = em.find(Groupe.class, idGroupe);
        if (unGroupe != null) {
            System.out.println("\tGroupe d'identifiant : " + idGroupe + " : " + unGroupe.toString());
        } else {
            System.out.println("\tECHEC : groupe d'identifiant : " + idGroupe + " non trouvée ");
        }
        System.out.println("Test 1 effectué");
        
        
        System.out.println("\nTest 2 - sélection de l'ensemble des groupes");
        Query query= em.createQuery("select g from Groupe g");
        desGroupes = query.getResultList();
        for (Groupe grp : desGroupes) {
            System.out.println("\t->" + grp);
        }
        System.out.println("Test 2 effectué");
        
        System.out.println("\nTest 3 - persistance de nouveaux groupes");
        unGroupe2 = new Groupe("g999", "Texas", "Spiteri", "Glasgow", 7, "Ecosse", 'N');
        unGroupe3 = new Groupe("g888", "Dire Straits", "Knopfler", "Deptford", 4, "Angleterre", 'N');
        em.persist(unGroupe2);
        em.persist(unGroupe3);
        System.out.println("\tpersistance demandée ; vérification par recherche sur l'identifiant du groupe : " + unGroupe2.getId());
        unGroupe2Lu =  em.find(Groupe.class, unGroupe2.getId());
        unGroupe3Lu =  em.find(Groupe.class, unGroupe3.getId());
        System.out.println("\tGroupe d'identifiant : " + unGroupe2.getId() + " : " + unGroupe2Lu.toString());
        System.out.println("\tGroupe d'identifiant : " + unGroupe3.getId() + " : " + unGroupe3Lu.toString());
        System.out.println("Test 3 effectué");
        
        System.out.println("\nTest 4 - modification d'un groupe");
        unGroupe2.setAdressePostale("Edimbourg");
        unGroupe2.setHebergement('O');
        System.out.println("\tmodification demandée ; vérification par recherche sur l'identifiant du groupe : " + unGroupe2.getId());
        unGroupe2Lu =  em.find(Groupe.class, unGroupe2.getId());
        System.out.println("\tGroupe d'identifiant : " + unGroupe2.getId() + " : " + unGroupe2Lu.toString());
        System.out.println("Test 4 effectué");
        
        unGroupeSuppr = unGroupe2;
        System.out.println("\nTest 5-1 - suppression d'un groupe persistant : " + unGroupeSuppr.toString());
        em.remove(unGroupeSuppr);
        System.out.println("\tsuppression effectuée ; vérification par recherche sur l'identifiant du groupe : " + unGroupeSuppr.getId());
        unGroupe2Lu =  em.find(Groupe.class, unGroupe2.getId());
        if (unGroupe2Lu == null) {
            System.out.println("\tsuppression réussie");
        } else {
            System.out.println("\téchec de la suppression : " + unGroupe2.getId() + " : " + unGroupe2Lu.toString());
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
