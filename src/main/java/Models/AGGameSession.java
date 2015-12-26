package Models;

public class AGGameSession {

    private final int x;
    private int score;
    private boolean isFinished;

    public AGGameSession(int x) {
        this.x = x % 10;
        this.score = 0;
        this.isFinished = false;
    }

    public int getX() {
        return x;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int scoreToAdd) {
        score += scoreToAdd;
    }

    public void finish() {
        isFinished = true;
    }
}
