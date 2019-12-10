
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import paassalaskuharjoittelusovellus.logic.Difficulty;
import paassalaskuharjoittelusovellus.logic.Game;

public class MenuViewController implements Initializable {

    @FXML
    private ComboBox comboBox;
    @FXML
    private Button hiscoreButton;
    @FXML
    private Button playButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Label usernameLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.getItems().addAll(Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD);
        usernameLabel.setText("Logged in: " + Main.getUser().getUserName());
    }
    
    @FXML
    private void handleComboBox(ActionEvent event) {
        if(comboBox.getValue() != null) {
            playButton.setDisable(false);
        }
    }
    
    @FXML
    private void onPlayButtonPressed(ActionEvent event) throws Exception {
        Main.setGame(new Game((Difficulty) comboBox.getValue()));
        Parent playViewParent = FXMLLoader.load(getClass().getResource("/fxml/PlayView.fxml"));
        Scene playViewScene = new Scene(playViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(playViewScene);
        window.show();
    }

    @FXML
    private void onHiscoreButtonPressed(ActionEvent event) throws Exception {
        Parent hiscoreViewParent = FXMLLoader.load(getClass().getResource("/fxml/HiscoreView.fxml"));
        Scene hiscoreViewScene = new Scene(hiscoreViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(hiscoreViewScene);
        window.show();
    }

    @FXML
    private void onLogOutButtonPressed(ActionEvent event) throws Exception {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(loginViewScene);
        window.show();
    }
    
}
