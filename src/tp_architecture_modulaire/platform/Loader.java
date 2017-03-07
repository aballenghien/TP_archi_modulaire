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
import java.util.List;
import java.util.Properties;
import tp_architecture_modulaire.appli.IAfficheur;
import org.yaml.snakeyaml.Yaml;

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
    
    public Object conv(Object source, Class<?> target) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Object res = target.newInstance();
		for(Method m: source.getClass().getMethods()){
			if(isGetter(m)){
				Method setter = target.getMethod("s"+m.getName().substring(1), m.getReturnType());
				if(setter == null){
					System.out.println();
				}else{
					setter.invoke(res, m.invoke(source,null));
				}
			}
		}
		return res;
	}

	boolean isGetter(Method m){
		return (m.getName().startsWith("get")&&m.getParameterTypes().length == 0);
	}
        
//        public List<IDescription> getDescrForPlugin(Class<?> constraint) throws FileNotFoundException{
//            String filename = "";
//            Yaml yaml = new Yaml();
//            InputStream is = new FileInputStream(filename);
//            yaml.load(is);
//            
//        }
//        
//        public Object getPluginForDescr(IDescription description){
//            
//        }
        
    
}
