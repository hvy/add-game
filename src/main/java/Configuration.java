import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The game configuration that is set according to the properties file located in the resource directory.
 */
public final class Configuration {

    private int sequenceLength;
    private int thinkingTimeSec;

    public Configuration() {
        loadFile();
    }

    public int getSequenceLength() {
        return sequenceLength;
    }

    public int getThinkingTimeSec() {
        return thinkingTimeSec;
    }

    private void loadFile() {
        InputStream in = null;
        try {
            in = this.getClass().getClassLoader().getResourceAsStream("configuration.properties");
            Properties properties = new Properties();
            properties.load(in);
            sequenceLength = Integer.parseInt(properties.getProperty("sequencelength"));
            thinkingTimeSec = Integer.parseInt(properties.getProperty("thinkingtimesec"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
