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
// products class used in order controller
public class Products {

    //products variables
    private int type;
    private int paymentM;
    private double price;
    private int quantity;

    // Get the value of quantity
    public int getQuantity() {
        return quantity;
    }

    //Set the value of quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Get the value of price
    public double getPrice() {
        return price;
    }

    // Set the value of price
    public void setPrice(double price) {
        this.price = price;
    }

    // Get the value of size
    public int getpaymentM() {
        return paymentM;
    }

    // Set the value of size
    public void setpaymentM(int paymentM) {
        this.paymentM = paymentM;
    }

    // Get the value of type
    public int getType() {
        return type;
    }

    //Set the value of type
    public void setType(int type) {
        this.type = type;
    }

}
