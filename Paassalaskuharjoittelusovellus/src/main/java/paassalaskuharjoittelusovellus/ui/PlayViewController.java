
package paassalaskuharjoittelusovellus.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import paassalaskuharjoittelusovellus.logic.Game;

public class PlayViewController implements Initializable {

    @FXML
    private Label operationLabel;
    @FXML
    private TextField answerTextField;
    private Game game;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onKeyPressed(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)) {
            // TODO 
        }
    }
    
}
