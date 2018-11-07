package it.sevenbits.homework.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    private static StringParser stringParser;
    private static FileParser fileParser;

    @Before
    public void setUp() {
        stringParser = new StringParser();
        fileParser = new FileParser();
    }

    @Test
    public void parseNull() {
        String str = "Hello world";
        String[] result = stringParser.parse(" ", str);
        assertNull(result);
    }

//    @Test
//    public void parseFewWords() {
//        String [] exp = new String[]{"Hello", "world"};
//        Assert.assertArrayEquals(exp,stringParser.parse(" ", "Hello world"));
//    }

//    @Test
//    public void parseArrayWord() {
//        String [] exp = new String[]{"Hello"};
//        Assert.assertArrayEquals(exp,stringParser.parse(" ", "Hello"));
//    }
}