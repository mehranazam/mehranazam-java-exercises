import java.util.Scanner;

public class Knock {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to the knock-knock joke simulator.");
        System.out.println("Knock knock!");
        String input = scn.nextLine();

        boolean validInput = true;

        while((input.equals("Who's there?"))) {

                System.out.println("Interrupting cow.");
                input = scn.nextLine();


        }

        System.out.println("Say Who's there?");
//        Scanner scn2 = new Scanner(System.in);
//
//
//        String input2 = scn2.nextLine();
//
//
//        System.out.println("Interrupting cow says Moo!");
    }
}
