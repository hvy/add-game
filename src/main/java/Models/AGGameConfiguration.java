package Models;

/**
 * The game configuration.
 *
 * @author hvy
 * @version 1.0
 */
public class AGGameConfiguration {

    private final int sequenceLength;
    private final int thinkingTimeSec;

    /**
     * Constructor.
     *
     * @param sequenceLength The sequence length.
     * @param thinkingTimeSec The thinking time in seconds.
     */
    public AGGameConfiguration(int sequenceLength, int thinkingTimeSec) {
        this.sequenceLength = sequenceLength;
        this.thinkingTimeSec = thinkingTimeSec;
    }

    /**
     * @return The configuration sequence length.
     */
    public int getSequenceLength() {
        return sequenceLength;
    }

    /**
     * @return The configuration thinking time in seconds.
     */
    public int getThinkingTimeSec() {
        return thinkingTimeSec;
    }
}

