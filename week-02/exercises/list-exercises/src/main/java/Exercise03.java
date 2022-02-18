import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise03 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Add three new games to `games` with the `add` method.
        // 2. Print `games` after each add.

        games.add(new BoardGame("Battleship", 2, 2, "War"));
        System.out.println(games);
        games.add(new BoardGame("Sorry", 2, 4, "Party Game"));
        System.out.println(games);
        games.add(new BoardGame("Scrabble", 2, 4, "Puzzle"));
        System.out.println(games);
    }
}
