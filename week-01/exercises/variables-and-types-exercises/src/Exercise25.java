import java.util.Scanner;

public class Exercise25 {
    public static void main(String[] args) {


        String name;

       String begin = "Hello everyone, ";
        String middle = "I am ";
        String end = "Pickle ";

        Scanner scn = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        name = scn.nextLine();


        System.out.println(begin + middle + end + name + ".");
    }

    // Mad Libs: https://en.wikipedia.org/wiki/Mad_Libs
    // 1. Add a main method.
    // 2. Declare several variables of various types to be "plugged in" to a Mad Libs sentence.
    // 3. Use string concatenation to build a silly sentence.
    // 4. Print the result.
    // 5. Change variable values to change the sentence. Ask a friend for random values to increase the chances
    // of something hilarious or kinda naughty.
}
