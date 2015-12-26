package Utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AGNumberSequenceChecker {

    public AGNumberSequenceChecker() {
    }

    public List<Integer> createModifiedList(List<Integer> baseList, int x) {
        return baseList.stream().map(b -> (b + x) % 10).collect(Collectors.toList());
    }

    public boolean areEqual(List<Integer> fstList, List<Integer> sndList) {
        if (fstList.size() != sndList.size()) {
            return false;
        }
        return IntStream.range(0, fstList.size()).allMatch(i -> fstList.get(i).equals(sndList.get(i)));
    }
}
