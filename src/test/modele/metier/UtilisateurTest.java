package test.modele.metier;

import modele.metier.Utilisateur;

/**
 * Classe permettant de tester la classe Utilisateur (getter/setter)
 *
 * @author ydurand v1.0
 */
public class UtilisateurTest {

    public static void main(String[] args) {
        Utilisateur objUtilisateur;

        System.out.println("\nTest n°1 : getter");
        objUtilisateur = new Utilisateur(1, "Durand", "Yann", "ydurand", "1234");
        System.out.println(objUtilisateur);

        System.out.println("\nTest n°2 : setter");
        objUtilisateur.setIdUtilisateur(69);
        objUtilisateur.setNom("Marie");
        objUtilisateur.setPrenom("Jean");
        objUtilisateur.setNomUtilisateur("jmarie");
        objUtilisateur.setMotDePasse("12345");
        System.out.println(objUtilisateur);
        objUtilisateur = new Utilisateur(1, null, null, null, null);
        System.out.println(objUtilisateur.equals(objUtilisateur));
    }
}
