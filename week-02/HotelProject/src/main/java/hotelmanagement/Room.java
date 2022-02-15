package hotelmanagement;

public class Room {
    private int roomNumber;
    private String roomType;
    private int floor;
    private String status;
    private boolean hasBalcony;
    private Guest guest;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room() {
    }

    public Room(int roomNumber, Guest guest) {
        this.roomNumber = roomNumber;
        this.guest = guest;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
