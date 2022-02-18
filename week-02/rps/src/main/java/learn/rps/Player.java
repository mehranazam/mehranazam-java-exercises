package learn.rps;

import java.util.Scanner;

public class Player implements GamePlayer{

private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    @Override
    public int move() {
        System.out.println("Please enter your choice: ");
        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();
        return choice;
    }

    /*
    human player
    computer player
     */

}

