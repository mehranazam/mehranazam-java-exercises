import hotelmanagement.Guest;
import hotelmanagement.Hotel;
import hotelmanagement.HotelNames;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //gateway for the application...
        String firstName = "Adel";
        String lastName = "Mozip";
        Guest hotelGuest0 = new Guest(firstName, lastName); //  guest with first/last name
        hotelGuest0.setHometown("Ibb"); //
        hotelGuest0.setEmailAddress("amozip@dev-10.com");
        hotelGuest0.setPhoneNum("3134155801");

        Guest hotelGuest1 = new Guest("Roddy", "Ratsirarson"); //  guest with first/last name
        hotelGuest1.setHometown("Albany"); //
        hotelGuest1.setEmailAddress("rratsirarson@dev-10.com");
        hotelGuest1.setPhoneNum("5104568974");

        int hotel18Capacity = 50;
        Guest[] hotelEighteenGuests = new Guest[hotel18Capacity];


        Hotel hotelEighteen = new Hotel(hotel18Capacity, hotelEighteenGuests);

        //check in first guest into the hotel
        //checkIn(hotelGuest0, hotelEighteen);

        //check Roddy
        //checkIn(hotelGuest1, hotelEighteen);
        //check out Adel out of his room
        checkOut(hotelGuest0, hotelEighteen);
        welcome();

        menu(hotel18Capacity, hotelEighteen);
        goodbye();

        int roomNum = 7;
        viewGuests(roomNum, hotelEighteen);

        String[] hotelNames = HotelNames.getHotelNames();

    }

    private static void welcome(){
        System.out.println("Welcome to Hotel 18");
        System.out.println("====================\n");

    }


    public static void menu(){
        while(true){
            System.out.println("\n There are %d unnoccupied capsules to be booked.", capacity);

        }
    }

    public static int guestMenu(){
        while(true){
            System.out.print("Guest Menu\n" +
                    "1. Check in\n" +
                    "2. Check out\n" +
                    "3. View Guests\n" +
                    "4. Exit\n" +
                    "Choose an option [1-4]: ");
            Scanner console = new Scanner(System.in);
            int choice = Integer.parseInt(console.nextLine());
            if(choice > 0 && choice < 5){
                return choice;
            }else{
                System.out.println("Invalid option!");
            }
        }
    }

    private static void viewGuests(int roomNum, Hotel hotelEighteen) {
        //view the room

    }

    private static void checkOut(Hotel hotel) {
        //hotelEighteen.getGuests()[0] = null;
        System.out.println("What room number would you like to check out?");
        Scanner scn = new Scanner(System.in);
        int intendedRoom = Integer.parseInt(scn.nextLine());
        if(hotel.getGuests()[intendedRoom - 1] == null){
            System.out.println("This room is unoccupied.");
            return;
        }
        Guest guest = hotel.getGuests()[intendedRoom - 1];
        guest = null;
        String hotelGuestName = guest.getFirstName() + " " + guest.getLastName();
        hotel.getGuests()[intendedRoom - 1] = null;


    }

    private static void checkIn(Hotel hotel) {
        Guest[] guests = hotel.getGuests();
        System.out.println("Enter capsule number");
        Scanner scn = new Scanner(System.in);
        int intendedRoom = Integer.parseInt(scn.nextLine());
        System.out.println("Guest's first name: ");
        String firstName = scn.nextLine();
        System.out.println("Guest's last name: ");
        String lastName = scn.nextLine();
        Guest guest = new Guest(firstName, lastName);


        if(intendedRoom > hotel.getCapacity() || intendedRoom < 0){
            System.out.println("The room index is out of bounds.");
            return;
        }


        if(guests[intendedRoom] == null){
            System.out.println("What's the guest's phone number?");
            guest.setPhoneNum(scn.nextLine());
            guests[intendedRoom] = guest;
            System.out.println("Successfully checked in " + guest.getFirstName() + " into Hotel 18 Room #" + guest.getRoom() + ".");
            //hotel.getGuests(guests);
        }else{
            System.out.println("Room " + intendedRoom + " is occupied.");
        }
    }

    public static void goodbye(){
        System.out.println("\nGoodbye!");
    }



}
