
package paassalaskuharjoittelusovellus.logic;

/**
 * A game difficulty.
 * 
 */
public enum Difficulty {
    EASY(1, 5),
    MEDIUM(5, 10),
    HARD(10, 20);
    
    final int pointsPerCorrectAnswer;
    final int timePerAnswer;

    private Difficulty(int pointsPerCorrectAnswer, int timePerAnswer) {
        this.pointsPerCorrectAnswer = pointsPerCorrectAnswer;
        this.timePerAnswer = timePerAnswer;
    }

    /**
     *
     * @return the points for one correct answer
     */
    public int getPointsPerCorrectAnswer() {
        return pointsPerCorrectAnswer;
    }

    /**
     *
     * @return the time limit for one answer
     */
    public int getTimePerAnswer() {
        return timePerAnswer;
    }
    
}
