package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PanelFileRepository implements PanelRepository {

    private static final String DELIMITER = ",";
    private static final String DELIMITER_REPLACEMENT = "@@@";
    private static final String HEADER = "panel_id,section,row,column,installationyear,material,istracking";
    private final String filePath;

    public PanelFileRepository(String filePath) {
        this.filePath = filePath;
    }


    public List<Panel> findAll() throws DataException{
        ArrayList<Panel> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                Panel panel = deserialize(line);
                if(panel != null){
                    result.add(panel);
                }
            }
        }catch(FileNotFoundException ex){

        }catch(IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
            return result;

    }

    private String serialize(Panel panel){
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                panel.getId(),
                panel.getSection(),
                panel.getRow(),
                panel.getColumn(),
                panel.getInstallationYear(),
                panel.getMaterial(),
                panel.isTracking());
    }

    private Panel deserialize(String line){
        String[] fields = line.split(DELIMITER, -1);
        if(fields.length == 7){
            Panel panel = new Panel();
            panel.setId(Integer.parseInt(fields[0]));
            panel.setSection(String.valueOf(fields[1]));
            panel.setRow(Integer.parseInt(fields[2]));
            panel.setColumn(Integer.parseInt(fields[3]));
            panel.setInstallationYear(Integer.parseInt(fields[4]));
            panel.setMaterial(Material.valueOf(fields[5]));
            panel.setTracking(Boolean.parseBoolean(fields[6]));
        }
        return null;
    }

    @Override
    public List<Panel> findBySection(String section) throws DataException {
        ArrayList<Panel> result = new ArrayList<>();
        for(Panel panel : findAll()){
            if(panel.getSection().equals(section)){
                result.add(panel);
            }
        }
        return result;
    }


    @Override
    public Panel findById(int id) throws DataException {
       Panel result = new Panel();
        for(Panel panel : findAll()){
            if(panel.getId() == id){
                result = panel;
            }
        }
        return result;
    }

    @Override
    public Panel add(Panel panel) throws DataException {
        List<Panel> all = findAll();
        int nextId = 0;
        for(Panel p : all){
            nextId = Math.max(nextId, p.getId());
        }
        nextId++;
        panel.setId(nextId);
        all.add(panel);
        writeAll(all);
        return panel;
    }


    @Override
    public boolean update(Panel panel) throws DataException{
        List<Panel> all = findAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId() == panel.getId()){
                all.set(i, panel);
                writeAll(all);
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
                 writeAll(all);
                return true;
            }
        }
        return false;
    }


    private void writeAll(List<Panel> panels) throws DataException{
        try(PrintWriter writer = new PrintWriter(filePath)){
            writer.println("panelId,section,row,column,installationyear,material,tracking");

            for(Panel p : panels){
                writer.println(serialize(p));
            }
        }catch(IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
    }


//    private String clean(String value) {
//        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
//    }
//
//    private String restore(String value) {
//        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
//    }

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
