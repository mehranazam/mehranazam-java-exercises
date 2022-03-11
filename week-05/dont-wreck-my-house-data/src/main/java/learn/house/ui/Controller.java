package learn.house.ui;

import learn.house.data.DataException;
import learn.house.domain.GuestService;
import learn.house.domain.HostService;
import learn.house.domain.ReservationService;

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

    private void runAppLoop(){
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
                    viewReservations();
                    break;
            }
        }while(option != MainMenuOption.EXIT);
    }

    private void viewReservations(){

    }

}
