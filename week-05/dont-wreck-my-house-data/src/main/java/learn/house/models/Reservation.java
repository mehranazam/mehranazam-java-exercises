package learn.house.models;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {

    private int id;
    private LocalDate startDate;
    private LocalDate endDate;


    public Reservation(){

    }

    public Reservation(int id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
