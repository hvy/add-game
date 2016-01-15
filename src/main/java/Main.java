import Controllers.AGGameController;
import Models.AGGameConfiguration;

/**
 * The class that initializes the game.
 *
 * @author hvy
 * @version 1.0
 */
public class Main {
    public static void main(String args[]) {
        // Load the game configurations file
        Configuration configFile = new Configuration();

        // Create the game configuration based on the configurations file
        AGGameConfiguration config = new AGGameConfiguration(configFile.getSequenceLength(), configFile.getThinkingTimeMs());

        // Initialize the game. The game instance is responsible for exiting the game.
        AGGameController game = new AGGameController(config);
        game.startGame();
    }
}
