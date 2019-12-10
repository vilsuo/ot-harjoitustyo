
package paassalaskuharjoittelusovellus.daoTest;

import java.sql.*;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import paassalaskuharjoittelusovellus.dao.UserDao;
import paassalaskuharjoittelusovellus.domain.User;

public class UserDaoTest {
    
    private static UserDao userDao;
    private static Connection conn;
    private static String url;
    
    @Before
    public void setUp() throws Exception {
        userDao = new UserDao("jdbc:h2:./databases/userTestDB");
        conn = userDao.getConnection();
    }
    
    @After
    public void tearDown() throws Exception {
        String query = "DROP TABLE User;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }
    
    @Test
    public void addingWorks() throws Exception {
        assertFalse(userDao.usernameIsTaken("jussi"));
        userDao.create(new User("jussi", "s"));
        assertTrue(userDao.usernameIsTaken("jussi"));
        assertFalse(userDao.usernameIsTaken("ville"));
        assertFalse(userDao.usernameIsTaken("Ville"));
        userDao.create(new User("ville", "qwer"));
        userDao.create(new User("Ville", "asdasd"));
        assertTrue(userDao.usernameIsTaken("ville"));
        assertTrue(userDao.usernameIsTaken("Ville"));
    }
    
    @Test
    public void usernameAndPasswordMaches() throws Exception {
        assertFalse(userDao.usernameAndPasswordMatches("", ""));
        assertFalse(userDao.usernameAndPasswordMatches("jussi", "qwert"));
        
        userDao.create(new User("jussi", "qwert"));
        assertTrue(userDao.usernameAndPasswordMatches("jussi", "qwert"));
        
        assertFalse(userDao.usernameAndPasswordMatches("jussi", "qwertt"));
        assertFalse(userDao.usernameAndPasswordMatches("jussi", ""));
        
        userDao.create(new User("ville", "asdasd"));
        assertTrue(userDao.usernameAndPasswordMatches("ville", "asdasd"));
        assertFalse(userDao.usernameAndPasswordMatches("jussi", "asdasd"));
    }
}
