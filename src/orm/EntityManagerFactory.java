package orm;

import javax.persistence.Persistence;

/**
 * Classe de test de la persistence "BilletJava2017PU"
 * 
 * @author ydurand
 * @v1.0
 */
public class EntityManagerFactory {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("BilletJava2017PU");
    }   
}