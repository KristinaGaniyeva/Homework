package it.sevenbits.homework.grep;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Factory GrepFactory
 */
public class GrepFactory {
    /**
     * Method returns oneWordGrep
     * @param line string
     * @return oneWordGrep
     */
    public OneWordGrep getOneWordGrep(final String line) {
        OneWordGrep oneWordGrep = new OneWordGrep(line);
        return oneWordGrep;
    }

    /**
     * Method returns orGrep
     * @param list ArrayList
     * @return orGrep
     * @throws IOException exception
     */
    public OrGrep getOrGrep(final ArrayList list) throws IOException {
        OrGrep orGrep = new OrGrep(list);
        return orGrep;
    }
    /**
     * Method returns andGrep
     * @param list ArrayList
     * @return andGrep
     */
    public AndGrep getAndGrep(final ArrayList list)  {
        AndGrep andGrep = new AndGrep(list);
        return andGrep;
    }
}
