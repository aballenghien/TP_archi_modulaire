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
public interface IDescription {
    
    public Map<String,String> getProperties();
    public String getName();
    public String getText();
    
}
