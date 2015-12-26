package Controllers;

import Models.AGGameConfiguration;
import Models.AGGameSession;
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
    private AGRandomNumberGenerator sequenceGenerator;
    private AGNumberSequenceChecker sequenceChecker;
    private AGStopWatch stopWatch;

    /**
     * Constructor method.
     *
     * @param config The game configuration.
     */
    public AGGameController(AGGameConfiguration config) {
        this.config = config;
        view = new AGGameView();
        sequenceGenerator = new AGRandomNumberGenerator();
        sequenceChecker = new AGNumberSequenceChecker();
        stopWatch = new AGStopWatch();
    }

    /**
     * Starts the main game loop (game rounds).
     */
    public void startGame() {
        view.printWelcomeText();
        view.printGameRules();
        view.printGameModeOptions();

        // Ask the player for the x in Add-x. Any value >= 0 is allowed.
        int x = view.askForX();
        currentSession = new AGGameSession(x);

        // Start the main loop
        while (!currentSession.isFinished()) {
            playRound();
        }

        // Print the game quit message and exit the game
        view.printFinishMessage(currentSession.getScore());
    }

    /**
     * Game logic for one game round.
     */
    private void playRound() {
        stopWatch.start();
        view.printScoreInfo(currentSession.getScore());
        List<Integer> sequence = sequenceGenerator.getRandomNumbers(config.getSequenceLength());
        view.printSequence(sequence);
        List<Integer> playerGuessSequence = view.askForGuess(config.getSequenceLength());
        List<Integer> correctSequence = sequenceChecker.createModifiedList(sequence, currentSession.getX());
        float thinkingTimeSec = stopWatch.stop();
        if (sequenceChecker.areEqual(correctSequence, playerGuessSequence)) {
            if (thinkingTimeSec < config.getThinkingTimeSec()) {
                // Correct answer, continue to the next round.
                view.printCorrectSequenceMessage();
                currentSession.addScore(config.getSequenceLength());
            } else {
                // Correct answer but too slow, finish the game.
                view.printTimeOutMessage();
                currentSession.finish();
            }
       } else {
            // Wrong answer, finish the game.
            view.printWrongSequenceMessage();
            view.printCorrectSequence(correctSequence);
            currentSession.finish();
        }
    }
}
