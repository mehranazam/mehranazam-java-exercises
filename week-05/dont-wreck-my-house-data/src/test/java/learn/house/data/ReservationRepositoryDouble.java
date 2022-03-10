package learn.house.data;

import learn.house.models.Host;
import learn.house.models.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationRepositoryDouble implements ReservationRepository{

    final String id = "498604db-b6d6-4599-a503-3d8190fda823";

    private List<Reservation> reservations = new ArrayList<>();



    public ReservationRepositoryDouble(){
        Reservation reservation = new Reservation();
        reservation.getHost().setHostId(id);
        reservation.setStartDate(LocalDate.of(2022, 10, 6));
        reservation.setEndDate(LocalDate.of(2022, 10, 8));
        reservation.setGuest(ReservationRepositoryDouble.GUEST);
        reservation.setHost(ReservationRepositoryDouble.HOST);
        reservations.add(reservation);
    }


    @Override
    public Reservation add(Reservation reservation) throws DataException {
       reservation.getHost().setHostId(java.util.UUID.randomUUID().toString());
       reservations.add(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> findById(Host id) throws DataException {
        return reservations.stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList());
    }

//    @Override
//    public boolean edit(Reservation editReservation) throws DataException {
//        boolean success = false;
//        reservations = reservations.stream()
//                .map(r -> r.getId() == editReservation.getId() ? editReservation : r)
//                .collect(Collectors.toList());
//
//        return success;
//    }

    @Override
    public boolean deleteById(Host id) throws DataException {
        return false;
    }
}
