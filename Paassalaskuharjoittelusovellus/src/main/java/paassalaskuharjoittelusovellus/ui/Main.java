
package paassalaskuharjoittelusovellus.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import paassalaskuharjoittelusovellus.logic.Difficulty;
import paassalaskuharjoittelusovellus.logic.Game;
import paassalaskuharjoittelusovellus.logic.User;

public class Main extends Application {
    private Stage primaryStage;
    
    private Scene loginScene;
    private Scene createNewUserScene;
    private Scene menuScene;
    private Scene diffucultyScene;
    private Scene hiscoreScene;
    private Scene playScene;
    
    @Override
    public void init() throws Exception {
        
    }
    
    public void setLoginScene() {
        primaryStage.setScene(loginScene);
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        setLoginScene();
        this.primaryStage.show();
    }

    public static void main(String[] args) throws InterruptedException{
//        launch(args);

        User user = new User("username");
        Game easy = new Game(Difficulty.EASY, user);
        Game normal = new Game(Difficulty.MEDIUM, user);
        Game hard = new Game(Difficulty.HARD, user);
    }
    
}
