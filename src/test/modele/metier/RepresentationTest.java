package test.modele.metier;

import modele.dao.GroupeDao;
import modele.dao.LieuDao;
import modele.metier.Groupe;
import modele.metier.Lieu;
import modele.metier.Representation;

/**
 * Classe permettant de tester la classe représentation (getter/setter)
 * @author ydurand
 * v1.0
 */
public class RepresentationTest {

    public static void main(String[] args) {
        Representation repr;
        Lieu unLieu1;
        Groupe unGroupe1;
        unLieu1 = new Lieu(2, "Le Cabaret", "MAIRIE ANNEXE DE PARAME, Place Georges COUDRAY", 250);
        unGroupe1 = new Groupe("g024", "Boxty", "NULL", "NULL", 5, "France-Bretagne", "O");
        System.out.println("\nTest n°1 : instanciation et accesseurs/getter");
        repr = new Representation(1, "11/07/2017", unLieu1, unGroupe1, "19:00", "20:00", 50);
        System.out.println(repr);
        System.out.println("\nTest n°2 : mutateurs/setter");
        repr.setDateRepresentation("11/07/2017");
        repr.setLieu(unLieu1);
        repr.setGroupe(unGroupe1);
        repr.setHeureDebRepresentation("19:00");
        repr.setHeureFinRepresentation("20:00");
        System.out.println(repr);
        repr = new Representation(1, null, null, null, null, null, 0);
        System.out.println(repr.equals(repr));
    }
}
