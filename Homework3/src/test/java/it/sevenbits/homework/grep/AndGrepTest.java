package it.sevenbits.homework.grep;

import it.sevenbits.homework.grep.Exception.AndGrepException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class AndGrepTest {
    private static AndGrep andGrep;
    private ArrayList<String> searchLine;

    @Before
    public void setUp() {
        searchLine = new ArrayList<>();
    }

    @Test
    public void testDoGrep() throws IOException, AndGrepException {
        searchLine.add("first string");
        searchLine.add("third string");
        andGrep = new AndGrep(searchLine);
        File file = new File("./src/main/resources/notes.txt");
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<String> list = new ArrayList<>();
        list.add("first string");
        list.add("third string");
        assertEquals(list, andGrep.doGrep(reader));
    }

    @Test(expected = AndGrepException.class)
    public void testDoGrepException() throws IOException, AndGrepException {
        searchLine.add("first string");
        searchLine.add("fifth string");
        searchLine.add("third string");
        andGrep = new AndGrep(searchLine);
        File file = new File("./src/main/resources/notes.txt");
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<String> list = new ArrayList<String>(andGrep.doGrep(reader));
    }
}