/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import modele.dao.GroupeDao;
import modele.dao.LieuDao;
import modele.metier.Lieu;
import modele.metier.Representation;

/**
 *
 * @author ydurand
 */
public class RepresentationTest {

    public static void main(String[] args) {
        Representation repr, repr1, repr2;
        System.out.println("\nTest n°1 : instanciation et accesseurs/getter");
        repr = new Representation(1, "11/07/2017", "", "g024", "19:00", "20:00");
        System.out.println(repr);
        System.out.println("\nTest n°2 : mutateurs/setter");
        repr.setDateRepresentation("11/07/2017");
        repr.setLieu();
        repr.setGroupe(GroupeDao.selectOneById(id_Groupe));
        repr.setHeureDebRepresentation("19:00");
        repr.setHeureFinRepresentation("20:00");
        System.out.println(repr);
        repr1 = new Representation(1, null, null, null, null, null);
        System.out.println(repr1.equals(repr));
        repr2 = new Representation(2, null, null, null, null, null);
        System.out.println(repr1.equals(repr2));
    }

}
