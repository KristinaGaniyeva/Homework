package it.sevenbits.homework.parser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringParserTest {
    private static StringParser stringParser;

    @Before
    public void setUp() throws Exception {
        stringParser = new StringParser();
    }

    @Test
    public void parse() {
        String str = "Hello world";
        String delimiter = " ";
        String[] result = stringParser.parse(delimiter, str);
        assertArrayEquals(new String[]{"Hello", "world"}, result);
    }

    @Test
    public void stringReplace() {
        String str = "Hello      world";
        String delimiter = " ";
        String result = stringParser.stringReplace(delimiter, str);
        assertEquals("Hello world", result);
    }
}