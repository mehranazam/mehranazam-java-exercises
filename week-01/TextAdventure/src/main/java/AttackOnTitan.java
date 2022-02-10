import java.util.Scanner;

public class AttackOnTitan {

    public static void main(String[] args) {
        System.out.println("The Titans have broken the Wall!");
        String location1 = "Jaeger House";
        String location2 = "Town Square";
        String location3 = "Garrison";

        String character1 = "Eren";
        String character2 = "Mikasa";
        String character3 = "Armin";

        String action1 = "Help Carla";
        String action2 = "Run away";

        String action3 = "Run into the trio";
        String action4 = "Run to the inner wall";

        String item1 = "rock";

        Scanner scn = new Scanner(System.in);

        System.out.println("Choose a location: (Jaeger House, Town Square, Garrison) ");
        String locInput = scn.nextLine();

        boolean endingReached = false;
        while(!endingReached){

                String input = null;

            switch(locInput){
                case "Jaegar House":
                System.out.println("A boulder from the Colossal Titan's kick lands on Jaeger House, pinning Carla (Eren's mom) to the ground.");

                System.out.println("What should you do next? (Help Carla or Run away)");
                input = scn.nextLine();

                if(input.equals(action1)){
                    System.out.println("You try to help Carla, but the weight of the boulder is too much.");
                    System.out.println("The trio run towards the boulder and with all their might combined, you successfully push the boulder off her.");
                    System.out.println("Everyone reaches the lifeboats and sails towards the inner wall.");
                    System.out.println("You, Eren, Mikasa, Armin, and Carla live to fight another day. But Eren's father is still missing. To be continued...");
                    endingReached = true;
                }else if(input.equals(action2)){
                    System.out.println("You eventually get eaten by a Titan. Game over :)");
                    endingReached = true;
                }
                break;
                case "Town Square":
                System.out.println("You are severely injured, and need to find shelter quickly.");
                    System.out.println("What should you do next? (Run into the trio or Run to the inner wall)");
                    input = scn.nextLine();

                    if(input.equals(action3)){
                        System.out.println("Run back to Jaegar House with the trio.");
                        locInput = location1;

//                        input = scn.nextLine();
                        break;
                    }else if(input.equals(action4)){
                        System.out.println("You make a run for the inner wall, but are eaten by one of the Titans");
                        endingReached = true;
                        break;
                    }
                    break;
                case "Garrison":
                System.out.println("The Colossal Titan has crushed you.");
                endingReached = true;
                break;
                default:
                System.out.println("Pick a different location.");
                locInput = scn.nextLine();
                break;
                }
        }


    }
}
