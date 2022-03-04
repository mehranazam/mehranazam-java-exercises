package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.ArrayList;
import java.util.List;

public class PanelRepositoryTestDouble implements PanelRepository{

    private ArrayList<Panel> panels = new ArrayList<>();

    public PanelRepositoryTestDouble(){
        Panel mono = new Panel();
        mono.setId(1);
        mono.setSection("Section 6");
        mono.setRow(6);
        mono.setColumn(6);
        mono.setInstallationYear(1975);
        mono.setMaterial(Material.MONOCRYSTALLINE_SILICON);
        mono.setTracking(true);

        panels.add(mono);


        panels.add(new Panel(2, "Section2", 2, 2, 1995, Material.CADMIUM_TELLURIDE, false));
        panels.add(new Panel(3, "Section3", 3, 3, 2000, Material.MULTICRYSTALLINE_SILICON, false));
        panels.add(new Panel(4, "Section4", 4, 4, 2010, Material.COPPER_INDIUM_GALLIUM_SELENIDE, true));
    }

    @Override
    public List<Panel> findBySection(String section) throws DataException {
        ArrayList<Panel> result = new ArrayList<>();
        for(Panel p : panels){
            if(section.equals(p.getSection())){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Panel findById(int id) throws DataException {
        return null;
    }

    @Override
    public Panel add(Panel panel) throws DataException {
        int newId = 0;
        for(Panel checkPanel : panels){
            if(checkPanel.getId() > newId){
                newId = checkPanel.getId();
            }
        }
        newId++;

        panel.setId(newId);
        panels.add(panel);
        return panel;
    }

    @Override
    public boolean update(Panel panel) throws DataException {
        return true;
    }

    @Override
    public boolean deleteById(int panelId) throws DataException {
        return true;
    }

//    @Override
//    public List<Panel> findAll() throws DataException {
//        return null;
//    }

//    @Override
//    public List<Panel> findAll() throws DataException {
//        return null;
//    }
}
