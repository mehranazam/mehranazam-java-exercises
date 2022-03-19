package learn.house.data;

import learn.house.models.Host;
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

class HostFileRepositoryTest {

    static final String SEED_FILE_PATH = "./reservations/reservation-seed/";
    static final String TEST_FILE_PATH = "./reservations/reservation-test/";



    HostRepository repository = new HostFileRepository(Paths.get(TEST_FILE_PATH, "hosts.csv").toString());


    @BeforeEach
    void setup() throws IOException {
        clearDirectory(TEST_FILE_PATH);


        copyAllFiles(SEED_FILE_PATH, TEST_FILE_PATH);





//        Path seedPath = Paths.get(SEED_FILE_PATH);
//        Path testPath = Paths.get(TEST_FILE_PATH);
//        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }


    @Test
    void shouldFindById() throws DataException {
        Host host = repository.findById("3edda6bc-ab95-49a8-8962-d50b53f84b15");
        assertNotNull(host);
    }

    @Test
    void shouldFindAll() throws DataException {
        List<Host> actual = repository.findAll();
        assertEquals(1000, actual.size());
    }

    @Test
    void shouldFindByEmail() throws DataException {
        List<Host> hosts = repository.findByEmail("eyearnes0@sfgate.com");
        assertNotNull(hosts);
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