/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import javax.swing.JOptionPane;

/**
 *
 * @author microsoft
 */
public class person implements Welcome {

    private String username;
    private int password;

    public person() {
    }

    public person(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "person{" + "username=" + username + ", password=" + password + '}';
    }

    @Override
    public void printw() {

        JOptionPane.showMessageDialog(null, "Welcome to Book Shop System");
    }

}
