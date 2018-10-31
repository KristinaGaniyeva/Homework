package it.sevenbits.homework;

import it.sevenbits.homework.parser.FileParser;
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
        String delimiter = " ";
        FileParser parser = new FileParser();
        String source = "../Homework2/Notes.txt";
        System.out.println(Arrays.toString(parser.parse(delimiter, source)));
    }
}
