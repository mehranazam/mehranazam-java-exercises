package learn.house.domain;

import learn.house.data.GuestRepository;
import learn.house.models.Guest;

import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

    private final GuestRepository repository;

    public GuestService(GuestRepository repository) {
        this.repository = repository;
    }

    public List<Guest> findByEmail(String email){
        return repository.findByEmail(email);
    }

    public List<Guest> findByLastName(String prefix){
        return repository.findAll().stream()
                .filter(i -> i.getLastName().startsWith(prefix))
                .collect(Collectors.toList());
    }
}
