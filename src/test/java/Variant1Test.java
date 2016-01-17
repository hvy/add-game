import Controllers.AGGameController;
import Models.AGGameConfiguration;

import static org.junit.Assert.*;

import Utils.AGNumberSequenceChecker;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for basic game logic.
 *
 * @author hvy
 * @version 1.0
 */
public class Variant1Test {

    private AGGameController game;

    private static final float THINKING_TIME_LIMIT_MS = 5000;
    private static final int SEQUENCE_LENGTH = 4;
    private static final int X = 3;

    private static List<Integer> sequence; // Initial question.
    private static List<Integer> correctSequence; // The correct answer given the initial sequence and the X.
    private static List<Integer> differByZeroGuessSequences; // The correct answer.
    private static List<Integer> differByOneGuessSequence; // Wrong answer example.

    @BeforeClass
    public static void setUpTests() throws Exception {
        sequence = Arrays.asList(1, 2, 3, 4);
        correctSequence = AGNumberSequenceChecker.createModifiedList(sequence, X);
        differByZeroGuessSequences = Arrays.asList(4, 5, 6, 7);
        differByOneGuessSequence = Arrays.asList(4, 5, 6, 8);
    }

    @Before
    public void setUpTest() throws Exception {
        AGGameConfiguration config = new AGGameConfiguration(SEQUENCE_LENGTH, THINKING_TIME_LIMIT_MS);
        game = new AGGameController(config);
        game.initSession(X);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCase1() throws Exception {
        game.handleRoundEnd(correctSequence, differByZeroGuessSequences, THINKING_TIME_LIMIT_MS, 0);
        assertEquals(game.getCurrentScore(), SEQUENCE_LENGTH);
        assertFalse(game.isTimedOut());
    }

    @Test
    public void testCase2() throws Exception {
        // N/A
    }

    @Test
    public void testCase3() throws Exception {
        game.handleRoundEnd(correctSequence, differByZeroGuessSequences, THINKING_TIME_LIMIT_MS, THINKING_TIME_LIMIT_MS);
        assertEquals(game.getCurrentScore(), SEQUENCE_LENGTH);
        assertFalse(game.isTimedOut());
    }

    @Test
    public void testCase4() throws Exception {
        game.handleRoundEnd(correctSequence, differByZeroGuessSequences, THINKING_TIME_LIMIT_MS, THINKING_TIME_LIMIT_MS + 1);
        assertEquals(game.getCurrentScore(), 0);
        assertTrue(game.isTimedOut());
    }

    @Test
    public void testCase5() throws Exception {
        // Duplicate of test case 3
    }

    @Test
    public void testCase6() throws Exception {
        // Duplicate of test case 3
    }

    @Test
    public void testCase7() throws Exception {
        game.handleRoundEnd(correctSequence, differByOneGuessSequence, THINKING_TIME_LIMIT_MS, THINKING_TIME_LIMIT_MS);
        assertEquals(game.getCurrentScore(), 0);
        assertFalse(game.isTimedOut());
    }

    @Test
    public void testCase8() throws Exception {
       // N/A
    }

    @Test
    public void testCase9() throws Exception {
        // Duplicate of test case 3
    }
}

