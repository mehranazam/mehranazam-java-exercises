package memories.data;

import memories.models.Memory;

import java.io.FileNotFoundException;
import java.util.List;

public interface MemoryRepository {

    // create
    Memory add(Memory memory) throws DataAccessException;
    // read
    List<Memory> findAll() throws DataAccessException;
    Memory findById(int id) throws DataAccessException;
    List<Memory> findBySender(String sender) throws DataAccessException;
    // update
    boolean update(Memory memory) throws DataAccessException;
    // delete
    boolean delete(Memory memory) throws DataAccessException;

    List<Memory> findShareable(boolean shareable) throws  DataAccessException;

    boolean deleteById(int i) throws DataAccessException;
}
