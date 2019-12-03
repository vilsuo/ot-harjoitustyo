
package paassalaskuharjoittelusovellus.dao;

import java.sql.SQLException;
import java.util.List;
import paassalaskuharjoittelusovellus.logic.Difficulty;
import paassalaskuharjoittelusovellus.logic.Game;

public class HiscoreDao {

    public void create(Game game) throws SQLException {
        int points = game.getPoints();
        Difficulty difficulty = game.getDifficulty();
        
    }

//    public List<Integer> list() throws SQLException {
//        
//    }
    
}
