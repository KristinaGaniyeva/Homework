package it.sevenbits.homework.grep;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface IGrep {
    List doGrep(final Reader reader) throws IOException;
}
