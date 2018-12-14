package it.sevenbits.homework.grep;

import java.io.IOException;
import java.io.Reader;
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
    public List doGrep(final Reader reader) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int text;
            while ((text = (reader).read()) != -1) {
                if ((char) text != '\n') {
                    sb.append((char) text);
                }
                if ((char) text == '\n') {
                    if (sb.toString().toLowerCase().contains(searchLine.toLowerCase())) {
                        list.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }
            if (sb.toString().toLowerCase().contains(searchLine.toLowerCase())) {
                list.add(sb.toString());
            }

        reader.close();
        return list;
    }
}