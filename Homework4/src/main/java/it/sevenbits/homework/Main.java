package it.sevenbits.homework;

import it.sevenbits.homework.Exception.ReaderException;
import it.sevenbits.homework.grep.AndGrep;
import it.sevenbits.homework.grep.IGrep;
import it.sevenbits.homework.grep.OneWordGrep;
import it.sevenbits.homework.grep.OrGrep;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Main application entry point
 */
public final class Main {
    private Main(){}
    /**
     * Main function for app
     * @param args - console arguments
     * @throws ReaderException reader exception
     * @throws IOException IO exception
     */
    public static void main(final String[] args) throws ReaderException, IOException {
        Reader reader;
        IGrep grep;
        String delim;

        switch (args[0]) {
            case "-f":
                reader = new InputStreamReader(new FileInputStream(new File(args[1])));
                break;
            case "-s":
                reader = new StringReader(args[1]);
                break;
            default:
                throw new ReaderException("Enter -f or -s");
        }

        if (args.length > 4) {
            delim = args[5];
        } else {
            delim = " ";
        }

        String[] strArray = args[3].split(delim);
        List<String> strList = new ArrayList<>();
        Collections.addAll(strList, strArray);

        switch (args[2]) {
            case "-and":
                grep = new AndGrep(strList);
                break;
            case "-or":
                grep = new OrGrep(strList);
                break;
            case "-one":
                grep = new OneWordGrep(args[3]);
                break;
            default:
                throw new ReaderException("Enter -and, -or, -one");
        }
        System.out.println(grep.doGrep(reader));
    }
}
