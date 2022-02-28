package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PanelService {

    private final PanelRepository repository;

    public PanelService(PanelRepository repository) {
        this.repository = repository;
    }

    public List<Panel> findBySection(String section) throws DataException{
        return repository.findBySection(section);
    }

    public PanelResult add(Panel panel)throws DataException{
        PanelResult result = validate(panel);
        if(!result.isSuccess()){
            return result;
        }

//        Map<Material, Integer> counts = countTypes();
//        counts.put(panel.getSection(), counts.get(panel.getSection()) + 1);
//        result = validateDomain(counts);
//        if(!result.isSuccess()){
//            return result;
//        }
        List<Panel> panels = repository.findAll();
        for(Panel p : panels){
            if(Objects.equals(panel.getSection(), p.getSection())
            && Objects.equals(panel.getRow(), p.getRow())
            && Objects.equals(panel.getColumn(), p.getColumn())
            && Objects.equals(panel.getInstallationYear(), p.getInstallationYear())
            && Objects.equals(panel.getMaterial(), p.getMaterial())
            && Objects.equals(panel.isTracking(), p.isTracking())){
                result.addErrorMessage("Duplicate panel is not allowed");
                return result;
            }
        }

        panel = repository.add(panel);
        result.setPayload(panel);
        return result;
    }



    public PanelResult update(Panel panel) throws DataException{
        PanelResult result = validate(panel);
        if(!result.isSuccess()){
            return result;
        }
        Panel existing = panel.getId();
        if(existing == null){
            result.addErrorMessage("Panel section " + panel.getId() + " not found.");
            return result;
        }
        if(existing.getSection() != panel.getSection()){
            result.addErrorMessage("Can't update type.");
            return result;
        }
        boolean success = repository.update(panel);
        if(!success){
            result.addErrorMessage("Could not find Panel section " + panel.getSection());
        }
        return result;
    }


    public PanelResult deleteById(int panelId) throws DataException {
        PanelResult result = new PanelResult();

        Panel panel = repository.findBySection(panelId);

        if(panel == null){
            result.addErrorMessage("Could not find panel Id " + panel);
            return result;
        }
        //Map<Material, Integer> counts = countTypes();
       // counts.put(panel.getSection(), counts.get(panel.getSection()) - 1);
//        result = validateDomain(counts);
        if(!result.isSuccess()){
            return result;
        }
        boolean success = repository.deleteById(panelId);
        if(!success){
            result.addErrorMessage("Could not find panel Id " + panel);
        }
        return result;

    }


//    private PanelResult validateDomain(Map<Material, Integer> counts){
//        int multi = counts.get(Material.MULTICRYSTALLINE_SILICON);
//        int mono = counts.get(Material.MONOCRYSTALLINE_SILICON);
//        int amorph = counts.get(Material.AMORPHOUS_SILICON);
//        int cad = counts.get(Material.CADMIUM_TELLURIDE);
//        int copper = counts.get(Material.COPPER_INDIUM_GALLIUM_SELENIDE);
//
//        PanelResult result = new PanelResult();
//
//
//    }

    private PanelResult validate(Panel panel){
        PanelResult result = new PanelResult();
        if(panel == null){
            result.addErrorMessage("Panel cannot be null");
            return result;
        } if(Integer.parseInt(panel.getSection()) < 0 || panel.getSection() == null){
            result.addErrorMessage("Section is required");
        }

        if((panel.getRow() < 0)){
            result.addErrorMessage("Row is required");
        }
        if((panel.getColumn() < 0)){
            result.addErrorMessage("Column is required");
        }
        if((panel.getInstallationYear() == Integer.parseInt(null)) || (panel.getInstallationYear() < 0)){
            result.addErrorMessage("When is required");
        }

        if(panel.getMaterial() == null){
            result.addErrorMessage("Material is required");
        }
        if(!panel.isTracking()){
            result.addErrorMessage("Panel is not being tracked");
        }
        return result;
    }


    /*
    Create `PanelService`.
    *- add a `PanelRepository` (interface) field with a corresponding constructor
    - generate tests for `PanelService`
    *- create `PanelRepositoryTestDouble` to support service testing, this test class implements `PanelRepository`
    *- implement `findBySection` and test, implement just enough code in `PanelRepositoryTestDouble` to enable service testing
    *- implement `add` and test, requires validation
    *- implement `update` and test, requires validation
    *- implement `deleteById` and test
     */


}
