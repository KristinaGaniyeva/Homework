package it.sevenbits.homework.grep;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class OrGrep
 */
public class OrGrep implements IGrep {
    private List<String> searchLine;

    /**
     * Class constructor
     *
     * @param searchLine string to find
     */
    public OrGrep(final List<String> searchLine) {
        this.searchLine = searchLine;
    }

    /**
     * Returns those strings that contain at least one word from the input set
     *
     * @param reader reader
     * @return list
     * @throws IOException reader exception
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
                for (int i = 0; i < searchLine.size(); i++) {
                    if (sb.toString().toLowerCase().contains(searchLine.get(i).toLowerCase())) {
                        list.add(sb.toString());
                        break;
                    }
                }
                sb = new StringBuilder();
            }
        }
        for (int i = 0; i < searchLine.size(); i++) {
            if (sb.toString().toLowerCase().contains(searchLine.get(i).toLowerCase())) {
                list.add(sb.toString());
                break;
            }
        }
        reader.close();
        return list;
    }
}
