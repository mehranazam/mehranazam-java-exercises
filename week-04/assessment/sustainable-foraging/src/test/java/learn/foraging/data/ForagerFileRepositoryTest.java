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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForagerFileRepositoryTest {

    static final String SEED_PATH = "./data/foragers-seed.txt";
    static final String TEST_PATH = "./data/foragers-test.txt";

    static final int FORAGE_COUNT = 54;

    final LocalDate date = LocalDate.of(2020, 6, 26);

    ForagerFileRepository repository = new ForagerFileRepository(TEST_PATH);


    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_PATH);
        Path testPath = Paths.get(TEST_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindAll() {
        ForagerFileRepository repo = new ForagerFileRepository("./data/foragers.csv");
        List<Forager> all = repo.findAll();
        assertEquals(1000, all.size());
    }

    @Test
    void shouldAdd() throws DataException {
        Forager forager = new Forager();
        forager.setId("AAAA-1111-2222-3333");
        forager.setFirstName("Steve");
        forager.setLastName("Miller");
        forager.setState("Colorado");

        forager = repository.add(forager);
        assertEquals(19, forager.getId().length());
    }
}