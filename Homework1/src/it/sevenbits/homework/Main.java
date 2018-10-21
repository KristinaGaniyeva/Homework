package it.sevenbits.homework;

import it.sevenbits.homework.parser.Parser;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String str = " Hello world How      Are  You   ";
        String str1 = str;
        System.out.println(Arrays.toString(parser.parse(str1)));
    }
}
