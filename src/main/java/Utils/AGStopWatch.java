package Utils;

/**
 * A stop watch that measures time.
 *
 * @author hvy
 * @version 1.0
 */
public class AGStopWatch {

    private long startTimeMillis = 0;

    /**
     * Constructor.
     */
    public AGStopWatch() {
    }

    /**
     * Resets and starts the stop watch.
     */
    public void start() {
        startTimeMillis = System.currentTimeMillis();
    }

    /**
     * Stops the stop watch and returns the time interval since the last start in seconds.
     *
     * @return The time interval in seconds since the last start.
     */
    public float stop() {
        return (float) ((System.currentTimeMillis() - startTimeMillis) / 1000.0);
    }
}
