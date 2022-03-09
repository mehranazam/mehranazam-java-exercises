package learn.house.data;

import learn.house.models.Guest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestFileRepository implements GuestRepository{

    private final String filePath;

    public GuestFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Guest findById(String id) {
        return findAll().stream()
                .filter(i -> i.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Guest> findAll() {
        ArrayList<Guest> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] fields = line.split(",", -1);
                if(fields.length == 5){
                    result.add(deserialize(fields));
                }
            }
        }catch(IOException ex){

        }
        return result;
    }

    @Override
    public List<Guest> findByEmail(String email) {
        return findAll().stream()
                .filter(i -> i.getEmailAddress().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    private Guest deserialize(String[] fields){
        Guest result = new Guest();
        result.setId(fields[0]);
        result.setFirstName(fields[1]);
        result.setLastName(fields[2]);
        result.setEmailAddress(fields[3]);
        return result;
    }


}
