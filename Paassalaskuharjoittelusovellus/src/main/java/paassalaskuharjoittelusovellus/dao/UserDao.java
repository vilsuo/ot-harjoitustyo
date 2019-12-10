
package paassalaskuharjoittelusovellus.dao;

import java.sql.*;
import paassalaskuharjoittelusovellus.domain.User;

public class UserDao {
    
    private String url;
    private Connection conn;

    public UserDao() throws Exception {
        url = "jdbc:h2:./databases/userDB";
        conn = null;
        
        createUserTable();
    }
    
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
    
    private void createUserTable() throws Exception {
        String query = "CREATE TABLE IF NOT EXISTS User (username VARCHAR(255), password VARCHAR(255));";
        
        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
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
    
    public boolean usernameAndPasswordMatches(String username, String password) throws Exception {
        String query = "SELECT username, password FROM User WHERE username = ? AND password = ?;";
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next() == true;
    }
    
    public boolean usernameIsTaken(String username) throws Exception {
        String query = "SELECT username FROM User WHERE username = ?;";
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        return rs.next() == true;
    }
    
//    public List<User> getUsers() throws Exception {
//        String query = "SELECT * FROM User;";
//        PreparedStatement stmt = getConnection().prepareStatement(query);
//        ResultSet rs = stmt.executeQuery();
//        
//        List<User> users = new ArrayList<>();
//        while (rs.next()) {
//            users.add(new User(rs.getString("username"), rs.getString("password")));
//        }
//        return users;
//    }
}
