
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
        
    }    

    @FXML
    private void onCreateButtonPressed(ActionEvent event) throws Exception {
        String usernameText = usernameTextField.getText();
        String passwordText = passwordField.getText();
        
        if (usernameText.equals("") || passwordText.equals("")) {
            userCreationErrorLabel.setText("Username or passsword missing.");
            passwordField.clear();
            return;
        }
        
        if (usernameText.length() > 20 || passwordText.length() > 20) {
            userCreationErrorLabel.setText("Username or password to long. Maximum 20 characters.");
            passwordField.clear();
            return;
        }
        
        UserDao userDao = new UserDao();
        if (userDao.usernameIsTaken(usernameText)) {
            userCreationErrorLabel.setText("This username is already taken.");
            passwordField.clear();
        } else {
            userDao.create(new User(usernameText, passwordText));
            onBackButtonPressed(event);
        }
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
