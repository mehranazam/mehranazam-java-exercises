import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Exercise01 {

    public static void main(String[] args) {

        String[] ep1Teams = {"Liverpool", "Arsenal"};

        ArrayList<String> englishTeams = new ArrayList<>();
        englishTeams.add("Liverpool");
        englishTeams.add("Arsenal");
        ArrayList<BoardGame> games = GameRepository.getAll();
        BoardGame sixth = games.get(5);
        System.out.println(sixth.getName());

//        HashMap<Integer, String> ep1TeamsMap = new HashMap<Integer, String>();
//        int ep1TeamSize = ep1TeamsMap.size();
       // ep1TeamsMap.containsKey()
        // HashSet<int>
        List<String> ep1TeamsList = new ArrayList<>();
        //ep1TeamsList.
//        ArrayList<E> identifier = new ArrayList<E>();

        ArrayList<String> ep1TeamsList2 = new ArrayList<String>();
        ArrayList<Integer> allowedNumbers = new ArrayList<Integer>();
        // 1. Grab the 6th game from `games` (index 5).
        // 2. Print it to stdout. (Expected: "7 Wonders")




        GenericType <String> one = new GenericType<String>();
    one.value = "This is a string.";

    GenericType<BoardGame> boardGame = new GenericType<BoardGame>();
    boardGame.value = new BoardGame("Gomoku", 2, 6, "Japanese Board Game");
    GenericType<int[]> three = new GenericType<int[]>();
    three.value = new int[]{1, 2, 3, 4, 5};








    }
}
