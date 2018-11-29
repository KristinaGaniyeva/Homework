package it.sevenbits.homework.grep;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class OneWordGrepTest {

    private static OneWordGrep oneWordGrep;
    private String searchLine;

    @Before
    public void setUp() {
        searchLine = "first string";
        oneWordGrep = new OneWordGrep(searchLine);

    }

    @Test
    public void testDoGrep() throws IOException {
        File file = new File("./src/main/resources/notes.txt");
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<String> list = new ArrayList<>();
        list.add("first string");
        assertEquals(list, oneWordGrep.doGrep(reader));
    }
}