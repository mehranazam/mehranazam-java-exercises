package learn.house.data;

import learn.house.models.Host;
import learn.house.models.Reservation;

import java.util.List;

public interface ReservationRepository {

        Reservation add(Reservation reservation) throws DataException;

     //   List<Reservation> findAll() throws DataException;

        List<Reservation> findById(Host id) throws DataException;

        boolean edit(Reservation editReservation) throws DataException;

        boolean deleteById(Host id)throws DataException;
}
