import java.util.Scanner;

public class Exercise05 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Musician[] musicians = new Musician[5];
        musicians[0] = new Musician("Frank Ocean", 10);

        for(int i = 0; i < musicians.length; i++) {
            System.out.println("Musician: ");
            String input1 = console.nextLine();
            System.out.println("Rating: ");
            int input2 = Integer.parseInt(console.nextLine());
            System.out.println(input1 + " " + input2);
            musicians[i] = new Musician(input1, input2);


        }
        for (int j = 0; j < musicians.length; j++) {
            System.out.println(musicians[j]);
        }

        // 1. Use a loop to populate the `musicians` array with your top 5 favorite musicians.
        // (Replace Frank Ocean.)
        // Create musicians from user input. (See Exercise04.)

        // 2. Use a second loop to print details about each musician.
    }
}
