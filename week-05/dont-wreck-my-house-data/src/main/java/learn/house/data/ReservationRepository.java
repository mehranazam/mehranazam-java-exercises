package learn.house.data;

import learn.house.domain.ReservationResult;
import learn.house.models.Reservation;

public interface ReservationRepository {

        ReservationResult<Reservation> add(Reservation reservation) throws DataException;

     //   List<Reservation> findAll() throws DataException;

        Reservation findById(String id) throws DataException;

        ReservationResult<Reservation> edit(Reservation editReservation) throws DataException;

        ReservationResult<Reservation> deleteById(String id)throws DataException;
}
