package Library.Domain;

import Library.Models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookResult {

    List<String> errorMessages = new ArrayList<>();
    Book payLoad;

    public boolean hasError(){
        return errorMessages.size() > 0;
    }
    public void addErrorMessage(String errorMessage){
        errorMessages.add(errorMessage);
    }

    public Book getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(Book payLoad) {
        this.payLoad = payLoad;
    }

    public List<String> getErrorMessages() {
        return new ArrayList<>(errorMessages);
    }
}
