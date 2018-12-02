package it.sevenbits.homework.grep;

import it.sevenbits.homework.grep.Exception.AndGrepException;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * IGrep interface with doGrep() method
 */
public interface IGrep {
    /**
     * The method filters the flow of textual information
     * @param reader Reader
     * @return Arraylist
     * @throws IOException reader exception
     * @throws AndGrepException andGrep exception
     */
    List doGrep(Reader reader) throws IOException, AndGrepException;
}
