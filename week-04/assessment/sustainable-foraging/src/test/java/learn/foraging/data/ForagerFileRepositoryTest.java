package learn.foraging.data;

import learn.foraging.models.Forager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForagerFileRepositoryTest {

    static final String SEED_PATH = "./data/foragers-seed.txt";
    static final String TEST_PATH = "./data/foragers-test.txt";


    ForagerRepository repository = new ForagerFileRepository(TEST_PATH);


    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_PATH);
        Path testPath = Paths.get(TEST_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindAll() {
        List<Forager> expected = new ArrayList<>();
        expected.add(new Forager("0e4707f4-407e-4ec9-9665-baca0aabe88c","Jilly","Sisse","GA"));
        expected.add(new Forager("0ffc0532-8976-4859-af6e-fedbe192fca7","Darby","Domerc","CT"));
        expected.add(new Forager("2ca7c3e5-2c97-4e93-83f4-6645ceed4a38","Gav","Snowdon","NV"));
        expected.add(new Forager( "7b7a7611-7a16-418b-b022-0553738a4ce1","Bev","Osgood","KY"));
        expected.add(new Forager( "7f47325f-8c02-4fca-a4a4-c56d737ffadc","Pearl","Kahen","OH"));

        List<Forager> actual = repository.findAll();
        assertEquals(5, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindById(){
        Forager expected = new Forager("0e4707f4-407e-4ec9-9665-baca0aabe88c","Jilly","Sisse","GA");
        Forager actual = repository.findById("0e4707f4-407e-4ec9-9665-baca0aabe88c");

        assertEquals(expected, actual);

    }


    @Test
    void shouldFindByState(){
        List<Forager> expected = new ArrayList<>();
        expected.add(new Forager("0e4707f4-407e-4ec9-9665-baca0aabe88c","Jilly","Sisse","GA"));
        List<Forager> actual = repository.findByState("GA");

        assertEquals(expected, actual);
    }



    @Test
    void shouldNotFindNonexistentState(){
        List<Forager> expected = new ArrayList<>();
        List<Forager> actual = repository.findByState("HJ");


        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindNonexistentId(){
        Forager actual = repository.findById("sdkfjblskadfuwliaefha;igufaildsuf");

        assertNull(actual);
    }

    @Test
    void shouldAdd() throws DataException {
        Forager forager = new Forager();
//        forager.setId();
        forager.setFirstName("Steve");
        forager.setLastName("Miller");
        forager.setState("CO");

        Forager actual = repository.add(forager);
       // assertEquals(19, forager.getId().length());

        assertNotNull(actual.getId());

        assertEquals("Steve", actual.getFirstName());
        assertEquals("Miller", actual.getLastName());
        assertEquals("CO", actual.getState());
        assertEquals(6, repository.findAll().size());
    }


}