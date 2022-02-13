import java.util.Random;
import java.util.Scanner;
public class HotelApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel 69.");
        System.out.println("=====================");

        int capsules = capsuleCount("How many capsules are available?: ");
        mainMenu();




    }

    private static Random rng = new Random();

    public static int capsuleCount (String prompt){
        Scanner scn = new Scanner(System.in);
        System.out.print(prompt);

        int userInt = Integer.MIN_VALUE;

        userInt = Integer.parseInt(scn.nextLine());

        return userInt;
    }

    public static void mainMenu(){

        System.out.println("Guest Menu");
        System.out.println("====================");
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. View Guests");
        System.out.println("4. Exit");
        System.out.println("Choose an option [1-4]: ");



    }

    public static int getIntInRange(){

        int choice = Integer.MIN_VALUE;
        Scanner scan1 = new Scanner(System.in);

        choice = scan1.nextInt();
        switch(choice) {
            case 1:
                checkIn();
                break;
            case 2:
                checkOut();
                break;
            case 3:
                viewRooms();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Unknown action");
                choice = scan1.nextInt();

        }
        return choice;

        }







    public static String name(String guestName){
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Guest's name: ");
        guestName = scan2.nextLine();

        return guestName;
            }
//
    public static int checkIn(int roomAvail){
        Scanner scan3 = new Scanner(System.in);
        String guestName = "";
        System.out.println("Guest Check In");
        System.out.println("===============");
        System.out.println("Guest Name: " + name(guestName));
        System.out.print("Capsule #[1-" + capsules]: + " ");
        roomAvail = scan3.nextInt();

       return roomAvail;
    }

    public static boolean isRoomAvailable(int roomAvail){
        boolean occupied = false;

        if(checkIn(roomAvail) ){
            occupied = true;
        }else{
            occupied = false;
        }
        return occupied;
    }
//
    public static int checkOut(){
        boolean occupied = false;
        if(){

        }

    }
//
    public static boolean exit(boolean doExit){
        doExit = false;
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Exit");
        System.out.println("====");
        System.out.println("Are you sure you want to exit?");
        System.out.println("All data will be lost.");
        System.out.println("Exit [y/n]: ");
        String exit1 = scan4.nextLine();
        if(exit1.equals("y")){
            doExit = true;
            System.out.println("Goodbye!");
        }
        else if(exit1.equals("n")){
            doExit = false;
            mainMenu();
        }
        return doExit;
    }



    public static void viewRooms(int capsules){
        Random random = new Random();
        capsules = capsuleCount();
        StringBuilder occupant = new StringBuilder();

        for(int i = 0; i < capsules; capsules++){

        }
        return occupant;
    }
}
