import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main( String[] args ){

        //Goal: play through one game of tic-tac-toe with the computer
        //      we'll let the player always go first

        // representing the state of the game
        //      2d array of ints
        //      1:      X
        //      -1:     O
        //      0:      blank

        //loop until the game is over
        //first let the player move,
        //      let the player enter the square they want
        //      using the numberpad locations
        //
        //      7  8  9
        //      4  5  6
        //      1  2  3


        //   [0][0]  [0][1]   [0][2]        first index is the row
        //   [1][0]  [1][1]   [1][2]        second index is the col
        //   [2][0]  [2][1]   [2][2]

        //check for winner

        //then let the computer move in a blank spot

        //check for winner

        //intializing to a new board of all blank squares
        //because 0 is blank
        int[][] board = new int[3][3];

        while(!allSquaresFilled(board) && !hasWinner( board )){
            //get move from player

            int playerMove = getMoveFromPlayer(board);

            //compute coordinate
            int row = calcRow( playerMove );
            int col = calcCol( playerMove );

            //mark x on the board
            board[row][col] = 1;

            //check if the game is over
            if( !allSquaresFilled(board) && !hasWinner(board)){
                //if not, get a random move from the computer
                int computerMove = getMoveFromComp( board );

                row = calcRow( computerMove );
                col = calcCol( computerMove );

                //marking an o on the board
                board[row][col] = -1;
            }

        }

        //final print after the game is over
        printBoard(board);

    }

    private static Random rng = new Random();
    private static int getMoveFromComp(int[][] board) {
        //randomly generate a number from 1-9
        //check if the square at that position is blank
        //if not, loop back to the start
        int compMove = Integer.MIN_VALUE;

        boolean valid = false;

        while( !valid ){
            //rng.nextInt(x)
            //      generates a random number between 0 and x-1
            //      each random number has an equal probability
            //      of being selected

            compMove = 1 + rng.nextInt(9);
            int row = calcRow( compMove );
            int col = calcCol( compMove );

            if( board[row][col] == 0){
                valid = true;
            }

        }

        return compMove;
    }


    //      7  8  9
    //      4  5  6
    //      1  2  3

    //subtracting 1

    //      6  7  8
    //      3  4  5
    //      0  1  2


    //   [0]  [1]   [2]
    //   [0]  [1]   [2]
    //   [0]  [1]   [2]
    private static int calcCol(int move) {
        return (move - 1) % 3;
    }


    //      7  8  9
    //      4  5  6
    //      1  2  3

    //        -1


    //      6  7  8
    //      3  4  5
    //      0  1  2

    //         /3

    //      2  2  2
    //      1  1  1
    //      0  0  0

    //         2-x

    //      0  0  0
    //      1  1  1
    //      2  2  2

    //   [0]  [0]   [0]
    //   [1]  [1]   [1]
    //   [2]  [2]   [2]


    private static int calcRow(int move) {

        return 2 - (move - 1)/3;
    }

    private static int getMoveFromPlayer(int[][] board) {
        Scanner scn = new Scanner(System.in);

        int playerMove = Integer.MIN_VALUE;

        boolean valid = false;

        while( !valid ){

            printBoard( board );

            System.out.print( "Please enter your move (keypad): ");

            playerMove = scn.nextInt();

            if( playerMove >= 1 && playerMove <= 9 ) {
                int row = calcRow(playerMove);
                int col = calcCol(playerMove);

                if (board[row][col] == 0) {
                    valid = true;
                }
            }
        }

        return playerMove;
    }

    public static boolean hasWinner( int[][] boardToCheck ){
        boolean winner = false;

        //checking rows
        for( int row = 0; row < 3; row++){
            int sum = 0;

            for( int col = 0; col < 3; col++){
                sum += boardToCheck[row][col];
            }

            //square the sum, 9 means we got 3 or -3 which means 3 marks in a row
            sum *= sum;

            if( sum == 9 ){
                winner = true;
            }
        }

        //checking columns
        for( int col = 0; col < 3; col++ ){
            int sum = 0;

            for( int row = 0; row < 3; row++){
                sum += boardToCheck[row][col];
            }

            sum *= sum;

            if( sum == 9 ){
                winner = true;
            }
        }

        int diag1Sum = boardToCheck[0][0] + boardToCheck[1][1] + boardToCheck[2][2];
        diag1Sum *= diag1Sum;

        int diag2Sum = boardToCheck[2][0] + boardToCheck[1][1] + boardToCheck[0][2];
        diag2Sum *= diag2Sum;

        if( diag1Sum == 9 || diag2Sum == 9 ){
            winner = true;
        }

        return winner;

    }

    private static boolean allSquaresFilled( int[][] boardToCheck ){

        boolean allFilled = true;

        for( int row = 0; row < 3; row++){
            for( int col = 0; col < 3; col++ ){
                if( boardToCheck[row][col] == 0 ){
                    allFilled = false;
                }
            }
        }



        return allFilled;
    }

    public static void printBoard( int[][] boardToPrint ){

        for( int row = 0; row < 3; row++){
            for( int col = 0; col < 3; col++ ){

                if( boardToPrint[row][col] == 0){
                    System.out.print(".");
                } else {
                    //ternary operator
                    //                boolean condition     true val  false val

                    String toPrint = boardToPrint[row][col] == 1 ? "X" : "O";
                    System.out.print( toPrint );


                    /*
                    if(boardToPrint[row][col] == 1){
                        toPrint = "X";


                    }else{

                     toPrint = "0";

                    }

                     */
                }

            }
            System.out.println();
        }
    }

}
