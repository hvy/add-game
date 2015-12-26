package Utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class is responsible for the add logic in the game. It takes care of adding the x values to the sequence
 * elements mod 10.
 *
 * @author hvy
 * @version 1.0
 */
public class AGNumberSequenceChecker {

    /**
     * Default constructor.
     */
    public AGNumberSequenceChecker() {
    }

    /**
     * Create a new sequence from a given sequence the x added to each element mod 10.
     *
     * @param baseList The base sequence.
     * @param x The value that is added to each element in the sequence mod 10.
     * @return A new sequence with x added to each element in the given list mod 10.
     */
    public List<Integer> createModifiedList(List<Integer> baseList, int x) {
        return baseList.stream().map(b -> (b + x) % 10).collect(Collectors.toList());
    }

    /**
     * Check if two sequences are identical (element pairwise).
     *
     * @param fstList The first sequence.
     * @param sndList The second sequence.
     * @return True if the first and the second sequence contain the same elements in the same order, false otherwise.
     */
    public boolean areEqual(List<Integer> fstList, List<Integer> sndList) {
        if (fstList.size() != sndList.size()) {
            return false;
        }
        return IntStream.range(0, fstList.size()).allMatch(i -> fstList.get(i).equals(sndList.get(i)));
    }
}
