
package paassalaskuharjoittelusovellus.daoTest;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import paassalaskuharjoittelusovellus.dao.HiscoreDao;
import paassalaskuharjoittelusovellus.domain.User;
import paassalaskuharjoittelusovellus.logic.Difficulty;
import paassalaskuharjoittelusovellus.logic.Game;
import paassalaskuharjoittelusovellus.logic.HiscoreObject;

public class HiscoreDaoTest {
    
    private static HiscoreDao hiscoreDao;
    private static Connection conn;
    private static String url;
    
    private static User ville;
    private static User tiina;
    private static User tomi;
    
    private static Game e1;
    private static Game e2;
    private static Game m1;
    private static Game m2;
    private static Game h1;
    private static Game h2;
    
    @BeforeClass
    public static void setUpUsersAndGames() {
        ville = new User("ville", "swtefagf1");
        tiina = new User("tiina", "dasdasdf");
        tomi = new User("tomi", "124bj13oi");
        
        e1 = new Game(Difficulty.EASY); // 1
        e2 = new Game(Difficulty.EASY); // 10
        m1 = new Game(Difficulty.MEDIUM); // 5
        m2 = new Game(Difficulty.MEDIUM); // 50
        h1 = new Game(Difficulty.HARD); // 0
        h2 = new Game(Difficulty.HARD); // 100
        
        for(int i = 0; i < 10; i++) {
            e2.addPoints();
            m2.addPoints();
            h2.addPoints();
        }
        e1.addPoints();
        m1.addPoints();
    }
    
    @Before
    public void setUpConnection() throws Exception {
        hiscoreDao = new HiscoreDao("jdbc:h2:./databases/hiscoreTestDB");
        conn = hiscoreDao.getConnection();
    }
    
    @After
    public void tearDown() throws Exception {
        String query = "DROP TABLE Hiscore;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }
    
    @Test
    public void addingWorks() throws Exception {
        assertEquals(0, hiscoreDao.getHiscoreObjectsSortedByPoints().size());
        hiscoreDao.add(ville, e1);
        hiscoreDao.add(ville, m1);
        hiscoreDao.add(ville, h1);
        assertEquals(3, hiscoreDao.getHiscoreObjectsSortedByPoints().size());
        hiscoreDao.add(tiina, e2);
        hiscoreDao.add(tiina, h1);
        hiscoreDao.add(tomi, h1);
        assertEquals(6, hiscoreDao.getHiscoreObjectsSortedByPoints().size());
    }
    
    @Test
    public void getsHiscoreObjectsIncorrectOrder() throws Exception {
        hiscoreDao.add(ville, e1); // 1
        hiscoreDao.add(ville, m1); // 5
        hiscoreDao.add(ville, e2); // 10
        hiscoreDao.add(tiina, h1); // 0
        hiscoreDao.add(tomi, h1); // 0
        hiscoreDao.add(tomi, h2); // 100
        hiscoreDao.add(tomi, m2); // 50
        hiscoreDao.add(tiina, e2); // 10
        
        ObservableList<HiscoreObject> list = hiscoreDao.getHiscoreObjectsSortedByPoints();
        
        List<String> answers = Arrays.asList(new String[]{
            "1, tomi, 100, HARD",
            "2, tomi, 50, MEDIUM",
            "3, tiina, 10, EASY",
            "3, ville, 10, EASY",
            "4, ville, 5, MEDIUM",
            "5, ville, 1, EASY",
            "6, tiina, 0, HARD",
            "6, tomi, 0, HARD"
        });
        
        for (int i = 0; i < 8; i++) {
            if (i == 2 || i == 3) {
                assertTrue(list.get(i).toString().equals(answers.get(2)) ||
                        list.get(i).toString().equals(answers.get(3)));
                
            } else if (i == 6 || i == 7) {
                assertTrue(list.get(i).toString().equals(answers.get(6)) ||
                        list.get(i).toString().equals(answers.get(7)));
            } else {
                assertEquals(answers.get(i), list.get(i).toString());
            }
        }
    }
}
