package Library.UI;

import java.util.Scanner;

public class TextIO {

    Scanner scn = new Scanner(System.in);

     public void print(String toPrint){
         System.out.print(toPrint);
    }

    public String readString(String prompt){
        print(prompt);
        return scn.nextLine();
    }

//    editString(String prompt, String oldValue){
//
//    }
//
    public int readInt(String prompt){
         int toReturn = Integer.MIN_VALUE;
         boolean valid = false;
         while(!valid) {
           String userInput = readString(prompt);
             //call readString()
             //parse string as integer
             try {
                 toReturn = Integer.parseInt(userInput);
                 //if we get to this line
                 // that means parseInt didn't throw exception
                 valid = true;
             }catch(NumberFormatException ex){
                 //options:
                 // do nothing, loop will just reprint prompt,
                 // print error message and loop continues
             }
         }
         return toReturn;
     }

    public int readInt(String prompt, int min, int max){
         int input = Integer.MIN_VALUE;
        boolean valid = false;

            while(!valid){
                input = readInt(prompt);
                valid = input <= max && input >= min;

            }
            return input;
    }

//    editInt(String prompt, int oldValue){
//
//    }
//
//    editInt(String prompt, int oldValue, int min, int max){
//
//    }


}
