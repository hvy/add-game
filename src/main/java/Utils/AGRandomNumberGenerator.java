package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Random number generator.
 *
 * @author hvy
 * @version 1.0
 */
public class AGRandomNumberGenerator {

    private static Random rnd = new Random();

    /**
     * Create a sequence of randomly generated integers in the range [0, 9].
     *
     * @param length The length of the sequence.
     * @return The sequence of random numbers.
     */
    public static List<Integer> getRandomNumbers(int length) {
        List<Integer> randomNumbers = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            randomNumbers.add(rnd.nextInt(10));
        }
        return randomNumbers;
    }
}
