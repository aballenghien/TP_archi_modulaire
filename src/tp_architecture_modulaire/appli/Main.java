/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_architecture_modulaire.appli;

import tp_architecture_modulaire.plugins.Person;
import tp_architecture_modulaire.platform.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author E140035M
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
            Object o = Loader.loadBeanV2("/comptes/E140035M/NetBeansProjects/TP_Architecture_modulaire/src/tp_architecture_modulaire/appli/beans.txt");
            ((IAfficheur)Loader.getPlugin("/comptes/E140035M/NetBeansProjects/TP_Architecture_modulaire/src/tp_architecture_modulaire/appli/config.txt", IAfficheur.class)).affiche(((Person)o).toString());
        
       
    }
    
}
