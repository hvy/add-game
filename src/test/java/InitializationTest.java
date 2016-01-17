import Views.AGGameView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the game setup validation.
 *
 * @author hvy
 * @version 1.0
 */
public class InitializationTest {

    private static final int NUM_GAME_MODES = 3;

    private Integer[] validGameModesSelections;
    private Integer[] invalidGameModeSelections;
    private Integer[] validXSelections;
    private Integer[] invalidXSelections;

    @Before
    public void setUp() throws Exception {
        // Prepare the input values.
        invalidGameModeSelections = new Integer[4];
        invalidGameModeSelections[0] = null;
        invalidGameModeSelections[1] = -1;
        invalidGameModeSelections[2] = 0; // Since it is 1-based.
        invalidGameModeSelections[3] = NUM_GAME_MODES + 1;
        validGameModesSelections = new Integer[NUM_GAME_MODES];
        for (int i = 0; i < NUM_GAME_MODES; i++) validGameModesSelections[i] = new Integer(i + 1);

        invalidXSelections = new Integer[3];
        invalidXSelections[0] = null;
        invalidXSelections[1] = new Integer(-1);
        invalidXSelections[2] = new Integer(-24);
        validXSelections = new Integer[10];
        for (int i = 0; i < 10; i++) validXSelections[i] = new Integer(i);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test the game mode validation.
     *
     * @throws Exception Thrown if the test fails.
     */
    @Test
    public void testGameModeSelection() throws Exception {
        AGGameView view = new AGGameView();
        for (Integer validOption : validGameModesSelections) {
            assertTrue(view.isValidGameOption(validOption, NUM_GAME_MODES));
        }
        for (Integer invalidOption : invalidGameModeSelections) {
            assertFalse(view.isValidGameOption(invalidOption, NUM_GAME_MODES));
        }
    }

    /**
     * Test the X selection validation.
     *
     * @throws Exception Thrown if the test fails.
     */
    @Test
    public void testXSelection() throws Exception {
        AGGameView view = new AGGameView();
        for (Integer validOption : validXSelections) {
            assertTrue(view.isValidX(validOption));
        }
        for (Integer invalidOption : invalidXSelections) {
            assertFalse(view.isValidX(invalidOption));
        }
    }
}
