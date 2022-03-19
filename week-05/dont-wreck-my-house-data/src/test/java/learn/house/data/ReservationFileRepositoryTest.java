package learn.house.data;

import static org.junit.jupiter.api.Assertions.*;

import learn.house.domain.ReservationResult;
import learn.house.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.function.BooleanSupplier;

class ReservationFileRepositoryTest {

    static final String SEED_FILE_PATH = "./reservations/reservation-seed";
    static final String TEST_FILE_PATH = "./reservations/reservation-test";



    ReservationRepository repository = new ReservationFileRepository(Paths.get(TEST_FILE_PATH, "reservation.csv").toString());


    @BeforeEach
    public void setup() throws IOException {
       clearDirectory(TEST_FILE_PATH);


       copyAllFiles(SEED_FILE_PATH, TEST_FILE_PATH);





//        Path seedPath = Paths.get(SEED_FILE_PATH);
//        Path testPath = Paths.get(TEST_FILE_PATH);
//        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindAll() throws DataException {
        List<Reservation> actual = repository.findAll();
        assertEquals(1000, actual.size());
    }

    @Test
    void shouldAdd() throws DataException {
        Reservation reservation = new Reservation();
        reservation.setId("13");
        reservation.setStartDate(LocalDate.of(2022, 10, 6));
        reservation.setEndDate(LocalDate.of(2022, 10, 8));
        reservation.getGuest().getId();

//        Guest guest = new Guest();
//        guest.setId("1001");
//        guest.setFirstName("Mark");
//        guest.setLastName("Stevens");
//        guest.setEmailAddress("mstevens@gmail.com");
//
//        Host host = new Host();
//        host.setId();
//        host.setEmailAddress("tjolie@optonline.net");
//        host.setCity("Joshua Tree");
//        host.setStandardRate(BigDecimal.valueOf(50));
//        host.setWeekendRate(BigDecimal.valueOf(200));
//        host.setTotal(BigDecimal.valueOf(1200));

        ReservationResult<Reservation> actual = repository.add(reservation);
        assertEquals("13", actual.getPayload());
    }

    @Test
    void shouldFindById() throws DataException {
        Reservation reservation = repository.findById("1");



//        assertEquals(java.util.UUID.randomUUID().toString());

    }

    @Test
    void edit() throws DataException {
        Reservation reservation = repository.findById("1");
        reservation.setStartDate(LocalDate.of(2021, 4, 30));
        reservation.setEndDate(LocalDate.of(2021, 5, 30));
        assertTrue((BooleanSupplier) repository.edit(reservation));
        assertNotNull(reservation);
    }

    @Test
    void deleteById() throws DataException {
        int count = repository.findAll().size();
        assertTrue((BooleanSupplier) repository.deleteById("13"));


    }


    private void clearDirectory(String dir){
        File testDir = new File(dir);

        File[] filesUnderTestDir = testDir.listFiles();

        for(File toDelete : filesUnderTestDir){
            if(toDelete.isFile()){
                toDelete.delete();
            }else{
                clearDirectory(toDelete.getAbsolutePath());
            }
        }
    }

    private void copyAllFiles(String fromDir, String toDir) throws IOException {
        File seedDir = new File(fromDir);

        File[] seedFiles = seedDir.listFiles();

        for(File toCopy : seedFiles){
            Path newPath = Paths.get(toDir, toCopy.getName());
            if(toCopy.isFile()){

                Files.copy(toCopy.toPath(), newPath, StandardCopyOption.REPLACE_EXISTING);
            }else{
                copyAllFiles(toCopy.getAbsolutePath(), newPath.toString());
            }
        }
    }
}