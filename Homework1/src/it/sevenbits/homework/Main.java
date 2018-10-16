package it.sevenbits.homework;

import java.util.Arrays;


import static it.sevenbits.homework.parser.Parser.parse;

public class Main {
    public static void main (String[] args) {

        String str = "Hello How are you";
        System.out.println(Arrays.asList(parse(str)));
    }
}
