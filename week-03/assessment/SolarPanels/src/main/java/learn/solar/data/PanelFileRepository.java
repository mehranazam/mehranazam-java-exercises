package learn.solar.data;

import learn.solar.models.Panel;

import java.util.ArrayList;
import java.util.List;

public class PanelFileRepository implements PanelRepository {

    private final String filePath;

    public PanelFileRepository(String filePath) {
        this.filePath = filePath;
    }

    private List<Panel> findAll() throws DataException{



    }

    private String serialize(Panel panel){

    }

    private Panel deserialize(String message){

    }

    @Override
    public List<Panel> findBySection(String message) throws DataException {
        ArrayList<Panel> result = new ArrayList<>();
        for(Panel panel : findAll()){
            if(panel.getSection() == message){
                    result.add(panel);
            }
        }
        return result;
    }

    @Override
    public Panel add(Panel panel){
        List<Panel> all = findAll();
        int nextId = 0;
        for(Panel p : all){
            nextId = Math.max(nextId, p.getId());
        }
        nextId++;
        panel.setId(nextId);
        all.add(panel);
       // writeAll(all);
        return panel;
    }


    @Override
    public boolean update(Panel panel) throws DataException{
        List<Panel> all = findAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId() == panel.getId()){
                all.set(i, panel);
               // writeAll(all);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean deleteById(int panelId) throws DataException{
        List<Panel> all = findAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId() == panelId){
                all.remove(i);
                // writeAll(all);
                return true;
            }
        }
        return false;
    }




    /*
    Create the `PanelFileRepository` class.
   All methods should catch IOExceptions and throw `DataException`.
    *- add the filePath field and create a constructor to initialize the field
    *- generate tests for `PanelFileRepository`, should be located in `src/test/java/learn/solar/data/PanelFileRepositoryTest`
    *- create a `data` directory in the project root. add test, seed, and production data files
    *- implement `findAll`, `serialize`, and `deserialize`. these are all private method. may be useful to make `findAll` public temporarily and test it quick.
    *- implement `findBySection`, it uses `findAll`. test it naively (no known-good-state for now)
    *- implement `add`
    - improve tests by establishing known-good-state with `@BeforeAll`
    - test `add`
    *- implement `update`
    - test `update`
    *- implement `deleteById`
    - test `deleteById`
     */


}
