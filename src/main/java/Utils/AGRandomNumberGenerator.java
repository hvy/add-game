package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AGRandomNumberGenerator {

    private Random rnd = new Random();

    public AGRandomNumberGenerator() {
        // Empty constructor
    }

    public List<Integer> getRandomNumbers(int length) {
        List<Integer> randomNumbers = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            randomNumbers.add(rnd.nextInt(10));
        }
        return randomNumbers;
    }
}
