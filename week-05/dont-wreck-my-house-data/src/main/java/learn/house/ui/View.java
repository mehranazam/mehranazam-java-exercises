package learn.house.ui;

import learn.house.domain.ReservationResult;
import learn.house.models.Guest;
import learn.house.models.Host;
import learn.house.models.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class View {

    private final ConsoleIO io;

    public View(ConsoleIO io) {
        this.io = io;
    }

    public MainMenuOption selectMainMenuOption(){
        displayHeader("Main Menu");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(MainMenuOption option : MainMenuOption.values()){
            if(!option.isHidden()){
                io.printf("%s. %s%n", option.getValue(), option.getMessage());
            }
            min = Math.min(min, option.getValue());
            max = Math.max(max, option.getValue());
        }

        String message = String.format("Select [%s-%s]: ", min, (max - 1));
        return MainMenuOption.fromValue(io.readInt(message, min, max));
    }


    public void displayHeader(String message) {
        io.println("");
        io.println(message);
        io.println("=".repeat(message.length()));
    }


    public void displayException(Exception ex) {
        displayHeader("A critical error occurred:");
        io.println(ex.getMessage());
    }

    public void displayStatus(boolean success, String message) {
        displayStatus(success, List.of(message));
    }

    public void displayStatus(boolean success, List<String> messages) {
        displayHeader(success ? "Success" : "Error");
        for (String message : messages) {
            io.println(message);
        }
    }


    public Guest chooseGuest(List<Guest> guests){
        if(guests.size() == 0){
            io.println("No guests found.");
            return null;
        }

        int index = 1;
        for(Guest g : guests.stream().limit(1000).collect(Collectors.toList())){
            io.printf("%s: %s %s%n", index++, g.getFirstName(), g.getLastName());
        }
        index --;

        if(guests.size() > 1000){
            io.println("More than 1000 guests found. Showing first 1000. Please refine your search.");
        }
        io.println("0: Exit");
        String message = String.format("Select a guest by their index [0-%s]: ", index);

        index = io.readInt(message, 0, index);
        if(index <= 0){
            return null;
        }
        return guests.get(index - 1);
    }


    public Host chooseHost(List<Host> hosts){
        if(hosts.size() == 0){
            io.println("No hosts found.");
            return null;
        }

        int index = 1;
        for(Host h : hosts.stream().limit(1000).collect(Collectors.toList())){
            io.printf("%s: %s %s%n", index++, h.getLastName(), h.getEmailAddress());
        }
        index --;

        if(hosts.size() > 1000){
            io.println("More than 1000 hosts found. Showing first 1000. Please refine your search.");
        }
        io.println("0: Exit");
        String message = String.format("Select a host by their index [0-%s]: ", index);

        index = io.readInt(message, 0, index);
        if(index <= 0){
            return null;
        }
        return hosts.get(index - 1);
    }

    public Reservation makeReservation(Host host){
        Reservation reservation = new Reservation();
        reservation.setHost(host);
        reservation.setStartDate(io.readLocalDate("Reservation start date [MM/dd/yyyy]: "));
        reservation.setEndDate(io.readLocalDate("Reservation end date [MM/dd/yyyy]: "));
        return reservation;
    }

    public Reservation changeReservation(Host host, Guest guest){
        Reservation reservation = new Reservation();

           String input = io.readRequiredString("Host email: ");
            host.getEmailAddress();
            if(input.trim().length() > 0){
                reservation.setStartDate(io.readLocalDate("Reservation start date [MM/dd/yyyy]: "));
                reservation.setEndDate(io.readLocalDate("Reservation end date [MM/dd/yyyy]: "));
            }
        return reservation;
    }

    public Reservation cancelReservation(Host host, Guest guest){
        Reservation reservation = new Reservation();
        String input = io.readRequiredString("Reservation to delete: ");
        reservation.setId(input);
                return reservation;
    }

    public void enterToContinue() {
        io.readString("Press [Enter] to continue.");
    }

    public void displayReservations(List<Reservation> reservations){
        if(reservations == null || reservations.isEmpty()){
            io.println("No reservations found.");
            return;
        }
        for(Reservation r : reservations){
            io.printf("ID: %s, %s - %s, Guest: %s, %s, Email: %s%n",
                    r.getId(),
                    r.getStartDate(),
                    r.getEndDate(),
                    r.getGuest().getLastName(),
                    r.getGuest().getFirstName(),
                    r.getGuest().getEmailAddress()
            );
        }
    }

    public Guest makeGuest(){
        Guest guest = new Guest();
        guest.setFirstName(io.readRequiredString("First name of guest: "));
        guest.setLastName(io.readRequiredString("Last name of guest: "));
        guest.setEmailAddress(io.readRequiredString("Email address of guest: "));
        return guest;

    }

    public String getGuestNamePrefix() {
        return io.readRequiredString("Guest last name starts with: ");
    }

    public String getHostNamePrefix() {
        return io.readRequiredString("Host last name starts with: ");
    }


    public String getGuestEmailPrefix() {
        return io.readRequiredString("Guest email address starts with: ");
    }

    public String getHostEmailPrefix() {
        return io.readRequiredString("Host email address starts with: ");
    }
}
