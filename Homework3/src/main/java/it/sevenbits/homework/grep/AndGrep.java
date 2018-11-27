package it.sevenbits.homework.grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class AndGrep implements IGrep {
    public List doGrep(Reader reader) throws IOException {
        String[] words;
        String searchWord = "Hello";
        String searchSecondWord = "world";
        String strLine;
        boolean strTemp;
        ArrayList<String> list = new ArrayList<String>();
        while ((strLine = ((BufferedReader) reader).readLine()) != null) {
            words = strLine.split(" ");
            boolean firstWorld = false;
            boolean secondWorld = false;
            for (int i = 0; i < words.length; i++) {
                String tempLine = words[i];
                if (tempLine.equals(searchWord)) {
                    firstWorld = true;
                }
                if (tempLine.equals(searchSecondWord)){
                    secondWorld = true;
                }
                if ((firstWorld) & (secondWorld)){
                    list.add(strLine);
                    break;
                }
            }
        }
        reader.close();
        return list;
    }
}
