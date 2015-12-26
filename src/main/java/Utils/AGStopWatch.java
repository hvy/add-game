package Utils;

public class AGStopWatch {

    private long startTimeMillis;

    public AGStopWatch() {
    }

    public void start() {
        startTimeMillis = System.currentTimeMillis();
    }

    public long stop() {
        return System.currentTimeMillis() - startTimeMillis;
    }
}
