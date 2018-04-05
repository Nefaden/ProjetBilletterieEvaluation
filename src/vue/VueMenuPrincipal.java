/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.*;

/**
 *
 * Fenêtre principale de l'application
 * @author ydurand
 * @version v0.1 - 22 février 2018
 * 
 */
public class VueMenuPrincipal extends VueGenerique {

    /**
     * Creates new form VueMenuPrincipal
     */
    public VueMenuPrincipal() {
        initComponents();
        myInitComponents();
        this.setLocation(500, 200);
    }   
    
    //GETTER
    /**
     * 
     * @return JMenuItem jMenuItemRepresentationAfficher : item du menu "representation"
     */
    public JMenuItem getjMenuItemRepresentationAfficher() {
        return jMenuItemRepresentationAfficher;
    }
    
    /**
     * 
     * @return JMenuItem jMenuItemVente : item du menu "vente"
     */
    public JMenuItem getjMenuItemVente() {
        return jMenuItemVente;
    }
    
    /**
     * 
     * @return JMenuItem jMenuItemQuitter : item du menu "fichier"
     */
    public JMenuItem getjMenuItemQuitter() {
        return jMenuItemQuitter;
    }
    
    /**
     * 
     * @return JMenuItem jMenuItemConnexion : item du menu "fichier" pour se connecter à la base distante
     */
    public JMenuItem getjMenuItemConnexion() {
        return jMenuItemConnexion;
    }
    
    //Initialisation des comlposants graphiques
    private void myInitComponents() {
        jLabelTitreMenu = new javax.swing.JLabel();
        jMenuBarGestion = new javax.swing.JMenuBar();
        jMenuFichier = new javax.swing.JMenu();
        jMenuRepresentation = new javax.swing.JMenu();
        jMenuVente = new javax.swing.JMenu();
        jMenuItemRepresentationAfficher = new javax.swing.JMenuItem();
        jMenuItemVente = new javax.swing.JMenuItem();
        jMenuItemQuitter = new javax.swing.JMenuItem();
        jMenuItemConnexion = new javax.swing.JMenuItem();
        jButtonVentePlace = new javax.swing.JButton();
        jButtonAfficherRepresentation = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ventes de billet v0.1 - février 2018");
        
        jLabelTitreMenu.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabelTitreMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitreMenu.setText("VENTES DE BILLETS");
        
        jButtonVentePlace.setText("Vendre");
        
        jButtonAfficherRepresentation.setText("Afficher");
        
        jMenuFichier.setText("Fichier");
        
        jMenuItemConnexion.setText("Se connecter");
        jMenuFichier.add(jMenuItemConnexion);
        
        jMenuItemQuitter.setText("Quitter");
        jMenuFichier.add(jMenuItemQuitter);
                
        jMenuBarGestion.add(jMenuFichier);
        
        jMenuRepresentation.setText("Representation");
        
        jMenuItemRepresentationAfficher.setText("Afficher les représentations");
        jMenuRepresentation.add(jMenuItemRepresentationAfficher);
        
        jMenuBarGestion.add(jMenuRepresentation);
        
        jMenuVente.setText("Vente");
        
        jMenuItemVente.setText("Vendre des places");
        jMenuVente.add(jMenuItemVente);
        
        jMenuBarGestion.add(jMenuVente);
        
        setJMenuBar(jMenuBarGestion);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTitreMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addComponent(jButtonVentePlace, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabelTitreMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        pack();
    }
    
    //Déclaration des variables
    private javax.swing.JLabel jLabelTitreMenu;
    private javax.swing.JMenuBar jMenuBarGestion;
    private javax.swing.JMenu jMenuFichier;
    private javax.swing.JMenu jMenuRepresentation;
    private javax.swing.JMenu jMenuVente;
    private javax.swing.JMenuItem jMenuItemRepresentationAfficher;
    private javax.swing.JMenuItem jMenuItemVente;
    private javax.swing.JMenuItem jMenuItemQuitter;
    private javax.swing.JMenuItem jMenuItemConnexion;
    private javax.swing.JButton jButtonVentePlace;
    private javax.swing.JButton jButtonAfficherRepresentation;
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
