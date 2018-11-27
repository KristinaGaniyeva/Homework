package it.sevenbits.homework.grep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OneWordGrep implements IGrep {
    public List doGrep(Reader reader) throws IOException {
        String[] words;
        String searchWord = "Hello";
        String strLine;
        ArrayList<String> list = new ArrayList<String>();
        while ((strLine = ((BufferedReader) reader).readLine()) != null) {
            words = strLine.split(" ");
            for (int i = 0; i < words.length; i++) {
                String tempLine = words[i];
                if (tempLine.equals(searchWord)) {
                    list.add(strLine);
                    break;
                }
            }
        }
        reader.close();
        return list;
    }
}