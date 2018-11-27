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

    @Before
    public void setUp() {
        oneWordGrep = new OneWordGrep();
    }

    @Test
    public void testDoGrepWithMock() throws IOException {
        Reader mockReader = mock(BufferedReader.class);
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        when(((BufferedReader) mockReader).readLine()).thenReturn("Hello world");
        assertEquals(list, oneWordGrep.doGrep(mockReader));
    }

    @Test
    public void testDoGrep() throws IOException {
        File file = new File("./src/test/resources/GrepTest.txt");
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello world");
        assertEquals(list, oneWordGrep.doGrep(reader));
    }
}