import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class App {

    public static void main(String[] args) {
        File secret = newFileCreation("secretMessage.txt");

        writeToFile();

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


    private static void writeToFile(){
        PrintWriter writer = null;

        try{
            writer = new PrintWriter("secretMessage.txt");
            writer.println("This is a secret message.");
            writer.println("Don't tell anyone about this message.");
            writer.println("This message will self-destruct in 10 seconds.");
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
