import java.util.Random;
import java.util.Scanner;
public class HotelApp {

    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to Hotel 69.");
        System.out.println("=====================");
        int capsules = 0;
//        int roomAvail = 0;

        capsules = capsuleCount();

        String[] capsulesArray = new String[capsules];
        System.out.println("There are " + capsules + " unoccupied capsules ready to be booked.");



     // int choice = Integer.parseInt(mainMenu());



      int num = Integer.MIN_VALUE;

      boolean isFinished = false;

//            switch (choice) {
//                case 1:
//                    checkIn(capsules, capsulesArray);
//                  //  choice = 0;
//                    break;
//                case 2:
//                  //  checkOut(capsulesArray);
//                  //  choice = 0;
//                    break;
//                case 3:
//                    viewRooms(capsulesArray);
//                   // choice = 0;
//                    break;
//                case 4:
//                    isFinished = exit();
//                   // choice = 0;
//                    break;
//                case 0:
//                    break;
//                default:
//                    System.out.println("Unknown action");
//                    mainMenu();
//            }

//        System.out.println("Guest Menu");
//        System.out.println("====================");
//        System.out.println("1. Check in");
//        System.out.println("2. Check out");
//        System.out.println("3. View Guests");
//        System.out.println("4. Exit");
//        System.out.println("Choose an option [1-4]: ");
//        int choice = scn.nextInt();
int choice;


       do {
           choice = mainMenu();
            if(choice == 1){
                checkIn(capsules, capsulesArray);
            }else if(choice == 2){
                  checkOut(capsules, capsulesArray);
            }
            else if(choice == 3){
                viewRooms(capsulesArray);
            }else if(choice == 4){
                isFinished = exit();
            }
     }while (!isFinished);


    }

    //  private static Random rng = new Random();

    public static int capsuleCount() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("How many capsules are there?");
        String count = scan1.nextLine();

       int userInt = Integer.parseInt(count);

        return userInt;
    }


    public static int mainMenu() {

        System.out.println("Guest Menu");
        System.out.println("====================");
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. View Guests");
        System.out.println("4. Exit");
        System.out.println("Choose an option [1-4]: ");

        Scanner scan1 = new Scanner(System.in);

        return scan1.nextInt();


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

    public static String name() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Guest's name: ");
        String guestName = scan2.nextLine();

        return guestName;
    }


    public static void checkIn(int numCapsules, String[] capsulesArray) {
        int chosenRoom = 0;
        Scanner scan3 = new Scanner(System.in);
        String guestName = "";
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Guest Check In");
        System.out.println("===============");
        System.out.println("Guest Name: " + guestName);
        guestName = scan4.nextLine();
//        System.out.println("Capsule #[1-" + numCapsules + "]:  ");
//        System.out.println("Please choose a room: ");
       // int chosenRoom = scan3.nextInt();
       // isRoomAvailable(chosenRoom, capsulesArray);
        boolean validInput = false;
        while(!validInput) {
            System.out.println("Capsule #[1-" + numCapsules + "]:  ");
            System.out.println("Please choose a room: ");
            chosenRoom = scan3.nextInt();
            //   System.out.println("Please choose a room: ");
            if (chosenRoom <= 0 || chosenRoom >= capsulesArray.length) {
                System.out.println("Not in range. Try again.");
            } else {
                if (capsulesArray[chosenRoom] != null) {
                    System.out.println("Room is occupied. Try again!");
                    System.out.println("Please choose a room: ");
                    chosenRoom = scan3.nextInt();

                } else {
                    validInput = true;
                }
            }
//             else {
//                System.out.println("Error! Try again.");
//                chosenRoom = scan3.nextInt();
//            }
        }
        capsulesArray[chosenRoom] = guestName;
        System.out.println("Success! " + guestName + " has booked room #" + chosenRoom + ".");
    }


//    public static boolean isRoomAvailable(int chosenRoom, String[] capsulesArray) {
//        if (capsulesArray[chosenRoom - 1] == null) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }







//        boolean occupied = true;
//
//        if(checkIn(roomAvail) ){
//            occupied = true;
//       }else{
//            occupied = false;
//        }
//        do {
//            for (int i = 0; i < capsulesArray.length; i++) {
//                if (capsulesArray[i] != null) {
//                    System.out.println("Error. This room is occupied.");
//                } else {
//                    System.out.println("Success :) \n" + name() + " is booked in capsule # " + (i));
//                    occupied = false;
//                }
//            }
//
//
//        } while (occupied);

       // return occupied;
  //  }
//
        public static void checkOut(int numCapsules, String[] capsulesArray) {

            int chosenRoom = 0;
            Scanner scan5 = new Scanner(System.in);
            //String guestName = "";
            //Scanner scan6 = new Scanner(System.in);
            System.out.println("Guest Check Out");
            System.out.println("===============");
//            System.out.println("Guest Name: " + guestName);
//            guestName = scan6.nextLine();
//        System.out.println("Capsule #[1-" + numCapsules + "]:  ");
//        System.out.println("Please choose a room: ");
            // int chosenRoom = scan3.nextInt();
            // isRoomAvailable(chosenRoom, capsulesArray);
            boolean validInput = false;
            while(!validInput) {
                System.out.println("Capsule #[1-" + numCapsules + "]:  ");
                System.out.println("Please choose a room: ");
                chosenRoom = scan5.nextInt();
                //   System.out.println("Please choose a room: ");
                if (chosenRoom <= 0 || chosenRoom >= capsulesArray.length) {
                    System.out.println("Not in range. Try again.");
                } else {
                    if (capsulesArray[chosenRoom] == null) {
                        System.out.println("Room is unoccupied. Try again!");
                        System.out.println("Please choose a room: ");
                        chosenRoom = scan5.nextInt();

                    } else {
                        validInput = true;
                    }
                }
//             else {
//                System.out.println("Error! Try again.");
//                chosenRoom = scan3.nextInt();1
//            }
            }
            System.out.println("Success! " + capsulesArray[chosenRoom] + " has checked out of room #" + chosenRoom + ".");
            capsulesArray[chosenRoom] = null;

        }



//
    public static boolean exit(){
        boolean doExit = false;
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Exit");
        System.out.println("====");
        System.out.println("Are you sure you want to exit?");
        System.out.println("All data will be lost.");
        System.out.println("Exit [y/n]: ");
        String exit1 = scan4.nextLine();

        if (exit1.equals("y")) {
            doExit = true;
            System.out.println("Goodbye!");

        }

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
        System.out.println("Capsule #[1-" + capsuleArray.length + "]:  " + " ");
        System.out.println("Please choose a room: ");
        int capsuleNumber = Integer.parseInt(scan4.nextLine());
        int max = capsuleNumber + 6;
        int min = capsuleNumber - 5;




        for(int i = min; i < max; i++){
            int safeIndex = i;

            if(max > capsuleArray.length){
                safeIndex = i % capsuleArray.length;
            }else if(i < 0){
                safeIndex += capsuleArray.length;
            }
//            if(capsuleArray[i] == null){
//                //System.out.println("Unoccupied.");
//                guestName = "Unoccupied.";
//            }

            guestName = capsuleArray[safeIndex];


            if(guestName == null) {
                guestName = "[Unoccupied]";
            }

            System.out.println((safeIndex) + ": " + guestName);

        }
//        return;
    }


//    public static String replaceNull(String input) {
//        return input == null ? "Unoccupied" : input;
//    }
}
