package controleur;

import vue.VueGenerique;

/**
 * ControleurGenerique
 modèle de contrôleur de base
 chaque contrôleur possède :
 - une vue
 - une liaison vers le contrôleur principal
 * @author ydurand
 - v1.0
 */
public abstract class ControleurGenerique {
    
    protected VueGenerique vue = null;
    protected CtrlPrincipal ctrlPrincipal = null;

    // Constructeur du controller générique
    protected ControleurGenerique(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }    
     
    /**
     * 
     * @return vue : Getter de la vue Générique
     */
    public VueGenerique getVue() {
        return vue;
    }

    /**
     * 
     * @param vue : la vue Générique lié au controller
     */
    public void setVue(VueGenerique vue) {
        this.vue = vue;
    }

    /**
     * 
     * @return CtrlPrincipal : Getter du controller principal
     */
    public CtrlPrincipal getCtrlPrincipal() {
        return (CtrlPrincipal)ctrlPrincipal;
    }

    /**
     * 
     * @param ctrlPrincipal : Setter du controller principal
     */
    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }   

}
