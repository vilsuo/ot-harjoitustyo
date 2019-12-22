
package paassalaskuharjoittelusovellus.dao;

import java.sql.*;
import paassalaskuharjoittelusovellus.domain.User;

/**
 * Class for handling User database transactions.
 * 
 */
public class UserDao {
    
    private String url;
    private Connection conn;

    public UserDao() throws Exception {
        url = "jdbc:h2:./databases/userDB";
        conn = null;
        
        createUserTable();
    }
    
    /**
     * Used for testing this class.
     * 
     * @param url the URL the test database
     * @throws Exception
     */
    public UserDao(String url) throws Exception {
        this.url = url;
        conn = null;
        
        createUserTable();
    }
    
    public Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, "sa", "");
        }
        return conn;
    }
    
    /**
     * Method creates User table. If the table already exists, nothing happens.
     * 
     * @throws Exception 
     */
    private void createUserTable() throws Exception {
        String query = "CREATE TABLE IF NOT EXISTS User (username VARCHAR(255), password VARCHAR(255));";
        
        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(query);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Adds a new User into the User table.
     * 
     * @param user User to add
     * 
     * @throws Exception
     */
    public void create(User user) throws Exception {
        if (usernameIsTaken(user.getUserName())) {
            return;
        }
        
        String query = "INSERT INTO User (username, password) VALUES (?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setString(1, user.getUserName());
        stmt.setString(2, user.getPassword());
        stmt.executeUpdate();
        stmt.close();
    }
    
    /**
     * Checks if there is username and password match in the User table. Used for login.
     *
     * @param username username to check
     * @param password password to check
     * 
     * @return true if there is a match, false otherwise
     * 
     * @throws Exception
     */
    public boolean usernameAndPasswordMatches(String username, String password) throws Exception {
        String query = "SELECT username, password FROM User WHERE username = ? AND password = ?;";
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next() == true;
    }
    
    /**
     * Checks if the username is found in the User table.
     * 
     * @param username username to check
     * 
     * @return true if the username is taken, false otherwise
     * 
     * @throws Exception
     */
    public boolean usernameIsTaken(String username) throws Exception {
        String query = "SELECT username FROM User WHERE username = ?;";
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        return rs.next() == true;
    }
}
