package it.sevenbits.homework.grep;

import it.sevenbits.homework.grep.Exception.AndGrepException;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for AndGrep
 */
public class AndGrepTest {
    private static AndGrep andGrep;
    private ArrayList<String> searchLine;

    @Before
    public void setUp() {
        searchLine = new ArrayList<>();
    }

    /**
     * The test checks the work method doGrep() for OrGrep
     * @throws IOException exception reader
     * @throws AndGrepException exception AndGrep
     */
    @Test
    public void testDoGrep() throws IOException, AndGrepException {
        searchLine.add("fourth string");
        searchLine.add("fifth string");
        andGrep = new AndGrep(searchLine);
        File file = new File("./src/test/resources/GrepTest.txt");
        Reader reader = new InputStreamReader(new FileInputStream(file));
        ArrayList<String> list = new ArrayList<>();
        list.add("fourth string");
        list.add("fifth string");
        assertEquals(list, andGrep.doGrep(reader));
    }

    /**
     * The test checks the work of the doGrep() method for OneWordGrep with a mock reader
     * @throws IOException exception reader
     * @throws AndGrepException exception AndGrep
     */
    @Test
    public void testDoGrepWithMock() throws IOException, AndGrepException {
        searchLine.add("fourth string");
        searchLine.add("fifth string");
        andGrep = new AndGrep(searchLine);
        Reader mockReader = mock(Reader.class);
        ArrayList<String> list = new ArrayList<>();
        list.add("fourth string");
        list.add("fifth string");
        when(mockReader.read()).thenReturn(102, 111, 117, 114, 116, 104, 32, 115, 116, 114, 105, 110, 103, 10,
                102, 105, 102, 116, 104, 32, 115, 116, 114, 105, 110, 103).thenReturn(-1);
        assertEquals(list, andGrep.doGrep(mockReader));
    }

    /**
     * The test checks if all required strings are not found
     * @throws IOException exception reader
     * @throws AndGrepException exception AndGrep
     */
    @Test(expected = AndGrepException.class)
    public void testDoGrepException() throws IOException, AndGrepException {
        searchLine.add("fourth string");
        searchLine.add("first string");
        andGrep = new AndGrep(searchLine);
        File file = new File("./src/test/resources/GrepTest.txt");
        Reader reader = new InputStreamReader(new FileInputStream(file));
        ArrayList<String> list = new ArrayList<>();
        assertEquals(list, andGrep.doGrep(reader));
    }
}