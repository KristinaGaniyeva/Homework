package it.sevenbits.homework.grep;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for OneWordGrep
 */
public class OneWordGrepTest {
    private static OneWordGrep oneWordGrep;
    private String searchLine;

    @Before
    public void setUp() {
        searchLine = "Fourth";
        oneWordGrep = new OneWordGrep(searchLine);
    }

    /**
     * The test checks the work method doGrep() for OneWordGrep
     * @throws IOException exception
     */
    @Test
    public void testDoGrepOneWord() throws IOException {
        File file = new File("./src/test/resources/GrepTest.txt");
        Reader reader = new InputStreamReader(new FileInputStream(file));
        ArrayList<String> list = new ArrayList<>();
        list.add("fourth string");
        assertEquals(list, oneWordGrep.doGrep(reader));
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
        when(mockReader.read()).thenReturn(102, 111, 117, 114, 116, 104, 32, 115, 116, 114, 105, 110, 103).thenReturn(-1);
        assertEquals(list, oneWordGrep.doGrep(mockReader));
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
        assertArrayEquals(list.toArray(), oneWordGrep.doGrep(reader).toArray());
    }
}