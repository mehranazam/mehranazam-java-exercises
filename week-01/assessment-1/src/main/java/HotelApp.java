import java.util.Random;
import java.util.Scanner;
public class HotelApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel 69.");
        System.out.println("=====================");
        int capsules = 0;
//        int roomAvail = 0;

        capsules = capsuleCount();
        boolean doExit = false;
        String[] capsulesArray = new String[capsules];
        System.out.println("There are " + capsules + " unoccupied capsules ready to be booked.");

        mainMenu();

        int choice = Integer.MIN_VALUE;
        Scanner scan1 = new Scanner(System.in);

        choice = scan1.nextInt();
        do {
            switch (choice) {
                case 1:
                    checkIn(capsules, capsulesArray);
                    break;
                case 2:
                    checkOut(capsulesArray);
                    break;
                case 3:
                    viewRooms(capsulesArray);
                    break;
                case 4:
                    exit(doExit);
                    break;
                default:
                    System.out.println("Unknown action");
                    choice = scan1.nextInt();
            }

        }while (!(choice == 4));






    }

  //  private static Random rng = new Random();

    public static int capsuleCount (){
        Scanner scan1 = new Scanner(System.in);
        System.out.print("How many capsules are there?");
        String count = scan1.nextLine();

        int userInt = Integer.MIN_VALUE;

        userInt = Integer.parseInt(count);

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

//    public static int getIntInRange(){
//
//        int choice = Integer.MIN_VALUE;
//        Scanner scan1 = new Scanner(System.in);
//
//        choice = scan1.nextInt();
//        do {
//            switch (choice) {
//                case 1:
//                    checkIn();
//                    break;
//                case 2:
//                    checkOut();
//                    break;
//                case 3:
//                    viewRooms();
//                    break;
//                case 4:
//                    exit();
//                    break;
//                default:
//                    System.out.println("Unknown action");
//                    choice = scan1.nextInt();
//            }
//            while (!(choice == 4)) ;
//
//        }
//        return choice;
//
//        }

    public static String name(){
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Guest's name: ");
        String guestName = scan2.nextLine();

        return guestName;
            }
//
    public static int checkIn(int numCapsules, String[] capsulesArray){
        Scanner scan3 = new Scanner(System.in);
        String guestName = "";
        System.out.println("Guest Check In");
        System.out.println("===============");
        System.out.println("Guest Name: " + name());
        System.out.print("Capsule #[1-" + numCapsules + ")]:  " + " ");
        System.out.println("Please choose a room: ");
        int chosenRoom = scan3.nextInt();
        isRoomAvailable(chosenRoom, capsulesArray);

       return chosenRoom;
    }

    public static boolean isRoomAvailable(int roomAvail, String[] capsulesArray){
        boolean occupied = false;
//        roomAvail = 0;

//        if(checkIn(roomAvail) ){
//            occupied = true;
//        }else{
//            occupied = false;
//        }
        do {
            for(int i = 0; i < capsulesArray.length; i++){
                if(capsulesArray[i] != null){
                    System.out.println("Error. This room is occupied.");
                }else{
                    System.out.println("Success :) \n " + name() + " is booked in capsule#" + i);
                }
            }

        }while(occupied);

        return occupied;
    }
//
    public static int checkOut(String[] capsulesArray){
        boolean occupied = false;
        Scanner scan3 = new Scanner(System.in);
        String guestName = "";
        System.out.println("Guest Check Out");
        System.out.println("===============");
        System.out.print("Capsule #[1-" + capsuleCount() + ")]:  " + " ");
        int roomOccupied = scan3.nextInt();
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
        do {
            if (exit1.equals("y")) {
                doExit = true;
                System.out.println("Goodbye!");
            } else if (exit1.equals("n")) {
                doExit = false;
                mainMenu();
            }
        }while(!(exit1.equals("n")));
        return doExit;
    }



    public static void viewRooms(String[] capsuleArray){
        Scanner scan4 = new Scanner(System.in);
//        Random random = new Random();
//        capsules = capsuleCount();
//        StringBuilder occupant = new StringBuilder();

        String guestName = "";
        System.out.println("View Guests");
        System.out.println("============");
        System.out.println("Capsule #[1-" + capsuleCount() + ")]:  " + " ");
        int capsuleNumber = Integer.parseInt(scan4.nextLine());
        int max = capsuleNumber + 6;
        int min = capsuleNumber - 5;

        for(int i = min; i < max; i++){
            if(max > capsuleArray.length){
                i = max % capsuleArray.length;
            }else if(i < 0){

            }
            guestName = capsuleArray[i];
            System.out.println(i + ": " + guestName);
        }
        return;
    }
}
