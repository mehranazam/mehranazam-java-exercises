package learn.solar.ui;

import learn.solar.models.Material;

import java.util.Scanner;

public class View {

    private final Scanner console = new Scanner(System.in);

    public String readSection(){

    }

    public int chooseOptionFromMenu(){
        printHeader("Main menu");

        System.out.print("0. Exit\n");
        System.out.print("1. Find Panels by Section\n");
        System.out.print("2. Add a panel\n");
        System.out.print("3. Update a Panel\n");
        System.out.print("4. Remove a Panel\n");
        System.out.print("Select [0-4]: \n");

        return readInt("Please enter your selection: ", 0, 4);
    }

    public void printHeader(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println("=".repeat(message.length()));
    }



    private String readString(String message){
        System.out.print(message);
        return console.nextLine();
    }

    private String readRequiredString(String message){
       String result;
       do{
           result = readString(message);
           if(result.trim().length() == 0){
               System.out.println("Value is required.");
           }
       }while(result.trim().length() == 0);
       return result;
    }

    private int readInt(String message){
        String input = null;
        int result = 0;
        boolean isValid = false;
        do{
            try{
                input = readRequiredString(message);
                result = Integer.parseInt(input);
                isValid = true;
            }catch(NumberFormatException ex){
                System.out.printf("%s is not a valid number,%n", input);
            }
        }while(!isValid);

        return result;
    }

    private int readInt(String message, int min, int max){
        int result;
        do{
            result = readInt(message);
            if(result < min || result > max){
                System.out.printf("Value must be between %s and %s.%n", min, max);
            }
        }while(result < min || result > max);

        return result;
    }

    private Material readMaterial(){
        int index = 1;
        for(Material material : Material.values()){
            System.out.printf("%s. %s%n", index++, material);
        }
        index--;
        String message = String.format("Select Material [1-%s]: ", index);
        return Material.values()[readInt(message, 1, index) - 1];
    }


/*
    Create `View`
            *- add `Scanner` field
    *- create read* methods: `readString`, `readRequiredString`, `readInt`, `readInt` (with min/max)
 */
}
