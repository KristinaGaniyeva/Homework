package it.sevenbits.homework.parser;

public class Parser {
    public String[] parse(final String strInput) {
        String str = strInput.trim().replaceAll(" {2,}", " ");
        int countSpace = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                countSpace++;
            }
        }

        String mass[] = new String[countSpace + 1];
        StringBuilder sb = new StringBuilder();

         for (int i = 0, j = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb = sb.append(str.charAt(i));
            }
            if(str.charAt(i) == ' ' || i==str.length()-1) {
                mass[j] = sb.toString();
                sb.setLength(0);
                j++;
            }
        }
        return mass;

    }
}
