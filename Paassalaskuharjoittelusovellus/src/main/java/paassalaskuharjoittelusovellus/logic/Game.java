
package paassalaskuharjoittelusovellus.logic;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Game {
    final Difficulty difficulty;
    final User user;
    private int points;
    private int livesLeft;
    
    final OperationGenerator operationGenerator;
    private String operation;

    public Game(Difficulty difficulty, User user) {
        this.difficulty = difficulty;
        this.user = user;
        this.points = 0;
        this.livesLeft = 3;
        this.operationGenerator = new OperationGenerator(difficulty);
        this.operation = operationGenerator.createNewRandomOperation();
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
    
    public void addPoints() {
        points += difficulty.getPointsPerCorrectAnswer();
    }

    public int getPoints() {
        return points;
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public String getOperation() {
        return operation;
    }
    
    public void setNewRandomOperation() {
        operation = operationGenerator.createNewRandomOperation();
    }
    
    public boolean checkAnswer(int answer, String operation) throws ScriptException{
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (int) engine.eval(operation) == answer;
    }
    
    public void answer(int answer) throws ScriptException{
        boolean correct = checkAnswer(answer, operation);
        
        if(correct) {
            addPoints();
            setNewRandomOperation();
            
        } else {
            livesLeft--;
            if(livesLeft > 0) {
                setNewRandomOperation();
            } else {
                // Todo
            }
        }
    }
    
}
