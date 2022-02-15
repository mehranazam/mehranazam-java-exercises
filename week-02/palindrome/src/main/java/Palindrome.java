import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Please write a word: ");
        String word = scn.nextLine();

        String [] wordArray = new String[word.length()];

        for(int i = 0; i < word.length(); i++) {
//            String wordArray = new String[word.length()];
            wordArray[i] = String.valueOf(word.charAt(i));
            System.out.print(String.valueOf(word.charAt(i)));
        }
        //System.out.println(wordArray);


        }

//        for(int i = 0; i < word.length(); i++) {
//            for (int j = word.length() - 1; j >= 0; j--) {
//                if (word.charAt(i) == (word.charAt(j))) {
//                    System.out.println("It is a palindrome");
//                } else {
//                    System.out.println("Wrong! Try again.");
//                    word = scn.nextLine();
//                }
//
//            }
//        }
//    }
}
