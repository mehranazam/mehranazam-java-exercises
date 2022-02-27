package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.List;
import java.util.Map;

public class PanelService {

    private final PanelRepository repository;

    public PanelService(PanelRepository repository) {
        this.repository = repository;
    }

    public List<Panel> findBySection(String message) throws DataException{
        return repository.findBySection(message);
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


        Panel p = repository.add(panel);
        result.setPayload(p);
        return result;
    }

    private PanelResult validate(Panel panel) {
        PanelResult result = new PanelResult();
        if(panel == null){
            result.addErrorMessage("panel cannot be null");
            return result;
        }
//        if(panel.getColumn() = null || panel.getRow() = null){
//
//        }
        return result;
    }

    public PanelResult update(Panel panel) throws DataException{
        PanelResult result = validate(panel);
        if(!result.isSuccess()){
            return result;
        }
        Panel existing = repository.findBySection(panel.getSection());
        if(existing == null){
            result.addErrorMessage("Panel section " + panel.getSection() + " not found.");
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


    public PanelResult deleteById(int panelId){
        PanelResult result = new PanelResult();

        Panel panel = repository.findBySection(panelId);

        if(panel == null){
            result.addErrorMessage("Could not find panel Id " + panel);
            return result;
        }
        Map<Material, Integer> counts = countTypes();
        counts.put(panel.getSection(), counts.get(panel.getSection()) - 1);
        result = validateDomain(counts);
        if(!result.isSuccess()){
            return result;
        }
        boolean success = repository.deleteById(panelId);
        if(!success){
            result.addErrorMessage("Could not find panel Id " + panel);
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
