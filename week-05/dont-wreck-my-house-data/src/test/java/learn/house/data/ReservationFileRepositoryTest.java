package learn.house.data;

import learn.house.models.Guest;
import learn.house.models.Host;
import learn.house.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

class ReservationFileRepositoryTest {

    static final String SEED_FILE_PATH = "./reservations/reservation-seed.csv";
    static final String TEST_FILE_PATH = "./reservations/reservation-test.csv";



    ReservationFileRepository repository = new ReservationFileRepository(TEST_FILE_PATH);


    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldAdd() throws DataException {
        Reservation reservation = new Reservation();
//        reservation.setId();
        reservation.setStartDate(LocalDate.of(2022, 10, 6));
        reservation.setEndDate(LocalDate.of(2022, 10, 8));

        Guest guest = new Guest();
        guest.setId("10");
        guest.setFirstName("Mark");
        guest.setLastName("Stevens");
        guest.setEmailAddress("mstevens@gmail.com");

        Host host = new Host();
        host.setHostId();
        host.setEmailAddress("tjolie@optonline.net");
        host.setLocation("Joshua Tree");
        host.setStandardRate(BigDecimal.valueOf(50));
        host.setWeekendRate(BigDecimal.valueOf(200));
        host.setTotal(BigDecimal.valueOf(1200));

        reservation = repository.add(reservation);
    }

    @Test
    void shouldFindById() {
        List<Reservation> reservations = repository.findById();
        assertEquals(, reservations.size());

    }

    @Test
    void edit() {

    }

    @Test
    void deleteById() {
    }
}