package it.sevenbits.homework.parser;

public class Parser {

    public static String[] parse (String strInput){

        int countSpace = 0;

        for (int i = 0; i < strInput.length(); i++) {
            if (strInput.charAt(i) == ' '){
                countSpace++;
            }
        }

        String mass[] = new String[countSpace+1];

        String tmpStr = "";

        for(int i = 0, j = 0; i < strInput.length(); i++){
            if(strInput.charAt(i) == ' '){
                j++;
                tmpStr = "";
            }
            else{
                tmpStr = tmpStr + strInput.charAt(i);
            }
            mass[j] = tmpStr;
        }
        return mass;
    }
}