package it.sevenbits.homework.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

/**
 * Class FileParser
 */
public class FileParser implements IParser {
    /**
     * @param delimiter split for string
     * @param source    string
     * @return array text
     * @exception StringParserException string exception
     * @exception IOException reader exception
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