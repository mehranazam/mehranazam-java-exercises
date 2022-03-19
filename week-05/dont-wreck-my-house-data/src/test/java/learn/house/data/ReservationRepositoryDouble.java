package learn.house.data;

import learn.house.domain.ReservationResult;
import learn.house.models.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationRepositoryDouble implements ReservationRepository{

    final String id = "498604db-b6d6-4599-a503-3d8190fda823";

    private ReservationResult<Reservation> reservations = new ReservationResult<>();

    private List<Reservation> reservationList = new ArrayList<>();



    public ReservationRepositoryDouble(){
        Reservation reservation = new Reservation();
        reservation.getHost().setId(id);
        reservation.setStartDate(LocalDate.of(2022, 10, 6));
        reservation.setEndDate(LocalDate.of(2022, 10, 8));

        reservationList.add(reservation);
    }


    @Override
    public ReservationResult<Reservation> add(Reservation reservation) throws DataException {
       reservation.getHost().setId(java.util.UUID.randomUUID().toString());
       reservationList.add(reservation);
        return reservations;
    }

    @Override
    public List<Reservation> findAll() throws DataException {
        return new ArrayList<Reservation>();
    }

    @Override
    public Reservation findById(String id) throws DataException {
        return reservationList.stream()
                .filter(i -> i.getId().equals(id))
                .findAny().orElse(null);
    }

    @Override
    public ReservationResult<Reservation> edit(Reservation editReservation) throws DataException {
        ReservationResult<Reservation> success = new ReservationResult<>();

        List <Reservation> allReservations = findAll();

        for(int i = 0; i < allReservations.size(); i++){
            Reservation toCheck = allReservations.get(i);
            if(toCheck.getId().equals(editReservation.getId())){
                allReservations.set(i, editReservation);
                success.setPayload(toCheck);
                break;
            }
        }
        return success;
    }

    @Override
    public ReservationResult<Reservation> deleteById(String id) throws DataException {
        ReservationResult<Reservation> success = new ReservationResult<>();
        List<Reservation> all = findAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId().equals(id)){
                all.remove(i);

                success.setPayload(all.get(i));
            }
        }
        return success;
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


}
