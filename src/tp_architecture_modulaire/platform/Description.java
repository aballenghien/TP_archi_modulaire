/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_architecture_modulaire.platform;

import java.util.Map;

/**
 *
 * @author E140035M
 */
public class Description implements IDescription{
    
    private Map<String,String> properties;
    private String name;
    private String text;
   

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    public void addProperty(String key, String value){
        properties.put(key, value);
    }
    
    
}
