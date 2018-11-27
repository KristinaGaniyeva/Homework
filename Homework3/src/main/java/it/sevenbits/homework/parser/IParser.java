package it.sevenbits.homework.parser;

import java.io.IOException;

/**
 * Interface for working with the parse method
 */
public interface IParser {
    /**
     * Parse method
     * @param delimiter split for string
     * @param source string
     * @return array
     */
    String[] parse(String delimiter, String source) throws IOException, StringParserException;
}
