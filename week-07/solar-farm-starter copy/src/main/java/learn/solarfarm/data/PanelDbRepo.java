package learn.solarfarm.data;

import learn.solarfarm.models.SolarPanel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PanelDbRepo implements SolarPanelRepository{

    JdbcTemplate template;

    public PanelDbRepo(JdbcTemplate template){
        this.template = template;
    }


    @Override
    public List<SolarPanel> findBySection(String section) throws DataAccessException {
        return null;
    }

    @Override
    public SolarPanel findById(int id) throws DataAccessException {
        return null;
    }

    @Override
    public SolarPanel create(SolarPanel solarPanel) throws DataAccessException {
        return null;
    }

    @Override
    public boolean update(SolarPanel solarPanel) throws DataAccessException {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws DataAccessException {
        return false;
    }
}
