/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

/**
 *
 * @author microsoft
 */
//Inheritance
public class customers extends person {

    public customers() {
    }

    public customers(String username, int password) {
        super(username, password);
    }

    
    public void Book(String num){     //overloading
        System.out.println(num);
        
    }
    
    public void Book(int name){       //overloading
        System.out.println(name);
        
    }
    
    
    
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
