package learn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws ParseException{ // main method should NEVER have throws
        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter a number");

        Number number = readInteger(scn.nextLine());


        int numberTwo = 7;
        // passed to another method and changed numberTwo



        if(numberTwo < 0) {
            IllegalArgumentException ex = new IllegalArgumentException("number is negative");
        
            throw ex;
        }

//        FileReader reader = null;
//        String value = null;
//        int[] numbers = new int[0];
//        //NULLPOINTER EXCEPTION
//       // int lengthOfValue = value.length();
//        //System.out.println(lengthOfValue);
//
//
////        int element = numbers[1];
////        System.out.println(element);
//
//        // NumberFormatException
//
////        System.out.println(number);
//
//        //try-catch
//
//        try{
//            reader = new FileReader("file.txt");
//            System.out.println(reader.read());
//            int number = Integer.parseInt(value);
//            number = numbers[1];
//        } catch(FileNotFoundException ex){
//            System.out.println("Couldn't read from your file because it's not found.");
//        }catch(NumberFormatException exception){
//            System.out.println("Exception: " + exception);
//        }catch(ArrayIndexOutOfBoundsException exception){
//            System.out.println("Exception: " + exception);
//        }catch(RuntimeException ex){
//            System.out.println("Exception: " + ex);
//        }catch(Exception ex){
//            System.out.println("Exception: " + ex);
//        } catch(Throwable throwable){
//            System.out.println("This is a throwable");
//        }finally{
//            if(reader != null){
//                try{
//                    reader.close();
//                }catch(Exception ex){
//                    System.out.println("Failed to close reader.");
//                }
//            }
//        }

    }

    private static Number readInteger(String message)  throws ParseException{
        NumberFormat formatter = NumberFormat.getInstance();
//        try{
//            return formatter.parse(message);
//        }catch(ParseException ex){
//            System.out.println("Exception: " + ex);
//            return null;
//        }
        return formatter.parse(message);
    }
}
