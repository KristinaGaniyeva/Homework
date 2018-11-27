package it.sevenbits.homework.grep;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrGrepTest {
    private static OrGrep orGrep;

    @Before
    public void setUp() {
        orGrep = new OrGrep();
    }

    @Test
    public void testDoGrep() throws IOException {
        File file = new File("./src/test/resources/GrepTest.txt");
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello world");
        list.add("Big world");
        assertEquals(list, orGrep.doGrep(reader));
    }
}