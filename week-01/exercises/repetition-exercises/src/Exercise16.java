import java.util.Scanner;

public class Exercise16 {

    public static void main(String[] args) {
        // BORDER BOX
        // 1. Use nested loops to print a box in the console with a different character for the border.
        // One loop should represent rows and the other should represent columns.
        // The border character should be different from the internal box character.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // *****
        // *###*
        // *###*
        // *###*
        // *****

        // (3X4)
        // ****
        // *##*
        // ****

        // (2X2)
        // **
        // **

        Scanner scn = new Scanner(System.in);

        System.out.println("How many rows: ");
        int row = scn.nextInt();

        System.out.println("How many columns: ");
        int column = scn.nextInt();


        System.out.println("(" + row + "x" + column + ")");


        for(int r = 0; r < row; r++){
            for(int c = 0; c < column - 1; c++){
                if(r == 0 || r == row){
                    System.out.print("*");
                }else {
                    System.out.print("#");
                }
            }
            if(r == row){
                System.out.print("*");
            }else {
                System.out.println("#");
            }
        }
    }
}
