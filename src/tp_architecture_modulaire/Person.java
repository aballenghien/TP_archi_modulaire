/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_architecture_modulaire;

/**
 *
 * @author E140035M
 */
public class Person {
    String nom;
    String ville;
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    

    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Person{" + "nom=" + nom + ", ville=" + ville + ", age=" + age + '}';
    }
    
    
    
    
    
}
