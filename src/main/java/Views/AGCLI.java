package Views;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Wrapper class for writing and reading to/from streams with minimal functionality.
 *
 * @author hvy
 * @version 1.0
 */
public class AGCLI {

    private PrintStream out;
    private BufferedReader reader;

    /**
     * Constructor.
     *
     * @param in The input stream.
     * @param out The output stream.
     */
    public AGCLI(InputStream in, PrintStream out) {
        this.out = out;
        reader = new BufferedReader(new InputStreamReader(in));
    }

    /**
     * Write an integer to the output stream.
     *
     * @param i The integer to write to the output stream.
     */
    public void write(int i) {
        out.print(i);
    }

    /**
     * Write an float to the output stream.
     *
     * @param i The float to write to the output stream.
     */
    public void write(float i) {
        out.print(i);
    }

    /**
     * Write a String to the output stream.
     *
     * @param s The String to write to the output stream.
     */
    public void write(String s) {
        out.print(s);
    }

    /**
     * Try to read an Integer from the input stream.
     *
     * @return An Integer that is read from the input stream, or null if the input cannot be parsed to an Integer.
     */
    public Integer readInt() {
        Integer lineAsInt = null;
        try {
            lineAsInt = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
        }
        return lineAsInt;
    }

    /**
     * Try to read a sequence of Integers from the input stream.
     *
     * @return A list of Integers that is read from the input stream, or null if the input cannot be parsed.
     */
    public List<Integer> readInts() {
        List<Integer> lineAsInts = new ArrayList<>();
        try {
            String line = reader.readLine();
            for (char c : line.toCharArray()) {
                lineAsInts.add(Character.getNumericValue(c));
            }
        } catch (Exception e) {
            return null;
        }
        return lineAsInts;
    }
}

