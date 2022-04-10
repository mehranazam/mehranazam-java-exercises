package controllers;

import memories.data.DataAccessException;
import memories.domain.MemoryResult;
import memories.domain.MemoryService;
import memories.domain.ResultType;
import memories.models.Memory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memories")
public class MemoryController {
    private final MemoryService service;

    public MemoryController(MemoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Memory> findAll() throws DataAccessException {
        return service.findAll();
    }

    @GetMapping("/api/memories/{id}")
    public ResponseEntity<Memory> findById(@PathVariable int id) throws DataAccessException {
        Memory memory = service.findById(id);
        if(memory == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Memory> add(@RequestBody Memory memory) throws DataAccessException {
        MemoryResult<Memory> result = service.add(memory);
        if(result.getType() == ResultType.INVALID){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
    }


    @PutMapping("/api/memories/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Memory memory) throws DataAccessException {
        if(id != memory.getId()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MemoryResult<Memory> result = service.update(memory);
        if(result.getType() == ResultType.INVALID){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if(result.getType() == ResultType.NOT_FOUND){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/api/memories/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws DataAccessException {
        if(service.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
