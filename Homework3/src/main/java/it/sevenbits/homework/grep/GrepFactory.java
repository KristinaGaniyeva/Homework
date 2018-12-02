package it.sevenbits.homework.grep;

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
        return new OneWordGrep(line);
    }

    /**
     * Method returns orGrep
     * @param list ArrayList
     * @return orGrep
     */
    public OrGrep getOrGrep(final ArrayList list) {
        return new OrGrep(list);
    }
    /**
     * Method returns andGrep
     * @param list ArrayList
     * @return andGrep
     */
    public AndGrep getAndGrep(final ArrayList list)  {
        return new AndGrep(list);
    }
}
