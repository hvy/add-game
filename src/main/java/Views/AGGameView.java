package Views;

import Assets.AGTexts;

import java.util.List;

/**
 * The view class that takes care of writing and reading text to and from the user. It is also responsible for user
 * input validation meaning that any data read from the view is guaranteed to be valid.
 *
 * @author hvy
 * @version 1.0
 */
public class AGGameView {

    private AGCLI cli;

    /**
     * Default constructor.
     */
    public AGGameView() {
        cli = new AGCLI(System.in, System.out);
    }

    /**
     * Prompt the user for a x value and returns the x.
     *
     * @return The x value chosen by the user.
     */
    public int askForX() {
        // Get all available game modes.
        AGGameModeOption[] options = AGGameModeOption.values();
        Integer option = cli.readInt();
        if (!isValidGameOption(option, options.length)) {
            // Ask for the game mode again since the last selection was invalid.
            cli.write(AGTexts.INVALID_INPUT);
            cli.write("\n");
            return askForX();
        }
        // Subtract 1 from the user options since it is 1-based.
        AGGameModeOption selection = options[option - 1];
        if (selection == AGGameModeOption.ADD_X) {
            cli.write(AGTexts.PROMPT_X);
            Integer x = cli.readInt();
            if (isValidX(x)) {
                selection.x = x;
            } else {
                cli.write(AGTexts.INVALID_INPUT);
                cli.write("\n");
                return askForX();
            }
        }
        return selection.x;
    }

    /**
     * Prompt the user for an integer sequence and returns the sequence.
     *
     * @param requiredLength The length of the sequence.
     * @return The sequence that is chosen by the user with the length of the given length.
     */
    public List<Integer> askForGuess(int requiredLength) {
        List<Integer> guess;
        while ((guess = cli.readInts()) == null || guess.size() != requiredLength) {
            cli.write(AGTexts.INVALID_INPUT);
        }
        return guess;
    }

    /**
     * Validate the given game mode input option.
     *
     * @param option The game mode option.
     * @param numOptions The number of game modes.
     * @return True if the game mode options is leq numOptions, false otherwise.
     */
    public boolean isValidGameOption(Integer option, int numOptions) {
        return option != null && option > 0 && option <= numOptions;
    }

    /**
     * Validate the given X value.
     *
     * @param x The x value.
     * @return True if x is not null and geq 0.
     */
    public boolean isValidX(Integer x) {
        return x != null && x >= 0;
    }

    /**
     * Print the welcome message to the view.
     */
    public void printWelcomeText() {
        cli.write(AGTexts.WELCOME_MESSAGE + "\n");
    }

    /**
     * Print the game rules to the view.
     */
    public void printGameRules() {
        cli.write(AGTexts.GAME_RULES);
        cli.write("\n");
    }

    /**
     * Print the game mode options to the view.
     */
    public void printGameModeOptions() {
        cli.write(AGTexts.GAME_MODE_OPTIONS_EXPLANATION);
        cli.write("\n");
        AGGameModeOption[] options = AGGameModeOption.values();
        for (int i = 0; i < options.length; i++) {
            cli.write(i + 1 + ". ");
            cli.write(options[i].name);
            cli.write("\n");
        }
    }

    /**
     * Print the score to the view.
     *
     * @param score The score that should be printed.
     */
    public void printScoreInfo(int score) {
        cli.write(AGTexts.PREFIX_SCORE);
        cli.write(score);
        cli.write("\n");
    }

    /**
     * Print the given sequence to the view.
     *
     * @param sequence The sequence that should be printed.
     */
    public void printSequence(List<Integer> sequence) {
        cli.write(AGTexts.PREFIX_SEQUENCE);
        cli.write("\n");
        for (int s: sequence) {
            cli.write(s);
        }
        cli.write("\n");
    }

    /**
     * Print the given correct sequence to the view.
     *
     * @param correctSequence The correct sequence that should be printed.
     */
    public void printCorrectSequence(List<Integer> correctSequence) {
        cli.write("Correct: ");
        for (int c : correctSequence) {
            cli.write(c);
        }
        cli.write("\n");
    }

    /**
     * Print the correct sequence message. Should be called when the user has entered the correct sequence.
     */
    public void printCorrectSequenceMessage() {
        cli.write(AGTexts.CORRECT_MESSAGE);
        cli.write("\n");
    }

    /**
     * Print the wrong sequence message. Should be called when the user has entered the wrong sequence.
     */
    public void printWrongSequenceMessage() {
        cli.write(AGTexts.WRONG_MESSAGE);
        cli.write("\n");
    }

    /**
     * Print the game finished message to the view along with the given score.
     *
     * @param score The score that should be printed along with the message.
     */
    public void printFinishMessage(int score) {
        cli.write(AGTexts.PREFIX_TOTAL_SCORE);
        cli.write(score);
        cli.write("\n");
        cli.write(AGTexts.GAME_FINISHED_MESSAGE);
        cli.write("\n");
    }

    /**
     * Print the time out message to the view. Should be called when the user has entered the correct value but when
     * the time has ran out.
     */
    public void printTimeOutMessage() {
        cli.write(AGTexts.TIMEOUT_MESSSAGE);
        cli.write("\n");
    }
}

