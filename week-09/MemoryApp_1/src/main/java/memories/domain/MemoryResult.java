package memories.domain;

import memories.models.Memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryResult<T> {

    private ResultType type = ResultType.SUCCESS;
    private T payload;
    private ArrayList<String> messages = new ArrayList<>();

    public ResultType getType() {
        return type;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void addMessage(String message, ResultType type) {
        messages.add(message);
        this.type = type;

    }







    //    private ArrayList<String> messages = new ArrayList<>();
//    private Memory memory;
//
//    public List<String> getMessages() {
//        return new ArrayList<>(messages);
//    }
//    //adding a message to our messages
//    public void addMessage(String message) {
//        this.messages.add(message);
//    }
//
//
//
//    public boolean isSuccessful() {
//       int messagesSize = messages.size();
//       if(messagesSize == 0) {
//           return true;
//       }
//       return false;
//    }
//    public Memory getMemory() {
//        return memory;
//    }
//
//    public void setMemory(Memory memory) {
//        this.memory = memory;
//    }





}
