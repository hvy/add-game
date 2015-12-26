import Controllers.AGGameController;
import Models.AGGameConfiguration;

public class Main {
    public static void main(String args[]) {
        AGGameConfiguration config = new AGGameConfiguration(Const.SEQUENCE_LENGTH, Const.THINKING_TIME_SEC);
        AGGameController game = new AGGameController(config);
        game.startGame();
    }
}
