package it.sevenbits.homework;

import it.sevenbits.homework.parser.FileParser;
import it.sevenbits.homework.parser.StringParserException;

import java.io.IOException;
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
        String delimiter = ".";
        FileParser parser = new FileParser();
        String source = "src/main/resources/notes.txt";
        try {
            try {
                System.out.println(Arrays.toString(parser.parse(delimiter, source)));
            } catch (StringParserException e) {
                System.out.println("Delimiter empty");
            }
        } catch (IOException e) {
            System.out.println("Invalid string");
        }
    }
}
