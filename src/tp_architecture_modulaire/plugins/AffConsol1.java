/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_architecture_modulaire.plugins;

import tp_architecture_modulaire.appli.IAfficheur;

/**
 *
 * @author E140035M
 */
public class AffConsol1 implements IAfficheur{

    @Override
    public void affiche(String s) {
        System.out.println(s);        
    }
    
}
