package modele.orm;

import modele.metier.Groupe;
import java.util.List;
import javax.persistence.*;

/**
 * Classe groupe de la DB
 * 
 * @author ydurand
 * v1.0
 */
public class testJPA_Groupe {
    
    public static void main(String[] args) {

        EntityManager em;
        Groupe groupeLue;
        long idGroupe;

        System.out.println("\nDEBUT DES TESTS DE PERSISTANCE POUR LA CLASSE GROUPE");
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        idGroupe = 2;
        System.out.println("\nTest 1 - sélection du groupe d'identifiant : " + idGroupe);
        groupeLue = em.find(Groupe.class, idGroupe);
        if (groupeLue != null){
            System.out.println("\tGroupe d'identifiant : " + idGroupe + " : " + groupeLue.toString());
        } else {
            System.out.println("\tECHEC : groupe d'identifiant : " + idGroupe + " non trouvée ");
        }
        System.out.println("Test 1 effectué");
    }
}
