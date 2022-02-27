package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PanelFileRepositoryTest {

    private static final String SEED_PATH = "./data/solarPanels-seed.csv";
    private static final String TEST_PATH = "./data/solarPanels-test.csv";

    private PanelFileRepository repository = new PanelFileRepository(TEST_PATH);

    /*
    - improve tests by establishing known-good-state with `@BeforeAll`
    - test `add`
    - implement `update`
    - test `update`
    - implement `deleteById`
    - test `deleteById`
     */

    @BeforeAll
    void shouldAddPanel() throws DataException{
        Panel panel = new Panel();
        panel.setSection(Material.AMORPHOUS_SILICON);
        panel.setRow(1);
        panel.setColumn(1);
        panel.setInstallationYear(2022);
        panel.setMaterial();

        Panel actual = repository.add(panel);

        assertNotNull(actual);
        assertEquals(1, actual.getId());

    }
}
