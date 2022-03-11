package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForagerRepositoryDouble;
import learn.foraging.models.Forager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForagerServiceTest {

    ForagerService foragerService = new ForagerService(new ForagerRepositoryDouble());

    static Forager forager;


    @BeforeAll
    static void setup(){
        forager = new Forager();
        forager.setId("0e4707f4-407e-4ec9-9665-baca0aabe88c");
        forager.setFirstName("Jilly");
        forager.setLastName("Sisse");
        forager.setState("GA");
    }

    @Test
    void findByState() {
       List<Forager> expected = new ArrayList<>();
       expected.add(forager);

       List<Forager> actual = foragerService.findByState("GA");

       assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindNonexistentState(){
        List<Forager> expected = new ArrayList<>();

        List<Forager> actual = foragerService.findByState("HJ");
        assertEquals(expected, actual);
    }

    @Test
    void findByLastName() {
        List<Forager> expected = new ArrayList<>();
        expected.add(forager);

        List<Forager> actual = foragerService.findByLastName("Sisse");
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindNonexistentName(){
        List<Forager> expected = new ArrayList<>();

        List<Forager> actual = foragerService.findByLastName("xtl");
        assertEquals(expected, actual);
    }

    @Test
    void add() throws DataException {
        Result<Forager> expected = new Result<>();
        expected.setPayload(new Forager("111222333444","Jasmin","Common","CT"));

        Result<Forager> actual = foragerService.add(new Forager(null, "Jasmin","Common","CT"));

        assertEquals(expected, actual);
    }


    @Test
    void shouldNotAddNull() throws DataException {
        Result<Forager> expected = makeResult("forager cannot be null");

        Result<Forager> actual = foragerService.add(null);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddBlankFirstName() throws DataException {
        Result<Forager> expected = makeResult("First name is required");

        Result<Forager> actual = foragerService.add(new Forager(null, "", "Azam", "NJ"));
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddBlankLastName() throws DataException {
        Result<Forager> expected = makeResult("Last name is required");

        Result<Forager> actual = foragerService.add(new Forager(null, "Mehran", "", "NJ"));
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddBlankState() throws DataException {
        Result<Forager> expected = makeResult("State is required");

        Result<Forager> actual = foragerService.add(new Forager(null, "Mehran", "Azam", ""));
        assertEquals(expected, actual);
    }


    @Test
    void shouldNotAddDuplicates() throws DataException {
        Result<Forager> expected = makeResult("duplicate forager is not allowed");

        Result<Forager> actual = foragerService.add(new Forager(null, "Jilly", "Sisse", "GA"));

        assertEquals(expected, actual);
    }





    private Result<Forager> makeResult(String message){
        Result<Forager> result = new Result<>();
        result.addErrorMessage(message);

        return result;


    }
}