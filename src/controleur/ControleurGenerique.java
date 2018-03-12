package controleur;

import vue.VueGenerique;

/**
 * ControleurGenerique
 modèle de contrôleur de base
 chaque contrôleur possède :
 - une vue
 - une liaison vers le contrôleur principal
 * @author ydurand
 * v1.0
 */
public abstract class ControleurGenerique {
    
    protected VueGenerique vue = null;
    protected CtrlPrincipal ctrlPrincipal = null;

    protected ControleurGenerique(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
     
    public VueGenerique getVue() {
        return vue;
    }

    public void setVue(VueGenerique vue) {
        this.vue = vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return (CtrlPrincipal)ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }   

}
