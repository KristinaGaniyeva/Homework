package it.sevenbits.homework.grep;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test class for GrepFactory
 */
public class GrepFactoryTest {
    private static GrepFactory grepFactory;

    @BeforeClass
    public static void setup() {
        grepFactory = new GrepFactory();
    }

    /**
     * The test checks that the factory returns OneWordGrep
     */
    @Test
    public void getOneWordGrep(){
        String line = "";
        OneWordGrep oneWordGrep = new OneWordGrep(line);
        assertEquals(oneWordGrep.getClass(), grepFactory.getOneWordGrep(line).getClass());
    }

    /**
     * The test checks that the factory returns OrGrep
     */
    @Test
    public void getOrGrep() {
        ArrayList<String> list = new ArrayList<>();
        OrGrep orGrep = new OrGrep(list);
        assertEquals(orGrep.getClass(), grepFactory.getOrGrep(list).getClass());
    }

    /**
     * The test checks that the factory returns AndGre
     */
    @Test
    public void getAndGrep() {
        ArrayList<String> list = new ArrayList<>();
        AndGrep andGrep = new AndGrep(list);
        assertEquals(andGrep.getClass(), grepFactory.getAndGrep(list).getClass());
    }
}