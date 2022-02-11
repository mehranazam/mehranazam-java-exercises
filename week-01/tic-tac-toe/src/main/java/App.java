import java.util.Random;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        //Goal: play through one game of tic tac toe with computer
        //      we'll let the player always go first



        // representing state of game
        //      2d array of ints
        //      1:      X
        //      -1:     O
        //      0:      blank

        //loop until game is over
        //first let the player move,
        //      let player enter square they want
        //      using numberpad locations
        //
        //      7   8   9
        //      4   5   6
        //      1   2   3



        //  [0][0]  [0][1]  [0][2]      first index is row
        //  [1][0]  [1][1]  [1][2]      second index is column
        //  [2][0]  [2][1]  [2][2]

        //check for winner

        //then let computer move in blank spot

        //check for winner

        //initializing to a new board of all blank squares
        int[][] board = new int[3][3];

        while(!isWinner(board)){
            //get move from player

            int playerMove = getMoveFromPlayer(board);


            //compute coordinate
            int row = calcRow(playerMove);
            int col = calcCol(playerMove);


            //mark x on the board
            board[row][col] = 1;

            //check if the game is over
            if(!isWinner(board)){
                //if not, get random move from computer
                int computerMove = getMoveFromComp(board);

                row = calcRow(computerMove);
                col = calcCol(computerMove);


                //marking an o on the board
                board[row][col] = -1;
            }



            //if not, get random move from computer


        }
        printBoard(board);




    }

    private static Random rng = new Random();

    private static int getMoveFromComp(int[][] board) {
        //randomly generate a number from 1-9
        //check if the square at that position is blank
        //if not, loop back to start
        int compMove = Integer.MIN_VALUE;

        boolean valid = false;

        while(!valid){
            //rng.nextInt(x)
            //      generates a random number between 0 and x-1
            //      each random number has an equal probability
            //      of being selected

            compMove = 1 + rng.nextInt(9);
            int row = calcRow(compMove);
            int col = calcCol(compMove);

            if(board[row][col] == 0){
                valid = true;
            }
        }

        //TODO: actually implement this method

        return -1;
    }

    private static int calcCol(int move) {
        return (move - 1) % 3;
    }

    private static int calcRow(int move) {
        return 2 - ((move - 1) / 3);
    }

    private static int getMoveFromPlayer(int[][] board) {
        Scanner scn = new Scanner(System.in);

        int playerMove = Integer.MIN_VALUE;

        boolean valid = false;

        while(!valid){
            printBoard(board);
            System.out.print("Please enter your move (keypad): ");
            playerMove = scn.nextInt();

            if(playerMove >= 1 && playerMove <= 9){
                int row = calcRow(playerMove);
                int col = calcCol(playerMove);

                if(board[row][col] == 0){
                    valid = true;
                }
            }
        }
        return playerMove;
    }

    public static boolean isWinner(int[][] boardToCheck){
        boolean winner = false;

        //checking rows
        for(int row = 0; row < 3; row++){
            int sum = 0;

            for(int col = 0; col < 3; col++){
                sum += boardToCheck[row][col];
            }

            sum *= sum;

            if(sum == 9){
                winner = true;
            }

        }

        for(int col = 0; col < 3; col++) {
                int sum = 0;
            for (int row = 0; row < 3; row++) {
                    sum += boardToCheck[row][col];
            }
            sum *= sum;

            if(sum == 9){
                winner = true;
            }
        }

        int diag1Sum = boardToCheck[0][0] + boardToCheck[1][1] + boardToCheck[2][2];
        diag1Sum *= diag1Sum;

        int diag2Sum = boardToCheck[2][0] + boardToCheck[1][1] + boardToCheck[0][2];
        diag2Sum *= diag2Sum;


        return winner;
    }

//    private static boolean allSquaresFilled(int[][] boardToCheck){
//
//        boolean allFilled = true;
//
//        for(int row = 0; row < 3; row++){
//            for(int col = 0; col < 3; col++){
//                if(boardToCheck){
//
//                }
//            }
//        }
//
//    }

    public static void printBoard(int[][] boardToPrint){
        for(int row = 0; row < 3; row++) {


            for (int col = 0; col < 3; col++) {
                if(boardToPrint[row][col] == 0){
                    System.out.print(".");
                }else{
                    String toPrint = boardToPrint[row][col] == 1 ? "X" : "O";
                    System.out.print(toPrint);
                }
            }
            System.out.println();
        }
    }
}
