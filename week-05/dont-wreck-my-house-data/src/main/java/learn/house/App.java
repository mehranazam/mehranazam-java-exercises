package learn.house;

import learn.house.data.GuestFileRepository;
import learn.house.data.HostFileRepository;
import learn.house.data.ReservationFileRepository;
import learn.house.domain.GuestService;
import learn.house.domain.HostService;
import learn.house.domain.ReservationService;
import learn.house.models.Guest;
import learn.house.ui.ConsoleIO;
import learn.house.ui.Controller;
import learn.house.ui.View;

public class App {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        View view = new View(io);

        ReservationFileRepository reservationFileRepository = new ReservationFileRepository("./reservations");
        GuestFileRepository guestFileRepository = new GuestFileRepository("./guests.csv");
        HostFileRepository hostFileRepository = new HostFileRepository("./hosts.csv");

        GuestService guestService = new GuestService(guestFileRepository);
        ReservationService reservationService = new ReservationService(reservationFileRepository, guestFileRepository, hostFileRepository);
        HostService hostService = new HostService(hostFileRepository);

        Controller controller = new Controller(guestService, reservationService, hostService, view);
        controller.run();
    }
}
