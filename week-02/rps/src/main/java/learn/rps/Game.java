package learn.rps;

public class Game {

    /*
    properties of game class
     */

//    private Player player1; // human player
//    private ComputerPlayer player2; // computer player
    private GamePlayer player1;
    private GamePlayer player2;


    private final int ROCK = 1;
    private final int PAPER = 2;
    private final int SCISSORS = 3;



    public Game(Player player1, ComputerPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Game(GamePlayer player1, GamePlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /*
                0 Tie
                1 computer wins
                -1 human wins

                */

    public int playGame(){
        int result = 0;
        int player1Choice = player1.move();
        int player2Choice = player2.move(); // random number

        if(player1Choice == player2Choice){
            return 0;
        }

        if((player2Choice == ROCK && player1Choice == PAPER) || (player2Choice == SCISSORS && player1Choice == PAPER) || (player2Choice == PAPER && player1Choice == ROCK)){
                return 1;
        }else{
            return -1;
        }

    }


}
