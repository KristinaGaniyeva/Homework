package it.sevenbits.homework.grep;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class AndGrep
 */
public class AndGrep implements IGrep {
    private ArrayList<String> searchLine;

    /**
     * Class constructor
     * @param searchLine string to find
     */
    public AndGrep(final ArrayList searchLine) {
        this.searchLine = searchLine;
    }

    /**
     * Returns those lines that contain all the words from the input set
     * @param reader reader
     * @return list
     * @throws IOException reader exception
     */
    public List doGrep(final Reader reader) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> listResult = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int text;
        while ((text = (reader).read()) != -1) {
            if ((char) text != '\n') {
                sb.append((char) text);
            }
            if ((char) text == '\n') {
                count++;
                for (int i = 0; i < searchLine.size(); i++) {
                    if (sb.toString().contains(searchLine.get(i))) {
                        list.add(sb.toString());
                        if (count == searchLine.size()) {
                            listResult = list;
                        }
                    }
                }
                sb = new StringBuilder();
            }
        }
        count++;
        for (int i = 0; i < searchLine.size(); i++) {
            if (sb.toString().contains(searchLine.get(i))) {
                list.add(sb.toString());
                if (count == searchLine.size()) {
                    listResult = list;
                }
            }
        }
        reader.close();
        return listResult;
    }
}