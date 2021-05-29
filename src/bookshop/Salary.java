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
public class Salary {
    
    private int date;
    private String quantity;
    private String currency ;
   private int TotalSalary;

    public Salary() {
    }
   // constructor for salary variables
    public Salary(int date, String quantity, String currency, int TotalSalary) {
        this.date = date;
        this.quantity = quantity;
        this.currency = currency;
        this.TotalSalary = TotalSalary;
    }

    
    
   // settersand getters for salary
    public int getTotalSalary() {
        return TotalSalary;
    }

    public void setTotalSalary(int TotalSalary) {
        this.TotalSalary = TotalSalary;
    }

    
    
    

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    
    
    
}
