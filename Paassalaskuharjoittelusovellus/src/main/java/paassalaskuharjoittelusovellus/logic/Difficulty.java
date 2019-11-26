
package paassalaskuharjoittelusovellus.logic;

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

    public int getPointsPerCorrectAnswer() {
        return pointsPerCorrectAnswer;
    }

    public int getTimePerAnswer() {
        return timePerAnswer;
    }
    
}
