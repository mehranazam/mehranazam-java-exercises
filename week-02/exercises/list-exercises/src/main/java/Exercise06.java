import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise06 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Use a loop to find the game in `games` that can be played by the most players.
        // 2. Print the game. (Expected: "Ultimate Werewolf...")

        for(int i = 0; i < games.size(); i++){
                if(games.get(i).getMaxPlayers() > 10){
                    System.out.println(games.get(i).getName());
                }
        }
    }
}

