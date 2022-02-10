import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        // SWITCH OPPOSITES
        // Given a word, print its opposite using a switch statement.
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = console.nextLine();
        String opposite = null;

        // 1. Re-implement Exercise08 using a switch statement.
        switch(word) {
            case ("high"):
                opposite = "low";
                System.out.printf("The opposite of %s is %s.%n", word, opposite);
                break;
            case ("cold"):
                opposite = "hot";
                System.out.printf("The opposite of %s is %s.%n", word, opposite);
                break;
            case ("little"):
                opposite = "big";
                System.out.printf("The opposite of %s is %s.%n", word, opposite);
                break;
            case ("strong"):
                opposite = "weak";
                System.out.printf("The opposite of %s is %s.%n", word, opposite);
                break;
            case ("wide"):
                opposite = "narrow";
                System.out.printf("The opposite of %s is %s.%n", word, opposite);
                break;
            default:
                System.out.printf("I don't have an opposite for %s.%n", word);

        }

    }
}
