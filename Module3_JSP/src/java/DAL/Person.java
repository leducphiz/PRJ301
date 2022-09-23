package DAL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leducphi
 */
public class Person {
   public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
    

   

    @Override
    public String toString() {
        return "Person{" + "name=" + name + '}';
    }
    
    
}
