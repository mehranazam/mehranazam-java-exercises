package learn.house.domain;

import learn.house.data.*;
import learn.house.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationServiceTest {

    ReservationService service;

    @BeforeEach
    void setup(){
        ReservationRepositoryDouble reservationRepositoryDouble = new ReservationRepositoryDouble();
        GuestRepositoryDouble guestRepositoryDouble = new GuestRepositoryDouble();
        HostRepositoryDouble hostRepositoryDouble = new HostRepositoryDouble();
        service = new ReservationService(reservationRepositoryDouble, guestRepositoryDouble, hostRepositoryDouble);
    }

    @Test
    void shouldUpdate() throws DataException {
        Reservation reservation = new Reservation();

        reservation.setStartDate(LocalDate.of(2021, 4, 30));
        reservation.setEndDate(LocalDate.of(2021, 5, 30));
        ReservationResult result = service.edit(reservation);
        assertTrue(result.isSuccess());
    }


}
