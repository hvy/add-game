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
    private float thinkingTimeMs;

    /**
     * Custom constructor that takes the configuration properties file path as argument.
     *
     * @param fileName The path to the configuration file.
     * @return An instance of this class configures with the given file.
     */
    public static Configuration newFromFile(String fileName) {
        Configuration config = new Configuration();
        config.loadFile(fileName);
        return config;
    }

    /**
     * Default private constructor that creates an empty configuration instance.
     */
    private Configuration() {
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

    /**
     * Load the file from the configuration file and sets the class properties accordingly.
     */
    private void loadFile(String fileName) {
        InputStream in = null;
        try {
            in = this.getClass().getClassLoader().getResourceAsStream(fileName);
            Properties properties = new Properties();
            properties.load(in);
            sequenceLength = Integer.parseInt(properties.getProperty("sequencelength"));
            thinkingTimeMs = Float.parseFloat(properties.getProperty("thinkingtimems"));
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

