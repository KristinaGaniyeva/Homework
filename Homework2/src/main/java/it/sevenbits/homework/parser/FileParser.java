package it.sevenbits.homework.parser;

import java.io.*;

/**
 * Class FileParser
 */
public class FileParser implements IParser {
    /**
     * @param delimiter split for string
     * @param source    string
     * @return array text
     */
    public String[] parse(final String delimiter, final String source) throws IOException, StringParserException {
        String[] text;
        StringBuilder sb = new StringBuilder();
        StringParser parser = new StringParser();

        FileInputStream fstream = new FileInputStream(source);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while ((strLine = br.readLine()) != null) {
            sb.append(strLine);
        }
        text = parser.parse(delimiter, sb.toString());
        return text;
    }
}