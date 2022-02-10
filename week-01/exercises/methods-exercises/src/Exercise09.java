import java.util.Scanner;

public class Exercise09 {

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        Scanner scn = new Scanner(System.in);

        System.out.println("How many rows: ");
        int r = scn.nextInt();

        System.out.println("How many columns: ");
        int c = scn.nextInt();
        printBox(r, c);
    }



    public static void printBox (int row, int column){



        System.out.println("(" + row + "x" + column + ")");


        for(int r = 0; r < row; r++){
            for(int c = 0; c < column - 1; c++){
                System.out.print("#");
            }
            System.out.println("#");
        }
    }

    // 1. Create a method.
    // Name: printBox
    // Inputs: int, int
    // Output: void
    // Description: prints a visual box to the console. The first parameter is the number of rows to print.
    // The second parameter is the number of columns.
    // See repetition Exercise15.

    // Expected Output (5 rows, 5 columns)
    // #####
    // #####
    // #####
    // #####
    // #####

    // (3 rows, 4 columns)
    // ####
    // ####
    // ####
}
