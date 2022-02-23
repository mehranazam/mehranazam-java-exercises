package memories.data;

import memories.models.Memory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MemoryFileRepository implements MemoryRepository{
    private final String filePath;
    private final String delimiter = ",";
    

    public MemoryFileRepository(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public Memory add(Memory memory) throws DataAccessException, FileNotFoundException {
        List<Memory> allmemories = findAll();
        int nextId = getNextId(allmemories);
        memory.setId(nextId);
        writeToFile(allmemories);
        allmemories.add(memory);
        return memory;
    }

    private void writeToFile(List<Memory> allmemories) throws FileNotFoundException{
        try(PrintWriter writer = new PrintWriter(filePath)){
            for(Memory memory : allmemories){
                writer.println(memoryToLine(memory));
            }
        } 
    }

    private String memoryToLine(Memory memory) {
        String buffer = memory.getId() + delimiter +
                memory.getFrom() + delimiter +
                memory.getContent() + delimiter +
                memory.isShareable() + delimiter;
        return buffer;
    }

    private int getNextId(List<Memory> allmemories){
        int maxId = 0;
        for(Memory memory : allmemories){
            if(maxId < memory.getId()){
                maxId = memory.getId();
            }
        }
    }

    @Override
    public List<Memory> findAll() {
        ArrayList<Memory> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(this.filePath))){
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                Memory m = lineToMemory(line);
                if(m != null){
                    result.add(m);
                }
            }
        }catch(FileNotFoundException ex){
            
        }
        return new Memory(Integer.parseInt(fields[0]), fields[1], fields[2], "true".equals(fields[3]));
    }

    private Memory lineToMemory(String line) {
        String[] fields = line.split(this.delimiter);
    }

    @Override
    public List<Memory> findById(int id) throws DataAccessException{
        List<Memory> allMemories = findAll();
        for (Memory memory : allMemories){
            if(memory.getId() == id){
                return memory;
            }
        }
        return null;
    }

    @Override
    public List<Memory> findByFrom(String sender) {
        List<Memory> allMemories = findAll();
        List<Memory> memoriesBySender = new ArrayList<>();
        for (Memory memory : allMemories){
            if(memory.getFrom().equals(sender)){
                memoriesBySender.add(memory);
            }
        }
        return memoriesBySender;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException, FileNotFoundException {
        List<Memory> allMemories = findAll();
        for(int i = 0; i < allMemories.size(); i++){
            if(allMemories.get(i).getId() == memory.getId()){
                allMemories.set(i, memory);
                writeToFile(allMemories);
                return true;

            }
        }
        return false;
    }

    @Override
    public boolean delete(Memory memory) {
        return false;
    }
}
