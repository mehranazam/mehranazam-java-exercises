import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {
        File file = newFileCreation("new-elements-file.txt");

//
       // writeToFile("elements.data");
      //  newFileCreation("super-bad-file.java");
//        badFile();
//        if(deleteFile(file)) {
//            System.out.println("File has been deleted");
//        }else{
//            System.out.println("File hasn't been deleted.");
//        }

//        newFileCreation();
    }


    private static boolean deleteFile(File fileName){
        boolean result = fileName.delete();
        return result;

    }

    private static void writeToFile(File fileName) {

        PrintWriter writer = null;

        try{
            writer = new PrintWriter("elements.data");
            writer.println("hydrogen");
            writer.println("helium");
            writer.println("lithium");
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex2){
           // System.out.println("[Error]: " + ex2);
            ex2.printStackTrace();
        }catch(Exception ex3){
            ex3.printStackTrace();
        }
        finally{
            if(writer != null){
                writer.close();
            }
        }


    }
    private static File newFileCreation(String fileName){
        File file = new File(fileName);
        try{
            if (file.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }catch(IOException ex2){
            // System.out.println("[Error]: " + ex2);
            System.out.println(ex2);
        }catch(Exception ex3){
            ex3.printStackTrace();
        }
        return file;

    }

    private static void badFile(){
        PrintWriter writer = null;

        try{
            writer = new PrintWriter("bad-file.txt");
            writer.println("Oh, wow.");
            writer.println("This is a bad file");
            writer.println("It should be deleted.");
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex2){
            // System.out.println("[Error]: " + ex2);
            ex2.printStackTrace();
        }catch(Exception ex3){
            ex3.printStackTrace();
        }
        finally{
            if(writer != null){
                writer.close();
            }
        }
    }

}
