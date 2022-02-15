package hotelmanagement;

public class Hotel {
    private int capacity;
    private Guest[] guests;
    // rooms?

    public Hotel(int capacity, Guest[] guests) {
        this.capacity = capacity;
        this.guests = guests;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Guest[] getGuests() {
        return guests;
    }

    public void setGuests(Guest[] guests) {
        this.guests = guests;
    }
}
