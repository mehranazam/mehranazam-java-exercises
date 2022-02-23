import memories.data.DataAccessException;
import memories.data.MemoryFileRepository;
import memories.data.MemoryRepository;
import memories.models.Memory;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {



        List<Memory> memories = new ArrayList<>();
        MemoryRepository memoryRepository = new MemoryFileRepository("memories.txt");

        try{
            memories = memoryRepository.findAll();
            System.out.println(memories.get(0).getFrom());
            System.out.println(memories.get(0).getContent());
        }catch(DataAccessException e){
            e.printStackTrace();

        }
    }
}
