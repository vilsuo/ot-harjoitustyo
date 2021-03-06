
package paassalaskuharjoittelusovellus.logic;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Game {
    final Difficulty difficulty;
    private int points;
    private int livesLeft;
    
    final OperationGenerator operationGenerator;
    private String operation;

    public Game(Difficulty difficulty) {
        this.difficulty = difficulty;
        this.points = 0;
        this.livesLeft = 3;
        this.operationGenerator = new OperationGenerator(difficulty);
        this.operation = operationGenerator.createNewRandomOperation();
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
    
    /**
     * Adds points by taking into account the difficulty level.
     */
    public void addPoints() {
        points += difficulty.getPointsPerCorrectAnswer();
    }

    public int getPoints() {
        return points;
    }

    public int getLivesLeft() {
        return livesLeft;
    }
    
    /**
     * Loses one life.
     */
    public void loseALife() {
        livesLeft--;
    }

    public String getOperation() {
        return operation;
    }
    
    /**
     * Generates a new random operation.
     */
    public void setNewRandomOperation() {
        operation = operationGenerator.createNewRandomOperation();
    }
    
    /**
     * Checks if the given answer is correct for the given operation.
     * 
     * @param answer given answer
     * @param operation the operation to check the answer for
     * 
     * @return true if answer is correct for the operation.
     * 
     * @throws ScriptException
     */
    public boolean checkAnswer(double answer, String operation) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (Double) engine.eval(operation + "+0.0") == answer;
    }
}
