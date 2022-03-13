package learn.house.data;

import learn.house.models.Guest;

import java.util.List;

public interface GuestRepository {
    Guest findById(String id) throws DataException;

    List<Guest> findAll() throws DataException;

    List<Guest> findByEmail(String email) throws DataException;
}
