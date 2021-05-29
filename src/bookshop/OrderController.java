/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author microsoft
 */
public class OrderController implements Initializable {
    //order buttons

    @FXML
    private Label lblType;
    //Radio buttons to choose
    @FXML
    private RadioButton FirstEdition;
    @FXML
    private RadioButton New;
    @FXML
    private RadioButton Used;
    @FXML
    private Label lblSize;
    //Arraylist to make customer choose from the choice box 
    @FXML
    private ChoiceBox<String> cbSize;
    private final String[] sizeItems = {"CashOnDelivery", "CreditCard", "Paypal"};
    private final ObservableList<String> sizeList = FXCollections.observableArrayList(sizeItems);
    @FXML
    private Label lblQuantity;
    @FXML
    private TextField tfQuantity;
    @FXML
    private Button btnOrder;
    @FXML
    private Button btnReset;
    @FXML
    private TextArea taSummary;
    @FXML
    private ToggleGroup tgType;

    @FXML
    private Button btnCalculateSales;

    @FXML
    private TextArea taSalesSummary;

    //Method to handle the order button
    @FXML
    private void handleOrderButtonAction1(ActionEvent event) {

//        double price = 0.0;
//        int quantity = Integer.parseInt(tfQuantity.getText());
//        String PaymentM = cbSize.getSelectionModel().getSelectedItem();
        //object from producta class
        Products p = new Products();
        //if conditions take the choice from user with a fixed price 
        if (New.isSelected()) {
            p.setType(1); // 1 for New, 2 for Used, 3 for FirstEdition
            p.setpaymentM(cbSize.getSelectionModel().getSelectedIndex()); // then choode CashOnDelivery , CreditCard, Paypal  
            p.setPrice(120);
            p.setQuantity(Integer.parseInt(tfQuantity.getText()));
            taSummary.appendText(New.getText() + " " + p.getPrice() + " " + p.getQuantity() + " " + p.getpaymentM() + "\n"); //append the order details in the text area
            // save order data to a File (sales.txt)
            writeRecord(p);
        } else if (Used.isSelected()) {
            p.setType(2);
            p.setpaymentM(cbSize.getSelectionModel().getSelectedIndex());
            p.setPrice(50);
            p.setQuantity(Integer.parseInt(tfQuantity.getText()));
            taSummary.appendText(Used.getText() + " " + p.getPrice() + " " + p.getQuantity() + " " + p.getpaymentM() + "\n");
            writeRecord(p);
        } else if (FirstEdition.isSelected()) {
            p.setType(3);
            p.setpaymentM(cbSize.getSelectionModel().getSelectedIndex());
            p.setPrice(150);
            p.setQuantity(Integer.parseInt(tfQuantity.getText()));
            taSummary.appendText(FirstEdition.getText() + " " + p.getPrice() + " " + p.getQuantity() + " " + p.getpaymentM() + "\n");
            writeRecord(p);
        } else {
            taSummary.appendText("Please select a Book type!\n"); //if order button pressed without any choices
        }
    }

    //method Reset button Action event
    @FXML
    private void handleResetButtonAction(ActionEvent event) {
        // make all the values null to reset the order details
        New.setSelected(false);
        FirstEdition.setSelected(false);
        Used.setSelected(false);
        tfQuantity.setText(null);
        cbSize.setValue(null);
    }

    // Method to handle the calculate sales buttons
    @FXML
    private void handleCalculateSalesButtonAction(ActionEvent event) {
        // Read sales data/records(that was saved to a file), and then calculate its sales with subtotal and total sales
        readRecord();
    }

    //this method read the order details
    public void readRecord() {
        File file = null;
        Scanner input = null;

        try {
            file = new File("(SALES.txt");
            // Create a Scanner object for the file
            input = new Scanner(file);

            // Calculate subtotal
            double subtotal = 0.0;
            double total = 0.0;

            // Set a heading for the text area 
            taSalesSummary.appendText("Type \t" + "Price \t" + "Quantity \t" + "ProductsM \t" + "Subtotal \n");
            // Read data from a file
            while (input.hasNext()) {
                int type = input.nextInt();
                double price = input.nextDouble();
                int quantity = input.nextInt();
                int PaymentM = input.nextInt();
                subtotal = price * quantity;
                taSalesSummary.appendText(type + " \t\t" + price + "\t\t" + quantity + "\t\t" + PaymentM + "\t\t" + subtotal + "\n"); // append sll the sales details in the text Area
                total += subtotal;
            }
            taSalesSummary.appendText("Total Sales: " + total + "\n"); //total sales appear in the text area
            // close input stream file
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.toString();
//       } catch (IOException ex2){
//            ex2.toString();
//        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    // Method used in the order action event to write the order details in a text file 
    public void writeRecord(Products products) {
        FileWriter file = null;
        PrintWriter output = null;

        try {
            // Construcrs a FileWriter object 
            // the boolean indicates whether to append data to an existing file 
            file = new FileWriter("(SALES.txt", true);

            // Create an output file
            output = new PrintWriter(file);

            // Write formatted output to the file with one space betwen data
            output.println(products.getType() + " " + products.getPrice() + " " + products.getQuantity() + " " + products.getpaymentM());

            // close the output stream object 
            output.close();
        } catch (FileNotFoundException ex1) {
            ex1.toString();
        } catch (IOException ex2) {
            ex2.toString();
        } finally {
            if (output != null) { // in case if it is not closed properly 
                output.close();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbSize.setItems(sizeList);
    }
}
