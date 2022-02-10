import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            //have the computer pick a random number 1-20
            //let user try to guess up to 5 times
            //      get the guess from user
            //      if too low, let user know it's too low
            //      if too high, let user know it's too high
            //      if it's a match, tell the user they've won, and quit


        Random rng = new Random();


        int targetNum = rng.nextInt(20) + 1;
        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to the guessing game. Please try to guess a number between 1-20.");

        for(int numGuess = 0; numGuess < 5; numGuess++){
            int guess = Integer.MIN_VALUE;
            while (guess < 1 || guess > 20) {
                System.out.print("Guess a number: ");
                guess = scn.nextInt();
            }
            if(guess < targetNum){
                System.out.println("Number too low.");
            }else if(guess > targetNum){
                System.out.println("Number too high.");
            } else {
                System.out.printf("Correct!");
                break;
            }


        }
    }

}
