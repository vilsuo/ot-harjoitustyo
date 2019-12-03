
package paassalaskuharjoittelusovellus.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paassalaskuharjoittelusovellus.dao.UserDao;
import paassalaskuharjoittelusovellus.domain.User;

public class CreateUserViewController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button createButton;
    @FXML
    private Button backButton;
    @FXML
    private Label userCreationErrorLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onCreateButtonPressed(ActionEvent event) throws Exception {
        String usernameText = usernameTextField.getText();
        String passwordText = passwordField.getText();
        
        if(usernameText.equals("") || passwordText.equals("")) {
            return;
        }
        
        UserDao userDao = new UserDao();
        if(userDao.usernameIsTaken(usernameText)) {
            userCreationErrorLabel.setVisible(true);
            passwordField.clear();
        } else {
            userDao.create(new User(usernameText, passwordText));
            onBackButtonPressed(event);
        }
//        System.out.println("");
//        System.out.println("Printing users creteUserView");
//        userDao.getUsers().forEach(System.out::println);
    }

    @FXML
    private void onBackButtonPressed(ActionEvent event) throws Exception {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(loginViewScene);
        window.show();
    }
    
}
