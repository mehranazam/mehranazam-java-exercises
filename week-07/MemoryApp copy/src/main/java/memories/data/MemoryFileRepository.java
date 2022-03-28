package memories.data;

import memories.models.Memory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MemoryFileRepository implements MemoryRepository{
    private final String filePath;
    private final String delimiter = ",";

    public MemoryFileRepository(@Value("${dataFilePath}") String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Memory add(Memory memory) throws DataAccessException {
        List<Memory> allMemories = findAll();
        int nextId = getNextId(allMemories);
        memory.setId(nextId);
        allMemories.add(memory);
        writeToFile(allMemories);
        return memory;
    }

    private void writeToFile(List<Memory> allMemories)  {
        try(PrintWriter writer = new PrintWriter(filePath)) {
            for(Memory memory: allMemories) {
                writer.println(memoryToLine(memory));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String memoryToLine(Memory memory) {
        return memory.getId() + delimiter +
                memory.getFrom() + delimiter +
                memory.getContent() + delimiter +
                memory.isShareable() + delimiter;
    }

    private int getNextId(List<Memory> allMemories) {
        int maxId = 0;
        for(Memory memory: allMemories) {
            if(maxId < memory.getId()) {
                maxId = memory.getId();
            }
        }
        return maxId + 1;
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        ArrayList<Memory> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                Memory m = lineToMemory(line);
                if (m != null) {
                    result.add(m);
                }
            }
        } catch (FileNotFoundException ex) {
            // If the file doesn't exist, no big deal.
            // We'll create it when we add a new memory.
            // No file just means no memories yet.
        } catch (IOException ex) {
            throw new DataAccessException("Could not open the file path: " + filePath, ex);
        }
        return result;
    }

    private Memory lineToMemory(String line) {
        String[] fields = line.split(this.delimiter);

        if (fields.length != 4) {
            return null;
        }

        return new Memory(
                Integer.parseInt(fields[0]),
                fields[1],
                fields[2],
                "true".equals(fields[3])
        );
    }

    @Override
    public Memory findById(int id) throws DataAccessException {
       List<Memory> allMemories = findAll();
       for(Memory memory: allMemories) {
           if(memory.getId() == id) {
               //found our memory, please return the object
               return memory;
           }
       }
       return null;
    }

    @Override
    public List<Memory> findBySender(String sender) throws DataAccessException {
        List<Memory> allMemories = findAll();
        List<Memory> memoriesBySender = new ArrayList<>();
        for(Memory memory: allMemories) {
            if(memory.getFrom().equals(sender)) {
                //found our memory, please add it to our list and then return the list @ the end
                memoriesBySender.add(memory);
            }
        }
        return memoriesBySender;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {
        List<Memory> allMemories = findAll();
        for(int i = 0; i < allMemories.size(); i++) {
            if(allMemories.get(i).getId() == memory.getId()) {
                allMemories.set(i, memory);
                writeToFile(allMemories);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Memory memory) throws DataAccessException {
        List<Memory> allMemories = findAll();
        for(int i = 0; i < allMemories.size(); i++) {
            if(allMemories.get(i).getId() == memory.getId()) {
               allMemories.remove(i);
                writeToFile(allMemories);
                return true;
            }
        }
        return false;
    }

    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
        List<Memory> allMemories = findAll();
        List<Memory> result = new ArrayList<>();
        for(Memory memory: allMemories) {
            if(memory.isShareable() == shareable) {
                result.add(memory);
            }
        }
        return result;
    }

    @Override
    public boolean deleteById(int id) throws DataAccessException {
        List<Memory> allMemories = findAll();
        for(Memory memory: allMemories) {
            if(memory.getId() == id) {
                //delete from the list
                allMemories.remove(memory);
                writeToFile(allMemories);
                return true;
            }
        }
        return false;
    }
}
