
package paassalaskuharjoittelusovellus.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import paassalaskuharjoittelusovellus.dao.HiscoreDao;
import paassalaskuharjoittelusovellus.domain.Heart;
import paassalaskuharjoittelusovellus.domain.User;
import paassalaskuharjoittelusovellus.logic.Game;

public class PlayViewController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Label operationLabel;
    @FXML
    private TextField answerTextField;
    @FXML
    private Label infoLabel;
    @FXML
    private Label pointsLabel;
    
    private Game game;
    private User user;
    private ScaleTransition st;
    private Rectangle rect;
    
    // lives
    private Shape h1;
    private Shape h2;
    private Shape h3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = Main.getGame();
        user = Main.getUser();
        operationLabel.setText(game.getOperation());
        
        h1 = new Heart(40, 50).getHeart();
        h2 = new Heart(70, 50).getHeart();
        h3 = new Heart(100, 50).getHeart();
        
        root.getChildren().addAll(h1, h2, h3);
        
        drawRectangle();
    }
    
    private void drawRectangle() {
        root.getChildren().removeIf((node) -> {
            return node instanceof Rectangle;
        });
        
        rect = new Rectangle(-400, 150, 800, 10);
        rect.setFill(Color.RED);
        
        rect.scaleXProperty().addListener((observable) -> {
            // if the time runs out
            if (rect.getScaleX() == 0.0) {
                infoLabel.setText("Time ran out");
                infoLabel.setTextFill(Color.RED);
                loseALife();
                
                // if no lives left
                if(!prepareNewOperation()) {
                    infoLabel.setText("GAME OVER");
                    infoLabel.setTextFill(Color.RED);
                    answerTextField.setEditable(false);
                }
            }
        });
        root.getChildren().add(rect);

        // transition for the rectangle
        st = new ScaleTransition(Duration.seconds(game.getDifficulty().getTimePerAnswer()), rect);
        st.setToX(0);
        st.play();
    }

    @FXML
    private void onKeyPressed(KeyEvent event) throws Exception {
        if (game.getLivesLeft() > 0) {
            infoLabel.setText("");
            if (event.getCode().equals(KeyCode.ENTER)) {
            // theres time left
                if (rect.getScaleX() > 0.0) {
                    if (!handleAnswer()) {
                        return;
                    }
                }
                
                // game over?
                if (!prepareNewOperation()) {
                    st.stop();
                    infoLabel.setText("GAME OVER");
                    infoLabel.setTextFill(Color.RED);
                    answerTextField.setEditable(false);
                }
            }
        } else {
            setHiscore();
        
            Parent menuViewParent = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
            Scene menuViewScene = new Scene(menuViewParent);
        
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(menuViewScene);
            window.show();
        }
    }
    
    /**
     * 
     * @return true if answer was accepted
     * @throws Exception 
     */
    private boolean handleAnswer() throws Exception {
        // answer is not a number
        if (!isNumber(answerTextField.getText())) {
            infoLabel.setText("Your answer is not a number!");
            infoLabel.setTextFill(Color.RED);
            return false;
        }
        
        // correct answer
        if (game.checkAnswer(Double.parseDouble(answerTextField.getText()), game.getOperation())) {
            infoLabel.setText("Correct!");
            infoLabel.setTextFill(Color.GREEN);
            game.addPoints();
            
        // incorrect answer
        } else {
            infoLabel.setText("False!");
            infoLabel.setTextFill(Color.RED);
            loseALife();
        }
        return true;
    }
    
    /**
     * 
     * @return true if lives left.
     */
    private boolean prepareNewOperation() {
        if (game.getLivesLeft() <= 0) {
            return false;
        }
        
        game.setNewRandomOperation();
        answerTextField.clear();
        operationLabel.setText(game.getOperation());
        pointsLabel.setText("Points: " + game.getPoints());
        drawRectangle();
        return true;
    }
    
    private void setHiscore() {
        HiscoreDao hiscoreDao;
        try {
            hiscoreDao = new HiscoreDao();
            hiscoreDao.add(user, game);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    private void loseALife() {
        game.loseALife();
        if (game.getLivesLeft() == 2) {
            root.getChildren().remove(h3);
        } else if (game.getLivesLeft() == 1) {
            root.getChildren().remove(h2);
        } else {
            root.getChildren().remove(h1);
        }
    }
    
    private boolean isNumber(String string) {
        if (string == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}