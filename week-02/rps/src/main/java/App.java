import learn.rps.ComputerPlayer;
import learn.rps.Game;
import learn.rps.Player;

public class App {
    public static void main(String[] args) {
        /*
        1. Rock
        2. Paper
        3. Scissors
         */

        Player player1 = new Player();
        int humanChoice = player1.move();
        System.out.println("You played "+ humanChoice);
        ComputerPlayer player2 = new ComputerPlayer();
        int computerChoice = player2.move();
        System.out.println("Computer played " + computerChoice);

        Game game = new Game(player1, player2);
        int result = game.playGame();
        if(result == 0){
            System.out.println("It was a tie");
        }
        if(result == 1){
            System.out.println("The computer wins!");
        }

        if(result == -1){
            System.out.println("You win!");
        }
    }
}
