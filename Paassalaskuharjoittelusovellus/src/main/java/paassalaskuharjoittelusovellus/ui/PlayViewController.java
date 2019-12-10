
package paassalaskuharjoittelusovellus.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = Main.getGame();
        user = Main.getUser();
        operationLabel.setText(game.getOperation());
        
        drawRectangle();
    }
    
    private void drawRectangle() {
        root.getChildren().removeIf((node) -> {
            return node instanceof Rectangle;
        });
        
        rect = new Rectangle(-400, 150, 800, 10);
        rect.setFill(Color.RED);
        
        // if the time runs out
        rect.scaleXProperty().addListener((observable) -> {
            if (rect.getScaleX() == 0.0) {
                game.loseALife();
                
                if(!prepareNewOperation()) {
                    infoLabel.setText("GAME OVER");
                    answerTextField.setEditable(false);
                }
            }
        });
        root.getChildren().add(rect);

        st = new ScaleTransition(Duration.seconds(5), rect);
        st.setToX(0);
        st.play();
    }

    @FXML
    private void onKeyPressed(KeyEvent event) throws Exception {
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
//                setHiscore();
                answerTextField.setEditable(false);
            }
        }
    }
    
    /**
     * 
     * @return true if answer was accepted
     * @throws Exception 
     */
    private boolean handleAnswer() throws Exception {
        // answer is not a number
        if(!isNumber(answerTextField.getText())) {
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
            game.loseALife();
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
    
//    private void setHiscore() throws Exception {
//        HiscoreDao hiscoreDao = new HiscoreDao();
//        hiscoreDao.add(user, game);
//    }
    
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