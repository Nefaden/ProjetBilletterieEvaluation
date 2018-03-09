package modele.orm;

import modele.metier.Representation;
import java.util.List;
import javax.persistence.*;

/**
 * Classe représentant les reservation faites par les clients pour une représentation du festival dans un lieu précis
 * 
 * @author ydurand
 * v1.0
 */
public class testJPA_Representation {
    
    public static void main(String[] args) {

        EntityManager em;
        Representation representationLue;
        long idRepresentation;

        System.out.println("\nDEBUT DES TESTS DE PERSISTANCE POUR LA CLASSE REPRESENTATION");
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        idRepresentation = 2;
        System.out.println("\nTest 1 - sélection de la representation d'identifiant : " + idRepresentation);
        representationLue = em.find(Representation.class, idRepresentation);
        if (representationLue != null){
            System.out.println("\tRepresentation d'identifiant : " + idRepresentation + " : " + representationLue.toString());
        } else {
            System.out.println("\tECHEC : representation d'identifiant : " + idRepresentation + " non trouvée ");
        }
        System.out.println("Test 1 effectué");
    }
}
