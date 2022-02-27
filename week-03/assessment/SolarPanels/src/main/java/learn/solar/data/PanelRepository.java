package learn.solar.data;

import learn.solar.models.Panel;

import java.util.List;

public interface PanelRepository {
    List<Panel> findBySection(String message) throws DataException;

    Panel add(Panel panel);

    boolean update(Panel panel) throws DataException;

    boolean deleteById(int panelId) throws DataException;
}
