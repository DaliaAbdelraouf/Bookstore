package bookshop;

import static com.sun.glass.ui.Cursor.setVisible;
import java.io.FileWriter;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author microsoft
 */
public class FXMLDocumentController implements Initializable {

    // login form controller
    @FXML
    TextField usernameLB;

    @FXML
    PasswordField passwordLB;

    @FXML
    Button btnLogin;

    @FXML
    Button btnNext;

    @FXML
    Button btnSignup;

    @FXML
    CheckBox check;

    @FXML
    private Hyperlink Forgetbtn;

    // Actionbutton for login button
    @FXML
    public void btnLogin(ActionEvent event) throws IOException {
        String username = usernameLB.getText();
        String password = passwordLB.getText();
        // String fileName= "data.txt";
        // save the login details in a file 
        try {
            FileWriter Writer = new FileWriter("data.txt", true);
            Writer.write("" + username + "" + password);
            Writer.write(System.getProperty("line.separator"));
            Writer.close();
            JOptionPane.showMessageDialog(null, "Login Sucess");
            setVisible(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "failed");
        }

    }

    // this function is made to switch to another scene 
    @FXML
    public void btnNext(ActionEvent event) throws Exception {

        Parent part = FXMLLoader.load(getClass().getResource("Products.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }
    // this function is made to switch to another scene 

    @FXML
    public void btnSignup(ActionEvent event) throws Exception {

        Parent part = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }
    // Remember me check box 

    @FXML
    public void rememberMe(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "I will remember You");
    }

    @FXML
    void Forgetpass(ActionEvent event) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

