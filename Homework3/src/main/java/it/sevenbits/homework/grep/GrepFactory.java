package it.sevenbits.homework.grep;

import java.io.*;
import java.util.ArrayList;

public class GrepFactory {

    public ArrayList getOneWordGrep(OneWordGrep oneWordGrep) throws IOException {
        File file = new File("./src/main/resources/notes.txt");
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList <String> list = new ArrayList<String>();
        if(oneWordGrep != null) {
            String[] words;
            String searchWord = "Hello";
            String strLine;
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

        } else {
            System.out.println("oneWordGrep doesn't exist");
        }
        return list;
    }

    public ArrayList getOrGrep(OrGrep orGrep){

        return null;
    }

    public ArrayList getAndGrep(AndGrep andGrep){

        return null;
    }
}
