package learn.solar.data;

import learn.solar.models.Panel;

import java.util.List;

public interface PanelRepository {
    List<Panel> findBySection(String section) throws DataException;

    Panel findById(int id) throws DataException;

    Panel add(Panel panel) throws DataException;

    boolean update(Panel panel) throws DataException;

    boolean deleteById(int panelId) throws DataException;

//    public List<Panel> findAll() throws DataException;
}
