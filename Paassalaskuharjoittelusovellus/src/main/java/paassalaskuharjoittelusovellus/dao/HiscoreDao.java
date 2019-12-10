
package paassalaskuharjoittelusovellus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import paassalaskuharjoittelusovellus.domain.User;
import paassalaskuharjoittelusovellus.logic.Game;

public class HiscoreDao {

    private String url;
    private Connection conn;

    public HiscoreDao() throws Exception {
        url = "jdbc:h2:./databases/hiscoreDB";
        conn = null;
        
        createHiscoreTable();
    }
    
    private Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, "sa", "");
        }
        return conn;
    }
    
    private void createHiscoreTable() throws Exception {
        String query = "CREATE TABLE IF NOT EXISTS Hiscore (\n"
                + "id INTEGER AUTO_INCREMENT PRIMARY KEY, \n"
                + "points INT, \n"
                + "username VARCHAR(255), \n"
                + "difficulty VARCHAR(255)\n"
                + ");";
        
        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void add(User user, Game game) throws Exception {
        
        String query = "INSERT INTO Hiscore"
                + " (points, username, difficulty)"
                + " VALUES (?, ?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setInt(1, game.getPoints());
        stmt.setString(2, user.getUserName());
        stmt.setString(3, game.getDifficulty().name());
        stmt.executeUpdate();
        stmt.close();
        System.out.println("added");
    }
}
