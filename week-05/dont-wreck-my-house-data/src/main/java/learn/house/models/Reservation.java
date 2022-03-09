package learn.house.models;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {

    private Host id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Guest guest;
    private Host host;


    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Host getId() {
        return id;
    }

    public void setId(Host id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Reservation reservation = (Reservation) o;
        return id == reservation.id &&
                startDate == reservation.startDate &&
                endDate == reservation.endDate;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, startDate, endDate);
    }
}
