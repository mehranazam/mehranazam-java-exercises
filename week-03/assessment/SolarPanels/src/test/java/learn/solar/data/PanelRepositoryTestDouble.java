package learn.solar.data;

import learn.solar.models.Panel;

import java.util.List;

public class PanelRepositoryTestDouble implements PanelRepository{
    @Override
    public List<Panel> findBySection(String message) throws DataException {
        return null;
    }

    @Override
    public Panel add(Panel panel) {
        return null;
    }

    @Override
    public boolean update(Panel panel) throws DataException {
        return false;
    }

    @Override
    public boolean deleteById(int panelId) throws DataException {
        return false;
    }

    @Override
    public List<Panel> findAll() throws DataException {
        return null;
    }
}
