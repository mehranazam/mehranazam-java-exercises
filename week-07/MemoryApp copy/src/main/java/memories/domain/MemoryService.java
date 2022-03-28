package memories.domain;

import memories.data.DataAccessException;
import memories.data.MemoryRepository;
import memories.models.Memory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class MemoryService {
    private final MemoryRepository repository;

    public MemoryService(MemoryRepository repository) {
        this.repository = repository;
    }

    public List<Memory> findPublicMemories() throws DataAccessException {
        return repository.findShareable(true);
    }

    public List<Memory> findPrivateMemories() throws DataAccessException {
        return repository.findShareable(false);

    }

    public List<Memory> findAll() throws DataAccessException {
        return repository.findAll();
    }


    public Memory findById(int id) throws DataAccessException {
        return repository.findById(id);
    }
    //create

    public MemoryResult<Memory> add(Memory memory) throws DataAccessException {

        MemoryResult<Memory> result = validate(memory);
        if(result.getType() != ResultType.SUCCESS){
            return result;
        }

        Memory m = repository.add(memory);
        result.setPayload(m);

        return result;

//        MemoryResult result = validate(memory);
//
//        if(result.isSuccessful()) {
//            if(memory.getId() > 0) {
//                result.addMessage("Id should not be set at this time");
//            }
//            memory = repository.add(memory);
//            result.setMemory(memory);
//        }
//        return result;
    }

    private MemoryResult<Memory> validate(Memory memory) {
        MemoryResult<Memory> result = new MemoryResult<>();

        if(memory == null) {
            result.addMessage("Memory cannot be null", ResultType.INVALID);
            return result;
        }


        if(memory.getFrom() == null || memory.getFrom().isBlank()) {
            result.addMessage("Sender is null or blank", ResultType.INVALID);
        }
        if(memory.getContent() == null || memory.getContent().isBlank()) {
            result.addMessage("Content is either null or blank", ResultType.INVALID);
        }
        return result;
    }



    //read
    //update
    public MemoryResult<Memory> update(Memory memory) throws DataAccessException {
        MemoryResult<Memory> result = new MemoryResult<>();
        if(result.getType() != ResultType.SUCCESS){
            return result;
        }

        if(!repository.update(memory)){
            result.addMessage("memory id " + memory.getId() + " not found", ResultType.NOT_FOUND);
        }

        return result;

//        result = validate(memory);
//        if(result.isSuccessful()) {
//            if(repository.update(memory)) {
//                result.setMemory(memory);
//            } else {
//                result.addMessage("Memory id is not found");
//            }
//        }
//        return result;
    }
    //delete

//    public MemoryResult delete(Memory memory) throws DataAccessException {
//        MemoryResult result = new MemoryResult();
//        result.setMemory(memory);
//        if(repository.delete(memory)) {
//            result.addMessage("There was an issue during the deletion operation");
//        }
//        return result;
//    }

    public boolean deleteById(int id) throws DataAccessException {
        return repository.deleteById(id);
    }

}
