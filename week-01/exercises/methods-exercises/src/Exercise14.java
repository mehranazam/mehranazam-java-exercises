import java.util.Scanner;

public class Exercise14 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String id = name();
        int towns = townsLivedIn();
        int instruments = instrumentsPlayed();

        System.out.println(id + " has lived in " + towns + " towns and plays " + instruments + " instruments.");


    }

   public static String name(){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName = scan1.nextLine();

       System.out.println("What is your last name?");
       String lastName = scan1.nextLine();

       String name1 = firstName + " " + lastName;

       return name1;
   }


    public static int townsLivedIn(){
        Scanner scan2 = new Scanner(System.in);
        String numberOfTowns = "";
        System.out.println("How many towns/cities have you lived in?");
        numberOfTowns = scan2.nextLine();

        int numTowns = Integer.parseInt(numberOfTowns);

        return numTowns;
    }

    public static int instrumentsPlayed(){
        Scanner scan3 = new Scanner(System.in);
        String instruments = "";
        System.out.println("How many musical instruments can you play?");
        instruments = scan3.nextLine();

        int numInstruments = Integer.parseInt(instruments);

        return numInstruments;
    }


    /* SHORT SURVEY

    Write a program that asks a user four questions and prints the results:
    - What is your first name?
    - What is your last name?
    - How many towns/cities have you lived in?
    - How many musical instruments can you play?

    Store each answer in a variable with an appropriate type.
    Print the results after the user has answered all four questions.

    Use methods to break the program into reusable blocks of code.
     */
}
