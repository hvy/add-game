package Assets;

/**
 * Container class, containing all of the CLI texts used by the game.
 *
 * @author hvy
 * @version 1.0
 */
public class AGTexts {
    // General
    public static final String WELCOME_MESSAGE =
            "Welcome to the AddGame inspired by the game from the book Thinking, Fast and Slow by Daniel Kahneman.";
    public static final String GAME_RULES =
            "Rules: In the beginning of each round, a sequence of numbers is displayed. To proceed to the next round " +
                    "you need to add the x value to each number in the sequence and write the new sequence before the time " +
                    "runs out. You need to do it quickly! If x is 1, 9 becomes 0 and if x is 3, 8 becomes 1. The game finishes " +
                    "when you enter the wrong sequence or if you enter the correct sequence but is too slow. The score increases " +
                    "as you successfully answer the rounds. The goal is to stay focused and reach a high score!";
    public static final String GAME_MODE_OPTIONS_EXPLANATION = "Select one of the following x values (write the number and press Enter): ";
    public static final String CORRECT_MESSAGE = "Correct answer!";
    public static final String WRONG_MESSAGE = "Wrong answer";
    public static final String GAME_FINISHED_MESSAGE = "Thanks for playing!";
    public static final String TIMEOUT_MESSSAGE = "Too slow!";

    // User prompts
    public static final String PROMPT_X = "x : ";

    // Prefixes
    public static final String PREFIX_SCORE = "Score: ";
    public static final String PREFIX_TOTAL_SCORE = "Total Score: ";
    public static final String PREFIX_X = "Starting game with x: ";
    public static final String PREFIX_SEQUENCE = "Sequence: ";
    public static final String PREFIX_THINKING_TIME = "Time: ";

    // Error messages
    public static final String INVALID_INPUT = "Invalid input";
}

