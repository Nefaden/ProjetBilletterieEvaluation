package vue;

import javax.swing.JFrame;

/**
 * VueGenerique : modèle de vue
 - étend JFrame
 * @author ydurand
 * @version  20 novembre 2013
 *   - révision octobre 2016 : la vue est passive ; elle est écoutée par son contrôleur
 */

public abstract class VueGenerique extends JFrame{   
    public VueGenerique() {            
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ventes de billet v0.1 - février 2018");
    }           
}
