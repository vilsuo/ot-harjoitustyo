
package paassalaskuharjoittelusovellus.logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HiscoreObject {
    private final SimpleStringProperty rank;
    private final SimpleStringProperty username;
    private final SimpleStringProperty points;
    private final SimpleStringProperty difficulty;

    public HiscoreObject(int rank, String username, int points, String difficulty) {
        this.rank = new SimpleStringProperty(Integer.toString(rank));
        this.username = new SimpleStringProperty(username);
        this.points = new SimpleStringProperty(Integer.toString(points));
        this.difficulty = new SimpleStringProperty(difficulty);
    }
    
    public String getRank() {
        return rank.get();
    }
    
    public String getUsername() {
        return username.get();
    }

    public String getPoints() {
        return points.get();
    }

    public String getDifficulty() {
        return difficulty.get();
    }
    
    public void setRank(String newVal) {
        rank.set(newVal);
    }
    
    public void setUsername(String newVal) {
        username.set(newVal);
    }
    
    public void setPoints(String newVal) {
        points.set(newVal);
    }
    
    public void setDifficulty(String newVal) {
        difficulty.set(newVal);
    }

    public StringProperty rankProperty() {
        return rank;
    }
    
    public StringProperty usernameProperty() {
        return username;
    }
    
    public StringProperty pointsProperty() {
        return points;
    }
    
    public StringProperty difficultyProperty() {
        return difficulty;
    }
}
