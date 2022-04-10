package memories.data;

import memories.models.Memory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MemoryRepositoryDouble implements  MemoryRepository{

    private List<Memory> memories = new ArrayList<>();

    public MemoryRepositoryDouble() {
      memories.add(new Memory(9,"Erwyn", "This was memory #1", true));
      memories.add(new Memory(14,"Owen", "This was memory #2", false));
      memories.add(new Memory(15,"Brad", "This was memory #3", true));
      memories.add(new Memory(16,"Descientia", "This was memory #4", false));
    }

    @Override
    public Memory add(Memory toAdd) throws DataAccessException {

        int newId = 0;
        for( Memory toCheck : memories ){
            if( toCheck.getId() > newId ){
                newId = toCheck.getId();
            }
        }
        newId++;

        toAdd.setId( newId );

        memories.add( toAdd );

        return toAdd;
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        return new ArrayList<>(memories);
    }

    @Override
    public Memory findById(int id) throws DataAccessException {
       for(Memory memory : memories) {
           if(memory.getId() == id) {
               return memory;
           }
       }
       return null;
    }

    @Override
    public List<Memory> findBySender(String sender) throws DataAccessException {
        return null;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {
        return findById(memory.getId()) != null;
    }

    @Override
    public boolean delete(Memory memory) throws DataAccessException {
        return false;
    }

    @Override
    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
       ArrayList<Memory> result = new ArrayList<>();
       for(Memory memory: memories) {
           if(memory.isShareable() == shareable) {
               result.add(memory);
           }
       }
       return result;
    }

    @Override
    public boolean deleteById(int i) throws DataAccessException {
        return false;
    }
}
