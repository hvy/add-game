package Controllers;

import Models.AGGameConfiguration;
import Models.AGGameSession;
import Utils.AGNumberSequenceChecker;
import Utils.AGRandomNumberGenerator;
import Utils.AGStopWatch;
import Views.AGGameView;

import java.util.List;

/**
 * The main class responsible for the main flow of the game.
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


    public AGGameController(AGGameConfiguration config) {
        this.config = config;
        view = new AGGameView();
        sequenceGenerator = new AGRandomNumberGenerator();
        sequenceChecker = new AGNumberSequenceChecker();
        stopWatch = new AGStopWatch();
    }

    public void startGame() {
        view.printWelcomeText();
        view.printGameRules();
        view.printGameModeOptions();

        // Ask for the x in Add-x. Any value >= 0 is allowed.
        int x = view.askForX();
        currentSession = new AGGameSession(x);

        // Start the main loop
        while (!currentSession.isFinished()) {
            playRound();
        }

        // Print the game quit message and exit the game
        view.printFinishMessage(currentSession.getScore());
    }

    private void playRound() {
        List<Integer> sequence = sequenceGenerator.getRandomNumbers(config.getSequenceLength());
        view.printScoreInfo(currentSession.getScore());
        view.printSequence(sequence);
        List<Integer> playerGuessSequence = view.askForGuess(config.getSequenceLength());
        List<Integer> correctSequence = sequenceChecker.createModifiedList(sequence, currentSession.getX());
        view.printCorrectSequence(correctSequence);
        if (sequenceChecker.areEqual(correctSequence, playerGuessSequence)) {
            view.printCorrectSequenceMessage();
            currentSession.addScore(config.getSequenceLength());
        } else {
            view.printWrongSequenceMessage();
            currentSession.finish();
        }
    }
}
