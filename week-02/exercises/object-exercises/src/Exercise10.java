import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // BALLOON GAME
        Scanner console = new Scanner(System.in);

        // 1. Instantiate three balloons of different colors.

        Balloon a = new Balloon("red");
        Balloon b = new Balloon("blue");
        Balloon c = new Balloon("green");

        do {

            System.out.println("Inflate? [y/n]: ");
            if (console.nextLine().equalsIgnoreCase("y")) {
                // 2. If the user confirms an inflate, inflate each balloon.
                a.inflate();
                b.inflate();
                c.inflate();
            }

            // 3. When one or more balloons explode, stop the loop.
        } while (!a.isExploded() && !b.isExploded() && !c.isExploded());

        // 4. Print the color of the winners (balloons that exploded).

        if(a.isExploded()){
            System.out.println("Balloon a has won! It's color was " + a.getColor());
        }if(b.isExploded()){
            System.out.println("Balloon b has won! It's color was " + b.getColor());
        }if(c.isExploded()){
            System.out.println("Balloon c has won! It's color was " + c.getColor());
        }
    }
}
