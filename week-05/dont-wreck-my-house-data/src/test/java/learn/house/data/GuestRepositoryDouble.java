package learn.house.data;

import learn.house.models.Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestRepositoryDouble implements GuestRepository{

    public final static Guest GUEST = makeGuest();

    private final ArrayList<Guest> guests = new ArrayList<>();

    public GuestRepositoryDouble(){
        guests.add(GUEST);

    }



    @Override
    public Guest findById(String id) {
        return guests.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Guest> findAll() {
        return guests;
    }

    @Override
    public List<Guest> findByEmail(String email) {
        return guests.stream()
                .filter(r -> r.getEmailAddress().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    private static Guest makeGuest(){
        Guest guest = new Guest();
        guest.setId("0e4707f4-407e-4ec9-9665-baca0aabe88c");
        guest.setFirstName("Mehran");
        guest.setLastName("Azam");
        guest.setEmailAddress("mehranazam@gmail.com");
        return guest;
    }
}
