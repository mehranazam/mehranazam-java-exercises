import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {

//        1. Add a class, `Exercise09`, to this project.
//        2. Add a `main` method.
//        3. Declare a `Scanner` variable.
//        4. Collect three pieces of data from the user: a minimum value, a maximum value, and an actual value.
//        5. Add `if/else` statements to determine if the actual value is between the min and max.
//        6. Print messages for both true and false cases.
        Scanner scn = new Scanner(System.in);

        System.out.println("Pick a minimum value");
        int min = scn.nextInt();

        System.out.println("Pick a maximum value");
        int max = scn.nextInt();

        System.out.println("Pick an actual value");
        int actual = scn.nextInt();

        if(actual >= min && actual <= max){
            System.out.println("Your actual number is between the minimum and maximum value.");
        }else{
            System.out.println("Your actual number is NOT between the minimum and maximum value.");
        }
    }
}
