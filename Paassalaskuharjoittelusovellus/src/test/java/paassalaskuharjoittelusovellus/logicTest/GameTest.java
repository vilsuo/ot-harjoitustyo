
package paassalaskuharjoittelusovellus.logicTest;

import java.util.regex.Pattern;
import javax.script.ScriptException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import paassalaskuharjoittelusovellus.logic.Difficulty;
import paassalaskuharjoittelusovellus.logic.Game;
import paassalaskuharjoittelusovellus.logic.User;

public class GameTest {
    
    private Game gameEasy;
    private Game gameMedium;
    private Game gameHard;
    
    private User user;
    
    @Before
    public void setUp() {
        User user = new User("username");
        
        gameEasy = new Game(Difficulty.EASY, user);
        gameMedium = new Game(Difficulty.MEDIUM, user);
        gameHard = new Game(Difficulty.HARD, user);
    }
    
    @Test
    public void addingPointsWorks() {
        assertEquals(0, gameEasy.getPoints());
        assertEquals(0, gameMedium.getPoints());
        assertEquals(0, gameHard.getPoints());
        gameEasy.addPoints();
        gameMedium.addPoints();
        gameHard.addPoints();
        assertEquals(Difficulty.EASY.getPointsPerCorrectAnswer(), gameEasy.getPoints());
        assertEquals(Difficulty.MEDIUM.getPointsPerCorrectAnswer(), gameMedium.getPoints());
        assertEquals(Difficulty.HARD.getPointsPerCorrectAnswer(), gameHard.getPoints());
    }
    
    @Test
    public void setNewRandomOperatorCreatesProperOperations() {
        for(int i = 0; i < 10; i++) {
            gameEasy.setNewRandomOperation();
            assertTrue(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", gameEasy.getOperation()));
            gameMedium.setNewRandomOperation();
            assertTrue(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", gameMedium.getOperation()));
            gameHard.setNewRandomOperation();
            assertTrue(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", gameHard.getOperation()));
        }
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "2"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "+3"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "4*"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "-"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "&"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "*4/"));
        
    }
    
    @Test
    public void checkAnswerChecksCorrectly() throws ScriptException {
        assertTrue(gameHard.checkAnswer(669, "711-42"));
        assertTrue(gameHard.checkAnswer(-41, "-42+1"));
        assertTrue(gameHard.checkAnswer(0, "0-0"));
        assertTrue(gameHard.checkAnswer(0, "10*0"));
        assertTrue(gameHard.checkAnswer(1368, "114*12"));
        assertTrue(gameHard.checkAnswer(17, "714/42"));
        assertTrue(gameHard.checkAnswer(753, "711+42"));
        assertTrue(gameHard.checkAnswer(1, "3/3"));
        assertFalse(gameHard.checkAnswer(0, "3*1"));
        assertFalse(gameHard.checkAnswer(112, "112/2"));
        assertFalse(gameHard.checkAnswer(321, "455-32"));
        assertFalse(gameHard.checkAnswer(27, "3+3"));
    }
    
}
