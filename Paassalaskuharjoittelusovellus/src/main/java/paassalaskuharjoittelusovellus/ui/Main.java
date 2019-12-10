
package paassalaskuharjoittelusovellus.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import paassalaskuharjoittelusovellus.domain.User;
import paassalaskuharjoittelusovellus.logic.Game;

public class Main extends Application {
    
    private static User user;
    private static Game game;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static User getUser() {
        return user;
    }
    
    public static void setUser(User newUser) {
        user = newUser;
    }
    
    public static Game getGame() {
        return game;
    }
    
    public static void setGame(Game newGame) {
        game = newGame;
    }

    public static void main(String[] args) throws Exception {
        launch(Main.class);
    }
}
