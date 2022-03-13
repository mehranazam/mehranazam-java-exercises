package learn.house.data;

import learn.house.models.Host;

import java.util.List;

public interface HostRepository {

    Host findById(String id) throws DataException;

    List<Host> findAll() throws DataException;

    List<Host> findByEmail(String email) throws DataException;

}
