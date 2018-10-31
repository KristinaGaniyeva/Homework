package it.sevenbits.homework.parser;

import java.io.*;

/**
 * Class FileParser
 */
public class FileParser implements IParser {
    /**
     *
     * @param delimiter split for string
     * @param source string
     * @return array text
     */
    public String[] parse(final String delimiter, final String source) {
        String[] text = new String[100]; // проблема с заданием размера пока не решена
        String all = "";
        StringBuilder sb = new StringBuilder();
        StringParser parser = new StringParser();
        try {
            FileInputStream fstream = new FileInputStream(source);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(all).append(strLine).append(delimiter);
            }
            text = parser.parse(delimiter, sb.toString());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }
}