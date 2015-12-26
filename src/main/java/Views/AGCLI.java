package Views;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class AGCLI {

    private PrintStream out;
    private BufferedReader reader;

    public AGCLI(InputStream in, PrintStream out) {
        this.out = out;
        reader = new BufferedReader(new InputStreamReader(in));
    }

    public void write(int i) {
        out.print(i);
    }

    public void write(String s) {
        out.print(s);
    }

    public Integer readInt() {
        Integer lineAsInt = null;
        try {
            lineAsInt = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
        }
        return lineAsInt;
    }

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

