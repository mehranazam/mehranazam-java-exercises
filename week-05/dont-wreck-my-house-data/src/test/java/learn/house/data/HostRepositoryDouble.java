package learn.house.data;

import learn.house.models.Guest;
import learn.house.models.Host;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HostRepositoryDouble implements HostRepository{


    private final ArrayList<Host> hosts = new ArrayList<>();


    @Override
    public Host findById(String id) throws DataException {
        return hosts.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Host> findAll() throws DataException {
        return hosts;
    }

    @Override
    public List<Host> findByEmail(String email) throws DataException {
        return hosts.stream()
                .filter(r -> r.getEmailAddress().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }
}
