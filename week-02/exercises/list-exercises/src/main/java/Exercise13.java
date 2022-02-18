import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise13 {

    private ArrayList<BoardGame> games = GameRepository.getAll();
    private Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        Exercise13 instance = new Exercise13();
        instance.run();
    }

    private void printHeader(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println("=".repeat(message.length()));
    }

    private void addGame(){
        System.out.println("Add a board game.");
        Scanner gameAddition = new Scanner(System.in);
        String pick = gameAddition.nextLine();
        System.out.println("Min. Players: ");
        int pick1 = gameAddition.nextInt();
        System.out.println("Max. Players: ");
        int pick2 = gameAddition.nextInt();
        System.out.println("Category: ");
        String pick3 = gameAddition.nextLine();
        games.add(new BoardGame(pick, pick1, pick2, pick3));
    }


    private void displayGames(){
        System.out.println(games);
    }

    private void removeGames(){
        System.out.println("Remove a board game.");
        Scanner gameRemoval = new Scanner(System.in);
        int remove = gameRemoval.nextInt();
        games.remove(remove);
    }

    private void run() {

        printHeader("Welcome to the Board Game Manager.");

        String input;
        do {
            printHeader("Menu");
            System.out.println("1. Add a board game.");
            System.out.println("2. Display all board games.");
            System.out.println("3. Remove a board game.");
            System.out.println("4. Exit");
            System.out.print("Select [1-4]: ");
            input = console.nextLine();

            switch (input) {
                case "1":
                    // 1. Create a method that gathers user input via `console` to instantiate a BoardGame
                    // and then adds it to the `games` list.
                    // 2. Replace the the line of code below with a call to the method.
                    addGame();
                    break;
                case "2":
                    // 3. Create a method to display all board games in the `games` list.
                    // 4. Replace the the line of code below with a call to the method.
                    displayGames();
                    break;
                case "3":
                    // 5. Stretch Goal: Create a method that allows the user to remove a board game from the
                    // `games` list with an index.
                    // 6. Replace the the line of code below with a call to the method.
                    removeGames();
                    break;
                case "4":
                    printHeader("Goodbye.");
                    break;
                default:
                    System.out.printf("%nI don't understand '%s'.%n", input);
                    break;
            }
        } while (!input.equals("4"));
    }
}
