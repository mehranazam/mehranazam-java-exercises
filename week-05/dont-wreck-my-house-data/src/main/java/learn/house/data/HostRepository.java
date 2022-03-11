package learn.house.data;

import learn.house.models.Host;

import java.util.List;

public interface HostRepository {

    Host findById(String id);

    List<Host> findAll();

    List<Host> findByEmail(String email);

}
