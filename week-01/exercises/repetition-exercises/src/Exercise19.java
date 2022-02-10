import java.util.Scanner;

public class Exercise19 {
    public static void main(String[] args) {
        // INTERLEAVE
        Scanner console = new Scanner(System.in);

        System.out.print("First word: ");
        String first = console.nextLine();

        System.out.print("Second word: ");
        String second = console.nextLine();

        // 1. Write a loop to interleave two strings to form a new string.
        // To interleave, during each loop take one character from the first string and add it to the result
        // and take one character from the second string and add it to the result.
        // If there are no more characters available, don't add characters.
        // 2. Print the result.


        String finalWord = "";
        int highestLength = 0;

        if(first.length() > second.length()) {
            highestLength = first.length();
        }else{
            highestLength = second.length();
        }

        for(int i = 0; i < highestLength; i++){

            if(i < first.length()){
                finalWord += first.charAt(i);
            }
            if(i < second.length()){
                finalWord += second.charAt(i);
            }
        }
            System.out.println(finalWord);
        // Examples
        // "abc", "123" -> "a1b2c3"
        // "cat", "dog" -> "cdaotg"
        // "wonder", "o" -> "woonder"
        // "B", "igstar" -> "Bigstar"
        // "", "huh?" -> "huh?"
        // "wha?", "" -> "wha?"
    }
}
