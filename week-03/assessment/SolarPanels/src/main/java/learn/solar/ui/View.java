package learn.solar.ui;

import learn.solar.models.Material;

import java.util.Scanner;

public class View {

    private Scanner console = new Scanner(System.in);

//    public String readSection(){
//
//    }

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

//    private Material readMaterial(){
//
//    }


/*
    Create `View`
            *- add `Scanner` field
    *- create read* methods: `readString`, `readRequiredString`, `readInt`, `readInt` (with min/max)
 */
}
