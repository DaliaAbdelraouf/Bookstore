/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

//import bookshop.databa.connection;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;
import static org.eclipse.persistence.jpa.jpql.parser.Expression.SQL;

/**
 * FXML Controller class
 *
 * @author microsoft
 */
public class SignUpController extends datab implements Initializable {

    @FXML
    private TextField Fullname;

    @FXML
    private TextField Email;

    @FXML
    private TextField Address;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void signup(ActionEvent event) throws ClassNotFoundException {

        Connection conn = datab.dbconnect();
        try {
            // PreparedStatement stmt ;
            PreparedStatement stmt = conn.prepareStatement(SQL);

            dbconnect();
            stmt = conn.prepareStatement(SQL);
            String SQL = "INSERT into Signup details (FullName,Email,Address,UserName,Password) VALUES (?, ?, ?, ?, ?)";

            stmt.setString(1, Fullname.getText());
            stmt.setString(2, Email.getText());
            stmt.setString(3, Address.getText());
            stmt.setString(4, username.getText());
            stmt.setString(5, password.getText());
            stmt.executeUpdate();
            //   con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
