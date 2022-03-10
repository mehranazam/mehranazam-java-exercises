package learn.foraging.data;

import learn.foraging.models.Forager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForagerFileRepository implements ForagerRepository {

    private static final String DELIMITER = ",";
    private static final String DELIMITER_REPLACEMENT = "@@@";
    private static final String HEADER = "id,first_name,last_name,state";
    private final String filePath;

    public ForagerFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Forager> findAll() {
        ArrayList<Forager> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine(); // read header

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                String[] fields = line.split(",", -1);
                if (fields.length == 4) {
                    result.add(deserialize(fields));
                }
            }
        } catch (IOException ex) {
            // don't throw on read
        }
        return result;
    }

    @Override
    public Forager findById(String id) {
        return findAll().stream()
                .filter(i -> i.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Forager> findByState(String stateAbbr) {
        return findAll().stream()
                .filter(i -> i.getState().equalsIgnoreCase(stateAbbr))
                .collect(Collectors.toList());
    }

    @Override
    public Forager add(Forager forager) throws DataException {
        List<Forager> all = findAll();
        Forager newForager = new Forager();

        newForager.setId(java.util.UUID.randomUUID().toString());
        newForager.setFirstName(forager.getFirstName());
        newForager.setLastName(forager.getLastName());
        newForager.setState(forager.getState());
        all.add(newForager);
        writeAll(all);
        return newForager;
    }

    private String serialize(Forager forager){
        return String.format("%s,%s,%s,%s",
                forager.getId(),
                forager.getFirstName(),
                forager.getLastName(),
                forager.getState());
    }

    private Forager deserialize(String[] fields) {
        Forager result = new Forager();
        result.setId(fields[0]);
        result.setFirstName(fields[1]);
        result.setLastName(fields[2]);
        result.setState(fields[3]);
        return result;
    }

    private void writeAll(List<Forager> foragers) throws DataException {
        try(PrintWriter writer = new PrintWriter(filePath)){
            writer.println(HEADER);
            for(Forager f : foragers){
                writer.println(serialize(f));
            }
        }catch (IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
    }
}
