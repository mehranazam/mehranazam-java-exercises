import java.util.Scanner;



public class Pangram {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Write a phrase: ");
        String phrase = scn.nextLine();

        allAlpha(phrase);
//        String testString = "abcdefghijklmnopqrstuvwxyz";
//        String testString2 = "hello world";

        System.out.printf("%s: %s", phrase, allAlpha(phrase));

    }

    public static boolean allAlpha(String phrase){
        boolean isPangram = true;
        String [] alpha = new String[26];
     //   String cleanInput = phrase.replace(" ", "");

        for(int i = 0; i < phrase.length(); i++){
            char currChar = Character.toLowerCase(phrase.charAt(i));
            int charToInt = Character.getNumericValue(currChar); // [a-z] = 97-122 (ASCII Values)
            //System.out.println(charToInt);
            int charIndex = charToInt;
            alpha[charIndex - 10] = currChar + "";
        }


        for(int i = 0; i < alpha.length; i++){
            String currChar2 = alpha[i];
            if(currChar2 == null){
                isPangram = false;
            }
        }


        return isPangram;
    }
}
