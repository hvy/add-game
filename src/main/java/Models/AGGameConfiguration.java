package Models;

/**
 * The game configuration.
 *
 * @author hvy
 * @version 1.0
 */
public class AGGameConfiguration {

    private final int sequenceLength;
    private final float thinkingTimeMs;

    /**
     * Constructor.
     *
     * @param sequenceLength The sequence length.
     * @param thinkingTimeMs The thinking time in ms.
     */
    public AGGameConfiguration(int sequenceLength, float thinkingTimeMs) {
        this.sequenceLength = sequenceLength;
        this.thinkingTimeMs = thinkingTimeMs;
    }

    /**
     * @return The configuration sequence length.
     */
    public int getSequenceLength() {
        return sequenceLength;
    }

    /**
     * @return The configuration thinking time in ms.
     */
    public float getThinkingTimeMs() {
        return thinkingTimeMs;
    }
}

