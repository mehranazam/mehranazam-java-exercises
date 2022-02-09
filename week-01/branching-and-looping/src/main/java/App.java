import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        //bar bouncer app
        //1. get age of person at door
        System.out.println("Please enter birth year: ");
        Scanner scn = new Scanner(System.in);
        int year = scn.nextInt();

        int age = 2022 - year;
        boolean oldEnough = age >= 21;

        //2. If they're < 21 yrs old, print rejection message.

        //In java, "whether or not" operations are handled
        //inside parens we have a boolean expression
        //examples of boolean expressions
        //          true            < - literal boolean value
        //          false           < - other literal boolean value
        //          year > 5        < - boolean operator
        //          (year > 5) || false         < - multiple boolean operators
        //          oldEnough       < - boolean variable
        //3. Otherwise, print success message.
//        if(oldEnough){
//            System.out.println("Come on in");
//        }else if(age >= 18){
//            System.out.println("Sorry, not in America");
//        }else{
//            System.out.println("Come back when you're older.");
//        }

        //Let's say we have lots of exact equality checks
        //we can use switch rather than if/else
        //very common with menu/submenu systems.
        switch(age){
            case 18:
            case 19:
            case 20:
            System.out.println("You can buy cigarettes here but not alcohol");
                 break;
            case 22:
            case 23:
            case 24:
                System.out.println("Welcome to the bar");
                break;
            case 25:
                System.out.println("Happy 25th, this is the cool last year.");
                break;
            default:
                System.out.println("Sorry, you're not allowed.");
        }


    }
}
