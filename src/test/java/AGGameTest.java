import Controllers.AGGameController;
import Models.AGGameConfiguration;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for basic game logic.
 *
 * @author hvy
 * @version 1.0
 */
public class AGGameTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testStartGame() throws Exception {
        AGGameConfiguration config = new AGGameConfiguration(4, 5000);

        // Initialize the game. The game instance is responsible for exiting the game.
        AGGameController game = new AGGameController(config);
        List<Integer> correctSequence = Arrays.asList(1, 2, 3, 4);
        List<Integer> playerGuessSequence = Arrays.asList(1, 2, 3, 4);

        game.initSession(0);
        System.out.println(game.getCurrentScore());
        game.handleRoundEnd(correctSequence, playerGuessSequence, 5000, 4999);
        assertEquals(4, game.getCurrentScore());
        assertFalse(game.isSessionFinished());
    }
}