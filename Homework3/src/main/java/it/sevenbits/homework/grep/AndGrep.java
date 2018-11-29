package it.sevenbits.homework.grep;

import it.sevenbits.homework.grep.Exception.AndGrepException;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
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
    public List doGrep(Reader reader) throws IOException, AndGrepException {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> listResult = new ArrayList<>();
        String strLine;
        File file = new File("./src/main/resources/notes.txt");
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((strLine = ((BufferedReader) reader).readLine()) != null) {
            list.add(strLine);
        }
        reader.close();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < searchLine.size(); j++) {
                if (list.contains(searchLine.get(j))) {
                    if (list.get(i).equals(searchLine.get(j))) {
                        listResult.add(list.get(i));
                    }
                } else {
                    throw new AndGrepException("All entered data must correspond to the data from the file");
                }
            }
        }
        return listResult;
    }
}