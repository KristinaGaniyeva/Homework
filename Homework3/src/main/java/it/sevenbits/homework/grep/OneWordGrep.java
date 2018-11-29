package it.sevenbits.homework.grep;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class OneWordGrep
 */
public class OneWordGrep implements IGrep {
    private String searchLine;

    /**
     * OneWordGrep constructor
     *
     * @param searchLine The string to find
     */
    public OneWordGrep(final String searchLine) {
        this.searchLine = searchLine;
    }

    /**
     * The method takes as input Reader, and returns those lines that contain the word
     *
     * @param reader Reader
     * @return list
     * @throws IOException exception
     */
    public List doGrep(Reader reader) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String strLine;
        File file = new File("./src/main/resources/notes.txt");
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((strLine = ((BufferedReader) reader).readLine()) != null) {
            if (strLine.contains(searchLine)) {
                list.add(strLine);
            }
        }
        return list;
    }
}