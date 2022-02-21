package learn.gomoku;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.List;
import java.util.Scanner;

import static learn.gomoku.game.Gomoku.WIDTH;

public class GameController {

    private Scanner console = new Scanner(System.in);
//    private char[][] board = new char[WIDTH][WIDTH];
    Gomoku game;


    public void run(){
        setup();
        play();
        playAgain();

    }


    private void setup(){
        Player player1 = getPlayer(1);  // gets one player
        Player player2 = getPlayer(2);
        game = new Gomoku(player1, player2);



//        return game;
    }

    private Player getPlayer(int playerNumber){
//        System.out.println("Welcome to Gomoku");
//        System.out.println("===================");
//        System.out.println("Player 1 is:\n1. Human\n2. Random Player\nSelect [1-2]: ");
//        int playerNum = Integer.parseInt(console.nextLine());
            playerNumber = readInt("Player 1 is:\n1. Human\n2. Random Player\nSelect [1-2]: ", 1, 2);
        if(playerNumber == 1) {
            Player player = new HumanPlayer(readRequiredString("Player 1, enter your name: "));
            return player;

        }else {
            Player computer = new RandomPlayer();
          
            return computer;
        }


    }

    private void play(){

        while(!game.isOver()) {
            printBoard(); //prints board
            Player currentPlayer = game.getCurrent(); //gets current player
            List<Stone> previousMoves = game.getStones(); //saves previous moves from each player
            Stone move = currentPlayer.generateMove(previousMoves); //generates a move for either player
            if(move == null) { //determines if the player currently playing is either a human or computer
                int rowMove = readInt("Enter a row: ", 1, 15) - 1; // HumanPlayer input
                int colMove = readInt("Enter a column: ", 1, 15) - 1;
                move = new Stone(rowMove, colMove, game.isBlacksTurn());
            }
            Result moveResult = game.place(move);
            if(moveResult.getMessage() != null) {
                System.out.println(moveResult.getMessage());
            }
        }
    }

//    private Stone findStoneAt(List<Stone> toSearch, int row, int col){
//        for(int row = 0; row < WIDTH; row++){
//            for(int col = 0; col < WIDTH; col++) {
//
//            }
//            }
//    }

    private void printBoard(){
        List<Stone> currentStones = game.getStones();

        char[][] board = new char[WIDTH][WIDTH];
        System.out.println();
        System.out.println();
        System.out.println();
        for(int row = 0; row < WIDTH; row++){
            for(int col = 0; col < WIDTH; col++){
                board[row][col] = '_';
            }
        }
        for(Stone s : currentStones){
            board[s.getRow()][s.getColumn()] = s.isBlack() ? 'X' : 'O';
        }


        for(int row = 0; row < WIDTH; row++){
            for(int col = 0; col < WIDTH; col++){
                System.out.print(board[row][col]);
            }
            System.out.println();
        }

//        if(currentStones.isEmpty()){
//            for(int i = 0; i < board.length; i++){
//                    if(i == 0){
//                        System.out.println(" ");
//                    }
//                System.out.printf("%02d  ", (i + 1));
//            }
//            System.out.println();
//            for(int row = 0; row < board.length; row++){
//                for(int col = 0; col < board[row].length; col++){
//                    if(col == 0){
//                        System.out.printf("%02d", (row + 1));
//                    }
//                    System.out.printf("%4s", board[row][col] + " ");
//                }
//            }
//        }else{
//            for(int row = 0; row < currentStones.size(); row++){
//                Stone stone = currentStones.get(row);
//                for(int col = 0; col < currentStones.size(); col++){
//                        if(stone.getRow() == (row + 1) && stone.getColumn() == (col + 1)){
//                                board[row][col] = 'x';
//                        }
//                }
//            }
//
//            for(int i = 0; i < board.length; i++){
//                    if(i == 0){
//                        System.out.println(" ");
//                    }
//                System.out.printf("%02d  ", (i + 1));
//            }
//            System.out.println();
//            for(int j = 0; j < board.length; j++){
//
//            }
//        }




//        for(int row = 0; row < WIDTH; row++){
//            for(int col = 0; col < WIDTH; col++){
//                if(board[row][col] == 0){
//                System.out.print("_");
//            }else{
//                    String toPrint = board[row][col] == 1 ? "X" : "O";
//                    System.out.println(toPrint);
//                }
//        }
//            System.out.println();
//    }
//

//        game.board();
    }

    private String readRequiredString(String message){
        System.out.println(message);
        String input = console.nextLine();
        if(input == " " || input == ""){
            System.out.println("Invalid. Try again!");
            System.out.println(message);
            input = console.nextLine();
        }
            return input;

    }

    private int readInt(String message, int min, int max){
        System.out.println(message);

        int playerNum = Integer.parseInt(console.nextLine());
        while(playerNum < min || playerNum > max){
            System.out.println("Invalid. Try again!");
            System.out.println(message);
            playerNum = Integer.parseInt(console.nextLine());
        }
            return playerNum;

    }

    private boolean playAgain(){
        boolean choice = false;
//        readRequiredString("Do you want to play again?");

        if(readRequiredString("Do you want to play again?").toLowerCase().equals("yes")){
            choice = true;
        }else{
            choice = false;
        }
        return choice;
    }

}
