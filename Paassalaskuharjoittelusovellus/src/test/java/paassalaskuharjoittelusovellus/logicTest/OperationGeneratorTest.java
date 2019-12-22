
package paassalaskuharjoittelusovellus.logicTest;

import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import paassalaskuharjoittelusovellus.logic.Difficulty;
import paassalaskuharjoittelusovellus.logic.OperationGenerator;

public class OperationGeneratorTest {
    private static OperationGenerator easy;
    private static OperationGenerator medium;
    private static OperationGenerator hard;
    
    @BeforeClass
    public static void setUp() {
        easy = new OperationGenerator(Difficulty.EASY);
        medium = new OperationGenerator(Difficulty.MEDIUM);
        hard = new OperationGenerator(Difficulty.HARD);
    }
    
    @Test
    public void createsProperRandomOperations() {
        for (int i = 0; i < 10; i++) {
            assertTrue(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", easy.createNewRandomOperation()));
            assertTrue(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", medium.createNewRandomOperation()));
            assertTrue(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", hard.createNewRandomOperation()));
        }
        
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "2"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "+3"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "4*"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "-"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "&"));
        assertFalse(Pattern.matches("\\d+(\\+|-|\\*|/)\\d+", "*4/"));
    }
}
