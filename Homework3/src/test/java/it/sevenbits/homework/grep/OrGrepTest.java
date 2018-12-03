package it.sevenbits.homework.grep;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for OrGrep
 */
public class OrGrepTest {
    private static OrGrep orGrep;
    private ArrayList<String> searchLine;

    @Before
    public void setUp()  {
        searchLine = new ArrayList<>();
        searchLine.add("fourth");
        searchLine.add("fifth");
        searchLine.add("first");
        orGrep = new OrGrep(searchLine);
    }

    /**
     * The test checks the work method doGrep() for OrGrep
     * @throws IOException exception
     */
    @Test
    public void testDoGrep() throws IOException {
        File file = new File("./src/test/resources/GrepTest.txt");
        Reader reader = new InputStreamReader(new FileInputStream(file));
        ArrayList<String> list = new ArrayList<>();
        list.add("fourth string");
        list.add("fifth string");
        assertEquals(list, orGrep.doGrep(reader));
    }

    /**
     * The test checks the work of the doGrep() method for OneWordGrep with a mock reader
     * @throws IOException exception
     */
    @Test
    public void testDoGrepWithMockReader() throws IOException {
        Reader mockReader = mock(Reader.class);
        ArrayList<String> list = new ArrayList<>();
        list.add("fourth string");
        list.add("first string");
        when(mockReader.read()).thenReturn(102, 111, 117, 114, 116, 104, 32, 115, 116, 114, 105, 110, 103, 10,
                102, 105, 114, 115, 116, 32, 115, 116, 114, 105, 110, 103).thenReturn(-1);
        assertEquals(list, orGrep.doGrep(mockReader));
    }
    /**
     * The test checks the file for emptiness
     * @throws IOException
     */
    @Test
    public void testDoGrepEmptyFile() throws IOException {
        File file = new File("./src/test/resources/GrepTestEmpty.txt");
        Reader reader = new InputStreamReader(new FileInputStream(file));
        ArrayList<String> list = new ArrayList<>();
        assertEquals(list, orGrep.doGrep(reader));
    }

}