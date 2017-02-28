/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_architecture_modulaire.platform;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import tp_architecture_modulaire.appli.IAfficheur;

/**
 *
 * @author E140035M
 */
public class Loader {
    
    public static Object loadBean(String filename) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
        
        //charger le fichier
        Properties p = new Properties();
        InputStream is = new FileInputStream(filename);
        p.load(is);
        
        //créer le beans
        Class<?> cl= Class.forName(p.getProperty("class"));
        
        // créer l'objet
        Object o = cl.newInstance();
        
        for(Object key : p.keySet()){
            if(!key.toString().equals("class")){
                Method setter = cl.getMethod("set"+key, String.class);
                setter.invoke(o,p.getProperty(key.toString()));
            }
        }
        
        return o;
    }
    
    
    public static Object loadBeanV2(String filename) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
        
        //charger le fichier
        Properties p = new Properties();
        InputStream is = new FileInputStream(filename);
        p.load(is);
        
        //créer le beans
        Class<?> cl= Class.forName(p.getProperty("class"));
        
        // créer l'objet
        Object o = cl.newInstance();
        for(Object key : p.keySet()){
            if(!key.toString().equals("class")){
                Method getter = cl.getMethod("get"+key, null);
                Class<?> typeGetter = getter.getReturnType();
                Method setter = cl.getMethod("set"+key, typeGetter);                
                if(typeGetter.equals(int.class)){
                    setter.invoke(o,Integer.parseInt(p.getProperty(key.toString())));
                }else{
                    setter.invoke(o,p.getProperty(key.toString()));
                }
                
            }
        }
        
        return o;
    }
    
    public static Object getPlugin(String filename, Class<?> contrainte) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        //charger le fichier
        Properties p = new Properties();
        InputStream is = new FileInputStream(filename);
        p.load(is);
        
        //créer le beans
        Class<?> cl= Class.forName(p.getProperty("class"));        
        if(contrainte.isAssignableFrom(cl)){
            Object o = cl.newInstance();
            return o;
        }  
        
        
        return null;
    }
    
}
