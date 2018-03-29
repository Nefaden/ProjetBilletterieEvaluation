package test.modele.metier;

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
        Representation objRepresentation;
        Lieu objLieu;
        Groupe objGroupe;
        objLieu = new Lieu(2, "Le Cabaret", "MAIRIE ANNEXE DE PARAME, Place Georges COUDRAY", 250);
        objGroupe = new Groupe("g024", "Boxty", "NULL", "NULL", 5, "France-Bretagne", "O");
        
        System.out.println("\nTest n°1 : instanciation et accesseurs/getter");
        objRepresentation = new Representation(1, "11/07/2017", objLieu, objGroupe, "19:00", "20:00", 50);
        System.out.println(objRepresentation);
        
        System.out.println("\nTest n°2 : mutateurs/setter");
        objRepresentation.setDateRepresentation("11/07/2017");
        objRepresentation.setLieu(objLieu);
        objRepresentation.setGroupe(objGroupe);
        objRepresentation.setHeureDebutRepresentation("19:00");
        objRepresentation.setHeureFinRepresentation("20:00");
        objRepresentation.setNbPlaceRestante(50);
        System.out.println(objRepresentation);
        objRepresentation = new Representation(1, null, null, null, null, null, 0);
        System.out.println(objRepresentation.equals(objRepresentation));
    }
}
