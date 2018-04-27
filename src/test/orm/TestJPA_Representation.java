package test.orm;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Groupe;
import modele.metier.Lieu;
import modele.metier.Representation;

/**
 * Classe de test du mapping de la classe Representation
 * 
 * @author ydurand
 * @v1.0
 */
public class TestJPA_Representation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em;
        List<Representation> arrObjRepresentation;
        int idRepresentation;
        Representation objRepresentation, objRepresentation2, objRepresentation3, objRepresentationLu, objRepresentationLu2, objRepresentationSupprimer;

        System.out.println("\nDEBUT DES TESTS DE PERSISTANCE POUR LA CLASSE Representation");
        em = Persistence.createEntityManagerFactory("BilletJava2017PU").createEntityManager();
        EntityTransaction tx = em.getTransaction(); 
        tx.begin();

        idRepresentation = 1;
        System.out.println("\nTest 1 - sélection de la représentation d'identifiant : " + idRepresentation);
        objRepresentation = em.find(Representation.class, idRepresentation);
        if (objRepresentation != null) {
            System.out.println("\treprésentation d'identifiant : " + idRepresentation + " : " + objRepresentation.toString());
        } else {
            System.out.println("\tECHEC : Représentation d'identifiant : " + idRepresentation + " non trouvée ");
        }
        System.out.println("Test 1 effectué");
        
        
        System.out.println("\nTest 2 - sélection de l'ensemble des représentations");
        Query query= em.createQuery("select r from Representation r");
        arrObjRepresentation = query.getResultList();
        for (Representation objLieu : arrObjRepresentation) {
            System.out.println("\t->" + objLieu);
        }
        System.out.println("Test 2 effectué");
        
        System.out.println("\nTest 3 - persistance de nouvelles représentations");
        Lieu objLieu2 = new Lieu(400, "SALLE DE TEST REPR ID 201", "357 rue des test", 600);
        Lieu objLieu = new Lieu(300, "SALLE DE TEST REPR ID 200", "357 rue des test", 500);
        Groupe objGroupe2 = new Groupe("g200", "Groupe de test REPR ID 201", "Responsable 201", "une adresse de test 201", 20, "Test-land2", 'O');
        Groupe objGroupe = new Groupe("g201", "Groupe de test REPR ID 200", "Responsable 200", "une adresse de test 200", 20, "Test-land", 'N');
        objRepresentation2 = new Representation(200, "23/04/2018", objLieu, objGroupe, "22:00", "23:30", 500);
        objRepresentation3 = new Representation(201, "20/05/2018", objLieu2, objGroupe2, "22:00", "23:30", 600);
        em.persist(objRepresentation2);
        em.persist(objRepresentation3);
        System.out.println("\tpersistance demandée ; vérification par recherche sur l'identifiant de la représentation : " + objRepresentation2.getIdRepresentation());
        objRepresentationLu =  em.find(Representation.class, objRepresentation2.getIdRepresentation());
        objRepresentationLu2 =  em.find(Representation.class, objRepresentation3.getIdRepresentation());
        System.out.println("\tReprésentation d'identifiant : " + objRepresentation2.getIdRepresentation() + " : " + objRepresentationLu.toString());
        System.out.println("\tReprésentation d'identifiant : " + objRepresentation3.getIdRepresentation() + " : " + objRepresentationLu2.toString());
        System.out.println("Test 3 effectué");
        
        System.out.println("\nTest 4 - modification d'une Représentation");
        objRepresentation2.setIdRepresentation(100);
        System.out.println("\tmodification demandée ; vérification par recherche sur l'identifiant de la représentation : " + objRepresentation2.getIdRepresentation());
        objRepresentationLu =  em.find(Representation.class, objRepresentation2.getIdRepresentation());
        System.out.println("\tRepésentation d'identifiant : " + objRepresentation2.getIdRepresentation() + " : " + objRepresentationLu.toString());
        System.out.println("Test 4 effectué");
        
        objRepresentationSupprimer = objRepresentation2;
        System.out.println("\nTest 5-1 - suppression d'une représentation persistante : " + objRepresentationSupprimer.toString());
        em.remove(objRepresentationSupprimer);
        System.out.println("\tsuppression effectuée ; vérification par recherche sur l'identifiant de la représentation : " + objRepresentationSupprimer.getIdRepresentation());
        objRepresentationLu =  em.find(Representation.class, objRepresentation2.getIdRepresentation());
        if (objRepresentationLu == null) {
            System.out.println("\tsuppression réussie");
        } else {
            System.out.println("\téchec de la suppression : " + objRepresentation2.getIdRepresentation() + " : " + objRepresentationLu.toString());
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