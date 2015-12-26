package Views;

/**
 * Enum for the available game modes that define the x value in the game. Add-1 and Add-3 sets the x to 1 and 3
 * respectively. The Add-x options should trigger a prompt to the user for an arbitrary x value (>=0).
 *
 * @author hvy
 * @version 1.0
 */
public enum AGGameModeOption {
    ADD_1("Add-1", 1),
    ADD_3("Add-3", 3),
    ADD_X("Add-X");

    String name;
    int x = 0;

    /**
     * Constructor.
     *
     * @param name The name of the game mode.
     */
    AGGameModeOption(String name) {
       this.name = name;
    }

    /**
     * Constructor.
     *
     * @param name The name of the game mode.
     * @param x The x value for the game mode.
     */
    AGGameModeOption(String name, int x) {
        this.name = name;
        this.x = x;
    }
}

