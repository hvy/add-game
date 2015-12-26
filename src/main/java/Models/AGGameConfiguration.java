package Models;

public class AGGameConfiguration {

    private final int sequenceLength;
    private final int thinkingTimeSec;

    public AGGameConfiguration(int sequenceLength, int thinkingTimeSec) {
        this.sequenceLength = sequenceLength;
        this.thinkingTimeSec = thinkingTimeSec;
    }

    public int getThinkingTimeSec() {
        return thinkingTimeSec;
    }

    public int getSequenceLength() {
        return sequenceLength;
    }
}
