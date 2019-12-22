
package paassalaskuharjoittelusovellus.logicTest;

import javax.script.ScriptException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import paassalaskuharjoittelusovellus.logic.Difficulty;
import paassalaskuharjoittelusovellus.logic.Game;
import paassalaskuharjoittelusovellus.domain.User;

public class GameTest {
    
    private Game gameEasy;
    private Game gameMedium;
    private Game gameHard;
    
    @Before
    public void setUp() {
        User user = new User("username", "password");
        
        gameEasy = new Game(Difficulty.EASY);
        gameMedium = new Game(Difficulty.MEDIUM);
        gameHard = new Game(Difficulty.HARD);
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
    public void checkAnswerChecksCorrectly() throws ScriptException {
        assertTrue(gameHard.checkAnswer(669, "711-42"));
        assertTrue(gameHard.checkAnswer(-41, "-42+1"));
        assertTrue(gameHard.checkAnswer(0, "0-0"));
        assertTrue(gameHard.checkAnswer(0, "10*0"));
        assertTrue(gameHard.checkAnswer(1368.0, "114*12"));
        assertTrue(gameHard.checkAnswer(17, "714/42"));
        assertTrue(gameHard.checkAnswer(753, "711+42"));
        assertTrue(gameHard.checkAnswer(1, "3/3"));
        assertTrue(gameHard.checkAnswer(1.5, "3/2"));
        assertTrue(gameHard.checkAnswer(5, "3+2"));
        assertTrue(gameHard.checkAnswer(5.0, "3+2"));
        assertFalse(gameHard.checkAnswer(0, "3*1"));
        assertFalse(gameHard.checkAnswer(112, "112/2"));
        assertFalse(gameHard.checkAnswer(321, "455-32"));
        assertFalse(gameHard.checkAnswer(27, "3+3"));
        assertFalse(gameHard.checkAnswer(1, "3/2"));
    }
    
}
