//import java.util.Scanner;
//
//public class Exercise10 {
//
//    public static void main(String[] args) {
//        // BALLOON GAME
//        Scanner console = new Scanner(System.in);
//
//        // 1. Instantiate three balloons of different colors.
//
//        Balloon a = new Balloon("red");
//        Balloon b = new Balloon("blue");
//        Balloon c = new Balloon("green");
//
//        do {
//
//            System.out.println("Inflate? [y/n]: ");
//            if (console.nextLine().equalsIgnoreCase("y")) {
//                // 2. If the user confirms an inflate, inflate each balloon.
//                Balloon.inflate();
//            }
//
//            // 3. When one or more balloons explode, stop the loop.
//        } while (Balloon.isExploded() == false);
//
//        // 4. Print the color of the winners (balloons that exploded).
//    }
//}
