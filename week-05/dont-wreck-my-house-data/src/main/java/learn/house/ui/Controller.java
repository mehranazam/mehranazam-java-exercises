package learn.house.ui;

import learn.house.data.DataException;
import learn.house.domain.GuestService;
import learn.house.domain.HostService;
import learn.house.domain.ReservationResult;
import learn.house.domain.ReservationService;
import learn.house.models.Guest;
import learn.house.models.Host;
import learn.house.models.Reservation;

import java.util.List;

public class Controller {

    private final GuestService guestService;
    private final ReservationService reservationService;
    private final HostService hostService;
    private final View view;

    public Controller(GuestService guestService, ReservationService reservationService, HostService hostService, View view) {
        this.guestService = guestService;
        this.reservationService = reservationService;
        this.hostService = hostService;
        this.view = view;
    }

    public void run(){
        view.displayHeader("Welcome to 'Don't Wreck My House'");
        try{
            runAppLoop();
        }catch(DataException ex){
            view.displayException(ex);
        }
        view.displayHeader("Goodbye.");
    }

    private void runAppLoop() throws DataException {
        MainMenuOption option;
        do{
            option = view.selectMainMenuOption();
            switch(option){
                case MAKE_RESERVATION:
                    addReservation();
                    break;
                case CANCEL_RESERVATION:
                    deleteReservation();
                    break;
                case EDIT_RESERVATION:
                    editReservation();
                    break;
                case VIEW_RESERVATIONS_BY_HOST:
                    viewReservationsByHost();
                    break;
            }
        }while(option != MainMenuOption.EXIT);
    }

    private void editReservation() throws DataException {
        view.displayHeader(MainMenuOption.EDIT_RESERVATION.getMessage());
        Host host = getHost();
        Guest guest = getGuest();
        if(host == null){
            return;
        }
        if(guest == null){
            return;
        }
        Reservation reservation = view.changeReservation(host, guest);
        ReservationResult<Reservation> result = reservationService.edit(reservation);
        if(!result.isSuccess()){
            view.displayStatus(false, result.getErrorMessages());
        }else{
            String successMessage = String.format("Reservation %s edited.", result.getPayload().getId());
            view.displayStatus(true, successMessage);
        }
    }

    private void deleteReservation() throws DataException {
        view.displayHeader(MainMenuOption.CANCEL_RESERVATION.getMessage());
        Host host = getHost();
        Guest guest = getGuest();
        if(host == null){
            return;
        }
        if(guest == null){
            return;
        }
        Reservation reservation = view.cancelReservation(host, guest);
        ReservationResult<Reservation> result = reservationService.delete(reservation);
        if(!result.isSuccess()){
            view.displayStatus(false, result.getErrorMessages());
        }else{
            String successMessage = String.format("Reservation %s deleted.", result.getPayload().getId());
            view.displayStatus(true, successMessage);
        }
    }

    private void addReservation() throws DataException {
        view.displayHeader(MainMenuOption.MAKE_RESERVATION.getMessage());
        Host host = getHost();
        if(host == null){
            return;
        }
        Guest guest = getGuest();
        if(guest == null){
            return;
        }
        Reservation reservation = view.makeReservation(host);
        ReservationResult<Reservation> result = reservationService.add(reservation);
        if(!result.isSuccess()){
            view.displayStatus(false, result.getErrorMessages());
        }else{
            String successMessage = String.format("Reservation %s created.", result.getPayload().getId());
            view.displayStatus(true, successMessage);
        }
    }

    private void viewReservationsByHost(){

    }

    private Guest getGuest() throws DataException {
        String emailPrefix = view.getGuestEmailPrefix();
        List<Guest> guests = guestService.findByEmail(emailPrefix);
        return view.chooseGuest(guests);
    }

    private Host getHost() throws DataException {
        String emailPrefix = view.getHostEmailPrefix();
        List<Host> hosts = hostService.findByEmail(emailPrefix);
        return view.chooseHost(hosts);
    }

}
