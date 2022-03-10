package learn.house.data;

import learn.house.models.Host;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HostFileRepository implements HostRepository{

    private final String filePath;

    public HostFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Host findById(String id) {
        return findAll().stream()
                .filter(i -> i.getHostId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Host> findAll() {
        ArrayList<Host> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();

            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] fields = line.split(",", -1);
                if(fields.length == 3){
                    result.add(deserialize(fields));
                }
            }
        }catch(IOException ex){

        }
        return result;
    }

    @Override
    public List<Host> findByEmail(String email) {
        return findAll().stream()
                .filter(i -> i.getEmailAddress().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    private Host deserialize(String[] fields){
        Host result = new Host();
        result.setHostId(fields[0]);
        result.setEmailAddress(fields[1]);
        result.setLocation(fields[2]);
        return result;
    }
}
