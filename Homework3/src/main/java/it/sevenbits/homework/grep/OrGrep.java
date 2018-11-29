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
 * Class OrGrep
 */
public class OrGrep implements IGrep {
    private ArrayList<String> searchLine;

    /**
     * Class constructor
     * @param searchLine string to find
     */
    public OrGrep(final ArrayList searchLine) {
        this.searchLine = searchLine;
    }

    /**
     * Returns those strings that contain at least one word from the input set
     * @param reader reader
     * @return list
     * @throws IOException reader exception
     */
    public List doGrep(Reader reader) throws IOException {
        File file = new File("./src/main/resources/notes.txt");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> listResult = new ArrayList<>();
        String strLine;
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((strLine = ((BufferedReader) reader).readLine()) != null) {
            list.add(strLine);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < searchLine.size(); j++) {
                if (list.get(i).equals(searchLine.get(j))) {
                    listResult.add(list.get(i));
                }
            }
        }
        return listResult;
    }
}
