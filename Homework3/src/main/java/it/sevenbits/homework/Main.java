package it.sevenbits.homework;

import it.sevenbits.homework.grep.AndGrep;
import it.sevenbits.homework.grep.GrepFactory;
import it.sevenbits.homework.grep.OneWordGrep;
import it.sevenbits.homework.grep.OrGrep;
import it.sevenbits.homework.parser.FileParser;
import it.sevenbits.homework.parser.StringParserException;

import java.io.*;
import java.util.Arrays;

/**
 * Main application entry point
 */
public class Main {
    /**
     * Main function for app
     * @param args - console arguments
     */
    public static void main(final String[] args) {
        File file = new File("./src/main/resources/notes.txt");
        Reader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        GrepFactory grepFactory = new GrepFactory();
        OneWordGrep oneWordGrep = new OneWordGrep();
        try {
            oneWordGrep.doGrep(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(grepFactory.getOneWordGrep(oneWordGrep));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
