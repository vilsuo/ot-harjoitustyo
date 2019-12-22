
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import paassalaskuharjoittelusovellus.dao.HiscoreDao;
import paassalaskuharjoittelusovellus.logic.HiscoreObject;

public class HiscoreViewController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TableView<HiscoreObject> tableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setEditable(true);
        
        TableColumn<HiscoreObject, Integer> rankCol = new TableColumn("Rank");
        rankCol.setSortable(false);
        rankCol.setCellValueFactory(
                new PropertyValueFactory<HiscoreObject, Integer>("rank"));
        rankCol.setMinWidth(40);
        
        TableColumn usernameCol = new TableColumn("Username");
        usernameCol.setSortable(false);
        usernameCol.setCellValueFactory(
                new PropertyValueFactory<HiscoreObject, String>("username"));
        usernameCol.setMinWidth(157);
        
        TableColumn pointsCol = new TableColumn("Points");
        pointsCol.setSortable(false);
        pointsCol.setCellValueFactory(
                new PropertyValueFactory<HiscoreObject, Integer>("points"));
        pointsCol.setMinWidth(40);
        
        TableColumn difficultyCol = new TableColumn("Difficulty");
        difficultyCol.setSortable(false);
        difficultyCol.setCellValueFactory(
                new PropertyValueFactory<HiscoreObject, String>("difficulty"));
        difficultyCol.setMinWidth(40);
        
        try {
            HiscoreDao hiscoreDao = new HiscoreDao();
            tableView.setItems(hiscoreDao.getHiscoreObjectsSortedByPoints());
            tableView.getColumns().addAll(rankCol, usernameCol, pointsCol, difficultyCol);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        tableView.setEditable(false);
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
