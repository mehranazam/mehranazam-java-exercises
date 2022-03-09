package learn.house.data;

import learn.house.models.Guest;

import java.util.List;

public interface GuestRepository {
    Guest findById(String id);

    List<Guest> findAll();

    List<Guest> findByEmail(String email);
}
