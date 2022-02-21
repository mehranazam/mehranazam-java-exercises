package learn.gomoku;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.List;
import java.util.Scanner;

import static learn.gomoku.game.Gomoku.WIDTH;

public class GameController {

    private Scanner console;
    private char[][] board;
    Gomoku game;


    public void run(){
        setup();
        play();
        playAgain();

    }


    private void setup(){
        getPlayer();


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

    private void play(Gomoku game){
        boolean isValid = false;
        while(!isValid) {
            printBoard();
            readInt("Enter a row: ", 1, 15);
            readInt("Enter a column: ", 1, 15);
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


        for(int row = 0; row < WIDTH; row++){
            for(int col = 0; col < WIDTH; col++){
                if(board[row][col] == 0){
                System.out.print("_");
            }else{
                    String toPrint = board[row][col] == 1 ? "X" : "O";
                    System.out.println(toPrint);
                }
        }
            System.out.println();
    }


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
        if(playerNum < min || playerNum > max){
            System.out.println("Invalid. Try again!");
            System.out.println(message);
            playerNum = Integer.parseInt(console.nextLine());
        }
            return playerNum;

    }

    private boolean playAgain(){
        boolean choice = false;
//        readRequiredString("Do you want to play again?");

        if(readRequiredString("Do you want to play again?") == "yes"){
            choice = true;
        }else{
            choice = false;
        }
        return choice;
    }

}
