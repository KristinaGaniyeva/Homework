package it.sevenbits.homework.parser;

/**
 * Class StringParser
 */
public class StringParser implements IParser {
    /**
     * The method splits the string and writes to the array
     *
     * @param delimiter split for string
     * @param source    string
     * @return array mass
     */
    public String[] parse(final String delimiter, final String source) {

//        String str = source.replaceAll(delimiter + "{2,}", delimiter);

        String str = stringReplace(delimiter, source);
        int countSpace = 0;


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter.charAt(0)) {
                countSpace++;
            }
        }
        String[] mass = new String[countSpace + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < str.length(); i++) {
            if (str.charAt(i) != delimiter.charAt(0)) {
                sb.append(str.charAt(i));
            }
            if (str.charAt(i) == delimiter.charAt(0) || i == str.length() - 1) {
                mass[j] = sb.toString();
                sb.setLength(0);
                j++;
            }
        }
        return mass;
    }

    /**
     * Replacing duplicate characters
     * @param delimiter delimiter
     * @param source input line
     * @return string
     */

    public String stringReplace(final String delimiter, final String source) {
        int delim = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != delimiter.charAt(0)) {
                sb.append(source.charAt(i));
                delim = 0;
            } else {
                delim++;
                if (delim == 1) {
                    sb.append(delimiter);
                }
            }
        }
        return sb.toString();
    }
}

//    public String stringReplace (String delimiter, String source) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < source.length(); i++) {
//            if (source.charAt(i) == delimiter.charAt(0)) {
//                sb.append(source.charAt(i));
//            }
//        }
//        return sb.toString();
//    }
//}
