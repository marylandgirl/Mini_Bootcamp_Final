import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringBuffer;

public class DictionaryWordList {
    public static void main(String[] args){

        //Declare and initialize variables
        String[] origList = new String[10];
        String[] ascendList = new String[10];
        String[] descendList = new String[10];
        String[] vowelList;
        StringBuffer sb = new StringBuffer();


        int counter = 0;
        String prefix = "Enter string ";
        String suffix = " of 10: ";
        String word;

        Scanner keybd = new Scanner(System.in);


        //Capture user entry of 10 strings
        for (int i = 0; i < 10; i++) {
            counter++;
            System.out.print(prefix + counter + suffix);
            word = keybd.next();
            boolean startsWithVowel = addToVowelList(word.charAt(0));
            if (startsWithVowel)
                sb.append(word + " ");
            origList[i] = word;
            ascendList[i] = word;
        }

        /*Loop through the list comparing two elements at a time
        /if an element is greater (in alphabetical order) than the one
        /behind it swap the values*/
        for (int i = 0; i < ascendList.length; i++) {
            for ( int j = 0; j < ascendList.length  - i - 1; j++) {
                String tempStr = "";
                if ( ascendList[j].compareTo(ascendList[j+1]) > 0) {
                    tempStr = ascendList[j];
                    ascendList[j] = ascendList[j+1];
                    ascendList[j+1] = tempStr;
                }
            }
        }

        //Create Descending List
        counter = 0;
        for ( int i = ascendList.length - 1; i >= 0 ; i--) {
            descendList[counter] = ascendList[i];
            counter++;
        }

        //Report results to screen
        System.out.println("\n\nOriginal Order:");
        System.out.println(Arrays.toString(origList)
                .replaceAll(",","")
                .replaceAll("\\[","")
                .replaceAll("\\]",""));
        System.out.println("\nAlphabetical Order:");
        System.out.println(Arrays.toString(ascendList)
                .replaceAll(",","")
                .replaceAll("\\[","")
                .replaceAll("\\]",""));
        System.out.println("\nReversed Alphabetical Order:");
        System.out.println(Arrays.toString(descendList)
                .replaceAll(",","")
                .replaceAll("\\[","")
                .replaceAll("\\]",""));
        System.out.println("\nBegins With A Vowel:");
        System.out.println(sb.toString());
    }

    //Checks first letter of the word and returns true if begins with vowel
    private static boolean addToVowelList(char letter) {
        StringBuffer sb = new StringBuffer();
        boolean isTrue = false;
        switch(letter){
            case 'a':
            case 'A':
                isTrue = true;
                break;
            case 'e':
            case 'E':
                isTrue = true;
            break;
            case 'i':
            case 'I':
                isTrue = true;
                break;
            case 'o':
            case 'O':
                isTrue = true;
                break;
            case 'u':
            case 'U':
                isTrue = true;
                break;
        }
        return isTrue;
    }
}
