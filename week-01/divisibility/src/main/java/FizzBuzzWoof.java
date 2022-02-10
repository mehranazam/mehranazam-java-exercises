import java.util.Scanner;

public class FizzBuzzWoof {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pick a number between 2 and 500: ");
        int result = input.nextInt();

        if(result < 2 || result > 500){
            System.out.println("Number out of range. Pick again.");
            result = input.nextInt();
        }

        for(int i = 1; i <= result; i++){
            if(i % 3 == 0){
                System.out.print("Fizz");
            }else if(i % 5 == 0){
                System.out.print("Buzz");
            }else if(i % 7 == 0) {
                System.out.print("Woof");
            }else{
                System.out.print(i);
            } if(i % 5 == 0 && i % 3 == 0){
                System.out.print("FizzBuzz");
            } if(i % 3 == 0 && i % 7 == 0){
                System.out.print("FizzWoof");
            } if(i % 5 == 0 && i % 7 == 0){
                System.out.print("BuzzWoof");
            }if(i % 5 == 0 && i % 7 == 0 && i % 3 == 0){
                System.out.print("FizzBuzzWoof");
            }
            if(i < result) {
                System.out.print(", ");
            }else{
                System.out.print("");
            }
        }
    }
}
