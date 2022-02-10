import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Choose a starting value: ");
        int start = scn.nextInt();

        System.out.println("Choose an ending value: ");
        int end = scn.nextInt();

        System.out.println("Choose an increment: ");
        int increment = scn.nextInt();

        int sum = 0;

        for(int i = start; i <= end; i += increment){

            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
