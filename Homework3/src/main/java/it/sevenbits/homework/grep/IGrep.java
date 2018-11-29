package it.sevenbits.homework.grep;

import it.sevenbits.homework.grep.Exception.AndGrepException;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * The method filters the flow of textual information
 * @throws IOException reader exception
 * @throws AndGrepException andGrep exception
 */
public interface IGrep {
    List doGrep(Reader reader) throws IOException, AndGrepException;
}
