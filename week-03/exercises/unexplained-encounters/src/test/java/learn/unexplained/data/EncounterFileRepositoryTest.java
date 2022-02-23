package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {

    static final String TEST_PATH = "./data/encounters-test.csv";
    final Encounter[] testEncounters = new Encounter[]{
            new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 1),
            new Encounter(2, EncounterType.CREATURE, "2020-02-01", "short test #2", 1),
            new Encounter(3, EncounterType.SOUND, "2020-03-01", "short test #3", 1),
            new Encounter(4, EncounterType.UFO, "2022-02-22", "some ufos showed up to class", 24)
    };

    EncounterRepository repository = new EncounterFileRepository(TEST_PATH);

    @BeforeEach
    void setup() throws DataAccessException {
        for (Encounter e : repository.findAll()) {
            repository.deleteById(e.getEncounterId());
        }

        for (Encounter e : testEncounters) {
            repository.add(e);
        }
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<Encounter> encounters = repository.findAll();
        Encounter[] actual = encounters.toArray(new Encounter[encounters.size()]);
        assertArrayEquals(testEncounters, actual);
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter();
        encounter.setType(EncounterType.UFO);
        encounter.setWhen("Jan 15, 2005");
        encounter.setDescription("moving pinpoint of light." +
                "seemed to move with me along the highway. " +
                "then suddenly reversed direction without slowing down. it just reversed.");
        encounter.setOccurrences(1);

        Encounter actual = repository.add(encounter);

        assertNotNull(actual);
        assertEquals(5, actual.getEncounterId());
    }

    @Test
    void shouldFindByType() throws DataAccessException {
        /*
        if we look for some type in our file, we should get
        those results
         */
        /*
        3 A's: Arrange - get ready to call function
        Act - call function
        Assert - check that function did expected
         */
        EncounterType lookFor = EncounterType.UFO;
        List<Encounter> ufoEncounters = repository.findByType(lookFor);
        assertEquals(2, ufoEncounters.size());
        for(Encounter toCheck : ufoEncounters){
            assertEquals(EncounterType.UFO, toCheck.getType());
        }

        Encounter firstEncounter = ufoEncounters.get(0);
        assertEquals(1, firstEncounter.getEncounterId());
        assertEquals("2020-01-01", firstEncounter.getWhen());



    }


    @Test
    void shouldNotFindByTypeForMissingType() {
        /*
        if we look for some type NOT in our file, we should get
        an empty array
         */
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        /*
        if we try to update real data, it should work
        the updated data should be available on a get
         */
        //for update test, we're gonna slightly "simulate" what the user would do.
        //step 1. find data we want to edit(arrange)

        Encounter toEdit = repository.findByType(EncounterType.CREATURE).get(0);
        //step 2, change data(arrange)

        toEdit.setDescription("new description");
        toEdit.setWhen("new data");
        //step 3. save the data(act)
        boolean success = repository.update(toEdit);


        assertTrue(success, "should get a success on update()");

        //step 4. look up the same data (assert)
        Encounter validation = repository.findByType(EncounterType.CREATURE).get(0);
        //step 5. validate that changes went through (assert)
        assertEquals("new description", validation.getDescription());
        assertEquals("new data", validation.getWhen());
    }

    @Test
    void shouldNotUpdate() {
        /*
        if we try to update real data, it should work
        the updated data should be available on a get
         */
    }
}