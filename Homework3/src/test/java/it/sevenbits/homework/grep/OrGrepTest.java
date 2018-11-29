package it.sevenbits.homework.grep;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class OrGrepTest {
    private static OrGrep orGrep;
    private ArrayList<String> searchLine;

    @Before
    public void setUp() throws IOException {
        searchLine = new ArrayList<>();
        searchLine.add("first string");
        searchLine.add("fifth string");
        searchLine.add("sixth string");
        orGrep = new OrGrep(searchLine);
    }

    @Test
    public void testDoGrep() throws IOException {
        File file = new File("./src/main/resources/notes.txt");
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<String> list = new ArrayList<>();
        list.add("first string");
        assertEquals(list, orGrep.doGrep(reader));
    }
}