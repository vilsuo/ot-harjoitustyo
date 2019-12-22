
package paassalaskuharjoittelusovellus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import paassalaskuharjoittelusovellus.domain.User;
import paassalaskuharjoittelusovellus.logic.Game;
import paassalaskuharjoittelusovellus.logic.HiscoreObject;

/**
 * Class for handling Hiscore database transactions.
 * 
 */
public class HiscoreDao {

    private String url;
    private Connection conn;

    public HiscoreDao() throws Exception {
        url = "jdbc:h2:./databases/hiscoreDB";
        conn = null;
        
        createHiscoreTable();
    }
    
    /**
     * Used for testing this class.
     *
     * @param url the URL of the test database
     * @throws Exception
     */
    public HiscoreDao(String url) throws Exception {
        this.url = url;
        conn = null;
        
        createHiscoreTable();
    }
    
    public Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, "sa", "");
        }
        return conn;
    }
    
    /**
     * Method creates Hiscore table. If the table already exists, nothing happens.
     * 
     * @throws Exception 
     */
    private void createHiscoreTable() throws Exception {
        String query = "CREATE TABLE IF NOT EXISTS Hiscore (\n"
                + "points INT, \n"
                + "username VARCHAR(255), \n"
                + "difficulty VARCHAR(255)"
                + ");";
        
        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(query);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * 
     * Adds a new entry in the Hiscore table.
     * 
     * @param user username from this User
     * @param game points and difficulty from this Game
     * 
     * @throws Exception 
     */
    public void add(User user, Game game) throws Exception {
        
        String query = "INSERT INTO Hiscore"
                + " (points, username, difficulty)"
                + " VALUES (?, ?, ?);";
        
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setInt(1, game.getPoints());
        stmt.setString(2, user.getUserName());
        stmt.setString(3, game.getDifficulty().name());
        stmt.executeUpdate();
        stmt.close();
    }
    
    /**
     * 
     * @return ObservableList of HiscoreObjects sorted by points descending. 
     * Each HiscoreObject has a rank corresponding to its points.
     * 
     * @throws Exception 
     */
    public ObservableList<HiscoreObject> getHiscoreObjectsSortedByPoints() throws Exception {
        ObservableList<HiscoreObject> list = FXCollections.observableArrayList();
        
        String query = "SELECT * FROM Hiscore ORDER BY points DESC;";
        PreparedStatement stmt = getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        int rank = 1;
        int pointsPrevius = -1;
        
        while (rs.next()) {
            int points = rs.getInt("points");
            String username = rs.getString("username");
            String difficulty = rs.getString("difficulty");
            
            if (points < pointsPrevius) {
                rank++;
            }
            pointsPrevius = points;
            
            list.add(new HiscoreObject(rank, username, points, difficulty));
        }
        rs.close();
        stmt.close();
        
        return list;
    }
}
