/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author microsoft
 */
public class Bookshop extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Object from person class to print the overided method from interface(welcome)
        person p = new person();
        p.printw();

        // object from class staff to print the totalSalary
        Staff s = new Staff();
        int TotalSalary = s.TotalSalary();

        System.out.println("TotalSalary of Staff:" + TotalSalary);

        //object from class customers to print the books available, overloaded methods 
        customers nn = new customers();
        nn.Book("Used Books availabe is" + 3000);
        nn.Book("New Books availabe is" + 12000);
        nn.Book("First Edition Books availabe is" + 14000);

        System.out.print(System.lineSeparator()); // seprator line to print new line 
        nn.Book("Books availabe is Novels,Comic books, Horror,Adventure,kids and Mystry  ");

        // print book types available 
        System.out.print(System.lineSeparator());
        BookType b = new BookType();
        b.type();

        System.out.print(System.lineSeparator());
        Novels n = new Novels();
        n.type();

        System.out.print(System.lineSeparator());
        Horror h = new Horror();
        h.type();

        System.out.print(System.lineSeparator());
        ComicBooks e = new ComicBooks();
        e.type();
        System.out.print("========================================================================");

        launch(args);

    }

}
