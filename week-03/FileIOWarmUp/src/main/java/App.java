import java.io.*;

public class App {

    public static void main(String[] args) {
        File secret = newFileCreation("secretMessage.txt");

        writeToFile();

        readFromFile("secretMessage.txt");

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



    private static void readFromFile(String fileName) {
        System.out.println("File " + fileName + " Contents:");

        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
                System.out.println(line);
            }
        }catch(IOException exception){
            System.out.println("Exception: " + exception);
        }
    }

}
