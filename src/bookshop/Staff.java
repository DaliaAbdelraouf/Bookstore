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
public class Staff extends person {

    private Salary salary;   // composition 

    // Method to set the total salary value
    public Staff() {
        this.salary = new Salary();
        salary.setTotalSalary(25000);

    }

    public int TotalSalary() {
        return salary.getTotalSalary();
    }

    public Staff(String username, int password) {
        super(username, password);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
