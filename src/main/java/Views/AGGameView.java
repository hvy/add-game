package Views;

import Assets.AGTexts;

import java.util.List;

public class AGGameView {

    private AGCLI cli;

    public AGGameView() {
        cli = new AGCLI(System.in, System.out);
    }

    public int askForX() {
        AGGameModeOption[] options = AGGameModeOption.values();
        Integer option = cli.readInt();
        if (option == null || option > options.length) {
            // Ask for the game mode again since the last selection was invalid
            cli.write(AGTexts.INVALID_INPUT);
            cli.write("\n");
            return askForX();
        }
        AGGameModeOption selection = options[option - 1];
        if (selection == AGGameModeOption.ADD_X) {
            cli.write(AGTexts.PROMPT_X);
            Integer x;
            if ((x = cli.readInt()) != null && x >= 0) {
                selection.x = x;
            } else {
                cli.write(AGTexts.INVALID_INPUT);
                cli.write("\n");
                return askForX();
            }
        }
        return selection.x;
    }

    public List<Integer> askForGuess(int requiredLength) {
        List<Integer> guess;
        while ((guess = cli.readInts()) == null || guess.size() != requiredLength) {
            cli.write(AGTexts.INVALID_INPUT);
        }
        return guess;
    }

    public void printWelcomeText() {
        cli.write(AGTexts.WELCOME_MESSAGE + "\n");
    }

    public void printGameRules() {
        // TODO
    }

    public void printGameModeOptions() {
        AGGameModeOption[] options = AGGameModeOption.values();
        for (int i = 0; i < options.length; i++) {
            cli.write(i + 1 + ". ");
            cli.write(options[i].name);
            cli.write("\n");
        }
    }

    public void printFinishMessage(int score) {
        cli.write(AGTexts.PREFIX_TOTAL_SCORE);
        cli.write(score);
        cli.write("\n");
        cli.write(AGTexts.GAME_FINISHED_MESSAGE);
    }

    public void printScoreInfo(int score) {
        cli.write(AGTexts.PREFIX_SCORE);
        cli.write(score);
        cli.write("\n");
    }

    public void printSequence(List<Integer> sequence) {
        cli.write(AGTexts.PREFIX_SEQUENCE);
        cli.write("\n");
        for (int s: sequence) {
            cli.write(s);
        }
        cli.write("\n");
    }

    public void printCorrectSequence(List<Integer> correctSequence) {
        cli.write("Correct: ");
        for (int c : correctSequence) {
            cli.write(c);
        }
        cli.write("\n");
    }

    public void printCorrectSequenceMessage() {
        cli.write(AGTexts.CORRECT_MESSAGE);
        cli.write("\n");
    }

    public void printWrongSequenceMessage() {
        cli.write(AGTexts.WRONG_MESSAGE);
        cli.write("\n");
    }
}
