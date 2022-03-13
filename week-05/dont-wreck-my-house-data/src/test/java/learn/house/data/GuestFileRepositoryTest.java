package learn.house.data;

import learn.house.models.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestFileRepositoryTest {

    static final String SEED_FILE_PATH = "./reservations/reservation-seed";
    static final String TEST_FILE_PATH = "./reservations/reservation-test/";



    GuestRepository repository = new GuestFileRepository(Paths.get(TEST_FILE_PATH, "guests.csv").toString());




    @BeforeEach
    void setup() throws IOException {
        clearDirectory(TEST_FILE_PATH);


        copyAllFiles(SEED_FILE_PATH, TEST_FILE_PATH);





//        Path seedPath = Paths.get(SEED_FILE_PATH);
//        Path testPath = Paths.get(TEST_FILE_PATH);
//        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

//    @Test
//    void findById() {
//    }

    @Test
    void shouldFindAll() throws DataException {
        GuestFileRepository repository = new GuestFileRepository("./guests.csv");
        List<Guest> all = repository.findAll();
        assertEquals(1, all.size());
    }

    @Test
    void shouldFindByEmail() throws DataException {
        List<Guest> matching = repository.findByEmail("ogecks1@dagondesign.com");

        assertEquals(1, matching.size());
        assertEquals("2", matching.get(1).getId());
        assertEquals("Olympie", matching.get(1).getFirstName());
        assertEquals("Gecks", matching.get(1).getLastName());
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