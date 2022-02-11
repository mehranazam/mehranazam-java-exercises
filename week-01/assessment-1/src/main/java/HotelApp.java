import java.util.Scanner;
public class HotelApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel 69.");
        System.out.println("=====================");

        int capsules = capsuleCount("How many capsules are available?: ");

        int menuOptions = mainMenu("Choose an option [1-4]: ");



    }

    public static int capsuleCount (String prompt){
        Scanner scn = new Scanner(System.in);
        System.out.print(prompt);

        int userInt = Integer.MIN_VALUE;

        userInt = Integer.parseInt(scn.nextLine());

        return userInt;
    }

    public static int mainMenu(String prompt){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Guest Menu");
        System.out.println("====================");
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. View Guests");
        System.out.println("4. Exit");

        int option = scan1.nextInt();
        return option;

    }

//    public static String name(){
//
//
//    }
//
//    public static int checkIn(){
//
//    }
//
//    public static int checkOut(){
//
//
//    }
//
//    public static boolean exit(){
//
//
//    }
}
