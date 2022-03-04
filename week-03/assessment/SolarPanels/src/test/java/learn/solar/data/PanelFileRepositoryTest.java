package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

public class PanelFileRepositoryTest {

    private static final String SEED_PATH = "./data/solarPanels-seed.csv";
    private static final String TEST_PATH = "./data/solarPanels-test.csv";


    PanelFileRepository repository = new PanelFileRepository(TEST_PATH);

    /*
    - improve tests by establishing known-good-state with `@BeforeAll`
    *- test `add`
    *- implement `update`
    *- test `update`
    *- implement `deleteById`
    *- test `deleteById`
     */

    @BeforeEach
    void setup() throws IOException {
       Files.copy(Paths.get(SEED_PATH), Paths.get(TEST_PATH), StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldAddPanel() throws DataException{
        Panel panel = new Panel();
        panel.setSection("Section5");
        panel.setRow(5);
        panel.setColumn(5);
        panel.setInstallationYear(2020);
        panel.setMaterial(Material.AMORPHOUS_SILICON);

        Panel actual = repository.add(panel);

        assertNotNull(actual);
        assertEquals(5, actual.getId());

    }

    @Test
    void shouldUpdate() throws DataException {
        Panel panel = new Panel();
        panel.setId(2);
        panel.setSection("Section 8");
        panel.setRow(8);
        panel.setColumn(8);
        panel.setInstallationYear(2002);
        panel.setMaterial(Material.CADMIUM_TELLURIDE);
        panel.setTracking(false);


        boolean success = repository.update(panel);
        assertTrue(success);

       // Panel actual = repository.findBySection("Section 8");
//        assertNotNull(actual);
//        assertEquals("Section 8", actual.getSection());
    }


    @Test
    void shouldNotUpdateMissing()throws DataException{
        Panel panel = new Panel();
        panel.setId(100000);
        boolean actual = repository.update(panel);
        assertFalse(actual);
    }

    @Test
    void shouldDeleteExisting()throws DataException{
        boolean actual = repository.deleteById(1);
        assertTrue(actual);

        Panel p = repository.findBySection("Section1");
        assertNull(p);
    }

    @Test
    void shouldNotDeleteMissing()throws DataException{
        boolean actual = repository.deleteById(1000000);
        assertFalse(actual);
    }

}
