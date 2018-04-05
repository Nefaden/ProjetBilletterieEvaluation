/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ydurand
 */
public class testMD5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String motDePasse = "81dc9bdb52d04dc20036dbd8313ed055";
        
        MessageDigest mdPassword;

                mdPassword = MessageDigest.getInstance("MD5");

                mdPassword.update("1234".getBytes());
                byte[] digest2 = mdPassword.digest();
                StringBuffer sb2 = new StringBuffer();
                for (byte b : digest2) {
                    sb2.append(String.format("%02x", b & 0xff));
                }
                System.out.println("Mot de passe lu :" + motDePasse);
                System.out.println("chiffrage java :" + sb2);
    }
    
}
