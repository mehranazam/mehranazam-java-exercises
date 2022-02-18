public class SoccerPlayer {

    private final int number;
    private final String firstName;
    private final String lastName;
    private final String position;

    public SoccerPlayer(int number, String firstName, String lastName, String position) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public static void main(String[] args) {


        SoccerPlayer captain = new SoccerPlayer(10, "Carli", "Lloyd", "FW");
        SoccerPlayer goalKeeper = new SoccerPlayer(1, "Alyssa", "Naeher", "GK");
        System.out.printf("%-2s: %s, %s%n", captain.getNumber(), captain.getLastName(), captain.getPosition());
        System.out.printf("%-2s: %s, %s%n", goalKeeper.getNumber(), goalKeeper.getLastName(), goalKeeper.getPosition());
    }
}
