
package paassalaskuharjoittelusovellus.logicTest;

import org.junit.Test;
import static org.junit.Assert.*;
import paassalaskuharjoittelusovellus.logic.HiscoreObject;

public class HiscoreObjectTest {
    
    @Test
    public void equalsWorks() {
        HiscoreObject h1 = new HiscoreObject(1, "ville", 100, "EASY");
        assertFalse(h1.equals(null));
        assertFalse(h1.equals("string"));
        
        assertTrue(h1.equals(h1));
        assertTrue(h1.equals(new HiscoreObject(1, "ville", 100, "EASY")));
        assertFalse(h1.equals(new HiscoreObject(2, "ville", 100, "EASY")));
        assertFalse(h1.equals(new HiscoreObject(1, "villes", 100, "EASY")));
        assertFalse(h1.equals(new HiscoreObject(1, "ville", 1000, "EASY")));
        assertFalse(h1.equals(new HiscoreObject(1, "ville", 100, "MEDIUM")));
    }
    
    @Test
    public void toStringWorks() {
        HiscoreObject h1 = new HiscoreObject(1, "ville", 100, "EASY");
        assertEquals("1, ville, 100, EASY", h1.toString());
        
        HiscoreObject h2 = new HiscoreObject(12, "v", 300, "HARD");
        assertEquals("12, v, 300, HARD", h2.toString());
    }
}
