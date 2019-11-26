
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button LoginButton;
    @FXML
    private Button createANewUserButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onCreateANewAccountButtonPressed(ActionEvent event) throws Exception {
        Parent createUserViewParent = FXMLLoader.load(getClass().getResource("/fxml/CreateUserView.fxml"));
        Scene createUserViewScene = new Scene(createUserViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(createUserViewScene);
        window.show();
    }
    
    @FXML
    private void onLoginButtonPressed(ActionEvent event) {
        
    }

    @FXML
    private void onBackButtonPressed(ActionEvent event) {
    }
}
