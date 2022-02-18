import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ArrayList<SoccerPlayer> defense = new ArrayList<>(Arrays.asList(
                new SoccerPlayer(14, "Emily", "Sonnett", "DF"),
                new SoccerPlayer(19, "Crystal", "Dunn", "DF"),
                new SoccerPlayer(20, "Casey", "Short", "DF")
        ));

        ArrayList<Integer> oddNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
    }
}