package memories.data;



import memories.models.Memory;

import java.io.FileNotFoundException;
import java.util.List;

public interface MemoryRepository {

    // create
    Memory add(Memory memory) throws FileNotFoundException;
    // read
    List<Memory> findAll();
    List<Memory> findById(int id);
    List<Memory> findByFrom(String sender);
    // update
    boolean update(Memory memory) throws FileNotFoundException;
    // delete

    boolean delete(Memory memory);

}
