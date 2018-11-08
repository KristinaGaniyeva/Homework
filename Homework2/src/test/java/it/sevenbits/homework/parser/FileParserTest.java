package it.sevenbits.homework.parser;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileParserTest {
    private static FileParser fileParser;

    @Before
    public void setUp() throws Exception {
        fileParser = new FileParser();
    }

    @Test
    public void parse() throws IOException, StringParserException {
        String [] str = {"Hello", "world"};
        String delimiter = ".";
        String source = "src/test/resources/notesTest.txt";
        String[] result = fileParser.parse(delimiter, source);
        assertArrayEquals(str, result);
    }
}