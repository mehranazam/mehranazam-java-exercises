package learn.house.domain;

public class ReservationResult<Reservation> extends ReservationResponse{

    private Reservation payload;

    public Reservation getPayload(){
        return payload;
    }

    public void setPayload(Reservation payload){
        this.payload = payload;
    }
}

