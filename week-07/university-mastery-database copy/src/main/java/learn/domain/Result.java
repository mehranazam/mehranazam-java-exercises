package learn.domain;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {

    T payload;
    List<String> errorMessages = new ArrayList<>();

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public List<String> getErrorMessages() {
        return new ArrayList<>(errorMessages);
    }

    public void addErrorMessage( String message ){
        errorMessages.add( message );
    }

    public boolean isSuccess() {
        return errorMessages.size() == 0;
    }


}
