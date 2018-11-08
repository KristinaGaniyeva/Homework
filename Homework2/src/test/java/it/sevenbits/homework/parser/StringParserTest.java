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
    public void parse() throws StringParserException {
        String str = "Hello world";
        String delimiter = " ";
        String[] result = stringParser.parse(delimiter, str);
        assertArrayEquals(new String[]{"Hello", "world"}, result);
    }

    @Test(expected = StringParserException.class)
    public void testStringParserException() throws StringParserException {
        stringParser.parse("", "Hello");
    }

    @Test
    public void stringReplace() {
        String str = "Hello      world";
        String delimiter = " ";
        String result = stringParser.stringReplace(delimiter, str);
        assertEquals("Hello world", result);
    }
}