/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author microsoft
 */
//Connector class to database 
public class datab {

    String USERNAME = "Dalia";
    String PASSWORD = "25122001";
    String CONN = "jdbc:mysql://localhost/bookstore";

    public static Connection dbconnect() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String db = "bookstore";
        String driver = "com.mysql.jdbc.Driver";
        String user = "Dalia";
        String pass = "25122001";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "Dalia", "25122001");
            if (conn == null) {
                System.out.println("Connection is not established");
            } else {
                System.out.println("Connected");
            }
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
 