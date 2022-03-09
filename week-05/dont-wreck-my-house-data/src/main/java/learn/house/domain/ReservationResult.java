package learn.house.domain;

public class ReservationResult<T> extends ReservationResponse{

    private T payload;

    public T getPayload(){
        return payload;
    }

    public void setPayload(T payload){
        this.payload = payload;
    }
}
