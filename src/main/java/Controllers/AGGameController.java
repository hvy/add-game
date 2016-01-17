package Controllers;

import Exceptions.AGInvalidArgumentException;
import Models.AGGameConfiguration;
import Models.AGGameSession;
import Models.AGGameState;
import Utils.AGNumberSequenceChecker;
import Utils.AGRandomNumberGenerator;
import Utils.AGStopWatch;
import Views.AGGameView;

import java.util.List;

/**
 * The class responsible for the main flow of the game.
 *
 * @author hvy
 * @version 1.0
 */
public class AGGameController {

    private AGGameView view;
    private AGGameSession currentSession;
    private AGGameConfiguration config;
    private AGStopWatch stopWatch;

    private List<Integer> playerGuessSequence = null;
    private List<Integer> correctSequence = null;
    private float thinkingTime = 0;

    /**
     * Constructor method.
     *
     * @param config The game configuration.
     */
    public AGGameController(AGGameConfiguration config) {
        this.config = config;
        view = new AGGameView();
        stopWatch = new AGStopWatch();
    }

    /**
     * Start the main game loop (game rounds).
     */
    public void startGame() {
        view.printWelcomeText();
        view.printGameRules();
        view.printGameModeOptions();

        // Ask the player for the x in Add-x. Any value >= 0 is allowed.
        int x = view.askForX();
        try {
            initSession(x);
        } catch (AGInvalidArgumentException e) {
        }

        // Start the main loop.
        while (!currentSession.isFinished()) {
            playRound();
        }

        // Print the game quit message and exit the game.
        view.printFinishMessage(getCurrentScore());

        // Exit the game.
    }

    /**
     * Initialize the session with the given X. This method should be called once before starting the main game loop.
     *
     * @param x The X value to use throughout the game.
     * @throws AGInvalidArgumentException The exception that is thrown when the x is invalid.
     */
    public void initSession(int x) throws AGInvalidArgumentException {
        currentSession = new AGGameSession(x);
    }

    /**
     * End the current session. This method should be called to exit the game.
     *
     * @param reason The reason why the game session is ended, e.g. a time out or a wrong answer.
     */
    public void endSession(AGGameState reason) {
        currentSession.setState(reason);
    }

    /**
     * @return True if the session is still alive, false otherwise.
     */
    public boolean isSessionFinished() {
        return currentSession.isFinished();
    }

    /**
     * @return True if the session is finished due to a timed out.
     */
    public boolean isTimedOut() {
        return currentSession.getState() == AGGameState.TIMED_OUT;
    }

    /**
     * Returns true if the given time is acceptable with respect to the given time limit.
     *
     * @param timeLimit The time limit, i.e. the maximum allowed time.
     * @param time The time that is tested for acceptance.
     * @return True if the time is acceptable, false otherwise.
     */
    private boolean isWithinTimeLimit(float timeLimit, float time) {
        return time <= timeLimit;
    }

    /**
     * @return The current player session score.
     */
    public int getCurrentScore() {
        return currentSession.getScore();
    }

    /**
     * Add the given score to the current player session.
     *
     * @param score The amount to add to the score.
     */
    private void addScore(int score) {
        currentSession.addScore(score);
    }

    /**
     * The
     * @param correctSequence
     * @param playerGuessSequence
     * @param thinkingTimeLimit
     * @param thinkingTime
     */
    public void handleRoundEnd(List<Integer> correctSequence, List<Integer> playerGuessSequence, float thinkingTimeLimit, float thinkingTime) {
       if (AGNumberSequenceChecker.areEqual(correctSequence, playerGuessSequence)) {
            if (isWithinTimeLimit(thinkingTimeLimit, thinkingTime)) {
                // Correct answer, continue to the next round.
                view.printCorrectSequenceMessage();
                // Add to the user score the length of the sequence for a correct input.
                addScore(correctSequence.size());
            } else {
                view.printTimeOutMessage();
                endSession(AGGameState.TIMED_OUT);
            }
       } else {
            view.printWrongSequenceMessage();
            view.printCorrectSequence(correctSequence);
            endSession(AGGameState.WRONG_ANSWER);
        }
    }

    /**
     * Game logic for one game round.
     */
    private void playRound() {
        view.printScoreInfo(getCurrentScore());
        List<Integer> sequence = AGRandomNumberGenerator.getRandomNumbers(config.getSequenceLength());
        view.printSequence(sequence);

        // Start the timer to measure player thinking time, if it is too slow, the game session should be finished.
        stopWatch.start();
        playerGuessSequence = view.askForGuess(config.getSequenceLength());

        // Stop the timer to get the measurement.
        thinkingTime = stopWatch.stop();
        view.printThinkingTime(thinkingTime);
        correctSequence = AGNumberSequenceChecker.createModifiedList(sequence, currentSession.getX());
        handleRoundEnd(correctSequence, playerGuessSequence, config.getThinkingTimeMs(), thinkingTime);
    }
}
