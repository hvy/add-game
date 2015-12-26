import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The game configuration that is set according to the properties file located in the resource directory.
 *
 * @author hvy
 * @version 1.0
 */
public final class Configuration {

    private int sequenceLength;
    private int thinkingTimeSec;

    /**
     * Default constructor that automatically loads the configuration file.
     */
    public Configuration() {
        loadFile();
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

    /**
     * Load the file from the configuration file and sets the class properties accordingly.
     */
    private void loadFile() {
        InputStream in = null;
        try {
            in = this.getClass().getClassLoader().getResourceAsStream("configuration.properties");
            Properties properties = new Properties();
            properties.load(in);
            sequenceLength = Integer.parseInt(properties.getProperty("sequencelength"));
            thinkingTimeSec = Integer.parseInt(properties.getProperty("thinkingtimesec"));
        } catch (Exception e) {
            e.printStackTrace();
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

