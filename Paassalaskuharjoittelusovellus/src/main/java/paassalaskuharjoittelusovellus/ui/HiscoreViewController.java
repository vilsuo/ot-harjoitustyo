
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class HiscoreViewController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TableView<?> tableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setEditable(true);
        
        TableColumn rankCol = new TableColumn("Rank");
        TableColumn usernameCol = new TableColumn("Username");
        TableColumn pointsCol = new TableColumn("Points");
        
        tableView.getColumns().addAll(rankCol, usernameCol, pointsCol);
        
        
        
        
        
        
        
        
        
        
        
        tableView.refresh();
    }    

    @FXML
    private void onBackButtonPressed(ActionEvent event) throws Exception {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        Scene menuViewScene = new Scene(menuViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(menuViewScene);
        window.show();
    }
    
}
