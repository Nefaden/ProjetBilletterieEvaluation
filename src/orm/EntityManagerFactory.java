package orm;
import javax.persistence.Persistence;
public class EntityManagerFactory {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("BilletJava2017PU");
    }   
}