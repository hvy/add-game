package Models;

/**
 * A class that keep track of the game state and the user score.
 *
 * @author hvy
 * @version 1.0
 */
public class AGGameSession {

    private final int x;
    private int score;
    private boolean isFinished;

    /**
     * Constructor.
     *
     * @param x The x in Add-x.
     */
    public AGGameSession(int x) {
        this.x = x % 10;
        this.score = 0;
        this.isFinished = false;
    }

    /**
     * @return The x value in Add-x.
     */
    public int getX() {
        return x;
    }

    /**
     * @return True if the game is finished, false otherwise.
     */
    public boolean isFinished() {
        return isFinished;
    }

    /**
     * @return The current user score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Add the given score to the current user score.
     *
     * @param scoreToAdd The score to add to the user score.
     */
    public void addScore(int scoreToAdd) {
        score += scoreToAdd;
    }

    /**
     * Updates the state of this game session to finished.
     */
    public void finish() {
        isFinished = true;
    }
}

