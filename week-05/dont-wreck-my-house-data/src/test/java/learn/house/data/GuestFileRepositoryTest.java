package learn.house.data;

import learn.house.models.Guest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestFileRepositoryTest {

//    @Test
//    void findById() {
//    }

    @Test
    void shouldFindAll() {
        GuestFileRepository repository = new GuestFileRepository("./data/.guests.csv");
        List<Guest> all = repository.findAll();
        assertEquals(1, all.size());
    }

//    @Test
//    void findByEmail() {
//    }
}