package it.sevenbits.homework.parser;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileParserTest {
    private static FileParser fileParser;

    @Before
    public void setUp() throws Exception {
        fileParser = new FileParser();
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void parse() throws IOException {

    }
}