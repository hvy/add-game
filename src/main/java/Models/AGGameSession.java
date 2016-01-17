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
    private AGGameState state;

    /**
     * Constructor.
     *
     * @param x The x in Add-x.
     */
    public AGGameSession(int x) {
        this.x = x % 10;
        this.score = 0;
        this.state = AGGameState.ACTIVE;
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
        return state != AGGameState.ACTIVE;
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
     * @return The current state of this session.
     */
    public AGGameState getState() {
        return state;
    }

    /**
     * Updates the state of this game session to the given state.
     *
     * @param state The reason why the game ended.
     */
    public void setState(AGGameState state) {
        this.state = state;
    }
}

