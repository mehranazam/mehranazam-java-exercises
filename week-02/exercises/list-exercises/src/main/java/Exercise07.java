import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise07 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Instantiate a new ArrayList<BoardGame> and call it `economicGames`.
        // 2. Loop over `games`. Add each game with the "Economic" category to `economicGames`.
        // 3. Print `economicGames`.

        ArrayList<BoardGame> economicGames = new ArrayList<BoardGame>();
        for(int i = 0; i < games.size(); i++){
            if(games.get(i).getCategory() == "Economic"){
                economicGames.add(games.get(i));
            }
        }

        System.out.println(economicGames);

    }
}
