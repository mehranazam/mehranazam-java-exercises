package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.data.PanelRepositoryTestDouble;
import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PanelServiceTest {
    PanelService service = new PanelService(new PanelRepositoryTestDouble());



    @Test
    void shouldFindBySection() throws DataException {
        List<Panel> sections = service.findBySection("Section2");
        assertNotNull(sections);
        assertEquals(2, sections.size());
    }

    @Test
    void shouldNotAddNullPanel() throws DataException {
        PanelResult result = service.add(null);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldUpdate() throws DataException {
        PanelResult result = service.update(new Panel(4, "Section69", 4, 5, 2020, Material.MONOCRYSTALLINE_SILICON, true));
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotUpdateSection() throws DataException {
        PanelResult result = service.update(new Panel(4, "Section67", 4, 5, 2020, Material.MONOCRYSTALLINE_SILICON, true));
        assertFalse(result.isSuccess());
    }


    @Test
    void shouldNotUpdateEmptyName() throws DataException {
        PanelResult result = service.update(new Panel(3, "      ", 6, 6, 1970, Material.MONOCRYSTALLINE_SILICON, false));
        assertFalse(result.isSuccess());
    }

    @Test

    void shouldDelete()throws DataException{
        PanelResult result = service.deleteById(3);
        assertTrue(result.isSuccess());
    }


    @Test
    void shouldNotDelete() throws DataException{
        PanelResult result = service.deleteById(1);
        assertFalse(result.isSuccess());
    }







}
