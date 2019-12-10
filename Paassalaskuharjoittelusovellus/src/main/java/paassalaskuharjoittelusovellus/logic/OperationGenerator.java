
package paassalaskuharjoittelusovellus.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OperationGenerator {
    private final Difficulty difficulty;
    private final Random random;
    private final List<String> operations;
    
    public OperationGenerator(Difficulty difficulty) {
        this.difficulty = difficulty;
        this.random = new Random();
        this.operations = Arrays.asList("+", "-", "/", "*");
    }
    
    /**
     * Creates a new random operation for current difficulty.
     * 
     * @return operation as a String
     */
    public String createNewRandomOperation() {
        switch (difficulty) {
            case EASY:
                return easyGenerator();
            case MEDIUM:
                return mediumGenerator();
            case HARD:
                return hardGenerator();
            default:
                throw new AssertionError("Invalid difficulty");
        }
    }
    
    private String easyGenerator() {
        String op = operations.get(random.nextInt(operations.size()));
        int val1 = random.nextInt(9) + 2;
        int val2 = random.nextInt(9) + 2;
        
        if (op.equals("/")) {
            return val1 * val2 + op + val1;
            
        } else if (op.equals("*")) {
            return val1 + op + val2;
            
        } else {
            return (val1 + random.nextInt(11)) + op + (val2 + random.nextInt(11));
        }
    }
    
    private String mediumGenerator() {
        String op = operations.get(random.nextInt(operations.size()));
        int val1 = random.nextInt(18) + 7;
        int val2 = random.nextInt(30) + 11;
        
        if (op.equals("/")) {
            return val1 * val2 + op + val1;
            
        } else if (op.equals("*")) {
            return val1 + op + val2;
            
        } else {
            return (val1 * (random.nextInt(50) + 1) + random.nextInt(50)) + op 
                    + (val2 + (random.nextInt(50) + 1) + random.nextInt(50));
        }
    }
    
    private String hardGenerator() {
        String op = operations.get(random.nextInt(operations.size()));
        int val1 = random.nextInt(64) + 37;
        int val2 = random.nextInt(37) + 14;
        
        if (op.equals("/")) {
            return val1 * val2 * (random.nextInt(9) + 1) + op + val1;
            
        } else if (op.equals("*")) {
            return val1 + op + val2;
            
        } else {
            return (val1 * (random.nextInt(100) + 101) + random.nextInt(100)) + op 
                    + (val2 * (random.nextInt(100) + 101) + random.nextInt(100));
        }
    }
}
