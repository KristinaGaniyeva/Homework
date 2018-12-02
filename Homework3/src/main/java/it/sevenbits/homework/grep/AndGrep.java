package it.sevenbits.homework.grep;

import it.sevenbits.homework.grep.Exception.AndGrepException;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class AndGrep
 */
public class AndGrep implements IGrep {
    private ArrayList searchLine;

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
     * @throws AndGrepException andGrep exception
     */
    public List doGrep(final Reader reader) throws IOException, AndGrepException {
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
                if (searchLine.contains(sb.toString())) {
                    list.add(sb.toString());
                    if (count == searchLine.size()) {
                        listResult = list;
                    }
                    sb = new StringBuilder();
                }
            }
        }
        count++;
        if (searchLine.contains(sb.toString())) {
            list.add(sb.toString());
            if (count == searchLine.size()) {
                listResult = list;
            }
        } else {
            throw new AndGrepException("Not all data found");
        }
        reader.close();
        return listResult;
    }
}