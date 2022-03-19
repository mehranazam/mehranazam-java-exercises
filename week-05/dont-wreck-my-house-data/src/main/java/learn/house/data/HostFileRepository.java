package learn.house.data;

import learn.house.models.Host;
import learn.house.models.Reservation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class HostFileRepository implements HostRepository{

    private final String filePath;
    private static final String DELIMITER = ",";
    private static final String DELIMITER_REPLACEMENT = "@@@";
    private static final String HEADER = "id,last_name,email,phone,address,city,state,postal_code,standard_rate,weekend_rate";



    public HostFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Host findById(String id) throws DataException {
        return findAll().stream()
                .filter(i -> i.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Host> findAll() throws DataException {
        ArrayList<Host> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();

            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] fields = line.split(",", -1);
                if(fields.length == 10){
                    result.add(deserialize(fields));
                }
            }
        }catch(IOException ex){
                throw new DataException("Could not get all hosts.", ex);
        }
        return result;
    }

    @Override
    public List<Host> findByEmail(String email) throws DataException {
        List<Host> allHosts = findAll();
        List<Host> matching = allHosts.stream()
                .filter(r -> r.getEmailAddress().toLowerCase().startsWith(email.toLowerCase()
                )).collect(Collectors.toList());
        return matching;
    }


    //"id,last_name,email,phone,address,city,state,postal_code,standard_rate,weekend_rate";

    private Host deserialize(String[] fields){
        Host result = new Host();
        result.setId(fields[0]);
        result.setLastName(fields[1]);
        result.setEmailAddress(fields[2]);
        result.setPhoneNumber(fields[3]);
        result.setAddress(fields[4]);
        result.setCity(fields[5]);
        result.setState(fields[6]);
        result.setPostalCode(Integer.parseInt(fields[7]));
        double standardPrice = Double.parseDouble(fields[8]);
        result.setStandardRate(BigDecimal.valueOf(standardPrice));
        double weekendPrice = Double.parseDouble(fields[9]);
        result.setWeekendRate(BigDecimal.valueOf(weekendPrice));
        return result;
    }
}
