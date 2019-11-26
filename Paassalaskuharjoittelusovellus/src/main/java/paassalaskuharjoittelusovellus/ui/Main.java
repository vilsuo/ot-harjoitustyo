
package paassalaskuharjoittelusovellus.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import paassalaskuharjoittelusovellus.logic.Difficulty;
import paassalaskuharjoittelusovellus.logic.Game;
import paassalaskuharjoittelusovellus.logic.User;

public class Main extends Application {
    
    @Override
    public void init() throws Exception {
    
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception{
        launch(Main.class);
    }
    
}
