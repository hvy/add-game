import Controllers.AGGameController;
import Models.AGGameConfiguration;

public class Main {
    public static void main(String args[]) {
        Configuration configFile = new Configuration();
        AGGameConfiguration config = new AGGameConfiguration(configFile.getSequenceLength(), configFile.getThinkingTimeSec());
        AGGameController game = new AGGameController(config);
        game.startGame();
    }
}
